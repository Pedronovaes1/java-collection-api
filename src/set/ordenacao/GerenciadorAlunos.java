package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    //atributos
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAlunoPorMatricula(long matricula){
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()){
            for(Aluno aluno : alunoSet){
                if(aluno.getMatricula() == matricula){
                    alunoParaRemover = aluno;
                    break;
                }
            }
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }

        if(alunoParaRemover == null){
            System.out.println("Matricula não encontrada");
        }
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>();
        if(!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }else{
            System.out.println("O conjunto está vazio");
        }
    }

    public void exibirAlunoPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new Aluno.ComparatorNota());
        if(!alunoSet.isEmpty()){
            alunosPorNota.addAll(alunoSet);
            System.out.println(alunosPorNota);
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void exibirAlunos(){
        if(!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunoSet);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAlunoPorMatricula(000L);
        gerenciadorAlunos.removerAlunoPorMatricula(123457L);
        System.out.println(gerenciadorAlunos.alunoSet);

        // Exibindo alunos ordenados por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        // Exibindo alunos ordenados por nota
        gerenciadorAlunos.exibirAlunoPorNota();
    }


}
