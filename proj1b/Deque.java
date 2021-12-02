public interface Deque<T> {
    public void addFirst(T item);

    public void addLast(T item);

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public boolean isEmpty();

    public int size();

    public T getRecursive(int index);

}
