package map.Ordenacao;

import map.OperacoesBasicas.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data,evento);
    }
    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }
    public void obterProximoEvento(){
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);

        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            proximaData  = entry.getKey();
            proximoEvento = entry.getValue();

            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O próximo evento :" + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15),"Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9),"Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10),"Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 12),"Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 13),"Evento 5", "Atração 5");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
