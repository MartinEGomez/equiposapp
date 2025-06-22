<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.equipos.equiposfutbol.model.EquiposFutbol" %>
<%@ page import="java.util.List" %>
<%
    List<EquiposFutbol> lista = (List<EquiposFutbol>) request.getAttribute("listaEquipos");
%>
<html>
<head>
    <title>Lista de Equipos</title>
</head>
<body>
    <h1>Listado de Equipos de Fútbol</h1>
    <a href="formulario.jsp">Registrar nuevo equipo</a>
    <br><br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Eslogan</th>
            <th>Técnico</th>
            <th>País</th>
            <th>Ciudad</th>
            <th>Categoría</th>
            <th>Goles</th>
            <th>Jugados</th>
            <th>Ganados</th>
            <th>Campeonatos</th>
            <th>Expulsiones</th>
            <th>Empates</th>
            <th>Acciones</th>
        </tr>
        <%
            if (lista != null) {
                for (EquiposFutbol equipo : lista) {
        %>
        <tr>
            <td><%= equipo.getId() %></td>
            <td><%= equipo.getNombre() %></td>
            <td><%= equipo.getEslogan() %></td>
            <td><%= equipo.getTecnico() %></td>
            <td><%= equipo.getPais() %></td>
            <td><%= equipo.getCiudad() %></td>
            <td><%= equipo.getCategoria() %></td>
            <td><%= equipo.getNumGoles() %></td>
            <td><%= equipo.getNumPartidosJugados() %></td>
            <td><%= equipo.getNumPartidosGanados() %></td>
            <td><%= equipo.getNumCampeonatos() %></td>
            <td><%= equipo.getNumExpulsiones() %></td>
            <td><%= equipo.getNumEmpates() %></td>
            <td>
                <a href="equipos?action=editar&id=<%= equipo.getId() %>">Editar</a> |
                <a href="equipos?action=eliminar&id=<%= equipo.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
