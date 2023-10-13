
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */

public class Usuarios {
    ArrayList<String>Descripcion = new ArrayList();
    String Nombre,Contra;
    public static int puntos;
    public Usuarios(String nombre, String contra) {
        //variables 
        Nombre=nombre;   
    
        Contra=contra;
        puntos();
    }
    public void agregardes(String des){
    if(Descripcion.size()==10){
    Descripcion.remove(0);
    }
    Descripcion.add(des);
    }
    
    public void puntosmas(){
    puntos+=3;
    }
    
    public void puntos(){
    this.puntos=0;
    }
    public int getpuntos(){
    return puntos;
    }
    public String getcontra(){
    return this.Contra;
   
    }    
    public void setcontra(String contra){   
    this.Contra=contra;
    }  
 
    public void setnombre(String nombreingresado){


     this.Contra=nombreingresado; 


    }    

    public String getnombre(){
    return this.Contra;    

    }   

    public ArrayList<String> getDescripcion() {
        return Descripcion;
    }
    
    
    
    
}
