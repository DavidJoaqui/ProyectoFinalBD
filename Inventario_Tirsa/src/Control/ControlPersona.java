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
public class ControlPersona {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarPersona(int codigoPersona, int numDocumento, String nombresPersona, String apellidosPersona,
            String correoPersona, String fechaNacimiento){
        
        boolean inserto = false;
        String sql = "Insert into persona (cod_persona, num_documento, nombres_persona, apellidos_persona,"
                + "correo_persona, fecha_nac_persona) values ("+codigoPersona+", "+numDocumento+", "
                + "'"+nombresPersona+"', '"+apellidosPersona+"', '"+correoPersona+"', '"+fechaNacimiento+"')";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarPersonaDocumento(int documentoPersona){
        boolean elimino = false;
        String sql = "Delete from persona where num_documento = " + documentoPersona;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean actualizarPersona(int codigoPersona, int numDocumento, String nombresPersona, String apellidosPersona,
            String correoPersona, String fechaNacimiento){
        boolean actualizo = false;
        String sql = "Update persona set "
                + "num_documento = "+numDocumento
                + ", nombres_persona = '"+nombresPersona
                + "', apellidos_persona = '"+apellidosPersona
                + "', correo_persona = '"+correoPersona   
                + "', fecha_nac_persona = '"+fechaNacimiento                 
                + "' where cod_persona = "+codigoPersona+";";
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarPersonas(){
        
        int numero = 0;
        String sql = "Select count(cod_persona) num from persona";
        ResultSet res = p.ejecutarConsulta(sql);
        
        try {
          
            while(res.next()){
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return numero;
    }
    
    public Object[][] consultarPersonaDocumento(int numDocumento){

        Object data[][] = new Object[this.contarPersonas()][6];
        ResultSet datos = null;
        String sql = "Select cod_persona, num_documento, nombres_persona, apellidos_persona,"
                + "correo_persona, fecha_nac_persona from persona "
                + "where num_documento = "+numDocumento;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_persona");
                data[i][1] = datos.getInt("num_documento");
                data[i][2] = datos.getString("nombres_persona");
                data[i][3] = datos.getString("apellidos_persona");
                data[i][4] = datos.getString("correo_persona");       
                data[i][5] = datos.getString("fecha_nac_persona");                   
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
    
    public Object[][] consultarPersonas(){

        Object data[][] = new Object[this.contarPersonas()][6];
        ResultSet datos = null;
        String sql = "Select * from persona";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_persona");
                data[i][1] = datos.getInt("num_documento");
                data[i][2] = datos.getString("nombres_persona");
                data[i][3] = datos.getString("apellidos_persona");
                data[i][4] = datos.getString("correo_persona");       
                data[i][5] = datos.getString("fecha_nac_persona");    
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public Object[][] consultarPersonaTodos(int numDocumento, String nombres, String apellidos){
        Object data[][] = new Object[this.contarPersonas()][6];
        ResultSet datos = null;
        String sql = "Select cod_persona, num_documento, nombres_persona, apellidos_persona, correo_persona, "
                + "fecha_nac_persona from persona where num_documento = "+numDocumento+"&& nombres_persona='"+nombres+"' "
                + "&& apellidos_persona='"+apellidos+"'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_persona");
                data[i][1] = datos.getInt("num_documento");
                data[i][2] = datos.getString("nombres_persona");
                data[i][3] = datos.getString("apellidos_persona");
                data[i][4] = datos.getString("correo_persona");       
                data[i][5] = datos.getString("fecha_nac_persona");                   
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;        
    }
    
    public Object[][] consultarPersonaNombres(String nombres){
        Object data[][] = new Object[this.contarPersonas()][6];
        ResultSet datos = null;
        String sql = "Select cod_persona, num_documento, nombres_persona, apellidos_persona, correo_persona, "
                + "fecha_nac_persona from persona where nombres_persona='"+nombres+"'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_persona");
                data[i][1] = datos.getInt("num_documento");
                data[i][2] = datos.getString("nombres_persona");
                data[i][3] = datos.getString("apellidos_persona");
                data[i][4] = datos.getString("correo_persona");       
                data[i][5] = datos.getString("fecha_nac_persona");                   
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;        
    } 
    
    public Object[][] consultarPersonaDocNombres(int numDocumento, String nombres){
        Object data[][] = new Object[this.contarPersonas()][6];
        ResultSet datos = null;
        String sql = "Select cod_persona, num_documento, nombres_persona, apellidos_persona, correo_persona, "
                + "fecha_nac_persona from persona where num_documento = "+numDocumento+"&& nombres_persona='"+nombres+"'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_persona");
                data[i][1] = datos.getInt("num_documento");
                data[i][2] = datos.getString("nombres_persona");
                data[i][3] = datos.getString("apellidos_persona");
                data[i][4] = datos.getString("correo_persona");       
                data[i][5] = datos.getString("fecha_nac_persona");                   
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;        
    }      
    
}
