<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"
	style="height: 100%; background: #fff;">
	<div class="layui-carousel" id="carousel">
		<div carousel-item>
			<div>
				<img src="res/image/lp.jpg" />
			</div>
			<div>
				<img src="res/image/lp.jpg" />
			</div>
			<div>
				<img src="res/image/lp.jpg" />
			</div>
			<div>
				<img src="res/image/lp.jpg" />
			</div>
			<div>
				<img src="res/image/lp.jpg" />
			</div>
		</div>
	</div>
	<div class="index-main">

		<div style="padding-left: 20px; padding-right: 20px;">
			<div class="main-introduce" style="width: 100%; text-align: center;">
				<h3 style="color: #808080; margin-top: 20px">公司概况</h3>
				<div
					style="height: 2px; width: 30px; background: #17a296; margin: 5px auto;"></div>
			</div>
			<a> &nbsp;&nbsp;&nbsp;&nbsp; </a> <a id="company_msg"
				style="color: #808080;"> </a>
			<div class="main-introduce" style="width: 100%; text-align: center;">
				<h3 style="color: #808080; margin-top: 20px">通讯方式</h3>
				<div
					style="height: 2px; width: 30px; background: #17a296; margin: 5px auto;"></div>
			</div>
			<div class="main-situation-2"
				style="text-align: center; color: #808080;">
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div
						style="text-align: left; display: inline-block; margin-bottom: 20px;">
						<a>公司名称：</a> <a id="company_name" name="company_name"> </a> <br />
						<br /> <a>公司电话：</a> <a id="company_phone" name="company_phone"></a><br />
						<br /> <a>公司传真：</a> <a id="company_fax" name="company_fax"></a><br />
					</div>

				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div style="text-align: left; display: inline-block;">
						<a>公司官网：</a> <a id="company_net" name="company_net" href=""
							style="text-decoration: none;"></a><br /> <br /> <a>公司地址：</a> <a
							id="company_address" name="company_address"></a><br /> <br />
					</div>
				</div>

			</div>
		</div>
	</div>

</div>

<script>
	layui.use([ 'form', 'jquery', 'carousel' ], function() {
		var form = layui.form;
		var $ = jQuery = layui.jquery;

		var carousel = layui.carousel;
		//建造实例
		carousel.render({
			elem : '#carousel',
			width : '100%' //设置容器宽度
			,
			arrow : 'always' //始终显示箭头
		//,anim: 'updown' //切换动画方式
		});

		function getCompany() {
			$.ajax({
				type : "get",
				url : "company/getCompany",
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.code == 100) {
						$("#company_name2").text(jsonData.data.company_name);
						$("#company_name").text(jsonData.data.company_name);
						$("#company_net").text(jsonData.data.company_net);
						$("#company_msg").text(jsonData.data.company_msg);
						$("#company_fax").text(jsonData.data.company_fax);
						$("#company_phone").text(jsonData.data.company_phone);
						$("#company_address").text(
								jsonData.data.company_address);

					} else if (jsonData.code == 101) {
						layer.msg("数据库获取失败");
					} else {
						layer.msg("未知错误");
					}
				},

			});
			return false;

		}

		getCompany();

	});
</script>
</html>
