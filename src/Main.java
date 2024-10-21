import trabalhos.Buscas;
import trabalhos.Grafos;
import trabalhos.Mochila;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //
        // Questão 1
        //

        int[] arr = {1, 2, 4, 10, 12};
        int x = 10;
        int resultadoSequencial = Buscas.buscaSequencial(arr, x);
        int resultadoBinario = Buscas.buscaBinaria(arr, x);

        System.out.println("Resultado Busca Sequencial: " + resultadoSequencial);
        System.out.println("Resultado Busca Binária: " + resultadoBinario);
        System.out.println();

        //
        // Questão 2
        //

        int[] pesos = {12, 1, 4, 1, 2};
        int[] valores = {4, 2, 10, 1, 2};
        int capacidade = 15;
        int resultadoDP = Mochila.knapsackDP(pesos, valores, capacidade);
        int resultadoGuloso = Mochila.knapsackGreedy(pesos, valores, capacidade);

        System.out.println("Resultado trabalhos.Mochila - Programação Dinâmica: " + resultadoDP);
        System.out.println("Resultado trabalhos.Mochila - Algoritmo Guloso: " + resultadoGuloso);
        System.out.println();

        //
        // Questão 3
        //

        Map<String, List<String>> grafo = new HashMap<>();
        grafo.put("A", Arrays.asList("B", "C"));
        grafo.put("B", Arrays.asList("D", "E"));
        grafo.put("C", List.of("F"));
        grafo.put("D", Collections.emptyList());
        grafo.put("E", List.of("F"));
        grafo.put("F", Collections.emptyList());

        List<String> resultadoBFS = Grafos.bfs(grafo, "A");
        List<String> resultadoDFS = Grafos.dfs(grafo, "A");

        System.out.println("Resultado BFS: " + resultadoBFS);
        System.out.println("Resultado DFS: " + resultadoDFS);
        System.out.println();
    }
}
