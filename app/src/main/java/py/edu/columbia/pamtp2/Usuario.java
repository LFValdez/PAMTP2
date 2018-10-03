package py.edu.columbia.pamtp2;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String categoria;
    private String usuario;
    private String contrasena;

    public enum Categoria{Docente,Estudiante}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}
