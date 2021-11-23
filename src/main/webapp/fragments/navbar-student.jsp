<!DOCTYPE HTML>
<%@ page import="static com.example.faculty.controller.command.PathCommand.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<fmt:setLocale value="${sessionScope.lang}"/>--%>
<%--<fmt:setBundle basename="messages"/>--%>

<%--<html lang="${sessionScope.lang}">--%>
<html>
<head><title></title></head>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<% String context = request.getContextPath(); %>

<!-- Header Section Begin -->
<header class="header-section">
    <div class="top-nav">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <ul class="tn-left">
                        <li>
                            <img src="${pageContext.request.contextPath}/img/icons/tel.svg" alt="tel"> (12) 345 67890
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/img/icons/email.svg" alt="email">
                            test.email.mariia@gmail.com
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6">
                    <div class="tn-right">
                        <div class="language-option">
                            <span>Choose language <i class="fa fa-angle-down"></i></span>
                            <div class="flag-dropdown">
                                <ul>
                                    <li><a href="?lang=ua">ua</a></li>
                                    <li><a href="?lang=en">en</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="menu-item">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="logo">
                        <a href="#"><h2>Faculty site</h2></a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="nav-menu">
                        <nav class="mainmenu">
                            <ul>
                                <li><a href="<%=context%><%=STUDENT_COURSES%>">My courses</a></li>
                                <li><a href="<%=context%><%=ALL_COURSES%>">Courses</a></li>
                                <li><a href="<%=context%><%=ALL_TEACHERS%>">Teachers</a></li>
                                <li><a href="<%=context%><%=ABOUT%>">About us</a></li>
                                <li><a href="<%=context%><%=CONTACTS%>">Contact info</a></li>
                                <%--                                <c:if test="${sessionScope.userEmail == null}">--%>
                                <li>
                                    <a href="<%=context%><%=LOGIN%>">
                                        <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;Sign
                                        in
                                    </a>
                                </li>
                                <%--                                </c:if>--%>
                                <%--                                <c:if test="${sessionScope.userEmail != null}">--%>
                                <li>
                                    <a href="<%=context%><%=LOGOUT%>">
                                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;Logout
                                    </a>
                                </li>
                                <%--                                </c:if>--%>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Header End -->
</html>