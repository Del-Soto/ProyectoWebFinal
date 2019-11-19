<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<article class="main-container">
	<section class="box-form">
		<header><h1>Registro</h1></header>
		<form class="form" action="RegistrarCursoControl" method="get">
			<label>Nombre:</label>
			<input type="text" name="curso.nombre" id="curso.nombre">
			<label>Fecha Inicio:</label>
			<input type="date" name="curso.fechaInicio" id="fechaInicio">
			<label>Fecha Final:</label>
			<input type="date" name="curso.fechaFin" id="curso.fechaFin">
			<input type="submit" id="boton-form" value="Registrar">
		</form>
	</section>		
	</article>
</body>
</html>