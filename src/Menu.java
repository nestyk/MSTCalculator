import java.util.Scanner;

public class Menu {


    public void Init(){
        Scanner sc = new Scanner(System.in);
        Conf c = new Conf();
        /*
        System.out.println("Benvenuto!");
        System.out.println("Inserisci la dimensione della matrice: Es -> 4 ");
        int SIZE = sc.nextInt();
        int[][] m = new int[SIZE][SIZE];



        System.out.println("inserisci i valori della matrice:");
        for(int i = 0; i<SIZE; i++){
            for(int j = 0; j<SIZE; j++){
                System.out.println("m["+i+"]["+j+"] -> ");
                m[i][j] = sc.nextInt();
            }
        }
        c.setMatrice(m);
        */



        int choice = sc.nextInt();
        switch (choice){
            case 1:
                Dijkstra d = new Dijkstra(c);
                d.start();
                break;
            case 2:
                System.out.println("dopo");
                break;
            default:
                System.out.println("Choice not recognized.");

        }

    }
}
