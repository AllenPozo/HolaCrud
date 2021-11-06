
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Artículo</title>
</head>
<body>
<h1>Agregar Artículo!</h1>
<form:form method="post" action="guardar.htm">
<table >
<tr>
<td>Clave: </td>
<td><form:input path="cveArticulo" /></td>
</tr>
<tr>
<td>Nombre:</td>
<td><form:input path="nombre" /></td>
</tr>
<tr>
<td>Descripción:</td>
<td><form:input path="descripcion" /></td>
</tr>
<tr>
<td>Marca:</td>
<td><form:input path="marca" /></td>
</tr>
<tr>
<td> </td>
<td><input type="submit" value="Guardar" /></td>
</tr>
</table>
</form:form>
</body>
</html>
