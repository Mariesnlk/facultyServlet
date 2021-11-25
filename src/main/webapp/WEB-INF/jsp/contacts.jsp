<%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 24.11.2021
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Contacts</title>
    <link href="${pageContext.request.contextPath}/css/contacts.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<jsp:include page="../../fragments/navbar-all.jsp"></jsp:include>

<!-- Contact Section Begin -->
<section class="contact-section spad contact-info" style="margin-top: 2%;">
    <div class="container">
        <div class="row">
            <div class="col-6">
                <div class="col-lg-4">
                    <div class="contact-text">
                        <h2>Contact Info</h2>
                        <table>
                            <tbody>
                            <tr>
                                <td class="c-o">Address:</td>
                                <td>Hryhoriy Skovoroda Street, 2, Kyiv, 04655, Ukraine</td>
                            </tr>
                            <tr>
                                <td class="c-o">Phone:</td>
                                <td>(12) 345 67890</td>
                            </tr>
                            <tr>
                                <td class="c-o">Email:</td>
                                <td>test.email.mariia@gmail.com</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="map">
                    <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2539.711119240782!2d30.517226415731912!3d50.46510387947737!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4ce3f8783f067%3A0x20e77fb079389395!2z0J3QsNGG0ZbQvtC90LDQu9GM0L3QuNC5INGD0L3RltCy0LXRgNGB0LjRgtC10YIgItCa0LjRlNCy0L4t0JzQvtCz0LjQu9GP0L3RgdGM0LrQsCDQsNC60LDQtNC10LzRltGPIg!5e0!3m2!1suk!2sua!4v1591727857832!5m2!1suk!2sua"
                            height="470" style="border:0;" allowfullscreen=""></iframe>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Contact Section End -->

</body>
</html>
