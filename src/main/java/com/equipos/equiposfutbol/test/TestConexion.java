package com.equipos.equiposfutbol.test;

import com.equipos.equiposfutbol.config.DBConfig;
import java.sql.*;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = DBConfig.getConnection()) {
            String sql = "SELECT * FROM equipos_futbol";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Equipo: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
