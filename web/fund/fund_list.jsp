<%@ page import="java.util.List" %>
<%@ page import="com.mybank.fundtrans.domain.Fund" %><%--
  Created by IntelliJ IDEA.
  User: LazySleep
  Date: 2018/3/24
  Time: 9:40
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
    <title>基金产品查询</title>
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
        function deleteRes(id) {
            if (window.confirm("确认要删除这条数据吗?")) {
                //跳转
                window.location = "fund/deleteFund.action?id=" + id;
            }
        }
    </script>
</head>
<body>
<%
    List<Fund> list = (List<Fund>) request.getAttribute("fundList");
%>
<p>基金产品查询结果</p>
<table>
    <thead>
    <tr>
        <td>基金编号</td>
        <td>基金产品<br>名称</td>
        <td>基金产品<br>价格</td>
        <td>基金产品<br>状态</td>
        <td>基金产品<br>创建时间</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <%
        if (list != null) {
            for (Fund f : list) {
    %>
    <tr>
        <td><%=f.getId()%>
        </td>
        <td><%=f.getName()%>
        </td>
        <td><%=f.getPrice()%>
        </td>
        <td><%=f.getStatus()%>
        </td>
        <td><%=f.getCreateTime() %>
        </td>
        <td><a href="fund/startUpdateFund.action?id=<%=f.getId()%>">修改</a>&nbsp;/&nbsp;<a
                href="javascript:deleteRes(<%=f.getId()%>)">删除</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
