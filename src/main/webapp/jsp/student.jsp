<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager`s page</title>

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

<h1>Сторінка менеджера</h1>

<table cellspacing="2" border="1" cellpadding="5" width="300" class="my-table">
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/logout'" value='Вийти'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
    </td>
</table>

<br>

<table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-employee'"
               value='Додати працівника'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-category'"
               value='Додати категорію'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-product'"
               value='Додати продукт'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-customerCard'"
               value='Додати карту клієнта'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-check'"
               value='Додати чек'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-sale'"
               value='Додати продаж товару'>
    </td>
    <td class="sub-but-row my-td">
        <input class="button" type=button onClick="location.href='/add-storeProduct'"
               value='Додати товар в магазині'>
    </td>
</table>

<br>

<h1>Запити менеджера</h1>

<div>

    <form action="/list-products-in-category" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список всіх товарів, що належать певній категорії</td>

            <td class="my-row td-filled-right"><label>Номер категорії: </label>
                <select name="categoryProd">
                    <%
                        List<Category> catList = (List<Category>) request.getAttribute("allCategories");
                        for (Category category : catList) {
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

    <form action="/list-store-products" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список товарів у магазині, що належать певному товару</td>

            <td class="my-row td-filled-right"><label>Назва товару: </label>
                <select name="nameProd">
                    <%
                        List<Product> prodList = (List<Product>) request.getAttribute("allProducts");
                        for (Product prod : prodList) {
                    %>
                    <option value=<%=prod.getProduct_name()%>><%=prod.getProduct_name()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/show-employee-info" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">За прізвищем працівника знайти його телефон та адресу</td>

            <td class="my-row td-filled-right"><label>Прізвище працівника: </label>
                <select name="lastName">
                    <%
                        List<Employee> emplList = (List<Employee>) request.getAttribute("allEmployees");
                        for (Employee employee : emplList) {
                    %>
                    <option value=<%=employee.getEmpl_surname()%>><%=employee.getEmpl_surname()%>
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

    <form action="/checks-by-allEmployees-from-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період часу</td>
            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-right"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/checks-by-employee-from-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період часу</td>
            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-middle"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="my-row td-filled-right"><label>Касир: </label>
                <select name="idEmpl">
                    <%
                        List<Employee> emplList1 = (List<Employee>) request.getAttribute("allEmployees");
                        for (Employee employee : emplList1) {
                            if (employee.getRole().equalsIgnoreCase("cashier")) {
                    %>
                    <option value=<%=employee.getId_employee()%>><%=employee.getEmpl_surname()%>  <%=employee.getEmpl_name()%>
                    </option>
                    <%
                            }
                        }
                    %>
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


    <form action="/list-checks-by-cashier-and-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список чеків, видрукуваних певним касиром за певний період часу (з можливістю перегляду
                куплених товарів, їх к-сті та ціни)
            </td>

            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-middle"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="my-row td-filled-right"><label>Касир: </label>
                <select name="idEmpl">
                    <%
                        List<Employee> employeList = (List<Employee>) request.getAttribute("allEmployees");
                        for (Employee employee : employeList) {
                            if (employee.getRole().equalsIgnoreCase("cashier")) {
                    %>
                    <option value=<%=employee.getId_employee()%>><%=employee.getEmpl_surname()%>  <%=employee.getEmpl_name()%>
                    </option>
                    <%
                            }
                        }
                    %>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/list-all-checks-by-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список чеків, видрукуваних усіма касирами за певний період часу (з можливістю перегляду
                куплених товарів, їх к-сті та ціни )
            </td>

            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-right"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/count-sold-product-by-period" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Визначити загальну кількість одиниць певного товару, проданого за певний період часу</td>

            <td class="my-row td-filled-middle"><label>Початкова дата: </label><input type="date" name="dateStart" value="2021-03-01"></td>
            <td class="my-row td-filled-middle"><label>Кінцева дата: </label><input type="date" name="dateFinish" value="2021-03-09"></td>
            <td class="my-row td-filled-right"><label>Назва товару: </label>
                <select name="nameProd">
                    <%
                        List<Product> prodListt = (List<Product>) request.getAttribute("allProducts");
                        for (Product prod : prodListt) {
                    %>
                    <option value=<%=prod.getProduct_name()%>><%=prod.getProduct_name()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/find-lot-info-by-upc" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару, назву та характеристики товару
            </td>

            <td class="my-row td-filled-right"><label>UPC товару: </label>
                <select name="upc">
                    <%
                        List<StoreProduct> list = (List<StoreProduct>) request.getAttribute("allStoreProducts");
                        for (StoreProduct prod : list) {
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

    <form action="/sort-prom" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список усіх акційних товарів, відсортованих за кількістю одиниць товару/ за назвою</td>

            <td class="my-row td-filled-right"><label>Cортувати: </label>
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

    <form action="/sort-non-prom" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-left">Скласти список усіх не акційних товарів, відсортованих за кількістю одиниць товару/ за назвою</td>

            <td class="my-row td-filled-right"><label>Cортувати: </label>
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

    <form action="/sort-cashiers-by-surname" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">Скласти список працівників, що займають посаду касира, відсортованих за прізвищем</td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <%-------------------------------%>

    <form action="/sort-products-name" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">Скласти список усіх товарів, відсортованих за назвою</td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/sorted-categories-name" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">Скласти список усіх категорій, відсортованих за назвою</td>
            <td class="sub-but-row my-td-cust">
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/list-customer-card" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td class="td-filled-both">Скласти список усіх постійних клієнтів, що мають карту клієнта, по полях ПІБ, телефон, адреса (якщо вказана)</td>
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
