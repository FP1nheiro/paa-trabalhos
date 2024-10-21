package trabalhos;

import java.util.*;

public class Grafos {

    public static List<String> bfs(Map<String, List<String>> grafo, String inicio) {
        List<String> visitados = new ArrayList<>();
        Queue<String> fila = new LinkedList<>();
        fila.add(inicio);
        while (!fila.isEmpty()) {
            String vertice = fila.poll();
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);
                for (String vizinho : grafo.get(vertice)) {
                    if (!visitados.contains(vizinho)) {
                        fila.add(vizinho);
                    }
                }
            }
        }
        return visitados;
    }

    public static List<String> dfs(Map<String, List<String>> grafo, String inicio) {
        List<String> visitados = new ArrayList<>();
        dfsRecursivo(grafo, inicio, visitados);
        return visitados;
    }

    private static void dfsRecursivo(Map<String, List<String>> grafo, String vertice, List<String> visitados) {
        visitados.add(vertice);
        for (String vizinho : grafo.get(vertice)) {
            if (!visitados.contains(vizinho)) {
                dfsRecursivo(grafo, vizinho, visitados);
            }
        }
    }
}
