package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    //atributo
    private List<Tarefa> tarefalist;

    public ListaTarefa() {
        this.tarefalist = new ArrayList<>();
    }
    public void adicionarTarefa(String descricao){
        tarefalist.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for(Tarefa t : tarefalist){
            if (t.getDescricao() .equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
            tarefalist.removeAll(tarefasParaRemover);
        }
    }
    public int obterNumeroTotalDeTarefas(){
        return tarefalist.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefalist);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();



        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");


        System.out.println("Numero total de elementos " + listaTarefa.obterNumeroTotalDeTarefas());
        listaTarefa.obterDescricoesTarefas();
    }
}