public class QueueNode {
    public Node data;
    public QueueNode next;

    public QueueNode(Node data, QueueNode pre){
        this.data = data;
        this.next = null;
        if (pre != null)
            pre.next = this;
    }
}