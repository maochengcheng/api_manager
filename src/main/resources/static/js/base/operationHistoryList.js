/**
 * 用户管理
 */
var pageCurr;
var form;

$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#interfaceOperationHistory',
            url:'/base/getInterfaceOperationHistoryList',
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
                ,{field:'userName', title:'调用人',align:'center'}
                ,{field:'jsbh', title:'监所编号',align:'center'}
                ,{field:'zybh', title:'作业编号',align:'center'}
                ,{field:'paramKey', title:'业务接口主键',align:'center'}
                ,{field:'methodName', title:'接口名',align:'center'}
                ,{field:'args', title:'传参',align:'center'}
                ,{field:'message', title:'返回',align:'center'}
                ,{field:'createTime', title: '调用时间',align:'center',templet: function(d){
                    return layui.util.toDateString(d.createTime,'yyyy-MM-dd HH:mm:ss');
                    }}
                ,{field:'responseTime', title: '响应时间',align:'center'}
                ,{field:'addressUrl', title: 'addressUrl',align:'center'}
                ,{field:'code', title: '是否成功',align:'center'}
                ,{field:'userKey', title:'权限码',align:'center'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
                $("[data-field='code']").children().each(function(){
                    if($(this).text()=='200'){
                        $(this).text("成功")
                    }else if($(this).text()!='200'){
                        $(this).text("失败")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
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
    });
});



function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

