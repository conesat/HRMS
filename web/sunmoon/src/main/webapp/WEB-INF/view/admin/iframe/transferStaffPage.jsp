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
<link rel="stylesheet" href="../res/css/formSelects-v4.css">

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
					<h2 class="div-title">调动职员：${staff.staff_name}</h2>
				</div>
				<div class="layui-card-body">
					<form class="layui-form" id='transfer-form'>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>调入部门 </label>
								<div class="layui-input-block">
									<select name="department_id" id="department_id"
										lay-verify="required" lay-search>
										<option value="">请选择</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>调入职位 </label>
								<div class="layui-input-block">
									<select name="position_id" id="position_id"
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
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<fieldset class="layui-elem-field layui-field-title">
								<legend>完善公告信息</legend>
							</fieldset>
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>通报部门</label>
								<div class="layui-input-block">
									<select name="notice_department_id" xm-select="selectId" lay-verify="required">
									    <option value="">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>公告标题</label>
								<div class="layui-input-block">
									<input type="text" name="notice_title" id='notice_title' required value="职员：${staff.staff_name} 调动公告"
										lay-verify="required" placeholder="请输入" autocomplete="off"
										class="layui-input">
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>公告内容 </label>
								<div class="layui-input-block">
									<textarea name="notice_msg" id='notice_msg' placeholder="请输入内容" lay-verify="required"
										class="layui-textarea"></textarea>
								</div>
							</div>
						</div>
						<div class="layui-form-item my-form-item" id="submit-button">
							<div class="layui-btn-group">
								<button class="layui-btn my-button" lay-submit
									lay-filter="transfer-staff" id="transfer-staff">调动</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script type="text/javascript">
	//全局定义一次, 加载formSelects
    layui.config({
        base: '../layui/lay/mymodules/' //此处路径请自行处理, 可以使用绝对路径
    }).extend({
        formSelects: 'formSelects-v4'
    });
	layui.use([ 'element', 'jquery', 'form', 'laydate','formSelects' ], function() {
		var element = layui.element;
		var $ = jQuery = layui.jquery;
		var form = layui.form;
		var staff_id = '${staff.staff_id}';
		var position_id = '${staff.position_id}';
		var department_id = '${staff.department_id}';
		var work_address_id = '${staff.work_address_id}';
		var formSelects = layui.formSelects;
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
				form.render("select");
			}
		});
		
		// 获取职位
		$.ajax({
			url : "../positionManage/getAllPositionIdName",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var op="<option value=''>请分配职位</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].position_id+"'>"+jsonData.data[x].position_name+"</option>";
				}
				$("#position_id").html(op);
				$("#position_id").val(position_id);
				form.render("select");
			}
		});
		
		// 获取部门
		$.ajax({
			url : "../department/getAllMyOrgs",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var ARR=new Array();
				var op="<option value=''>请分配部门</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].department_id+"'>"+jsonData.data[x].department_name+"</option>";
					ARR[ARR.length]={'name':jsonData.data[x].department_name,'value':jsonData.data[x].department_id};
				}
				$("#department_id").html(op);
				$("#department_id").val(department_id);
				form.render("select");
				layui.formSelects.data('selectId', 'local', {
		            arr: ARR
		        });
			}
		});

		// 监听提交
		form.on('submit(transfer-staff)', function(data) {
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
								url : "transferStaff?" + $("#transfer-form").serialize()+"&staff_id="+staff_id,
								async : true,
								success : function(data) {
									layer.close(load); 
									var jsonData = JSON.parse(data);
									if (jsonData.code == 100) {
										layer.confirm('已完成', {
											icon : 1,
											title : '提示'
										}, function(index) {
											layer.closeAll();
											var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
											parent.layer.close(index); //再执行关闭  
											//parent.location.reload();
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