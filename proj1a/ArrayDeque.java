public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int bigRFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
        if (isfull()) {
            int newcap = size * bigRFACTOR;
            resize(newcap);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
        if (isfull()) {
            int newcap = size * bigRFACTOR;
            resize(newcap);
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private boolean isfull() {
        if (size == items.length-3) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = nextFirst; i < nextLast; i = (i + 1) / items.length) {
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
        T res = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1 ) % items.length;
        size--;
        if (items.length > 16 && size < (items.length / 4)) {
            int newcapcity = items.length / 2;
            resize(newcapcity);
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size--;
        if (items.length > 16 && size < (items.length / 4)) {
            int newcapcity = items.length / 2;
            resize(newcapcity);
        }
        return res;
    }

    public T get(int index) {
        if (size <= index ) {
            return null;
        }
        return items[(nextFirst + index + 1) % items.length];
    }


    private void resize(int newSize) {
        T[] newitem = (T[]) new Object[newSize];

        if (nextLast > nextFirst) {
            int length = nextLast - nextFirst - 1;
            System.arraycopy(items, nextFirst + 1, newitem, 1, length);
            nextFirst = 0;
            nextLast = length+1;
        } else {
            int length1 = items.length - nextFirst - 1;
            int length2 = nextLast;
            System.arraycopy(items, nextFirst + 1, newitem, 1, length1);
            System.arraycopy(items, 0, newitem, length1 + 1, length2);
            nextLast = length1 + length2+1;
            nextFirst = 0;
        }
        items = newitem;
    }
//    public static void main(String[] args) {
//        ArrayDeque a = new ArrayDeque();
//        a.addFirst(0);
//        a.addFirst(1);
//        a.addLast(2);
//        a.addFirst(3);
//        a.addLast(4);
//        a.removeLast();
//        a.get(3);
//        a.addLast(7);
//        a.get(0);
//        a.addLast(9);
//        a.removeFirst();
//        a.addLast(11);
//        a.removeFirst();
//        a.addLast(13);
//        a.addFirst(14);
//        a.addFirst(15);
//        a.addFirst(66);
//        System.out.print(a.size);
////        a.printDeque();
//        System.out.print(a.removeFirst());
//    }
}


