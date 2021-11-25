<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 22.11.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>
<fmt:setBundle basename="${cookie.bundle.value}"/>
<%@ include file="/fragments/navbar-all.jsp" %>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1><fmt:message key="login_page"/></h1>
            <form action="<%=request.getContextPath()%>/faculty<%=LOGIN%>" method="POST">
                <div class="form-group">
                    <label for="email"><fmt:message key="login_email"/></label>: <input type="text" id="email"
                                                                                        name="email"
                                                                                        class="form-control"
                                                                                        autofocus="autofocus"
                                                                                        placeholder="Email"/>
                </div>
                <div class="form-group">
                    <label for="password"><fmt:message key="login_password"/></label>: <input type="password"
                                                                                              id="password"
                                                                                              name="password"
                                                                                              class="form-control"
                                                                                              placeholder="Password"/>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Log In"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <span><fmt:message key="new_user"/></span> <span><a href="${pageContext.request.contextPath}/faculty<%=REGISTER_PAGE%>">
                    <fmt:message key="register_here"/></a></span>
                    <span><a href="#" style="float: right"><fmt:message key="forgot_your_password"/></a></span>
                </div>
            </form>
        </div>
    </div>
    </form>
    <c:if test="${errors != null}">
        <c:forEach items="${errors}" var="error">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
