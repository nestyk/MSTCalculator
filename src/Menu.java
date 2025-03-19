import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {


    public static void Init(){
        Scanner sc = new Scanner(System.in);
        Conf c = new Conf();

        System.out.println("Benvenuto!");
        System.out.println("Inserisci il valore 1 per aprire la matrice da file, 2 per inserirla manualmente:");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Setting up matrix.txt");
                try {
                    c.setMatrice("matrix.txt");
                } catch (FileNotFoundException e){
                    System.out.println("FIle not found.");
                } break;
            case 2:
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
                break;
            default:
                System.out.println("Choice not recognized. Quitting...");
                System.exit(0);
        }


        System.out.println("Matrice impostata a questi valori: ");
        c.stampaMatrice();
        System.out.println("Digita 1 se vuoi usare l'algoritmo di Dijkstra, 2 per Bellmanford.");



        choice = sc.nextInt();
        switch (choice){
            case 1:
                Dijkstra d = new Dijkstra(c);
                d.start();
                break;
            case 2:
                Bellmanford b = new Bellmanford(c);
                b.start();
                break;
            default:
                System.out.println("Choice not recognized. Quitting..");

        }

    }
}
