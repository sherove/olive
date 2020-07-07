<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>업로드 테스트</title>
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
<table>
	<thead>
		<tr>
		 <th>작성자</th>
		 <th>제    목</th>
		 <th>파일이름</th>
		 <th>날짜</th>
		</tr>
	</thead>
	<tbody id="testBody">
	
	</tbody>
	</table>
	<br><br>

	  <form action="/main/UploadService" method="post" enctype="multipart/form-data">
	     <table>
		          <tr>
		              <td>작성자 : </td>
		              <td><input type="text" name="author"/></td>
		          </tr>
		          <tr>
		              <td>제목 : </td>
		              <td><input type="text" name="title"/></td>
		          </tr>
		          <tr>
		              <td>파일이름 : </td>
		              <td><input type="file" value="파일 선택" name="report"/></td>
		          </tr>
		          <tr>
		              <td colspan="2"><input type="submit" value="업로드"/></td>
		          </tr>
	     </table>
    </form>

</body>
</html>