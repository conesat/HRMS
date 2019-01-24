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
	height: 510px;
	margin: 0 auto;
	background-color: #ffffff;
}

.backfather {
	width: 100%;
	height: 1000px;
	margin: 0 auto;
	background-color:#f4f4f4f4;
	padding-top: 20px;
}
</style>
</head>
<body>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>
		<div class="layui-body" id='body-div' style="left:0;">
			<form class="layui-form" action="" lay-filter="example" id="expenseform">
				<div class="backfather">
					<div class="back">
                        	<div style="margin-left:250px"> 
						<legend style="font-weight: bold; font-size: 36px; margin: auto;">费用报销申请表</legend>
						</div>
						<br>
						<br>
						<div class="layui-form-item">
							<label class="layui-form-label">姓 名</label>
							<div class="layui-input-block">
								<input name="expense_staff_name" id="expense_staff_name" value="${staff.staff_name}" readonly="readonly"
								class="layui-input" type="text" lay-verify="title"
									style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">工号</label>
								<input name="expense_staff_id" id="expense_staff_id" class="layui-input" type="text" 
									 lay-verify="title" value="${staff_id}"readonly="readonly"
									style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">所属部门</label>
							<div class="layui-input-block">
								<input name="expense_department" id="expense_department" class="layui-input" type="text" maxlength="10"
									value="${staff.department_name}" readonly="readonly" autocomplete="off" lay-verify="title"
									style="width: 200px">
							</div>

							<div class="layui-input-block"
								style="float: right; margin-top: -40px; margin-right: 200px">
								<label class="layui-form-label" style="float: left;">现任岗位</label>
								<input name="expense_post" id="expense_post" class="layui-input"  maxlength="10"
									 autocomplete="off" lay-verify="title" readonly="readonly" type="text" value="${staff.position_name}"
									style="width: 200px">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">费用类型</label>
							<div class="layui-input-block">
								<input name="ex"  value="交通费"    title="交通费" type="checkbox"  lay-skin="primary"> 
                                    <input name="ex" value="资料费"   title="资料费" type="checkbox"  lay-skin="primary"> 
                                     <input name="ex" value="补贴费"  title="补贴费" type="checkbox" lay-skin="primary"> 
                                     <input	name="ex"  value="交际费" title="交际费" type="checkbox" lay-skin="primary"> 
                                    <input name="ex"  value="其他"   title="其他" type="checkbox" lay-skin="primary">
							</div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">合计金额</label>
                                <div class="layui-input-block">
                                    <input name="expense_total_price" id="expense_total_price" class="layui-input" type="text" maxlength="10"
                                        placeholder="合计金额" autocomplete="off" lay-verify="title"onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')"
                                        style="width: 200px">
                                </div>
    
                                <div class="layui-input-block"
                                    style="float: right; margin-top: -40px; margin-right: 200px">
                                    <label class="layui-form-label" style="float: left;">应付金额</label>
                                    <input name="expense_actual_price" id="expense_actual_price" class="layui-input" type="text"  placeholder="实际应付金额" maxlength="10"
                                        autocomplete="off" lay-verify="title" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')"
                                        style="width: 200px">
                                </div>
                            </div>
							
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">备注</label>
								<div class="layui-input-block">
									<textarea name="expense_msg" id="expense_msg" style="width:600px;heit:130px" class="layui-textarea"
										placeholder="费用清单，以及费用的使用缘由"></textarea>
								</div>
							</div>
							

								<div class="layui-input-block">
									备注： 请如实填写费用详情，有虚报等行为，一经发现，后果自负。
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

				form.on('submit(sub)', function() {
					
					// 复选框集合。
			        var $areaId=$("input[type='checkbox'][name='ex']:checked").map(function(){  
		                return $(this).val();  
		            }).get().join(",");  
			      // 判断至少选择一个复选框
					if(!$areaId){
						layer.confirm('请至少选择一个报销类型', {
							icon : 2,
							title : '系统提示'
						}, function(index) {
							layer.close(index);
							window.location.reload;
						});
					}else {
  
 				   
               	 $.ajax({
						type : "post",
						url : "staffApply/staff_expense?"
								+ $("#expenseform").serialize()+"&expense_type="+$areaId,// 传值
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