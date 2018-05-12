<%@ page import="com.mybank.fundtrans.dao.ClientDao" %>
<%@ page import="com.mybank.fundtrans.dao.ClientDaoHibernateImpl" %>
<%@ page import="com.mybank.fundtrans.domain.Client" %>
<%--
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
    <title>修改客户信息</title>
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
    String IDCard = request.getParameter("idCard");
    ClientDao clientDao = new ClientDaoHibernateImpl();
    Client client = clientDao.findByIDCard(IDCard);
%>
<div class="content-box-header">
    <h3>修改客户信息</h3>
</div>

<div class="content-box-content">
    <form name="form1" action="client/updateClient.action" method="post"
          onSubmit="return checkNull()">
        <p>
            客户身份证号：<%=client.getIDCard()%>
            <input class="text-input large-input" type="hidden"
                          name="client.IDCard" value="<%=client.getIDCard()%>"/>
        </p>
        <p>
            客户姓名：<input class="text-input large-input" type="text"
                        name="client.name" value="<%=client.getName()%>"/>
        </p>
        <p>
            客户性别：<input class="text-input large-input" type="radio"
                        name="client.sex" value="M" <%="M".equals(client.getSex())?"checked":""%>/>男
            <input class="text-input large-input" type="radio"
                   name="client.sex" value="F" <%="F".equals(client.getSex())?"checked":""%>/>女
        </p>
        <p>
            客户电话：<input class="text-input large-input" type="text"
                        name="client.phone" value="<%=client.getPhone()%>"/>
        </p>
        <p>
            客户地址：<input class="text-input large-input" type="text"
                        name="client.address" value="<%=client.getAddress()%>"/>
        </p>
        <p>
            客户邮箱：<input class="text-input large-input" type="text"
                        name="client.email" value="<%=client.getEmail()%>"/>
        </p>
        <p>
            客户兴趣爱好：<input class="text-input large-input" type="text"
                          name="client.hobby" value="<%=client.getHobby()%>"/>
        </p>
        <p>
            <input class="button" type="submit" value="修改"/> <input
                class="button" type="reset" value="重置修改"/>
        </p>
    </form>
</div>
</body>
</html>
