function init() {
    var url = location.href;

    //승인키
    var confmKey = "devU01TX0FVVEgyMDIxMTExMjEzMTcxMTExMTg3NTE=";

    // 도로명주소 검색결과 화면 출력유형, 1 : 도로명, 2 : 도로명+지번+상세보기(관련지번, 관할주민센터), 3 : 도로명+상세보기(상세건물명), 4 : 도로명+지번+상세보기(관련지번, 관할주민센터, 상세건물명)
    var resultType = "4";
    var inputYn = "<%=inputYn%>";

    if (inputYn != "Y") {
        document.form.confmKey.value = confmKey;
        document.form.returnUrl.value = url;
        document.form.resultType.value = resultType; // resultType항목 추가(2016.10.06)
        document.form.action = "https://www.juso.go.kr/addrlink/addrLinkUrl.do"; // 인터넷망
        document.form.submit();
    } else {
        /** API 서비스 제공항목 확대 (2017.02) **/
        opener.jusoCallBack("<%=roadFullAddr%>", "<%=roadAddrPart1%>", "<%=addrDetail%>", "<%=roadAddrPart2%>", "<%=engAddr%>"
            , "<%=jibunAddr%>", "<%=zipNo%>", "<%=admCd%>", "<%=rnMgtSn%>", "<%=bdMgtSn%>", "<%=detBdNmList%>"
            , "<%=bdNm%>", "<%=bdKdcd%>", "<%=siNm%>", "<%=sggNm%>", "<%=emdNm%>", "<%=liNm%>", "<%=rn%>", "<%=udrtYn%>"
            , "<%=buldMnnm%>", "<%=buldSlno%>", "<%=mtYn%>", "<%=lnbrMnnm%>", "<%=lnbrSlno%>", "<%=emdNo%>");
        window.close();
    }
}