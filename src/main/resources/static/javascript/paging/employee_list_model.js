/*
* 功能需求：为数据呈现的页面提供分页的js算法
* */
// layui.use( 'laypage', function(){
//     var laypage = layui.laypage;
//     //当前页-1（从0开始）
//     var currentPage = [[${currentPage}]];
//     //总页数
//     var totalPage=[[${totalPage}]]
//
//     //分页
//     laypage.render({
//         elem: 'pageDemo' //分页容器的id
//         ,count: totalPage //从后台传过来的总页数
//         ,skin: '#1E9FFF' //自定义选中色值
//         ,limit: 1
//         ,curr:currentPage    //从后台传过来的当前页数-1
//         ,jump: function(obj, first){
//             if(!first){
//                 //重定向到分页查询的接口
//
//                 window.location.href = '/employee/emps/?currentPage='+obj.curr+'&limit='+obj.limit;
//             }
//         }
//     });
//
// });