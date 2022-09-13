package cl.isisur.proyectoapp;

public class PerfilModelo {
    private String nombre,detalles;
    private int imgperfil;

    public PerfilModelo() {
    }

    public PerfilModelo(String nombre, String detalles, int imgperfil) {
        this.nombre = nombre;
        this.detalles = detalles;
        this.imgperfil = imgperfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getImgperfil() {
        return imgperfil;
    }

    public void setImgperfil(int imgperfil) {
        this.imgperfil = imgperfil;
    }
}
