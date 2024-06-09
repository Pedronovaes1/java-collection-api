package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    //atributo

    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if(!tarefasSet.isEmpty()){
           for(Tarefa tarefa : tarefasSet){
               if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                   tarefaParaRemover = tarefa;
                   break;
               }
           }
           tarefasSet.remove(tarefaParaRemover);
        }else {
            throw new RuntimeException("Conjunto vazio");
        }
    }

    public void exibirTarefas(){
        if(!tarefasSet.isEmpty()){
            System.out.println(tarefasSet);
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public int contarTarefas(){
        return tarefasSet.size();
        //pode fazer mais simples com tarefasSet.size()
    }

    public Set<Tarefa> obterTarefaConcluida(){
        Set<Tarefa> tarefasConcluida = new HashSet<>();
        for(Tarefa tarefa : tarefasSet){
            if(tarefa.isConcluida()){
                tarefasConcluida.add(tarefa);
            }
        }
        return tarefasConcluida;
    }

    public Set<Tarefa> obterTarefaPendentes(){
        Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
        for(Tarefa tarefa : tarefasSet){
            if(!tarefa.isConcluida()){
                tarefasNaoConcluidas.add(tarefa);
            }
        }
        return tarefasNaoConcluidas;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa tarefa: tarefasSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefa.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for(Tarefa tarefa: tarefasSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefaPendente = tarefa;
                break;
            }
        }

        if(tarefaPendente != null){
            if(tarefaPendente.isConcluida()){
                tarefaPendente.setConcluida(false);
            }else{
                System.out.println("Tarefa não encontrada na lista");
            }
        }
    }

    public void limparListaTarefas(){
        if(tarefasSet.isEmpty()){
            System.out.println("A lista está vazia");
        }else{
            tarefasSet.clear();
        }
    }

    public static void main(String[] args) {
        //instanciando lista tarefa
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        //exibir tarefas
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefaPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefaConcluida());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        //listaTarefas.exibirTarefas();
    }


}
