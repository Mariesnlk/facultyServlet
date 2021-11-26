<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 26.11.2021
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Complete Registration for teacher</title>
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-all.jsp" %>


<!-- Hero Section Begin -->
<section class="hero-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="hero-text">
                    <h1>Are you a teacher?</h1>
                    <div class="hero-text">
                        <h3>If yes, complete registration</h3>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 col-md-offset-3">
                                    <c:if test="${param.notExistEmail == true}">
                                        <div class="alert alert-warning">
                                            <p class="errorsM">Sorry, you are not register as a teacher</p>
                                        </div>
                                    </c:if>
                                    <div>
                                        <c:if test="${param.register == true}">
                                            <div class="alert alert-info">
                                                <p class="alert-success">You have successfully confirm your email! </p>
                                            </div>
                                        </c:if>
                                    </div>
                                    <form method="POST"
                                          action="${pageContext.request.contextPath}/faculty<%=TEACHER_REGISTRATION_COMPLETE%>"
                                          class="form">
                                        <div class="form-group">
                                            <label for="email">Email *</label>
                                            <input class="form-control" type="text" name="email" id="email"
                                                   placeholder="Enter your email">
                                            <c:if test="${param.badInput == true}">
                                                <div class="alert alert-warning">
                                                    <p class="errorsM">Email is not valid</p>
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="form-group">
                                            <label for="password">Password *</label>
                                            <input class="form-control" type="password" name="password" id="password"
                                                   placeholder="Enter your password">
                                            <c:if test="${param.badInput == true}">
                                                <div class="alert alert-warning">
                                                    <p class="errorsM">Password is not valid</p>
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="form-group">
                                            <label for="confirmPassword">Confirm password *</label>
                                            <input class="form-control" type="password" name="confirmPassword"
                                                   id="confirmPassword" placeholder="Confirm your password">
                                            <c:if test="${param.badInput == true}">
                                                <div class="alert alert-warning">
                                                    <p class="errorsM">Confirmed password is not valid</p>
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-success">Save</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

</body>
</html>
