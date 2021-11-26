<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 24.11.2021
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Teacher</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-admin.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1>Add a new Teacher</h1>
            <form method="POST" action="${pageContext.request.contextPath}/faculty<%=ADD_TEACHER%>" class="form">
                <div class="form-group">
                    <label for="email">Email *</label>
                    <input class="form-control" type="text" name="email" id="email" placeholder="Enter teacher`s email">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Email is null or empty</p>
                        </div>
                    </c:if>
                    <c:if test="${param.notValid == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Invalid email</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="firstName">First name *</label>
                    <input class="form-control" type="text" name="firstName" id="firstName"
                           placeholder="Enter teacher`s fisrt name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Name is null or empty</p>
                        </div>
                    </c:if>
                    <c:if test="${param.notValid == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Invalid name</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="secondName">Second name *</label>
                    <input class="form-control" type="text" name="secondName" id="secondName"
                           placeholder="Enter teacher`s second name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Name is null or empty</p>
                        </div>
                    </c:if>
                    <c:if test="${param.notValid == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Invalid name</p>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="lastName">Last name *</label>
                    <input class="form-control" type="text" name="lastName" id="lastName"
                           placeholder="Enter teacher`s last name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Name is null or empty</p>
                        </div>
                    </c:if>
                    <c:if test="${param.notValid == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Invalid name</p>
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
</body>
</html>

