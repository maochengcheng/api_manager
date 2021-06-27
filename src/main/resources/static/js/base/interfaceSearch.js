/**
 * 接口管理
 */
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#interfaceList',
            url:'/base/getInterfaceList',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            page: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：pageNum
                limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response:{
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type:'numbers'}
                ,{field:'moduleName', title:'模块',align:'center'}
                ,{field:'methodName', title:'接口名',align:'center'}
                ,{field:'paramKey', title:'业务接口主键',align:'center',weigh:200}
                ,{field:'descInfo', title:'接口描述',align:'center'}
                ,{field:'interfaceType', title:'接口类型',align:'center'}
                ,{field:'methodType', title:'方法类型',align:'center'}
                ,{field:'timeout', title: '超时时间',align:'center'}
                ,{field:'frequency', title: '访问次数',align:'center'}
                ,{field:'url', title: 'url',align:'center'}
                ,{field:'status', title: '是否有效',align:'center'}
                /*,{title:'操作',align:'center', toolbar:'#optBar'}*/
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
                $("[data-field='status']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("有效")
                    }else if($(this).text()=='0'){
                        $(this).text("失效")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(interfaceTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delInterface(data,data.id,data.methodName);
            } else if(obj.event === 'edit'){
                //编辑
                openInterface(data,"编辑");
            }else if(obj.event === 'recover'){
                //恢复
                recoverInterface(data,data.id);
            }
        });

        //监听提交
        form.on('submit(interfaceSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
        selectModule();
    });

    selectModule();

});

function selectModule(){
    form = layui.form;
    $.ajax({
        url:'/base/getInterfaceModuleList',
        dataType:'json',
        async: true,
        success:function(data){
            $.each(data,function(index,item){
                /*if(!moduleSearch){
                    var option = new Option(item.moduleName ,item.moduleCode);
                }else {
                    var option = new Option(item.moduleName ,item.moduleCode);
                    // 如果是之前的parentId则设置选中
                    if(item.moduleCode == moduleCode) {
                        option.setAttribute("selected",'true');
                    }
                }*/
                var option = new Option(item.moduleName ,item.moduleCode);
                $('#moduleSearch').append(option);//往下拉菜单里添加元素
                form.render('select'); //这个很重要
            })
        }
    });
}

//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: "/base/updateInterfaceInfo",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}
function openInterface(data,title){
    var moduleCode = null;
    if(data==null || data==""){
        $("#id").val("");
    }else{
        $("#id").val(data.id);
        $("#methodName").val(data.methodName);
        $("#timeout").val(data.timeout);
        $("#frequency").val(data.frequency);
        moduleCode = data.moduleCode;
    }

    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);
    $.ajax({
        url:'/base/getInterfaceModuleList',
        dataType:'json',
        async: true,
        success:function(data){
            $.each(data,function(index,item){
                if(!moduleCode){
                    var option = new Option(item.moduleName ,item.moduleCode);
                }else {
                    var option = new Option(item.moduleName ,item.moduleCode);
                     // 如果是之前的parentId则设置选中
                    if(item.moduleCode == moduleCode) {
                        option.setAttribute("selected",'true');
                    }
                }
                $('#moduleCode').append(option);//往下拉菜单里添加元素
                form.render('select'); //这个很重要
            })
        }
    });

    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['550px'],
        content:$('#setInterface'),
        end:function(){
            cleanInteface();
        }
    });
}

function delInterface(obj,id,methodName) {
    var currentUser=$("#currentUser").html();
    if(null!=id){
        if(currentUser==id){
            layer.alert("对不起，您不能执行删除自己的操作！");
        }else{
            layer.confirm('您确定要删除'+methodName+'接口吗？', {
                btn: ['确认','返回'] //按钮
            }, function(){
                $.post("/base/updateInterfaceStatus",{"id":id,"status":"0"},function(data){
                    if (data.code == 1) {
                        layer.alert(data.msg,function(){
                            layer.closeAll();
                            load(obj);
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                });
            }, function(){
                layer.closeAll();
            });
        }
    }
}
//恢复
function recoverInterface(obj,id) {
    if(null!=id){
        layer.confirm('您确定要恢复吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/base/updateInterfaceStatus",{"id":id,"status":"1"},function(data){
                if (data.code == 1) {
                    layer.alert(data.msg,function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanInteface(){
    $("#module").val("");
    $("#methodName").val("");
    $("#timeout").val("");
    $("#frequency").val("");
    $('#roleId').html("");
}
