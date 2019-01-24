layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var element = layui.element;
	var key="";
	var checkDep='';
	
	
	var myTable = table.render({
		elem : '#myTable',
		url : 'performance/getStaffPerformanceBySe',
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
		}, {
			field : 'performance',
			title : '绩效',
			minWidth : 100,
			sort : true
		},{
			title : '操作',
			toolbar : '#opreationBar',
			width : 80,
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
	

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("staff_id");
	filter.add("staff_name");
	filter.add("work_address_name");
	filter.add("department_name");
	filter.add("position_name");
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
	
	$('#start_performace').on('click', function() {
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
					url : "staffManage/startPerformance",
					async : false,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							layer.msg("已发起绩效评估,等待职员完成评估", {
								icon : 1
							});
						}else {
							layer.msg("未知错误", {
								icon : 2
							});
						}
					},
					error : function(jqObj) {

					}
				});
			}
		});
		
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
			url : 'performance/getStaffPerformanceBySe?key=' + key + '&filter=' + Array.from(filter)+"&department_id="+checkDep,
		});
	}
	// 搜索工具 end

	// 监听行工具事件
	table.on('tool(myTable)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			 layer.prompt({title:'请输入绩效',maxlength: 8},function(value, index, elem){
				  var point=false;
				  layer.close(index);
				   for(i=0;i<value.length;i++)  {
					  if(value.charAt(i) == '.'){
						  if(point){
							  layer.msg('非法数值');
							  return;
						  }else{
							  point=true;
						  }
					  }else  if ((value.charAt(i)<"0" || value.charAt(i)>"9")){
					      layer.msg('非法数值'+point);
					      return;
				        }
				   }
				  $.ajax({
						url : "performance/settlementStaffPerformance?staff_id="+data.staff_id+"&performance="+value,
						type : "post",
						success : function(data) {
							var jsonData=JSON.parse(data);
							if (jsonData.code==100) {
								layer.msg('已提交', {
									icon : 1,
									time : 2500
								}, function() {
									window.location.reload();
								});
							}else {
								layer.msg('异常');  
							}
						},
						error:function(){
							layer.msg('连接失败');
						}
					});
				  
			});
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
		myTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}
		
	};
	
	form.render();
	
});
