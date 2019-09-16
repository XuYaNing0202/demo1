function logIn(){
    $("#logInFormButton").click(function(){
        $.post({
            url:"/user/userLogIn",
            data:{"account":$("input[name=account]").val(),"password":$("input[name=password]").val()},
            success:function(data){
                if (data){
                    window.location.href="show";
                }else{
                    alert("用户名或密码错误");
                }
            }
        },"json");
    });
    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            $('#logInFormButton').triggerHandler('click');
        }
    });
}

$(function(){
    logIn();
});