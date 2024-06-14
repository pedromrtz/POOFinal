package itca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatilloDAO implements CRUDInterface<Platillo> {
    
    private Connection connection;

    public PlatilloDAO(Connection connection) {
        this.connection = connection;
    }
    
        @Override
    public Platillo findById(int id) {
        String query = "SELECT * FROM PLATILLOS WHERE ID_PLATO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToPlatillo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Platillo> findAll() {
        List<Platillo> platillos = new ArrayList<>();
        String query = "SELECT * FROM PLATILLOS";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                platillos.add(mapResultSetToPlatillo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platillos;
    }

    @Override
    public void save(Platillo platillo) {
        String query = "INSERT INTO PLATILLOS (NOMBRE, DESCRIPCION, ID_MENU, ESTADO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, platillo.getNombre());
            stmt.setString(2, platillo.getDescripcion());
            stmt.setInt(3, platillo.getIdMenu());
            stmt.setInt(4, platillo.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Platillo platillo) {
        String query = "UPDATE PLATILLOS SET NOMBRE = ?, DESCRIPCION = ?, ID_MENU = ?, ESTADO = ? WHERE ID_PLATO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, platillo.getNombre());
            stmt.setString(2, platillo.getDescripcion());
            stmt.setInt(3, platillo.getIdMenu());
            stmt.setInt(4, platillo.getEstado());
            stmt.setInt(5, platillo.getIdPlato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Platillo platillo) {
        String query = "DELETE FROM PLATILLOS WHERE ID_PLATO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, platillo.getIdPlato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Platillo> findByMenu(int idMenu) {
        List<Platillo> platillos = new ArrayList<>();
        String query = "SELECT * FROM PLATILLOS WHERE ID_MENU = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMenu);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                platillos.add(mapResultSetToPlatillo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platillos;
    }

    private Platillo mapResultSetToPlatillo(ResultSet rs) throws SQLException {
        Platillo platillo = new Platillo();
        platillo.setIdPlato(rs.getInt("ID_PLATO"));
        platillo.setNombre(rs.getString("NOMBRE"));
        platillo.setDescripcion(rs.getString("DESCRIPCION"));
        platillo.setIdMenu(rs.getInt("ID_MENU"));
        platillo.setEstado(rs.getInt("ESTADO"));
        return platillo;
    }
    
}
