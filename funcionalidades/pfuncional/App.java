import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    
    private static boolean IMPRIMIR=true;
    
    public static void main(String[] args){
        System.out.println( App.doblar(4) );
        App.imprimir(App::doblar,7);
        App.imprimir(App::mitad,16);         // LAZY
            // THREADSTACK
            //  main
            //      imprimir
            //          doblar
            
                      // Expresión lambda: Función anónima
                      /////////////////////////                 Java 8
        App.imprimir( (Integer numero) ->  numero*2 , 9);
        App.imprimir( (numero) ->  numero*2 , 9);
        App.imprimir( numero ->  numero*2 , 9);
        
        App.imprimirMasCompleja( (numero1,numero2) ->  numero1-numero2 , 9, 5);
        
        List<String> textos=new ArrayList<>();
        textos.add(new String("Texto1"));
        textos.add(new String("Texto2"));
        textos.add(new String("Texto3"));

        List<String> textos2=Arrays.asList(new String[]{"Texto1","Texto2","Texto3"});
        
        // Bucle: FOR
        for (String texto : textos2){
            System.out.println(texto);
        }
        for (int indice=0; indice<textos2.size();indice++){
            System.out.println(textos2.get(indice));
        }
        // JAVA1.8 - Bucle interno: > MAP - REDUCE
        textos2.stream().forEach( System.out::println );
        // Quiero que la función se aplique en paralelo sobre todos los elementos: Cores: 4
        textos2.parallelStream().forEach( System.out::println );
        
        textos2.stream()                                // ["Texto1", "Texto2", "Texto3"]
            .map( texto-> texto.toUpperCase() )         // ["TEXTO1", "TEXTO2", "TEXTO3"]
            .map( texto -> texto.substring(0,3) )       // ["TEX", "TEX", "TEX"]
            .forEach( System.out::println );
    }
    
    // THREADSTACK
    // App.imprimir(App.doblar(7));
    //  main
    //    doblar
    
    private static int doblar(int numero){
        return numero*2;
    }
    private static int mitad(int numero){
        return numero/2;
    }
    
    private static void imprimir(Function<Integer, Integer> funcion, int numero) {
        if(App.IMPRIMIR)
            System.out.println(funcion.apply(numero));
    }
    private static void imprimirMasCompleja(BiFunction<Integer,Integer , Integer> funcion, int numero1, int numero2) {
        if(App.IMPRIMIR)
            System.out.println(funcion.apply(numero1,numero2));
    }
}

// static aplicado a una función: Son funciones que van asociadas a la clase...
// no a las instancias de ella