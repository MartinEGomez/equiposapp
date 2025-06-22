package com.equipos.equiposfutbol.controller;

import com.equipos.equiposfutbol.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        boolean valido = usuarioDAO.validar(usuario, password);


        if (valido) {
            // Guardar sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("equipos");
        } else {
            request.setAttribute("error", "Usuario o contraseña inválidos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
