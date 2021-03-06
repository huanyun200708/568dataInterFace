<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<title>指标编辑</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/global.css" media="all">
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
			var dataStr = '<%=request.getParameter("dataStr")%>';
			var data = JSON.parse(dataStr);
			var CTX_PATH = '<%=request.getContextPath()%>';
			$(document).ready(function(){
			   if(data.length > 0){
				   $("#name").val(data[0].name);
			   }
			   
			});
			function getFormData(){
				data[0]["name"] = $("#name").val();
				data[0]["password"] = $("#newpassword").val();
				data[0]["repassword"] = $("#renewpassword").val();
				data[0]["oldpassword"] = $("#oldpassword").val();
				return data[0];
			}
	</script>
</head>

<body >
	<center>
		<form class="layui-form" action="" style="width: 500px;margin-top:50px;" id="form1" lay-filter="form1">
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">用户名</label>
			    <div class="layui-input-block">
			      <input type="text" id="name" class="layui-input" style="width:300px" disabled="">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">旧密码</label>
			    <div class="layui-input-block">
			      <input type="password" id="oldpassword" lay-verify="pass" lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input" style="width:300px">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">新密码</label>
			    <div class="layui-input-block">
			      <input type="password" id="newpassword" lay-verify="pass" lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input" style="width:300px">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">再次输入密码</label>
			    <div class="layui-input-block">
			      <input type="password" id="renewpassword" lay-verify="pass" lay-verify="required" placeholder="再次输入密码" autocomplete="off" class="layui-input" style="width:300px">
			      <button lay-submit lay-filter="*" id="submitBt" style="display:none">提交</button>
			    </div>
			</div>
		</form>
	</center>
	
	<script type="text/javascript">
		layui.use(['form'], function(){
			  var form = layui.form;
			  //监听提交
			  form.on('submit(*)', function(data){
			   /*  layer.alert(JSON.stringify(data.field), {
			      title: '最终的提交信息'
			    }) */
			    var formdata = getFormData();
			    $.ajax({
					async : false,
					cache : false,
					type : "POST",
					url : CTX_PATH + "/updatePassWordById_user.do",
					dataType : "json",
					data : {
						"password" : formdata.password,
						"oldpassword" : formdata.oldpassword,
						repassword : formdata.repassword,
						"id"	   : formdata.id
					},
					success : function(data, textStatus, jqXHR) {
						if(data.success == false){
							alert("error:"+data.message);
						}else{
							parent.complateEdit("更新成功！");
						}
					},
					complete : function(XHR, TS) {
						XHR = null;
					}
				});
			    return false;
			  });
			});
	</script>
</body>
</html>
