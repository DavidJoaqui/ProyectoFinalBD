/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Persistencia;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarolVasquez
 */
//autores: carol vasquez ,david joaqui
public class ControlCategorias {

    Persistencia p = new Persistencia();

    public boolean insertarCategoria(int codigoCategoria, String nombreCategoria) {

        boolean inserto = false;
        CallableStatement cs;
        try {
            cs = p.cBD.getConnection().prepareCall("{call InsertarCategoria(?,?)}");
            cs.setInt("codigo_categoria", codigoCategoria);
            cs.setString("nombre_categoria", nombreCategoria);
            cs.executeQuery();
            inserto=true;
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inserto;
    }

    public boolean eliminarCategoriaCodigo(int codigoCategoria) {
        boolean elimino = false;
        String sql = "Delete from categoria where cod_categoria = " + codigoCategoria;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }

    public boolean eliminarCategoriaNombre(String nombreCategoria) {
        boolean elimino = false;
        String sql = "Delete from categoria where nombre_categoria = '" + nombreCategoria + "'";
        elimino = p.ejecutarDML(sql);
        return elimino;
    }

    public boolean actualizarCategoria(int codigoCategoria, String nombreCategoria) {
        boolean actualizo = false;
        String sql = "Update categoria set "
                + "nombre_categoria = " + "'" + nombreCategoria
                + "' where cod_categoria = " + codigoCategoria;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }

    public int contarCategorias() {

        int numero = 0;
        String sql = "Select count(cod_categoria) num from categoria";
        ResultSet res = p.ejecutarConsulta(sql);

        try {

            while (res.next()) {
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }

    public Object[][] consultarCategoriaCodigo(int codigo) {

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select cod_categoria, nombre_categoria from categoria "
                + "where cod_categoria = " + codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_categoria");
                data[i][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarCategoriaNombre(String nombre) {

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select cod_categoria, nombre_categoria from categoria "
                + "where nombre_categoria = '" + nombre + "'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[0][0] = datos.getInt("cod_categoria");
                data[0][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarCategoriaLetras(String letras) {

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select cod_categoria, nombre_categoria from categoria "
                + "where nombre_categoria like '" + letras + "'%;";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[0][0] = datos.getInt("cod_categoria");
                data[0][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarCategoria() {

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select * from categoria";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_categoria");
                data[i][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
