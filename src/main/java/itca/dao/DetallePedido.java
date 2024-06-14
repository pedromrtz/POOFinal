package itca.dao;


public class DetallePedido {
    private int idDetPedido;
    private int idPedido;
    private int idPlato;
    private int cantidad;

    public DetallePedido() {
    }
    

    // Getters y Setters

    public int getIdDetPedido() {
        return idDetPedido;
    }

    public void setIdDetPedido(int idDetPedido) {
        this.idDetPedido = idDetPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
