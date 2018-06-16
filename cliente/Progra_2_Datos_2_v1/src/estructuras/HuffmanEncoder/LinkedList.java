package HuffmanEncoder;

/**
 * Singly linked list class.
 *
 * @author Fabián Montero <machetazo>
 * @param <T> value type of the list
 * @version alpha as fuck
 */
public class LinkedList<T> {

    public LinkedListNode<T> head;
    private int size;

    /**
     * Default constructor for this class.
     *
     * All fields are initialized with default values.
     */
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * This constructor initializes the list with values provided by the user.
     *
     * Uses varargs.
     *
     * @param pValues values to be added to the list
     */
    public LinkedList(T... pValues){
        this.head = null;
        this.size = 0;

        add(pValues);
    }

    /**
     * Adds a new node on the bottom of the list.
     *
     * @param pValue value of the node that will be inserted
     */
    public void add(T pValue){
        addOnBottom(pValue);
    }

    /**
     * Adds more than one node at a time to the list.
     *
     * Uses varargs.
     *
     * @param pValues all the values that will be added
     */
    public void add(T... pValues){
        for(T value : pValues){
            add(value);
        }
    }

    /**
     * Adds a new node on the top of the list.
     *
     * @param pValue value of the node that will be inserted
     */
    public void addOnTop(T pValue){
        addOnTop_aux(pValue);
    }
    private void addOnTop_aux(T pValue){
        LinkedListNode<T> temp = new LinkedListNode<T>(pValue , this.getHead());

        this.head = temp;
        this.size++;
    }

    /**
     * Adds a new node on the bottom of the list.
     *
     * @param pValue value of the node that will be inserted
     */
    public void addOnBottom(T pValue){
        addOnBottom_aux(pValue);
    }
    private void addOnBottom_aux(T pValue){
        LinkedListNode<T> temp = new LinkedListNode<T>(pValue , null);
        LinkedListNode<T> ref = this.head;

        if(isEmpty()){
            this.head = temp;
        } else if(this.size < 2){
            this.head.setNext(temp);
        } else{
            while(ref.getNext().getNext() != null){
                ref = ref.getNext();
            }
            ref.getNext().setNext(temp);
        }
        this.size++;
    }

    /**
     * Adds a new node on a certain position of the list.
     *
     * If the position is already occupied, all nodes after that position are
     * moved 1 space to the bottom of the list in order to make space for the
     * new node. If the specified position is less than or equal to 0, the node
     * is added on the top of the list. If the specified position is out of
     * range (larger than the size of the list or any other condition), the node
     * is added on the bottom of the list.
     *
     * @param pValue value of the node that will be inserted
     * @param pPos position in which the node will be inserted
     */
    public void addOnPos(T pValue , int pPos){
        if(isEmpty() || pPos <= 0){
            addOnTop(pValue);
        } else if(indexExists(pPos)){
            addOnPos_aux(pValue , pPos);
        } else {
            addOnBottom(pValue);
        }
    }
    private void addOnPos_aux(T pValue , int pPos){
        LinkedListNode<T> temp = new LinkedListNode<T>(pValue , null);
        LinkedListNode<T> ref = this.head;

        if(pPos == 1){
            temp.setNext(ref.getNext());
            this.head.setNext(temp);
        } else{
            for(int i = 0 ; i < this.size ; i++){
                if(i == pPos - 2){
                    temp.setNext(ref.getNext().getNext());
                    ref.getNext().setNext(temp);
                } else{
                    ref = ref.getNext();
                }
            }
        }
        this.size++;
    }

    /**
     * Deletes the first occurrence of a node that contains a certain value.
     *
     * Checks if list is empty first.
     *
     * @param pValue value of the node that will be deleted
     */
    public void deleteByValue(T pValue){
        if(!isEmpty() && valueExists(pValue)){
            deleteByValue_aux(pValue);
        } else {
            System.out.println("List is empty or value was not found.");
        }
    }
    private void deleteByValue_aux(T pValue){
        LinkedListNode<T> ref = this.head;

        if(this.head.getValue().equals(pValue)){
            this.head = ref.getNext();
        } else if(this.head.getNext().getValue().equals(pValue)){
            this.head.setNext(ref.getNext().getNext());
        } else {
            for(int i = 0 ; i < this.size ; i++){
                if(ref.getNext().getNext().getValue().equals(pValue)){
                    ref.getNext().setNext(ref.getNext().getNext().getNext());
                    this.size--;
                    return;
                } else {
                    ref = ref.getNext();
                }
            }
        }
        this.size--;
    }

    /**
     * Deletes all nodes that contain a certain value.
     *
     * Uses deleteByValue method in a loop.
     *
     * @param pValue value of the nodes that will be deleted
     */
    public void deleteAllValues(T pValue){
        if(!isEmpty() && valueExists(pValue)){
            while(valueExists(pValue)){
                deleteByValue(pValue);
            }
        }
    }

