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
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
        if (isfull()) {
            int newcap = capacity * bigRFACTOR;
            resize(newcap);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
        if (isfull()) {
            int newcap = capacity * bigRFACTOR;
            resize(newcap);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isfull() {
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
        if (isEmpty()) {
            return null;
        }
        T res = items[(nextFirst + 1) % capacity];
        items[(nextFirst + 1) % capacity] = null;
        nextFirst = (nextFirst + 1 + items.length) % capacity;
        size--;
        double radio = size / capacity;
        if (capacity > 16 && radio < 0.25) {
            int newcapcity = capacity / 2;
            resize(newcapcity);
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = items[(nextLast - 1 + items.length) % capacity];
        items[(nextLast - 1 + items.length) % capacity] = null;
        nextLast = (nextLast - 1 + items.length) % capacity;
        size--;
        double radio = size / capacity;
        if (capacity > 16 && radio < 0.25) {
            int newcapcity = capacity / 2;
            resize(newcapcity);
        }
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
            nextLast = length+1;
        } else {
            int length1 = capacity - nextFirst - 1;
            int length2 = nextLast;
            System.arraycopy(items, nextFirst + 1, newitem, 1, length1);
            System.arraycopy(items, 0, newitem, length1 + 1, length2);
            nextLast = length1 + length2+1;
            nextFirst = 0;
        }
        capacity = newSize;
        items = newitem;
    }


}
