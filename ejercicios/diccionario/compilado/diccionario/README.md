
# Compilar: 

javac -d compilado --module-source-path modulos modulos/diccionario/module-info.java modulos/app/module-info.java modulos/app/com/curso/app/App.java

* NOTA, falta copiar los ficheros de diccionarios (.properties) dentro de compilado/dicccionario

# Ejecutar:

java --module-path compilado -m app/com.curso.app.App