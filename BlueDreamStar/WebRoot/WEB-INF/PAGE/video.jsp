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
<script src="JS/jquery-3.2.1.min.js"></script>
<script src="JS/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

	//video对象
	var videoObj = document.createElement("VIDEO");
	
	//初始化
	$(function(){
		//绑定按钮事件
		creatButton();
		//计算进度条高度
		progressHeight();
		//设置播放文件路径
		videoObj.src = "./VIDEO/test.mp4";
		//设置播放器初始音量
		videoObj.volume = 0.6;
		//向页面添加画布
		$(videoObj).css("width","100%");
		$("#videoDiv").append(videoObj);
		//设置video监听
		//播放时间变化监听
		videoObj.addEventListener("timeupdate",function(){
			getPlayTime();
		},false);
		//播放结束监听
		videoObj.addEventListener("ended",function(){
			videoObj.currentTime = 0;
			$("#playbutton").find("span").attr("class","glyphicon glyphicon-play");
		},false);
	});
	
	//设置进度条播放进度
	function getPlayTime(){
		//视频总时间(秒)
		var allTime = videoObj.duration;
		//当前播放时间(秒)
		var nowTime = videoObj.currentTime;
		//播放百分比
		var playPercent = nowTime/allTime*100
		$("#playprogressdiv").find(".progress-bar").attr("aria-valuenow",playPercent);
		$("#playprogressdiv").find(".progress-bar").css("width",playPercent + "%");
	}
	
	//计算进度条高度
	function progressHeight(){
		$("#playprogressdiv").css("height",parseFloat($(".progress").css("height"))/2);
	}
	
	//绑定按钮事件
	function creatButton(){
		//绑定播、暂停事件
		$("#playbutton").click(function(){
			var playbuttonclass = $("#playbutton").find("span").attr("class");
			if (playbuttonclass == "glyphicon glyphicon-play") {
				videoObj.play();
				$("#playbutton").find("span").attr("class","glyphicon glyphicon-pause");
			} else {
				videoObj.pause();
				$("#playbutton").find("span").attr("class","glyphicon glyphicon-play");
			}
		});
		//绑定停止事件
		$("#stopbutton").click(function(){
			videoObj.pause();
			videoObj.currentTime = 0;
			$("#playbutton").find("span").attr("class","glyphicon glyphicon-play");
		});
		//绑定静音、取消静音事件
		$("#volumebutton").click(function(){
			var volumebuttonclass = $("#volumebutton").find("span").attr("class");
			if (volumebuttonclass == "glyphicon glyphicon-volume-up") {
				videoObj.muted = true;
				$("#volumebutton").find("span").attr("class","glyphicon glyphicon-volume-off");
			} else {
				videoObj.muted = false;
				$("#volumebutton").find("span").attr("class","glyphicon glyphicon-volume-up");
			}
		});
		//绑定单次播放、循环播放事件
		$("#replaybutton").click(function(){
			var replaybuttonclass = $("#replaybutton").find("span").attr("class");
			if (replaybuttonclass == "glyphicon glyphicon-arrow-right") {
				videoObj.loop = true;
				$("#replaybutton").find("span").attr("class","glyphicon glyphicon-retweet");
			} else {
				videoObj.loop = false;
				$("#replaybutton").find("span").attr("class","glyphicon glyphicon-arrow-right");
			}
		});
		//绑定音量调节事件
		$("#volumerange").change(function(){
			var volumeValue = ($("#volumerange").val())/100;
			videoObj.volume = volumeValue;
			if (volumeValue <= 0) {
				$("#volumebutton").find("span").attr("class","glyphicon glyphicon-volume-off");
			} else {
				$("#volumebutton").find("span").attr("class","glyphicon glyphicon-volume-up");
			}
		});
	}
	
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div id="videoDiv" class="col-md-6"></div>
			<div class="col-md-3"></div>
		</div>
		<div>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-12">
						<div id="playprogressdiv" class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
								<span class="sr-only"></span>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<button id="playbutton" type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-play"></span>
						</button>
						<button id="stopbutton" type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-stop"></span>
						</button>
						<button id="replaybutton" type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-arrow-right"></span>
						</button>
						<button id="volumebutton" type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-volume-up"></span>
						</button>
						<input id="volumerange" type="range" value="60" min="0" max="100" step="5" style="width: 5em;display: inline;"/>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>