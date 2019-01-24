layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'positionManage/getPositionsBySE?field=salaryBase&order=asc',
		title : '职位表',
		cols : [ [ {
			field : 'position_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'position_msg',
			title : '描述',
			minWidth : 200
		}, {
			field : 'post_id',
			title : '职务ID',
			minWidth : 100,
			sort : true
		}, {
			field : 'post_name',
			title : '职务',
			minWidth : 100,
			sort : true
		}, {
			field : 'rank_level',
			title : '职级',
			minWidth : 100,
			sort : true
		}, {
			field : 'salaryBase',
			title : '岗位工资',
			minWidth : 100,
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 150
		} ] ],
		page : true
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
	
	//获取基本工资
	$.ajax({
		url : "company/getCompany",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			if (jsonData.code==100) {
				$('#salary-now').html('当前基本工资'+jsonData.data.salary_base);
			}
		},
		error:function(){
			layer.msg('连接失败');
		}
	});
	

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("position_name");
	filter.add("position_msg");
	filter.add("post_id");
	filter.add("post_name");
	filter.add("rank_level");
	filter.add("salaryBase");
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
			url : 'positionManage/getPositionsBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end


	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		if (obj.event === 'set') {
			 layer.prompt({title:'请输入岗位工资',maxlength: 8},function(value, index, elem){
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
						url : "positionManage/updateSalary?position_id="+data.position_id+"&salaryBase="+value,
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
	
	//设置基本工资
	$('#setting-salary-base').on('click',function(){
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			layer.prompt({title:'请输入基本工资',maxlength: 8},function(value, index, elem){
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
						url : "company/updateSalaryBase?salaryBase="+value,
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
		});
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
	};
	
	form.render();
	
});