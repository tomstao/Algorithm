public class Performance {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + (double)duration / 1_000_000 + " milliseconds");
    }
}
