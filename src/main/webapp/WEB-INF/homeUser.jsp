<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="usuarioLogueado" scope="session" type="org.example.lab9_20210535.Beans.UsuarioB" class="org.example.lab9_20210535.Beans.UsuarioB" />
<html>
<head>
    <title>Home User</title>
</head>
<body>
    <p>Se ha logeado:</p>
    <p><%=usuarioLogueado.getNombres()%> %></p>
    <p><%=usuarioLogueado.getApellidos()%> %></p>


</body>
</html>
