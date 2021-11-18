<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show employee</title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.png");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        text-align: center;
        color: rgba(220, 0, 0, 1);;
    }

    .button {
        border: 0;
        line-height: 2.5;
        padding: 0 20px;
        font-size: 1rem;
        text-align: center;
        color: #fff;
        text-shadow: 1px 1px 1px #000;
        border-radius: 10px;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        box-shadow: inset 2px 2px 3px rgba(255, 255, 255, .6),
        inset -2px -2px 3px rgba(0, 0, 0, .6);
    }

    #table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 40%;
    }

    .value {
        border: 1px solid #000000;
        padding: 8px;
        background-color: rgba(255, 255, 255, 0.5);
    }

    .info {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        color: white;
    }

</style>
<br>

<div>
    <h1>Інформація про працівника </h1>
</div>
<br>
<div>
    <%
        Employee employee = (Employee) request.getAttribute("employeeSpecific");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td class="info">Прізвище:</td>
                <td class="value">
                    <%
                        out.println(employee.getEmpl_surname());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Номер телефону:</td>
                <td class="value">
                    <%
                        out.println(employee.getPhone_number());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Місто:</td>
                <td class="value">
                    <%
                        out.println(employee.getCity());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Вулиця:</td>
                <td class="value">
                    <%
                        out.println(employee.getStreet());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Індекс:</td>
                <td class="value">
                    <%
                        out.println(employee.getZip_code());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Логін:</td>
                <td class="value">
                    <%
                        out.println(employee.getLogin());
                    %>
                </td>
            </tr>
            <tr>
                <td class="info">Пароль:</td>
                <td class="value">
                    <%
                        out.println(employee.getPassword());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>

</body>
</html>
