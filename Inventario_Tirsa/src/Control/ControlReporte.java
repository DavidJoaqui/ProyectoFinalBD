/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ConexionBD;
import Modelo.Persistencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidJP
 */
public class ControlReporte {

    Connection con = null;
    ConexionBD cBD;
    Persistencia p = new Persistencia();

    public Object[][] Consultar_facturas_reporte_diario(String fecha_inicial) {
        Object data[][] = new Object[this.contar_facturas_reporte(fecha_inicial)][5];
        ResultSet datos = null;
        String sql = "select cod_factura,valor_factura,fecha_factura,nombres_persona,apellidos_persona,cod_empleado from factura join persona where fecha_factura='" + fecha_inicial + "' and factura.cod_cliente=persona.cod_persona;";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getDate("fecha_factura");
                data[i][3] = datos.getString("nombres_persona") + " " + datos.getString("apellidos_persona");
                data[i][4] = datos.getInt("cod_empleado");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] Consultar_Facturas_Reporte(String fecha_inicial, String fecha_final) {
        Object[][] data = new Object[this.contar_facturas_reporte(fecha_inicial, fecha_final)][5];
        cBD = new ConexionBD();
        try {
            ResultSet datos = null;
            String sql = "select cod_factura,valor_factura,fecha_factura,nombres_persona,apellidos_persona,cod_empleado from factura join persona where fecha_factura BETWEEN '" + fecha_inicial + "' and '" + fecha_final + "'and factura.cod_cliente=persona.cod_persona;";
            datos = p.ejecutarConsulta(sql);
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getDate("fecha_factura");
                data[i][3] = datos.getString("nombres_persona") + " " + datos.getString("apellidos_persona");
                data[i][4] = datos.getInt("cod_empleado");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public float obtener_promedio(String fecha_inicial,String fecha_final) {
        float promedio = 0;
         cBD = new ConexionBD();

        try {
            PreparedStatement ps = cBD.getConnection().prepareStatement("select promedio_intervalo_fechas(?,?);");
            ps.setString(1,fecha_inicial);
             ps.setString(2, fecha_final);
            ResultSet rs = ps.executeQuery();
            rs.next();
            promedio = rs.getFloat(1);

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promedio;
    }
     public float obtener_promedio(String fecha) {
        float promedio = 0;
         cBD = new ConexionBD();

        try {
            PreparedStatement ps = cBD.getConnection().prepareStatement("select promedio_fecha_unitaria(?);");
            ps.setString(1,fecha);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            promedio = rs.getFloat(1);

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promedio;
    }

    public int contar_facturas_reporte(String fecha_inicial, String fecha_final) {
        int num_fac = 0;
        ResultSet datos = null;
        String sql = "select count(cod_factura) from factura where fecha_factura BETWEEN '" + fecha_inicial + "' and '" + fecha_final + "';";
        datos = p.ejecutarConsulta(sql);
        try {

            while (datos.next()) {
                num_fac = datos.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num_fac;
    }

    public int contar_facturas_reporte(String fecha_inicial) {
        int num_fac = 0;
        ResultSet datos = null;
        String sql = "select count(cod_factura) from factura where fecha_factura='" + fecha_inicial + "';";
        datos = p.ejecutarConsulta(sql);
        try {

            while (datos.next()) {
                num_fac = datos.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num_fac;
    }

    public Object[][] total_facturas(String fecha_inicial, String fecha_final) {
        int num = 0;
        float total = 0;
        cBD = new ConexionBD();
        Object data[][] = null;
        try {
            CallableStatement cst = null;
            con = cBD.getConnection();
            cst = con.prepareCall("{call Reporte_Fechas_Intervalo(?,?,?,?)}");
            cst.setString(1, fecha_inicial);
            cst.setString(2, fecha_final);
            cst.executeQuery();
            num = cst.getInt("total");
            total = cst.getFloat("sum_total_facturas");
            if (num != 0 && total != 0) {
                data = new Object[1][2];
                data[0][0] = num;
                data[0][1] = total;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public Object[][] total_facturas(String fecha) {
        int num = 0;
        float total = 0;
        Object data[][] = null;
         cBD = new ConexionBD();
        try {
            CallableStatement cst = null;
            con = cBD.getConnection();
            cst = con.prepareCall("{call Reporte_Fecha_unitaria(?,?,?)}");
            cst.setString(1, fecha);

            cst.executeQuery();

            total = cst.getFloat("total");
            num = cst.getInt("num_fac");

            if (num != 0 && total != 0) {
                data = new Object[1][2];
                data[0][0] = num;
                data[0][1] = total;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public float total_facturas() {

        float total = 0;
        cBD = new ConexionBD();

        try {
            PreparedStatement ps = cBD.getConnection().prepareStatement("select total_ventas_en_facturas();");

            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getFloat(1);

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }
}
