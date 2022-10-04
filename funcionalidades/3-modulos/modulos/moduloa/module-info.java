module moduloa {

    // Que paquetes de este modulo 
    // exporto a otros modulos
    exports com.curso.moduloa; // to aplicacionb;
    
    // Servicio ofrecido                     El código estará en una clase
    provides com.curso.moduloa.Interfaz with 
          com.curso.moduloa.ClaseQueImplementaInterfaz
        , com.curso.moduloa.ClaseQueImplementaInterfaz2 ;
    
}