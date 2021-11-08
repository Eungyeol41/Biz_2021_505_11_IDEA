<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set value="" />--%>
<html>
<head>
    <title>학생 정보</title>
</head>
<body>
<h1>학생 정보</h1>
<table border="1">
    <thead>
        <tr>
            <th>이름</th>
            <th>학번</th>
            <th>학과</th>
            <th>학년</th>
            <th>주소</th>
            <th>전화번호</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${STLIST}" var="ST">
            <tr>
                <td>${ST.st_name}</td>
                <td>${ST.st_num}</td>
                <td>${ST.st_dept}</td>
                <td>${ST.st_grade}</td>
                <td>${ST.st_address}</td>
                <td>${ST.st_tel}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
