package itca.vistas;

import itca.dao.*;
import java.awt.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {
    
    private Connection connection;
    private UsuarioDAO usuarioDAO;
    private PlatilloDAO platilloDAO;
    private PerfilDAO perfilDAO;
    private PedidoDAO pedidoDAO;
    private MenuDAO menuDAO;
    private DetallePedidoDAO detallePedidoDAO;
    private ClienteDAO clienteDAO;
    

    
    public Login() {
        initComponents();
        initializeConnection();
        initializeDAOs();
        customComponents();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

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
        
        
        
        URL imageUrl = getClass().getResource("/assets/pedidosYa.png");
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            Logo.setIcon(icon); 
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Panel = new javax.swing.JPanel();
        BG_Red = new javax.swing.JPanel();
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        botonEntrar = new javax.swing.JPanel();
        labelBotonEntrar = new javax.swing.JLabel();
        passInput = new javax.swing.JPasswordField();
        usuarioInput = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BG_Panel.setBackground(new java.awt.Color(255, 255, 255));
        BG_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BG_Red.setBackground(new java.awt.Color(255, 50, 50));
        BG_Red.setForeground(new java.awt.Color(255, 255, 255));

        labelUser.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        labelUser.setForeground(new java.awt.Color(255, 255, 255));
        labelUser.setText("Usuario:");
        labelUser.setToolTipText("");

        labelPass.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        labelPass.setForeground(new java.awt.Color(255, 255, 255));
        labelPass.setText("Contraseña:");
        labelPass.setToolTipText("");

        botonEntrar.setBackground(new java.awt.Color(255, 255, 255));
        botonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEntrarMouseExited(evt);
            }
        });

        labelBotonEntrar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        labelBotonEntrar.setForeground(new java.awt.Color(255, 51, 51));
        labelBotonEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBotonEntrar.setText("Ingresar");

        javax.swing.GroupLayout botonEntrarLayout = new javax.swing.GroupLayout(botonEntrar);
        botonEntrar.setLayout(botonEntrarLayout);
        botonEntrarLayout.setHorizontalGroup(
            botonEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBotonEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        botonEntrarLayout.setVerticalGroup(
            botonEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBotonEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        passInput.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        passInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passInput.setText("password");
        passInput.setBorder(null);
        passInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passInputMousePressed(evt);
            }
        });

        usuarioInput.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        usuarioInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioInput.setText("Usuario");
        usuarioInput.setBorder(null);
        usuarioInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioInputMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BG_RedLayout = new javax.swing.GroupLayout(BG_Red);
        BG_Red.setLayout(BG_RedLayout);
        BG_RedLayout.setHorizontalGroup(
            BG_RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_RedLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(BG_RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPass)
                    .addComponent(labelUser)
                    .addComponent(passInput)
                    .addComponent(botonEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarioInput))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        BG_RedLayout.setVerticalGroup(
            BG_RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_RedLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(labelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(botonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        BG_Panel.add(BG_Red, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 450));
        BG_Panel.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, -4, 380, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseClicked
        String user,password;
        
        user = usuarioInput.getText();
        char[] passchar = passInput.getPassword();
        password = new String(passchar);
        
        
            
        Usuario respuestaUser = usuarioDAO.findByUser(user);
               
        if(respuestaUser == null){
            new ErrorLogin("Usuario no encontrado").setVisible(true);
            return;
        }
                
        if(respuestaUser.getClave().equals(password)){
            System.out.println("Tienes Acceso");
            new mainMenu(respuestaUser).setVisible(true);
            dispose();
        }else{
            System.out.println("No tienes acceso");
            new ErrorLogin("Contraseña incorrecta").setVisible(true);
            return;
        }
        
    }//GEN-LAST:event_botonEntrarMouseClicked

    private void passInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passInputMousePressed
        
        passInput.setText("");

    }//GEN-LAST:event_passInputMousePressed

    private void usuarioInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioInputMousePressed
       
        usuarioInput.setText("");

    }//GEN-LAST:event_usuarioInputMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void botonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseEntered
        botonEntrar.setBackground(new Color(245,245,245));
        
    }//GEN-LAST:event_botonEntrarMouseEntered

    private void botonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseExited

        botonEntrar.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_botonEntrarMouseExited


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_Panel;
    private javax.swing.JPanel BG_Red;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel botonEntrar;
    private javax.swing.JLabel labelBotonEntrar;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPasswordField passInput;
    private javax.swing.JTextField usuarioInput;
    // End of variables declaration//GEN-END:variables
}
