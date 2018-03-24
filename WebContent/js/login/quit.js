/**
 * 
 */
//退出按钮的js
	function out(){
		if(confirm("是否退出？")){
			//alert("确定");
			var result={
 		 			"username":"root"
 		 	};
			$.ajax({
 				cache : false,
 				type : "POST",
 				url : CTX_PATH + "/Destorydata_login.do",
 				dataType : "json",
 				data : result,
 				success : function(data) {
 				},
 				complete : function(XHR, TS) {
 					XHR = null;
 				}
 			});
			window.location.href='page/login.jsp';
		}else{
			//alert("取消");
			//window.open("page/EditUI.jsp");
		}
		
	}