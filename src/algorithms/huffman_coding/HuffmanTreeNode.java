package algorithms.huffman_coding;

public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>  {
    private Integer frequency;
    private Character symbol;
    private HuffmanTreeNode parent;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;

    public HuffmanTreeNode(Character symbol, Integer frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public HuffmanTreeNode(HuffmanTreeNode left, HuffmanTreeNode right) {
        this.left = left;
        this.right = right;
        frequency = left.frequency;
        left.parent = this;
        if (right != null) {
            frequency += right.frequency;
            right.parent = this;
        }
    }

    public Character getSymbol() {
        return symbol;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public HuffmanTreeNode getLeft() {
        return left;
    }

    public HuffmanTreeNode getRight() {
        return right;
    }

    public int compareTo(HuffmanTreeNode huffmanTreeNode) {
        return frequency.compareTo(huffmanTreeNode.frequency);
    }
}
