layui.use(['layer','form'], function(){
    var form = layui.form;
    var layer = layui.layer;

    //监听提交
    form.on('submit(formDemo)', function (data) {
        var action = data.form.action;//表单提交URL地址
        console.log(JSON.stringify(data.field));//表单数据
        $.post(action, data.field, function (obj) {
            //根据返回结果作出相应处理
        });
        //return false;//注释掉这行代码后，表单将会以普通方式提交表单，否则以ajax方式提交表单
    });
});