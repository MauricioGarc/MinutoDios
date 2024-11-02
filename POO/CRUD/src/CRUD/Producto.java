
package CRUD;

public class Producto{
        public String codigo_prodcuto="";
        public String nombre="";
        public String descripcion="";
        public int cantidad_en_inventario=0;
        public double precio_venta=0;
        public int producto_activo=0;
        
        public void Producto (String codigo_prodcuto, String nombre, String descripcion, int cantidad_en_inventario, double precio_venta, int producto_activo){
            this.codigo_prodcuto=codigo_prodcuto;
            this.nombre=nombre;
            this.descripcion=descripcion;
            this.cantidad_en_inventario=cantidad_en_inventario;
            this.precio_venta=precio_venta;
            this.producto_activo=producto_activo;
        } 
    }
