module diccionario {

    requires java.logging;

    exports com.curso.diccionario;

    provides com.curso.diccionario.Diccionario
            with com.curso.diccionario.impl.DiccionarioEspanol,
                 com.curso.diccionario.impl.DiccionarioFrances;

    uses com.curso.diccionario.Diccionario;

}
