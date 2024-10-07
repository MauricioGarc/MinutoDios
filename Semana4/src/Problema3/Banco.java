package Problema3;

import Problema3.Cuenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    private List<Cuenta> cuentas = new ArrayList<>();
    private Cliente clienteActual=new Cliente();
    
    public void abrirCuentaAhorro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("  Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("  Apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("  Edad del cliente: ");
        int edad = scanner.nextInt();
        System.out.print("  Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Cliente cliente = new Cliente(nombre, apellido, edad);
        if (saldoInicial < 0 || (cliente.esMenorEdad() && saldoInicial < 0)) {
            System.out.println("    Saldo inicial no válido.");
            return;
        }
        
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100000);
        
        CuentaAhorro cuenta = new CuentaAhorro(cliente, saldoInicial, numeroAleatorio);
        clienteActual = cliente;
        cuentas.add(cuenta);
        System.out.println("    Cuenta de ahorros abierta para " + cliente.getNombreCompleto() + 
                "\r\n, con numero: " + numeroAleatorio);
    }
    public void abrirCuentaCorriente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("  Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("  Apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("  Edad del cliente: ");
        int edad = scanner.nextInt();
        System.out.print("  Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Cliente cliente = new Cliente(nombre, apellido, edad);
        if (saldoInicial < CuentaCorriente.MONTO_MINIMO) {
            System.out.println("    El monto minimo de apertura para cuenta corriente es de 200 mil pesos.");
            return;
        }
        
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100000);
        
        CuentaCorriente cuenta = new CuentaCorriente(cliente, saldoInicial, numeroAleatorio);
        cuentas.add(cuenta);
        System.out.println("    Cuenta corriente abierta para " + cliente.getNombreCompleto() + 
                "\r\n, con numero: " + numeroAleatorio);
    }

    public void realizarTransferencia() {
        
    }
    
    public boolean getCuentacliente(int cuenta) {
        for (Cuenta cuentaItera : cuentas) {
            if (cuentaItera.numeroCuenta == cuenta) {
              return true;  
            }
        }
        return false;
    }
    public boolean setSaldoCuentacliente(int cuenta, double monto) {
        for (Cuenta cuentaItera : cuentas) {
            if (cuentaItera.numeroCuenta == cuenta) {
                cuentaItera.depositar(monto);
                return true;  
            }
        }
        return false;
    }
    
    public boolean setSaldoCuentaclienteAhorros(int cuenta, double monto) {
        for (Cuenta cuentaItera : cuentas) {
            if (cuentaItera.numeroCuenta == cuenta) {
                cuentaItera.depositar(monto);
                return true;  
            }
        }
        return false;
    }
    public boolean cajero(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        if (numeroAleatorio<=50) {
            return true;
        }
        return false;
    }
    public void retirarDineroCajero(double monto, boolean cajeroPropio, int cuenta) {
       for (Cuenta cuentaItera : cuentas) {
            if (cuentaItera.numeroCuenta == cuenta) {
                if (cajeroPropio) {
                    if (cuentaItera.saldo >= monto) {
                        cuentaItera.retirar(monto);
                        System.out.println("Retiro exitoso de " + monto +
                                "\r\npesos. No se ha cobrado comisión.");
                        System.out.println("Nuevo saldo: " + cuentaItera.saldo + " pesos.");
                    } else {
                        System.out.println("Saldo insuficiente para realizar el retiro.");
                        System.out.println("Saldo existente: " + cuentaItera.saldo + " pesos.");
                    }
                } else {
                    if (cuentaItera.saldo >= monto + 4500) { // Comisión de 4500 pesos por cajeros ajenos
                        cuentaItera.retirar(monto + 4500);
                        System.out.println("Retiro exitoso de " + monto + 
                                "\r\npesos. Comisión de cajero ajeno: 4500 pesos.");
                        System.out.println("Nuevo saldo: " + cuentaItera.saldo + " pesos.");
                    } else {
                        System.out.println("Saldo insuficiente para realizar el retiro.");
                        System.out.println("Saldo existente: " + cuentaItera.saldo + " pesos.");
                    }
                }
                return;
            }
        }
    }

    public void cierreDeMes() {
        for (Cuenta cuenta : cuentas) {
            cuenta.aplicarComisiones();
        }
        System.out.println("    Comisiones aplicadas a todas las cuentas.");
    }

    public void mostrarCuentas() {
        for (Cuenta cuenta : cuentas) {
            cuenta.mostrarEstadoCuenta();
        }
    }
}
