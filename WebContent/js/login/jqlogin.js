$(document).ready(function(){
	$("#loginButton").click(function(){
        jQuery('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                username: {
	                    required: true,
	                    isChar:true
	                },
	                password: {
	                    required: true
	                }
	            },
	            messages: {
	                username: {
	                    required: "用户名没有填写！"
	                },
	                password: {
	                    required: "密码没有填写！"
	                }
	            },

	            highlight: function (element) { // hightlight error inputs
	                jQuery(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            /*errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },*/

	            submitHandler: function (form) {
         	var result={
 		 			"username":jQuery('#loginName').val(),
 		 			"password":jQuery('#loginPwd').val()
 		 	};
         	$('#loadind_div').css("display","block");
         	$('#main').css("display","none");
         	$.ajax({
 				cache : false,
 				type : "POST",
 				url : CTX_PATH + "/getuserdata_login.do",
 				dataType : "json",
 				data : result,
 				success : function(data) {
 					if(data.result == true){
 						 window.location.href = CTX_PATH+"/page/EditUI.jsp";
 					}
 					else{
 						alert("Please enter the correct username and password!");
 						return;
 					}
 				},
 				complete : function(XHR, TS) {
 					XHR = null;
 				}
 			});
         	
         	//用于提交用户名和密码；
	            /* jQuery.ajax({
	       			 url:"Login.action",
	       			 type: "post",dataType : "text",
	       			 data:result,
	       			 success: function(json){ 
	       				 var obj = jQuery.parseJSON(json)
	       				 if(obj.result=="success"){
	       					SetPwdAndChk();
	       				 	self.location='/PEEMES/pages/xitong/index.jsp';}
	       				 else{
	       					$('.alert-error', $('.login-form')).show();
	       				 }
	       			 }
	       		});*/
	           }
	        });

        jQuery('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if (jQuery('.login-form').validate().form()) {
	                    window.location.href = CTX_PATH+"/page/EditUI.jsp";
	                }
	                return false;
	            }
	        });
	        
	        jQuery.validator.addMethod("isChar", function(value, element) {  
	            var length = value.length;  
	            var regName =/[^a-zA-Z0-9]/g;  
	            return this.optional(element) || !regName.test( value );    
	        }, "请正确格式的姓名(仅可以输入英文字符与数字)");  

     });
})
