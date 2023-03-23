// Gustav Walter guwa7932
public class DHeap<T extends Comparable<? super T>> {
    // Instance variables
    private static final int DEFAULT_CAPACITY = 10;
    private int children = 2;
    private int currentSize; 
    private T[] array; 
    
    // Always go here
    public DHeap() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
        return;
    }

    // If you have an argument in the constructor, you have to go here
    public DHeap(int capacity) {
        children = capacity;
        if(capacity <= 1){
            throw new IllegalArgumentException("Capacity must be greater than 1");
        }
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    // Insert method
    public void insert(T x)
    {
        if( currentSize == array.length - 1 ) {
            enlargeArray( array.length * 2 + 1 );
        }

        percolateUp(x);
    }

    // Percolate up method
    private void percolateUp(T x){
        int hole = ++currentSize;
        for(array[0] = x; hole != 1 && x.compareTo( array[parentIndex(hole)] ) < 0; hole = parentIndex(hole)) {
            if (hole != 1) {
                array[hole] = array[parentIndex(hole)];
            }
        }
        array[ hole ] = x;
    }

    // Enlarge array method
    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    // Find min method
    public T findMin() {
        if (isEmpty())
            throw new UnderflowException();
        return array[1];
    }

    // Delete min method
    public T deleteMin() {
        if (isEmpty())
            throw new UnderflowException();

        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    // Is empty method
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Make empty method
    public void makeEmpty() {
        currentSize = 0;
    }

    // Percolate down method
    private void percolateDown(int holeIndex) {
        int childIndex;
        T temp = array[holeIndex];
        int smallestChildIndex;
        
        while (firstChildIndex(holeIndex) <= currentSize) {
            childIndex = firstChildIndex(holeIndex);
            smallestChildIndex = childIndex;
            
            // Find smallest child index
            for (int i = 0; i < children && (childIndex + i) <= currentSize; i++) {
                if ((childIndex + i) <= currentSize && smallestChildIndex <= currentSize &&
                    array[childIndex + i].compareTo(array[smallestChildIndex]) < 0) {
                    smallestChildIndex = childIndex + i;
                }
            }
            
            // Swap 
            if (array[smallestChildIndex].compareTo(temp) < 0) {
                array[holeIndex] = array[smallestChildIndex];
                holeIndex = smallestChildIndex;
            } else {
                break;
            }
        }
        
        // Set hole index to temp
        array[holeIndex] = temp;
    }

    // Find parent index when it's D amount of children
    public int parentIndex(double index) {
        if(index <= 1){
            throw new IllegalArgumentException("Index must be greater than 0");
        }

        double parent = (index - 1) / children;
        parent = Math.ceil(parent);
        return (int)parent;
    }

    // Find first child index when it's D amount of children
    public int firstChildIndex(double index) {
        if(index <= 0){
            throw new IllegalArgumentException("Index must be greater than 0");
        }

        double firstChild = children * (index - 1) + 2;
        firstChild = Math.ceil(firstChild);
        return (int)firstChild;
    }

    // Size method
    public int size() {
        return currentSize;
    }

    // Get method
    public T get(int index) {
        return array[index];
    }
}