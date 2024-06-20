package org.example.lab9_20210535.Beans;

public class CredencialesB {
    private int idUsuario;
    private String correo;
    private String contrasenha_encriptada;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha_encriptada() {
        return contrasenha_encriptada;
    }

    public void setContrasenha_encriptada(String contrasenha_encriptada) {
        this.contrasenha_encriptada = contrasenha_encriptada;
    }
}
