<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-03
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />


<html>
<head>
    <title>MAIN</title>
</head>
<link href="${rootPath}/static/css/main.css" rel="stylesheet" />
<body>
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>
</body>
</html>
