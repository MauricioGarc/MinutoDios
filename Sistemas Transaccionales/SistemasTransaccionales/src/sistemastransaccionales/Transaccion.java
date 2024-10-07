package sistemastransaccionales;

import java.time.LocalDateTime;

public class Transaccion {
    private int idTransaccion;
    private LocalDateTime fechaHora;
    private int idSucursal;

    public Transaccion(int idTransaccion, LocalDateTime fechaHora, int idSucursal) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.idSucursal = idSucursal;
    }
}

