<%--
  Created by IntelliJ IDEA.
  User: 16438
  Date: 2020/3/10
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <script src="js/jquery-2.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>

<h1 style="color: #122b40;font-size: 100px">${name},<small>欢迎您</small></h1>

<div align="center">
  <a
          href="${pageContext.request.contextPath}/FindUserByPageServlet" style="text-decoration:none;font-size:70px;color: #761c19;font-weight: 800">查询所有用户信息
  </a>
</div>
</body>
</html>