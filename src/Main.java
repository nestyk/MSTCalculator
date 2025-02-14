import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Menu menu = new Menu();
        //menu.Init();
        Conf c = new Conf();
        try {
            c.setMatrice("matrix.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found.");
        }
    }
}