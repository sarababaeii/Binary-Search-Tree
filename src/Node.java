public class Node {
    public int data;
    public Node rightChild;
    public Node leftChild;
    private Node parent;
    public int depth;

    public Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
        if (parent == null)
            depth = 0;
        else
            depth = parent.depth + 1;
        rightChild = null;
        leftChild = null;
    }

    public void add(int data, Node parent) {
        if (this.data < data) {
            if (rightChild == null) {
                rightChild = new Node(data, parent); //added
            }
            else
                rightChild.add(data, rightChild); //recursive
        }
        if (this.data > data) {
            if (leftChild == null) {
                leftChild = new Node(data, parent); //added
            }
            else
                leftChild.add(data, leftChild); //recursive
        }
    }

    public void delete() {
        if (rightChild == null && leftChild == null) { //without child
            if (parent.data < data)
                parent.rightChild = null;
            else
                parent.leftChild = null;
        }
        else if (rightChild != null && leftChild == null) { //with one child
            if (parent.data < data)
                parent.rightChild = rightChild;
            else
                parent.leftChild = rightChild;
            rightChild.parent = parent;
            rightChild.refreshDepth();
        } //the child becomes successor
        else if (rightChild == null && leftChild != null) { //with one child
            if (parent.data < data)
                parent.rightChild = leftChild;
            else
                parent.leftChild = leftChild;
            leftChild.parent = parent;
            leftChild.refreshDepth();
        } //the child becomes successor
        else { //with tow children
            Node min = rightChild.findMin();
            data = min.data;
            min.parent.leftChild = null;
        } //the minimum node of right subtree becomes successor
    }

    public Node search(int data) {
        if (this.data == data)
            return this; //found
        if (this.data < data && rightChild != null)
            return rightChild.search(data); //recursive
        if (this.data > data && leftChild != null)
            return leftChild.search(data); //recursive
        return null; //does not exist
    }

    public void printInOrder() {
        if (leftChild != null)
            leftChild.printInOrder(); //recursive
        System.out.print(data + " ");
        if (rightChild != null)
            rightChild.printInOrder(); //recursive
    }

    private void refreshDepth() {
        if (parent == null)
            depth = 0;
        else
            depth = parent.depth + 1;
        if (rightChild != null)
            rightChild.refreshDepth();
        if (leftChild != null)
            leftChild.refreshDepth();
    }

    private Node findMin() {
        if (leftChild == null)
            return this;
        return leftChild.findMin();
    }
}