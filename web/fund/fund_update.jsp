<%@ page import="com.mybank.fundtrans.dao.FundDao" %>
<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page import="com.mybank.fundtrans.dao.FundDaoHibernateImpl" %><%--
  Created by IntelliJ IDEA.
  User: LazySleep
  Date: 2018/3/24
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改基金信息</title>
    <script language="javascript">
        function checkNull() {
            /*判断是否有空内容*/
            for (i = 0; i < form1.length; i++) {
                if (form1.elements[i].value == "") {
                    alert(form1.elements[i].title + "不能为空!");
                    form1.elements[i].focus();
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    FundDao fundDao = new FundDaoHibernateImpl();
    Fund fund = fundDao.findById(id);
%>
<div class="content-box-header">
    <h3>修改基金信息</h3>
</div>

<div class="content-box-content">
    <form name="form1" action="fund/updateFund.action" method="post"
          onSubmit="return checkNull()">
        <input type="hidden" name="fund.id" value="<%=id%>">
        <p>
            基金名字：<input class="text-input large-input" type="text"
                        name="fund.name" value="<%=fund.getName()%>"/>
        </p>
        <p>
            基金价格：<input class="text-input large-input" type="number" step="0.1"
                        name="fund.price" value="<%=fund.getPrice()%>"/>
        </p>
        <p>
            基金描述：
            <textarea class="text-input textarea" rows="16" cols="50"
                      name="fund.description"><%=fund.getDescription()%></textarea>
        </p>
        <p>
            基金状态： <input type="radio" name="fund.status"
                         value="Y" <%= fund.getStatus().equals("Y") ? "checked" : "" %>/>可交易
            <input type="radio" name="fund.status" value="N" <%= fund.getStatus().equals("N") ? "checked" : "" %>/>不可交易
        </p>
        <p>
            <input class="button" type="submit" value="修改"/> <input
                class="button" type="reset" value="重置修改"/>
        </p>
    </form>
</div>
</body>
</html>
