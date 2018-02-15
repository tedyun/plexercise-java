import java.util.Arrays;

class Heap {
    static int MAX_SIZE = 50;
    // We will keep heap[0] as null and start from index 1.
    int[] heap;
    int size;

    public Heap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public int[] getArray() {
        return heap;
    }

    public void add(int num) {
        this.append(num);
        swim(size);
    }

    public int remove() throws Exception {
        if (size > 0) {
            int first = this.removeFirst();
            sink(1);
            return first;
        } else {
            throw new Exception("No item in the heap");
        }
    }

    protected void append(int num) {
        heap[++size] = num;
    }

    // Remove the last entry
    protected int removeLast() {
        if (size > 0) {
            return heap[size--];
        }
        return null;
    }

    // Remove the first entry and replace it by the last entry
    protected int removeFirst() throws Exception {
        if (size > 0) {
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = 0;
            size--;
            return temp;
        } else {
            throw new Exception("No Item in the heap");
        }
    }

    // sink the entry at the index and return the final index at which it ends up
    protected int sink(int ind) {
        int curNode = heap[ind];
        boolean hasLeftChild = ind * 2 <= size;
        boolean hasRightChild = ind * 2 + 1 <= size;
        int leftChild, rightChild;
        
        // has at most 1 child
        if (!hasLeftChild && !hasRightChild) {
            // has no child
            return ind;
        } else if (!hasRightChild) {
            leftChild = heap[ind * 2];
            // only has left child
            if (curNode < leftChild) {
                swap(ind, ind * 2);
                return sink(ind * 2);
            } else {
                return ind;
            }
        }
        
        // has both children
        leftChild = heap[ind * 2];
        rightChild = heap[ind * 2 + 1];

        int nextPos = (leftChild >= rightChild)? (ind * 2) : (ind * 2 + 1);
        swap(ind, nextPos);
        return sink(nextPos);
    }

    // swim up the entry at the index and return the final index at which it ends up
    protected int swim(int ind) {
        if (ind == 1) return ind;

        int curVal = heap[ind];
        int parentInd = ind / 2;
        int parentVal = heap[parentInd];
        
        if (parentVal < curVal) {
            // move up
            swap(ind, parentInd);
            return swim(parentInd);
        } else {
            return ind;
        }
    }

    protected void swap(int indA, int indB) {
        int temp = heap[indA];
        heap[indA] = heap[indB];
        heap[indB] = temp;
    }
    
    // return the size of the heap
    public int size() {
        return size;
    }
}

public class HeapSort {

    /**
     * Main
     */
    public static void main(String[] args) {
        System.out.println("HeapSort class");
        Heap heap = new Heap();
        try {
            System.out.println("Adding 3");
            heap.add(3);
            System.out.println("Adding 4");
            heap.add(4);
            System.out.println("Adding 2");
            heap.add(2);
            System.out.println(Arrays.toString(heap.getArray()));
            System.out.println("Size: " + heap.size());
            System.out.println("Removing " + heap.remove());
            System.out.println("Adding 7");
            heap.add(7);
            System.out.println("Adding 4");
            heap.add(4);
            System.out.println("Adding 2");
            heap.add(2);
            System.out.println("Removing " + heap.remove());
            System.out.println("Adding 9");
            heap.add(9);
            System.out.println("Removing " + heap.remove());
            System.out.println(Arrays.toString(heap.getArray()));
            System.out.println("Size: " + heap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}