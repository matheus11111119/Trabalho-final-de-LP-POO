package Telas;

import metodos.Item;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaProdutos {

    public JPanel framevendas;

    public JSpinner quantAtum;
    public JSpinner quantTainha;
    public JSpinner quantBacalhau;
    public JSpinner quantSalmao;
    public JSpinner quantLinguado;

    public JPanel item1;
    public JPanel item2;
    public JPanel item3;
    public JPanel item4;
    public JPanel item5;
    public JPanel item6;

    public JLabel img2;
    public JLabel img3;
    public JLabel img4;
    public JLabel img5;
    public JLabel img6;

    public JButton addcarrinhoButton;

    public JCheckBox AtumBox;
    private JCheckBox TainhaBox;
    private JCheckBox BacalhauBox;
    private JCheckBox Salmaobox;
    private JCheckBox LinguadoBox;
    private JCheckBox CavalaBox;

    private JSpinner quantCavala;

    private JButton carrinhoButton;
    public JButton sairButton;

    private final ArrayList<Item> itensCarrinho = new ArrayList<>();

    public TelaProdutos() {

        carrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaOutraTela();
            }
        });

        addcarrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarItens();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framevendas.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    private void salvarItens() {
        if (AtumBox.isSelected()) {
            itensCarrinho.add(new Item("Atum", 39, (Integer) quantAtum.getValue()));
        }
        if (TainhaBox.isSelected()) {
            itensCarrinho.add(new Item("Tainha", 25, (Integer) quantTainha.getValue()));
        }
        if (BacalhauBox.isSelected()) {
            itensCarrinho.add(new Item("Bacalhau", 319, (Integer) quantCavala.getValue()));
        }
        if (Salmaobox.isSelected()) {
            itensCarrinho.add(new Item("Salmão", 396, (Integer) quantSalmao.getValue()));
        }
        if (LinguadoBox.isSelected()) {
            itensCarrinho.add(new Item("Linguado", 43, (Integer) quantBacalhau.getValue()));
        }
        if (CavalaBox.isSelected()) {
            itensCarrinho.add(new Item("Cavala", 24, (Integer) quantLinguado.getValue()));
        }
        mostrarResumoCarrinho();
    }

    private void mostrarResumoCarrinho() {
        StringBuilder resumo = new StringBuilder();
        double valorTotal = 0;

        for (Item item : itensCarrinho) {
            resumo.append(item.getQuantidade())
                    .append("x ")
                    .append(item.getNome())
                    .append(": R$")
                    .append(item.getValor() * item.getQuantidade())
                    .append("\n");
            valorTotal += item.getValor() * item.getQuantidade();
        }

        resumo.append("Valor total: R$").append(valorTotal);

        int confirm = JOptionPane.showConfirmDialog(null, resumo.toString(), "Confirmar Carrinho", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            irParaOutraTela();
        }
    }
    private void irParaOutraTela(){
        TelaCarrinho telaCarrinho = new TelaCarrinho(itensCarrinho);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(framevendas);
        frame.setContentPane(telaCarrinho.panelCarrinho);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,550);
        frame.revalidate();
        frame.repaint();
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vendas");
        frame.setContentPane(new TelaProdutos().framevendas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1300,950);
    }
}