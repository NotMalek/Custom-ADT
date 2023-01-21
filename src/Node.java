public class Node {
    private int value, count;
    private Node left, right;
    private String info;


    Node(int value, int count, String info) {
        this.value = value;
        this.count = count;
        this.info = info;
        this.right = null;
        this.left = null;

    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public Node getLeft() {return left;}

    public void setLeft(Node left) {this.left = left;}

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {this.right = right;}

    public String getInfo() {
        return info;
    }

}
