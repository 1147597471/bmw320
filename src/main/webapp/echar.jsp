<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/messages_zh.min.js"></script>

</head>
<body>

	 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1600px;height:800px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
          myChart.setOption({
            title: {
                text: '课程平均播放次数表'
            },
            tooltip: {},
            legend: {
                data:['平均播放次数']
            },
            xAxis: {
            	
         			 data: []
             
            },
            yAxis: {},
            series: [{
                name: '平均播放次数',
                type: 'bar',
                data:[]
            }]
          });
         
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums=[];    //销量数组（实际用来盛放Y坐标值）
        
        $.ajax({
        type : "post",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url :"${pageContext.request.contextPath}/admin/video/playVideo.action",    //请求发送到TestServlet处
        data : {},
        dataType : "json",        //返回数据形式为json
        success : function(result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            
            if (result) {
                   for(var i=0;i<result.length;i++){       
                      names.push(result[i].courseName);    //挨个取出类别并填入类别数组
                    }
                   for(var i=0;i<result.length;i++){        
                       nums.push(result[i].videoPlayTimes);    //挨个取出销量并填入销量数组
                     }
                   myChart.hideLoading();    //隐藏加载动画
                   myChart.setOption({        //加载数据图表
                       xAxis: {
                           data: names
                       },
                       series: [{
                           // 根据名字对应到相应的系列
                           name: '平均播放次数',
                           data: nums
                       }]
                   });
                   
            }
        
      
            
       },
        error : function(errorMsg) {
            //请求失败时执行该函数
        alert("图表请求数据失败!");
        myChart.hideLoading();
        }
   });

    </script>
</body>
</html>