<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Iniciar sesión</h2>

    <form method="post" action="login">
        Usuario: <input type="text" name="usuario" required /><br><br>
        Contraseña: <input type="password" name="password" required /><br><br>
        <input type="submit" value="Ingresar" />
    </form>

    <p style="color:red;">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </p>
</body>
</html>
