<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的审批结果</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" href="res/css/index.css">
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">

</head>
<body>


	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>

		<div class="layui-body" id='body-div' style="padding: 20px;">
			<table class="layui-hide" id="test" lay-filter="test">
			</table>
		</div>

	</div>

	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/myApproval.js"></script>
	<script type="text/html" id="details">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="details">详情</a>
</script>


<script type="text/html" id="nameStateTpl">
  	{{#  if(d.apply_name === ''){}}
  		<span>招聘申请</span>
	{{#  } else  {  }}
	    <span>{{ d.apply_name }}</span>
    {{#  } }}
</script>

	<script type="text/html" id="stateTpl">
  {{#  if(d.check_state === '待审核'){ }}
    <span style="color: #b5b21e;">{{ d.check_state }}</span>
  {{#  } else if(d.check_state === '不通过') { }}
    <span style="color: #d82b2b;">{{ d.check_state }}</span>
 {{#  } else if(d.check_state === '已通过') { }}
    <span style="color: #20c12e;">{{ d.check_state }}</span>
  {{#  } }}
</script>
</body>
</html>