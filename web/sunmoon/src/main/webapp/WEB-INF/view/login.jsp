<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>登录</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">

<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<link rel="stylesheet" href="res/css/login.css">
</head>


<body class="layui-layout-body">

	<div id='bg-one'
		style="width: 100%; height: 100%;; position: absolute; background-image: url('res/image/1.jpg'); background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	</div>
	<div class="layui-layout layui-layout-admin">

		<div class="layui-header">
			<div class="layui-logo">
				<div class="logo-icon">
					<img src='res/image/sun.png' />
				</div>
				<div class="cmpany-name">日&月 HRMS</div>
			</div>

		</div>


		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div
				class="layui-card layui-col-xs8 layui-col-sm5 layui-col-md3 layui-col-lg2"
				style="box-shadow: 1px 0px 20px black;">
				<div id='login-div'>
					<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
						<ul class="layui-tab-title">
							<li class="layui-this" style="padding: 0; margin: 0; width: 50%;"
								id="staff-login">职员登录</li>
							<li style="padding: 0; margin: 0; width: 50%;" id="admin-login">管理员登录</li>
						</ul>
					</div>

					<div class="layui-card-body">
						<form class="layui-form layui-form-pane" id='login_form'>
							<div class="layui-form-item">
								<label class="layui-form-label">账号</label>
								<div class="layui-input-inline">
									<input required lay-verify="required" type="text" id="staff_id"
										name="staff_id" placeholder="请输入工号/身份证号" autocomplete="off"
										class="layui-input" maxlength="21">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">密码</label>
								<div class="layui-input-inline">
									<input required lay-verify="required" type="password"
										id="staff_password" name="staff_password" placeholder="请输入密码"
										autocomplete="off" class="layui-input" maxlength="16">
								</div>
							</div>
							<div class="layui-form-item">
								<input type="checkbox" id="remember" title="记住密码"
									lay-skin="primary">
							</div>
							<div class="layui-form-item">
								<button class="layui-btn layui-btn-fluid" lay-submit id="login"
									lay-filter="login"><i id='login-load' class="layui-icon layui-anim layui-anim-rotate layui-anim-loop" style="display: none;">&#xe63d;</i>   登录</button>
									
							</div>
						</form>
					</div>
				</div>
				<div id='ewm-div' style="width: 100%;text-align: center;display: none;">
					<h2 style="margin-top: 10px;">扫码下载签到打卡APP</h2>
					<img style="margin: 10px 0;width: 80%" alt="" src="res/image/ewm.png" >
				</div>
			</div>

			<div
				style="width: 100%; text-align: center; margin-top: 150px; position: absolute;">
				<div id='ewm' style="padding: 5px; border-radius: 25px; background: #fff; cursor: pointer;width: 25px;height:25px;margin: 0 auto;" onclick="ewm()">
					<img id='ewm-img' alt="" src="res/image/icon/ewm.png"  height="100%" >
					<label id='ewm-label' style="line-height: 25px;display: none;cursor: pointer;"> 返回登录</label>
				</div>
				
			</div>
		</div>

	</div>
	<script src="layui/layui.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="res/js/vidbg.js"></script>
	<script>
		 jQuery(function($) {
			$('#bg-one').vidbg({
				'mp4' : 'res/vbg.mp4',
				'poster' : 'res/image/1.jpg',
			}, {
				muted : true,
				loop : true,
				overlay : false,
			});
		}); 
		//JavaScript代码区
		layui.use([ 'element', 'jquery', 'form', 'layer' ], function() {
			var element = layui.element;
			var $ = jQuery = layui.jquery;
			var form = layui.form;
			var layer = layui.layer;
			var type = 1;
			var msg = '${msg}';
			if (msg != '') {
				layer.open({
					title : '系统提示',
					content : msg
				});
			}
		
			if (getCookie("rmbUser") == "true") {
				$("#remember").prop("checked", true);
				$("#staff_id").val(getCookie("staff_id"));
				$("#staff_password").val(getCookie("staff_password"));
				$("#remember").prop("checked", 'checked');
			} else {
				$("#staff_id").val("");
				$("#staff_password").val("");
			}
			form.render("checkbox");
		
			//记住用户名密码 
			function save() {
				if ($("#remember").prop("checked")) {
					var staff_id = $("#staff_id").val();
					var staff_password = $("#staff_password").val();
					setCookie("rmbUser", "true", 7);
					setCookie("staff_id", staff_id, 7);
					setCookie("staff_password", staff_password, 7);
				} else {
					delCookie("rmbUser");
					delCookie("staff_id");
					delCookie("staff_password");
				}
			}
		
			//监听提交
			form.on('submit(login)', function(data) {
				$('#login-load').fadeIn();
				$('#login').prop("disabled", true);
				$.ajax({
					type : "post",
					url : "login?" + $("#login_form").serialize() + "&staffType="
							+ type + "&ip=" + window.returnCitySN["cip"] + "&cname="
							+ window.returnCitySN["cname"],
					async : true,
					success : function(data) {
						$('#login-load').fadeOut();
						$('#login').prop("disabled", false);
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							save();
							if (type == 0) {
								window.location.href = "gotoJsp?jsp=admin/index";
							} else {
								window.location.href = "gotoJsp?jsp=staff/index";
							}
						} else if (jsonData.code == 101) {
							layer.msg("用户不存在");
						} else if (jsonData.code == 102) {
							layer.msg("密码错误");
						} else if (jsonData.code == 103) {
							layer.msg("员工已离职");
						} else if (jsonData.code == 104) {
							layer.msg("访问受限");
						} else if (jsonData.code == 105) {
							layer.msg(jsonData.msg);
							$('#login').prop("disabled", true);
							$('#login').css("background-color", "#eee");
							setTimeout(function() {
								$('#login').prop("disabled", false);
								$('#login').css("background-color", "#45baef");
							}, jsonData.time * 60000);
						} else {
							layer.msg("未知错误");
						}
					},
					error : function(jqObj) {
						$('#login-load').fadeOut();
						$('#login').prop("disabled", false);
						layer.msg("连接失败");
					}
				});
				return false;
			});
		
			$('#staff-login').on('click', function() {
				if (type == 0) {
					type = 1;
					var that = this;
					layer.tips('已切换普通职员登录', that);
				}
		
			});
		
			$('#admin-login').on('click', function() {
				if (type == 1) {
					type = 0;
					var that = this;
					layer.tips('已切换管理员登录', that);
				}
			});
		
			//设置cookie
			function setCookie(name, value, day) {
				var date = new Date();
				date.setDate(date.getDate() + day);
				document.cookie = name + '=' + value + ';expires=' + date;
			}
			;
			//获取cookie
			function getCookie(name) {
				var reg = RegExp(name + '=([^;]+)');
				var arr = document.cookie.match(reg);
				if (arr) {
					return arr[1];
				} else {
					return '';
				}
			}
			;
			//删除cookie
			function delCookie(name) {
				setCookie(name, null, -1);
			}
			;
			window.ewm=function(){
				if ($("#login-div").css("display")=='block') {
					$("#login-div").slideUp('', function() {
						$('#ewm-div').slideDown();
						
					});
					$("#ewm").animate({
					    width:'150px'
					},function(){
						$('#ewm-img').fadeOut('',function(){
							$('#ewm-label').fadeIn();
						});
						
					});
				}else{
					$("#ewm-div").slideUp('', function() {
						$('#login-div').slideDown();
					});
					$('#ewm-label').fadeOut('',function(){
						$('#ewm-img').fadeIn();
						$("#ewm").animate({
					    	width:'25px'
						});
					});
				}
			}
		
		});
	</script>
</body>
</html>