public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            
            array[j + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {50, 22, 35, 31, 20, 77, 80, 90, 65, 72};
        
        System.out.println("Lista antes da ordenação por inserção:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        insertionSort(array);
        
        System.out.println("\nLista após a ordenação por inserção:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
