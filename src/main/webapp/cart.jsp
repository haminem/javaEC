<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>カート</title>
</head>
<body>
    <jsp:include page="navigator.jsp" />
    <c:if test="${empty cart.items}">
        カートに商品はありません。
    </c:if>

    <c:if test="${not empty cart.items}">
        <table>
            <tr>
                <th>商品名</th>
                <th>価格</th>
            </tr>
            <c:forEach items="${cart.items}" var="item" varStatus="status">
                <form action="CartServlet?action=delete" method="post">
                    <tr>
                        <input type="hidden" name="id" value="${status.index}" />
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>
                            <input type="submit" value="削除" />
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
