package itca.vistas;

import itca.dao.*;
import java.awt.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class mainMenu extends javax.swing.JFrame {
    
    private Connection connection;
    private UsuarioDAO usuarioDAO;
    private PlatilloDAO platilloDAO;
    private PerfilDAO perfilDAO;
    private PedidoDAO pedidoDAO;
    private MenuDAO menuDAO;
    private DetallePedidoDAO detallePedidoDAO;
    private ClienteDAO clienteDAO;
    
    private Usuario user;
    

    
    public mainMenu(Usuario _user) {
        initComponents();
        this.user = _user;

        initializeConnection();
        initializeDAOs();
        customComponents();
        setLocationRelativeTo(null);
        

    }
        
     private void initializeDAOs() {
        usuarioDAO = new UsuarioDAO(connection);
        platilloDAO = new PlatilloDAO(connection);
        perfilDAO = new PerfilDAO(connection);
        pedidoDAO = new PedidoDAO(connection);
        menuDAO = new MenuDAO(connection);
        detallePedidoDAO = new DetallePedidoDAO(connection);
        clienteDAO =  new ClienteDAO(connection);
        
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
    
    private void customComponents(){
        
        if(this.user.getIdPerfil() != 1){
            btnClientes.setVisible(false);
            btnUsuarios.setVisible(false);
        }
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Panel = new javax.swing.JPanel();
        btnPedidos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnPlatillos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnMenus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();

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

        btnPedidos.setBackground(new java.awt.Color(255, 50, 50));
        btnPedidos.setToolTipText("");
        btnPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPedidosMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pedidos");

        javax.swing.GroupLayout btnPedidosLayout = new javax.swing.GroupLayout(btnPedidos);
        btnPedidos.setLayout(btnPedidosLayout);
        btnPedidosLayout.setHorizontalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPedidosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        btnPedidosLayout.setVerticalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        BG_Panel.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 190, 60));

        btnUsuarios.setBackground(new java.awt.Color(255, 50, 50));
        btnUsuarios.setToolTipText("");
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuarios");

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        BG_Panel.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 190, 60));

        btnPlatillos.setBackground(new java.awt.Color(255, 50, 50));
        btnPlatillos.setToolTipText("");
        btnPlatillos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlatillosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlatillosMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Platillos");

        javax.swing.GroupLayout btnPlatillosLayout = new javax.swing.GroupLayout(btnPlatillos);
        btnPlatillos.setLayout(btnPlatillosLayout);
        btnPlatillosLayout.setHorizontalGroup(
            btnPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPlatillosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        btnPlatillosLayout.setVerticalGroup(
            btnPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPlatillosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        BG_Panel.add(btnPlatillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 190, 60));

        btnMenus.setBackground(new java.awt.Color(255, 50, 50));
        btnMenus.setToolTipText("");
        btnMenus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenusMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menus");

        javax.swing.GroupLayout btnMenusLayout = new javax.swing.GroupLayout(btnMenus);
        btnMenus.setLayout(btnMenusLayout);
        btnMenusLayout.setHorizontalGroup(
            btnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMenusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        btnMenusLayout.setVerticalGroup(
            btnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        BG_Panel.add(btnMenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 60));

        btnClientes.setBackground(new java.awt.Color(255, 50, 50));
        btnClientes.setToolTipText("");
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clientes");

        javax.swing.GroupLayout btnClientesLayout = new javax.swing.GroupLayout(btnClientes);
        btnClientes.setLayout(btnClientesLayout);
        btnClientesLayout.setHorizontalGroup(
            btnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        btnClientesLayout.setVerticalGroup(
            btnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        BG_Panel.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 190, 60));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Que desea gestionar?");
        BG_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

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
        BG_Panel.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 70, 20));

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

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        btnClientes.setBackground(new Color(255,50,50));
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        btnClientes.setBackground(new Color(240,40,40));
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnMenusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenusMouseExited
        btnMenus.setBackground(new Color(255,50,50));
    }//GEN-LAST:event_btnMenusMouseExited

    private void btnMenusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenusMouseEntered
        btnMenus.setBackground(new Color(240,40,40));
    }//GEN-LAST:event_btnMenusMouseEntered

    private void btnPlatillosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlatillosMouseExited
        btnPlatillos.setBackground(new Color(255,50,50));
    }//GEN-LAST:event_btnPlatillosMouseExited

    private void btnPlatillosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlatillosMouseEntered

        btnPlatillos.setBackground(new Color(240,40,40));
    }//GEN-LAST:event_btnPlatillosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(new Color(255,50,50));
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(new Color(240,40,40));
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutMouseClicked

    private void btnPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseExited
        btnPedidos.setBackground(new Color(255,50,50));
    }//GEN-LAST:event_btnPedidosMouseExited

    private void btnPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseEntered
        btnPedidos.setBackground(new Color(240,40,40));
    }//GEN-LAST:event_btnPedidosMouseEntered

    private void btnMenusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenusMouseClicked
        new Menus(this.user).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenusMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_Panel;
    private javax.swing.JPanel btnClientes;
    private javax.swing.JPanel btnMenus;
    private javax.swing.JPanel btnPedidos;
    private javax.swing.JPanel btnPlatillos;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel logOut;
    // End of variables declaration//GEN-END:variables
}
