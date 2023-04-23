package Everton.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CamisasRemoverController implements ActionListener {
    private CamisasInterface sistema;
    private JFrame JanelaPrincial;

    public CamisasRemoverController(CamisasInterface sistema, JFrame janelaPrincial){
        this.sistema = sistema;
        this.JanelaPrincial = janelaPrincial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog("Qual é o codigo da camisa");

        boolean remover = sistema.removecamisa(codigo);
        if (remover){
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "camisa removido ");
        }else {
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "Camisa não foi encontrado." +
                            "Operação não realizada","Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}