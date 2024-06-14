package itca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CRUDInterface<Usuario> {
    
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario findById(int id) {
        String query = "SELECT * FROM USUARIOS WHERE ID_USER = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIOS";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapResultSetToUsuario(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void save(Usuario usuario) {
        String query = "INSERT INTO USUARIOS (NOMBRE, USUARIO, CLAVE, ESTADO, ID_PERFIL) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getUser());
            stmt.setString(3, usuario.getClave());
            stmt.setInt(4, usuario.getEstado());
            stmt.setInt(5, usuario.getIdPerfil());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Usuario usuario) {
        String query = "UPDATE USUARIOS SET NOMBRE = ?, USUARIO = ?, CLAVE = ?, ESTADO = ?, ID_PERFIL = ? WHERE ID_USER = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getUser());
            stmt.setString(3, usuario.getClave());
            stmt.setInt(4, usuario.getEstado());
            stmt.setInt(5, usuario.getIdPerfil());
            stmt.setInt(6, usuario.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        String query = "DELETE FROM USUARIOS WHERE ID_USER = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, usuario.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Usuario findByUser(String user){
        String query = "SELECT * FROM USUARIOS WHERE USUARIO = ? AND ESTADO = 1";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Usuario mapResultSetToUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUser(rs.getInt("ID_USER"));
        usuario.setNombre(rs.getString("NOMBRE"));
        usuario.setUser(rs.getString("USUARIO"));
        usuario.setClave(rs.getString("CLAVE"));
        usuario.setEstado(rs.getInt("ESTADO"));
        usuario.setIdPerfil(rs.getInt("ID_PERFIL"));
        return usuario;
    }
 
    
}
