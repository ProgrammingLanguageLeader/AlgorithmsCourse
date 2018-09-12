package algorithms.max_binary_heap;

import java.lang.reflect.Array;

public class MaxBinaryHeap<T extends Comparable<T>> {
    private static final int MAX_HEAP_SIZE = 100000;
    private int freeElementIndex;
    private T[] arrayContainer;

    public MaxBinaryHeap(Class<T> c) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(c, MAX_HEAP_SIZE);
        arrayContainer = array;
        freeElementIndex = 0;
    }

    private int getParentIndex(int elementIndex) {
        if (elementIndex == 0) {
            return 0;
        }
        return (int)Math.ceil((double)(elementIndex - 2) / 2);
    }

    private int getLeftChildIndex(int elementIndex) {
        return 2 * elementIndex + 1;
    }

    private int getRightChildIndex(int elementIndex) {
        return 2 * elementIndex + 2;
    }

    private void siftDown() {
        int parentIndex = 0;
        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = getRightChildIndex(parentIndex);
        int maxChildIndex;
        while (leftChildIndex < freeElementIndex && rightChildIndex < freeElementIndex) {
            if (!(
                    arrayContainer[parentIndex].compareTo(arrayContainer[leftChildIndex]) < 0 ||
                    arrayContainer[parentIndex].compareTo(arrayContainer[rightChildIndex]) < 0
            )) {
                return;
            }
            if (arrayContainer[leftChildIndex].compareTo(arrayContainer[rightChildIndex]) > 0) {
                maxChildIndex = leftChildIndex;
            } else {
                maxChildIndex = rightChildIndex;
            }
            T temp = arrayContainer[parentIndex];
            arrayContainer[parentIndex] = arrayContainer[maxChildIndex];
            arrayContainer[maxChildIndex] = temp;
            parentIndex = maxChildIndex;
            leftChildIndex = getLeftChildIndex(parentIndex);
            rightChildIndex = getRightChildIndex(parentIndex);
        }

        maxChildIndex = -1;
        if (rightChildIndex < freeElementIndex) {
            if (arrayContainer[parentIndex].compareTo(arrayContainer[rightChildIndex]) < 0) {
                maxChildIndex = rightChildIndex;
            }
        }
        else if (leftChildIndex < freeElementIndex) {
            if (arrayContainer[parentIndex].compareTo(arrayContainer[leftChildIndex]) < 0) {
                maxChildIndex = leftChildIndex;
            }
        }
        if (maxChildIndex != -1) {
            T temp = arrayContainer[parentIndex];
            arrayContainer[parentIndex] = arrayContainer[maxChildIndex];
            arrayContainer[maxChildIndex] = temp;
        }
    }

    private void siftUp(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        while (arrayContainer[parentIndex].compareTo(arrayContainer[childIndex]) < 0) {
            T temp = arrayContainer[parentIndex];
            arrayContainer[parentIndex] = arrayContainer[childIndex];
            arrayContainer[childIndex] = temp;
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    public void insert(T element) {
        arrayContainer[freeElementIndex++] = element;
        if (freeElementIndex - 1 != 0) {
            siftUp(freeElementIndex - 1);
        }
    }

    public T extractMax() {
        T maxValue = arrayContainer[0];
        arrayContainer[0] = arrayContainer[--freeElementIndex];
        siftDown();
        return maxValue;
    }

    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder("[");
        for (int i = 0; i < freeElementIndex - 1; i++) {
            resultBuilder.append(arrayContainer[i].toString());
            resultBuilder.append(", ");
        }
        resultBuilder.append(arrayContainer[freeElementIndex - 1].toString());
        resultBuilder.append("]");
        return resultBuilder.toString();
    }
}
