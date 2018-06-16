package HuffmanEncoder;

import org.json.JSONObject;

public class HuffmanEncoder {

    private String input;
    private HuffTreeList trees = new HuffTreeList();
    private JSONObject result;

    public void start(String input){
        this.input = input;
        int amountOfChars = countFreq();
        buildTree();
        fillTable(amountOfChars);
    }

    private int countFreq(){
        for(int i = 0 ; i < input.length() ; i++){

            String c = input.charAt(i) + "";

            if(!trees.strExists(c)){
                trees.addNode(1 , c);
            } else {
                trees.searchStr(c).getValue().setFreq(
                        trees.searchStr(c).getValue().getFreq() + 1
                );
            }
        }

        Console.write_("Characters counted:", Res.ANSI_BLUE);
        trees.print();

        return trees.getSize();
    }

    private void buildTree(){

        int counter = 1;

        while(trees.getSize() > 1) {
            Tuple<HuffTree> min2 = trees.getMin2();

            HuffTree tempL = min2.first;        //crea arbol izquierdo
            HuffTree tempR = min2.second;       //crea arbol derecho
            HuffTree temp = new HuffTree();     //crea arbol papa

            temp.setFreq(tempL.getFreq() + tempR.getFreq());    //añade frecuencia al papa
            temp.setData("n" + counter);                        //añade nombre al papa
            temp.setLeft(tempL);            //añade hijo izquierdo
            temp.setRight(tempR);           //añade hijo derecho
            counter++;                      //aumenta el contador

            trees.deleteByValue(tempL);       //elimina arb
            trees.deleteByValue(tempR);

            trees.add(temp);

            System.out.println("----------------------");
            trees.print();
        }
        Console.write_("Tree constructed", Res.ANSI_BLUE);
    }

    private void fillTable(int stopValue){
        HuffTree huffmanTree = trees.searchByIndex(0).getValue();
        int hits = 0;
        JSONObject table = new JSONObject();

        while(hits < stopValue){
            HuffTree ref = huffmanTree;
            String code = "";
            HuffTree parent = ref;

            while(!(ref.isLeaf()) ){

                while(ref.hasLeft()){
                    parent = ref;
                    ref = ref.getLeft();
                    code = code + "0";
                }

                while(ref.hasRight()){
                    parent = ref;
                    ref = ref.getRight();
                    code = code + "1";
                }
            }

            table.put(ref.getData(), code);
            hits++;
            if(code.endsWith("0")){
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            System.out.println(hits);

        }

        System.out.println(table);
    }

    public static void main(String[] args) {
        HuffmanEncoder test = new HuffmanEncoder();

        test.start("aabbcvvvvvvbxxx");
    }
}
