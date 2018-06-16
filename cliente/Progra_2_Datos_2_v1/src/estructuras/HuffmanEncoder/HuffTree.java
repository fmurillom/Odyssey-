package HuffmanEncoder;

public class HuffTree {

    private int freq;
    private String data;
    private HuffTree left;
    private HuffTree right;

    public HuffTree(int freq, String data, HuffTree left, HuffTree right) {
        this.freq = freq;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public HuffTree(int freq, String data) {
        this.freq = freq;
        this.data = data;
    }

    public HuffTree(){}

    public boolean isLeaf(){
        return (this.right == null && this.left == null);
    }

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
