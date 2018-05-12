<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>add fund</title>
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
<div class="content-box-header">
    <h3>新增基金信息</h3>
</div>

<div class="content-box-content">
    <form name="form1" action="client/addClient.action" method="post"
          onSubmit="return checkNull()">
        <p>
            客户身份证号：<input class="text-input large-input" type="text"
                          name="client.IDCard"/>
        </p>
        <p>
            客户姓名：<input class="text-input large-input" type="text"
                        name="client.name"/>
        </p>
        <p>
            客户性别：<input class="text-input large-input" type="radio"
                        name="client.sex" value="M"/>男
            <input class="text-input large-input" type="radio"
                   name="client.sex" value="F"/>女
        </p>
        <p>
            客户电话：<input class="text-input large-input" type="text"
                        name="client.phone"/>
        </p>
        <p>
            客户地址：<input class="text-input large-input" type="text"
                        name="client.address"/>
        </p>
        <p>
            客户邮箱：<input class="text-input large-input" type="text"
                        name="client.email"/>
        </p>
        <p>
            客户兴趣爱好：<input class="text-input large-input" type="text"
                        name="client.hobby"/>
        </p>
        <p>
            <input class="button" type="submit" value="新增"/> <input
                class="button" type="reset" value="取消"/>
        </p>
    </form>
</div>

</body>
</html>