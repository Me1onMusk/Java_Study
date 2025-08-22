package mid2.collection.link;

public class Node<E> {

    public E item;
    public Node<E> next;

    public Node(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> x = this;
        sb.append("[ ");
        while (x != null) {
            sb.append(x.item);
            if (x.next != null)
                sb.append("->");
            x = x.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
