<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<%@include file="/pages/common/manager.jsp" %>

<div id="main">
    <form action="manager/bookServlet" method="get">
        <%--				这里的add和update 一定要注意加引号，因为要字符串才能用method方法--%>
        <input type="hidden" name="action" value="${requestScope.name==null?"add":"update"}">
        <input type="hidden" name="id" value="${requestScope.id}">
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>