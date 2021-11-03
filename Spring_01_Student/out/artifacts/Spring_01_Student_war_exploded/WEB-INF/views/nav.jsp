<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NAV</title>
</head>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%--<link href="${rootPath}/static/css/main.css" rel="stylesheet" />--%>
<body>
<nav class="main_nav">
    <ul>
        <li id="home">Home</li>
        <li id="list">학생 정보</li>
        <li id="score">성적일람표</li>
        <li id="login">로그인</li>
    </ul>
</nav>
</body>
<script>
    let main_nav = document.querySelector("nav.main_nav")
    
    main_nav.addEventListener("click", (e)=>{
        let menu = e.target
        // console.log("menu", menu);

        if(menu.tagName === "LI") {
            if(menu.id === "home") {
                location.href = "/student"
            } else if(menu.id === "list") {
                location.href = "/student/student/"
            } else if(menu.id === "score") {
                location.href = "/student/score"
            } else if(menu.id === "login") {
                location.href = "/member/login"
            }
        }
    })
</script>
</html>
