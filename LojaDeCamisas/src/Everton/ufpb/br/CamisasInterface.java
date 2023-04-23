package Everton.ufpb.br;


import java.util.Collection;

public interface CamisasInterface {

    public  boolean cadastraCamisas(String nome, String codigo , int quantidade);
    public Collection<Camisa> pesquisaCamisas(String nome, String codigo);
    public boolean removecamisa(String codigo);
    public Collection<Camisa> getCamisa ();
    public void setCamisa(Collection<Camisa> Camisas);
}