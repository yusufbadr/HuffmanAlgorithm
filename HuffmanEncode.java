import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncode {

    public static class HuffmanComparator implements Comparator<HuffmanNode>{

        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            return node1.freq - node2.freq;
        }
    }

    //building a frequency map
    public static Map<Character, Integer> buildFrequencyMap(String text){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c,  0) + 1);
        }

        return frequencyMap;
    }

    // building a huffman tree
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap){
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new HuffmanComparator());

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size()>1){
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();

            assert y != null;

            HuffmanNode newNode = new HuffmanNode(x.freq + y.freq, '*');
            newNode.left = x;
            newNode.right = y;

            priorityQueue.add(newNode);
        }

        // returning the root of the priority queue
        return priorityQueue.poll();
    }

    public static void buildHuffmanCodesRecursive(HuffmanNode root, String code, Map<Character, String> huffmanCodes){
        if (root == null)
            return;

        // base case: leaf node
        if (root.character!='*'){
            huffmanCodes.put(root.character, code);
        }

        buildHuffmanCodesRecursive(root.left, code + "0", huffmanCodes);
        buildHuffmanCodesRecursive(root.right, code + "1", huffmanCodes);

    }

    public static Map<Character, String> buildHuffmanCodes(HuffmanNode root){
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodesRecursive(root, "", huffmanCodes);
        return huffmanCodes;
    }

    public static Object[] encodeHelper(Map<Character, String> huffmanCodes, String text){
        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()){
            encodedString.append(huffmanCodes.get(c));
        }

        return new Object[]{huffmanCodes, encodedString.toString()};
    }
    public static Object[] encode(String text){
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        HuffmanNode root = buildHuffmanTree(frequencyMap);
        Map<Character, String> huffmanCodes = buildHuffmanCodes(root);
        return encodeHelper(huffmanCodes, text);
    }
}
