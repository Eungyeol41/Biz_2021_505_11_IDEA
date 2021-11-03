<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link href="${rootPath}/static/css/main.css" rel="stylesheet" />
<link href="${rootPath}/static/css/list.css" rel="stylesheet" />
<body>
<%@include file="../header.jsp" %>
<%@include file="../nav.jsp" %>
<table>
    <thead>
        <tr id="table_th">
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>주소</th>
            <th>전화번호</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>20210001</td>
            <td>홍길동</td>
            <td>컴퓨터공학</td>
            <td>2</td>
            <td>서울시 동대문구</td>
            <td>02-222-1234</td>
        </tr>
        <tr>
            <td>20210002</td>
            <td>성춘향</td>
            <td>전자공학</td>
            <td>3</td>
            <td>전라북도 익산시</td>
            <td>063-111-1234</td>
        </tr>
    </tbody>
</table>
<div class="div_btn">
    <button>학생 정보 추가</button>
</div>
</body>
</html>
