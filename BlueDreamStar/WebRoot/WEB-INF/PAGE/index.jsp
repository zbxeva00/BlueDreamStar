<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<!-- 让 IE 浏览器运行最新的渲染模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 默认采用高速模式渲染页面（不是所有双模式浏览器都支持） -->
<meta name="renderer" content="webkit">
<!-- 响应式布局 -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>INDEXPAGE</title>
<link href="JS/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	body { padding-top: 70px; }
</style>
<script src="JS/jquery-3.2.1.min.js"></script>
<script src="JS/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		createEvent();
	});
	
	function createEvent(){
		$("#loginbtn").click(function(){
			window.location.href = "./userOperationController_jumpToIndex.do";
		});
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">NewTest</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
		        	<li class="active"><a href="javascript:void(0)">Video</a></li>
		      	</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control input-sm" placeholder="用户登录名">
						<input type="password" class="form-control input-sm" placeholder="用户登录密码">
					</div>
					<button id="loginbtn" type="button" class="btn btn-primary btn-sm">登录</button>
					<button type="button" class="btn btn-default btn-sm">注册</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>