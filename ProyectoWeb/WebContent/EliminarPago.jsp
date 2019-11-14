<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form method="get" action="EliminarPago">
		<p>
			Clave de Pago:<input type="text" id="pago.clavepago"
				name="pago.clavepago">
		</p>
		<input type="submit" value="Eliminar Pago">
	</form>
</body>
</html>