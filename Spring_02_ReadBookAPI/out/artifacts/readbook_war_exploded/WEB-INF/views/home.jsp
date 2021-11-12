<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form>
      <div class="input">
        <input name="isbn" placeholder="9791163032816" />
        <input name="title" placeholder="Do It 자바" />
      </div>
      <div class="input">
        <label>읽기 시작한 날짜</label><input name="sdate" placeholder="2021-10-07" type="date" />
        <label>읽기 시작한 시간</label><input name="stime" placeholder="09:28:22" type="time" />
        <label>읽기 완료한 시간</label><input name="etime" placeholder="12:32:12" type="time" />
      </div>
      <%--
      <div class="input">
        <input name="etime" placeholder="12:32:12" type="time" />
      </div>
      --%>
      <div class="input">
        <input name="content" placeholder="내용을 입력해주세요" />
      </div>
      <div class="input">
        <input name="content" placeholder="내용을 입력해주세요" />
      </div>
      <div class="btn_box">
        <button type="button">저장</button>
        <button type="reset">새로 작성</button>
        <button type="button">리스트</button>
      </div>
    </form>
  </body>
</html>
