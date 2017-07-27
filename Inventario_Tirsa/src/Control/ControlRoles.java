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
 * @author DavidJP
 */
public class ControlRoles {
    Persistencia p = new Persistencia();
    
    
public boolean insertarRol(int cod_rol,String nombre_rol){
        
        boolean inserto = false;

        String sql = "Insert into rol(cod_rol,nombre_rol "+")"
                + " values("+cod_rol+",'"+nombre_rol+"');";

        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarRol(int cod_rol){
        boolean elimino = false;
        String sql = "Delete from rol where cod_rol = " + cod_rol;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
     
    
    public boolean actualizarRol(int cod_rol, String nombre_rol){
        boolean actualizo = false;
        
        String sql = "Update rol set "
                + "nombre_rol= '"+nombre_rol+"' where cod_rol= "+cod_rol;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarRoles(){
        
        int numero = 0;
        String sql = "Select count(cod_rol) num from rol";
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

        Object data[][] = new Object[1][2];
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
      
    public Object[][] consultarRolTodos(int codigo, String nombre){

        Object data[][] = new Object[1][2];
        ResultSet datos = null;
        String sql = "Select cod_rol,nombre_rol from rol "
                + "where cod_rol = "+codigo+ "& nombre_rol= '"+nombre+"'";
        datos = p.ejecutarConsulta(sql);

        try {
            while(datos.next()){
                data[0][0] = datos.getInt("cod_rol");
                data[0][1] = datos.getString("nombre_rol");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }    
    
    public Object[][] consultarRolNombre(String nombre){

        Object data[][] = new Object[1][2];
        ResultSet datos = null;
        String sql = "Select cod_rol,nombre_rol from rol "
                + "where nombre_rol= '"+nombre+"'";
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

        Object data[][] = new Object[this.contarRoles()][2];
        ResultSet datos = null;
        String sql = "Select * from rol";
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
    
//    public static void main(String[] args) {
//        ControlRoles cr = new ControlRoles(); 
//
//        boolean inserto=cr.insertarRol(1234,"Admin");
//        if (inserto) {
//            System.out.println("inserto...");
//        }
//        else{
//            System.out.println("error...");
//    }
    
//        boolean elimino=cr.eliminarRol(12334);
//        if (elimino) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("error...");
//        }
    
//        
//        boolean actualizo=cr.actualizarRol(12334,"vendedor");
//        if(actualizo){
//            System.out.println("actualizo...");
//        }else{
//            System.out.println("error...");
//        }
    
        
        
//        int aux=cr.contarRoles();
//        System.out.println("el numero de roles es : "+aux);
//        
//        
 
       
        //Prueba
//        Object[][] dato = cr.consultarRol();        
//        for (int i = 0; i < cr.contarRoles(); i++) {
//                System.out.println("Codigo Rol: "+ dato[i][0]+ " nombre rol: "+dato[i][1]);
//        }
//  }
    //}
}
