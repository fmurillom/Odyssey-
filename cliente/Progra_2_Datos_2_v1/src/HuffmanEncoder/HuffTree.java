package HuffmanEncoder;

/**
 * Huffman Tree class
 */
public class HuffTree {

    private int freq;
    private String data;
    private HuffTree left;
    private HuffTree right;

    /**
     * Constructor of the class
     *
     * @param freq freq of the node
     * @param data char in the node
     * @param left lift child
     * @param right right child
     */
    public HuffTree(int freq, String data, HuffTree left, HuffTree right) {
        this.freq = freq;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Simple constructor
     *
     * @param freq freq of the node
     * @param data char of the node
     */
    public HuffTree(int freq, String data) {
        this.freq = freq;
        this.data = data;
    }

    /**
     * EMpty constructor
     */
    public HuffTree(){}

    /**
     * Checks if this node is a leaf
     *
     * @return true or false
     */
    public boolean isLeaf(){
        return (this.right == null && this.left == null);
    }

    /** getters and setters */
    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HuffTree getLeft() {
        return left;
    }

    public void setLeft(HuffTree left) {
        this.left = left;
    }

    public HuffTree getRight() {
        return right;
    }

    public void setRight(HuffTree right) {
        this.right = right;
    }

    public boolean isMidNode(){
        return (getData().length() > 1);
    }

    public boolean hasLeft(){
        return (this.left != null);
    }

    public boolean hasRight(){
        return (this.right != null);
    }
}
