<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<form:form modelAttribute="newSt" action="saveStudent" method="post">
    <form:hidden path="id"/>
    <br>
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    Surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    Coarse: <form:input path="coarse"/>
    <form:errors path="coarse"/>
    <br>
    Average Grade: <form:input path="grade"/>
    <form:errors path="grade"/>
    <br>
    <input type="submit" value="OK">

</form:form>

</body>

</html>