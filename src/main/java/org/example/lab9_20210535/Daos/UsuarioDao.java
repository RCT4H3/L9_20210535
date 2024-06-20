package org.example.lab9_20210535.Daos;

import org.example.lab9_20210535.Beans.LicenciaB;
import org.example.lab9_20210535.Beans.PaisB;
import org.example.lab9_20210535.Beans.UsuarioB;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends DaoBase{
    public ArrayList<UsuarioB> listarUsuarioOperativo(){
        ArrayList<UsuarioB> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario u\n" +
                "left join licencia l ON (l.idlicencia = u.licencia_idlicencia)\n" +
                "left join pais p ON (p.idpais = l.pais_idpais);";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UsuarioB usuario = new UsuarioB();
                if (rs.getInt(5) == 1 || rs.getInt(5)==3) {
                    usuario.setIdUsuario(1);
                    usuario.setNombres(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setTelefono(rs.getString(4));
                    LicenciaB licenciaB = new LicenciaB();
                    licenciaB.setIdLicencia(rs.getInt(7));
                    licenciaB.setCategoria(rs.getString(8));
                    licenciaB.setFecha_emision(rs.getString(9));
                    licenciaB.setFecha_caducidad(rs.getString(10));
                    PaisB paisB = new PaisB();
                    paisB.setIdPais(rs.getInt(11));
                    paisB.setNombrePais(rs.getString(13));
                    licenciaB.setPaisB(paisB);
                    usuario.setLicenciaB(licenciaB);
                    lista.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public boolean validarUsuarioPasswordHashed(String email, String password){

        String sql = "SELECT * FROM credenciales_usuario where correo = ? and contraseña_encriptada = sha2(?,256)";

        boolean exito = false;

        try(Connection connection = getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,email);
            pstmt.setString(2,password);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    exito = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exito;
    }
    public int obtenerUsuarioPorCorreo(String email) {

        String sql = "SELECT * FROM credenciales_usuario where correo = ?";
        int id = 0;
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return id;
    }
    public UsuarioB obtenerUsuarioPorID(int idUser) {
        UsuarioB usuario = null;
        String sql = "SELECT * FROM rentaautos.usuario WHERE idusuario = ?";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUser);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    usuario = new UsuarioB();
                    usuario.setIdUsuario(idUser);
                    usuario.setNombres(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setTelefono(rs.getString(4));

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuario;
    }

}
