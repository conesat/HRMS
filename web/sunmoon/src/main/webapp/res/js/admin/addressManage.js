layui.use([ 'table', 'jquery', 'form' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	// 百度地图API功能
	var map = new BMap.Map("allmap"); // 创建Map实例
	// 获取表格数据 getAddsBySE
	var addressTable = table.render({
		elem : '#address',
		url : 'workAddress/getAddsBySE',
		toolbar : '#toolBar',
		title : '上班地点',
		cols : [ [ {
			type : 'checkbox',
			fixed : 'left'
		}, {
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
	
	// 排序事件
	table.on('sort(address)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
		table.reload('address', {
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
	
	// 监听提交
	form.on('submit(addAddress)', function(data) {
		var url = "";
		if (type == 1) {
			url = "workAddress/updateAddress?"
					+ $("#add-address-form").serialize() + "&work_address_id="
					+ opID;
		} else {
			url = "workAddress/addAddress?"
					+ $("#add-address-form").serialize();
		}
		$.ajax({
			type : "post",
			url : url,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					layer.confirm('已完成', {
						icon : 1,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = window.location.href;
					});
				} else if (jsonData.code == 101) {
					layer.confirm('身份已过期，请重新登录', {
						icon : 2,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = "gotoLogin";
					});
				} else if (jsonData.code == 102) {
					layer.msg("访问受限，权限不足");
				} else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

			}
		});
		return false;
	});
	
	// 头工具栏事件
	table.on('toolbar(address)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'delChecked':
			var data = checkStatus.data;
			layer.prompt({
				formType : 1,
				value : '',
				title : '验证密码',
				maxlength : 20,
			}, function(value, index, elem) {
				layer.close(index);
				if (varifyPass(value)) {
					var ids = new Array();
					for ( var x in data) {
						ids[x] = data[x].work_address_id;
					}
					delAdds(ids);
				}
			});
			break;
		}
		;
	});

	// 监听行工具事件
	table.on('tool(address)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.prompt({
				formType : 1,
				value : '',
				title : '验证密码',
				maxlength : 20,
			}, function(value, index, elem) {
				layer.close(index);
				if (varifyPass(value)) {
					delAdds(data.work_address_id);
				}
			});
		} else if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			opID = data.work_address_id;// 操作数据id
			$('#xy').val(data.work_address_xy);
			$('#name').val(data.work_address_name);
			$('#add-change').html('修改');
			map.clearOverlays(); // 清除地图上所有覆盖物
			var pp = new BMap.Point(data.work_address_xy.split(",")[0],
					data.work_address_xy.split(",")[1]);
			map.centerAndZoom(pp, 20);
			map.addOverlay(new BMap.Marker(pp)); // 添加标注
			map.panBy($('#addAddress-content').width(), 200);// 调整偏移量否则显示在左上角
			$("#table").slideUp('', function() {
				$("#addAddress-content").slideDown();
			});
		}
	});

	// 批量删除地址
	function delAdds(ids) {
		$.ajax({
			type : "post",
			url : "workAddress/delAddress?ids=" + ids,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == '100') {
					layer.msg('已完成', {
						icon : 1,
						time : 2500
					}, function() {
						window.location.reload();
					});
				} else if (jsonData.code == 102) {
					layer.msg("访问受限，权限不足");
				} else {
					layer.msg("未知错误", {
						icon : 2
					});
				}
			},
			error : function(jqObj) {

			}
		});
		return false;
	}

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
		table.reload('address', {
			url : 'workAddress/getAddsBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end
	// 添加按钮点击事件
	$('#add-address').on('click', function() {
		// 添加方法
		type = 0;
		$('#xy').val("");
		$('#name').val("");
		$('#add-change').html('添加');
		map.clearOverlays(); // 清除地图上所有覆盖物
		$("#table").slideUp('', function() {
			$("#addAddress-content").slideDown();
		});
	});

	// 返回按按钮点击事件
	$('#back').on('click', function() {
		$("#addAddress-content").slideUp('', function() {
			$("#table").slideDown();
		});
	});

	// 重载表格 防止拉伸
	window.reloadTable = function() {
		addressTable.reload();
	};

	// 百度地图API功能
	map.centerAndZoom('柳州', 15); // 初始化地图,设置中心点坐标和地图级别
	// 添加地图类型控件
	map.addControl(new BMap.MapTypeControl({
		mapTypes : [ BMAP_NORMAL_MAP, BMAP_HYBRID_MAP ]
	}));
	map.setCurrentCity("柳州"); // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
	// 单击获取点击的经纬度
	map.addEventListener("click", function(e) {
		map.clearOverlays(); // 清除地图上所有覆盖物
		map.addOverlay(new BMap.Marker(e.point)); // 添加标注
		$('#xy').val(e.point.lng + "," + e.point.lat);
	});

	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}

	var ac = new BMap.Autocomplete( // 建立一个自动完成的对象
	{
		"input" : "suggestId",
		"location" : map
	});

	ac.addEventListener("onhighlight", function(e) { // 鼠标放在下拉列表上的事件
		var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province + _value.city + _value.district
					+ _value.street + _value.business;
		}
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = "
				+ value;

		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province + _value.city + _value.district
					+ _value.street + _value.business;
		}
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = "
				+ value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) { // 鼠标点击下拉列表后的事件
		var _value = e.item.value;
		myValue = _value.province + _value.city + _value.district
				+ _value.street + _value.business;
		G("searchResultPanel").innerHTML = "onconfirm<br />index = "
				+ e.item.index + "<br />myValue = " + myValue;

		setPlace();
	});

	function setPlace() {
		map.clearOverlays(); // 清除地图上所有覆盖物
		function myFun() {
			var pp = local.getResults().getPoi(0).point; // 获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			map.addOverlay(new BMap.Marker(pp)); // 添加标注
		}
		var local = new BMap.LocalSearch(map, { // 智能搜索
			onSearchComplete : myFun
		});
		local.search(myValue);
	}
	form.render('checkbox');
});