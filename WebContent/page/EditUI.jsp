<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();	
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String user = (String)request.getSession().getAttribute("user");
	String user = (String)session.getAttribute("user");
	if (user == null ||user.isEmpty()) {
		response.sendRedirect(basePath+"page/login.jsp");
	}
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/quit.css" media="all">
	<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/login/quit.js"></script>
	<script type="text/javascript">
			var name = "${myname}";
			var CTX_PATH = '<%=request.getContextPath()%>';
	</script>
</head>

<body>
<div class="div_button"><button class="button_zx" onclick="out()">QUIT</button></div>
	<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
						<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo">
				<li class="layui-nav-item layui-this" page="${pageContext.request.contextPath}/page/interfacemgt.jsp">
					<dd  id="userManage" >
						<a href="javascript:;">客户管理</a>
					</dd>
				</li>
				<li class="layui-nav-item " page="${pageContext.request.contextPath}/page/userManage.jsp">
					<dd  id="userManage" >
						<a href="javascript:;">管理员管理</a>
					</dd>
				</li>
			</ul>
		</div>
	</div>
	<div class="layui-tab layui-tab-card">
		<div class="layui-body layui-tab-content site-demo site-demo-body">
			<iframe id="main_iframe" src="${pageContext.request.contextPath}/page/interfacemgt.jsp" style="width:100%;height:100%" frameborder="0"></iframe>
		</div>
	</div>
	<script type="text/javascript">
	 	var layer;
		layui.use('layer', function(){
		  layer = layui.layer;
		});   
		layui.use('element', function(){
		  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
		  //监听导航点击
		  element.on('nav(demo)', function(elem){
		    $("#main_iframe").attr("src",$(elem.context).attr("page"));
		  });
		});
	</script>
</body>
</html>
