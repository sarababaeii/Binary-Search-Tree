public class BST {
    public Node root;

    public BST(int rootData){
        root = new Node(rootData, null);
    }
    public void add(int data){
        root.add(data, root);
    }
    public void delete(int data){
        Node node = search(data);
        if (node != null)
            node.delete();
        else
            System.out.println("Error");
    }
    public Node search(int data){
        return root.search(data);
    }
    public void print(){
        root.printInOrder();
        System.out.println();
    }
}
//methods: constructor, add, delete, search, print in order