<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio de Sesión</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <form action="login" method="post">
        <label for="username">Usuario:</label>
        <input type="text" name="username" id="username" required /><br><br>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" required /><br><br>
        <input type="submit" value="Ingresar" />
    </form>
    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>
</body>
</html>
