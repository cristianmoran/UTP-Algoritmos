/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import View.Formularios.Vista;

/**
 *
 * @author USUARIO
 */
public class Controlador implements ActionListener{
    
    EmpleadoDAO dao = new EmpleadoDAO();
    Empleado m = new Empleado();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public Controlador(Vista v){
        this.vista=v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        listar(vista.tabla);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListar){
            limpiarTabla();
            listar(vista.tabla);
        }
        
        if(e.getSource()==vista.btnModificar){
            Actualizar();
            limpiarTabla();
            listar(vista.tabla);
        }
        
        if(e.getSource()==vista.btnEliminar){
            int fila=vista.tabla.getSelectedRow();
            String codigo = (String)vista.tabla.getValueAt(fila, 0);
            if(fila==-1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
                
            }else{
                dao.Eliminar(codigo);
                JOptionPane.showMessageDialog(vista,"Usuario eliminado");
            }
        }
    }
    
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<Empleado>lista=dao.listar();
        Object[]object=new Object[6];
        for(int i=0; i< lista.size(); i++){
            object[0]=lista.get(i).getCodigo();
            object[1]=lista.get(i).getDocumento();
            object[2]=lista.get(i).getApellido();
            object[3]=lista.get(i).getNombre();
            object[4]=lista.get(i).getStatus();
            object[5]=lista.get(i).getRol();
            modelo.addRow(object);
            
        }
        vista.tabla.setModel(modelo);
        
    }
    void limpiarTabla(){
        for(int i=0; i<vista.tabla.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    public void Actualizar(){
        String codigo= vista.txtCodigo.getText();
        String documento=vista.txtCedula.getText();
        String apellido= vista.txtApellido.getText();
        String nombre= vista.txtNombre.getText();
        m.setCodigo(codigo);
        m.setDocumento(documento);
        m.setNombre(nombre);
        m.setApellido(apellido);
        
        int r=dao.Actualizar(m);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Usuario actualizado con exito");
        }else{
            JOptionPane.showMessageDialog(vista, "Error");
         
        }
    }
}
