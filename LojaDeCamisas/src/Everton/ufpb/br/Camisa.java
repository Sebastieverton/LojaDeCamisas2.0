package Everton.ufpb.br;


import java.io.Serializable;
import java.util.Objects;

public class Camisa implements Serializable {
    private String nome;
    private String codigo;
    private  int quantidade;

    public Camisa(String nome, String codigo, int quantidade){
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camisa camisa)) return false;
        return quantidade == camisa.quantidade && Objects.equals(nome, camisa.nome) && Objects.equals(codigo, camisa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  "\n nome= " + nome + "\n codigo= " + codigo + "\n quantidade= " + quantidade ;
    }


}