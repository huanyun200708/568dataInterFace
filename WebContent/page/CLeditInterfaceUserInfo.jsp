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
			var id = '<%=request.getParameter("id")%>';
			var CTX_PATH = '<%=request.getContextPath()%>';
			$(document).ready(function(){
				$.ajax({
					async : false,
					cache : false,
					type : "POST",
					url : CTX_PATH + "/getInterFaceUseById_inter.do",
					dataType : "json",
					data : {id:id},
					success : function(data, textStatus, jqXHR) {
						if(data.success == "false"){
							alert("error:"+data.message);
						}else{
							var result = data.data;
							 $("#name").val(result.name);
							 $("#phone").val(result.phone);
						}
					},
					complete : function(XHR, TS) {
						XHR = null;
					}
				});
			   
			});
	</script>
</head>

<body >
	<center>
		<form class="layui-form" action="" style="width: 500px;margin-top:50px;" id="form1" lay-filter="form1">
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">用户名</label>
			    <div class="layui-input-inline">
			      <input type="text" id="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">电话</label>
			    <div class="layui-input-inline">
			      <input type="text" id="phone" lay-verify="" placeholder="请输入" autocomplete="off" class="layui-input">
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
			    $.ajax({
					async : false,
					cache : false,
					type : "POST",
					url : CTX_PATH + "/updateInterFaceUse_inter.do",
					dataType : "json",
					data : {
						"id":id,
						"name" : $("#name").val(),
						"phone" : $("#phone").val()
					},
					success : function(data, textStatus, jqXHR) {
						if(data.success == "false"){
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
