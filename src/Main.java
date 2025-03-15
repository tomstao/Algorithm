public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
//        int[] intArray = Algorithms.generateRandomArray(10,10);
        int[] intArray2 = Algorithms.generateRandomArray(10,5000, 100);
        //Algorithms.selection(intArray);
        //Algorithms.insertionSort(intArray);
        //Algorithms.shellSort(intArray);
        //Algorithms.mergeSort(intArray, 0, intArray.length);
        //Algorithms.quickSort(intArray, 0, intArray.length);
//        Algorithms.printArray(intArray);
//        System.out.println();
//        Algorithms.countingSort(intArray,1,10);
//        Algorithms.printArray(intArray);
        //Algorithms.printArray(intArray2);
        //Algorithms.radixSort(intArray2,10,4);
        //System.out.println();
        //Algorithms.printArray(intArray2);

        Algorithms.classInsertion(intArray2);
        Algorithms.printArray(intArray2);

    }
}