public class Dijkstra {
    private Conf conf;

    public Dijkstra(Conf conf) {
        this.conf = conf;
    }
    public void start(){
        int[][] matrice = conf.getMatrice();

        int len = matrice.length;
        int[] distanze = new int[len];
        boolean[] nodiVisitati = new boolean[len];

        //Impostiamo tutto il vettore contenente le distanze a infinito (Integer.MAX_VALUE)
        for(int i = 0; i< len; ++i){
            distanze[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<len; ++i){
            for(int j = 0; j<len; ++j){
                if( (matrice[i][j] != 0) && (matrice[i][j] != -1)){
                    System.out.println("DBG: " + matrice[i][j]);
                    if(matrice[i][j] < distanze[i]){
                        distanze[i] = matrice[i][j];
                    }
                }
            }
        }

        for(int i = 0; i<len; i++){
            System.out.println(distanze[i]);
        }
        

    }





}
