<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Employees</title>
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
        width: 100%;
    }

    #table td, #table th {
        border: 1px solid #000000;
        padding: 8px;
        background-color: rgba(255, 255, 255, 0.7);
    }

    #table th {
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

    @media print {

        #printableTable {
            display: block;
        }
    }

</style>
<br>
<div>
    <h1>Всі працівники</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-employee'" value='Додати Працівника'>
</div>
<br>
<br>
<div id="printableTable">
<div>
    <div>

        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("allEmployees");
            if (employees != null && !employees.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Прізвище</th>
                <th>Ім'я</th>
                <th>По-батькові</th>
                <th>Роль</th>
                <th>Зарплата</th>
                <th>Дата народження</th>
                <th>Дата початку роботи</th>
                <th>Номер телефону</th>
                <th>Місто</th>
                <th>Вулиця</th>
                <th>Індекс</th>
                <th>Логін</th>
                <th>Пароль</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Employee employee : employees) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/employee?id=" + employee.getId_employee() + "\">"
                            + employee.getId_employee() + "</a></td>");
                    out.println("<td>" + employee.getEmpl_surname() + "</td>");
                    out.println("<td>" + employee.getEmpl_name() + "</td>");
                    out.println("<td>" + employee.getEmpl_patronymic() + "</td>");
                    out.println("<td>" + employee.getRole() + "</td>");
                    out.println("<td>" + employee.getSalary() + "</td>");
                    out.println("<td>" + employee.getDate_of_birth() + "</td>");
                    out.println("<td>" + employee.getDate_of_start() + "</td>");
                    out.println("<td>" + employee.getPhone_number() + "</td>");
                    out.println("<td>" + employee.getCity() + "</td>");
                    out.println("<td>" + employee.getStreet() + "</td>");
                    out.println("<td>" + employee.getZip_code() + "</td>");
                    out.println("<td>" + employee.getLogin() + "</td>");
                    out.println("<td>" + employee.getPassword() + "</td>");

                    out.println("<td><a href=\"/update-employee?id=" + employee.getId_employee()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-employee?id=" + employee.getId_employee()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no employees yet!</p>");
            }
        %>

    </div>
</div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-employee'" value='Додати Працівника'>
    <br><br>
    <button class="Button Button--outline button" onclick="printDiv()">Друкувати</button>
</div>

<iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>

<script>
    function printDiv() {
        window.frames["print_frame"].document.body.innerHTML = document.getElementById("printableTable").innerHTML;
        window.frames["print_frame"].window.focus();
        window.frames["print_frame"].window.print();
    }
</script>

</body>
</html>
