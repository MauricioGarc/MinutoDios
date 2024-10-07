package Problema3;

abstract class Cuenta {
    protected Cliente cliente;
    protected double saldo;
    protected String tipoCuenta;
    protected int numeroCuenta;

    public Cuenta(Cliente cliente, double saldoInicial, int numeroCuenta) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.numeroCuenta = numeroCuenta;
    }

    public abstract void depositar(double monto);
    public abstract void retirar(double monto);
    public abstract void aplicarComisiones();
    public abstract double calcularIntereses();
    
    public double getSaldo() {
        return saldo;
    }

    public void mostrarEstadoCuenta() {
        System.out.println("Estado de cuenta de " + cliente.getNombreCompleto());
        System.out.println("Saldo: " + saldo);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
    }
}
