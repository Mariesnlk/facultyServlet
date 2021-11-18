<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
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

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.5);
        padding: 20px;
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

    form {
        text-align: left;
    }

</style>
<br>

<div>
    <%
        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {
            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");
        }
    %>

    <h1>Реєстрація працівника</h1>

    <div>
        <form action="/add-employee" method="post">
            <%--  added regex --%>
            <label>ID: </label> <input type="text" name="id" placeholder="Введіть ID працівника.."><br/>
            <%--  added regex --%>
            <label>Прізвище: </label> <input type="text" name="lastName" placeholder="Введіть ваше прізвище.."><br/>
            <%--  added regex --%>
            <label>Ім`я: </label><input type="text" name="firstName" placeholder="Введіть ваше ім`я.."><br/>
            <%--  added regex --%>
            <label>По-батькові: </label><input type="text" name="patronymicName" placeholder="по-батькові.."><br/>
            <label>Роль: </label>
            <select name="role">
                <option value="manager">менеджер</option>
                <option value="cashier">касир</option>
            </select><br/>
            <label>Зарплата: </label><input type="text" name="salary" placeholder="Введіть зарплату.."><br/>
            <br>
            <label>Дата народження: </label><input type="date" name="birthDate"
                                                   value="2021-03-22"
                                                   max="2003-01-01"><br/>
            <br>
            <label>Дата початку роботи: </label><input type="date" name="startDate" value="2021-03-22"><br/>
            <br>
            <label for="phoneNum">Номер телефону (формат: +xxx-xxx-xx-xx): </label>
            <%--  should start with + and consists not more than 13 symbols --%>
            <input id="phoneNum" name="phoneNum" type="tel" pattern="^\d{3}-\d{3}-\d{2}-\d{2}$" required><br/>
            <br>
            <%--  added regex --%>
            <label>Місто: </label><input type="text" name="city" placeholder="Введіть місто.."><br/>
            <%--  added regex --%>
            <label>Вулиця: </label><input type="text" name="street" placeholder="Введіть вулицю.."><br/>
            <%--  added regex --%>
            <label>Індекс: </label><input type="text" name="zipCode" placeholder="Введіть індекс.."><br/>

            <label>Логін: </label><input type="text" name="login" placeholder="Введіть логін.."><br/>
            <label>Пароль: </label><input type="password" name="password" placeholder="Введіть пароль.."><br/>
            <br>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
