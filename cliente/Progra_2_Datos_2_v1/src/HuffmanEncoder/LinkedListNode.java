package HuffmanEncoder;

/**
 * Singly Linked List node class.
 *
 * @author Fabian Montero <machetazo>
 * @param <T> data dataype of the value of the node
 * @version alpha as fuck
 */
public class LinkedListNode<T> {

    private T value;
    private LinkedListNode<T> next;

    /**
     * Constructor takes all arguments and initializes.
     *
     * @param pValue value of the node
     * @param pNext reference to next node
     */
    public LinkedListNode(T pValue, LinkedListNode<T> pNext){
        this.value = pValue;
        this.next = pNext;
    }

    /**
     * Constructor doesn't take the value argument and sets that field to default value (null)
     *
     * @param pNext reference to next node
     */
    public LinkedListNode(LinkedListNode<T> pNext){
        this.value = null;
        this.next = pNext;
    }

    /**
     * Returns a string representation of the node.
     *
     * @return string representation of the value
     */
    @Override
    public String toString(){
        return this.value.toString();
    }

    /** getters and setters */

    public T getValue(){
        return value;
    }

    public void setValue(T pValue){
        this.value = pValue;
    }

    public LinkedListNode<T> getNext(){
        return next;
    }

    public void setNext(LinkedListNode<T> pNext){
        this.next = pNext;
    }
}
