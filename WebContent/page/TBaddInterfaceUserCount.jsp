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
			var user_key = '<%=request.getParameter("user_key")%>';
			var CTX_PATH = '<%=request.getContextPath()%>';
			$(document).ready(function(){
			   
			});
	</script>
</head>

<body >
	<center>
		<form class="layui-form" action="" style="width: 500px;margin-top:50px;" id="form1" lay-filter="form1">
			<div class="layui-form-item">
			    <label class="layui-form-label" style="width:160px">查询次数</label>
			    <div class="layui-input-inline">
			      <input type="text" id="count" lay-verify="required|number" placeholder="请输入" autocomplete="off" class="layui-input">
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
					url : CTX_PATH + "/CreateOrders_TBinter.do",
					dataType : "json",
					data : {
						"userKey":user_key,
						"count" : $("#count").val()
					},
					success : function(data, textStatus, jqXHR) {
						if(data.success == "false"){
							alert("error:"+data.message);
						}else{
							parent.complateEdit("新增次数成功！");
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
