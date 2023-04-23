package Everton.ufpb.br;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;

public class MenuCamisas extends JFrame {

    JLabel linha1, linha2;
    JMenuBar barraDeMenu = new JMenuBar();
    ImageIcon imagem = new ImageIcon("C:\\Estudos\\Java\\LojaDeCamisas\\src\\Everton\\ufpb\\br\\Camisa2.0.jpg");
    CamisasInterface sistemaCamisas = new SistemaCamisas();
    GravadoDeCamisas gravador = new GravadoDeCamisas();



    public MenuCamisas(){

        try {
            Collection<Camisa> CamisasParaRecuperar = gravador.recuperaCamisas();
            sistemaCamisas.setCamisa(CamisasParaRecuperar);
            for (Camisa p : CamisasParaRecuperar){
                JOptionPane.showMessageDialog(null,"marca da camisa:" + p.getNome(),"INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Problema ao recuperar camisas","ERRO",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        setTitle("Loja de Camisas");
        setSize(800,600);
        setLocation(150,150);
        setResizable(true);
        setBackground(Color.WHITE);
        linha1 = new JLabel("",JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif",Font.BOLD,24));
        linha2 = new JLabel(imagem,JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastra = new JMenu("Cadastra");
        JMenuItem menuCadastraPefume = new JMenuItem("Cadastra camisa");
        menuCadastra.add(menuCadastraPefume);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuRemoverPerfume = new JMenuItem("Pesquisar camisa");
        menuPesquisar.add(menuRemoverPerfume);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuPesquisarPerfume = new JMenuItem("Remover camisa");
        menuRemover.add(menuPesquisarPerfume);
        JMenu menuSalva = new JMenu("Salva");
        JMenuItem menuSalvaPerfume = new JMenuItem("Salva camisas");
        menuSalva.add(menuSalvaPerfume);
        menuPesquisarPerfume.addActionListener(
                new CamisasRemoverController(sistemaCamisas, this));
        menuRemoverPerfume.addActionListener(
                new CamisasSearchController(sistemaCamisas,this));
        menuCadastraPefume.addActionListener(
                new CamisasAddController(sistemaCamisas,this));
        menuSalvaPerfume.addActionListener((ae)->{
            try{
                gravador.gravaPerfume(sistemaCamisas.getCamisa());
                JOptionPane.showMessageDialog(this,"camisa foi salvo","INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }catch (IOException e) {
                JOptionPane.showMessageDialog(this,"ops!sua camisa não foi salvar","ERRO",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });


        barraDeMenu.add(menuCadastra);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSalva);
        setJMenuBar(barraDeMenu);
    }

    public static void main(String []args){
        JFrame janela = new MenuCamisas();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}