layui.use(['element','form'], function(){
    var element = layui.element;
    var form = layui.form;
    // +----------------------------------------------------------------------
    // | 弹出层
    // +----------------------------------------------------------------------
    $(".dw-dailog").click(function(){
      var dw_url = $(this).attr("dw-url");//URL地址，必填
      var dw_title = $(this).attr("dw-title");//弹出层标题，必填
      var dw_width = $(this).attr("dw-width");//弹出层宽度，如80%或500px；如果没有默认为屏幕宽度的50%
      var dw_height = $(this).attr("dw-height");//弹出层高度，如50%或500px；如果没有默认为屏幕高度的50%
      if(dw_url == undefined) {
        layer.msg("请给button加上dw-url属性");
        return false;
      }
      if(dw_title == undefined) {
        layer.msg("请给button加上dw-title属性");
        return false;
      }
      if(dw_width == undefined) dw_width = '50%';
      if(dw_height == undefined) dw_height = '50%';
      layer.open({
        type: 2,
        title: dw_title,
        shadeClose: true,
        shade: 0.8,
        area: [dw_width, dw_height],
        content: dw_url,
        cancel: function (index, layero) {
          $(".dw-refresh").trigger('click');
          return false;
        }    
      }); 
    });
    // +----------------------------------------------------------------------
    // | 刷新
    // +----------------------------------------------------------------------
    $(".dw-refresh").click(function(){
      location.href = location.href;
    });
    // +----------------------------------------------------------------------
    // | 监听提交
    // +----------------------------------------------------------------------
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
});