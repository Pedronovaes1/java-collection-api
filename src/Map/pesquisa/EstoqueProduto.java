package Map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {
    //atributo
    private Map<Long,Produto> estoqueProdutosMap;

    public EstoqueProduto() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionaProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome,preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calculaValorTotalEstoque(){
        double total = 0;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto produto: estoqueProdutosMap.values()){
                total += produto.getPreco() * produto.getQuantidade();
            }
        }else{
            throw new RuntimeException("O map está vazio");
        }
        return total;
    }

    public Produto coletatProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MAX_VALUE;

        if(!estoqueProdutosMap.isEmpty()){
            for(Produto produto: estoqueProdutosMap.values()){
                if(produto.getPreco() > maiorPreco){
                    produtoMaisCaro = produto;
                }
            }
        }else{
            throw new RuntimeException("O map está vazio");
        }
        return produtoMaisCaro;
    }

}
