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

    public void removerAluno(long matricula){
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()){
            for(Aluno aluno : alunoSet){
                if(aluno.getMatricula() == matricula){
                    alunoParaRemover = aluno;
                }
            }
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
        alunoSet.remove(alunoParaRemover);
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

    }
}
