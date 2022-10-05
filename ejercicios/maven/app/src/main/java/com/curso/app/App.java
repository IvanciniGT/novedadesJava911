package com.curso.app;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;
import com.curso.diccionario.Diccionario;

public class App {
    public static void main(String[] args){
        // Obtener un listado de todas las implementaciones posibles de Diccionario
        Iterable<Diccionario> diccionarios = ServiceLoader.load(Diccionario.class);
        
        // Filtramos los potenciales diccionarios, para quedarnos con el de idioma ES
        Diccionario diccionarioEspanol=StreamSupport.stream(diccionarios.spliterator(), false)
                                                    .filter( diccionario-> diccionario.getIdioma().equals("ES"))
                                                    .findFirst()
                                                    .orElseThrow();
    
        //for(Diccionario dict: diccionarios){
        //    if(diccionario.getIdioma().equals("ES")){
        //        diccionario=dict;
        //        break;
        //    }
        //}
        //if (diccionario==null) throw new NotSuchElementException();
        
        while(true){
            
            System.out.print("Dame una palabra: ");
            String palabra = System.console().readLine().trim();
            
            if(palabra.length()==0){
              System.out.print("Gracias por usar el diccionario ACME®");
              return;  
            } 
            
            if(diccionarioEspanol.existe(palabra)){
                System.out.println("La palabra existe");
            }else{
                System.out.println("La palabra no existe. Sugerencias");
                var correcciones = diccionarioEspanol.corregir(palabra);
                correcciones.stream().forEach(System.out::println);
            }
        }
 
    }
}