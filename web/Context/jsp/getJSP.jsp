<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th {
            padding: 5px
        }
    </style>
    <title>Sorted Name-Value</title>
</head>
<body>
<jsp:useBean id="person" class="Person.Person" scope="request"></jsp:useBean>

<table style="width:30%">
    <tr bgcolor="aqua">
        <th>Параметр</th>
        <th>Значение</th>
    </tr>

    <%for (String key : person.getParameters().keySet()) {%>
    <tr>
        <td><%=key%></td>
        <%for (String value : person.getParameters().get(key)) {%>
            <td><%=value%></td>
        <%}%>
    </tr>
    <%}%>

</table>
</body>
</html>
