import java.util.*;

class maxHeap {
    private int[] heap;
    private int size;

    // Constructor
    public maxHeap() {
        // Since q <= 1000, a fixed size of 1001 avoids resizing overhead completely
        heap = new int[1001];
        size = 0;
    }

    public void push(int x) {
        // Place the element at the end of the heap
        heap[size] = x;
        int current = size;
        size++;

        // Up-heapify (Bubble up) to restore Max-Heap property
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[current] > heap[parent]) {
                // Swap current and parent
                int temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;
                
                current = parent;
            } else {
                break;
            }
        }
    }

    public void pop() {
        if (size == 0) {
            return;
        }

        // Replace root with the last element
        heap[0] = heap[size - 1];
        size--;

        // Down-heapify (Bubble down) to restore Max-Heap property
        int current = 0;
        while (2 * current + 1 < size) {
            int leftChild = 2 * current + 1;
            int rightChild = 2 * current + 2;
            int largest = current;

            if (heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }
            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            if (largest != current) {
                // Swap current and largest
                int temp = heap[current];
                heap[current] = heap[largest];
                heap[largest] = temp;
                
                current = largest;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return heap[0];
    }

    public int size() {
        return size;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna