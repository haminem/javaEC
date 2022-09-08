<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品ページ</title>
</head>
<body>
    <h1>商品ページ</h1>
    <table>
        <tr>
            <th>商品名</th>
            <th>価格</th>
        </tr>
        <c:forEach items="${products}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>