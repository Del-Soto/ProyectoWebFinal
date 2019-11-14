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
		} else if (codigo != null && codigo == -2) {
			out.write("<p>El monto  es un dato obligatorio, debe usted llenarlo</p>");
		} 
	%>
	<form method="get" action="RegistrarPago">
		<p>
			Clave de pago:<input type="text" id="pago.clavepago"
				name="pago.clavepago">
		</p>
		<p>
			Monto:<input type="text" id="pago.monto" name="pago.monto">
		</p>
		<p>
			Fecha de pago:<input type="text" id="pago.fechapago"
				name="pago.fechapago">
		</p>
		<input type="submit" value="Registrar Pago">
	</form>
</body>
</html>