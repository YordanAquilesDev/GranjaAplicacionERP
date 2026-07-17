package domain.model;

public class DetalleCompra {
    private int idDetalle;
    private Compra compra;
    private Producto productos;
    private int cantidad;
    private double subtotal;
    // ------

    public DetalleCompra(int idDetalle,
            Compra compra,
            Producto productos,
            Integer cantidad,
            Double subtotal) {
        this.idDetalle = idDetalle;
        this.compra = compra;
        this.productos = productos;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }






}
