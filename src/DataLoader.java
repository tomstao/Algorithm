import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // Using List initially for flexibility, then converting to array

public class DataLoader {

    public static int[] loadNumbersFromFile(String filePath, int expectedCount) {
        System.out.println("Loading numbers from file: " + filePath);
        long startTime = System.nanoTime();

        // Using ArrayList first is flexible, but if you know the exact count,
        // you can initialize the array directly for slight performance gain.
        List<Integer> numberList = new ArrayList<>(expectedCount > 0 ? expectedCount : 1024);
        // Or, if strictly using expectedCount and it's guaranteed:
        // int[] numbers = new int[expectedCount];
        // int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numberList.add(Integer.parseInt(line.trim()));
                    // For pre-allocated array:
                    // if (index < expectedCount) {
                    //     numbers[index++] = Integer.parseInt(line.trim());
                    // } else {
                    //     System.err.println("Warning: File has more numbers than expectedCount " + expectedCount);
                    //     break;
                    // }
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
            return null; // Or throw an exception
        }

        // Convert List to int[]
        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }
        // If using pre-allocated array and it might not be full (e.g. file was shorter):
        // if (index < expectedCount) {
        //     return Arrays.copyOf(numbers, index); // Return a correctly sized array
        // }


        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;
        System.out.println("Finished loading " + numbers.length + " numbers in " + durationMs + " ms.");
        return numbers;
    }

    public static void main(String[] args) {
        String filePath = "numbers_1M.txt"; // File created in Step 1
        int expectedNumberOfIntegers = 1_000_000;

        int[] testArray = loadNumbersFromFile(filePath, expectedNumberOfIntegers);

        if (testArray != null && testArray.length > 0) {
            System.out.println("Successfully loaded array. First 10 elements:");
            for (int i = 0; i < Math.min(10, testArray.length); i++) {
                System.out.print(testArray[i] + " ");
            }
            System.out.println();

            // Now you can use 'testArray' for your sorting algorithm tests
            // e.g., BubbleSort.bubbleSort(testArray);
            // e.g., YourSortAlgorithm.sort(Arrays.copyOf(testArray, testArray.length)); // Sort a copy
        } else {
            System.out.println("Failed to load the array.");
        }
    }
}