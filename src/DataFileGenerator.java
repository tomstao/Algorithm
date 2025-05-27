import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataFileGenerator {

    public static void generateNumbersToFile(String filePath, int count, int upperBound) {
        System.out.println("Generating " + count + " numbers to file: " + filePath);
        long startTime = System.nanoTime();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random(); // For reproducibility, use new Random(seedL);
            for (int i = 0; i < count; i++) {
                writer.write(Integer.toString(random.nextInt(upperBound)));
                writer.newLine(); // Write each number on a new line
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;
        System.out.println("Finished writing to file in " + durationMs + " ms.");
    }

    public static void main(String[] args) {
        String filePath = "numbers_1M.txt"; // Name of the file to create
        int numberOfIntegers = 1_000_000;   // 10^6
        int upperBound = 1000;             // Numbers will be from 0 to 999

        // Generate the file (you only need to do this once, or when you want new data)
        generateNumbersToFile(filePath, numberOfIntegers, upperBound);
    }
}