    /**
     * Deletes the node that has the specified index.
     *
     * Checks if list is empty first.
     *
     * @param pIndex index of the node that will be deleted
     */
    public void deleteByIndex(int pIndex){
        if(!isEmpty() && indexExists(pIndex)){
            deleteByIndex_aux(pIndex);
        } else {
            System.out.println("List is empty or index is out of range.");
        }
    }
    private void deleteByIndex_aux(int pIndex){
        LinkedListNode<T> ref = this.head;

        if(pIndex == 0){
            this.head = ref.getNext();
        } else if(pIndex == 1){
            this.head.setNext(ref.getNext().getNext());
        } else {
            for(int i = 0 ; i < this.size ; i++){
                if(i == pIndex - 2){
                    ref.getNext().setNext(ref.getNext().getNext().getNext());
                    this.size--;
                    return;
                } else{
                    ref = ref.getNext();
                }
            }
        }
        this.size--;
    }

    /**
     * Deletes all nodes from the list.
     *
     * Uses the deleteByIndex method.
     */
    public void deleteAll(){
        while(!isEmpty()) {
            for(int i = 0 ; i < this.size ; i++){
                deleteByIndex(0);
            }
        }
    }

    /**
     * Searches the list for a node that contains a certain value.
     *
     * @param pValue value that will be used as a search parameter
     * @return the first occurrence of such node
     */
    public LinkedListNode<T> searchByValue(T pValue){
        if(!isEmpty() && valueExists(pValue)){
            return searchByValue_aux(pValue);
        } else {
            System.out.println("List is empty or value does not exist.");
            return null;
        }
    }
    private LinkedListNode<T> searchByValue_aux(T pValue){
        LinkedListNode<T> ref = this.head;

        if(this.head.getValue().equals(pValue)){
            return this.head;
        } else if(this.head.getNext().getValue().equals(pValue)){
            return this.head.getNext();
        } else{
            for(int i = 0 ; i < this.size ; i++){
                if(ref.getNext().getNext().getValue().equals(pValue)){
                    return ref.getNext().getNext();
                } else{
                    ref = ref.getNext();
                }
            }
            return null;
        }
    }


    /**
     * Searches the list for a node of a certain index.
     *
     * @param pIndex value that will be used as a search parameter
     * @return the node with said index
     */
    public LinkedListNode<T> searchByIndex(int pIndex){
        if(!isEmpty() && indexExists(pIndex)){
            return searchByIndex_aux(pIndex);
        } else {
            System.out.println("List is empty or index is out of range.");
            return null;
        }
    }
    private LinkedListNode<T> searchByIndex_aux(int pIndex){
        LinkedListNode<T> ref = this.head;

        if(pIndex == 0){
            return this.head;
        } else if(pIndex == 1){
            return ref.getNext();
        } else {
            for(int i = 0 ; i < this.size ; i++){
                if(i == pIndex - 2){
                    return ref.getNext().getNext();
                } else{
                    ref = ref.getNext();
                }
            }
            return null;
        }
    }

    /**
     * Changes the value of a node with a certain value to a new value.
     *
     * @param pValue value of the node that will be modified
     * @param pNewValue new value of the node
     */
    public void changeValueFor(T pValue , T pNewValue){
        if(!isEmpty() && valueExists(pValue)){
            changeValueFor_aux(pValue , pNewValue);
        } else {
            System.out.println("List is empty or value does not exist");
        }
    }
    private void changeValueFor_aux(T pPalue , T pNewValue){
        searchByValue(pPalue).setValue(pNewValue);
    }

    /**
     * Changes the value of a node with a certain index to a new value.
     *
     * @param pIndex index of the node that will be modified
     * @param pNewValue new value of the node
     */
    public void changeValueOf(int pIndex , T pNewValue){
        if(!isEmpty() && indexExists(pIndex)){
            changeValueOf_aux(pIndex , pNewValue);
        } else {
            System.out.println("List is empty or index is out of range.");
        }
    }
    private void changeValueOf_aux(int pIndex , T pNewValue){
        searchByIndex(pIndex).setValue(pNewValue);
    }

    /**
     * Checks if a node exists in a list.
     *
     * @return true if it does, false if it doesn't
     */
    public boolean valueExists(T pValue){
        if(!isEmpty()){
            return valueExists_aux(pValue);
        } else {
            System.out.println("List is empty.");
            return false;
        }
    }
    private boolean valueExists_aux(T pValue){
        LinkedListNode<T> ref = this.head;

        for(int i = 0 ; i < this.size ; i++){
            if(ref.getValue().equals(pValue)){
                return true;
            } else {
                ref = ref.getNext();
            }
        }
        return false;
    }

    /**
     * Checks if a list contains a certain index.
     *
     * @return true if it does, false if it doesn't
     */
    public boolean indexExists(int pIndex){
        if(!isEmpty()){
            return indexExists_aux(pIndex);
        } else {
            System.out.println("List is empty.");
            return false;
        }
    }
    private boolean indexExists_aux(int pIndex){
        return (pIndex < this.size && pIndex >= 0);
    }

    /**
     * Checks if head is null. If it is, this implies that the list is empty.
     *
     * @return true if the list is empty, false if its not
     */
    public boolean isEmpty(){
        return (this.head == null);
    }

    /**
     * Prints the whole list.
     */
    public void print(){
        LinkedListNode<T> ref = this.head;

        System.out.println("{");
        for(int i = 0 ; i < this.size ; i++){
            System.out.println(ref.toString());
            ref = ref.getNext();
        }
        System.out.println("}");
    }

    /** getters and setters */

    public LinkedListNode<T> getHead(){
        return this.head;
    }

    public void setHead(LinkedListNode<T> pHead){
        this.head = pHead;
    }

    public int getSize(){
        return this.size;
    }
}
