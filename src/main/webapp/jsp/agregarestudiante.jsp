<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Agregar Nuevo Estudiante</h1>
<form:form method="post" action="/agregar-estudiante">
    <table>
        <tr>
            <td>Matricula: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Nombre: </td>
            <td><form:input path="matricula"/></td>
        </tr>
        <tr>
            <td>Telefono: </td>
            <td><form:input path="telefono"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
