package semana2;
import java.util.Scanner;
public class Problema6 {
    public static void main(String[] args) {
        System.out.print("Por favor ingresar el valor numero entero, \r\n"
                + "con el fin de calcular el cuadrado: ");
        Scanner NumeroCuadrado = new Scanner(System.in);
        int cuadrado = NumeroCuadrado.nextInt();
        System.out.println("El cuadrado del numero ("+ cuadrado +") es: "
                + Math.pow(cuadrado,2));
    }
    
}
