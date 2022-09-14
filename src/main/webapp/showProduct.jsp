<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品ページ</title>
</head>
<body>
    <jsp:include page="/navigator.jsp" />
    <hr>
    <h1>商品ページ</h1>
    <table>
        <tr>
            <th>商品名</th>
            <th>価格</th>
            <th></th>
        </tr>
        <c:forEach items="${products}" var="item">
            <form action="CartServlet?action=add" method="post">
                <input type="hidden" name="id" value="${item.id}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><input type="submit" value="カートに入れる"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</body>
</html>