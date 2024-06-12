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

    public int exibirContagemPalavras(){
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

    public String encontrarPalavrasMaisFrequente(){
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        for(Map.Entry<String, Integer> palavra : this.palavras.entrySet()){
            if(palavra.getValue() > maiorContagem){
                maiorContagem = palavra.getValue();
                palavraMaisFrequente = palavra.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavrasMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }


}
