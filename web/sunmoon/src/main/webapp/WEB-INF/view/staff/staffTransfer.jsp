<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>调动申请</title>
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
	height: 610px;
	margin: 0 auto;
	background-color: #ffffff;
}

.backfather {
	width: 100%;
	height: 1000px;
	margin: 0 auto;
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
			<form class="layui-form" id="transferform" action=""
				lay-filter="example">
				<div class="backfather">
					<div class="back">
						<div style="margin-left: 250px">
							<legend style="font-weight: bold; font-size: 36px; margin: auto;">员工岗位调动申请表</legend>
						</div>

						<br> <br>
						<div class="layui-form-item">
							<label class="layui-form-label">姓 名</label>
							<div class="layui-input-block">
								<input name="transfer_staff_name" id="transfer_staff_name"
									class="layui-input" type="text" value="${staff.staff_name}"
									autocomplete="off" lay-verify="title" readonly="readonly"
									style="width: 200px"> <br>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">工 号</label>
								<div class="layui input-block">
									<input lay-verify="title" readonly="readonly"
										name="transfer_staff_id" id="transfer_staff_id"
										value="${staff_id}" class="layui-input" type="text"
										style="width: 200px">
								</div>

							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">现任部门</label>
								<div class="layui-input-block">
									<input name="transfer_position_name_old"
										id="transfer_department_name_old" class="layui-input"
										readonly="readonly" type="text" value="${staff.department_name}"  maxlength="10"
										autocomplete="off" lay-verify="title" style="width: 200px">
								</div>

								<div class="layui-input-block"
									style="float: right; margin-top: -40px; margin-right: 200px">
									<label class="layui-form-label" style="float: left;">现任岗位</label>
									<input name="transfer_position_name_old"
										id="transfer_department_name_old" class="layui-input" 
										readonly="readonly" type="text" value="${staff.position_name}"
										autocomplete="off" lay-verify="title" style="width: 200px">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">调入部门</label>
								<div class="layui-input-block">
									<input name="transfer_position_name_new"
										id="transfer_department_name_new" class="layui-input" maxlength="10"
										type="text" placeholder="请输入部门" autocomplete="off"
										lay-verify="title" style="width: 200px">
								</div>

								<div class="layui-input-block"
									style="float: right; margin-top: -40px; margin-right: 200px">
									<label class="layui-form-label" style="float: left;">新任岗位</label>
									<input name="transfer_position_name_new"
										id="transfer_department_name_new" class="layui-input"
										type="text" placeholder="请输入岗位" autocomplete="off"
										lay-verify="title" style="width: 200px">
								</div>
								<br>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">员工申请岗位调动原因自述</label>
									<div class="layui-input-block">
										<textarea name="transfer_msg" id="transfer_msg" maxlength="200"
											class="layui-textarea" placeholder="（包括申请调动的原因、对岗位的规划、建议）"></textarea>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">

									<div class="layui-input-block">
										<textarea style="border-style: none; height: 120px;" name=""
											class="layui-textarea" readonly="readonly"
											placeholder="备注：1、 员工的申请调动时间以主管领导的批准时间为准。
     &nbsp &nbsp &nbsp 2、 员工在原岗位工作未交接清楚，此审批单不予生效。
     &nbsp &nbsp &nbsp 3、 薪资标准按照新人岗位工资标准执行。
     &nbsp &nbsp &nbsp 4、 本申请表由申请人填写，并报相关部门核准。经核准后，报送行政部、财务部各一份存档。
     &nbsp &nbsp &nbsp 5、 经理级以上人员由日月公司签批，公司员工由公司总经理签批。"></textarea>
									</div>
								</div>



								<div style="margin-left: 300px">
									<button type="submit" name="sub" id="sub"
										class="layui-btn layui-btn-primary layui-btn-radius"
										lay-submit lay-filter="sub">提交</button>
								</div>
								<br>
								<div
									style="float: right; margin-right: 340px; margin-top: -57px;">
									<button type="reset"
										class="layui-btn layui-btn-primary layui-btn-radius">重置</button>
								</div>

									</div>
									</div>
									</div>
									</div>
				
			</form>

		</div>
	</div>

	<script>
		layui.use([ 'form', 'layedit', 'laydate', 'jquery' ],
						function() {
							var form = layui.form, layer = layui.layer,
							layedit = layui.layedit, 
							laydate = layui.laydate;
							var $ = jQuery = layui.jquery;

							//监听 提交按钮
							form.on('submit(sub)', function() {

								$.ajax({
									type : "post",
									url : "staffApply/staff_transfer?"
											+ $("#transferform").serialize(),
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
								return false;
							});

						});
	</script>
</body>

</html>