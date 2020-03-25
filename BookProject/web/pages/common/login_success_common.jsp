<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="/BookProject/pages/order/order.jsp">我的订单</a>
    <a href="manager/bookServlet?action=loginout">注销</a>&nbsp;&nbsp;
    <a href="/BookProject/index.jsp">返回</a>
</div>