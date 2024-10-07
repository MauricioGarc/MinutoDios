package sistemastransaccionales;

import java.time.LocalDateTime;

public class Compra extends Transaccion {
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Compra(int idTransaccion, LocalDateTime fechaHora, int idSucursal, 
            int idProducto, int cantidad, double precioUnitario) {
        super(idTransaccion, fechaHora, idSucursal);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
