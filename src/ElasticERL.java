public class ElasticERL {
    private int size;
    Node root;
    int count;
    int max;

    public ElasticERL() {
        count = 0;
    }

    public void SetEINThreshold(int size){
        this.max = size;
    }

    public void generate(String info){

        int min = 0;
        int max = 99999999;

        while (true){
            int key = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (!containsNode(key)) {
                System.out.print("Generated key: ");
                System.out.println(converter.fillZero(key));
                add(Integer.parseInt(converter.fillZero(key)), info);
                System.out.println("Successfully added.");
                break;
            }
        }

    }

    public void allKeys() {printRecursive(root);}


    //    post-order traversal
    private void printRecursive(Node current) {

        if (current == null)
            return;

        System.out.println(converter.fillZero(current.getValue()) + current.getInfo());

        printRecursive(current.getLeft());

        printRecursive(current.getRight());

    }


    public void add(int value, String info) {
        if (count + 1 > max)
            System.out.println("Maximum number of elements reached, delete an element to add another one.");
        else
            root = addRecursive(root, value, info);}

    private Node addRecursive(Node current, int value, String info) {
        if (current == null) {
            count++;
            return new Node(value, count, info);
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value, info));

        }
        else  {
            current.setRight(addRecursive(current.getRight(), value, info));

        }

        return current;
    }

    public void remove(int key) {
        max++;
        root = removeRecursive(root, key);}

    private Node removeRecursive(Node current, int key) {

        if (current == null)
            return null;

        if (key == current.getValue()){

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

        }


        if (key < current.getValue()) {
            current.setLeft(removeRecursive(current.getLeft(), key));
            return current;
        }
        current.setRight(removeRecursive(current.getRight(), key));
        return current;
    }


    public void getValues(int key) {getValuesRecursive(root, key);}

    private void getValuesRecursive(Node current, int key) {
        if (current != null) {
            if (current.getValue() == key){
                System.out.println(current.getInfo());
            }

            getValuesRecursive(current.getLeft(), key);

            getValuesRecursive(current.getRight(), key);
        }
    }


    public void find(int value) {System.out.println(findRecursive(root, value));}

    private int findRecursive(Node current, int value){

        if (current == null || current.getValue() == value)
            return current.getCount();

        if (current.getValue() > value)
            return findRecursive(current.getLeft(), value);

        return findRecursive(current.getRight(), value);
    }


    public boolean containsNode(int value) {return containsNodeRecursive(root, value);}

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null)
            return false;

        if (value == current.getValue())
            return true;

        return value < current.getValue() ?
                containsNodeRecursive(current.getLeft(), value) : containsNodeRecursive(current.getRight(), value);
    }



    public void nextKey(int key){
        nextKeyRecursive(root, findRecursive(root, key));
    }

    private void nextKeyRecursive(Node current, int key) {
        if (current == null)
        return;
            if (current.getCount() == key + 1) {
                System.out.println(converter.fillZero(current.getValue()));
                return;
            }

            nextKeyRecursive(current.getLeft(), key);
            nextKeyRecursive(current.getRight(), key);

    }

    public void prevKey(int key){
        prevKeyRecursive(root, findRecursive(root, key));
    }

    private void prevKeyRecursive(Node current, int key) {
        if (current == null)
            return;
        if (current.getCount() == key - 1) {
            System.out.println(converter.fillZero(current.getValue()));
            return;
        }

        prevKeyRecursive(current.getLeft(), key);
        prevKeyRecursive(current.getRight(), key);
    }

    public void rangeKey(int key1, int key2){

       int range = Math.abs(findRecursive(root, key1) - findRecursive(root, key2)) - 1;
       System.out.println(range);

    }


}
