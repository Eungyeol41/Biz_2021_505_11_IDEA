<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<style>
    form.join_form {

    }
</style>
<form:form action="${rootPath}/member/join" method="post" cssClass="join_form">
    <h2>회원가입</h2>
    <input placeholder="사용자 ID" name="username">
    <input placeholder="비밀번호" name="password" type="password">
    <input placeholder="비밀번호 확인" name="password_ch" type="password">
    <input placeholder="E-mail" name="email" type="email">
    <button type="button">회원가입 신청</button>
</form:form>

<script>
    const join_form = document.querySelector("form.join_form button");

    let username = document.querySelector("input[name='username']");
    let password = document.querySelector("input[name='password']");
    let password_ch = document.querySelector("input[name='password_ch']");
    let email = document.querySelector("input[name='email']");

    $("input#username").on("blur", function (){
        $.ajax("${rootPath}/member/idCheck")
        .done(function (result){
            if (result) {
                alert("이미 사용중인 ID입니다")
                $(this).focus()
            } else {
                alert("사용가능한 ID입니다.")
                $("#password").focus()
            }
        })
    })

    join_form.addEventListener("click", (e)=>{

        if(!username.value) {
            alert("사용자 ID를 입력해야합니다")
            username.focus();
            return false;
        }

        if (!password.value) {
            alert("비밀번호를 입력해야합니다.")
            password.focus();
            return false;
       }

        if (!password_ch.value) {
            alert("비밀번호를 다시 한 번 입력해야합니다.")
            password_ch.focus();
            return false;
        }

        if (password.value !== password_ch.value) {
            alert("비밀번호가 다릅니다!")
            password_ch.focus();
            return false;
        }

        if (!email.value) {
            alert("E-mail을 입력해야합니다.")
            email.focus();
            return false;
        }

        <%--alert("== 회원가입 성공 ==")--%>
        <%--location.href = `${rootPath}/member/login`;--%>

        $("form.join_form").submit()

    })

</script>