module diccionario {
    exports com.curso.diccionario;
    provides com.curso.diccionario.Diccionario with com.curso.diccionario.impl.DiccionarioEspañol,
                                                    com.curso.diccionario.impl.DiccionarioFrances;
}
