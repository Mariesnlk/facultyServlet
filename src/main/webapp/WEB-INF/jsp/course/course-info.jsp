<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 05.12.2021
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Course info</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-teacher.jsp" %>

<div class="container">

    <form method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="profile-head">

                    <div class="row">
                        <div class="col-md-6">
                            <label class="text-3">Course Name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${requestScope.course.courseName}"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label class="text-3">Topic name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3 "><c:out value="${requestScope.course.topic.topicName}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Teacher name:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out
                                    value="${requestScope.course.teacher.firstName} ${requestScope.course.teacher.secondName} ${requestScope.course.teacher.lastName}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Duration:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${requestScope.course.duration}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Students amount:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${requestScope.course.studentsAmount}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Enroll students:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${requestScope.course.enrollStudents}"/></label>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-6">
                            <label class="text-3">Course status:</label>
                        </div>
                        <div class="col-md-6">
                            <label class="text-3"><c:out value="${requestScope.course.status}"/></label>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </form>
</div>

<div id="table">
    <div>
        <h2>All Students</h2>
        <table id="incomes_table" class="table table-bordered">
            <thead>
            <tr class="table-success">
                <th class="table-th">Name</th>
                <c:if test="${requestScope.course.status == 'FINISH'}">
                    <th class="table-th">Mark</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.studentsMark}" var="studentMark">
                <tr>
                    <td class="table-success"><c:out value="${studentMark.firstName} ${studentMark.secondName} ${studentMark.lastName}"/></td>
                    <td>
                        <c:if test="${requestScope.course.status == 'FINISH'}">
                            <form method="POST" action="${pageContext.request.contextPath}/faculty<%=SET_MARK%>?course=${requestScope.course.courseId}&student=${studentMark.id}&mark=${mark}" class="form">
                                <div class="form-group">
                                    <input type="number" name="mark" id="mark" min="60" max="100" value="${studentMark.mark}"/>
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
