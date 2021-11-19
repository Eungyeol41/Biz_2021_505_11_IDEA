<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 독서록</title>
    <link href="${rootPath}/static/css/main.css?ver=001" rel="stylesheet">
</head>
<body>
<header>
    <h1>2021 READ BOOK</h1>
</header>
<nav>
    <ul>
        <li>Home</li>
        <li>
            <form method="post">
                <input name="search" placeholder="검색어를 입력하세요">
            </form>
        </li>
    </ul>
</nav>
<section class="main">

</section>
<footer>
    <address>CopyRight &copy;iniziato@naver.com</address>
</footer>

</body>
</html>
