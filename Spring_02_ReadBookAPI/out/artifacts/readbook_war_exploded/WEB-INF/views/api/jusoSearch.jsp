<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="${rootPath}/static/js/postcode.v2.js"></script>

<body>
<h1>■ 행정안정부 - 주소 검색 API</h1>

현재 페이지 : <input type="number" id="currentPage" value="1" style="text-align: center"/>

<div style="height: 5px"></div>

페이지당 출력 개수 : <input type="number" id="countPerPage" value="5" style="text-align: center"/>

<input
        type="text"
        id="zipCode"
        value=""
        onClick="addressWindowOpen();"
        readonly
/>

<input type="button" onClick="addressWindowOpen();" value="우편번호 찾기"/>

<div id="wrap">
<%--    <img id="closeBtn" src="./close_box_red.png" onClick="addressWindowClose();"/>--%>

    <div>
        <input
                type="text"
                id="searchAddr"
                value=""
                onkeydown="enterSearch();"
                placeholder="도로명주소, 건물명 또는 지번 입력"
        />

        <input type="button" onClick="getAddr();" value="주소검색"/>
    </div>

    <div>
        <div id="totoalOutcome">검색결과 : <span id="totalCnt">0</span></div>

        <table id="list"></table>
    </div>

    <div id="pagingList" style="text-align: center"></div>
</div>

<div style="height: 5px"></div>

<input type="text" id="address" value="" placeholder="도로명 주소, 지번 주소" readonly/>

<div style="height: 5px"></div>

<input type="text" id="detail" value="" placeholder="상세 주소지 입력"/>
</body>