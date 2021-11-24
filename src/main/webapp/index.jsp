<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 23.11.2021
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static com.example.faculty.controller.command.PathCommand.REGISTER_USER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <%-- localization   <fmt:message key="navbar.navbarHeader"/>--%>
    <title>Main page</title>

    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
<%--          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
</head>
<body>

<% String context = request.getContextPath(); %>

<%--<%@ include file="fragments/navbar-all.jsp" %>--%>

<jsp:include page="fragments/navbar-all.jsp"></jsp:include>

<!-- Hero Section Begin -->
<section class="hero-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="hero-text">
                    <h1>Faculty Site - the best matches for your education</h1>
                    <p>Find all information about courses and teacher, enroll for courses and
                        review your grades.</p>
                    <span>New user?</span> <span><a href="<%=context%>/faculty<%=REGISTER_USER%>">Register here</a></span>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

</body>
</html>
