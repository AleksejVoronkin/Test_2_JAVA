import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class ToyQueue {
    private Queue<Toy> toyQueue;

    public ToyQueue(String[] ids, String[] names, int[] weights) {
        this.toyQueue = new PriorityQueue<>();
        fillToyQueue(ids, names, weights);
    }

    private void fillToyQueue(String[] ids, String[] names, int[] weights) {
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], weights[i]);
            toyQueue.add(toy);
        }
    }

    public void writeResultsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(100);
                Toy toy = getRandomToy(randomNumber);
                writer.write(toy.getId());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Toy getRandomToy(int randomNumber) {
        int totalWeight = 0;
        for (Toy toy : toyQueue) {
            totalWeight += toy.getWeight();
        }

        int randomWeight = randomNumber % totalWeight;
        int currentWeight = 0;
        for (Toy toy : toyQueue) {
            currentWeight += toy.getWeight();
            if (randomWeight < currentWeight) {
                return toy;
            }
        }
        return toyQueue.peek();
    }
}