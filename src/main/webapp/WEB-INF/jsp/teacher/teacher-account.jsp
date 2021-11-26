<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 22.11.2021
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Teacher page</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-teacher.jsp" %>

<div class="container emp-profile">

    <form method="post">
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

                    <div class="row">
                        <div class="col-md-6">
                            <label class="text-3">First name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${sessionScope.loginPerson.firstName}"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label class="text-3">Second name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${sessionScope.loginPerson.secondName}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Last name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${sessionScope.loginPerson.lastName}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Email:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${sessionScope.loginPerson.email}"/></label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <button id="updateUser" type="button" class="profile-edit-btn btnSaveUser"
                        name="btnAddMore"><a href="#">Edit</a>
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

