package semana2;
import java.util.Scanner;
public class Problema2 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            SumaNumeroPositivo();
            System.out.println("Ejecucion terminada........\r\n");
        }
    } 
   
    public static void SumaNumeroPositivo(){
        System.out.println("Por favor ingrese dos Numeros, con el fin \r\n"
                + "de sumarlos e indentificar si es positivo o Negativo: \r\n");
        Scanner Numero= new Scanner(System.in);
        System.out.print("Ingrese el primer Numero: ");
        int numero_1=Numero.nextInt();
        System.out.print("Ingrese el segundo Numero: ");
        int numero_2=Numero.nextInt();
        int suma= numero_1 + numero_2;
        if(suma >=0){
            System.out.println("La suma de los numeros es: " + suma + 
                  " y es POSITIVO");  
        }else{
            System.out.println("La suma de los numeros es: " + suma + 
                  " y es NEGATIVO");
        } 
    }
}
