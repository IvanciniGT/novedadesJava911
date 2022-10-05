module diccionario {

    requires java.logging;
    //requires lombok;

    exports com.curso.diccionario; // to app;

    provides com.curso.diccionario.Diccionario
            with com.curso.diccionario.impl.DiccionarioEspanol,
                 com.curso.diccionario.impl.DiccionarioFrances;

    uses com.curso.diccionario.Diccionario;
    // opens  com.curso.diccionario to OTRO_MODULO; / poder usar este paquete desde REFLECTION

}
