package Map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    //atributo
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate date, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(date, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        //o Local date já sabe como organizar de forma crescente
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        /*Set<LocalDate> dataSet = eventosMap.keySet();
        Collection<Evento> values = eventosMap.values();*/
        //eventosMap.get(); ele recebe a chave e retorna um evento ou produto, por exemplo

        //pegar data atual
        LocalDate dataAtual = LocalDate.now();
        //elementos na ordem crescente
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            //o método retorna o set, onde o elementos é de um tipo único
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O próximo evento: " + entry.getValue() + " acontecerá na data: " + entry.getKey());
                break;
            }
        }
    }


    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();

    }

}
