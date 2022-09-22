public class Queue {
    public QueueNode first;
    private QueueNode last;

    public Queue(){}
    public void push(Node data) {
        if (first == null) {
            first = new QueueNode(data, null);
            last = first;
            return;
        }
        last.next = new QueueNode(data, last);
        last = last.next;
    }
    public Node pop() {
        QueueNode q = first;
        first = first.next;
        return q.data;
    }
    public void print() {
        for (QueueNode i = first; i != null; i = i.next){
            System.out.print(i.data.data + " ");
            if (i.next != null && i.data.depth != i.next.data.depth)
                System.out.println();
        }
        System.out.println();
    }
}
//methods: push, pop, print