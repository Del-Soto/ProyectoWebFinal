<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method="get" action="ModificarCursoControl2">
		<p>
			Nombre:<input type="text" id="curso.nombre"
				name="curso.nombre">
		</p>
		<p>
			Fecha inicio :<input type="date" id="curso.fechaInicio" name="curso.fechaInicio">
		</p>
		<p>
			Fecha de pago:<input type="date" id="curso.fechaFin"
				name="curso.fechaFin">
		</p>
		<input type="submit" value="Actualizar Pago">
	</form>
</body>
</html>