public class App {
    
    private int numero;
    private String texto;
    
    public App(int numero, String texto){
        this.numero=numero;
        this.texto=texto;
    }

    public static void main(String[] args){
        App app1=new App(14,"hola");
        System.out.println(app1.numero);
    }
    
}