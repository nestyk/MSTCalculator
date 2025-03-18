public class Helpers {

    public static int findNextNode(boolean[] nodiVisitati, int[] costi){
        for (boolean node:
                nodiVisitati) {
            if (!node){
                System.out.println("test");
            }
        }
        return 0;
    }

    public static boolean visitedAllNodes(boolean[] nodes){
        for (boolean node:
             nodes) {
            if (!node){
                return false;
            }
        }
        return true;
    }
}
