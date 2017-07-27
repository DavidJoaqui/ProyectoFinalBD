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
import javax.swing.JOptionPane;

/**
 *
 * @author DavidJP
 */
public class ControlEmpleado_Rol {
Persistencia p = new Persistencia();
    
    
public boolean insertarEmpleado_Rol(int cod_empleado_persona,int cod_rol){
        
        boolean inserto = false;

        String sql = "Insert into empleado_rol(cod_empleado_persona,cod_rol "+")"
                + "values("+cod_empleado_persona+","+cod_rol+");";

        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarEmpleado_Rol(int cod_empleado_rol){
        boolean elimino = false;
        String sql = "Delete from empleado_rol where cod_empleado_rol = " + cod_empleado_rol;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
     
    
    public boolean actualizarEmpleado_Rol(int cod_empleado_rol,int cod_empleado_persona,int cod_rol){
        boolean actualizo = false;
        
        String sql = "Update empleado_rol set "
                + "cod_empleado_persona= "+cod_empleado_persona+",cod_rol="+cod_rol+" where cod_empleado_rol= "+cod_empleado_rol;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarEmpleado_Roles(){
        
        int numero = 0;
        String sql = "Select count(cod_empleado_rol) num from empleado_rol";
        ResultSet res = p.ejecutarConsulta(sql);
        
        try {
          
            while(res.next()){
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlRoles.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return numero;
    }
    
    public Object[][] consultarRol(int codigo){

        Object data[][] = new Object[this.contarEmpleado_Roles()][3];
        ResultSet datos = null;
        String sql = "Select cod_rol,nombre_rol from rol "
                + "where cod_rol = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_rol");
                data[i][1] = datos.getString("nombre_rol");
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
      
    
    
    public Object[][] consultarRol(){

        Object data[][] = new Object[this.contarEmpleado_Roles()][3];
        ResultSet datos = null;
        String sql = "Select * from empleado_rol";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_empleado_rol");
                data[i][1] = datos.getInt("cod_empleado_persona");
                data[i][2] = datos.getInt("cod_rol");
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlEmpleado_Rol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public Object[][] consultarRolEmpleado(int codEmpleado){

        Object data[][] = new Object[1][3];
        ResultSet datos = null;
        String sql = "Select * from empleado_rol where cod_empleado_persona="+ codEmpleado+";";
        datos = p.ejecutarConsulta(sql);

        try {
            while(datos.next()){
                data[0][0] = datos.getInt("cod_empleado_rol");
                data[0][1] = datos.getInt("cod_empleado_persona");
                data[0][2] = datos.getInt("cod_rol");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlEmpleado_Rol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
