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
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon" />

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/admin/header.jsp"%>
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div class="index-welcome">
				系统信息：欢迎回来
				<div class="index-welcome-right">
					<i class="layui-icon layui-icon-add-1" id='new-notice'></i> <i
						class="layui-icon layui-icon-reply-fill" id='new-msg'><span
						class="layui-badge-dot"></span></i><i
						class="layui-icon layui-icon-set-fill"></i>
				</div>
			</div>
			<div class="layui-row">
				<div
					class="layui-col-xs12 layui-col-sm12 layui-col-md2 layui-col-lg2">
					<div class="layui-card">
						<div class="layui-tab layui-tab-brief">
							<ul class="layui-tab-title">
								<li class="layui-this index-msg-li">消息</li>
								<li class="index-msg-li">公司公告</li>
							</ul>
							<div class="layui-tab-content">
								<div class="layui-tab-item layui-show" id="msg-div"></div>
								<div class="layui-tab-item" id='notice-div'></div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4">
					<div class="layui-card">
						<div class="layui-card-header">待办事项</div>
						<div class="layui-card-body">
							<div class="layui-col-xs4 index-myfun">
								<img alt="加载中。。。" src="res/image/birthday.png"> <br>
								<label>0人</label> <br> <label>生日提醒</label>
							</div>
							<div class="layui-col-xs4 index-myfun" onclick="window.location.href='gotoJsp?jsp=admin/staffManage&con=staffContractManage'">
								<img alt="加载中。。。" src="res/image/contract.png"> <br>
								<label>0人</label> <br> <label>合同到期</label>
							</div>

							<div class="layui-col-xs4 index-myfun"
								onclick="window.location.href='gotoJsp?jsp=admin/examineCentrality&con=examineLeave'">

								<img alt="加载中。。。" src="res/image/leave.png"> <br> <label>0人</label>
								<br> <label>假期审批</label>
							</div>


						</div>
					</div>

					<div class="layui-card">
						<div class="layui-card-header">人事变动</div>
						<div class="layui-card-body">
							<div class="layui-col-xs6">
								<div class="index-hunman-change">
									<div class="index-hunman-change-main">
										<div>
											<label>0</label>&nbsp;&nbsp;人
										</div>
										<img alt="加载中。。。" src="res/image/icon/add_staff.png">
									</div>
									<div class="index-hunman-change-footer color-blue">待入职
										>&nbsp;&nbsp;</div>
								</div>
							</div>

							<div class="layui-col-xs6">
								<div class="index-hunman-change">
									<div class="index-hunman-change-main">
										<div>
											<label>0</label>&nbsp;&nbsp;人
										</div>
										<img alt="加载中。。。"
											src="res/image/icon/application_for_Quit.png">
									</div>
									<div class="index-hunman-change-footer color-green">待离职
										>&nbsp;&nbsp;</div>
								</div>
							</div>

							<div class="layui-col-xs6">
								<div class="index-hunman-change">
									<div class="index-hunman-change-main">
										<div>
											<label>0</label>&nbsp;&nbsp;人
										</div>
										<img alt="加载中。。。"
											src="res/image/icon/training_and_development.png">
									</div>
									<div class="index-hunman-change-footer color-blue-one">待转正
										>&nbsp;&nbsp;</div>
								</div>
							</div>

							<div class="layui-col-xs6">
								<div class="index-hunman-change">
									<div class="index-hunman-change-main">
										<div>
											<label>0</label>&nbsp;&nbsp;人
										</div>
										<img alt="加载中。。。"
											src="res/image/icon/application_for_Transfer.png">
									</div>
									<div class="index-hunman-change-footer color-violet">待调动
										>&nbsp;&nbsp;</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-card">
						<div class="layui-card-header">快捷入口</div>
						<div class="layui-card-body">
							<div
								onclick="gotoJsp('gotoJsp?jsp=admin/staffManage&con=roster')"
								class="index-myfun layui-col-xs4 layui-col-sm4 layui-col-md2 layui-col-xs2 ">
								<img alt="加载中。。。" src="res/image/roster.png"> <br> <label>花名册</label>
							</div>


							<div
								onclick="gotoJsp('gotoJsp?jsp=admin/staffManage&con=staffTableList')"
								class="index-myfun layui-col-xs4 layui-col-sm4 layui-col-md2 layui-col-xs2 ">
								<img alt="加载中。。。" src="res/image/entry.png"> <br> <label>入职管理</label>
							</div>

							<div
								class="index-myfun layui-col-xs4 layui-col-sm4 layui-col-md2 layui-col-xs2 ">
								<img alt="加载中。。。" src="res/image/notice.png"> <br> <label>公告管理</label>
							</div>
							<div
								onclick="gotoJsp('gotoJsp?jsp=admin/examineCentrality&con=examineRrcruit')"
								class="index-myfun layui-col-xs4 layui-col-sm4 layui-col-md2 layui-col-xs2 ">
								<img alt="加载中。。。" src="res/image/approval.png"> <br>
								<label>审批中心</label>
							</div>

							<div
								onclick="gotoJsp('gotoJsp?jsp=admin/performanceEva&con=performanceEvaNew')"
								class="index-myfun layui-col-xs4 layui-col-sm4 layui-col-md2 layui-col-xs2 ">
								<img alt="加载中。。。" src="res/image/achievements.png"> <br>
								<label>绩效管理</label>
							</div>

						</div>
					</div>

					<div class="layui-card">
						<div class="layui-card-header">日期</div>
						<div class="layui-card-body" id='date'></div>
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
		layui
				.use(
						[ 'element', 'jquery', 'laydate' ],
						function() {
							var element = layui.element;
							var $ = jQuery = layui.jquery;
							var laydate = layui.laydate;
							setInterval(getOnline(), 3000);
							function getOnline() {
								$
										.ajax({
											type : "get",
											url : "msg/getStaffOnline",
											async : true,
											success : function(data) {
												var jsonData = JSON.parse(data);
												if (jsonData.code == 100) {
													var item = "";
													for ( var x in jsonData.data) {
														item += '<div style="width: 100%;background: #fff;display:  flex;border-bottom: 1px solid #eee;flex-direction: row;">';
														item += '<div style="display: inline-block;border: 1px solid #eee; margin: 5px;line-height: 60px;border-radius: 50px;background-image: url('
																+ "'file/getFile?path="
																+ jsonData.data[x].staff_person_picture
																+ "'"
																+ ');width: 50px;height: 50px;background-size: cover;background-repeat: no-repeat;background-position: center;"></div>';
														item += '<div style="text-align: left;display: flex;flex-direction: column;justify-content:center;flex: 1;">';
														item += jsonData.data[x].staff_name
																+ '-'
																+ jsonData.data[x].position_name
																+ '<br>部门：'
																+ jsonData.data[x].department_name
																+ '</div>';
														item += '<div style="text-align: center;display: flex;flex-direction: column;justify-content:center;margin-right: 10px;">';
														item += '<a href="javascript:;" onclick="gotoSendMsg('
																+ "'"
																+ jsonData.data[x].staff_id
																+ "','"
																+ jsonData.data[x].staff_name
																+ "'"
																+ ')">发送消息</a></div></div>';
													}
													if (item == '') {
														item = "无人在线";
													}

													$("#online-div").html(item);
												}
											},
											error : function(jqObj) {
											}
										});
							}

							$('#new-msg')
									.on(
											'click',
											function() {
												getOnline();
												refOnline = setInterval(
														getOnline, 3000);
												layer
														.open({
															type : 1,
															title : false,
															shadeClose : true, // 开启遮罩关闭
															closeBtn : 0, // 不显示关闭按钮
															shade : [ 0.2 ],
															area : [
																	'340px',
																	($(window)
																			.height() - 50)
																			+ 'px' ],
															offset : [
																	'50px',
																	($(window)
																			.width() - 340)
																			+ "px" ],
															anim : 5,
															content : $(
																	'#msg-content')
																	.html(),
															end : function() { // 此处用于演示
																clearInterval(refOnline);
															}
														});
											});

							laydate.render({
								calendar : true,
								elem : '#date',
								position : 'static',
								change : function(value, date) { //监听日期被切换
									lay('#testView').html(value);
								}
							});

							$('#menue-i').fadeOut();

							window.gotoJsp = function(url) {
								window.location.href = url;
							}

							window.gotoSendMsg = function(staff_id, staff_name) {
								layer.open({
									type : 2,
									title : '发送消息',
									shadeClose : true,
									shade : 0.8,
									area : [ '90%', '80%' ],
									content : "msg/gotoSendMsg?staff_id="
											+ staff_id + "&staff_name="
											+ staff_name
								});
							}

							$('#new-notice').on('click', function() {
								layer.open({
									type : 2,
									title : '发布公告',
									shadeClose : true,
									shade : 0.8,
									area : [ '90%', '80%' ],
									content : "notice/gotoAddNotice"
								});
							});

							window.indexReFMsg = function() {
								$("#msg-div").html('');
								$
										.ajax({
											type : "get",
											url : "msg/getMsgList",
											async : true,
											success : function(data) {
												var jsonData = JSON.parse(data);
												if (jsonData.code == 100) {
													for ( var x in jsonData.data) {
														var msgItems = "";
														msgItems += '<div class="index-msg-div"onclick="openMsg('
																+ "'"
																+ jsonData.data[x].msg_title
																+ "',"
																+ "'"
																+ jsonData.data[x].msg_body
																+ "',"
																+ "'"
																+ jsonData.data[x].send_name
																+ "',"
																+ "'"
																+ jsonData.data[x].send_time
																+ "',"
																+ "'"
																+ jsonData.data[x].send_id
																+ "'," + ')">';
														msgItems += '<div class="index-msg-div-con">';
														msgItems += '<nobr>'
																+ jsonData.data[x].msg_title
																+ '</nobr></div>';
														msgItems += '	<div class="index-msg-div-date">'
																+ jsonData.data[x].send_name
																+ '</div>';
														msgItems += '<div class="index-msg-div" > </div> ';
														$("#msg-div").append(
																msgItems);
													}

												}
											},
											error : function(jqObj) {
											}
										});
							}
							//获取公司公告
							function getNotice() {
								$
										.ajax({
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
														notice += '<nobr onclick="openNotice('
																+ "'"
																+ jsonData.data[x].notice_id
																+ "'"
																+ ')">'
																+ jsonData.data[x].notice_title
																+ '</nobr></div>';
														notice += '	<div class="index-msg-div-date">'
																+ jsonData.data[x].notice_time
																		.substring(
																				5,
																				16)
																+ '</div>';
														notice += '<div class="index-msg-div" > </div> ';
														$("#notice-div")
																.append(notice);
													}

												}
											},
											error : function(jqObj) {
											}
										});
							}

							window.openNotice = function(id) {

								$
										.ajax({
											type : "get",
											url : "notice/getNoticesById?id="
													+ id,
											async : false,
											success : function(data) {
												var jsonData = JSON.parse(data);
												if (jsonData.code == 100) {

													layer
															.open({
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
																		+ jsonData.data.notice_time
																		+ '</div>',
																success : function(
																		layero) {

																}
															});

												} else {
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

							window.openMsg = function(titile, body, name, time,
									send_id) {
								layer
										.open({
											type : 1,
											title : "消息",
											closeBtn : false,
											area : '300px;',
											shade : 0.8,
											id : 'new_notice',
											btn : [ '回复', '关闭' ],
											btnAlign : 'c',
											moveType : 1,
											content : '<div style="padding: 20px; line-height: 22px; background-color: #ffffff; color: #6d6d6d;"><span style="font-size: 16px;color: #000;">标题 </span>'
													+ titile
													+ '<br><br><span style="font-size: 16px;color: #000;">内容 </span>'
													+ body
													+ '<br><br><br>发布者：'
													+ name
													+ '<br>发布时间：'
													+ time
													+ '</div>',
											success : function(layero) {
												var btn = layero
														.find('.layui-layer-btn');
												btn
														.find(
																'.layui-layer-btn0')
														.on(
																'click',
																function() {
																	returnMsg(send_id);
																});
											}
										});
							}

							function returnMsg(send_id) {
								layer
										.prompt(
												{
													formType : 2,
													value : '',
													title : '请输入回复信息',
													area : [ '400px', '100px' ]
												//自定义文本域宽高
												},
												function(value, index, elem) {
													if (value != '') {
														layer.close(index);
														$
																.ajax({
																	type : "post",
																	url : "msg/sendMsg?object_id="
																			+ send_id
																			+ "&msg_body="
																			+ value,
																	async : false,
																	success : function(
																			data) {
																		var jsonData = JSON
																				.parse(data);
																		if (jsonData.code == 100) {
																			layer
																					.msg("已回复");
																		}
																	},
																	error : function(
																			jqObj) {
																	}
																});
													} else {
														layer.msg("请输入回复信息");
													}

												});
							}
							indexReFMsg();
							getNotice();
						});
	</script>
	
	<script type="text/javascript" src="res/js/socket.js"></script>
</body>
</html>