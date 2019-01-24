<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>日&月股份有限公司</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" href="res/css/index.css">
<link rel="stylesheet" href="res/css/personMyInfo.css">
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">


</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>
		<div class="layui-body" id='body-div'>
			<!-- 内容主体区域 -->
			<div class="index-welcome">
				系统信息：欢迎回来
				<div class="index-welcome-right">
					 <i class="layui-icon layui-icon-reply-fill" id='new-msg'><span
						class="layui-badge-dot"></span></i><i
						class="layui-icon layui-icon-set-fill"></i>
				</div>
			</div>
			<div class="layui-row">
				<div
					class="layui-col-xs11 layui-col-sm10 layui-col-md8 layui-col-lg7 person-my-info">
					<div class="person-my-info-mypic">
						<img alt="加载中。。。" src="res/image/sun.png">
					</div>
					<hr>
					<div class="person-my-info-msg-div">
						<div class="person-my-info-msg">
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">姓名：</label><label id="staff_name"
									class="val"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">工号：</label><label id="staff_id" class="val"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">手机号：</label><label class="val"
									id="staff_phone"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">所属部门：</label><label class="val"
									id="department_name"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">邮箱：</label><label class="val"
									id="staff_email"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">职位：</label><label class="val"
									id="position_name"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">工作地点：</label><label class="val"
									id="work_address_name"></label>
							</div>
							<div
								class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4 person-my-info-label">
								<label class="title">入职日期：</label><label class="val"
									id="staff_in_date"></label>
							</div>

						</div>
					</div>
				</div>


				<div
					class="layui-col-xs11 layui-col-sm10 layui-col-md8 layui-col-lg7 person-my-info2">
					<div class="layui-card">
						<div class="layui-tab layui-tab-brief">
							<ul class="layui-tab-title">
								<li class="layui-this index-msg-li">消息</li>
								<li class="index-msg-li">公司公告</li>
							</ul>
							<div class="layui-tab-content">
								<div class="layui-tab-item layui-show" id='msg-div'></div>

								<div class="layui-tab-item" id='notice-div'></div>


							</div>
						</div>



					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/html" id="msg-content">
		<div style="width: 100%;padding-top: 20px;text-align: center;">
   	 		<div  style="border: 1px solid #eee; background-image: url('file/getFile?path=${staff.staff_person_picture}'); border-radius: 100px; width: 100px;height: 100px;display: flex;margin: 0 auto; background-size: cover;background-repeat: no-repeat;background-position: center;">
    		</div>
    		<div style="margin: 10px;"> ${staff.staff_name} -  ${staff.position_name}<br>部门：${staff.department_name}</div>
			<div id='online-div'></div>
		</div>
	</script>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script>
		//JavaScript代码区域
		layui.use([ 'form', 'jquery' ], function() {
			console.log(0);
			var form = layui.form;
			var layer = layui.layer;
			var $ = jQuery = layui.jquery;
			var refOnline;
			function getOnline() {
				$.ajax({
					type : "get",
					url : "msg/getStaffOnline",
					async : true,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							var item="";
							for ( var x in jsonData.data) {
								item = "";
								item += '<div style="width: 100%;background: #fff;display:  flex;border-bottom: 1px solid #eee;flex-direction: row;">';
								item += '<div style="display: inline-block;border: 1px solid #eee; margin: 5px;line-height: 60px;border-radius: 50px;background-image: url('+"'file/getFile?path="+jsonData.data[x].staff_person_picture+"'"+');width: 50px;height: 50px;background-size: cover;background-repeat: no-repeat;background-position: center;"></div>';
								item += '<div style="text-align: left;display: flex;flex-direction: column;justify-content:center;flex: 1;">';
								item += jsonData.data[x].staff_name+'-'+jsonData.data[x].position_name+'<br>部门：'+jsonData.data[x].department_name+'</div>';
								item += '<div style="text-align: center;display: flex;flex-direction: column;justify-content:center;margin-right: 10px;">';
								item += '<a href="javascript:;" onclick="gotoSendMsg('+"'"+jsonData.data[x].staff_id+"','"+jsonData.data[x].staff_name+"'"+')">发送消息</a></div></div>';
							}
							if (item=='') {
								item="无人在线";
							}
							$("#online-div").html(item);
						}
					},
					error : function(jqObj) {
					}
				});
			}
			$('#new-msg').on('click', function() {
				getOnline();
				refOnline=setInterval(getOnline, 3000);
				layer.open({
					type : 1,
					title : false,
					shadeClose : true, // 开启遮罩关闭
					closeBtn : 0, // 不显示关闭按钮
					shade : [ 0.2 ],
					area : [ '340px', ($(window).height() - 50) + 'px' ],
					offset : [ '50px', ($(window).width() - 340) + "px" ],
					anim : 5,
					content : $('#msg-content').html(),
					end : function() { // 此处用于演示
						clearInterval(refOnline);
					}
				});
			});
			
			window.gotoSendMsg=function(staff_id,staff_name){
				layer.open({
					  type: 2,
					  title: '发布公告',
					  shadeClose: true,
					  shade: 0.8,
					  area: ['90%', '80%'],
					  content: "msg/gotoSendMsg?staff_id="+staff_id+"&staff_name="+staff_name
					}); 
			}
			
			function getMsg() {
				$.ajax({
					type : "get",
					url : "msg/getMsgList",
					async : false,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							for ( var x in jsonData.data) {
								var msgItems = "";
								msgItems += '<div class="index-msg-div"onclick="openMsg('+"'"+jsonData.data[x].msg_title+"',"+
								"'"+jsonData.data[x].msg_body+"',"+
								"'"+jsonData.data[x].send_name+"',"+
								"'"+jsonData.data[x].send_time+"',"+
								"'"+jsonData.data[x].send_id+"',"+')">';
								msgItems += '<div class="index-msg-div-con">';
								msgItems += '<nobr>'+ jsonData.data[x].msg_title+ '</nobr></div>';
								msgItems += '	<div class="index-msg-div-date">'+ jsonData.data[x].send_name+'</div>';
								msgItems += '<div class="index-msg-div" > </div> ';
								$("#msg-div").append(msgItems);
							}
		
						}
					},
					error : function(jqObj) {
					}
				});
			}
			
			//获取公司公告
			function getNotice() {
				$.ajax({
					type : "get",
					url : "notice/getNoticesAll",
					async : true,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							for ( var x in jsonData.data) {
								var notice = "";
								notice += '<div class="index-msg-div">';
								notice += '<div class="index-msg-div-con">';
								notice += '<nobr onclick="openNotice('+"'"+jsonData.data[x].notice_id+"'"+')">'+ jsonData.data[x].notice_title+ '</nobr></div>';
								notice += '	<div class="index-msg-div-date">'+ jsonData.data[x].notice_time.substring(5,16)+'</div>';
								notice += '<div class="index-msg-div" > </div> ';
								$("#notice-div").append(notice);
							}
		
						}
					},
					error : function(jqObj) {
					}
				});
			}
		
			$.ajax({
				type : "post",
				url : "staffManage/getMyInfo?"
						+ $("#leaveform").serialize(),
				async:true,
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.code == 100) {
						$("#staff_name")
								.html(jsonData.staff.staff_name);
						$("#staff_id").html(jsonData.staff.staff_id);
						$("#staff_phone").html(
								jsonData.staff.staff_phone);
						$("#department_name").html(
								jsonData.staff.department_name);
						$("#staff_email").html(
								jsonData.staff.staff_email);
						$("#position_name").html(
								jsonData.staff.position_name);
						$("#work_address_name").html(
								jsonData.staff.work_address_name);
						$("#staff_in_date").html(
								jsonData.staff.staff_in_date);
		
					} else if (jsonData.code == 101) {
						layer.msg('身份已过期，请重新登录', {
							icon : 2,
							time : 2500
						}, function() {
							window.location.href = "gotoLogin";
						});
					}
				}
			});
			
			window.openMsg=function(titile,body,name,time,send_id) {
				layer.open({
					type : 1,
					title : "消息",
					closeBtn : false,
					area : '300px;',
					shade : 0.8,
					id : 'new_notice',
					btn : [ '回复','关闭' ],
					btnAlign : 'c',
					moveType : 1,
					content : '<div style="padding: 20px; line-height: 22px; background-color: #ffffff; color: #6d6d6d;"><span style="font-size: 16px;color: #000;">标题 </span>'
							+ titile
							+ '<br><br><span style="font-size: 16px;color: #000;">内容 </span>'
							+ body
							+ '<br><br><br>发布者：'
							+ name
							+ '<br>发布时间：'
							+ time + '</div>',
					success : function(layero) {
						 var btn = layero.find('.layui-layer-btn');
						 btn.find('.layui-layer-btn0').on('click',function() {
							 returnMsg(send_id);
						});
					}
				});
			}
