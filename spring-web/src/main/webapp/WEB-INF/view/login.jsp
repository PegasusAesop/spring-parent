<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>这是登录界面</h2>
	<span style="color:red;">${fail}</span>
	<form action="${pageContext.request.contextPath}/login.do" method="POST">
		<p>用户名<input type="text" name="username" /></p>
		<p>密码<input type="text" name="password" /></p>
		<p><input type="submit" value="提交"  /></p>
	
	</form>
</body>
</html>