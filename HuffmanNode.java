public class HuffmanNode {
    int freq;
    char character;
    HuffmanNode left, right;
    HuffmanNode(int freq, char character){
        this.freq = freq;
        this.character = character;
        this.left = this.right = null;
    }
}
