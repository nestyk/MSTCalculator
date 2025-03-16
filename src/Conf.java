import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Conf {
    private int[][] matrice;
    public void stampaMatrice(){
        for(int i = 0; i< matrice.length;++i){
            for(int j = 0; j< matrice.length; ++j){
                System.out.printf("%d ", matrice[i][j]);
            }
            System.out.println();
        }
    }
    public void setMatrice(int[][] m){
        matrice = m;
    }
    public void setMatrice(String path) throws FileNotFoundException {
        Scanner sf = new Scanner(new File(path));
        Vector<String> Lines = new Vector<>();
        int SIZE = 0;

        while(sf.hasNextLine()){
            Lines.add(sf.nextLine());
            ++SIZE;
        }
        int m[][] = new int[SIZE][SIZE];
        sf.close();

        int i = 0; // Inizializza i
        for (String line : Lines) {
            String[] valori = line.split(","); // Divide la riga in valori
            for (int j = 0; j < valori.length; j++) {

                if(valori[j].equals("Inf")){
                    m[i][j] = -1;
                } else{
                    m[i][j] = Integer.parseInt(valori[j].trim());
                }

            }
            ++i;
        }
        matrice = m;


        
    }
    public int[][] getMatrice(){
        return matrice;
    }



}
