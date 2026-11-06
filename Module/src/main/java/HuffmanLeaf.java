public record HuffmanLeaf (int freq, int charASCII) implements HuffmanTree{
//WHAT ARE WE DOING
    @Override
    public boolean comesBefore(HuffmanTree other) {
        if(this.freq == other.freq()) {
            if (this.charASCII < other.charASCII()) {
                return true;
            } else if (other.charASCII() < this.charASCII) {
                return false;
            } else {
                throw new IllegalArgumentException("Duplicate characters detected");
            }
        }else{
            return this.freq < other.freq();
        }
    }

    @Override
    public HuffmanTree combine(HuffmanTree other) {
        if(this.comesBefore(other) && this.charASCII < other.charASCII()){
            return new HuffmanNode(this.charASCII,this.freq + other.freq(), this, other);
        }else if(this.comesBefore(other) && other.charASCII() < this.charASCII){
            return new HuffmanNode(other.charASCII(),this.freq + other.freq(), this, other);

        }else if(this.comesBefore(other) && this.charASCII < other.charASCII()){
            return new HuffmanNode(this.charASCII,this.freq + other.freq(), other,this);
        }else if(this.comesBefore(other) && other.charASCII() < this.charASCII){
            return new HuffmanNode(other.charASCII(),this.freq + other.freq(), other,this);
        }else{
            throw new IllegalArgumentException("Combining issue");
        }
    }

    @Override
    public int compareTo(HuffmanTree other) {
        if (this.comesBefore(other)) return -1;
        if (other.comesBefore(this)) return 1;
        return 0;
    }
}
