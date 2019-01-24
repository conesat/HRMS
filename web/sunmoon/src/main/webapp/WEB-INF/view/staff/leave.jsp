<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假申请</title>
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
	height: 550px;
	margin: 0 auto;
	background-color: #ffffff;
	padding: 20px;
}

.backfather {
	width: 100%;
	height: 1000px;
	margin: 0 auto;
	display: flow;
	background-color: #f4f4f4f4;
	padding-top: 20px;
}
</style>
</head>
<body>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>
		<div class="layui-body" id='body-div' style="left: 0;">


			<form class="layui-form" id="leaveform" action="" >
				<div class="backfather">
					<div class="back" style="margin: auto">
						<div style="margin-left: 350px">
							<legend style="font-weight: bold; font-size: 36px;">请假条</legend>
						</div>
						<br>
						<div class="layui-form-item">
							<label class="layui-form-label">姓名:</label>
							<div class="layui-input-block">
								<input name="leave_staff_name" id="leave_staff_name"
									value="${staff.staff_name}" readonly="readonly" class="layui-input" type="text"
									placeholder="" autocomplete="off" lay-verify="title">
							</div>
						</div>
				
						<div class="layui-form-item">
							<label class="layui-form-label">工号:</label>
							<div class="layui-input-block">
								<input  name="leave_staff_id" id="leave_staff_id"
									value="${staff_id}"readonly="readonly" class="layui-input" type="text"
									placeholder="" autocomplete="off" lay-verify="title">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">请假类别:</label>
							<div class="layui-input-block">
								<select  lay-verify="required"  name="leave_type" id="leave_type" lay-filter="aihao">
									<option value=""></option>
									<option value="事假">事假</option>
									<option value="病假">病假</option>
									<option value="婚假">婚假</option>
									<option value="丧假">丧假</option>
									<option value="工伤">工伤</option>
									<option value="工假">工假</option>
									<option value="产假">产假</option>
									<option value="护理假">护理假</option>
									<option value="其他">其他</option>
								</select>
							</div>
						</div>

						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -90px;">请假开始时间:</label>
							<div class="layui-inline">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input autocomplete="off" required lay-verify="required"  class="layui-input" id="leave_start_time"
										name="leave_start_time" placeholder="yyyy-MM-dd" type="text"
										style="margin-left: -80px; width: 150px;">
								</div>
							</div>
						</div>

						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label"
								style="width: 200px; margin-left: -90px;">请假结束时间:</label>
							<div class="layui-inline">
								<label class="layui-form-label"></label>
								<div class="layui-input-inline">
									<input  autocomplete="off" required lay-verify="required"  class="layui-input" id="leave_end_time"
										name="leave_end_time" placeholder="yyyy-MM-dd" type="text"
										style="margin-left: -80px; width: 150px;">
								</div>
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">请假事由:</label>
							<div class="layui-input-block">
								<textarea name="leave_msg" class="layui-textarea" id="leave_msg" maxlength="200"
									placeholder="请输入内容" autocomplete="on" lay-verify="required"  ></textarea>
							</div>
						</div>

						<div style="margin-left: 300px">
							<button type="submit" name="sub" id="sub"
								class="layui-btn layui-btn-primary layui-btn-radius" lay-submit
						lay-filter="sub" >提交</button>
						</div>
						<br>
						<div style="float: right; margin-right: 340px; margin-top: -57px;">
							<button type="reset"
								class="layui-btn layui-btn-primary layui-btn-radius">重置</button>
						</div>
						
						<div>注：1、提前一天请假。 2、假期期间不可续假。 3、病假须出具医院证明。
							4、未经批准擅自离职按旷工处罚（双倍工资）。 &nbsp 5、本表交由财务部存档。</div>

					</div>
				</div>
				
			</form>


		</div>
	</div>

</body>
<script>
	layui.use([ 'form', 'layedit', 'laydate' ,'jquery'],
					function() {
						var form = layui.form, 
						layer = layui.layer,
						layedit = layui.layedit, 
						laydate = layui.laydate;
						var $ = jQuery = layui.jquery;
						
					
						//日期
						laydate.render({
							elem : '#leave_start_time'
						});
						laydate.render({
							elem : '#leave_end_time'
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
						  var DateTwo=$("#leave_start_time").val();
						  var DateOne=$("#leave_end_time").val();//获取控件的值       
                          var time=daysBetween(DateOne, DateTwo);
						 console.log(daysBetween(DateOne, DateTwo));//控制台输出
/* 						 document.getElementById("apply_time").value = today();//将获取到的 年-月-日 时:分:秒 赋给input文本输入框 */
							if (time<0){
								layer.confirm('开始时间当小于结束时间', {
									icon : 2,
									title : '系统提示'
								},function(index) {
									layer.close(index);
									window.location.reload;
								});
							}else {$.ajax({
								type : "post",
								url : "staffApply/staff_leave?"
										+ $("#leaveform").serialize(),
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

</html>