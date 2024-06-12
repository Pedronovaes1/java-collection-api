package Map.ordenacao;

import java.util.Comparator;
import java.util.Map;

public class Livro {
    //atributos
    private String titulo;
    private String auto;
    private double preco;

    public Livro(String titulo, String auto, double preco) {
        this.titulo = titulo;
        this.auto = auto;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public String getAuto() {
        return auto;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", auto='" + auto + '\'' +
                ", preco=" + preco +
                '}';
    }


    static class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {

        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
        }
    }

    static class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>>{

        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return l1.getValue().getAuto().compareToIgnoreCase(l2.getValue().getAuto());
        }
    }

}
