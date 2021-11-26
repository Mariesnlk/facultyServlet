<%@ page import="static com.example.faculty.controller.command.PathCommand.REGISTER_USER" %>
<%@ page import="static com.example.faculty.controller.command.PathCommand.LOGIN_PAGE" %><%--
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
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<fmt:setBundle basename="${cookie.bundle.value}"/>
<%@ include file="/fragments/navbar-all.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <h1><fmt:message key="registration"/></h1>

            <form method="POST" action="${pageContext.request.contextPath}/faculty<%=REGISTER_USER%>" class="form">

                <div class="form-group">
                    <label for="firstName"><fmt:message key="first.name"/></label>
                    <input class="form-control" type="text" name="firstName" id="firstName"
                           placeholder="Enter first name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check first name</p>
                        </div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="secondName"><fmt:message key="second.name"/></label>
                    <input class="form-control" type="text" name="secondName" id="secondName"
                           placeholder="Enter second name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check second name</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="lastName"><fmt:message key="last.name"/></label>
                    <input class="form-control" type="text" name="lastName" id="lastName"
                           placeholder="Enter last name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check last name</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="email"><fmt:message key="user_email"/></label>
                    <input class="form-control" type="text" name="email" id="email" placeholder="Enter email">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check email</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="password"><fmt:message key="user_password"/></label>
                    <input class="form-control" type="password" id="password" name="password"
                           placeholder="Enter password">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check password</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="confirmPassword"><fmt:message key="user_confirm_password"/></label>
                    <input class="form-control" name="confirmPassword" type="password" id="confirmPassword"
                           name="confirmPassword" placeholder="Confirm password">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Check confirmed password</p>
                        </div>
                    </c:if>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success"><fmt:message key="register"/></button>
                    <span><fmt:message key="already.register"/> <a href="${pageContext.request.contextPath}/faculty<%=LOGIN_PAGE%>"><fmt:message key="login.here"/></a></span>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
