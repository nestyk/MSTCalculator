import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    private Conf conf;

    public Dijkstra(Conf conf) {
        this.conf = conf;
    }

    // Metodo per trovare il nodo con il costo minore tra quelli non visitati
    private int trovaNodoMinimo(int[] costi, boolean[] nodiVisitati) {
        int minCosto = Integer.MAX_VALUE;
        int nodoMinimo = -1;
        for (int i = 0; i < costi.length; i++) {
            if (!nodiVisitati[i] && costi[i] < minCosto) {
                minCosto = costi[i];
                nodoMinimo = i;
            }
        }
        return nodoMinimo;
    }

    public void start() {
        int[][] matrice = conf.getMatrice();
        int len = matrice.length;
        int[] costi = new int[len];  // Distanze minime dal nodo di partenza
        boolean[] nodiVisitati = new boolean[len]; // Per tenere traccia dei nodi visitati
        HashMap<Integer, List<Integer>> predecessori = new HashMap<>(); // Mappa dei predecessori

        // Inizializziamo i costi a infinito (tranne il nodo iniziale)
        Arrays.fill(costi, Integer.MAX_VALUE);
        costi[0] = 0; // Il nodo di partenza ha costo 0

        for (int i = 0; i < len; i++) {
            // Trova il nodo con il costo minore tra quelli non ancora visitati
            int nodoCorrente = trovaNodoMinimo(costi, nodiVisitati);
            if (nodoCorrente == -1) break; // Se nessun nodo è raggiungibile, interrompi

            nodiVisitati[nodoCorrente] = true; // Segna il nodo come visitato

            // Aggiorna i costi dei vicini
            for (int vicino = 0; vicino < len; vicino++) {
                if (matrice[nodoCorrente][vicino] > 0 && !nodiVisitati[vicino]) {
                    int nuovoCosto = costi[nodoCorrente] + matrice[nodoCorrente][vicino];

                    if (nuovoCosto < costi[vicino]) {
                        costi[vicino] = nuovoCosto;
                        // Se troviamo un percorso migliore, sostituiamo la lista dei predecessori
                        //System.out.println(predecessori.get(vicino));
                        predecessori.put(vicino, new ArrayList<>(Arrays.asList(nodoCorrente)));

                    } else if (nuovoCosto == costi[vicino]) {
                        // Se il nuovo percorso ha lo stesso costo, aggiungiamo il predecessore
                        predecessori.get(vicino).add(nodoCorrente);
                    }
                }
            }
        }


        System.out.println("Costi minimi:");
        System.out.println(" NODO COSTO PREDECESSORI");
        System.out.println("-------------------------");
        for (int i = 0; i < len; i++) {
            System.out.println("  " + i + "     " + costi[i] + "    " + predecessori.getOrDefault(i, new ArrayList<>()));
        }
    }


}