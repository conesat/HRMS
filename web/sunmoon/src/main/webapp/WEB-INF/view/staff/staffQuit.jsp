<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>离职</title>
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
.back{
width: 800px;
height: 700px;
margin: 0 auto;
background-color: #ffffff;
}
.backfather{
  width: 100%;
  height: 1000px;
  margin: 0 auto;
background-color: #f4f4f4;
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
			<form class="layui-form" action="" id="quitform" lay-filter="example">
				<div class="backfather">
					<div class="back">
						<div style="margin-left: 280px">
							<div style="margin-left: -10px">
								<legend style="font-weight: bold; font-size: 36px;">员工离职申请表</legend>
								<br>
								<br>
							</div>
							<br>

						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">姓 名</label>
							<div class="layui-input-block">
								<input name="quit_staff_name" id="quit_staff_name"
									value="${staff.staff_name}" readonly="readonly"
									class="layui-input" type="text" lay-verify="title"
									style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">工号</label>
								<input name="quit_staff_id" id="quit_staff_id"
									class="layui-input" type="text" lay-verify="title"
									value="${staff_id}" readonly="readonly" style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">所属部门</label>
							<div class="layui-input-block">
								<input name="quit_department" id="quit_department"
									class="layui-input" type="text" maxlength="10"
									value="${staff.department_name}" readonly="readonly"
									autocomplete="off" lay-verify="title" style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">现任岗位</label>
								<input name="quit_post" id="quit_post" class="layui-input"
									maxlength="10" autocomplete="off" lay-verify="title"
									readonly="readonly" type="text" value="${staff.position_name}"
									style="width: 200px">
							</div>
							<br>
							<div class="layui-form-item layui-form-text"
								style="margin-left: -30px;">
								<label class="layui-form-label"
									style="width: 200px; margin-left: -90px;">离职日期:</label>
								<div class="layui-inline" style="margin-left: -30px;">
									<label class="layui-form-label"></label>
									<div class="layui-input-inline">
										<input required lay-verify="required" class="layui-input"
											autocomplete="off" id="quit_time"
											name="quit_time" placeholder="yyyy-MM-dd" type="text"
											style="margin-left: -80px; width: 200px;">
									</div>
								</div>
							</div>
						</div>

						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">离职理由</label>
							<div class="layui-input-block">
								<textarea autocomplete="on" lay-verify="required"
									name="quit_msg" class="layui-textarea" placeholder="请输入内容"
									style="height: 300px; width: 600px"></textarea>
							</div>

						
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div style="margin-left: 300px">
								<button type="submit" name="sub" id="sub"
									class="layui-btn layui-btn-primary layui-btn-radius" lay-submit
									lay-filter="sub">提交</button>
							</div>
							<br>
							<div
								style="float: right; margin-right: 340px; margin-top: -57px;">
								<button type="reset"
									class="layui-btn layui-btn-primary layui-btn-radius">重置</button>
							</div>
						</div>
						<div>注：1、请提前15天申请离职。 2、离职前做好交接工作。 3、未经批准擅自离职负刑事责任。
							4、本表交由人力资源部存档。</div>

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
						elem : '#quit_time'
					});

			 	
				//	var t2=//拿到控件里的值 */ 
			
				
     // 计算离职日期是否大于 当前日期。 
	 function daysBetween(DateOne) {
		        var date = new Date();
		        var seperator1 = "-";
		        var TwoYear = date.getFullYear();
		        var TwoMonth = date.getMonth() + 1;
		        var TwoDay = date.getDate();
		        var OneYear=DateOne.substr(0,4);
		        var OneMonth=DateOne.substr(5,2);
		        var OneDay=DateOne.substr(8,2);
	
						var cha = ((Date.parse(OneMonth + '/' + OneDay
								+ '/' + OneYear) - Date.parse(TwoMonth
								+ '/' + TwoDay + '/' + TwoYear)) / 86400000);
						return cha;
					}
					//监听 提交按钮
					form.on('submit(sub)', function() {
					  var DateOne=$("#quit_time").val();
                      var time=daysBetween(DateOne);
                      
					 console.log(daysBetween(DateOne));//控制台输出
 
			/* 		 	if (time<0){
							layer.confirm('离职时间填写不正确', {
								icon : 2,
								title : '系统提示'
							},function(index) {
								layer.close(index);
								window.location.reload;
							});
						}else { */
							 
							$.ajax({
							type : "post",
							url : "staffApply/staff_quit?"
									+ $("#quitform").serialize(),
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
				/* 	}  */
						return false;
					});

		
				});
</script>
</html>