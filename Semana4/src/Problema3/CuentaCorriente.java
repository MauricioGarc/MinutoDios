package Problema3;

public class CuentaCorriente extends Cuenta{
    private static final double TASA_MANTENIMIENTO = 0.015;
    private static final double COSTO_CHEQUE = 3000;
    static final double MONTO_MINIMO = 200000;
    
    public CuentaCorriente(Cliente cliente, double saldoInicial, int numeroCuenta) {
        super(cliente, saldoInicial, numeroCuenta);
        this.tipoCuenta = "Corriente";
    }

    public void depositar(double monto) {
        double comision = calcularComisionDeposito(monto);
        saldo += (monto - comision);
        System.out.println("Deposito realizado\r\n. Monto depositado: " + 
                monto + "\r\n, Comision cobrada: " + comision);
        System.out.println("Nuevo saldo: " + saldo);
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public void aplicarComisiones() {
        saldo -= (saldo * TASA_MANTENIMIENTO);
    }

    public double calcularIntereses() {
        return 0; // No aplica para cuentas corrientes
    }

    private double calcularComisionDeposito(double monto) {
        if (monto < 500000) {
            return 7000;
        } else if (monto < 2000000) {
            return 5000 + (0.02 * monto);
        } else if (monto <= 10000000) {
            return 4000 + (0.02 * monto);
        } else {
            return 0.033 * monto;
        }
    }
}
