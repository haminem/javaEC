<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ログイン</title>
</head>
<body>
    <jsp:include page="navigator.jsp" />
    <h1>ログイン</h1>
    <form action="LoginServlet?action=login" method="post">
        <table>
            <tr>
                <td>ユーザー名</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="ログイン" /></td>
            </tr>
        </table>
        <p>${message}</p>
    </form>
</body>
</html>
