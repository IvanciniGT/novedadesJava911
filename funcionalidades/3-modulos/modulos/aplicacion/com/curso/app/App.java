package com.curso.app;
import com.curso.moduloa.Clase;         // Modelos
import com.curso.moduloa.Interfaz;

// OLD STYLE import com.curso.moduloa.ClaseQueImplementaInterfaz;
// JAVA 9 STYLE
import java.util.ServiceLoader;

public class App {
    
    public static void main(String[] args){
        System.out.println(  Clase.getText() );
        Clase clase1=new Clase();
        System.out.println(  clase1.getNumber() );
        
        // OLD STYLE         
        //    Interfaz interfaz=new ClaseQueImplementaInterfaz();
        
        // JAVA 9
        Iterable<Interfaz> interfaces = ServiceLoader.load(Interfaz.class);
        Interfaz interfaz = interfaces.iterator().next(); // La primera
        
        System.out.println(  interfaz.dameTexto() );
    }
    
}