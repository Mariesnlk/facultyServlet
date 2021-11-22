<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cashier`s page</title>

    <style>

        body {
            background-image: url("/images/background.png");
            background-repeat: no-repeat;
            background-size: cover;
        }

        .button {
            border: 0;
            line-height: 2.3;
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

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            border: none;
        }

        .my-table {
            width: 28%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        .my-td {
            border: none;
            padding: 0px;
        }

        /*for submit button*/
        .my-td-cust {
            border: none;
            padding: 10px;
        }

        .sub-but-row {
            width: 140px;
        }

        .my-row {
            width: 220px;
        }

        .td-filled-left {
            background-color: rgba(255, 255, 255, 0.6);
            border: 1px white;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 0px;
            border-top-left-radius: 10px;
            border-top-right-radius: 0px;
        }

        .td-filled-right {
            background-color: rgba(255, 255, 255, 0.6);
            border: 1px white;
            border-bottom-left-radius: 0px;
            border-bottom-right-radius: 10px;
            border-top-left-radius: 0px;
            border-top-right-radius: 10px;
        }

        .td-filled-middle {
            background-color: rgba(255, 255, 255, 0.6);
            border: 1px white;
            border-bottom-left-radius: 0px;
            border-bottom-right-radius: 0px;
            border-top-left-radius: 0px;
            border-top-right-radius: 0px;
        }

        .td-filled-both {
            background-color: rgba(255, 255, 255, 0.6);
            border: 1px white;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

    </style>

</head>
<body>

<h1>Сторінка касира</h1>

<table cellspacing="2" border="1" cellpadding="5" width="300" class="my-table">
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/logout'" value='Вийти'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
    </td>
</table>

<br>

<h1>Запити касира</h1>

<%
    Employee registeredEmployee = (Employee) session.getAttribute("registeredEmployee");
    String idEmployee = registeredEmployee.getId_employee();

%>

<div>


    <form action="/print-check" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Виберіть чек, який бажаєте друкувати</td>

            <td class="my-row td-filled-right"><label>Номер чека: </label>
                <select name="checkNum">
                    <%
                        List<Check> checksList = (List<Check>) request.getAttribute("allChecks");
                        for (Check check : checksList) {
                    %>
                    <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>


    <form action="/list-products-in-check" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">За номером чека скласти список усіх товарів, інформація про продаж яких є у цьому чеку</td>

            <td class="my-row td-filled-right"><label>Номер чека: </label>
                <select name="checkNum">
                    <%
                        List<Check> checkList = (List<Check>) request.getAttribute("allChecks");
                        for (Check check : checkList) {
                    %>
                    <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/checkInfo" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">За номером чеку вивести усю інформацію про даний чек</td>

            <td class="my-row td-filled-right"><label>Номер чека: </label>
                <select name="checkNumber">
                    <%
                        List<Check> checkList1 = (List<Check>) request.getAttribute("allChecks");
                        for (Check check : checkList1) {
                    %>
                    <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/storeProductByUpc" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару</td>

            <td class="my-row td-filled-right"><label>UPC товару: </label>
                <select name="upc">
                    <%
                        List<StoreProduct> prodStList = (List<StoreProduct>) request.getAttribute("allStoreProducts");
                        for (StoreProduct prod : prodStList) {
                    %>
                    <option value=<%=prod.getUPC()%>><%=prod.getUPC()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/list-sorted-products-in-category" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список товарів, що належать певній категорії, відсортованих за назвою</td>

            <td class="my-row td-filled-right"><label>Номер категорії: </label>
                <select name="categoryProd">
                    <%
                        List<Category> cattList = (List<Category>) request.getAttribute("allCategories");
                        for (Category category : cattList) {
                    %>
                    <option value=<%=category.getCategory_name()%>><%=category.getCategory_name()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/show-customer-info-by-surname" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Вивести усю інформацію про покупця з певним прізвищем, що має карту клієнта</td>

            <td class="my-row td-filled-right"><label>Прізвище клієнта: </label>
                <select name="custSurname">
                    <%
                        List<CustomerCard> surnameList = (List<CustomerCard>) request.getAttribute("allCustomerCards");
                        for (CustomerCard cust : surnameList) {
                    %>
                    <option value=<%=cust.getCust_surname()%>><%=cust.getCust_surname()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/list-customers-by-percent" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список усіх постійних клієнтів, що мають карту клієнта із певним відсотком</td>

            <td class="my-row td-filled-right"><label>Відсоток знижки: </label>
                <select name="percent">
                    <%
                        List<CustomerCard> percList = (List<CustomerCard>) request.getAttribute("allCustomerCards");
                        for (CustomerCard cust : percList) {
                    %>
                    <option value=<%=cust.getPercent()%>><%=cust.getPercent()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>


    <form action="/list-check-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список чеків, видрукуваних даним касиром за певний період часу</td>
            <%
                out.println("<input type=\"text\" name=\"idCashier\" value=\"" + idEmployee + "\" hidden>");
            %>
            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-right"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/sort-prom" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список усіх акційних товарів, відсортованих за кількістю одиниць товару/ за назвою</td>

            <td class="my-row td-filled-right"><label>Сортувати: </label>
                <select name="sorting">
                    <option value="byQuantity">за кількістю одиниць</option>
                    <option value="byName">за назвою</option>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/sort-products-name" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">Скласти список усіх товарів, відсортований за назвою</td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/employeeCurr?id=<%=idEmployee%>" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">За ID працівника знайти всю інформацію про себе</td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>
</div>

<br>
<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>
<br>

</body>
</html>
