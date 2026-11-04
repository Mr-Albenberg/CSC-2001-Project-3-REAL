public class List implements HQueue{


    private HuffmanTree[] items;
    private int size;

    public List() {
        this.items = new HuffmanTree[26];
        this.size = 0;
    }

    public HuffmanNode newQueue() {
        return new List();
    }
    /**
     * return true if the queue is empty
     */
    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }


    public int count(){
        return this.size;
    }

    /**
     * enqueue a true
     */
    public void enqueue(HuffmanTree tree){


        this.size++;
    }

    /**
     * dequeue and return the highest-priority tree
     */
    public HuffmanTree dequeue();

}