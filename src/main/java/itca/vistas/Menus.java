package itca.vistas;

import itca.dao.*;
import java.awt.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Menus extends javax.swing.JFrame {
    
    private Connection connection;
    private UsuarioDAO usuarioDAO;
    private PlatilloDAO platilloDAO;
    private PerfilDAO perfilDAO;
    private PedidoDAO pedidoDAO;
    private MenuDAO menuDAO;
    private DetallePedidoDAO detallePedidoDAO;
    private ClienteDAO clienteDAO;
    

    
    private Usuario user;
    

    
    public Menus(Usuario _user) {
        initializeConnection();
        initializeDAOs();

        initComponents();
        this.user = _user;

        customComponents();
        setLocationRelativeTo(null);
        

    }
        
     private void initializeDAOs() {
        this.usuarioDAO = new UsuarioDAO(connection);
        this.platilloDAO = new PlatilloDAO(connection);
        this.perfilDAO = new PerfilDAO(connection);
        this.pedidoDAO = new PedidoDAO(connection);
        this.menuDAO = new MenuDAO(connection);
        this.detallePedidoDAO = new DetallePedidoDAO(connection);
        this.clienteDAO =  new ClienteDAO(connection);
        
    }
    
    private void initializeConnection() {
        try {
            connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void dispose() {
        super.dispose();
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private DefaultTableModel getTableMenus(){
        
        List<Menu> menus = this.menuDAO.findAll();
        
        return TableModelUtil.createTableModel(menus);
    }
    
    private void customComponents(){
        
               
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResult = new javax.swing.JTable();
        refresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BG_Panel.setBackground(new java.awt.Color(255, 255, 255));
        BG_Panel.setPreferredSize(new java.awt.Dimension(817, 450));
        BG_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gestionar Menus");
        BG_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 440, -1));

        logOut.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 50, 50));
        logOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logOut.setText("LogOut");
        logOut.setToolTipText("");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        BG_Panel.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 70, 20));

        jPanel1.setBackground(new java.awt.Color(250, 50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        BG_Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 450));

        tablaResult.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tablaResult.setModel(getTableMenus());
        jScrollPane1.setViewportView(tablaResult);

        BG_Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 420, 330));

        refresh.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 50, 50));
        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setText("Refresh");
        refresh.setToolTipText("");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        BG_Panel.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 70, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BG_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        
        tablaResult.setModel(getTableMenus());
    }//GEN-LAST:event_refreshMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_Panel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel refresh;
    private javax.swing.JTable tablaResult;
    // End of variables declaration//GEN-END:variables
}
