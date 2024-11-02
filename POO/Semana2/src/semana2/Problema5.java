package semana2;
import java.util.Scanner;
public class Problema5 {
    public static void main(String[] args) {
        System.out.print("Por favor ingresar el valor del, \r\n"
                + "producto con el fin obtener el iva: ");
        Scanner valorProducto = new Scanner(System.in);
        double valor_Producto = valorProducto.nextDouble();
        double porcentaje=0.19;
        System.out.println("\r\nValor de la compra sin IVA: " + valor_Producto);
        System.out.println("Valor del IVA: " + (valor_Producto * porcentaje));
        System.out.println("Valor de la compra con IVA: " + 
                (valor_Producto + (valor_Producto * 0.19)));
    }
    
}
