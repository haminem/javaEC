<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ログアウト</title>
</head>
<body>
    <c:if test="${empty sessionScope.login}">
        <p>ログインしていません</p>
    </c:if>
    <c:if test="${not empty sessionScope.login}">
    <p>ログアウトしますか？</p>
    <form action="LogoutServlet?logout" method="post">
        <input type="submit" value="ログアウト">
    </form>
    </c:if>
</body>
</html>
