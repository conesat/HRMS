layui.use([ 'table', 'jquery', 'form' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	
	//性别
	$.ajax({
		type : "get",
		url : "staffManage/getStaffSex",
		async : true,
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.code == 100) {
				var data=[];
				for(var x in jsonData.data){
					data[x]=jsonData.data[x].name;
				}
				console.log(data);
				var option = {
					    title : {
					        text: '公司男女比例',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient: 'vertical',
					        left: 'left',
					        data:data
					    },
					    series : [
					        {
					            name: '男女比例',
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '50%'],
					            data:jsonData.data,	
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};
				initCharts(option,"man_women");
				
				
			} 
		},
		error : function(jqObj) {

		}
	});
	
	
	//年龄
	$.ajax({
		type : "get",
		url : "staffManage/getAgeProp",
		async : true,
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.code == 100) {
				var data=[];
				for(var x in jsonData.data){
					data[x]=jsonData.data[x].name;
				}
				option = {
					    title : {
					        text: '年龄分布',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient: 'vertical',
					        left: 'left',
					        data: data
					    },
					    series : [
					        {
					            name: '年龄分布',
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '50%'],
					            data:jsonData.data,
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};
				initCharts(option,"age");
				
				
			} 
		},
		error : function(jqObj) {

		}
	});
	
	
	$.ajax({
		type : "get",
		url : "staffManage/getWorkAddProp",
		async : true,
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.code == 100) {
				var data=[];
				for(var x in jsonData.data){
					data[x]=jsonData.data[x].name;
				}
				option = {
					    title : {
					        text: '工作地址分布',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					    	orient: 'vertical',
						    left: 'left',
					        data: data
					    },
					    series : [
					        {
					            name: '工作地址分布',
					            type: 'pie',
					            radius : [30, 100],
					            center: ['50%', '50%'],
					            roseType : 'area',
					            data:jsonData.data,
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};
				
				initCharts(option,"work-add");
				
			} 
		},
		error : function(jqObj) {

		}
	});
	

	//薪资

	
	$.ajax({
		type : "get",
		url : "staffManage/getPayProp",
		async : true,
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.code == 100) {
				var data=[];
				for(var x in jsonData.data){
					data[x]=jsonData.data[x].name;
				}
				option = {
					    title : {
					        text: '工资分布',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient: 'vertical',
					        left: 'left',
					        data: data
					    },
					    series : [
					        {
					            name: '工资分布',
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '50%'],
					            roseType : 'area',
					            data:jsonData.data,
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};
				initCharts(option,"money-in");
			} 
		},
		error : function(jqObj) {

		}
	});
	
	
	
	
	option = {
		    title: {
		        text: '本月人事变动'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['新入职','离职','调动']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        {
		            name:'新入职',
		            type:'line',
		            stack: '人数',
		            data:[120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210, 90, 230, 210]
		        },
		        {
		            name:'离职',
		            type:'line',
		            stack: '人数',
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'调动',
		            type:'line',
		            stack: '人数',
		            data:[150, 232, 201, 154, 190, 330, 410]
		        }
		    ]
		};
	initCharts(option,"staff-state");
	
});

function initCharts(option,id){
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom,"light");
	
	if (option && typeof option === "object") {
	    myChart.setOption(option, true);
	}
}

