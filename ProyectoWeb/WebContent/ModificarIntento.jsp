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
		if (codigo != null && codigo == -2) {
			out.write("<p>La institucion es un dato obligatorio, debe usted llenarlo</p>");
		}
	%>
	<form method="get" action="ModificarIntento">
		<p>
			Institucion:<input type="text" id="intento.institucion"
				name="intento.institucion">
		</p>
		<input type="submit" value="Consultar Intento">
	</form>
</body>
</html>