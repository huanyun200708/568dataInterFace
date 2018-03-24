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
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta name="author" content="" />
<meta charset="UTF-8">
<title>登录页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/reset.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/supersized.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/loginstyle.css"
	media="all">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/supersized.3.2.7.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/supersized-init.js"></script>
<script type="text/javascript">
			var CTX_PATH = '<%=request.getContextPath()%>';
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/Check_Login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/jqlogin.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/login/memory.js"></script> --%>
</head>

<body>
	<div class="page-container" id="main">
		<h1>接口维护系统</h1>
		<form action="" method="post" class="login-form">
			<div class="forusername">
				<!--<input  class="username" id="cname" name="name" minlength="2" type="text" required>-->
				<input type="text" name="username" id="loginName" class="username"
					placeholder="Username" autocomplete="off" />
			</div>
			<div class="forpassword">
				<input type="password" name="password" id="loginPwd"
					class="password" placeholder="Password"
					oncontextmenu="return false" onpaste="return false" />
			</div>

			<!--使用控件后-->
			<button id="loginButton" type="submit">Sign in</button>
			<!--使用控件前-->
			<!--<button id="submit" type="button">Sign in</button>-->
		</form>
	</div>
	<div class="alert" style="display: none;">
		<h2>消息</h2>
		<div class="alert_con">
			<p id="ts"></p>
			<p style="line-height: 70px;">
				<a class="btn"> 确定 </a>
			</p>
		</div>
	</div>
	<div class="loader loader--style1" title="0" id="loadind_div" style="display: none;width:100%;height: 100%; z-index: 1000; padding-top: 20%;">
		<svg version="1.1" id="loader-1" xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
			width="100px" height="100px" viewBox="0 0 100 100"
			enable-background="new 0 0 100 100" xml:space="preserve"> <path
			opacity="0.2" fill="#000"
			d="M20.201,5.169c-8.254,0-14.946,6.692-14.946,14.946c0,8.255,6.692,14.946,14.946,14.946
    s14.946-6.691,14.946-14.946C35.146,11.861,28.455,5.169,20.201,5.169z M20.201,31.749c-6.425,0-11.634-5.208-11.634-11.634
    c0-6.425,5.209-11.634,11.634-11.634c6.425,0,11.633,5.209,11.633,11.634C31.834,26.541,26.626,31.749,20.201,31.749z" />
		<path fill="#000"
			d="M26.013,10.047l1.654-2.866c-2.198-1.272-4.743-2.012-7.466-2.012h0v3.312h0
    C22.32,8.481,24.301,9.057,26.013,10.047z">
		<animateTransform attributeType="xml" attributeName="transform"
			type="rotate" from="0 20 20" to="360 20 20" dur="0.5s"
			repeatCount="indefinite" /> </path> </svg>
	</div>
</body>
</html>
