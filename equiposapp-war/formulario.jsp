<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Equipo de Fútbol</title>
</head>
<body>
    <h1>Registrar o Editar Equipo</h1>
    <form action="equipos" method="post">
        <input type="hidden" name="id" value="${equipo.id}" />

        Nombre: <input type="text" name="nombre" value="${equipo.nombre}" required /><br><br>
        Eslogan: <input type="text" name="eslogan" value="${equipo.eslogan}" required /><br><br>
        Técnico: <input type="text" name="tecnico" value="${equipo.tecnico}" required /><br><br>
        País: <input type="text" name="pais" value="${equipo.pais}" required /><br><br>
        Ciudad: <input type="text" name="ciudad" value="${equipo.ciudad}" required /><br><br>
        Categoría: <input type="text" name="categoria" value="${equipo.categoria}" required /><br><br>
        Goles: <input type="number" name="numGoles" value="${equipo.numGoles}" required /><br><br>
        Partidos Jugados: <input type="number" name="numPartidosJugados" value="${equipo.numPartidosJugados}" required /><br><br>
        Partidos Ganados: <input type="number" name="numPartidosGanados" value="${equipo.numPartidosGanados}" required /><br><br>
        Campeonatos: <input type="number" name="numCampeonatos" value="${equipo.numCampeonatos}" required /><br><br>
        Expulsiones: <input type="number" name="numExpulsiones" value="${equipo.numExpulsiones}" required /><br><br>
        Empates: <input type="number" name="numEmpates" value="${equipo.numEmpates}" required /><br><br>

        <input type="submit" value="Guardar" />
    </form>
    <br>
    <a href="equipos">Volver a la lista</a>
</body>
</html>
