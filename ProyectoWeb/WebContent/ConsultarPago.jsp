<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-with, initial-scale=1.0">
<meta charset="utf-8">
<title>Consultar pago por clave de pago</title>
</head>
<body>
	<%
		HttpSession misesion = request.getSession();
		Integer codigo = 0;
		codigo = (Integer) misesion.getAttribute("codigo");
		if (codigo != null && codigo == -1) {
			out.write("<p>La clave de pago es un dato obligatorio, debe usted llenarlo</p>");
		}
	%>
	<form method="get" action="ConsultarPago">
		<p>
			Clave de pago:<input type="text" id="pago.clavepago"
				name="pago.clavepago">
		</p>
		<input type="submit" value="Consultar Pago">
	</form>
</body>
</html>