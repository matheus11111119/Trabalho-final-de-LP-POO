package Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TelaLogin {

    public JPanel telalogin;
    public JButton entrarButton;
    public JTextField nomeTextField;
    public JPasswordField senhaPasswordField;
    public JButton sairButton;
    public JButton buttoncadastrar;


    public TelaLogin() {
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttoncadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cadastro cadastro = new Cadastro();
                JFrame frame = new JFrame("Cadastro");
                frame.setContentPane(cadastro.cadastroframe);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(true);
                frame.setSize(900, 900);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

            entrarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String usuario = nomeTextField.getText();
                    char[] senha = senhaPasswordField.getPassword();
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pinguinando", "root", "06170710");
                        PreparedStatement pst = connection.prepareStatement("SELECT * FROM dados_senhas WHERE usuario=? AND senha=?");
                        pst.setString(1, usuario);
                        pst.setString(2, new String(senha));
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            TelaProdutos telaVendas = new TelaProdutos();
                            JFrame frame = new JFrame("Tela de Vendas");
                            frame.setContentPane(telaVendas.framevendas);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.pack();
                            frame.setResizable(true);
                            frame.setSize(1200, 1000);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                        }
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
    }
}
