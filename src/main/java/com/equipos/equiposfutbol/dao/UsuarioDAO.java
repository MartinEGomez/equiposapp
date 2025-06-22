package com.equipos.equiposfutbol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.equipos.equiposfutbol.config.DBConfig;

public class UsuarioDAO {
    public boolean validar(String usuario, String password) {
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND password = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // true si encontró una coincidencia

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
