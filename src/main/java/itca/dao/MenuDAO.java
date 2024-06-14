package itca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO implements CRUDInterface<Menu> {

    private Connection connection;

    public MenuDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Menu findById(int id) {
        String query = "SELECT * FROM MENUS WHERE ID_MENU = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToMenu(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM MENUS";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                menus.add(mapResultSetToMenu(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public void save(Menu menu) {
        String query = "INSERT INTO MENUS (NOMBRE, ESTADO) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menu.getNombre());
            stmt.setInt(2, menu.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Menu menu) {
        String query = "UPDATE MENUS SET NOMBRE = ?, ESTADO = ? WHERE ID_MENU = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menu.getNombre());
            stmt.setInt(2, menu.getEstado());
            stmt.setInt(3, menu.getIdMenu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Menu menu) {
        String query = "DELETE FROM MENUS WHERE ID_MENU = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, menu.getIdMenu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Menu mapResultSetToMenu(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setIdMenu(rs.getInt("ID_MENU"));
        menu.setNombre(rs.getString("NOMBRE"));
        menu.setEstado(rs.getInt("ESTADO"));
        return menu;
    }
}
