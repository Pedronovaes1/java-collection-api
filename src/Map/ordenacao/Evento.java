package Map.ordenacao;

public class Evento {
    //atributos
    private String nome;
    private String nomeAtracao;

    public Evento(String nome, String nomeAtracao) {
        this.nome = nome;
        this.nomeAtracao = nomeAtracao;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAtracao() {
        return nomeAtracao;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", nomeAtracao='" + nomeAtracao + '\'' +
                '}';
    }
}
