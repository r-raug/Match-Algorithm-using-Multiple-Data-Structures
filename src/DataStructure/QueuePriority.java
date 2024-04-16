package DataStructure;
//import DataStructure.Queue;
//import auxiliaryStructure.compareProfessorsClass;

import Model.Professors;
import auxiliaryStructure.compareProfessorsClass;

public class QueuePriority<T extends Comparable<T>> extends Queue<T>{


    public void enqueue(T item){
        if (isFull()) {
            resize();
        }else {
            queue[size] = item;
            size++;
        }
        insertionSort();
    }

    private void insertionSort() {
        if (isEmpty()) {
            System.out.println("Cannot sort an empty queue.");
            return;
        }

        for (int i = 1; i < size; i++) {
            T key = queue[i];
            int j = i - 1;

            while (j >= 0 && ((Comparable) queue[j]).compareTo(key) > 0) {
                queue[j + 1] = queue[j];
                j--;
            }
            queue[j + 1] = key;
        }
    }

    public void displayElement(T element){
        var item = findPosition(element);
        if( item == - 1){
            System.out.println("Element not found.");
        }else{
            System.out.printf("The element {element} is on the index {item}.",element, item);
        }
    }

    public void displayHigherElements(T item){
        var position = findPosition(item);
        for( int i = position; i < size - 1 ; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void displayLowerElements(T item){
        var position = findPosition(item);
        for( int i = 0; i < position ; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }


    /**
     * Finds the position of an item in the queue.
     *
     * @param item the item to find the position of
     * @return the position of the item in the queue, or -1 if the item is not found
     */
    public int findPosition(T item) {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int i = 0;
        compareProfessorsClass comparator = new compareProfessorsClass(); // Instanciando a classe de comparação
        while (i < size && comparator.compareProfessors((Professors) queue[i], (Professors) item) < 0) { // Comparando usando a classe de comparação
            i = (i + 1) % queue.length;
        }
        return i;
    }

    public T getElement(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Invalid index or queue is empty.");
            return null;
        }
        return queue[index];
    }

}
