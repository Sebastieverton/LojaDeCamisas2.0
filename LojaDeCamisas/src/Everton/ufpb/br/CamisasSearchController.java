package Everton.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CamisasSearchController implements ActionListener {

    private CamisasInterface sistema;
    private JFrame JanelaPrincipal;

    public CamisasSearchController(CamisasInterface sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.JanelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(null,"Qual a marca da camisa ?","PERGUNTA",JOptionPane.QUESTION_MESSAGE);
        String codigo = JOptionPane.showInputDialog(null,"Qual o codigo da camisa?","PERGUNTA",JOptionPane.QUESTION_MESSAGE);
        Collection<Camisa> Pesquisar = sistema.pesquisaCamisas(nome,codigo);
        if (Pesquisar.size()>0){
            JOptionPane.showMessageDialog(JanelaPrincipal,
                    "Camisa encontrado");
            for (Camisa p : Pesquisar){
                JOptionPane.showMessageDialog(JanelaPrincipal, p.toString(),"INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(JanelaPrincipal,
                    "Camisa não encontrado","ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
}