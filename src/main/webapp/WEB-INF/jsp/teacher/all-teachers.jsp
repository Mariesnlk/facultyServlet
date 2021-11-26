<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 24.11.2021
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All topics</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/userPage.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<c:if test="${sessionScope.loginPerson.role == 'ADMINISTRATOR'}">
    <%@ include file="/fragments/navbar-admin.jsp" %>
</c:if>
<c:if test="${sessionScope.loginPerson.role == 'STUDENT'}">
    <%@ include file="/fragments/navbar-student.jsp" %>
</c:if>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="table">
                <div>
                    <h2>All Teachers</h2>
                    <table id="incomes_table" class="table table-bordered">
                        <thead>
                        <tr class="table-success">
                            <th class="table-th">Full name</th>
                            <th class="table-th">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.teachersList}" var="teacher" begin="0"
                                   end="${requestScope.recordPerPage -1}">
                            <tr>
                                <td class="table-success"><c:out value="${teacher.firstName} ${teacher.secondName} ${teacher.lastName}"/></td>
                                <td class="table-success"><c:out value="${teacher.email}"/></td>
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
                                           href="${pageContext.request.contextPath}/faculty<%=ALL_TEACHERS_PAG%>?pagination=${pagNumber}">
                                            <c:out value="${pagNumber}"/></a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                    <!------- Paging ------>

                </div>
                <div class="container">
                    <p><a id="add-new" href="${pageContext.request.contextPath}/faculty<%=ADD_TEACHER_FORM%>">Add a new
                        teacher</a></p>
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
