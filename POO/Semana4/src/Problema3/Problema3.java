
package Problema3;

import java.util.Scanner;

public class Problema3 {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("");
            System.out.println("    1. Apertura de Cuentas");
            System.out.println("    2. Transferencias");
            System.out.println("    3. Retiro Cajero Automatico");
            System.out.println("    4. Deposito");
            System.out.println("    5. Cierre de Mes");
            System.out.println("    6. Mostrar Estado de Cuenta");
            System.out.println("    7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("    1. Abrir cuenta de ahorros");
                    System.out.println("    2. Abrir cuenta corriente");
                    System.out.print("Seleccione el tipo de cuenta: ");
                    int tipoCuenta = scanner.nextInt();
                    System.out.println("");
                    if (tipoCuenta == 1) {
                        banco.abrirCuentaAhorro();
                    } else if (tipoCuenta == 2) {
                        banco.abrirCuentaCorriente();
                    }
                    break;
                case 2:
                    banco.realizarTransferencia();
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    scanner = new Scanner(System.in);
                    double montoRetirar = scanner.nextDouble();
                    System.out.print("Ingrese el numero de cuenta para depositar: ");
                    scanner = new Scanner(System.in);
                    int cCliente = scanner.nextInt();
                    banco.retirarDineroCajero(montoRetirar, banco.cajero(), cCliente);
                    break;
                case 4:
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    System.out.print("Ingrese el numero de cuenta para depositar: ");
                    scanner = new Scanner(System.in);
                    int cuentaCliente = scanner.nextInt();
                    System.out.println("    1. Cuenta de ahorros");
                    System.out.println("    2. Cuenta corriente");
                    System.out.print("Tipo de cuenta: ");
                    scanner = new Scanner(System.in);
                    int tipoCuentaDe = scanner.nextInt();
                    if (tipoCuentaDe==2) {
                        if (banco.getCuentacliente(cuentaCliente)) {
                            banco.setSaldoCuentacliente(cuentaCliente, montoDeposito);
                        } else {
                            System.out.println("No es una cuenta corriente.");
                        }
                    }else if(tipoCuentaDe==1){
                        if (banco.getCuentacliente(cuentaCliente)) {
                            banco.setSaldoCuentaclienteAhorros(cuentaCliente, montoDeposito);
                        } else {
                            System.out.println("No es una cuenta de ahorros.");
                        }
                    }else{
                        System.out.println("Datos Incorrectos.");
                    }
                    break;
                case 5:
                    banco.cierreDeMes();
                    break;
                case 6:
                    banco.mostrarCuentas();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        
        scanner.close();
    }
    
}
