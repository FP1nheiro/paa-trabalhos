package trabalhos;

import java.util.Arrays;
import java.util.Comparator;

public class Mochila {

    public static int knapsackDP(int[] pesos, int[] valores, int capacidade) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidade + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidade; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacidade];
    }

    public static int knapsackGreedy(int[] pesos, int[] valores, int capacidade) {
        int n = pesos.length;
        Item[] itens = new Item[n];
        for (int i = 0; i < n; i++) {
            itens[i] = new Item(pesos[i], valores[i]);
        }
        Arrays.sort(itens, Comparator.comparingDouble(Item::valorPorPeso).reversed());
        int pesoTotal = 0;
        int valorTotal = 0;
        for (Item item : itens) {
            if (pesoTotal + item.peso <= capacidade) {
                pesoTotal += item.peso;
                valorTotal += item.valor;
            }
        }
        return valorTotal;
    }

    static class Item {
        int peso;
        int valor;

        Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }

        double valorPorPeso() {
            return (double) valor / peso;
        }
    }
}
