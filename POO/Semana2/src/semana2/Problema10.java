package semana2;
import java.util.Scanner;
public class Problema10 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            NumeroPrimo();
            System.out.println("Ejecucion terminada........\r\n");
        }
    }  
    public static void NumeroPrimo(){
        System.out.print("Por favor ingrese un Numero, \r\n"
                + "con el fin de indentificar si es \r\n"
                + "primo o no es primo: ");
        Scanner LeerNumero= new Scanner(System.in);
        int Numero=LeerNumero.nextInt();
        double resultado= Numero % 2;
        if(resultado == 0){
          System.out.println("El numero Ingresado (" + Numero + 
                  ") es PRIMO");  
        }else{
          System.out.println("El numero Ingresado (" + Numero + 
                  ") no es PRIMO");
          
        } 
    }
    
}
