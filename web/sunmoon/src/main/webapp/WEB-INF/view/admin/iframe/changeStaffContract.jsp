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
					<h2 class="div-title">职员：${staff.staff_name} 合同变更</h2>
				</div>
				<div class="layui-card-body">
					<form class="layui-form" id='transfer-form'>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>变更形式 </label>
								<div class="layui-input-block">
									<select name=changeType id="change_type"
										lay-verify="required" lay-search>
										<option value="">请选择</option>
										<option value="0">替换原合同-原合同将失效</option>
										<option value="1">追加-当前合同过期后自动生效</option>
									</select>
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>起始日期 </label>
								<div class="layui-input-block">
									<input type="text" class="layui-input" id="contract_start_date"
										placeholder="yyyy-MM-dd" lay-verify="required" 
										readonly="readonly">
								</div>
							</div>
						</div>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>合同类型 </label>
								<div class="layui-input-block">
									<select id="contract_id"
										lay-verify="required">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item">
									<label class="layui-form-label"><a style="color: red;">*
									</a>变更事由</label>
									<div class="layui-input-block">
										<input type="text" name="change_msg" id='change_msg'
											required 
											lay-verify="required" placeholder="请输入" autocomplete="off"
											class="layui-input">
									</div>
								</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>合同电子档</label>
								<div class="layui-input-block">
									<div class="layui-upload-drag" id="contract">
										<i class="layui-icon"></i>
										<p>点击上传，或将文件拖拽到此处</p>
									</div>
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<fieldset class="layui-elem-field layui-field-title">
								<legend>反馈给用户的信息</legend>
							</fieldset>
						    <div class="layui-form-item">
						    	<div class="layui-input-block" style="margin-left: 0px;">
						      		<input type="checkbox" id="email-msg" title="邮箱通知" checked>
						      		<input type="checkbox" id="sys-msg" title="系统信息通知" checked>
						    	</div>
						    </div>
							<div class="layui-form-item">
								<label class="layui-form-label">信息标题</label>
								<div class="layui-input-block">
									<input type="text" name="msg_title" id='msg_title' lay-verify="myMsgType"
										required value="合同变更信息"
										placeholder="请输入" autocomplete="off"
										class="layui-input">
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">信息内容 </label>
								<div class="layui-input-block"> 
									<textarea name="msg_body" id='msg_body' placeholder="请输入内容" lay-verify="myMsgType"
										class="layui-textarea"></textarea>
								</div>
							</div>
						</div>
						<div class="layui-form-item my-form-item" id="submit-button">
							<div class="layui-btn-group">
								<button class="layui-btn my-button" lay-submit
									lay-filter="transfer-staff" id="transfer-staff">完成</button>
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
		layui.use([ 'element', 'jquery', 'form', 'laydate','upload' ], function() {
			var element = layui.element;
			var $ = jQuery = layui.jquery;
			var form = layui.form;
			var laydate = layui.laydate;
			var upload = layui.upload;
			var staff_id = '${staff.staff_id}';
			var email = '${staff.staff_email}';
			var msgType=2;//判断是否反馈信息必填
			var cont="";//是否选择合同
			console.log(email);
			//多选事件
			form.on('checkbox()', function(data){
				if (data.elem.checked) {
					msgType++;
				}else {
					msgType--;
				}
				console.log($('#email-msg').prop('checked'));
			});       
			
			//表单验证
			form.verify({
				myMsgType: function(value, item){ //value：表单的值、item：表单的DOM对象
				    if(msgType>0 && value==''){
				      return '反馈该项必填';
				    }
				 }
			});  
			
			//起始日期
			laydate.render({
				elem : '#contract_start_date'
			});
			
			// 获取合同类型
			$.ajax({
				url : "../contractManage/getAllContractIdName",
				type : "get",
				success : function(data) {
					var jsonData=JSON.parse(data);
					var op="<option value=''>请选择合同</option>";
					for(var x in jsonData.data){
						op+="<option value='"+jsonData.data[x].contract_id+"'>"+jsonData.data[x].contract_name+"</option>";
					}
					$("#contract_id").html(op);
					form.render("select");
				}
			});
			
			var load;
	
			// 监听提交
			form.on('submit(transfer-staff)', function(data) {
				var msg_type="";
				if (cont=='') {
					layer.msg("请上传合同！");
					return false;
				}
				
				if ($('#email-msg').prop('checked')) {
					msg_type="email";
				}
				if ($('#sys-msg').prop('checked')) {
					msg_type+="sys";
				}
				layer.prompt({
					formType : 1,
					value : '',
					title : '验证密码',
					maxlength : 20,
				}, function(value, index, elem) {
					layer.close(index);
					if (varifyPass(value)) {
						
						
						load= layer.open({
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
									url : "changeStaffContract?" + $("#transfer-form").serialize()
											+ "&staff_id=" + staff_id+"&msg_type="+msg_type+"&email="+email,
									async : true,
									success : function(data) {
										var jsonData = JSON.parse(data);
										if (jsonData.code == 100) {
											contract.upload();
											
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
			
			//上传合同
			 var contract=upload.render({
			    elem: '#contract'
			    ,url: 'uploadContract'
			    ,auto: false
			    ,accept:'file'
			    ,before: function(obj){
			    	var state="";
			    	if ($('#change_type').val()==0) {
			    		state="0";
					}else{
						state="1";
					}
			    	this.data={"staff_id":staff_id,"contract_id":$('#contract_id').val(),"start_time":$('#contract_start_date').val(),"state":state}
			      }
			 	,choose: function(obj){ 
					cont="yes";
					obj.preview(function(index, file, result){
				        $('#contract').html('<i class="layui-icon">&#xe605</i><p >已选择文件：'+file.name+"</p>");
				    });
				} ,done: function(res, index, upload){ //每个文件提交一次触发一次。详见“请求成功的回调”
					layer.close(load); 
					layer.confirm('已完成', {
						icon : 1,
						title : '提示'
					}, function(index) {
						layer.closeAll();
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭  
						parent.location.reload();
					});
			    },error: function(index, upload){
			    	layer.confirm('上传失败，是否重新尝试?', function(index){
			    		uploadContract.upload();
			    		layer.close(index);
			    	});     
			    }
			  });
		});
	</script>
</body>

</html>