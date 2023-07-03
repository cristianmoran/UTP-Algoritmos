/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class EmpleadoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Empleado>datos= new ArrayList<>();
        String sql= "select * from employee";
        try {
            con = conectar.getConnection();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Empleado e= new Empleado();
                e.setCodigo(rs.getString(1));
                e.setDocumento(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setNombre(rs.getString(4));
                e.setStatus(rs.getInt(5));
                e.setRol(rs.getString(6));
                datos.add(e);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    
   public int Actualizar(Empleado m) {
    int r = 0;
    String sql = "update employee set documento=?, apellido=?, nombre=? where codigo=?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, m.getDocumento());
        ps.setString(2, m.getApellido());
        ps.setString(3, m.getNombre());
        ps.setString(4, m.getCodigo());
        r = ps.executeUpdate();
        if (r == 1) {
            return 1;
        } else {
            return 0;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return r;
}

   public void Eliminar(String codigo){
       String sql= "delete from employee where codigo="+codigo;
       try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
       } catch (Exception e) {
       }
   }
}
























