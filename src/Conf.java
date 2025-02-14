import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Conf {
    private int[][] matrice;

    public void setMatrice(int[][] m){
        matrice = m;
    }
    public void setMatrice(String path) throws FileNotFoundException {
        Scanner sf = new Scanner(new File(path));
        Vector<String> Lines = new Vector<>();

        while(sf.hasNextLine()){
            //System.out.println("line found");
            Lines.add(sf.nextLine());

        }
        sf.close();
        for(String line :Lines){
            System.out.println(line);
        }
        
    }
    public int[][] getMatrice(){
        return matrice;
    }



}
