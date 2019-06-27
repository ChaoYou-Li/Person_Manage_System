// 文件上传的js
layui.use('upload', function() {
    var $ = layui.jquery
        , upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#uploadPic'
        , url: '/upload/pic'
        , done: function (res) {
            $('#pic').attr('src',res.data); //图片链接（base64）
            $('#empPic').attr('value', res.data); //填充隐藏的图片链接

        }
        , error: function () {
            //演示失败状态，并实现重传
            var picText = $('#picText');
            picText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            picText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });
});