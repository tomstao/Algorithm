public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        //Algorithms.selection(intArray);
        //Algorithms.insertionSort(intArray);
        //Algorithms.shellSort(intArray);
        //Algorithms.mergeSort(intArray, 0, intArray.length);
        Algorithms.quickSort(intArray, 0, intArray.length);
        Algorithms.printArray(intArray);
    }
}