window.openNotice=function(id) {
				
				$.ajax({
					type : "get",
					url : "notice/getNoticesById?id=" + id,
					async : false,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							
							layer.open({
								type : 1,
								title : "公告",
								closeBtn : false,
								area : '300px;',
								shade : 0.8,
								id : 'new_notice',
								btn : [ '关闭' ],
								btnAlign : 'c',
								moveType : 1,
								content : '<div style="padding: 20px; line-height: 22px; background-color: #ffffff; color: #6d6d6d;"><span style="font-size: 16px;color: #000;">标题 </span>'
										+ jsonData.data.notice_title
										+ '<br><br><span style="font-size: 16px;color: #000;">内容 </span>'
										+ jsonData.data.notice_msg
										+ '<br><br><br>发布者：'
										+ jsonData.data.notice_staff_name
										+ '<br>发布时间：'
										+ jsonData.data.notice_time + '</div>',
								success : function(layero) {
									
								}
							});
							
						}  else {
							layer.msg("找不到公告", {
								icon : 2
							});
						}
					},
					error : function(jqObj) {
						layer.msg("链接失败", {
							icon : 2
						});
					}
				});
				
				
			}
			function returnMsg(send_id) {
				layer.prompt({
				  formType: 2,
				  value: '',
				  title: '请输入回复信息',
				  area: ['400px', '100px'] //自定义文本域宽高
				}, function(value, index, elem){
				  if (value!='') {
					  layer.close(index);
					  $.ajax({
							type : "post",
							url : "msg/sendMsg?object_id="+send_id+"&msg_body="+value,
							async : false,
							success : function(data) {
								var jsonData = JSON.parse(data);
								if (jsonData.code == 100) {
									 layer.msg("已回复");
								}
							},
							error : function(jqObj) {
							}
						});
				   }else{
					   layer.msg("请输入回复信息");
				   }
				  
				});
			}
			getMsg();
			getNotice();
		});
	</script>
</body>
</html>