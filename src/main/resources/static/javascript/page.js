layui.use( 'laypage', function(){
    var laypage = layui.laypage;
    //当前页
    var currentPage = [[${currentPage}]];
    //总页数
    var totalPage=[[${totalPage}]]

    //分页
    laypage.render({
        elem: 'pageDemo' //分页容器的id
        ,count: totalPage //从后台传过来的总页数
        ,skin: '#1E9FFF' //自定义选中色值
        ,limit: 2
        ,curr:currentPage    //从后台传过来的当前页数
        ,jump: function(obj, first){
            if(!first){
                //重定向到分页查询的接口
                window.location.href = '/employee/emps/?currentPage='+obj.curr+'&limit='+obj.limit;
            }
        }
    });

});
