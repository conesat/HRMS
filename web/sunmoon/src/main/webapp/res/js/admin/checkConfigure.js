layui.use([ 'table', 'jquery', 'form', 'element','laydate' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	var laydate = layui.laydate;
	// 获取表格数据 getAddsBySE
	var fileTable="";
	var postTable = table.render({
		elem : '#post',
		url : 'workAddress/getAddsBySE',
		title : '上班地点',
		cols : [ [{
			field : 'work_address_name',
			title : '地点',
			minWidth : 100,
			sort : true
		}, {
			field : 'work_address_xy',
			title : '坐标',
			minWidth : 100
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 150,
			fixed: 'right'
		} ] ],
		page : true
	});
	
	//上午时间范围
	laydate.render({
		elem : '#morning-time',
		type : 'time',
		range : '到'
	});
	
	//下午时间范围
	laydate.render({
		elem : '#afternoon-time',
		type : 'time',
		range : '到'
	});
	
	//晚上时间范围
	laydate.render({
		elem : '#night-time',
		type : 'time',
		range : '到'
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
	filter.add("work_address_name");
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
			searchAdd($("#serach-address-key").val());
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
	function searchAdd(key) {
		$("#filter-ul-div").fadeOut();
		table.reload('post', {
			url : 'recruitManage/getRecruitBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end
	
	form.verify({
		range: function(value, item){ //value：表单的值、item：表单的DOM对象
			if ($("#range_on")[0].checked && value=='') {
				return "请输入范围值";
			}
		  }
		  
	}); 

	// 监听提交
	form.on('submit(check-submit)', function(data) {
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			if (varifyPass(value)) {
				console.log($('#night-time').val()+" "+$('#night-time').val()!="");
				var timeDate="";
				if($('#morning-time').val()!=""){
					timeDate+="&morning_start="+$('#morning-time').val().split(' 到 ')[0];
					timeDate+="&morning_end="+$('#morning-time').val().split(' 到 ')[1];
				}else{
					timeDate+="&morning_start=";
					timeDate+="&morning_end=";
				}
				if($('#afternoon-time').val()!=""){
					timeDate+="&afternoon_start="+$('#afternoon-time').val().split(' 到 ')[0];
					timeDate+="&afternoon_end="+$('#afternoon-time').val().split(' 到 ')[1];
				}else{
					timeDate+="&afternoon_start=";
					timeDate+="&afternoon_end=";
				}
				if($('#night-time').val()!=""){
					timeDate+="&night_start="+$('#night-time').val().split(' 到 ')[0];
					timeDate+="&night_end="+$('#night-time').val().split(' 到 ')[1];
				}else{
					timeDate+="&night_start=";
					timeDate+="&night_end=";
				}
				
				$.ajax({
					type : "post",
					url : "workAddress/updateCheckSetting?work_address_id="+opID+"&"+$("#check-setting").serialize()+timeDate,
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
						}else if (jsonData.code == 102) {
							layer.msg("访问受限,权限不足");
						}
					},
					error : function(jqObj) {

					}
				});
			}
		});
		return false;
	});

	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			opID = data.work_address_id;// 操作数据id
			$('#work_address_name').html("地址名称："+data.work_address_name);
			$('#range_value').val(data.range_value);
			$('#wifi_mac').val(data.wifi_mac);
			
			$('#morning-time').val(data.morning_start+" 到 "+data.morning_end);
			$('#afternoon-time').val(data.afternoon_start+" 到 "+data.afternoon_end);
			$('#night-time').val(data.night_start+" 到 "+data.night_end);
			
			if (data.range_on=='on') {
				$('#range_on').prop('checked','checked');
			}
			if (data.wifi_on=='on') {
				$('#wifi_on').prop('checked','checked');
			}
			if (data.face=='on') {
				$('#face').prop('checked','checked');
			}
			if (data.finger=='on') {
				$('#finger').prop('checked','checked');
			}
			form.render("checkbox");
			
			form.render(); // 更新全部000
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			
			$('#examine-search-div').hide(); 
			$('#back').parent().show();
			
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
