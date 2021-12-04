<%--
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
    <title>All Courses</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="/fragments/navbar-admin.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="table">
                <div>
                    <h2>ALL COURSES</h2>

                    <c:if test="${requestScope.isEnroll == true}">
                        <div class="alert alert-info">You enroll to this course</div>
                    </c:if>
                    <c:if test="${requestScope.isEnroll == false}">
                        <div class="alert alert-warning">You already enroll to this course</div>
                    </c:if>

                    <table id="incomes_table" class="table table-bordered">
                        <thead>
                        <tr class="table-success">
                            <th class="table-th">Name</th>
                            <th class="table-th">Topic</th>
                            <th class="table-th">Teacher</th>
                            <th class="table-th">Duration</th>
                            <th class="table-th">Students amount</th>
                            <th class="table-th">Enroll students</th>
                            <th class="table-th">Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.coursesList}" var="course" begin="0"
                                   end="${requestScope.recordPerPage -1}">
                            <tr>
                                <td class="table-success"><c:out value="${course.courseName}"/></td>
                                <td class="table-success"><c:out value="${course.topic}"/></td>
                                <td class="table-success"><c:out value="${course.teacher}"/></td>
                                    <%--                                <td class="table-success"><c:out value="${course.topic.topicName}"/></td>--%>
                                    <%--                                <td class="table-success"><c:out value="${course.teacher.firstName} ${course.teacher.secondName} ${course.teacher.lastName}"/></td>--%>
                                <td class="table-success"><c:out value="${course.duration}"/></td>
                                <td class="table-success"><c:out value="${course.studentsAmount}"/></td>
                                <td class="table-success"><c:out value="${course.enrollStudents}"/></td>
                                <td class="table-success"><c:out value="${course.status}"/></td>
                                <c:if test="${sessionScope.loginPerson.role == 'ADMINISTRATOR'}">
                                    <td class="edit-delete">
                                        <a href="${pageContext.request.contextPath}/faculty<%=UPDATE_COURSE_FORM%>?course=${course.courseId}">Edit</a>
                                    </td>
                                    <td class="edit-delete">
                                        <a href="${pageContext.request.contextPath}/faculty<%=DELETE_COURSE_PATH%>?course=${course.courseId}">Delete</a>
                                    </td>
                                </c:if>
                                <c:if test="${sessionScope.loginPerson.role == 'STUDENT'}">
                                    <td class="edit-delete" id="hide">
                                        <a href="${pageContext.request.contextPath}/faculty<%=ENROLL%>?course=${course.courseId}">Enroll</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <!------ Paging ------->
                    <div class="con-pagination">
                        <nav aria-label="Page navigation" class="paging">
                            <ul class="pagination pagination-sm justify-content-center">
                                <c:forEach var="pagNumber" begin="1" end="${requestScope.pageNumbers}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="${pageContext.request.contextPath}/faculty<%=ALL_COURSES_PAG%>?pagination=${pagNumber}">
                                            <c:out value="${pagNumber}"/></a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                    <!------- Paging ------>

                </div>
                <div class="container">
                    <p><a id="add-new" href="${pageContext.request.contextPath}/faculty<%=ADD_COURSE_FORM%>">Add a new
                        course</a></p>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
