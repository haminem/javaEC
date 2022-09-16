<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>購入</title>
</head>
<body>
<jsp:include page="navigator.jsp" />
<h1>購入</h1>
<c:if test="${empty sessionScope.login}">
    <p>ログインしてください</p>
    <a href="login.jsp">ログイン</a>
</c:if>
<c:if test="${not empty sessionScope.login}">
    <c:forEach items="${cart.items}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <br>
        </tr>
    </c:forEach>
    <form action="PurchaseServlet?action=buy" method="post">
        お名前<input type="text" name="name">
        住所<input type="text" name="address">
        <input type="submit" value="購入">
    </form>
</c:if>
</body>
</html>
