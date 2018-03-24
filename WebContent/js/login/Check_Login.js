$(function(){
	$(".btn").click(function(){
		is_hide();
	});
	var u=$("input[name=username]");
	var p=$("input[name=password]");
	/*$("#submit").click(function(){
		var username = '';
		var password = '';
		username=u.val().replace(/(^\s+)|(\s+$)/g,"");
		password=p.val().replace(/(^\s+)|(\s+$)/g,"");
		if(username==''||password==''){
			$("#ts").html("用户名或密码不能为空！");
			is_show();
			return false;
		}
		else{
			$.ajax({
				cache : false,
				type : "POST",
				url : CTX_PATH + "/getuserdata_login.do",
				dataType : "json",
				data : {
				},
				success : function(data) {
					if(data.result == true){
						 window.location.href = CTX_PATH+"/page/EditUI.jsp"
					}
				},
				complete : function(XHR, TS) {
					XHR = null;
				}
			});
			//校验用户名密码
			var reg=/^\w+$/;
			if(!reg.exec(u.val())){
				$("#ts").html("用户名错误！");
				is_show();
				return false;
			}
		}
	});*/
	window.onload=function(){
		$(".connect p").eq(0).animate({"left":"0%"},600);
		$(".connect p").eq(1).animate({"left":"0%"},400);
	}
	function is_hide(){
		$(".alert").animate({"top":"-40%"},800)
		}
	function is_show(){
		$(".alert").show().animate({"top":"45%"},300)
	}
})
