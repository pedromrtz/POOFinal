package itca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO implements CRUDInterface<Perfil> {

    private Connection connection;

    public PerfilDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Perfil findById(int id) {
        String query = "SELECT * FROM PERFILES WHERE ID_PERFIL = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToPerfil(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Perfil> findAll() {
        List<Perfil> perfiles = new ArrayList<>();
        String query = "SELECT * FROM PERFILES";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                perfiles.add(mapResultSetToPerfil(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perfiles;
    }

    @Override
    public void save(Perfil perfil) {
        String query = "INSERT INTO PERFILES (NOMBRE, ESTADO) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, perfil.getNombre());
            stmt.setInt(2, perfil.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Perfil perfil) {
        String query = "UPDATE PERFILES SET NOMBRE = ?, ESTADO = ? WHERE ID_PERFIL = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, perfil.getNombre());
            stmt.setInt(2, perfil.getEstado());
            stmt.setInt(3, perfil.getIdPerfil());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Perfil perfil) {
        String query = "DELETE FROM PERFILES WHERE ID_PERFIL = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, perfil.getIdPerfil());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Perfil mapResultSetToPerfil(ResultSet rs) throws SQLException {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(rs.getInt("ID_PERFIL"));
        perfil.setNombre(rs.getString("NOMBRE"));
        perfil.setEstado(rs.getInt("ESTADO"));
        return perfil;
    }
}

