import java.util.*;

public class Colecciones {
    
    public static void main(String[] args){
        // JAVA 9 . Constructores de Colecciones 
        // todas estas colecciones son IMNUTABLES
        Set<String> miSet = Set.of("hola","amigo","como estas");      // Comodo
        List<String> miLista = List.of("hola","amigo","como estas");  // Comodo
        Map<String,String> miMap = Map.of("clave1","valor1","clave2","valor2","clave3","valor3"); // comodo
        
        // JAVA 10
        
        //Set, List, Map copyOf Pero inmutables
        Set<String> miSet2 = Set.copyOf(miSet);
        List<String> miLista2 = List.copyOf(miLista);
        Map<String,String> miMap2 = Map.copyOf(miMap);
        
        System.out.println("Funciona!!!!");
        
        // Esto lo podría ejecutar directamente en JAVA 11 con:
        // $ java Colecciones.java
        // $ java Colecciones               Con este no
    }
    
}