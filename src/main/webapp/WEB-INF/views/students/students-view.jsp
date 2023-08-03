<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>

<html>

<head>
    <h2> All our Students </h2>
</head>

<body>


<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Coarse</th>
        <th>Average Grade</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="st" items="${students}">
        <c:url var="updateButton" value="updateStudent">
            <c:param name="stID" value="${st.id}"></c:param>
        </c:url>
        <c:url var="deleteButton" value="deleteStudent">
            <c:param name="stID" value="${st.id}"></c:param>
        </c:url>

        <tr>
            <td> ${st.name} </td>
            <td> ${st.surname} </td>
            <td> ${st.coarse} </td>
            <td> ${st.grade} </td>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'">
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
            </td>
        </tr>
    </c:forEach>

</table>
<br>
    <input type="button" value="Add" onclick="window.location.href = 'newStudent'">


</body>

</html>