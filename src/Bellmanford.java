import java.util.*;

public class Bellmanford {
    private Conf conf;

    public Bellmanford(Conf conf) {
        this.conf = conf;
    }



    public void start() {
        int[][] matrice = conf.getMatrice();
        int len = matrice.length;
        int[] costi = new int[len];  // Distanze minime dal nodo di partenza
        HashMap<Integer, List<Integer>> predecessori = new HashMap<>(); // Mappa dei predecessori
        boolean aggiornamento;
        // Inizializziamo i costi a infinito (tranne il nodo iniziale)
        Arrays.fill(costi, Integer.MAX_VALUE);
        costi[0] = 0; // Il nodo di partenza ha costo 0

        do {
            aggiornamento = false;
            for (int i = 0; i < len; i++) {

                int nodoCorrente = i;
                if(costi[nodoCorrente] == Integer.MAX_VALUE) { continue;}

                // Aggiorna i costi dei vicini
                for (int vicino = 0; vicino < len; vicino++) {
                    if (matrice[nodoCorrente][vicino] > 0) {
                        int nuovoCosto = costi[nodoCorrente] + matrice[nodoCorrente][vicino];

                        if (nuovoCosto < costi[vicino]) {
                            costi[vicino] = nuovoCosto;
                            // Se troviamo un percorso migliore, sostituiamo la lista dei predecessori
                            //System.out.println(predecessori.get(vicino));
                            predecessori.put(vicino, new ArrayList<>(Arrays.asList(nodoCorrente)));
                            aggiornamento = true;

                        } else if (nuovoCosto == costi[vicino]) {
                            // Se il nuovo percorso ha lo stesso costo, aggiungiamo il predecessore
                            if (!(predecessori.get(vicino).contains(nodoCorrente))){
                                predecessori.get(vicino).add(nodoCorrente);
                            }

                        }
                    }
                }
            }
        }
        while(aggiornamento);





        System.out.println("Costi minimi:");
        System.out.println(" NODO COSTO PREDECESSORI");
        System.out.println("-------------------------");
        for (int i = 0; i < len; i++) {
            System.out.println("  " + i + "     " + costi[i] + "    " + predecessori.getOrDefault(i, new ArrayList<>()));

            //System.out.println("Nodo " + i + " -> Costo: " + costi[i] + ", Predecessori: " + predecessori.getOrDefault(i, new ArrayList<>()));
        }
    }


}