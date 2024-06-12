package Map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    //atributos
    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro){
        livros.put(link, livro);
    }

    public void removerLivro(String titulo){
        List<String>  chavesParaRemover = new ArrayList<>();
        if(!livros.isEmpty()){
            for(Map.Entry<String, Livro> livro : livros.entrySet()){
                if(livro.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    chavesParaRemover.add(livro.getKey());
                }
            }
        }else{
            throw new RuntimeException("O map está vazio");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new Livro.ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> livro : livrosParaOrdenarPorPreco){
            livrosOrdenadosPorPreco.put(livro.getKey(), livro.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new Livro.ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> livros : livrosParaOrdenarPorAutor){
            livrosOrdenadosPorAutor.put(livros.getKey(), livros.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for(Map.Entry<String,Livro> entry : livros.entrySet()){
            Livro livro = entry.getValue();
            if(livro.getAuto().equals(autor)){
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro(){
        List<Livro> livroMaisCaro = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if(!livros.isEmpty()){
            for(Livro livro : livros.values()){
                if(livro.getPreco() > precoMaisAlto){
                   precoMaisAlto = livro.getPreco();
                }
            }
        }else{
            throw new RuntimeException("A livraria está vazia");
        }

        for(Map.Entry<String,Livro> livro : livros.entrySet()){
            if(livro.getValue().getPreco() == precoMaisAlto){
                Livro livroComPrecoMaisAlto = livros.get(livro.getKey());
                livroMaisCaro.add(livroComPrecoMaisAlto);
            }
        }
        return livroMaisCaro;
    }

    public List<Livro> obterLivroMaisBarato(){
        List<Livro> livrosMaisBarato = new ArrayList<>();
        double precoMaisBarato = Double.MAX_VALUE;

        if(!livros.isEmpty()){
            for(Livro livro : livros.values()){
                if(livro.getPreco() < precoMaisBarato){
                    precoMaisBarato = livro.getPreco();
                }
            }
        }else{
            throw new RuntimeException("A livraria está vazia");
        }

        for(Map.Entry<String, Livro> livro : livros.entrySet()){
            if(livro.getValue().getPreco() == precoMaisBarato){
                Livro livroComPrecoMaisBarato = livros.get(livro.getKey());
                livrosMaisBarato.add(livroComPrecoMaisBarato);
            }
        }

        return livrosMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livros);

    }
}
