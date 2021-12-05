<%@ page import="static com.example.faculty.database.Queries.UPDATE_COURSE" %><%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 24.11.2021
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Course</title>
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
            <h1>Edit course</h1>
            <form method="POST"
                  action="${pageContext.request.contextPath}/faculty<%=UPDATE_COURSES%>?course=${requestScope.course.courseId}"
                  class="form">
                <div class="form-group">
                    <label for="name">Course name *</label>
                    <input class="form-control" type="text" name="name" id="name"
                           value="${requestScope.course.courseName}"
                           placeholder="Enter topic name">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Course name cannot be null or empty</p>
                        </div>
                    </c:if>
                    <c:if test="${param.notValid == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Course name is not valid</p>
                        </div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="topic">Topic *</label>
                    <select name="topic" class="custom-select form-control" id="topic"
                            value="${requestScope.course.topic}">
                        <c:forEach items="${requestScope.topicsList}" var="topic">
                            <option value="${topic.topicId}"
                                    <c:if test="${topic.topicId == requestScope.course.topic}">
                                        selected
                                    </c:if>
                            >${topic.topicName}

                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="studentsAmount">Students amount *</label>
                    <input class="form-control" aria-label="With textarea" type="number" id="studentsAmount"
                           min="10" max="60" name="studentsAmount" placeholder="amount"
                           value="${requestScope.course.studentsAmount}">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Students amount cannot be null or empty</p>
                        </div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="duration">Course duration *</label>
                    <input class="form-control" aria-label="With textarea" type="number" id="duration"
                           min="1" max="2" name="duration" placeholder="duration"
                           value="${requestScope.course.duration}">
                    <c:if test="${param.badInput == true}">
                        <div class="alert alert-warning">
                            <p class="errorsM">Duration cannot be null or empty</p>
                        </div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="teacher">Teacher *</label>
                    <select name="teacher" class="custom-select form-control" id="teacher"
                            value="${requestScope.course.teacher}">
                        <c:forEach items="${requestScope.teachersList}" var="teacher">
                            <option value="${teacher.userId}">${teacher.firstName} ${teacher.secondName} ${teacher.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="status">Status *</label>
                    <select name="status" class="custom-select form-control" id="status"
                            value="${requestScope.course.status}">
                        <c:forEach items="${requestScope.statuses}" var="status">
                            <option value="${status}">${status.name()}</option>
                        </c:forEach>
                    </select>
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
