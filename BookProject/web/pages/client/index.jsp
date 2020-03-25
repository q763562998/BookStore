<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>

        <c:if test="${ empty sessionScope.user}">

            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;

        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <a href="pages/user/login_success.jsp">个人中心</a>
            <a href="pages/cart/cart.jsp">购物车</a>

        </c:if>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="/BookProject/client/bookService" method="get">
                价格：<input id="min" type="text" name="min" value="${requestScope.min}"> 元 -
                <input type="hidden" name="action" value="pageByPrice">
                <input id="max" type="text" name="max" value="${requestScope.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有${sessionScope.cart.totalNumber}件商品</span>
            <div>
                您刚刚将<span style="color: red">${sessionScope.last.name}</span>加入到了购物车中
            </div>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add" bookName="${book.name}" bookId="${book.id}"  bookPrice="${book.price}" >
                        <input bookName="${book.name}" bookId="${book.id}" bookPrice="${book.price}" id="cart" type="button" value="加入购物车">

                        <script type="text/javascript">
                            $(function () {
                                $("div.book_add").click(function () {

                                     var name=$(this).attr("bookName");
                                    var id=$(this).attr("bookId");
                                    var price=$(this).attr("bookPrice");
                                    location.href="/BookProject/cartService?action=add&name="+name+"&id="+id+"&price="+price;
                                    // location.href="http://www.baidu.com";
                                });
                            });
                        </script>
                    </div>
                </div>
            </div>
        </c:forEach>



    </div>

    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="${requestScope.page.url}&pageNo=${1}">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>


        <%--        输出起始页码--%>
        <c:choose>
            <c:when test="${requestScope.page.pageTotals<=5}">
                <c:forEach begin="1" end="${requestScope.page.pageTotals}" var="i">

                    <c:if test="${requestScope.page.pageNo!=i}">

                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
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

                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo==i}">

                            <a>【${i}】</a>
                        </c:if>

                    </c:forEach>

                </c:if>
                <c:if test="${requestScope.page.pageNo>=requestScope.page.pageTotals-2}">
                    <c:forEach begin="${requestScope.page.pageTotals-4}" end="${requestScope.page.pageTotals}" var="i">
                        <c:if test="${requestScope.page.pageNo!=i}">

                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo==i}">

                            <a>【${i}】</a>
                        </c:if>




                    </c:forEach>
                </c:if>

                <c:if test="${requestScope.page.pageNo>3&&requestScope.page.pageNo<requestScope.page.pageTotals-2}">
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${requestScope.page.pageNo!=i}">

                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
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

            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotals}">末页</a>
        </c:if>
        共${requestScope.page.pageTotals}页，${requestScope.page.bookCounts}条记录 到第<input
            value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input id="search" type="button" value="确定">
        <script   type="text/javascript">
            $(function () {

                $("#search").click(function () {


                    var pageNo=$("#pn_input").val();
                    location.href="http://localhost:8080/BookProject/client/bookService?action=page1&pageNo="+pageNo;
                    // location.href="http://www.baidu.com";
                });

            });
        </script>


    </div>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>