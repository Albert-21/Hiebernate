/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiebernate.Vista;


import hiebernate.Empleados;
import hiebernate.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Luis Alberto
 */
public class TablaEmpleados extends javax.swing.JInternalFrame {

    private static TablaEmpleados tablPer = null;
    private Empleados emp = new Empleados();
    private DefaultTableModel modelo;

    public static TablaEmpleados getInstace() {
        if (tablPer == null) {
            tablPer = new TablaEmpleados();
            return tablPer;
        }
        return tablPer;
    }

    /**
     * Creates new form TablaPersonas
     */
    public TablaEmpleados() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ItenMostrarUno = new javax.swing.JMenuItem();
        itenMostrarTodos = new javax.swing.JMenuItem();

        setClosable(true);
        setTitle("Tabla Personas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Mostrar");

        ItenMostrarUno.setText("Mostrar Uno");
        ItenMostrarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItenMostrarUnoActionPerformed(evt);
            }
        });
        jMenu1.add(ItenMostrarUno);

        itenMostrarTodos.setText("Mostrar Todos");
        itenMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itenMostrarTodosActionPerformed(evt);
            }
        });
        jMenu1.add(itenMostrarTodos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItenMostrarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItenMostrarUnoActionPerformed
        // TODO add your handling code here:
        emp.setId(JOptionPane.showInputDialog("Ingrese la clave"));
        MostrarUno(emp, modelo);


    }//GEN-LAST:event_ItenMostrarUnoActionPerformed

    private void itenMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itenMostrarTodosActionPerformed
        // TODO add your handling code here:
        MostrarTodos(modelo);
    }//GEN-LAST:event_itenMostrarTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItenMostrarUno;
    private javax.swing.JMenuItem itenMostrarTodos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel MostrarTodos(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT em FROM Empleados em");
        List<Empleados> empleados = query.list();
        
        for (Empleados empleado : empleados) {
            modelo.addRow(new Object[]{empleado.getId(), empleado.getNombre(), empleado.getApellidos(), empleado.getDireccion(), empleado.getTelefono()});
        }
        

        return modelo;
    }

    private DefaultTableModel MostrarUno(Empleados emp, DefaultTableModel modelo) {
        modelo.setRowCount(0);
       Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT em FROM Empleados em WHERE id = '"+emp.getId()+"'");
        List<Empleados> empleados = query.list();
        
        for (Empleados empleado : empleados) {
            modelo.addRow(new Object[]{empleado.getId(), empleado.getNombre(), empleado.getApellidos(), empleado.getDireccion(), empleado.getTelefono()});
        }
        

        return modelo;
    }

}
