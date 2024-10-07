package Problema1;

import java.util.ArrayList;
import java.util.List;

public class Estudiantes {
    private List<Estudiantes> ListadoEstudiantes = null;
    private String Nombres;
    private String Apellidos;
    private String Documento;
    private String Direccion;
    private int Telefono;   
    private String Carrera;
    private String Modalidad;
    private int Semestre;
    private int CreditosPerdidos;
    private double Preciobase;
    
    public Estudiantes(){
       ListadoEstudiantes = BuscarEstudiantes();
    }
    private List<Estudiantes> BuscarEstudiantes(){
        List<Estudiantes> students= new ArrayList<Estudiantes>();
        students.add(new Estudiantes("Andres Mauricio","Garcia Nivia","1032472499","Calle 49 d bis",320916254,"Ingeniera de Sistemas","Virtual",5,0,1500));
        students.add(new Estudiantes("Juan", "Perez", "12345678", "Calle Falsa 123",5551234,"Matematicas Aplciadas","Presencial",4,2,1500));
        students.add(new Estudiantes("Maria", "Gonzalez", "87654321", "Av. Siempre Viva 456",5555678,"Economia","Presencial",2,8,1500));
        students.add(new Estudiantes("Pedro", "Lopez", "11223344", "Calle Real 789",5559876,"Economia","Virtual",6,4,1500));
        students.add(new Estudiantes("Laura", "Rodriguez", "55667788", "Calle Luna 101",5554321,"Ingeniera de Sistemas","Presencial",5,6,1500));
        students.add(new Estudiantes("Andres", "Martinez", "33445566", "Calle Sol 202",5556543,"Ciencias Politicas","Presencial",1,3,1500));
        students.add(new Estudiantes("Ana", "Torres", "99887766", "Av. Estrella 303",5558765,"Ciencias Politicas","Virtual",4,2,1500));
        students.add(new Estudiantes("Carlos", "Fernandez", "77889900", "Plaza Norte 404",5557890,"Matematicas Aplciadas","Virtual",7,0,1500));
        students.add(new Estudiantes("Sofia", "Ramirez", "44332211", "Calle Sur 505",5555670,"Ingeniera de Sistemas","Presencial",5,0,1500));
        students.add(new Estudiantes("Diego", "Castro", "66778899", "Calle Este 606",5553456,"Ingeniera de Sistemas","Presencial",9,0,1500));
        students.add(new Estudiantes("Lucia", "Gomez", "55443322", "Calle Oeste 707",5559870,"Matematicas Aplciadas","Presencial",2,4,1500));
        return students;
    }
    private Estudiantes(String nombres, String apellidos, String documento, String direccion, 
            int telefono, String carrera, String modalidad,int semestre, int creditosPerdidos, double preciobase){
        this.Nombres = nombres;
        this.Apellidos = apellidos;
        this.Documento = documento;
        this.Direccion = direccion;
        this.Telefono = telefono;
        this.Carrera = carrera;
        this.Modalidad = modalidad;
        this.Semestre = semestre;
        this.CreditosPerdidos = creditosPerdidos;
        this.Preciobase = preciobase;
    }
    
    public int getSemestre(String Palumno){
        int alumno = Integer.parseInt(Palumno);
        return ListadoEstudiantes.get(alumno).Semestre;
    }
    public String getModalidad(String Palumno){
        int alumno = Integer.parseInt(Palumno);
        return ListadoEstudiantes.get(alumno).Modalidad;
    }
    
    public int getCreditosPerdidos(String Palumno){
        int alumno = Integer.parseInt(Palumno);
        return ListadoEstudiantes.get(alumno).CreditosPerdidos;
    }
    
    public double getPreciobase(String Palumno){
        int alumno = Integer.parseInt(Palumno);
        return ListadoEstudiantes.get(alumno).Preciobase;
    }
    
    public String getAlumno(String Palumno){
        int alumno = Integer.parseInt(Palumno);
        return "    Nombre: " + ListadoEstudiantes.get(alumno).Nombres + "\r\n" +
               "    Apellidos: " + ListadoEstudiantes.get(alumno).Apellidos + "\r\n" +
               "    Documento: " + ListadoEstudiantes.get(alumno).Documento + "\r\n" +
               "    Direccion: " + ListadoEstudiantes.get(alumno).Direccion + "\r\n" +
               "    Telefono: " + ListadoEstudiantes.get(alumno).Telefono ;
    }
    
    public String getIdAlumno(String Documento, String Carrera){
        for(int i = 0; i < ListadoEstudiantes.size(); i++) {
            if (ListadoEstudiantes.get(i).Documento.equals(Documento) && 
                    ListadoEstudiantes.get(i).Carrera.equals(Carrera)) {
                return i + "";
            }
        }
        return "";
    }
    
    public boolean setAlumno(String Palumno, String Name, String lastName, 
            String address, int Phone) {
       try{
        int alumno = Integer.parseInt(Palumno);
        ListadoEstudiantes.get(alumno).Nombres=Name;
        ListadoEstudiantes.get(alumno).Apellidos=lastName;
        ListadoEstudiantes.get(alumno).Direccion=address;
        ListadoEstudiantes.get(alumno).Telefono=Phone;
        return true;
       }
       catch(Exception e) {
           return false;
       }
    }
    
}
