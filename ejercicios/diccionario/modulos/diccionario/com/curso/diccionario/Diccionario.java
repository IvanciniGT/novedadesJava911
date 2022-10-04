package com.curso.diccionario;

public interface Diccionario {
 
    static String getIdiomaPorDefecto(){
        //Leerlo de un fichero
        throw new NotImplementedException();
    }
    
    String getIdioma();
    
    // Estos métodos default se usan para dotar a los interfaces de nuevos
    // métodos, sin necesitar cambiar todas las implemntaciones
    // FACILITAR EL MNTO DE LA APP
    default boolean isPorDefecto(){
        return getIdioma().equals(Diccionario.getIdiomaPorDefecto()) ;
    }
    
    Optional<String> getSignificado(String termino);
    
    boolean existe(String termino); // Editar de correo interactivo. Pantallita.
                                    // Cada palabra que se escriba, saber si existe.. Si no existe: SUBARAYADA ROJO
    
    List<String> corregir(String termino); // Me da la lista deposibilidades 

}