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
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<div class="layui-body" id='body-div'
			style="left: 0px; top: 0px; bottom: 0px; padding: 20px;"
			align="center">
			<div class="layui-card">
				<div class="layui-card-header">
					<h2 class="div-title">${title}</h2>
				</div>
				<div class="layui-card-body">
					<table class="layui-table">
						<thead>
							<tr>
								<th >申请ID</th>
								<th lay-data="{align:'center'}" colspan="2">${recruit.apply_id}</th>
								<th >申请人</th>
								<th lay-data="{{align:'center'}"  colspan="2">${recruit.apply_staff_name}</th>
								<th lay-data="{fixed: 'right',align: 'center'}" rowspan="4"><div id='qrcode' style="text-align: center;"></div></th>
							</tr>
							<tr>
								<th >申请标题</th>
								<th lay-data="{{align:'center'}" >${recruit.rel_rec_title}</th>
								<th >申请描述</th>
								<th lay-data="{{align:'center'}"  colspan="3">${recruit.rel_rec_desc}</th>
							</tr>
							<tr>
								<th >申请</th>
								<th lay-data="{{align:'center'}" >${recruit.apply_time}</th>
								<th >审核时间</th>
								<th lay-data="{{align:'center'}" >${recruit.check_time}</th>
								<th >审核人</th>
								<th lay-data="{{align:'center'}" >${recruit.check_staff_name}</th>
							</tr>
							<tr>
								<th >审核状态</th>
								<th lay-data="{{align:'center'}" >${recruit.check_state}</th>
								<th >审核反馈</th>
								<th lay-data="{{align:'center'}"  colspan="3">${recruit.check_msg}</th>
							</tr>
						</thead>
					</table>
				</div>

			</div>
			<button id="printer-start" type="button"
				class="layui-btn layui-btn-primary">打印凭条</button>
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="../res/js/jquery.qrcode.min.js"></script>
	<script type="text/javascript">
	var id='${recruit.apply_id}';
		$('#qrcode').qrcode({
		    render: "canvas",
		    width: 100,
		    height: 100,
		    text: encodeURI("ID:"+id)
		});
		layui.use([ 'element', 'jquery', 'form','table' ], function() {
			var element = layui.element;
			var $ = jQuery = layui.jquery;
			var form = layui.form;
			var table = layui.table;
			
			$("#printer-start").on('click',function(){
				$("#printer-start").hide();
				window.print();
				$("#printer-start").show();
			});
		});
		
		
		
	</script>
</body>

</html>