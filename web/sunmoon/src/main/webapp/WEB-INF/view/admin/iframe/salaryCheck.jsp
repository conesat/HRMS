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
</head>
<body class="layui-layout-body" style="background: #fff;">
	<div class="layui-layout layui-layout-admin">

		<div class="layui-body" id='body-div'
			style="left: 0px; top: 0px; bottom: 0px; padding: 20px;">
			<div class="layui-card">
				<div class="layui-card-body">
					<fieldset class="layui-elem-field layui-field-title">
						<legend>职员情况</legend>
						<div class="layui-field-box">
							<table class="layui-table">
								<thead>
									<tr>
										<th lay-data="{align:'center'}">工号</th>
										<th lay-data="{align:'center'}">姓名</th>
										<th lay-data="{align:'center'}">部门</th>
										<th lay-data="{align:'center'}">职位</th>
										<th lay-data="{align:'center'}">工作地址</th>
										<th lay-data="{align:'center'}">入职日期</th>
										<th lay-data="{align:'center'}">工龄(单位年)</th>
									</tr>
									<tr>
										<th lay-data="{align:'center'}">${staff.staff_id}</th>
										<th lay-data="{align:'center'}">${staff.staff_name}</th>
										<th lay-data="{align:'center'}">${staff.department_name}</th>
										<th lay-data="{align:'center'}">${staff.position_name}</th>
										<th lay-data="{align:'center'}">${staff.work_address_name}</th>
										<th lay-data="{align:'center'}">${staff.staff_in_date}</th>
										<th lay-data="{align:'center'}">${workYear}</th>
									</tr>
								</thead>
							</table>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>上月考勤情况</legend>
						<div class="layui-field-box">
							<table class="layui-table">
								<thead>
									<tr>
										<th lay-data="{align:'center'}">旷工天数</th>
										<th lay-data="{align:'center'}">迟到次数</th>
										<th lay-data="{align:'center'}">早退次数</th>
										<th lay-data="{align:'center'}">请假天数</th>
										<th lay-data="{align:'center'}">实际出勤天数</th>
										<th lay-data="{align:'center'}">理应出勤天数</th>
									</tr>
									<tr>
										<th lay-data="{align:'center'}">${monthCheck.absence}</th>
										<th lay-data="{align:'center'}">${monthCheck.late}</th>
										<th lay-data="{align:'center'}">${monthCheck.early}</th>
										<th lay-data="{align:'center'}">${monthCheck.staff_leave}</th>
										<th lay-data="{align:'center'}">${monthCheck.attendance}</th>
										<th lay-data="{align:'center'}">${monthCheck.attendance_need}</th>
									</tr>
								</thead>
							</table>
						</div>
					</fieldset>
					
					<fieldset class="layui-elem-field layui-field-title">
						<legend>工资详情</legend>
						<div class="layui-field-box">
							<table class="layui-table">
								<thead>
									<tr>
										<th lay-data="{align:'center'}">基本工资</th>
										<th lay-data="{align:'center'}">岗位工资</th>
										<th lay-data="{align:'center'}">年限工资</th>
										<th lay-data="{align:'center'}">绩效工资</th>
										<th lay-data="{align:'center'}">奖惩工资</th>
										<th lay-data="{align:'center'}">五险一金</th>
										<th lay-data="{align:'center'}">个人所得税</th>
										<th lay-data="{align:'center'}">总计</th>
									</tr>
									<tr>  
										<th lay-data="{align:'center'}" id='base-pay'>${risksGold.base_pay}</th>
										<th lay-data="{align:'center'}" id='post-pay-val'>${risksGold.post_pay}</th>
										<th lay-data="{align:'center'}" id='year-pay-val'>${risksGold.year_pay}</th>
										<th lay-data="{align:'center'}" id='achievements-val'>${risksGold.achievements}</th>
										<th lay-data="{align:'center'}" id='bonus-val'>${risksGold.bonus}</th>
										<th lay-data="{align:'center'}" id='deduction-val'>${risksGold.deduction}</th>
										<th lay-data="{align:'center'}" id='individual-income-tax-val'>${risksGold.individual_income_tax}</th>
										<th lay-data="{align:'center'}" id='all'></th>
									</tr>

								</thead>
							</table>
						</div>
					</fieldset>
					
					<fieldset class="layui-elem-field layui-field-title">
						<legend>调整项</legend>
						<div class="layui-field-box">
							<table class="layui-table">
								<thead>
									<tr>
										<th lay-data="{align:'center'}">奖惩工资</th>
										<th lay-data="{align:'center'}">个人所得税</th>
										<th lay-data="{align:'center'}" colspan="3">备注</th>
									</tr>
									<tr>
										<th lay-data="{align:'center'}"><input id='bonus'
											style="width: 100%; color: #158456; background: #f2f2f2; border: none;"
											maxlength="10" value="${risksGold.bonus}" /></th>
										<th lay-data="{align:'center'}"><input
											id='individual-income-tax'
											style="width: 100%; color: #158456; background: #f2f2f2; border: none;"
											maxlength="10" value="${risksGold.individual_income_tax}" /></th>
										<th lay-data="{align:'center'}" style="height: 60px;"><textarea
												style="width: 100%; color: #158456; background: #f2f2f2; border: none; resize: none;" id='mypay_msg'
												maxlength="250">${risksGold.mypay_msg}</textarea></th>
									</tr>
								</thead>
							</table>
						</div>
					</fieldset>
				</div>

			</div>
			<div style="width: 100%;text-align: center;">
				<button id="save-check" type="button"
					class="layui-btn layui-btn-primary">保存核对结果</button>
			</div>
			
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="../res/js/jquery.qrcode.min.js"></script>
	<script type="text/javascript">
	layui.use([ 'element', 'jquery', 'form', 'table' ], function() {
		var element = layui.element;
		var $ = jQuery = layui.jquery;
		var form = layui.form;
		var table = layui.table;
		var staff_id='${staff.staff_id}';
		var msg='${msg}';
		var code='${checkCode}';
		console.log(code);
		if (code==0) {
			layer.open({
				  title: '提示'
				  ,content: '该职员薪资已被审核，无法再次修改'
			});    
			$('#mypay_msg').prop('disabled',true);
			$('#individual-income-tax').prop('disabled',true);
			$('#bonus').prop('disabled',true);
			$('#save-check').hide();
			
		}
		if(msg!=''){
			layer.open({
				  title: '提示'
				  ,content: msg
			});
		}
		$('.layui-table :input').bind(
				'input propertychange',
				function() {
					if ( $(this).attr('id') == 'mypay_msg'||code==0) {
						return;
					}
					console.log("dd");
					var point = false;
					var i = 0;
					if ($(this).val().length > 0) {
						if ($(this).val().charAt(i) == '-'
								&& $(this).attr('id') == 'bonus') {
							i = 1;
						}
						for (; i < $(this).val().length; i++) {
							if ($(this).val().charAt(i) == '.') {
								if (point) {
									console.log(1);
									layer.msg('非法数值');
									$(this).val(
											$(this).val().substring(0,
													$(this).val().length - 1));
									return;
								} else {
									point = true;
								}
							} else if (($(this).val().charAt(i) < "0" || $(this)
									.val().charAt(i) > "9")) {
								layer.msg('非法数值');
								console.log(2);
								$(this).val(
										$(this).val().substring(0,
												$(this).val().length - 1));
								return;
							}
						}
					}
					
					count();
				})
				
		function count() {
			var v1 = parseFloat($("#individual-income-tax").val());
			if (isNaN(v1)) {
				v1 = 0;
			}
			var v2 = parseFloat($("#bonus").val());
			if (isNaN(v2)) {
				v2 = 0;
			}
			var v3 = parseFloat($("#base-pay").html());
			if (isNaN(v3)) {
				v3 = 0;
			}
			var v4 = parseFloat($("#post-pay-val").html());
			if (isNaN(v4)) {
				v4 = 0;
			}
			var v5 = parseFloat($("#year-pay-val").html());
			if (isNaN(v5)) {
				v5 = 0;
			}
			var v6 = parseFloat($("#achievements-val").html());
			if (isNaN(v6)) {
				v6 = 0;
			}
			var v7 = parseFloat($("#deduction-val").html());
			if (isNaN(v7)) {
				v7 = 0;
			}
			$("#bonus-val").html(v2);
			$("#individual-income-tax-val").html(v1);
		    $("#all").html((v2+v3+v4+v5+v6-v7-v1).toFixed("2"));
		}
		
		$('#save-check').on('click',function(){
			if (code==0) {
				return;
			}
			var data="mypay_staff_id="+staff_id+"&base_pay="+$("#base-pay").html()
			+"&post_pay="+$("#post-pay-val").html()
			+"&year_pay="+$("#year-pay-val").html()
			+"&achievements="+$("#achievements-val").html()
			+"&bonus="+$("#bonus-val").html()
			+"&individual_income_tax="+$("#individual-income-tax-val").html()
			+"&deduction="+$("#deduction-val").html()
			+"&mypay_msg="+$("#mypay_msg").val()
			+"&actual_pay="+ $("#all").html();
			
			console.log(data);
			$.ajax({
				type : "post",
				url : "saveMonthSalaryCheck?" +data,
				async : false,
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.code == 100) {
						layer.confirm('已完成', {
							icon : 1,
							title : '提示'
						}, function(index) {
							layer.closeAll();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭  
							parent.location.reload();
						});
					} else if (jsonData.code == 101) {
						layer.msg('身份已过期，请重新登录', {
							icon : 2,
							time : 2500
						}, function() {
							window.location.href = "gotoLogin";
						});
					} else if (jsonData.code == 102) {
						layer.msg("权限不足");
					}
				},
				error : function(jqObj) {

				}
			});
			
		});
		
		count();

	});
	</script>
</body>

</html>