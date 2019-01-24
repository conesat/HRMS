layui.use([ 'table', 'jquery', 'form', 'element', 'laydate' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var element = layui.element;
	var laydate = layui.laydate;
	var data={};
	var dataSet=new Set();
	var choiceMonth='';
	var type=0;
	var nowDate=new Date();
	var nowMonth=nowDate.getFullYear()+"-"+(nowDate.getMonth()+2);
	nowDate=nowDate.getFullYear()+"-"+(nowDate.getMonth()+1)+"-"+nowDate.getDate();
	// 获取表格数据 getAddsBySE
	var seTable = table.render({
		elem : '#schedule',
		url : 'checkManage/getSchedulingBySE',
		title : '职位表',
		cols : [ [ {
			field : 'month',
			title : '月份',
			minWidth : 100,
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 120,
			fixed : 'right'
		} ] ],
		page : true
	});
	
	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("month");

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
	// 开始查询
	function searchAdd(key) {
		$("#filter-ul-div").fadeOut();
		table.reload('schedule', {
			url : 'checkManage/getSchedulingBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end
	

	// 监听提交
	form.on('submit(check-month-submit)', function(data) {
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			if (varifyPass(value)) {
				var url="";
				if(type==0){
					url="checkManage/addScheduling?month="+choiceMonth+"&dates="+Array.from(dataSet);
				}else{
					url="checkManage/update?month="+choiceMonth+"&dates="+Array.from(dataSet);
				}
				$.ajax({
					type : "post",
					url : url,
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
						}else if(jsonData.code == 101){
							layer.msg("该月份已有排班");
						}
					},
					error : function(jqObj) {

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

	function loadingDate(val) {
		$('#date').html('');
		let obj= Object.create(null);
		for (var x of dataSet) { // 遍历Set
			 obj[x] = "";
		}
	
		data=obj;
			  
		if (val=="") {
			val=nowMonth+'-01';
		}
	
		laydate.render({
			elem : '#date',
			position : 'static',
			mark:data,
			value:val,
			min: nowDate,
			isInitValue: false,
			showBottom: false,
			done: function(value, date){
				if(dataSet.size==0){
					choiceMonth=date.year+"-"+date.month;
					dataSet.add(value,"");
					loadingDate(value);
				}else if(choiceMonth!=date.year+"-"+date.month){
					layer.msg("只能选择同月份的");
				} else {
					if(dataSet.has(value)){
						dataSet.delete(value);
					}else{
						dataSet.add(value);
					}
				
					loadingDate(value);
				}
				
		    }
		});
	}
	
	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		var oDate1 = new Date(nowDate);
		var oDate2 = new Date(data.month+"-01");
		 if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			$('#reset').html('放弃更改');
			choiceMonth = data.month;// 操作数据id
			dataSet=new Set(data.dates.split(","));
			loadingDate(choiceMonth+"-01");
		}else if(obj.event === 'del'){
			if(oDate1.getYear()==oDate2.getYear()&&oDate1.getMonth()==oDate2.getMonth()){
				layer.msg("无法删除该月份");
			}else{
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
							url : "checkManage/del?month="+data.month,
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
								}else {
									layer.msg("未知错误");
								}
							},
							error : function(jqObj) {

							}
						});
					}
				});
			}
		}
	});
	
	$('#reset').on('click',function(){
		type=0;
		dataSet.clear();
		loadingDate("");
		$('#check-month-submit').show();
		$('#reset').html('重置');
	});
	
	loadingDate("");
	
});