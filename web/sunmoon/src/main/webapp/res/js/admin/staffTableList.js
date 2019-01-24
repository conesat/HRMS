layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	// 获取表格数据 getAddsBySE
	var fileTable="";
	var staff_state="";// 职员状态
	var staff_type="";// 职员类型
	var checkDep="";
	var key='';
	
	var myTable = table.render({
		elem : '#myTable',
		url : 'staffManage/getStaffsBySE',
		title : '员工表',
		cols : [ [ {
			field : 'staff_id',
			title : '工号',
			minWidth : 110,
			sort : true
		},  {
			field : 'staff_name',
			title : '名字',
			minWidth : 130,
			sort : true
		}, {
			field : 'staff_sex',
			title : '性别',
			minWidth : 100,
			sort : true
		}, {
			field : 'work_address_name',
			title : '上班地点',
			minWidth : 100,
			sort : true
		}, {
			field : 'department_name',
			title : '部门',
			minWidth : 100,
			sort : true
		}, {
			field : 'position_name',
			title : '职位',
			minWidth : 100,
			sort : true
		}, {
			field : 'staff_phone',
			title : '电话',
			width : 160,
			sort : true
		},{
			field : 'staff_state',
			title : '状态',
			minWidth : 100,
			templet: '#stateTpl',
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
	table.on('sort(table)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
		table.reload('table', {
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
	filter.add("staff_id");
	filter.add("staff_name");
	filter.add("work_address_name");
	filter.add("position_name");
	filter.add("staff_phone");
	filter.add("staff_state");
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
		table.reload('myTable', {
			url : 'staffManage/getStaffsBySE?key=' + key + '&filter=' + Array.from(filter)+"&department_id="+checkDep,
		});
	}
	// 搜索工具 end

	// 监听提交
	form.on('submit(check-apply)', function(data) {
		
		$.ajax({
			type : "post",
			url : "apply/getApplyCheckState?id="+opID,
			async : false,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					$.ajax({
						type : "post",
						url : "apply/checkApply?apply_id="+opID+"&"+ $("#apply-form").serialize(),
						async : false,
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
					
				}else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

			}
		});
		
		
		return false;
	});

	// 监听行工具事件
	table.on('tool(myTable)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			opID = data.staff_id;// 操作数据id
			
			var text='	<img layer-pid="" layer-src="file/getFile?path='+data.staff_idcard_picture_one+'" src="file/getFile?path='+data.staff_idcard_picture_one+'" alt="身份证正面" height="200">';
		
			text+='	<img layer-pid="" layer-src="file/getFile?path='+data.staff_idcard_picture_tow+'" src="file/getFile?path='+data.staff_idcard_picture_tow+'" alt="身份证反面" height="200">';

			text+='	<img layer-pid="" layer-src="file/getFile?path='+data.staff_person_picture+'" src="file/getFile?path='+data.staff_person_picture+'" alt="一寸照" height="200">';
			$('#layer-photos-demo').html(text);
			layer.photos({
				  photos: '#layer-photos-demo'
				  ,anim: 5 // 0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
				}); 
			
			
			$('#staff_id').html(data.staff_id);
			$('#staff_name').html(data.staff_name);
			$('#staff_sex').html(data.staff_sex);
			$('#staff_certificates_type').html(data.staff_certificates_type);
			$("#staff_certificates_number").html(data.staff_certificates_number);
			
			$('#staff_birthday').html(data.staff_birthday);
			$('#staff_education').html(data.staff_education);
			$('#staff_address').html(data.staff_address);
			$('#staff_email').html(data.staff_email);
			$("#staff_phone").html(data.staff_phone);
			$("#department_name").html(data.department_name);
			
			$('#position_name').html(data.position_name);
			$('#work_address_name').html(data.work_address_name);
			$('#staff_in_date').html(data.staff_in_date);
			$("#staff_state").html(data.staff_state);
			$("#staff_msg").html(data.staff_msg);
			$("#staff_marriage").html(data.staff_marriage);
			$("#staff_type").html(data.staff_type);
			
			
			form.render(); // 更新全部000
			
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			
			$('#examine-search-div').hide(); 
			$('#back').parent().show();
			
			staff_state=data.staff_state;
			staff_type=data.staff_type;
			
			$('#change-staff-base').show();
			$('#regular').show();
			$('#quit').show();
			$('#layui-btn-group').show();
			if (data.staff_type=='正式员工') {
				 $('#regular').hide();
			}
			if(data.staff_state=='已离职'){
				 $('#change-staff-base').hide();
				 $('#layui-btn-group').hide();
			}else if(data.staff_state=='待入职'){
				 $('#quit').hide();
			}

			fileTable=table.render({
				elem : '#upload-table',
				url : 'staffManage/getStaffContractByStaffId?id='+data.staff_id,
				title : '职位表',
				cols : [ [ {
					field : 'contract_name',
					title : '合同名称',
					minWidth:200,
					sort : true
				},{
					field : 'start_time',
					title : '开始日期',
					minWidth:200,
					sort : true
				},{
					field : 'end_time',
					title : '结束日期',
					minWidth:200,
					sort : true
				},{
					field : 'state',
					title : '合同状态',
					minWidth:200,
					sort : true
				},{
					field : 'change_msg',
					title : '变更备注',
					minWidth:200,
					sort : true
				}, {
					title : '操作',
					toolbar : '#opreationBarContract',
					width : 120,
					fixed: 'right'
				} ] ]
			});
		}
	});
	
	// 监听行工具事件
	table.on('tool(upload-table)', function(obj) {
		var data = obj.data;
		var url=data.contract_url;
		var name=data.staff_id+data.contract_name+data.start_time+"至"+data.end_time;
		if (obj.event === 'edit') {
			$.ajax({
				url : "file/verifyFile?path="+url,
				type : "get",
				success : function(data) {
					var jsonData=JSON.parse(data);
					if (jsonData.code==100) {
						 layer.open({
						      type: 2,
						      title: '查看文件',
						      shadeClose: true,
						      shade: false,
						      maxmin: true, // 开启最大化最小化按钮
						      area: ['893px', '600px'],
						      maxmin: true,
						      content: 'file/getFile?path='+url
						 });
					}else {
						layer.confirm('不支持浏览的文件是否下载？', function(index){
							  window.location.href="file/downLoadFile?path="+url+"&fileName="+name;
							  layer.close(index);
						});   
					}
				}
			});
			
		}else if (obj.event === 'download') {
			  window.location.href="file/downLoadFile?path="+url+"&fileName="+name;
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
	
	// 编辑职员基本信息
	$('#change-staff-base').on('click',function(){
		layer.open({
			  type: 2,
			  title: '修改职员'+opID+'信息',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['90%', '80%'],
			  content: 'staffManage/gotoJsp?id='+opID+"&jsp=changeStaffBasePage"
			}); 
	});
	
	
	// 转正
	$('#regular').on('click',function(){
		if (staff_type!='正式员工') {
			if (staff_state=='待入职') {
				layer.confirm('该职员尚未入职，转正将自动入职，是否继续?', {icon: 3, title:'提示'}, function(index){
					changeStaff("staffManage/regularStaff?id="+opID);
					layer.close(index);
				});
			}else {
				changeStaff("staffManage/regularStaff?id="+opID);
			}
		}else{
			layer.msg("执行操作异常");
		}
	});
	
	// 离职
	$('#quit').on('click',function(){
		if (staff_state=='在职') {
			changeStaff("staffManage/quitStaff?id="+opID);
		}else {
			layer.msg("该员工非在职员工，无法操作！");
		}
	});
	
	// 调动
	$('#transfer').on('click',function(){
		layer.open({
			  type: 2,
			  title: '调动'+opID+'职员',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['90%', '80%'],
			  content: 'staffManage/gotoJsp?id='+opID+"&jsp=transferStaffPage"
			}); 
	});
	
	// 合同变更
	$('#change-staff-contract').on('click',function(){
		layer.open({
			  type: 2,
			  title: ''+opID+'职员合同变更',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['90%', '80%'],
			  content: 'staffManage/gotoJsp?id='+opID+"&jsp=changeStaffContract"
			}); 
	});
	
	//重置密码
	$('#reset-password').on("click",function(){
		changeStaff("staffManage/resetPassword?staff_id="+opID);
	});
	
	
	function changeStaff(url) {
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			if (varifyPass(value)) {
				
				$.ajax({
					type : "post",
					url : url,
					async : false,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							layer.confirm('已完成', {
								icon : 1,
								title : '提示'
							}, function(index) {
								layer.closeAll();
								window.location.href = window.location.href;
							});
						} else if (jsonData.code == 102) {
							layer.msg("访问受限,权限不足");
						}
					},
					error : function(jqObj) {

					}
				});
			}
		});
	}
	
	
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		myTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}
		
	};
	
	form.render();
	
});
