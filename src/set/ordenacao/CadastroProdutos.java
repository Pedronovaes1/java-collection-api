package set.ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    //atributos
    private Set<Produtos> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long codigo, double preco, int quantidade) {
        produtosSet.add(new Produtos(nome, codigo, preco, quantidade));
    }

    public Set<Produtos> exibirProdutoPorNome(){
        Set<Produtos> produtosPorNome = new TreeSet<>(produtosSet);
        return produtosPorNome;
    }

   public Set<Produtos> exibirProdutoPorPreco(){
        Set<Produtos> produtosPorPreco = new TreeSet<>(new Produtos.ComparatorPorPrecos());
        produtosPorPreco.addAll(produtosSet);
        return produtosPorPreco;
   }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto("Smartphone", 1L, 1000d, 10);
        cadastroProdutos.adicionarProduto("Notebook", 2L, 1500d, 5);
        cadastroProdutos.adicionarProduto("Mouse", 1L, 30d, 20);
        cadastroProdutos.adicionarProduto("Teclado", 4L, 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println(cadastroProdutos.produtosSet);

        // Exibindo produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutoPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println(cadastroProdutos.exibirProdutoPorPreco());
    }
}
