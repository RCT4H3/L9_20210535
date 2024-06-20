
<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.lab9_20210535.Beans.UsuarioB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<org.example.lab9_20210535.Beans.UsuarioB>" scope="request" id="listaUsuariosOperativo"/>
<html>
<head>
    <title>Lista de usuarios operativos</title>
</head>
<body>
    <div class='container'>
        <div>
            <h>Lista de Usuarios Operativos</h>
        </div>
        <table class="table" border>
            <tr>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Tipo de licencia</th>
                <th>Estado de licencia</th>
                <th>Pais de procedencia</th>
            </tr>
            <%
                for (UsuarioB usuarioB : listaUsuariosOperativo) {
            %>
            <tr>
                <td><%=usuarioB.getNombres()%></td>
                <td><%=usuarioB.getApellidos()%></td>
                <td><%=usuarioB.getLicenciaB().getCategoria()%></td>
                <td>Vigente</td>
                <td><%=usuarioB.getLicenciaB().getPaisB().getNombrePais()%></td>

            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
