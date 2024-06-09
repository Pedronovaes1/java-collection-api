package set.operacaobasica;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    //atributos
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavrasUnicas(String palavra){
       if(!palavrasUnicasSet.isEmpty()){
           if(palavrasUnicasSet.contains(palavra)){
               palavrasUnicasSet.remove(palavra);
           }else{
               System.out.println("Palavra não encontradda no conjunto!");
           }
       }else{
           throw new RuntimeException("O conjunto está vazio");
       }
    }

    public boolean verificarPalavra(String palavra){
       return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if(!palavrasUnicasSet.isEmpty()){
            System.out.println(palavrasUnicasSet);
        }else {
            System.out.println("Conjunto vazio");
        }
    }

    public static void main(String[] args) {
        //istanciando conjunto
        ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoPalavras.adicionarPalavra("Java");
        conjuntoPalavras.adicionarPalavra("Python");
        conjuntoPalavras.adicionarPalavra("JavaScript");
        conjuntoPalavras.adicionarPalavra("Python");
        conjuntoPalavras.adicionarPalavra("C++");
        conjuntoPalavras.adicionarPalavra("Ruby");

        //Exibindo
        conjuntoPalavras.exibirPalavrasUnicas();

        //remover palavras
        conjuntoPalavras.removerPalavrasUnicas("Python");
        conjuntoPalavras.exibirPalavrasUnicas();

        //remover linguagem inexistente
        System.out.println("remover linguagem inexistente");
        conjuntoPalavras.removerPalavrasUnicas("Swift");

        //verificando se linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoPalavras.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoPalavras.verificarPalavra("Python"));

        conjuntoPalavras.exibirPalavrasUnicas();
    }
}
