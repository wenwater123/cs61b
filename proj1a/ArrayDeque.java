public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity = 8;
    private final int bigRFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public void addFirst(T item) {
        if (isfull()) {
            resize(capacity * bigRFACTOR);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;

    }

    public void addLast(T item) {
        if (isfull()) {
            resize(capacity * bigRFACTOR);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isfull() {
        return size == capacity - 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = nextFirst; i < nextLast; i = (i + 1) / capacity) {
            if (i == nextLast - 1) {
                System.out.print(items[i]);
                break;
            }
            System.out.print(items[i] + "");
        }
    }

    public T removeFirst() {
        double radio = capacity / size;
        if (radio < 0.25) {
            resize(capacity / 2);
        }
        if (isEmpty()) {
            return null;
        }
        T res = items[(nextLast - 1 + items.length) % capacity];
        nextLast = (nextLast - 1 + items.length) % capacity;
        size--;
        return res;
    }

    public T removeLast() {
        double radio = capacity / size;
        if (radio < 0.25) {
            resize(capacity / 2);
        }
        if (isEmpty()) {
            return null;
        }
        T res = items[(nextFirst + 1) % capacity];
        nextLast = (nextFirst - 1 + items.length) % capacity;
        size--;
        return res;
    }

    public T get(int index) {
        if (size < index || index < 0 || isEmpty()) {
            return null;
        }
        return items[(nextFirst + index + 1) % capacity];
    }


    private void resize(int newSize) {
        T[] newitem = (T[]) new Object[newSize];

        if (nextLast > nextFirst) {
            int length = nextLast - nextFirst - 1;
            System.arraycopy(items, nextFirst + 1, newitem, 1, length);
            nextFirst = 0;
            nextLast = length;
        } else {
            int length1 = capacity - nextFirst - 1;
            int length2 = nextLast;
            System.arraycopy(items, nextFirst + 1, newitem, 1, length1);
            System.arraycopy(items, 0, newitem, length1 + 1, length2);
            nextLast = length1 + length2;
            nextFirst = 0;
        }
        capacity = newSize;
        items = newitem;
    }


}
