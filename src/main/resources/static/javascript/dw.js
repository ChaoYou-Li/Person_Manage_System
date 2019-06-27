// +----------------------------------------------------------------------
// | 列表页通用引用文件（如有特殊需求可参照此文件写一个单独的js文件,如:sys_config.js）
// +----------------------------------------------------------------------
layui.use(['element', 'layer'], function () {
  var element = layui.element;
  var layer = layui.layer;
  var $ = layui.jquery;
  // +----------------------------------------------------------------------
  // | icheck
  // +----------------------------------------------------------------------
  $('input').iCheck({
    checkboxClass: 'icheckbox_minimal-red',
    radioClass: 'iradio_minimal-red',
    increaseArea: '20%' // optional
  });//checkbox美化
  $('.selectAll input').on('ifChecked', function (event) {
    $('input').iCheck('check');
  });//全选
  $('.selectAll input').on('ifUnchecked', function (event) {
    $('input').iCheck('uncheck');
  });//反选
  // +----------------------------------------------------------------------
  // | 弹出层
  // +----------------------------------------------------------------------
  $(".dw-dailog").click(function () {
    var dw_url = $(this).attr("dw-url");//URL地址，必填
    var dw_title = $(this).attr("dw-title");//弹出层标题，必填
    var dw_width = $(this).attr("dw-width");//弹出层宽度，如80%或500px；如果没有默认为屏幕宽度的50%
    var dw_height = $(this).attr("dw-height");//弹出层高度，如50%或500px；如果没有默认为屏幕高度的50%
    if (dw_url == undefined) {
      layer.msg("请给button加上dw-url属性");
      return false;
    }
    if (dw_title == undefined) {
      layer.msg("请给button加上dw-title属性");
      return false;
    }
    if (dw_width == undefined) dw_width = '50%';
    if (dw_height == undefined) dw_height = '50%';
    layer.open({
      type: 2,
      title: dw_title,
      shadeClose: true,
      shade: 0.8,
      area: [dw_width, dw_height],
      content: dw_url,
      cancel: function (index, layero) {
        $(".dw-refresh").trigger('click');
        location.reload();
        return false;
      }
    });
  });
  // +----------------------------------------------------------------------
  // | 批量删除
  // +----------------------------------------------------------------------
 $(".dw-batch-delete").click(function () {
    var dw_url = $(this).attr("dw-url");//URL地址，必填
    //获取checkbox[name='like']的值
    var arr = new Array();
    if (dw_url == undefined) {
      layer.msg("请给button加上dw-url属性");
      return false;
    }
    var chk_value = [];
    $('input[name="empId"]:checked').each(function () {
      chk_value.push($(this).val());
    if (chk_value.length == 0) {

      layer.msg("请选择要删除的数据!", { anim: 1 });
      return false;
    }
    layer.confirm('确定要删除选中['+chk_value+']的数据吗?', { icon: 3, title: '提示' }, function (index) {
      $.ajax({
        url: dw_url+'data_id='+chk_value,
        type: 'DELETE',
        success: function(result) {
          alert("删除成功");
          location.reload();
        }
      });
        layer.close(index);
    });
  });
  // +----------------------------------------------------------------------
  // | 删除
  // +----------------------------------------------------------------------
   $(".dw-delete").click(function () {
     var dw_url = $(this).attr("dw-url");//URL地址，必填
     if (dw_url == undefined) {
       layer.msg("请给button加上dw-url属性");
       return false;
     }
     layer.confirm('确定要删除选中['+chk_value+']的数据吗?', { icon: 3, title: '提示' }, function (index) {
       $.ajax({
         url: dw_url,
         type: 'DELETE',
         success: function(result) {
           alert("删除成功");
           location.reload();
         }
       });

       layer.close(index);
     });
   });
  });
  // +----------------------------------------------------------------------
  // | 刷新
  // +----------------------------------------------------------------------
  $(".dw-refresh").click(function () {
    var dw_url = $(this).attr("dw-url");//URL地址，必填
    if (dw_url == undefined) {
      layer.msg("请给button加上dw-url属性");
      return false;
    }
    location.href = location.href=dw_url;
  });
});





layui.use('table',function () {
  var table = layui.table;
  $(".dw-delete").click(function () {
    var dw_url = $(this).attr("dw-url");//URL地址，必填
    var dw_title = $(this).attr("dw-title");//删除数据标识，如姓名，默认为'该数据'
    if (dw_url == undefined) {
      layer.msg("请给button加上dw-url属性");
      return false;
    }
    if (dw_title == undefined) {
      dw_title = '该数据';
    }
  table.render({
    elem:'.layui-table',
    url:dw_url,
    page:true,
    id:'tableDemo',
  });
  }
  var $ = layui.$, active = {
    getCheckData: function () {
      var dw_url = $(this).attr("dw-url");//URL地址，必填
      var dw_title = $(this).attr("dw-title");//删除数据标识，如姓名，默认为'该数据'
      if (dw_url == undefined) {
        layer.msg("请给button加上dw-url属性");
        return false;
      }
      if (dw_title == undefined) {
        dw_title = '该数据';
      }
      var checkStatus = table.checkStatus('tableDemo'),data = checkStatus.data;
      if (data == ""){
        layer.msg("请选择要删除的数据!", { icon: 2 });
        return ;
      }
      var ids = "";
      if (data.length > 0){
        for (var i = 0; i < data.length; i++){
            ids += data[i] + ",";
        }
      }
      layer.confirm("确定要删除吗？", ids, function (index) {
        $.ajax({
          type:'DELETE',
          url: dw_url,
          data:{"data_id":ids},
          success: function () {
            alert("删除成功");
            location.reload();
          }
        })
      })
    }
  }

})