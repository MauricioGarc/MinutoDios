package semana2;
import java.util.Scanner;
public class Problema3 {
    public static void main(String[] args) {
        System.out.println("Por favor ingrese dos Numeros, \r\n"
                + "con el fin de ejecutar las cuatro operaciones basicas \r\n"
                + "suma, resta, mutiplicacion y division\r\n");
        Scanner Numero= new Scanner(System.in);
        System.out.print("Ingrese el primer Numero: ");
        int numero_1=Numero.nextInt();
        System.out.print("Ingrese el segundo Numero: ");
        int numero_2=Numero.nextInt();
        System.out.println("");
        System.out.println("La suma entre " + numero_1 + " y " + 
                 numero_2 + " es: " + (numero_1 + numero_2));
        System.out.println("La resta entre " + numero_1 + " y " + 
                 numero_2 + " es: " + (numero_1 - numero_2));
        System.out.println("La multiplicacion entre " + numero_1 + " y " + 
                 numero_2 + " es: " + (numero_1 * numero_2));
        System.out.println("La division entre " + numero_1 + " y " + 
                 numero_2 + " es: " + (numero_1 / numero_2));
    }
    
}
