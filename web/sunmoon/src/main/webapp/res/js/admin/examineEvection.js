layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	var fileTable="";
	var key="";
	var checkDep='';
	var postTable = table.render({
		elem : '#post',
		url : 'Audit/getEvectionBySE',
		title : '请假表',
		cols : [ [ {
			field : 'apply_name',
			title : '标题',
			minWidth : 100,
			sort : true
		}, {
			field : 'apply_staff_name',
			title : '申请人',
			minWidth : 130,
			sort : true
		},{
			field : 'apply_time',
			title : '申请时间',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_state',
			title : '状态',
			minWidth : 100,
			templet: '#stateTpl',
			sort : true
		}, {
			field : 'check_staff_name',
			title : '处理人',
			minWidth : 100,
			sort : true
		},{
			title : '操作',
			toolbar : '#opreationBar',
			width : 110,
			fixed: 'right'
		} ] ],
		page : true
	});
	
	// 获取部门
	$.ajax({
		url : "department/getAllMyOrgs",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			var op="<option value=''>全部可用部门</option>";
			for(var x in jsonData.data){
				op+="<option value='"+jsonData.data[x].department_id+"'>"+jsonData.data[x].department_name+"</option>";
			}
			$("#department_id").html(op);
			form.render("select");
		}
	});
	
	form.on('select(department_id)', function(data){
		//  console.log(data.value); //复选框value值，也可以通过data.elem.value得到
		  checkDep=data.value;
		  searchAdd();
	});   
	
	
	// 排序事件
	table.on('sort(post)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
		table.reload('post', {
			initSort : obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
			,
			where : { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
				field : obj.field // 排序字段
				,
				order : obj.type
			// 排序方式
			}
		});
	});
	

	// 返回按按钮点击事件
	$('#back').on('click', function() {
		$('#examine-search-div').show(); 
		$('#back').parent().hide();
		if($("#table").css('display')=='none'){
			$("#add-post-content").slideUp('', function() {
				$("#table").slideDown();
			});
		}
	});

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("apply_name");
	filter.add("apply_staff_id");
	filter.add("leave_type");
	filter.add("check_state");
	// 字段拦截按钮事件
	$('#filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 字段拦截收起按钮事件
	$('#close-filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 搜索按钮事件
	$('#search-i').on('click', function() {
		searchAdd($("#serach-address-key").val());
	});
	// 输入框回车事件
	$('#serach-address-key').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			key=$("#serach-address-key").val();
			searchAdd();
		}
	});
	// 查询字段修改事件
	form.on('checkbox(filter)', function(data) {
		if(data.elem.checked){
			filter.add(data.value);
		}else if (filter.size>1) {
			filter.delete(data.value);
		}else {
			layer.msg("至少选择一个");
			data.elem.checked=true;
			form.render('checkbox');
		}
	});
	// 开始查询
	function searchAdd() {
		$("#filter-ul-div").fadeOut();
		table.reload('post', {
			url : 'Audit/getEvectionBySE?key=' + key + '&filter=' + Array.from(filter)+"&department_id="+checkDep,
		});
	}
	// 搜索工具 end

	// 监听提交
	form.on('submit(check-apply)', function(data) {

		$.ajax({
			type : "post",
			url : "apply/getApplyCheckState?id="+opID,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				console.log(opID);
				if (jsonData.code == 100) {
					console.log("1111111111");
					$.ajax({
						type : "post",
						url : "Audit/updateApply?apply_id="+opID+"&"+ $("#apply-form").serialize(),
						async : true,
						success : function(data) {
					
							var jsonData = JSON.parse(data);
							if (jsonData.code == 100) {
								layer.msg('已完成', {
									icon : 1,
									time : 2500
								}, function() {
									window.location.reload();
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
							} else {
								layer.msg("未知错误");
							}
						},
						error : function(jqObj) {

						}
					});
					
				}else if(jsonData.code == 101){
					layer.confirm('处理人：'+jsonData.data.check_staff_name+'<br>处理结果：'+jsonData.data.check_state+'<br>处理时间：'+jsonData.data.check_time, {icon: 7, title:'申请已被处理'}, function(index){
						window.location.reload();
						  layer.close(index);
						}); 
				} else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

			}
		});
		
		
		return false;
	});

	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			opID = data.apply_id;// 操作数据id
		
			$('#apply_name').html(data.apply_name);
			$('#apply_staff_id').html(data.apply_staff_id);
			$('#apply_staff_name').html(data.apply_staff_name);
			$('#evection_acc').html(data.evection_acc);
			$('#evection_acc_position').html(data.evection_acc_position);
			$('#evection_start_time').html(data.evection_start_time);
			$('#evection_end_time').html(data.evection_end_time);
			$('#evection_path').html(data.evection_path);
			$('#evection_msg').html(data.evection_msg);			
			$('#evection_vehicle').html(data.evection_vehicle);
			$('#check_staff_name').html(data.check_staff_name);
			$('#check_msg').html(data.check_msg);
			$('#check_state').html(data.check_state);
			$('#check_time').html(data.check_time);
			form.render(); // 更新全部000
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			
			$('#examine-search-div').hide(); 
			$('#back').parent().show();
			
			if (data.check_state!='待审核') {
				$('#check-form-div').hide(); //不显示
			}else{
				$('#check-form-div').show(); //显示
			}

		}
	});
	


	// 验证账号密码
	function varifyPass(pass) {
		var re = false;
		$.ajax({
			type : "post",
			url : "verifyStaff?staff_password=" + pass,
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
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}
		
	};
	
	form.render();
	
});
