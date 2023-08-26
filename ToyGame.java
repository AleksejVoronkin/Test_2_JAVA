public class ToyGame {

    public static void main(String[] args) {
        String[] ids = {"1", "2", "3"};
        String[] names = {"конструктор", "робот", "кукла"};
        int[] weights = {2, 2, 6};

        ToyQueue toyQueue = new ToyQueue(ids, names, weights);
        toyQueue.writeResultsToFile("ToyResults.txt");
    }
}