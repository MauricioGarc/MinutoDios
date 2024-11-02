package semana2;
import java.util.Scanner;
public class Problema1 {
    public static void main(String[] args) {
         for (int i = 0; i < 2; i++) {
            NumeroPositivo();
            System.out.println("Ejecucion terminada........\r\n");
        }
    }
    public static void NumeroPositivo(){
        System.out.print("Por favor ingrese un Numero, \r\n"
                + "con el fin de indentificar si es \r\n"
                + "positivo o Negativo: ");
        Scanner LeerNumero= new Scanner(System.in);
        int Numero=LeerNumero.nextInt();
        if(Numero >=0){
          System.out.println("El numero Ingresado (" + Numero + 
                  ") es POSITIVO");  
        }else{
          System.out.println("El numero Ingresado (" + Numero + 
                  ") es NEGATIVO");
        } 
    } 
}
