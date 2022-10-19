<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Lista de Estudiantes</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Matricula</th>
        <th>Nombre</th>
        <th>Telefono</th>
        <th>Actualizar</th>
        <th>Borrar</th>
    </tr>
    <c:forEach var="estudiante" items="${contacts}">
        <tr>
            <td>${estudiante.id}</td>
            <td>${estudiante.name}</td>
            <td>${estudiante.matricula}</td>
            <td>${estudiante.telefono}</td>
            <td><a href="/actualizar-estudiante/${estudiante.id}">Actualizar</a></td>
            <td><a href="/borrar-estudiante/${estudiante.id}">Borrar</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/agregar-estudiante">
    <button>
        Agregar Nuevo Estudiante
    </button>
    </a>
