package Problema3;

public class CuentaAhorro extends Cuenta{
     private static final double TASA_RENDIMIENTO_ANUAL = 0.022;

    public CuentaAhorro(Cliente cliente, double saldoInicial, int numeroCuenta) {
        super(cliente, saldoInicial, numeroCuenta);
        this.tipoCuenta = "Ahorro";
    }
    
    public void depositar(double monto) {
        double comision = calcularComisionDeposito(monto);
        saldo += (monto - comision);
        System.out.println("Deposito realizado\r\n  Monto depositado: " + 
                monto + "\r\n  Comision cobrada: " + comision);
        System.out.println("Nuevo saldo: " + saldo);
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public void aplicarComisiones() {
        double tasaRendimientoMensual = TASA_RENDIMIENTO_ANUAL / 12; // Divide la tasa anual entre 12 para obtener la tasa mensual
        double rendimiento = saldo * tasaRendimientoMensual; // Calcular el rendimiento mensual
        saldo += rendimiento; // Añadir el rendimiento al saldo de la cuenta
    }

    public double calcularIntereses() {
        return saldo * TASA_RENDIMIENTO_ANUAL;
    }

    private double calcularComisionDeposito(double monto) {
        if (monto < 500000) {
            return 3000;
        } else if (monto < 2000000) {
            return 3000 + (0.01 * monto);
        } else if (monto <= 10000000) {
            return 2000 + (0.005 * monto);
        } else if (monto < 100000000) {
            return 0.018 * monto;
        } else {
            return 0.02 * monto;
        }
    }
}
