package algorithms.huffman_coding;

import java.util.HashMap;

public class HuffmanEncodingTable extends HashMap<Character, String> {
    public void calculateEncodingTable(HuffmanTreeNode currentNode, StringBuilder currentCode) {
        HuffmanTreeNode leftChild = currentNode.getLeft();
        HuffmanTreeNode rightChild = currentNode.getRight();
        if (leftChild != null) {
            currentCode.append("0");
            calculateEncodingTable(leftChild, currentCode);
            currentCode.setLength(currentCode.length() - 1);
        }
        if (rightChild != null) {
            currentCode.append("1");
            calculateEncodingTable(rightChild, currentCode);
            currentCode.setLength(currentCode.length() - 1);
        }
        if (rightChild == null && leftChild == null) {
            put(currentNode.getSymbol(), currentCode.toString());
        }
    }
}
