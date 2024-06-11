package set.ordenacao;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
    //atributos
    private String nome;
    private long matricula;
    private double media;

    public Aluno(String nome, long matricula, double media) {
        this.nome = nome;
        this.matricula = matricula;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", media=" + media +
                '}';
    }

    @Override
    public int compareTo(Aluno o) {
        return 0;
    }

}
