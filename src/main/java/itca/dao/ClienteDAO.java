package itca.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUDInterface<Cliente> {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cliente findById(int id) {
        String query = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCliente(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM CLIENTES";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(mapResultSetToCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void save(Cliente cliente) {
        String query = "INSERT INTO CLIENTES (NOMBRE, DIRECCION, ESTADO) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setInt(3, cliente.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente) {
        String query = "UPDATE CLIENTES SET NOMBRE = ?, DIRECCION = ?, ESTADO = ? WHERE ID_CLIENTE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setInt(3, cliente.getEstado());
            stmt.setInt(4, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cliente cliente) {
        String query = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
        cliente.setNombre(rs.getString("NOMBRE"));
        cliente.setDireccion(rs.getString("DIRECCION"));
        cliente.setEstado(rs.getInt("ESTADO"));
        return cliente;
    }
}
