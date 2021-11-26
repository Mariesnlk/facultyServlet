<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 26.11.2021
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit admin page</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-admin.jsp" %>
<div class="container emp-profile">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img alt="user" src="${pageContext.request.contextPath}/img/icons/author.png" style="height: 300px;"/>
                </div>
            </div>

            <div class="col-md-6">
                <div class="profile-head">
                    <h3 id="user-name"></h3>

                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" role="tab"
                               aria-controls="home" aria-selected="true">About</a>
                        </li>
                    </ul>

                    <form method="POST" action="${pageContext.request.contextPath}/faculty<%=UPDATE_USER%>" class="form">

                        <div class="row">
                            <div class="col-md-6">
                                <label class="text-3">First name:</label>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="text" id="firstName" name="firstName" value="<c:out value="${sessionScope.loginPerson.firstName}"/>"
                                       placeholder="First name">
                                <%--                                <div class="alert alert-warning" th:if="${#fields.hasErrors('firstName')}"--%>
                                <%--                                     th:errors="*{firstName}"></div>--%>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label class="text-3">Second name:</label>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="text" name="secondName" value="<c:out value="${sessionScope.loginPerson.secondName}"/>" id="secondName"
                                       placeholder="Second name">
                                <%--                                <div class="alert alert-warning" th:if="${#fields.hasErrors('secondName')}"--%>
                                <%--                                     th:errors="*{secondName}"></div>--%>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label class="text-3">Last name:</label>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="text" name="lastName" value="<c:out value="${sessionScope.loginPerson.lastName}"/>" id="lastName"
                                       placeholder="Last name">
                                <%--                                <div class="alert alert-warning" th:if="${#fields.hasErrors('lastName')}"--%>
                                <%--                                     th:errors="*{lastName}"></div>--%>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label class="text-3">Email:</label>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="text" name="email" value="<c:out value="${sessionScope.loginPerson.email}"/>" id="email"
                                       placeholder="Email">
                                <%--                                <div class="alert alert-warning" th:if="${#fields.hasErrors('email')}"--%>
                                <%--                                     th:errors="*{email}"></div>--%>
                            </div>
                        </div>
                        <div class="col-md-6"></div>
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-success profile-edit-btn btnSaveUser">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</div>
</body>
</html>

