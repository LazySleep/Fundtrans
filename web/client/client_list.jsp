<%@ page import="com.mybank.fundtrans.domain.Client" %>
<%@ page import="com.mybank.fundtrans.domain.Fund" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>客户信息列表</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        p {
            text-align: center;
            margin: 0;
            font-weight: bold;
            font-size: 1.5em;
        }

        table {
            margin: 0 0 250px 0;
            border-collapse: collapse;
            border-spacing: 0;
            table-layout: fixed;
            width: 100%;
        }

        tbody tr:nth-child(even) {
            background-color: #fff;
        }

        tbody tr:nth-child(odd), thead, p {
            background-color: #f0f0f0;
        }

        table td, p {
            padding: 10px 0;
            text-align: center;
        }

        tbody td:last-child, tbody td:last-child a {
            color: #66ab00;
        }

        tbody td:last-child a {
            text-decoration: none;
        }

    </style>
    <script type="text/javascript">
        function deleteRes(IDCard) {
            if (window.confirm("确认要删除这条数据吗?")) {
                //跳转
                window.location = "client/deleteClient.action?idCard=" + IDCard;
            }
        }
    </script>
</head>
<body>
<%
    List<Client> list = (List<Client>) request.getAttribute("clients");
%>
<p>客户信息列表</p>
<table>
    <thead>
    <tr>
        <td>客户身份证号</td>
        <td>客户姓名</td>
        <td>客户性别</td>
        <td>客户电话</td>
        <td>客户地址</td>
        <td>客户邮箱</td>
        <td>客户兴趣爱好</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <%
        if (list != null) {
            for (Client clent : list) {
    %>
    <tr>
        <td><%=clent.getIDCard()%>
        </td>
        <td><%=clent.getName()%>
        </td>
        <td><%="M".equals(clent.getSex())?"男":"女"%>
        </td>
        <td><%=clent.getPhone()%>
        </td>
        <td><%=clent.getAddress() %>
        </td>
        <td><%=clent.getEmail() %>
        </td>
        <td><%=clent.getHobby() %>
        </td>
        <td><a href="client/startUpdateClient.action?idCard=<%=clent.getIDCard()%>">修改</a>&nbsp;/&nbsp;<a
                href="javascript:deleteRes('<%=clent.getIDCard()%>')">删除</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
