package Everton.ufpb.br;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaCamisas implements CamisasInterface {

    private Map<String, Camisa> CamisaMap;

    public SistemaCamisas(){

        this.CamisaMap = new HashMap<>();
    }


    @Override
    public boolean cadastraCamisas(String nome, String codigo, int quatindadeDeCamisas) {
        if (!this.CamisaMap.containsKey(codigo)){
            this.CamisaMap.put(codigo, new Camisa (nome, codigo, quatindadeDeCamisas));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Collection<Camisa> pesquisaCamisas(String nome, String codigo) {
        Collection<Camisa> Camisas = new ArrayList<>();
        for (Camisa p : this.CamisaMap.values()){
            if (p.getNome().equals(nome) && p.getCodigo().equals(codigo)){
                Camisas.add(p);
            }

        }
        return Camisas;
    }

    @Override
    public boolean removecamisa(String codigo){
        if (this.CamisaMap.containsKey(codigo)){
            this.CamisaMap.remove(codigo);
            return true;
        }else {
            return false;
        }
    }
    public Collection<Camisa> getCamisa(){
        return this.CamisaMap.values();
    }
    public void setCamisa(Collection<Camisa> camisas) {
        for (Camisa p : camisas) {
            this.CamisaMap.put(p.getCodigo(), p);
        }
    }
}