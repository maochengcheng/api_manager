/**
 * 权限管理
 */
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#secretSecureList',
            url:'/secure/getSecretSecureList',
            method: 'post', //默认：get请求
          //  cellMinWidth: 80,
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
                ,{field:'userKey', title:'唯一编码',align:'center'}
                ,{field:'jsbh', title:'监所编号',align:'center'}
                ,{field:'level', title:'等级',align:'center'}
                ,{field:'createTime', title: '注册时间',align:'center',templet: function(d){
                        return layui.util.toDateString(d.createTime,'yyyy-MM-dd HH:mm:ss');
                    }}
                ,{field:'interfacePermissionsName', title: '接口模块权限',align:'center'}
                ,{field:'status', title: '是否有效',align:'center'}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度


                $("[data-field='status']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("有效")
                    }else if($(this).text()=='0'){
                        $(this).text("失效")
                    }
                });
                //得到数据总量

                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(secretSecureTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delSecretSecure(data,data.id,data.userkey);
            } else if(obj.event === 'edit'){
                //编辑
                openSecretSecure(data,"编辑");
            }else if(obj.event === 'recover'){
                //恢复
                recoverSecretSecure(data,data.id);
            }
        });

        //监听提交
        form.on('submit(secretSubmit)', function(data){
            // TODO 校验
            secretFormSubmit(data);
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
        form.on('submit(searchSecureSubmit)', function(data){
            //重新加载table
            secretLoad(data);
            return false;
        });
    });
});

//提交表单
function secretFormSubmit(obj){
    console.log($("#secretSecureForm").serialize());

    $.ajax({
        type: "POST",
        data: $("#secretSecureForm").serialize(),
        url: "/secure/addSecretSercure",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                    secretLoad(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                secretLoad(obj);//自定义
            });
        }
    });
}

//开通用户
function addSecretSecure(){
    openSecretSecure(null,"新增权限码");
}
function openSecretSecure(data,title){
    var pid = null;
    if(data==null || data==""){
        $("#id").val("");
    }else{
        $("#id").val(data.id);
        $("#userKey").val(data.userKey);
        $("#jsbh").val(data.jsbh);
        $("#status").val(data.status);
        $("#level").val(data.level);
        pid = data.interfacePermissions;
    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);

    formSelects.data('interfacePermissions', 'server', {
        url: '/base/getInterfaceModuleList',
        keyName: 'moduleName',
        keyVal: 'moduleCode',
        success: function(id, url, searchVal, result){      //使用远程方式的success回调
            //console.log(pid)
            if(pid != null){
                var assistAuditArry =pid.split(",");
                formSelects.value('interfacePermissions', assistAuditArry);
            }

        //    console.log(result);    //返回的结果
        },
        error: function(id, url, searchVal, err){           //使用远程方式的error回调
                                                            //同上
       //     console.log(err);   //err对象
        },
    });

    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['600px','600px'],
        content:$('#setSecretSecure'),
        end:function(){
            cleanUser();
        }
    });
}

function synchSecretSecure(){

    $.ajax({
        type: "POST",
        data: $("#secretSecureForm").serialize(),
        url: "/secure/synchSecretSecure",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                secretLoad(obj);//自定义
            });
        }
    });

}

function delSecretSecure(obj,id,name) {

    if(null!=id){
            layer.confirm('您确定要删除'+name+'用户吗？', {
                btn: ['确认','返回'] //按钮
            }, function(){
                $.post("/secure/updateSecretSecureStatus",{"id":id,"status":0},function(data){
                    if (data.code == 1) {
                        layer.alert(data.msg,function(){
                            layer.closeAll();
                            secretLoad(obj);
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
//恢复
function recoverSecretSecure(obj,id) {
    if(null!=id){
        layer.confirm('您确定要恢复吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/secure/updateSecretSecureStatus",{"id":id,"status":1},function(data){
                if (data.code == 1) {
                    layer.alert(data.msg,function(){
                        layer.closeAll();
                        secretLoad(obj);
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

function secretLoad(obj){
    console.log("查询："+obj);
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanUser(){
    $("#userKey").val("");
    $("#jsbh").val("");
    $("#level").val("");
    $("#interfacePermissions").val("");
}
