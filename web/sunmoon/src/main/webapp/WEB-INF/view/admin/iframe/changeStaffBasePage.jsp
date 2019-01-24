<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>日&月股份有限公司</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="../res/css/my.css">

<style>
.spinner {
  width: 60px;
  height: 60px;
 
  position: relative;
  margin: 20px;
}
 
.double-bounce1, .double-bounce2 {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background-color: #67CF22;
  opacity: 0.6;
  position: absolute;
  top: 0;
  left: 0;
   
  -webkit-animation: bounce 2.0s infinite ease-in-out;
  animation: bounce 2.0s infinite ease-in-out;
}
 
.double-bounce2 {
  -webkit-animation-delay: -1.0s;
  animation-delay: -1.0s;
}
 
@-webkit-keyframes bounce {
  0%, 100% { -webkit-transform: scale(0.0) }
  50% { -webkit-transform: scale(1.0) }
}
 
@keyframes bounce {
  0%, 100% {
    transform: scale(0.0);
    -webkit-transform: scale(0.0);
  } 50% {
    transform: scale(1.0);
    -webkit-transform: scale(1.0);
  }
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<div class="layui-body" id='body-div'
			style="left: 0px; top: 0px; bottom: 0px; padding: 20px;"
			align="center">
			<div class="layui-card">
				<div class="layui-card-header">
					<h2 class="div-title">修改职员：${staff.staff_name} 基本信息</h2>
				</div>
				<div class="layui-card-body">

					<form class="layui-form" id='add-form'>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>姓名</label>
								<div class="layui-input-block">
									<input type="text" name="staff_name" id='staff_name' required
										value="${staff.staff_name}" lay-verify="required"
										placeholder="请输入" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>性别</label>
								<div class="layui-input-block">
									<select name="staff_sex" id="staff_sex" lay-verify="required">
										<option value="">请选择</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>证件类型 </label>
								<div class="layui-input-block">
									<select name="staff_certificates_type"
										id="staff_certificates_type" lay-verify="required">
										<option value="">请选择</option>
										<option value="身份证">身份证</option>
										<option value="护照">护照</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>证件号</label>
								<div class="layui-input-block">
									<input type="text" name="staff_certificates_number"
										value="${staff.staff_certificates_number}"
										id='staff_certificates_number' required
										lay-verify="required|identity" placeholder="请输入"
										autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">生日</label>
								<div class="layui-input-block">
									<input type="text" class="layui-input" id="staff_birthday"
										value="${staff.staff_birthday}" name="staff_birthday"
										placeholder="yyyy-MM-dd" readonly="readonly">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">学历 </label>
								<div class="layui-input-block">
									<select name="staff_education" id="staff_education">
										<option value="">请选择</option>
										<option value="博士">博士</option>
										<option value="硕士">硕士</option>
										<option value="研究生">研究生</option>
										<option value="本科">本科</option>
										<option value="专科">专科</option>
										<option value="高中">高中</option>
										<option value="初中">初中</option>
										<option value="小学">小学</option>
										<option value="其他">其他</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">住址</label>
								<div class="layui-input-block">
									<input type="text" name="staff_address" id="staff_address"
										value="${staff.staff_address}" placeholder="请输入"
										autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">邮箱 </label>
								<div class="layui-input-block">
									<input type="text" name="staff_email" id="staff_email"
										value="${staff.staff_email}" placeholder="请输入"
										autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>


						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">婚否 </label>
								<div class="layui-input-block">
									<select name="staff_marriage" id="staff_marriage">
										<option value="">请选择</option>
										<option value="已婚">已婚</option>
										<option value="未婚">未婚</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>职员类型</label>
								<div class="layui-input-block">
									<input type="text" value="${staff.staff_type}"
										disabled="disabled" autocomplete="off" class="layui-input">
									
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>手机号</label>
								<div class="layui-input-block">
									<input type="text" name="staff_phone" id="staff_phone" required
										value="${staff.staff_phone}" lay-verify="required|phone"
										placeholder="请输入" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>部门 </label>
								<div class="layui-input-block">

									<input type="text" value="${staff.department_name}"
										disabled="disabled" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>职位 </label>
								<div class="layui-input-block">
									<input type="text" value="${staff.position_name}"
										disabled="disabled" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>工作地点 </label>
								<div class="layui-input-block">
									<select name="work_address_id" id="work_address_id"
										lay-verify="required">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>入职日期</label>
								<div class="layui-input-block">
									<input type="text" class="layui-input" id="staff_in_date"
										value="${staff.staff_in_date}" name="staff_in_date"
										placeholder="yyyy-MM-dd" readonly="readonly">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>状态</label>
								<div class="layui-input-block">
									
									<select name="staff_state" id="staff_state" lay-verify="required|staff_state">
										<option value="">请选择</option>
										<option value="待入职">待入职</option>
										<option value="在职">在职</option>
									</select>
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">备注 </label>
								<div class="layui-input-block">
									<textarea name="staff_msg" id='staff_msg' placeholder="请输入内容"
										class="layui-textarea">${staff.staff_msg}</textarea>
								</div>
							</div>
						</div>
						<div class="layui-form-item my-form-item" id="submit-button">
							<div class="layui-btn-group">
								<button class="layui-btn my-button" lay-submit
									lay-filter="add-staff" id="add-staff">更新</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use([ 'element', 'jquery', 'form', 'laydate' ], function() {
				var element = layui.element;
				var $ = jQuery = layui.jquery;
				var form = layui.form;
				var laydate = layui.laydate;
				var work_address_id = '${staff.work_address_id}';
				var staff_sex = '${staff.staff_sex}';
				var staff_certificates_type = '${staff.staff_certificates_type}';
				var staff_education = '${staff.staff_education}';
				var staff_id = '${staff.staff_id}';
				var staff_marriage = '${staff.staff_marriage}';
				var staff_state='${staff.staff_state}';
				//入职日期
				laydate.render({
					elem : '#staff_in_date',
					theme : '#0078d7'
				});
			
				//生日
				laydate.render({
					elem : '#staff_birthday',
					theme : '#0078d7'
				});
				$('#staff_state').val(staff_state);
				
				// 获取工作地址
				$.ajax({
					url : "../workAddress/getAddsIdName",
					type : "get",
					success : function(data) {
						var jsonData = JSON.parse(data);
						var op = "<option value=''>请分配部门</option>";
						for ( var x in jsonData.data) {
							op += "<option value='" + jsonData.data[x].work_address_id
									+ "'>" + jsonData.data[x].work_address_name
									+ "</option>";
						}
						$("#work_address_id").html(op);
						$("#work_address_id").val(work_address_id);
						$("#staff_sex").val(staff_sex);
						$("#staff_certificates_type").val(staff_certificates_type);
						$("#staff_education").val(staff_education);
						$("#staff_marriage").val(staff_marriage);
			
						form.render("select");
					}
				});
			
				// 监听提交
				form.on('submit(add-staff)', function(data) {
					layer.prompt({
						formType : 1,
						value : '',
						title : '验证密码',
						maxlength : 20,
					}, function(value, index, elem) {
						layer.close(index);
						if (varifyPass(value)) {
							
							var load= layer.open({
						        type: 1
						        ,title: false //不显示标题栏
						        ,closeBtn: false
						        ,area: ['100px','100px']
						        ,shade: 0.8
						        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
						        ,btnAlign: 'c'
						        ,moveType: 1 //拖拽模式，0或者1
						        ,content: '<div class="spinner">  <div class="double-bounce1"></div>  <div class="double-bounce2"></div> </div>'
						        ,success: function(layero, index){
						        	$.ajax({
										type : "post",
										url : "updateStaffBase?" + $("#add-form").serialize()
												+ "&staff_id=" + staff_id,
										async : false,
										success : function(data) {
											layer.close(load); 
											var jsonData = JSON.parse(data);
											if (jsonData.code == 100) {
												layer.confirm('已完成', {
													icon : 1,
													title : '提示'
												}, function(index) {
													//layer.closeAll();
													var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
													parent.layer.close(index); //再执行关闭  
													parent.location.reload();
												});
											} else if (jsonData.code == 102) {
												layer.msg("访问受限,权限不足");
											}
										},
										error : function(jqObj) {
											layer.close(load); 
										}
									});
						       }
							});
							
							
							
							
						}
					});
					return false;
				});
			
				// 验证账号密码
				function varifyPass(pass) {
					var re = false;
					$.ajax({
						type : "post",
						url : "../verifyStaff?staff_password=" + pass,
						async : false,
						success : function(data) {
							var jsonData = JSON.parse(data);
							if (jsonData.code == 100) {
								re = true;
							} else if (jsonData.code == 101) {
								layer.msg("密码验证不通过", {
									icon : 4
								});
							} else if (jsonData.code == 102) {
								layer.msg('身份已过期，请重新登录', {
									icon : 2,
									time : 2500
								}, function() {
									window.location.href = "gotoLogin";
								});
							} else {
								layer.msg("未知错误", {
									icon : 2
								});
							}
						},
						error : function(jqObj) {
			
						}
					});
					return re;
				}
		});
	</script>
</body>
</html>