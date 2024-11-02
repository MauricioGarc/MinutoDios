package semana2;
import java.util.Scanner;
public class Problema9 {
    public static void main(String[] args) {
        Scanner LeerNumero= new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print("Por favor ingrese un Numero, que este entre 1 y 9 \r\n"
                + "con el fin de mostrar la tabla de multiplicacion:  ");
            int Numero=LeerNumero.nextInt();
            System.out.println("");
            TablaMultiplicacion(Numero);
            System.out.println("Ejecucion terminada........\r\n");
        }
    }
    public static void TablaMultiplicacion(int Numero){
        if (Numero >=1 && Numero <= 9) {
            System.out.println("Tabla de Multiplicacion del numero " + Numero);
            for (int i = 1; i < 10; i++) {
                System.out.println("    " + Numero + " x " + i + " = " + (Numero*i));
            }
        }else{
             System.out.println("Valor ingresado no valido");
        }
    }
}
