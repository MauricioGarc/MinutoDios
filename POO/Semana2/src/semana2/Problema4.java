package semana2;
import java.util.Scanner;
public class Problema4 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            NumerosRomanos();
            System.out.println("Ejecucion terminada........\r\n");
        }
    }
    public static void NumerosRomanos(){
         System.out.println("Por favor ingrese un numero romano, \r\n"
                + "es importante acotar que este progrma solo \r\n"
                + "identifica los numero de 1 al 10 \r\n");
         Scanner NumeroRomano= new Scanner(System.in);
         System.out.print("Ingrese el Numero Romano: ");
         String numero=NumeroRomano.next();
         switch(numero){
             case "I" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 1");
             case "II" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 2");
             case "III" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 3");
             case "IV" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 4");
             case "V" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 5");
             case "VI" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 6");
             case "VII" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 7");
             case "VIII" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 8");
             case "IX" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 9");
             case "X" -> System.out.println("El numero ingresado (" + numero + ") en decimal es: 10");
             default -> System.out.println("El numero ingresado (" + numero + ") no es valido");
         }
    }
}
