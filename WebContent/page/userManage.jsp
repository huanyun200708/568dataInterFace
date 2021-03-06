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
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.10.2.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
		<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript">
			var CTX_PATH = '<%=request.getContextPath()%>';
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>

	<body>
		<div class="layui-tab layui-tab-card" lay-filter="tab">
			<ul class="layui-tab-title">
				<li class="layui-this" id="edit_tab">编辑</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<div class="layui-btn-group demoTable">
						<button class="layui-btn" data-type="add">新增</button>
						<button class="layui-btn" data-type="edit">编辑</button>
						<button class="layui-btn" data-type="delete">删除</button>
					</div>
					<table class="layui-hide" id="table"></table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			layui.use('element', function() {
				var $ = layui.jquery,
					element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
				//触发事件
				var active = {
					tabAdd: function() {
						//新增一个Tab项
						element.tabAdd('demo', {
							title: '新选项' + (Math.random() * 1000 | 0) //用于演示
								,
							content: '内容' + (Math.random() * 1000 | 0),
							id: new Date().getTime()
							//实际使用一般是规定好的id，这里以时间戳模拟下
						})
					},
					tabDelete: function(othis) {
						//删除指定Tab项
						element.tabDelete('demo', '44'); //删除：“商品管理”
						othis.addClass('layui-btn-disabled');
					},
					tabChange: function() {
						//切换到指定Tab项
						element.tabChange('demo', '22'); //切换到：用户管理
					}
				};

				$('.site-demo-active').on('click', function() {
					var othis = $(this),
						type = othis.data('type');
					active[type] ? active[type].call(this, othis) : '';
				});
				//Hash地址的定位
				var layid = location.hash.replace(/^#test=/, '');
				element.tabChange('test', layid);

				element.on('tab(tab)', function(elem) {
					if($(this).attr('id') == "edit_tab") {
						refreshEditTab();
					} else if($(this).attr('id') == "preview_tab") {
						refresPreviewTab();
					}
				});

			});

			layui.use('table', function() {
				table = layui.table;
				table.render({
					elem: '#table',
					url: CTX_PATH + "/getAllUser_user.do",
					cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
						,
					cols: [
						[{
							type: 'numbers'
						}, {
							type: 'checkbox'
						}, {
							field: 'id',
							title: 'ID'
						}, {
							field: 'name',
							title: '用户名'
						}]
					]
				});

				var _$ = layui.$,
					active = {
						edit: function() { //获取选中数据
							var checkStatus = table.checkStatus('table'),
								data = checkStatus.data;
							if(data.length != 1) {
								layer.msg('请选则1 条记录！');
								return;
							}
							var dataStr = JSON.stringify(data);
							layer.open({
								type: 2, //此处以iframe举例,
								title: '编辑',
								area: ['700px', '400px'],
								shade: 0.3,
								maxmin: true,
								resize: true,
								fixed: false,
								scrollbar: true,
								content: CTX_PATH + "/page/editUser.jsp?dataStr=" + encodeURI(dataStr) ,
								btn: ['提交', '关闭'],
								btnAlign: 'c',
								yes: function(index, layero) {
									var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method(); 
									iframeWin.document.getElementById("submitBt").click();
								},
								btn2: function() {
									layer.closeAll();
								}
							});
						},
						add: function() { //获取选中数目
							layer.open({
								type: 2, //此处以iframe举例,
								title: '编辑',
								area: ['700px', '400px'],
								shade: 0.3,
								maxmin: true,
								resize: true,
								fixed: false,
								scrollbar: true,
								content: CTX_PATH + "/page/addUser.jsp",
								btn: ['提交', '关闭'],
								btnAlign: 'c',
								yes: function(index, layero) {
									var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method(); 
									iframeWin.document.getElementById("submitBt").click();
								},
								btn2: function() {
									layer.closeAll();
								}
							});
						},
						delete: function() { //验证是否全选
							var checkStatus = table.checkStatus('table'),
							data = checkStatus.data;
							if(data.length == 0) {
								layer.msg('请选则至少1 条记录！');
								return;
							}
							var ids = "";
							for(var i=0;i<data.length;i++){
								ids = ids + ","+data[i].id;
							}
							ids = ids.substring(1);
							$.ajax({
								async : false,
								cache : false,
								type : "POST",
								url : CTX_PATH + "/deleteUserByIds_user.do",
								dataType : "json",
								data : {
									"ids" : ids
								},
								success : function(data, textStatus, jqXHR) {
									if(data.success == false){
										alert("error:"+data.message);
									}else{
										alert("删除成功！");
										refreshEditTab();
									}
								},
								complete : function(XHR, TS) {
									XHR = null;
								}
							});
						}
					};

				$('.demoTable .layui-btn').on('click', function() {
					var type = $(this).data('type');
					active[type] ? active[type].call(this) : '';
				});
			});

			function complateEdit(resultMsg) {
				layer.closeAll();
				layer.msg(resultMsg);
				table.render({
					elem: '#table',
					url: CTX_PATH + "/getAllUser_user.do",
					cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
						,
					cols: [
						[{
							type: 'numbers'
						}, {
							type: 'checkbox'
						}, {
							field: 'id',
							title: 'ID'
						}, {
							field: 'name',
							title: '用户名'
						}]
					]
				})
			}

			function closeLay() {
				layer.closeAll();
			}

			function refreshEditTab() {
				table.render({
					elem: '#table',
					url: CTX_PATH + "/getAllUser_user.do",
					cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
						,
					cols: [
						[{
							type: 'numbers'
						}, {
							type: 'checkbox'
						}, {
							field: 'id',
							title: 'ID'
						}, {
							field: 'name',
							title: '用户名'
						}]
					]
				})
			}

		</script>
	</body>

</html>