/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CarolVasquez
 */
public class ControlEmpleado {

    Persistencia p = new Persistencia();
    
    public boolean insertarEmpleado(int codigoEmpleado, String loginEmpleado, String psswdEmpleado) {

        boolean inserto = false;
        String sql = "Insert into empleado (cod_empleado_persona, login_empleado, password_empleado) "
                + "values (" + codigoEmpleado + ", '" + loginEmpleado + "', '" + psswdEmpleado + "')";
        inserto = p.ejecutarDML(sql);
        return inserto;
    }

    public boolean eliminarEmpleadoCodigo(int codigoEmpleado) {
        boolean elimino = false;
        String sql = "Delete from empleado where cod_empleado_persona = " + codigoEmpleado+";";
        elimino = p.ejecutarDML(sql);
        return elimino;
    }

    public boolean actualizarEmpleado(int codigoEmpleado, String loginEmpleado, String psswdEmpleado) {
        boolean actualizo = false;
        String sql = "Update empleado set login_empleado = '" + loginEmpleado + "', password_empleado = '" + psswdEmpleado + "' where cod_empleado_persona = " + codigoEmpleado;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }

    public int contarEmpleados() {

        int numero = 0;
        String sql = "Select count(cod_empleado_persona) num from empleado";
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

    public int contarEmpleadosBloqueados() {

        int numero = 0;
        String sql = "Select count(cod_empleado_persona) num from empleado where bloqueado = 'T'";
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
        
    public Object[][] consultarEmpleadoPersona(int codigo) {

        Object data[][] = new Object[this.contarEmpleados()][8];
        ResultSet datos = null;
        String sql = "Select cod_empleado_persona, login_empleado, password_empleado,num_documento,nombres_persona,apellidos_persona,correo_persona,fecha_nac_persona from empleado "
                + "inner join persona on(empleado.cod_empleado_persona=persona.cod_persona)"
                + " where cod_empleado_persona = " + codigo + ";";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_empleado_persona");
                data[i][1] = datos.getString("login_empleado");
                data[i][2] = datos.getString("password_empleado");
                data[i][3] = datos.getInt("num_documento");
                data[i][4] = datos.getString("nombres_persona");
                data[i][5] = datos.getString("apellidos_persona");
                data[i][6] = datos.getString("correo_persona");
                data[i][7] = datos.getString("fecha_nac_persona");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarEmpleadoLogin(String login) {

        Object data[][] = new Object[1][4];
        ResultSet datos = null;
        String sql = "Select cod_empleado_persona, login_empleado, password_empleado, bloqueado from empleado "
                + "where login_empleado = '" + login + "';";
        datos = p.ejecutarConsulta(sql);

        try {
            while (datos.next()) {
                data[0][0] = datos.getInt("cod_empleado_persona");
                data[0][1] = datos.getString("login_empleado");
                data[0][2] = datos.getString("password_empleado");
                data[0][3] = datos.getString("bloqueado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarEmpleado() {

        Object data[][] = new Object[this.contarEmpleados()][3];
        ResultSet datos = null;
        String sql = "Select * from empleado";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_empleado_persona");
                data[i][1] = datos.getString("login_empleado");
                data[i][2] = datos.getString("password_empleado");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public boolean insertarAcceso(int codigoEmpleado, int num_intentos) {
        boolean inserto = false;
        String sql = "Insert into historial_accesos (num_intentos, cod_empleado) "
                + "values (" + num_intentos + ", " + codigoEmpleado + ")";
        inserto = p.ejecutarDML(sql);
        return inserto;
    }  
    
    public Object[][] consultarEmpleadoBloqueado() {

        Object data[][] = new Object[this.contarEmpleadosBloqueados()][2];
        ResultSet datos = null;
        String sql = "Select cod_empleado_persona, login_empleado from empleado where bloqueado = 'T'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_empleado_persona");
                data[i][1] = datos.getString("login_empleado");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public boolean DesbloquearUsuario(int codigoEmpleado, String bloqueo) {
        boolean actualizo = false;
        String sql = "Update empleado set bloqueado= '"+ bloqueo +"' where cod_empleado_persona = " + codigoEmpleado;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }      
    
    public boolean eliminarHistorial(int codigoEmpleado){
        boolean elimino = false;
        String sql = "Delete from historial_accesos where cod_empleado = " + codigoEmpleado+";";
        elimino = p.ejecutarDML(sql);
        return elimino;        
    }

    //public Object[][] consul
//    public static void main(String[] args) {
//        ControlEmpleado ce = new ControlEmpleado();        
//        Object[][] dato = ce.consultarEmpleadoLogin("CarolVasquezB");
//        System.out.println("Login "+ dato[0][1]+ "Contraseña "+dato[0][2]);       
//    }
}
