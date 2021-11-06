<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Artículos View</title>
</head>
<body>
<h1>Lista de Artículos!</h1>
<table border="2" width="70%" cellpadding="2">
<tr>
<th>Id</th>
<th>Nombre</th>
<th>Clave</th>
<th>Descripción</th>
<th>Marca</th>
<th>Editar</th>
<th>Borrar</th>
</tr>
<c:forEach var="art" items="${list}">
<tr>
<td>${art.idArticulo}</td>
<td>${art.nombre}</td>
<td>${art.cveArticulo}</td>
<td>${art.descripcion}</td>
<td>${art.marca}</td>
<td><a href="editar.htm?id=${art.idArticulo}">Editar</a></td>
<td><a href="borrar.htm?id=${art.idArticulo}">Borrar</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="nuevo.htm">Agregar artículo</a>
</body>
</html>
