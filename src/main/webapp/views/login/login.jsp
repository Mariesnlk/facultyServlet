<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.png");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1, h2 {
        text-align: center;
        color: rgba(220, 0, 0, 1);
    }

    input[type=text], select {
        width: 25%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 25%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    div{
        margin-top: 5px;
        margin-bottom: 5px;
        text-align: center;
    }

    .button, .container.button {
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

    .container{
        text-align: center;
    }

</style>

<br>
<h1>Please Login</h1>

<div class="container">
    <form action="/login" method="POST">
        <div>
            <input type="text" name="employeeLogin" placeholder="Введіть логін"/>
        </div>
        <div>
            <input type="password" name="employeePassword" placeholder="Введіть пароль"/>
        </div>
        <br>
        <div>
            <button class="button" type="submit">Підтвердити</button>
        </div>
    </form>
</div>

<div>
    <input class="button" type=button onClick="location.href='../..'" value='Повернутися на головну'>
</div>

</body>
</html>

