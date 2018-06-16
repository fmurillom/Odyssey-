package HuffmanEncoder;

public class HuffTreeList extends LinkedList<HuffTree> {

    public Tuple<HuffTree> getMin2(){
        if(this.getSize() == 2){
//            Console.write("Default min values returned." , Res.ANSI_BLUE);

            return new Tuple<HuffTree>(super.searchByIndex(0).getValue(),
                    super.searchByIndex(1).getValue());
        }

        HuffTree min1 = null;
        HuffTree min2 = null;

        LinkedListNode<HuffTree> ref = this.head;
        while ((ref = ref.getNext()) != null) {
            if (min1 == null || min1.getFreq() > ref.getValue().getFreq()) {
                min1 = ref.getValue();
            }
        }

        LinkedListNode<HuffTree> ref2 = this.head;
        while ((ref2 = ref2.getNext()) != null) {
            if (min2 == null || (min2.getFreq() > ref2.getValue().getFreq())){
                if(!ref2.getValue().getData().equals(min1.getData())) {
                    min2 = ref2.getValue();
                }
            }
        }

//        Console.write("Min values found: " , Res.ANSI_BLUE);
//        System.out.print(min1.getData());
//        System.out.print("=");
//        System.out.print(min1.getFreq());
//        System.out.print(" , ");
//        System.out.print(min2.getData());
//        System.out.print("=");
//        System.out.println(min2.getFreq());

        return new Tuple<>(min1, min2);
    }

    public boolean strExists(String c){
        LinkedListNode<HuffTree> ref = this.head;

        for(int i = 0 ; i < super.getSize() ; i++){
            if(ref.getValue().getData().equals(c)){
                return true;
            } else {
                ref = ref.getNext();
            }
        }
        return false;
    }

    public void addNode(int freq, String data){
        HuffTree temp = new HuffTree(freq, data);

        super.add(temp);
    }

    public LinkedListNode<HuffTree> searchStr(String c){
        LinkedListNode<HuffTree> ref = this.head;

        if(this.head.getValue().getData().equals(c)){
            return this.head;
        } else if(this.head.getNext().getValue().getData().equals(c)){
            return this.head.getNext();
        } else{
            for(int i = 0 ; i < this.getSize() ; i++){
                if(ref.getNext().getNext().getValue().getData().equals(c)){
                    return ref.getNext().getNext();
                } else{
                    ref = ref.getNext();
                }
            }
            return null;
        }
    }

    public void print(){
        LinkedListNode<HuffTree> ref = this.head;

        System.out.println("{");
        for(int i = 0 ; i < this.getSize() ; i++){
            System.out.print("\t" + ref.getValue().getData());
            System.out.print(" = ");
            System.out.println(ref.getValue().getFreq());
            ref = ref.getNext();
        }
        System.out.println("}");
    }



}