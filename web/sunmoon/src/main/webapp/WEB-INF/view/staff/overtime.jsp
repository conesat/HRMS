<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加班申请</title>
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
	height: 540px;
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

	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>

		<div class="layui-body" id='body-div'>

			<form class="layui-form" action="" id="overtimeform"  lay-filter="example">
				<div class="backfather">
					<div class="back">
						<div style="margin-left: 320px">
							<legend style="font-weight: bold; font-size: 36px;">加班申请表</legend>
							<br> <br>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">申请人</label>
							<div class="layui-input-block">
								<input 	lay-verify="title" readonly="readonly" name="overtime_staff_name"
									id="overtime_staff_name" value="${staff.staff_name}"
									class="layui-input" type="text" style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">所属部门</label>
								<input name="overtime_post" id="overtime_post" class="layui-input" type="text"
									 placeholder=""  value="${staff.department_name}" readonly="readonly"
									lay-verify="title"  style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">工号</label>
							<div class="layui-input-block">
								<input name="overtime_staff_id" id="overtime_staff_id" class="layui-input" type="text"
									readonly="readonly" value="${staff_id}" autocomplete="off"
									lay-verify="title" style="width: 200px">
							</div>

						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">职位</label>
							<div class="layui-input-block">
								<input name="overtime_department" id="overtime_department" class="layui-input" type="text"
									readonly="readonly" value="${staff.position_name}"
									autocomplete="off" lay-verify="title" style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item layui-form-text"
							style="margin-left: -30px;">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -90px;">开始日期:</label>
							<div class="layui-inline" style="margin-left: -30px;">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input required lay-verify="required" class="layui-input" autocomplete="off"
										id="overtime_start_time" name="overtime_start_time"
										placeholder="yyyy-MM-dd" type="text"
										style="margin-left: -80px; width: 200px;">
								</div>
								<div class="layui-inline" style="right: 30px;">
									<label class="layui-form-label">总时长</label>
									<div class="layui-input-inline">
										<input class="layui-input" placeholder="/个小时"
											oninput="value=value.replace(/[^\d]/g,'')"
											id="overtime_duration" name="overtime_duration"
											placeholder=" - " type="text" autocomplete="off">
									</div>
								</div>
							</div>
						</div>

						<div class="layui-form-item layui-form-text"
							style="margin-left: -30px;">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -90px;">结束日期:</label>
							<div class="layui-inline" style="margin-left: -30px;">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input required lay-verify="required" class="layui-input" autocomplete="off"
										id="overtime_end_time" name="overtime_end_time"
										placeholder="yyyy-MM-dd" type="text"
										style="margin-left: -80px; width: 200px;">
								</div>
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">加班事由: </label>
							<div class="layui-input-block">
								<textarea name="overtime_msg" id="overtime_msg" class="layui-textarea" placeholder="请输入内容"
									autocomplete="on" lay-verify="required"></textarea>
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
				<input id="apply_time" name="apply_time"
					style="background-color: transparent; border: 0;"
					readonly="readonly" />
			</form>
		</div>

	</div>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>

	<script>
		layui.use([ 'form', 'layedit', 'laydate', 'jquery' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
							var $ = jQuery = layui.jquery;
							//日期
							laydate.render({
								elem : '#overtime_start_time'
							});
							laydate.render({
								elem : '#overtime_end_time'
							});
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
							  var DateTwo=$("#overtime_start_time").val();
							  var DateOne=$("#overtime_end_time").val();//获取控件的值       
	                          var time=daysBetween(DateOne, DateTwo);
							 console.log(daysBetween(DateOne, DateTwo));//控制台输出
  							 document.getElementById("apply_time").value = today();//将获取到的 年-月-日 时:分:秒 赋给input文本输入框  
  							if (time<0){
								layer.confirm('开始时间当小于结束时间', {
									icon : 2,
									title : '系统提示'
								},function(index) {
									layer.close(index);
									window.location.reload;
								});
							}else{ $.ajax({
									type : "post",
									url : "staffApply/staff_overtime?"
											+ $("#overtimeform").serialize(),
									success : function(data) {
										var jsonData = JSON.parse(data);
										 if (jsonData.code == 100) {
											$("#sub").attr('disabled',true);
											layer.confirm('已提交申请', {
												icon : 1,
												title : '系统提示'
											},function(index) {
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
	<script type="text/javascript">
    function today(){//构建方法
        var today=new Date();//new 出当前时间
        var h=today.getFullYear();//获取年
        var m=today.getMonth()+1;//获取月
        var d=today.getDate();//获取日
        var H = today.getHours();//获取时
        var M = today.getMinutes();//获取分
        var S = today.getSeconds();//获取秒
        return h+"-"+m+"-"+d+" "+H+":"+M+":"+S; //返回 年-月-日 时:分:秒
}
</script>
</body>
</html>