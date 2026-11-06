public class List implements HQueue{


    private HuffmanTree[] items;
    private int size;

    public List() {
        this.items = new HuffmanTree[256];
        this.size = 0;
    }
    /*
    public HuffmanNode newQueue() {
        return new List();
    }
    */
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
        this.items[this.size] = tree;
        this.size++;

        HuffmanTree fuck;
        for(int i = 0; i < this.size; i++){
            for(int j = i; j > 0 && this.items[j].compareTo(this.items[j-1]) < 0; j--){
                fuck = this.items[j];
                this.items[j] = this.items[j-1];
                this.items[j-1] = fuck;
            }
        }
    }

    /**
     * dequeue and return the highest-priority tree
     */
    public HuffmanTree dequeue(){
        HuffmanTree pull = this.items[0];
        for(int i = 0; i < this.size; i++){
            this.items[i] = this.items[i+1];
        }
        this.size--;
        return pull;
    }

}