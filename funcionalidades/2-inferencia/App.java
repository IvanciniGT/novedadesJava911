import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
public class App {
    
    int hola=17;
    //var adios=17; Aquí no es válido. Solo en variables de métodos.
    
    //@Override
    public static void main( String [] args ){
        
        /*int*/ var numero1=17;
        // Compilador de java: Osease: JAVAC, estoy hhoy muy perro...
        // Y no quiero escribir mucho... Rellena tu el tipo de ddato por mi...
        // Que me cuesta muchos escribit int... parece que var es mar corto.. 
        // o no se... porque si no no entiendo por uso esto... me he vuelto loco...
        
        /*int*/ var numero2=23;             // NO ES MALA PRACTICA OFICIAL!!! pero tampoco !!!
        
        // var proyecto_id = proyecto.getId(); // MALA PRACTICA OFICIAL!
        
        /*int*/ var resultado=numero1+numero2;
        
        /*String*/ var texto = new String("Resultado "); // Inferencia del tipo
        
        //String texto2 = new String("HOLA AMIGOS DESDE EL FUTURO JAVA 10... o no tan futuro :( ");
        String texto2 = "HOLA AMIGOS DESDE EL FUTURO JAVA 10... o no tan futuro :( ";
        var texto3 = "HOLA AMIGOS DESDE EL FUTURO JAVA 10... o no tan futuro :( ";
    
        
        // texto=4; // Válido en lenguajes de tipado dinámico: JS / Python... NUNCA EN JAVA
        
        System.out.println(texto + resultado);
        
        // Este cambio es RUINA para los JAVEROS DE VERDAD de la BUENA !!!!
        // Aporta dificultad de lectura y CONFUSION !!!
        Map<String,Integer> edades=new HashMap<String,Integer>();
        Map<String,Integer> edades2=new HashMap<>();
        
        var edades3=new HashMap<String, Integer>(); // NOS MOLA !!!

        
        //var email; // PETA. No es posible la inferencia de tipo
        //var email = null;
        
        BiFunction<Double,Double, Double> myfunct1= ( numeroA,  numeroB) -> numeroA+numeroB;
                   // ARG1. ARG2.  RETURN
        //BiFunction<Double,Double, Double> myfunct2 = (@NonNull Double numeroA, Double numeroB) -> numeroA+numeroB;
        // var myfunct3 = (Double numeroA, Double numeroB) -> numeroA+numeroB;
        // LIMITACION DEL USO DEL VAR: EN LOS LAMBDA NO PUEDO !!!!!

        BiFunction<Double,Double, Double> myfunct3 = (var numeroA, var numeroB) -> numeroA + numeroB;
        //BiFunction<Double,Double, Double> myfunct4 = (@NonNull var numeroA,  var numeroB   ) -> numeroA+numeroB;


        

    }
    
}