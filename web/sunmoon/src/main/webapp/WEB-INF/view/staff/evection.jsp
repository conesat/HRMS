<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出差申请</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">

<style>
.back {
	width: 800px;
	height: 600px;
	margin: 0 auto;
	background-color: #ffffff;
}

.backfather {
	width: 100%;
	height: 1000px;
	margin: 0 auto;
	background-color: #f4f4f4;
	padding-top: 20px;
}

.layui-body {
	left: 0px;
	right: 0px;
}
</style>
</head>
<body>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>

		<div class="layui-body" id='body-div' style="left: 0px;">

			<form class="layui-form" action="" id="evectionform">
				<div class="backfather">
					<div class="back">
						<div style="margin-left: 320px">
							<legend style="font-weight: bold; font-size: 36px;">出差申请表</legend>
							<br> <br>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">申请人</label>
							<div class="layui-input-block">
								<input 	lay-verify="title" readonly="readonly" name="evection_staff_name"
									id="evection_staff_name" value="${staff.staff_name}"
									class="layui-input" type="text" style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">工号</label>
								<input name="evection_staff_id" id="evection_staff_id" class="layui-input" type="text"
									value="${staff_id}" placeholder="" 
									lay-verify="title" readonly="readonly" style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">随同人员</label>
							<div class="layui-input-block">
								<input name="evection_acc" id="evection_acc" class="layui-input" maxlength="20"
									type="text" placeholder="请输入姓名" autocomplete="off"
									lay-verify="title" style="width: 200px" lay-verify="required">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">职位</label> 
								<input name="evection_acc_position" id="evection_acc_position"
									class="layui-input" type="text" placeholder="请输入职位" maxlength="10"
									autocomplete="off" lay-verify="title" style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">交通工具</label>
							<div class="layui-input-block">
								<input name="evection_vehicle" id="evection_vehicle"
									style="width: 200px;" class="layui-input" type="text"
									placeholder="请输入交通工具" autocomplete="off" lay-verify="title">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -120px;">开始时间</label>
							<div class="layui-inline">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input class="layui-input" id="evection_start_time"
										name="evection_start_time" placeholder="yyyy-MM-dd"
										type="text" lay-verify="required"
										style="margin-left: -110px; width: 200px;" autocomplete="off">
								</div>
							</div>
						</div>

						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -120px;">结束时间</label>
							<div class="layui-inline">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input class="layui-input" id="evection_end_time"
										name="evection_end_time" placeholder="yyyy-MM-dd" type="text"
										style="margin-left: -110px; width: 200px;" autocomplete="off"
										required lay-verify="required">
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">出差路线</label>
							<div class="layui-input-block">
								<input name="evection_path" id="evection_path"
									class="layui-input" type="text" placeholder="请输入路线" maxlength="200"
									autocomplete="off" lay-verify="title">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">出差要办事项简述</label>
							<div class="layui-input-block">
								<textarea name="evection_msg" id="evection_msg" 
									class="layui-textarea" lay-verify="required" maxlength="200"
									placeholder="请输入内容"></textarea>
							</div>
						</div>
						<div style="margin-left: 300px">
							<button type="submit" name="sub" id="sub"
								class="layui-btn layui-btn-primary layui-btn-radius" lay-submit
								lay-filter="sub">提交</button>
						</div>
						<br>
						<div style="float: right; margin-right: 340px; margin-top: -57px;">
							<button type="reset"
								class="layui-btn layui-btn-primary layui-btn-radius">重置</button>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
 
</body>

<script>
	layui.use([ 'form', 'layedit', 'laydate', 'jquery' ],
					function() {
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
						var $ = jQuery = layui.jquery;

						//日期

						laydate.render({
							elem : '#evection_start_time'
						});
						laydate.render({
							elem : '#evection_end_time'
						});

						//	var t2=//拿到控件里的值 */ 

						// 计算请假日期 
						function daysBetween(DateOne, DateTwo) {
							var OneMonth = DateOne.substring(5, DateOne
									.lastIndexOf('-'));
							var OneDay = DateOne.substring(DateOne.length,
									DateOne.lastIndexOf('-') + 1);
							var OneYear = DateOne.substring(0, DateOne
									.indexOf('-'));

							var TwoMonth = DateTwo.substring(5, DateTwo
									.lastIndexOf('-'));
							var TwoDay = DateTwo.substring(DateTwo.length,
									DateTwo.lastIndexOf('-') + 1);
							var TwoYear = DateTwo.substring(0, DateTwo
									.indexOf('-'));

							var cha = ((Date.parse(OneMonth + '/' + OneDay
									+ '/' + OneYear) - Date.parse(TwoMonth
									+ '/' + TwoDay + '/' + TwoYear)) / 86400000);
							return cha;
						}

						//监听 提交按钮
						form.on('submit(sub)', function() {
							var DateTwo=$("#evection_start_time").val();
							 var DateOne=$("#evection_end_time").val();//获取控件的值       
							 var time=daysBetween(DateOne, DateTwo);
							 	 console.log(daysBetween(DateOne, DateTwo));//控制台输出 
							 
	  							if (time<0){
									layer.confirm('开始时间当小于结束时间', {
										icon : 2,
										title : '系统提示'
									},function(index) {
										layer.close(index);
										window.location.reload;
									});
								}else{$.ajax({
								type : "post",
								url : "staffApply/staff_evection?"
										+ $("#evectionform").serialize(),
								success : function(data) {
									var jsonData = JSON.parse(data);
									 if (jsonData.code == 100) {
										$("#sub").attr('disabled', true);
										layer.confirm('已提交申请', {
											icon : 1,
											title : '系统提示'
										}, function(index) {
											layer.close(index);
											window.location.reload;
										});

									} else if (jsonData.code == 101) {
										layer.msg("数据库访问异常");
									} else {
										layer.msg("未知错误");
									}
								},

							});
								}
							return false;
						});

					});
</script>

</html>