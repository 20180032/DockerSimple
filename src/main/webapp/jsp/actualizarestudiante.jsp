<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Actualizar Datos</h1>
<form:form method="post" action="/actualizar-estudiante/${id}">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Matricula: </td>
            <td><form:input path="matricula"/></td>
        </tr>
        <tr>
            <td>Telefono: </td>
            <td><form:input path="telefono"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
