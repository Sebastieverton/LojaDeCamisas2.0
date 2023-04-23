package Everton.ufpb.br;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadoDeCamisas {

    private String arquivosDasCamisas;
    public GravadoDeCamisas(){
        this.arquivosDasCamisas = "C:\\Estudos\\Java\\LojaDeCamisas\\src\\Everton\\ufpb\\br\\CamisasSalvas\\CamisasSalvas.txt";
    }
    public GravadoDeCamisas(String arquivosdecamisas ){
        this.arquivosDasCamisas = arquivosdecamisas;
    }

    public void gravaPerfume(Collection<Camisa> Camisas1) throws IOException{
        try(ObjectOutputStream gravador= new ObjectOutputStream(new FileOutputStream(this.arquivosDasCamisas))){
            ArrayList<Camisa> CamisasNovas = new ArrayList<>(Camisas1);
            gravador.writeObject(CamisasNovas);

        }
    }

    public Collection<Camisa> recuperaCamisas() throws IOException {
        try (ObjectInputStream gravador= new ObjectInputStream(new FileInputStream(arquivosDasCamisas))){
            ArrayList<Camisa> CamisasRecuperados = (ArrayList<Camisa>) gravador.readObject();
            return CamisasRecuperados;
        }catch (ClassNotFoundException e){
            throw  new IOException(e);
        }


    }

}