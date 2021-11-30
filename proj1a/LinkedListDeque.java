public class LinkedListDeque<T> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode pre;
        public T item;
        public IntNode next;

        public IntNode(LinkedListDeque<T>.IntNode pre, T item, LinkedListDeque<T>.IntNode next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        sentinel = new IntNode(null, (T) new Object(), null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    //    public LinkedListDeque(T item){
//        sentinel = new IntNode(null,(T)new Object(),null);
//        sentinel.next = new IntNode(sentinel,item,null);
//        size=1;
//
//    }
    public void addFirst(T item) {
        IntNode newnode = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.pre = newnode;
        sentinel.next = newnode;
        size += 1;
    }

    public void addLast(T item) {
        IntNode newnode = new IntNode(sentinel.pre, item, sentinel);
        sentinel.pre.next = newnode;
        sentinel.pre = newnode;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (IntNode p = sentinel.next; p.next == sentinel; p = p.next) {
            if (p.next == p) {
                System.out.print(p.item);
                break;
            }
            System.out.print(p.item + "");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size--;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size--;
        return res;
    }

    public T get(int index) {
        if (size < index || index < 0 || isEmpty()) {
            return null;
        }
        IntNode p = sentinel.next;
        for (int i = 0; i < index; p = p.next) {
            i=i+1;
        }
        return p.item;

    }

    public T getRecursive(int index) {
        if (size < index || index < 0 || isEmpty()) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    public T getRecursive(LinkedListDeque<T>.IntNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursive(node.next, index-1);
    }

}
