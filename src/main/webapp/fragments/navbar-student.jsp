<!DOCTYPE HTML>
<%@ page import="static com.example.faculty.controller.command.PathCommand.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title></title></head>
<link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<fmt:setBundle basename="${cookie.bundle.value}"/>
<!-- Header Section Begin -->
<header class="header-section">
    <div class="top-nav">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <ul class="tn-left">
                        <li>
                            <img src="${pageContext.request.contextPath}/img/icons/tel.png" alt="tel" style="width: 30px;"> (12) 345 67890
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/img/icons/email.png" alt="email" style="width: 50px;">
                            test.email.mariia@gmail.com
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6">
                    <div class="tn-right">
                        <div class="language-option">
                            <span><fmt:message key="choose_language"/> <i class="fa fa-angle-down"></i></span>
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
                        <a href="${pageContext.request.contextPath}/faculty<%=STUDENT_ACCOUNT%>"><h2>Faculty site</h2></a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="nav-menu">
                        <nav class="mainmenu">
                            <ul>
<%--                                <li><a href="${pageContext.request.contextPath}/faculty<%=STUDENT_COURSES%>?pagination=1">--%>
                                <li><a href="${pageContext.request.contextPath}/faculty<%=STUDENT_COURSES%>">
                                    <fmt:message key="navbar.my_courses"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/faculty<%=ALL_COURSES_PAG%>?pagination=1">
                                    <fmt:message key="navbar.courses"/></a></li>
                                <li><a  href="${pageContext.request.contextPath}/faculty<%=ALL_TEACHERS_PAG%>?pagination=1">
                                    <fmt:message key="navbar.teachers"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/faculty<%=ABOUT%>">
                                    <fmt:message key="navbar.about"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/faculty<%=CONTACTS%>">
                                    <fmt:message key="navbar.contacts"/></a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/faculty<%=LOGIN_PAGE%>">
                                        <span class="glyphicon glyphicon-log-in"
                                              aria-hidden="true"></span>&nbsp;<fmt:message key="sign_in"/>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/faculty<%=LOGOUT%>">
                                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;
                                        <fmt:message key="logout"/>
                                    </a>
                                </li>
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