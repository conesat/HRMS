<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/admin/scheduling.css">
<style>
.layui-flow-more {
	display: inline-block;
	width: 100%;
	text-align: center;
}

.layui-flow-more a cite {
	background-color: rgba(0, 0, 0, 0);
	color: #a5a3a3;
}
</style>
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"
	style="height: 100%; padding-bottom: 10px;">
	<div class="layui-card" style="height: 100%;">
		<div class="layui-card-header" style="display: flex;;flex-direction: row;">
			<h2 class="div-title" style="flex: 1">花名册</h2>
			<div class="map-tools" id="examine-search-div" style="display: flex;height: 32px;">
				<div class="search-filter-main">
					<i id='filter' class="layui-icon">&#xe6b2;</i>
					<div id='filter-ul-div' class="filter-ul-div">
						<form class="layui-form">
							<ul id='filter-ul'>
								<li><input type="checkbox" value="staff_id" title="工号"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="staff_name" title="名字"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_name" title="职位"
									lay-skin="primary" lay-filter='filter' checked></li>
									<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
					</div>
				</div>

				<div class="map-search">
					<div id="r-result">
						<input type="text" id="serach-address-key" size="18"
							placeholder="搜索" /><i id='search-i' class="layui-icon"
							style="color: #fff;">&#xe615;</i>
					</div>
					<div id="searchResultPanel"></div>
				</div>
			</div>
		</div>
		<div class="layui-card-body" style="height: 90%">
			<div style="height: 100%; overflow-y: scroll;" class="flow-default"
				id="roster-ul"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	layui .use( [ 'form', 'flow','jquery'], function() {
		var flow = layui.flow;
		var $ = jQuery = layui.jquery;
		var form = layui.form;
		// 搜索工具 start
		var filter=new Set();// 需要查询的字段
		filter.add("staff_id");
		filter.add("staff_name");
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
			load(key);
		}
		// 搜索工具 end
		
		function load(key) {
			$('#roster-ul').html("");
			flow.load({
				elem : '#roster-ul' //流加载容器
				,
				scrollElem : '#roster-ul' //滚动条所在元素，一般不用填，此处只是演示需要。
				,
				done : function(page, next) { //执行下一页的回调
					$.ajax({
						type : "get",
						url : "staffManage/getStaffsRosterBySE?page="+page+"&limit=10&key=" + key + "&filter=" + Array.from(filter),
						async : false,
						success : function(data) {
							var jsonData = JSON.parse(data);
							if (jsonData.code == 0) {
								var lis = [];
								for (var i = 0; i < jsonData.data.length; i++) {
									var pic=jsonData.data[i].staff_person_picture;
									if (pic=='') {
										pic="res/image/pic404.png";
									}
									var item="";
									item+='<div class="content layui-col-xs6 layui-col-sm4 layui-col-md3 layui-col-lg2" style="padding: 10px;">';
									item+='<div style="background: #eee; height: 100%; border: 1px solid #eee; border-radius: 5px;">';
									item+='<img alt="" onerror="this.src='+"'res/image/pic404.png'"+'" src="file/getFile?path='+pic+'" style="width: auto; height: auto; max-width: 100%;min-width: 100%; max-height: 100%;">';
									item+='<div style="display: flex; flex-direction: row;padding-left: 5px; padding-right: 5px;">';
									item+='<i class="layui-icon">&#xe600;</i>&nbsp; <label >部门：'+jsonData.data[i].department_name+'</label></div>';
									item+='<div style="display: flex; flex-direction: row;padding-left: 5px; padding-right: 5px;">';
									item+='<i class="layui-icon">&#xe66f;</i>&nbsp; <label >姓名：'+jsonData.data[i].staff_name+'</label></div>';
									item+='<div style="display: flex; flex-direction: row;padding-left: 5px; padding-right: 5px;">';
									item+='<i class="layui-icon">&#xe66e;</i>&nbsp; <label >职位：'+jsonData.data[i].position_name+'</label>';
									item+='</div> </div> </div>';
									
									lis.push(item)
								}
								next(lis.join(''), page < (jsonData.count/10)); 
							}
						}
					});
				}
			});
		}
		load("");
		
	});
</script>
</html>