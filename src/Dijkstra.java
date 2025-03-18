import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Dijkstra {
    private Conf conf;

    public Dijkstra(Conf conf) {
        this.conf = conf;
    }
    public void start(){
        int[][] matrice = conf.getMatrice();

        int len = matrice.length;
        int[] costi = new int[len];
        boolean[] nodiVisitati = new boolean[len];
        HashMap<Integer, List> predecessori = new HashMap<Integer, List>();

        //Impostiamo tutto il vettore contenente i costi a infinito (Integer.MAX_VALUE)
        costi[0] = 0;
        for(int i = 1; i< len; ++i){
            costi[i] = Integer.MAX_VALUE;
        }



        for(int i = 0; i<len; ++i){
            for (int j = 0; j<len; ++j){
                if( (matrice[i][j] != 0) && (matrice[i][j] != -1)){
                    int costo = matrice[i][j];
                    if(costo < costi[j]){
                        costi[j] = costo;
                    }
                    //System.out.println("DBG: " + matrice[i][j]);
                    /*if(matrice[i][j] < costi[i]){
                        costi[i] = matrice[i][j];
                    }*/


                }
            }
        }

        for(int i = 0; i<len; i++){
            System.out.println(costi[i]);
        }
        

    }





}
