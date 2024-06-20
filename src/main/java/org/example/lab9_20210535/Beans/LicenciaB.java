package org.example.lab9_20210535.Beans;

public class LicenciaB {
    private int idLicencia;
    private String categoria;
    private String fecha_emision;
    private String fecha_caducidad;
    private PaisB paisB;

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public PaisB getPaisB() {
        return paisB;
    }

    public void setPaisB(PaisB paisB) {
        this.paisB = paisB;
    }
}
