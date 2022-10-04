modulos
    aplicacion                          - MODULO
        module-info.java
        com.curso.app                   - PAQUETE
                     App.java           - CLASE
                     
    modulo1                             - MODULO
        module-info.java
        com.curso.modulo1               - PAQUETE
                         Clase.java     - CLASE

set PATH=RUTA_JAVA/bin;%PATH%
set JAVA_HOME=RUTA_JAVA

--- Compilar

javac -d compilado \
      --module-source-path modulos \
      modulos/aplicacion/com/curso/app/App.java \
      modulos/aplicacion/module-info.java \
      modulos/moduloa/com/curso/moduloa/Clase.java \
      modulos/moduloa/module-info.java
      
--- Ejecutar
java --module-path compilado -m aplicacion/com.curso.app.App








SonarQube Analisis estatico de código 
-------------------------------------

Smell codes - Que código ATUFA APESTA !!!!
    Malas prácticas

Deuda técnica (horas de trabajo): El tiempo que me costaría arreglar esos smell codes + bugs

Todas las mañanas pasar mi codigo por sonarqube:
Informe de las 20 cosas que he hecho el dia anterior que son ruinosas!
Y las corrijo... 10 minutos. Y ya no las hago más... Y APRENDO. ME HAGO MEJOR PROGRAMADOR !!!!


API ????
Application Programming Interface