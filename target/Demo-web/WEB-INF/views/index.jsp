<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
</head>
<body>
<table border="1" cellspacing="0" width="500">
    <tr>
        <th>login_id</th>
        <th>user_id</th>
        <th>login_time</th>
        <th>login_ip</th>
    </tr>
    <c:forEach var="li" items="${sessionScope.list}">
        <tr>
            <td>${li.loginId}</td>
            <td>${li.userId}</td>
            <td>${li.loginTime}</td>
            <td>${li.loginIp}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>