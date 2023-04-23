package Everton.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CamisasAddController implements ActionListener {

    private CamisasInterface sistema;
    private JFrame JanelaPrincial;

    public CamisasAddController(CamisasInterface sistema, JFrame janelaPrincial){
        this.sistema = sistema;
        this.JanelaPrincial = janelaPrincial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Qual a marca da sua camisa?");
        String codigo = JOptionPane.showInputDialog("Qual o codigo de barras da sua camisa");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Coloque a quantidade"));
        boolean cadastrou = this.sistema.cadastraCamisas(nome,codigo,quantidade);
        if (cadastrou){
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "Camisa foi colocada no estoque.","INFORMAÇÃO",JOptionPane.INFORMATION_MESSAGE);

        }else {
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "Nao foi encontrado sua camisa no estoque." +
                            "Verifique se já colocou no estoque","Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}