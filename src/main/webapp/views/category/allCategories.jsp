<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Categories</title>
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
    <h1>Всі категорії</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-category'" value='Додати Категорію'>
</div>
<br>
<br>
<div id="printableTable">
<div>
    <div>

        <%
            List<Category> categories = (List<Category>) request.getAttribute("allCategories");
            if (categories != null && !categories.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Назва</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Category category : categories) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/category?id=" + category.getCategory_number() + "\">"
                            + category.getCategory_number() + "</a></td>");
                    out.println("<td>" + category.getCategory_name() + "</td>");

                    out.println("<td><a href=\"/update-category?id=" + category.getCategory_number()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-category?id=" + category.getCategory_number()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
            out.println("<p>There are no categories yet!</p>");
            }
        %>
    </div>
</div>
</div>
<br>

<div>
    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/add-category'" value='Додати Категорію'>
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
