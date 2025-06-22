package com.equipos.equiposfutbol.dao;

import com.equipos.equiposfutbol.config.DBConfig;
import com.equipos.equiposfutbol.model.EquiposFutbol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquiposFutbolDAO {

    public void insertarEquipo(EquiposFutbol equipo) {
        String sql = "INSERT INTO equipos_futbol (nombre, eslogan, tecnico, pais, ciudad, categoria, num_goles, num_partidos_jugados, num_partidos_ganados, num_campeonatos, num_expulsiones, num_empates) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getEslogan());
            ps.setString(3, equipo.getTecnico());
            ps.setString(4, equipo.getPais());
            ps.setString(5, equipo.getCiudad());
            ps.setString(6, equipo.getCategoria());
            ps.setInt(7, equipo.getNumGoles());
            ps.setInt(8, equipo.getNumPartidosJugados());
            ps.setInt(9, equipo.getNumPartidosGanados());
            ps.setInt(10, equipo.getNumCampeonatos());
            ps.setInt(11, equipo.getNumExpulsiones());
            ps.setInt(12, equipo.getNumEmpates());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EquiposFutbol> obtenerEquipos() {
        List<EquiposFutbol> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipos_futbol";

        try (Connection con = DBConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                EquiposFutbol equipo = new EquiposFutbol();
                equipo.setId(rs.getInt("id"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setEslogan(rs.getString("eslogan"));
                equipo.setTecnico(rs.getString("tecnico"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setCategoria(rs.getString("categoria"));
                equipo.setNumGoles(rs.getInt("num_goles"));
                equipo.setNumPartidosJugados(rs.getInt("num_partidos_jugados"));
                equipo.setNumPartidosGanados(rs.getInt("num_partidos_ganados"));
                equipo.setNumCampeonatos(rs.getInt("num_campeonatos"));
                equipo.setNumExpulsiones(rs.getInt("num_expulsiones"));
                equipo.setNumEmpates(rs.getInt("num_empates"));
                lista.add(equipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminarEquipo(int id) {
        String sql = "DELETE FROM equipos_futbol WHERE id = ?";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEquipo(EquiposFutbol equipo) {
        String sql = "UPDATE equipos_futbol SET nombre = ?, eslogan = ?, tecnico = ?, pais = ?, ciudad = ?, categoria = ?, num_goles = ?, num_partidos_jugados = ?, num_partidos_ganados = ?, num_campeonatos = ?, num_expulsiones = ?, num_empates = ? WHERE id = ?";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getEslogan());
            ps.setString(3, equipo.getTecnico());
            ps.setString(4, equipo.getPais());
            ps.setString(5, equipo.getCiudad());
            ps.setString(6, equipo.getCategoria());
            ps.setInt(7, equipo.getNumGoles());
            ps.setInt(8, equipo.getNumPartidosJugados());
            ps.setInt(9, equipo.getNumPartidosGanados());
            ps.setInt(10, equipo.getNumCampeonatos());
            ps.setInt(11, equipo.getNumExpulsiones());
            ps.setInt(12, equipo.getNumEmpates());
            ps.setInt(13, equipo.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
