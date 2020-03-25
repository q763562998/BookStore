<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗")
            })
        })
    </script>
</head>
<body>
<%@include file="/pages/common/manager.jsp" %>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>


        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotals}">添加图书</a></td>
        </tr>
    </table>

    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="manager/bookServlet?action=page1&pageNo=${1}&onePageShows=${4}">首页</a>
            <a href="manager/bookServlet?action=page1&pageNo=${requestScope.page.pageNo-1}&onePageShows=${4}">上一页</a>
        </c:if>


<%--        输出起始页码--%>
        <c:choose>
            <c:when test="${requestScope.page.pageTotals<=5}">
                <c:forEach begin="1" end="${requestScope.page.pageTotals}" var="i">

                    <c:if test="${requestScope.page.pageNo!=i}">

                        <a href="manager/bookServlet?action=page1&pageNo=${i}">${i}</a>
                    </c:if>
                    <c:if test="${requestScope.page.pageNo==i}">

                        <a>【${i}】</a>
                    </c:if>


                </c:forEach>
            </c:when>

            <c:when test="${requestScope.page.pageTotals>5}">
                <c:if test="${requestScope.page.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">

                        <c:if test="${requestScope.page.pageNo!=i}">

                            <a href="manager/bookServlet?action=page1&pageNo=${i}">${i}</a>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo==i}">

                            <a>【${i}】</a>
                        </c:if>

                    </c:forEach>

                </c:if>
                <c:if test="${requestScope.page.pageNo>=requestScope.page.pageTotals-2}">
                    <c:forEach begin="${requestScope.page.pageTotals-4}" end="${requestScope.page.pageTotals}" var="i">
                        <c:if test="${requestScope.page.pageNo!=i}">

                            <a href="manager/bookServlet?action=page1&pageNo=${i}">${i}</a>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo==i}">

                            <a>【${i}】</a>
                        </c:if>




                    </c:forEach>
                </c:if>

                <c:if test="${requestScope.page.pageNo>3&&requestScope.page.pageNo<requestScope.page.pageTotals-2}">
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${requestScope.page.pageNo!=i}">

                            <a href="manager/bookServlet?action=page1&pageNo=${i}">${i}</a>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo==i}">

                            <a>【${i}】</a>
                        </c:if>




                    </c:forEach>
                </c:if>





            </c:when>

        </c:choose>

<%--        输出末尾页码--%>

        <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotals}">

            <a href="manager/bookServlet?action=page1&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="manager/bookServlet?action=page1&pageNo=${requestScope.page.pageTotals}">末页</a>
        </c:if>
        共${requestScope.page.pageTotals}页，${requestScope.page.bookCounts}条记录 到第<input
            value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input id="search" type="button" value="确定">
        <script   type="text/javascript">
        $(function () {

            $("#search").click(function () {


                var pageNo=$("#pn_input").val();
                location.href="http://localhost:8080/BookProject/manager/bookServlet?action=page1&pageNo="+pageNo;
                // location.href="http://www.baidu.com";
            });

        });
        </script>


    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>