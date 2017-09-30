;(function () {
    var times = null,
        isSned = true; // 防止重复点击发送验证码
        isRegister = true; // 防止重复点击注册

    touch.on('#scode', 'tap doubletap', function () { // 点击发送短信验证码
        var phone = $('input[name=tel]').val(),
            imgCode = $('input[name=imgScode]').val(),
            obj = $('#scode'),
            layers = null;

        if(!/^(13|14|15|17|18)[0-9]{9}$/.test(phone)) return layer.open({content: '请输入正确手机号码', skin: 'msg', time: 2});
        if(imgCode.length == 0) return layer.open({content: '请输入图片验证码', skin: 'msg', time: 2});
        if(!isSned) return; // 防止重复点击
        isSned = false;
        layers = layer.open({type: 2, shadeClose: false, content: '验证法发送中'});

        countTime($('#scode'));
        $.ajax({
            url: '',
            type: 'POST',
            data: {phone: phone, code: imgCode},
            dataType: 'json',
            success: function (data) {
                isSned = true;
                layer.close(layers);
                clearInterval(times);
                obj.removeClass('sendCode').text('获取验证码');

                if(data.statu == 0) return layer.open({content: '图片验证码错误',btn: '确定'});
                if(data.statu == 1) return layer.open({content: '验证码发送成功', btn: '确定'});
                if(data.statu == 2) return layer.open({content: '手机号码已被注册',btn: '确定'});
            }
        })
    });

    function countTime (obj) { // 倒计时
        var count = 60;

        obj.addClass('sendCode').text(count + 's');

        times = setInterval(function(){
            count--;

            if (count > 0) {
                obj.text(count + 's');
            }else{
                clearInterval(times);
                obj.removeClass('sendCode').text('获取验证码');
            }
        }, 1000);
    }

    touch.on('#register-btn', 'tap doubletap', function () { // 注册
        var phone = $('input[name=tel]').val(),
            scode = $('input[name=scode]').val(),
            pwd = $('input[name=pwd]').val(),
            layers = null;

        if(!/^(13|14|15|17|18)[0-9]{9}$/.test(phone)) return layer.open({content: '请输入正确手机号码', skin: 'msg', time: 2});
        if(scode.length == 0) return layer.open({content: '请输入短信验证码', skin: 'msg', time: 2});
        if(pwd.length == 0) return layer.open({content:'请输入密码', skin: 'msg', time: 2});
        if(!isRegister) return; // 防止重复点击
        isRegister = false;
        layers = layer.open({type: 2, shadeClose: false, content: '注册中'});

        $.ajax({
            url: '',
            type: 'POST',
            data: {phone: phone, code: scode, pwd: pwd},
            dataType: 'json',
            success: function(data){
                isRegister = true;
                layer.close(layers);

                if(data.statu == 0) return layer.open({content: '验证码错误',btn: '确定'});
            }
        })
    });
})();