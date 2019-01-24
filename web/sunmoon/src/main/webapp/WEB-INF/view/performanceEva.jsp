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
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon" />
<style type="text/css">
.layui-rate {
	padding: 0px;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<div class="layui-body" id='body-div'
			style="padding: 15px; left: 0px; display: flex; top: 0px;">
			<div class="layui-col-xs12 layui-col-md12 layui-col-lg11"
				style="margin: 0 auto;">
				<div class="layui-card">
					<div class="layui-card-header">
						<h2>绩效评估</h2>
					</div>
					<div class="layui-card-body">
						<div>
							<table class="layui-hide" id="table" lay-filter="table"></table>
						</div>
						<div align="right">
							<button class="layui-btn">提交</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/html" id="opreationBar">
  <input style='width:90px;border:none;line-height: 28px;' value='100'/>
</script>



	<script src="layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'rate', 'table', 'jquery' ], function() {
			var rate = layui.rate;
			var table = layui.table;
			var $ = jQuery = layui.jquery;
			table.render({
				elem : '#table',
				url : 'staffManage/getStaffByDepId',
				title : '',
				cols : [ [ {
					field : 'staff_id',
					title : '工号',
					minWidth : 100,
					sort : true
				}, {
					field : 'staff_name',
					title : '姓名',
					minWidth : 100,
					sort : true
				}, {
					field : 'position_name',
					title : '职位',
					minWidth : 200
				}, {
					title : '绩效0-100',
					toolbar : '#opreationBar',
					width : 120
				} ] ],
				page : true
			});

		});
	</script>

</body>
</html>