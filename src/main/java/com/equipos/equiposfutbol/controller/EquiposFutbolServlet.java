package com.equipos.equiposfutbol.controller;

import com.equipos.equiposfutbol.dao.EquiposFutbolDAO;
import com.equipos.equiposfutbol.model.EquiposFutbol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/equipos")
public class EquiposFutbolServlet extends HttpServlet {

    private EquiposFutbolDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new EquiposFutbolDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 👇 VERIFICACIÓN DE SESIÓN
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "eliminar":
                eliminarEquipo(request, response);
                break;
            default:
                listarEquipos(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        EquiposFutbol equipo = new EquiposFutbol();
        equipo.setNombre(request.getParameter("nombre"));
        equipo.setEslogan(request.getParameter("eslogan"));
        equipo.setTecnico(request.getParameter("tecnico"));
        equipo.setPais(request.getParameter("pais"));
        equipo.setCiudad(request.getParameter("ciudad"));
        equipo.setCategoria(request.getParameter("categoria"));
        equipo.setNumGoles(Integer.parseInt(request.getParameter("numGoles")));
        equipo.setNumPartidosJugados(Integer.parseInt(request.getParameter("numPartidosJugados")));
        equipo.setNumPartidosGanados(Integer.parseInt(request.getParameter("numPartidosGanados")));
        equipo.setNumCampeonatos(Integer.parseInt(request.getParameter("numCampeonatos")));
        equipo.setNumExpulsiones(Integer.parseInt(request.getParameter("numExpulsiones")));
        equipo.setNumEmpates(Integer.parseInt(request.getParameter("numEmpates")));

        if (idStr == null || idStr.isEmpty()) {
            dao.insertarEquipo(equipo);
        } else {
            equipo.setId(Integer.parseInt(idStr));
            dao.actualizarEquipo(equipo);
        }

        response.sendRedirect("equipos");
    }

    private void listarEquipos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<EquiposFutbol> lista = dao.obtenerEquipos();
        request.setAttribute("listaEquipos", lista);
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        List<EquiposFutbol> lista = dao.obtenerEquipos();
        EquiposFutbol equipo = lista.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        request.setAttribute("equipo", equipo);
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }

    private void eliminarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        dao.eliminarEquipo(id);
        response.sendRedirect("equipos");
    }
}
