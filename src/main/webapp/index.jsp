<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 23.11.2021
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static com.example.faculty.controller.command.PathCommand.REGISTER_PAGE" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Main page</title>

    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

</head>
<body>

<fmt:setBundle basename="${cookie.bundle.value}"/>

<jsp:include page="fragments/navbar-all.jsp"></jsp:include>

<!-- Hero Section Begin -->
<section class="hero-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="hero-text">
                    <h1><fmt:message key="main.info.h1"/></h1>
                    <p><fmt:message key="main.info.p"/></p>
                    <span><fmt:message key="new_user"/></span> <span><a href="${pageContext.request.contextPath}/faculty<%=REGISTER_PAGE%>"><fmt:message key="register_here"/></a></span>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

</body>
</html>
