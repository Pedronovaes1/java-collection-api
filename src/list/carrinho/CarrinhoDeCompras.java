package list.carrinho;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo
    private List<Item> item;

    public CarrinhoDeCompras() {
        this.item = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item itm = new Item(nome, preco, quantidade);
        this.item.add(itm);
    }

    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();

        if(!item.isEmpty()){
            for(Item item: item){
                if(item.getNome().equalsIgnoreCase(nome)){
                    itemParaRemover.add(item);
                }
            }
            item.removeAll(itemParaRemover);
        }else{
            System.out.println("A lista está vazia");
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        if (!item.isEmpty()){
            for (Item item : item) {
                double valorTotal = item.getPreco() * item.getQuantidade();
                total += valorTotal;
            }
        }else{
            throw new RuntimeException("A lista está vazia");
        }
        return total;
    }


    public void exibirItens(){
        if(!item.isEmpty()){
            System.out.println(this.item);
        }else{
            System.out.println("A lista está vazia");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + item +
                '}';
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}


