/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Modelo.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidJP
 */
//modificado hoy lunes 22 de mayo 2017
public class ControlAbonos {
 Persistencia p = new Persistencia();
    
    public boolean insertarAbono(int cod_abono, float valor_abono, int cod_factura){
        
        boolean inserto = false;

        String sql = "Insert into abonos(cod_abono, valor_abono, cod_factura "+")"
                + " values("+cod_abono+","+valor_abono+",'"+cod_factura+"');";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarAbono(int codigo_abono){
        boolean elimino = false;
        String sql = "Delete from abonos where cod_abono = " + codigo_abono;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
     
    
    public boolean actualizarAbono(int cod_abono,float valor_abono){
        boolean actualizo = false;
        float acum_total=0;
        float valor_abono_antiguo=0;
        Object[][]data=this.consultarAbono(cod_abono);        
                  
                valor_abono_antiguo=(float)data[0][1]; 
                acum_total=(valor_abono_antiguo+valor_abono);
                  
        String sql = "Update abonos set "
                + "valor_abono = "+acum_total +"where cod_abono = "+cod_abono;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarAbonos(){
        
        int numero = 0;
        String sql = "Select count(cod_abono) num from abonos";
        ResultSet res = p.ejecutarConsulta(sql);
        
        try {
          
            while(res.next()){
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return numero;
    }
    
    public Object[][] consultarAbono(int codigo){

        Object data[][] = new Object[this.contarAbonos()][2];
        ResultSet datos = null;
        String sql = "Select cod_abono,valor_abono from abonos "
                + "where cod_abono = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_abono");
                data[i][1] = datos.getFloat("valor_abono");
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
      
    
    
    public Object[][] consultarAbonos(){

        Object data[][] = new Object[this.contarAbonos()][2];
        ResultSet datos = null;
        String sql = "Select * from abonos";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_abono");
                data[i][1] = datos.getFloat("valor_abono");
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public Object[][] consultarCodMaxAbonos() {
        ResultSet datos = null;
        Object data[][] = new Object[1][1];
        String sql = "select max(cod_abono) num from abonos";
        int num=0;
        datos = p.ejecutarConsulta(sql);
        try {
            while (datos.next()) {
                data[0][0] = datos.getString("num");    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
}
