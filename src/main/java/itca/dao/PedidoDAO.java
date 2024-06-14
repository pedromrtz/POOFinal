package itca.dao;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements CRUDInterface<Pedido> {

    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pedido findById(int id) {
        String query = "SELECT * FROM PEDIDOS WHERE ID_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToPedido(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM PEDIDOS";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(mapResultSetToPedido(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void save(Pedido pedido) {
        String query = "INSERT INTO PEDIDOS (ID_CLIENTE, FECHA_HORA, ENTREGADO, ESTADO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setTimestamp(2, Timestamp.valueOf(pedido.getFechaHora()));
            stmt.setInt(3, pedido.getEntregado());
            stmt.setInt(4, pedido.getEstado());
            stmt.executeUpdate();

            // Obtener el ID generado para el pedido
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pedido.setIdPedido(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pedido pedido) {
        String query = "UPDATE PEDIDOS SET ID_CLIENTE = ?, FECHA_HORA = ?, ENTREGADO = ?, ESTADO = ? WHERE ID_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setTimestamp(2, Timestamp.valueOf(pedido.getFechaHora()));
            stmt.setInt(3, pedido.getEntregado());
            stmt.setInt(4, pedido.getEstado());
            stmt.setInt(5, pedido.getIdPedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pedido pedido) {
        String query = "DELETE FROM PEDIDOS WHERE ID_PEDIDO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pedido.getIdPedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Pedido mapResultSetToPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(rs.getInt("ID_PEDIDO"));
        pedido.setIdCliente(rs.getInt("ID_CLIENTE"));
        Timestamp fechaHora = rs.getTimestamp("FECHA_HORA");
        pedido.setFechaHora(fechaHora.toLocalDateTime());
        pedido.setEntregado(rs.getInt("ENTREGADO"));
        pedido.setEstado(rs.getInt("ESTADO"));
        return pedido;
    }
}
