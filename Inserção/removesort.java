public class removesort {
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
        
        System.out.println("Lista antes da remoção:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        // Remoção dos elementos
        int removeIndex1 = 2;
        int removeIndex2 = 5;
        int removeIndex3 = 7;
        int removeIndex4 = 9;
        
        // Definindo novo tamanho do array
        int newSize = array.length - 4;
        int[] newArray = new int[newSize];
        
        // Copiando os elementos que não serão removidos para o novo array
        int newIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != removeIndex1 && i != removeIndex2 && i != removeIndex3 && i != removeIndex4) {
                newArray[newIndex] = array[i];
                newIndex++;
            }
        }
        
        insertionSort(newArray);
        
        System.out.println("\nLista após a remoção e ordenação por inserção:");
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}