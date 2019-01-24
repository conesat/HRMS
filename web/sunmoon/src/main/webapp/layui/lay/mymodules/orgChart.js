/**
 * jQuery org-chart/tree plugin.
 *
 * Author: Wes Nolte
 * http://twitter.com/wesnolte
 *
 * Based on the work of Mark Lee
 * http://www.capricasoftware.co.uk
 *
 * Copyright (c) 2011 Wesley Nolte
 * Dual licensed under the MIT and GPL licenses.
 *
 */

layui.define("jquery", function(exports) {
	var $ = layui.jquery;
	"use strict";
	layui.link("res/css/orgChart.css");
	var self,
		objs = {
			render: function(options) {
				
				var defaults = {};
				var opts = $.extend({}, defaults, options);
				var obj = opts.data;
				if($(options.elm).length == 0) {
					return;
				}
				self = $(options.elm);
				self.html('');
				if(obj && Object.keys(obj).length > 0) {

					var level1s = '<div class="level1s"><div class="level1"><div class="content"></div></div></div>';
					var $level1s = $(level1s);
					var devider = '<div class="divider"></div>';
					var $devider = $(devider);
					var level2s = '<ul class="level2s"></ul>';
					var $level2s = $(level2s);
					var renderLevel3 = function(obj, $level, $levels, loopIndex) {

						var levels = 'level' + loopIndex + 's';
						var level = 'level' + loopIndex;
						if(loopIndex > 0) {

							var level3s = '<ul class="level' + loopIndex + 's"></ul>';
							var level3 = '<li class="level' + loopIndex + '"  data-level=""><div class="content"></div></li>';
							var $level3s = $(level3s);
							var $level3 = $(level3);
							$level3.attr('data-level', loopIndex);
							if(loopIndex == 3) {
								$level3s.addClass('tree')
							}

							if(obj.children && obj.children.length) {
								$.each(obj.children, function(item, value) {
									var $level3 = $(level3); /*错*/
									if(value.department_name && opts.renderdata) {
										opts.renderdata(value, $level3.find('.content'))
									}
									if(value.children && value.children.length) {
										if(opts.depth && loopIndex == opts.depth) {
											// 收起
											addIcon($level3, true);
										} else {
											// 展开
											addIcon($level3, false);
										}

									}
									// 隐藏下级
									if(opts.depth && loopIndex == (parseInt(opts.depth) + 1)) {

										$level3.hide()
									}
									$level3s.append($level3);
									renderLevel3(value, $level3, $level3s, loopIndex + 1);
								});

							}
						}

						$level.append($level3s);
						$levels.append($level)

					} /*renderLevel3结束*/
					/*防止第二层折行*/
					var avoid = function() {
						var $level2 = $('.level2s').children('.level2');
						var _width = parseInt($level2.width());
						var maxHeight = $level2.height();
						var allWidth = 0; /*累加第二层宽度*/
						/*js获取元素属性兼容*/
						function getStyle(obj, attr) {
							if(obj.currentStyle) {
								return obj.currentStyle[attr];
							} else {
								return getComputedStyle(obj, false)[attr];
							}
						}

						$level2.each(function() {
							if(!$(this).find('li.level3').size()) {
								$(this).addClass('noneChild')
							}

							var _height = $(this).height();
							allWidth += $(this).outerWidth(true);
							var left = 0;
							for(var i = 0; i < $(self).index(); i++) {
								var contentWidth = parseInt(window.getComputedStyle($level2[i]).width);
								var paddingLeft = parseInt(window.getComputedStyle($level2[i]).paddingLeft);
								var paddingright = parseInt(window.getComputedStyle($level2[i]).paddingRight);
								var width = contentWidth + paddingLeft + paddingright;
								left += width;
							}
							/*向右堆叠*/
							// $(self).css('left', allWidth - $(self).outerWidth(true));
						});
						/*为没有子节点的第二层添加右padding*/

						/**/
						var lastlevel2 = $('.level2:last-child');
						var lastWidth = parseInt(lastlevel2.css('width'));

						/*防止第二层折行*/
						$('.level2s').css('width', allWidth);
						self.css('width', allWidth);
						// 判断是否为手机
						var ua = navigator.userAgent;
						var sTime = '';

						var ipad = ua.match(/(iPad).*OS\s([\d_]+)/),

						isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),

						isAndroid = ua.match(/(Android)\s+([\d.]+)/),

						isMobile = isIphone || isAndroid;
						// 判断是否为手机
						if(isMobile){
							self.css('margin-left', 0);
						}else{
							self.css('margin-left', -allWidth / 2);
						}
						
						//设置divider宽度
						$('.divider').width(layui.jquery('.level2:last').offset().left - layui.jquery('.level2s').offset().left - 2 + ($('.level2:last .content').width() - $('.level2:first .content').width()) / 2);
						$('.divider').css('left', parseInt($('.level2:first .content').width()) / 2 + parseInt($('.level2s').css('marginLeft')));
						$('.level2s').width($('.level2s').width() * 2);
					}

					var addIcon = function($levels, flag, depth) {
						var icon
						if(flag) {
							icon = '<i class="layui-icon glyphicon-plus-sign"></i>'
						} else {
							icon = '<i class="layui-icon glyphicon-minus-sign"></i>'
						}
						var $icon = $(icon);
						$levels.find('.content').append($icon);
						// 加减按钮点击事件
						//第一层区别事件
						if(depth && depth == 1) {
							$icon.on('click', function(e) {
								var $level2s = this.find('.level2s')
								if($level2s.is(":visible")) {
									this.attr('id', 'noneLevel2');
									$(this).attr('title', '展开').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
								} else {
									this.attr('id', '');
									avoid();
									$(this).attr('title', '收起').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
								}
							})
						} else {
							$icon.on('click', function(e) {
								var children = $(this).closest('li.parent_li').find(' > ul > li');
								if(children.is(":visible")) {
									children.hide('fast', function() {
										avoid();
									});
									$(this).attr('title', '展开').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
								} else {
									children.show('fast', function() {
										avoid();
									});
									children.css({
										overflow: 'visible'
									})
									$(this).attr('title', '收起').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
								}

								e.stopPropagation();
							})
						}
					}
					//拖拽
					/*网页拖拽*/
					var drag = function(obj) {
						var dragEle = obj;
						var _move = false; //移动标记
						var _x, _y; //鼠标离控件左上角的相对位置
						dragEle.click(function() {
							//alert("click");//点击（松开后触发）
						}).mousedown(function(e) {
							_move = true;
							_x = e.pageX - parseInt(dragEle.css("left"));
							_y = e.pageY - parseInt(dragEle.css("top"));
							// dragEle.fadeTo(20, 0.9);//点击后开始拖动并透明显示
						});
						$(document).mousemove(function(e) {
							if(_move) {
								var x = e.pageX - _x; //移动时根据鼠标位置计算控件左上角的绝对位置
								var y = e.pageY - _y;
								dragEle.css({
									top: y,
									left: x
								}); //控件新位置
							}
						}).mouseup(function() {
							_move = false;
							dragEle.fadeTo("fast", 1); //松开鼠标后停止移动并恢复成不透明
						});
					}

					self.attr('id', '')
					if(obj.department_name && opts.renderdata) {

						opts.renderdata(obj, $level1s.find('.content'))
					}
					if(obj.children && obj.children.length) {
						if(opts.depth == 1) { //只显示一层
							self.attr('id', "noneLevel2")
							addIcon($level1s, true, 1);
						} else {
							addIcon($level1s, false, 1);
						}
					} else {

					}
					self.append($level1s);
					if(obj.children && obj.children.length) {
						self.append($devider);
						var level2length = 0; //第二层数量
						if(obj.children) {
							$.each(obj.children, function(item, value) {
								level2length++;
								var level2 = '<li class="level2"><div class="content"></div></li>';
								var $level2 = $(level2);

								if(value.department_name && opts.renderdata) {
									opts.renderdata(value, $level2.find('.content'));
								}
								if(value.children && value.children.length) {
									if(opts.depth == 2) { //显示两层
										addIcon($level2, true);
									} else {
										addIcon($level2, false);
									}

								}
								if(value.children) {
									renderLevel3(value, $level2, $level2s, 3);
								} else {
									renderLevel3(value, $level2, $level2s, -1);
								}
							})

							if(level2length == 1) {
								self.attr('id', 'oneChild')
							}
							if(level2length == 0) {
								self.attr('id', 'noneLevel2')
							}
						}
						self.append($level2s);
						// 加减按钮点击事件
						$('.orgWrap li:has("ul>li")').addClass('parent_li').find(' > span').attr('title', '收起');
						avoid();
					}else{
						
						$(self).css('left','0');
						$('.organization').addClass("noChildren").removeClass("content");
						
					}
					if(opts.drag) {
						drag(self)
					}
					if(opts.callback) {
						opts.callback()
					}
				}
				//              
				//              if(options.data.children&&options.data.children.length>0){
				//              	
				//              }else{
				//              	$('.divider').remove();
				//					$('.organization').addClass("no-border").addClass("nocontent").removeClass("content");
				//              }
			}
		}
	exports('orgChart', objs);
});