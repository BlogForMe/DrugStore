;(function () {
    touch.on('#receive-btn', 'tap doubletap', function () {
        document.querySelector('.cover-wrap').style.display = 'block';
    });

    touch.on('#close', 'tap doubletap', function (){
        document.querySelector('.cover-wrap').style.display = 'none';
    })

    touch.on('#jup', 'tap doubletap', function () {
        jup();
    })
    function jup() {
        Android.jup();
    }
})();