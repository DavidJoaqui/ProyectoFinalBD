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
//prueba 
//editado por david 
public class ControlFactura {

    Persistencia p = new Persistencia();

    public boolean insertarFactura(int codigoFactura, float valorFactura, String fechaFactura, int codigoCliente,
            int codigoEmpleado) {

        boolean inserto = false;
        String sql = "Insert into factura (cod_factura, valor_factura, fecha_factura, cod_cliente, cod_empleado) "
                + "values (" + codigoFactura + ", " + valorFactura + ", '" + fechaFactura + "', " + codigoCliente + ", " + codigoEmpleado + ")";
        inserto = p.ejecutarDML(sql);
        return inserto;
    }

    public boolean actualizarFactura(int codigoFactura, float valorFactura, String fechaFactura, int codigoCliente,
            int codigoEmpleado) {
        boolean actualizo = false;
        String sql = "Update factura set "
                + "valor_factura = " + valorFactura
                + ", fecha_factura = '" + valorFactura
                + ", cod_cliente = " + codigoCliente
                + ", cod_empleado = " + codigoCliente
                + " where cod_factura = " + codigoFactura;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }

    public int contarFacturas() {

        int numero = 0;
        String sql = "Select count(cod_factura) num from factura";
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

    public Object[][] consultarFactura(int codigo) {

        Object data[][] = new Object[this.contarFacturas()][5];
        ResultSet datos = null;
        String sql = "Select cod_factura, valor_factura, fecha_factura, cod_cliente, cod_empleado"
                + " from factura where cod_factura = " + codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getString("fecha_factura");
                data[i][3] = datos.getInt("cod_cliente");
                data[i][4] = datos.getInt("cod_empleado");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarFacturas() {

        Object data[][] = new Object[this.contarFacturas()][5];
        ResultSet datos = null;
        String sql = "Select * from factura";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getString("fecha_factura");
                data[i][3] = datos.getInt("cod_cliente");
                data[i][4] = datos.getInt("cod_empleado");              
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarCodMaxFactura() {
        ResultSet datos = null;
        Object data[][] = new Object[1][1];
        String sql = "select max(cod_factura) num from factura";
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

    public Object[][] consultarFacturaAbonos(int codCliente) {

        Object data[][] = new Object[this.contarFacturasAbonos(codCliente)][5];
        ResultSet datos = null;
        String sql = "Select f.cod_factura, f.valor_factura, f.fecha_factura, p.nombres_persona, t1.sum_abono\n" +
                        "FROM inventario.factura f inner join persona p \n" +
                        "on (p.cod_persona=f.cod_empleado)\n" +
                        "left join (select cod_factura, sum(a.valor_abono) sum_abono from abonos a group by a.cod_factura)t1\n" +
                        "on (t1.cod_factura=f.cod_factura)\n" +
                        "where cod_cliente=" + codCliente;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getString("fecha_factura");
                data[i][3] = datos.getString("nombres_persona");
                data[i][4] = datos.getString("sum_abono");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public int contarFacturasAbonos(int codCliente) {

        int numero = 0;
        String sql = "Select count(cod_factura) num from factura"
                + " where cod_cliente=" + codCliente;
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
}
