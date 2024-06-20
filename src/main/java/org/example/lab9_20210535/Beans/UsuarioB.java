package org.example.lab9_20210535.Beans;

import javax.management.relation.Role;

public class UsuarioB {
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String telefono;
    private RolB rolB;
    private LicenciaB licenciaB;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RolB getRolB() {
        return rolB;
    }

    public void setRolB(RolB rolB) {
        this.rolB = rolB;
    }

    public LicenciaB getLicenciaB() {
        return licenciaB;
    }

    public void setLicenciaB(LicenciaB licenciaB) {
        this.licenciaB = licenciaB;
    }
}
