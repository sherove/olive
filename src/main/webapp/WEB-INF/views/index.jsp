<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
  table {
    width: 100%; 
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }

 </style>
</head>
<body>
Hello...
<P>  The time on the server is ${serverTime}. </P>
<button type="button" class="btn-login" id="tableBtn">Login</button>
<br><br>
<table>
	<thead>
		<tr>
		 <th>이 름</th>
		 <th>나 이</th>
		 <th>주 소</th>
		 <th>전화번호</th>
		 <th>파일 업로드</th>
		</tr>
	</thead>
	<tbody id="testBody">
	
	</tbody>
</table>

	<br>
	<br>
	
</body>
</html>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$("#tableBtn").on("click",function(){
	console.log("asd");
	
	$.ajax({
        url : "/main/tableList",
        type: 'POST',
        dataType : "json",
        success: function(data) {
        	console.log("하이");
        	console.log(data.voList[0].age);
        	      	
        	var dataList = data.voList;
        	var html = "";
        	
        	console.log(dataList);
        	for(i in dataList){
        		html += "<tr>";
        		html += "<td>"+dataList[i].name+"</td>"
        		html += "<td>"+dataList[i].age+"</td>"
        		html += "<td>"+dataList[i].address+"</td>"
        		html += "<td>"+dataList[i].phone+"</td>"
        		html += "<tr>";
        	}
        	
        	$("#testBody").empty();
        	$("#testBody").append(html);
        	
        }
	 });
	
});
</script>