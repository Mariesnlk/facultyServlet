<%--
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
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="regbox box">
        <img class="avatar" src="img/collaboration.png">
        <h1>
            Register Account</h1>
        <form action="RegisterServlet" method="post">
            <p>First name</p>
            <input type="text" placeholder="First name" name="firstName" required>
            <p>Second name</p>
            <input type="text" placeholder="Second name" name="secondName" required>
            <p>Last name</p>
            <input type="text" placeholder="Last name" name="lastName" required>
            <p>Email</p>
            <input type="text" placeholder="Email" name="email" required>
            <p>Password</p>
            <input type="password" placeholder="Password" name="password" required>
            <p>Confirm password</p>
            <input type="password" placeholder="Confirm password" name="confirmPassword" required>
            <input type="submit" value="Register">
            <a href="../index1.jsp">Already have Account?</a>
        </form>
    </div>
</div>
</body>
</html>
