<%@ page import="static com.example.faculty.controller.command.PathCommand.REGISTER_USER" %><%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 21.11.2021
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../fragments/navbar-all.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">


            <h1>Registration</h1>
            <form method="POST" action="<%=request.getContextPath()%>/faculty<%=REGISTER_USER%>" class="form">

                <div class="form-group">
                    <label for="firstName">First name *</label>
                    <input class="form-control" type="text" name="firstName" id="firstName"
                           placeholder="Enter first name">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('firstName')}"
                         th:errors="*{firstName}"></div>
                </div>

                <label><b><fmt:message key="register.name"/></b></label>
                <c:if test="${param.badInput == true}">
                    <p class="errorsM"><fmt:message key="register.name.error"/></p>
                </c:if>
                <input type="text" placeholder="<fmt:message key="register.name"/>" name="name" required>


                <div class="form-group">
                    <label for="secondName">Second name *</label>
                    <input class="form-control" type="text" th:field="*{secondName}" id="secondName"
                           placeholder="Enter second name">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('secondName')}"
                         th:errors="*{secondName}"></div>
                </div>
                <div class="form-group">
                    <label for="lastName">Last name *</label>
                    <input class="form-control" type="text" th:field="*{lastName}" id="lastName"
                           placeholder="Enter last name">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('lastName')}"
                         th:errors="*{lastName}"></div>
                </div>
                <div class="form-group">
                    <label for="email">Email *</label>
                    <input class="form-control" type="text" th:field="*{email}" id="email" placeholder="Enter email">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></div>
                </div>
                <div class="form-group">
                    <label for="password">Password *</label>
                    <input class="form-control" th:field="*{password}" type="password" id="password" name="password"
                           placeholder="Enter password">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('password')}"
                         th:errors="*{password}"></div>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm password *</label>
                    <input class="form-control" th:field="*{confirmPassword}" type="password" id="confirmPassword"
                           name="confirmPassword" placeholder="Confirm password">
                    <div class="alert alert-warning" th:if="${#fields.hasErrors('confirmPassword')}"
                         th:errors="*{confirmPassword}"></div>
                </div>

                <div class="form-group" th:classappend="${#fields.hasErrors('terms')}? 'has-error':''">
                    <input id="terms" type="checkbox" th:field="*{terms}"/> <label class="control-label" for="terms"> I
                    agree with the <a href="#">terms and conditions</a> for Registration.
                </label>
                    <p class="error-message" th:each="error : ${#fields.errors('terms')}" th:text="${error}">Validation
                        error
                    </p>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Register</button>
                    <span>Already registered? <a href="/" th:href="@{/login}">Login here</a></span>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
