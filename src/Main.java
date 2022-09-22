public class Main {

    public static Queue q = new Queue();
    public static Queue bfsNodes = new Queue();

    public static void main(String[] args) {
        BST b = new BST(10);
        int[] a = {5, 7, 15, 12, 6, 3, 1, 20, 16, 13};
        for (int i = 0; i < a.length; i++) {
            b.add(a[i]);
        }
        b.print(); //in order print
        System.out.println();

        BFS(b.root);
        bfsNodes.print();
    }
    private static void BFS(Node root){
        bfsNodes.push(root);
        if (root.leftChild != null)
            q.push(root.leftChild);
        if (root.rightChild != null)
            q.push(root.rightChild);
        if (q.first != null)
            BFS(q.pop()); //recursive
    }
}