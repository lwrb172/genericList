import java.util.AbstractList;

public class CustomList<T> extends AbstractList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if(head == null) {
            return null;
        } else {
            T temp = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return temp;
        }
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        } else if (head == tail) {
            T temp = tail.value;
            head = tail = null;
            size--;
            return temp;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            T temp = tail.value;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    public T getLast() {
        return tail != null ? tail.value : null;
    }

    public T getFirst() {
        return head == null ? null : head.value;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; ++i) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return size;
    }

}
