package semana2;
import java.util.Scanner;
public class Problema8 {
    public static void main(String[] args) {
        System.out.println("Calculadora de Sueldo, por favor ingresar la\r\n"
                + "cantidad de horas trabajadas y el valor por hora: \r\n");
        Scanner dato = new Scanner(System.in);
        System.out.print("Ingresar la cantidad de horas trabajadas: ");
        double Horas = dato.nextDouble();
        System.out.print("Ingresar el valor de la hora en pesos: ");
        double Valor = dato.nextDouble();
        System.out.println("El sueldo pagar del trabajador es: " + (Horas*Valor));
    }
}
