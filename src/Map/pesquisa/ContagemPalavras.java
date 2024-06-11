package Map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    //atributos
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        this.palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!palavras.isEmpty()){
            this.palavras.remove(palavra);
        }else{
            throw new RuntimeException("O map está vazio");
        }
    }

    public int exibirContagemPalvras(){
        int contagemTotal = 0;
        if(!palavras.isEmpty()){
            for(Map.Entry<String, Integer> palavra : this.palavras.entrySet()){
                contagemTotal += palavra.getValue();
            }
        }else{
            throw new RuntimeException("O map está vazio");
        }

        return contagemTotal;
    }


}
