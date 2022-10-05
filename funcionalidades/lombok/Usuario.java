import lombok.*;

public class Usuario {
    
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellidos;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private int edad;
    
}