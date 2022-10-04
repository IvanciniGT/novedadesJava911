package com.curso.app;
import com.curso.moduloa.Clase;         // Modelos
import com.curso.moduloa.Interfaz;
// OLD STYLE import com.curso.moduloa.ClaseQueImplementaInterfaz;
// JAVA 9 STYLE
import java.util.ServiceLoader;
// JAVA 8
import java.util.stream.StreamSupport;
public class App {
    
    public static void main(String[] args){
        System.out.println(  Clase.getText() );
        Clase clase1=new Clase();
        System.out.println(  clase1.getNumber() );
        
        // OLD STYLE         
        //    Interfaz interfaz=new ClaseQueImplementaInterfaz();
        
        // JAVA 9
        Iterable<Interfaz> interfaces = ServiceLoader.load(Interfaz.class);
        //Interfaz interfaz = interfaces.iterator().next(); // La primera
        //System.out.println(  interfaz.dameTexto() );
        
        // OLD STYLE
        //for (Interfaz interfaz : interfaces)
        //    System.out.println(  interfaz.dameTexto() );
        
        // JAVA 8
        //Stream<Interfaz> miStream=StreamSupport.stream(interfaces.spliterator(), false); //Paralelo
        StreamSupport.stream(interfaces.spliterator(), true).forEach(  interfaz -> System.out.println(  interfaz.dameTexto()  )  );
    }
    
}