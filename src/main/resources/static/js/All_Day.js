//デフォルトで表示するもの
$(function(){
    var getmonth = new Date().getMonth()+1;
    $('#month').html(getmonth);
});


$(function(){
    $('#button1').click(function(){
        $(".list1").toggle();
    });
});
$(function(){
    $('#button2').click(function(){
        $(".list2").toggle();
    });
});
//送信ボタンを押したら、記録されるようにする

