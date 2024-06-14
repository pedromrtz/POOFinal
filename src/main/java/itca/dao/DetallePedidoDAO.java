package itca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO implements CRUDInterface<DetallePedido> {

    private Connection connection;

    public DetallePedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public DetallePedido findById(int id) {
        String query = "SELECT * FROM DETALLE_PEDIDO WHERE ID_DET_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToDetallePedido(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DetallePedido> findAll() {
        List<DetallePedido> detalles = new ArrayList<>();
        String query = "SELECT * FROM DETALLE_PEDIDO";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detalles.add(mapResultSetToDetallePedido(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }

    @Override
    public void save(DetallePedido detallePedido) {
        String query = "INSERT INTO DETALLE_PEDIDO (ID_PEDIDO, ID_PLATO, CANTIDAD) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, detallePedido.getIdPedido());
            stmt.setInt(2, detallePedido.getIdPlato());
            stmt.setInt(3, detallePedido.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DetallePedido detallePedido) {
        String query = "UPDATE DETALLE_PEDIDO SET ID_PEDIDO = ?, ID_PLATO = ?, CANTIDAD = ? WHERE ID_DET_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, detallePedido.getIdPedido());
            stmt.setInt(2, detallePedido.getIdPlato());
            stmt.setInt(3, detallePedido.getCantidad());
            stmt.setInt(4, detallePedido.getIdDetPedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DetallePedido detallePedido) {
        String query = "DELETE FROM DETALLE_PEDIDO WHERE ID_DET_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, detallePedido.getIdDetPedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DetallePedido> findByPedido(int idPedido) {
        List<DetallePedido> detalles = new ArrayList<>();
        String query = "SELECT * FROM DETALLE_PEDIDO WHERE ID_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                detalles.add(mapResultSetToDetallePedido(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }

    private DetallePedido mapResultSetToDetallePedido(ResultSet rs) throws SQLException {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetPedido(rs.getInt("ID_DET_PEDIDO"));
        detallePedido.setIdPedido(rs.getInt("ID_PEDIDO"));
        detallePedido.setIdPlato(rs.getInt("ID_PLATO"));
        detallePedido.setCantidad(rs.getInt("CANTIDAD"));
        return detallePedido;
    }
}
