package algorithms.huffman_coding.encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import algorithms.huffman_coding.HuffmanTreeNode;
import algorithms.huffman_coding.HuffmanEncodingTable;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        String sourceString = scanner.next();
        Map<Character, Integer> symbolsCounter = new HashMap<>();
        for (int i = 0; i < sourceString.length(); i++) {
            if (!symbolsCounter.containsKey(sourceString.charAt(i))) {
                symbolsCounter.put(sourceString.charAt(i), 1);
                continue;
            }
            int previousValue = symbolsCounter.get(sourceString.charAt(i));
            symbolsCounter.put(sourceString.charAt(i), previousValue + 1);
        }
        int symbolsNumber = symbolsCounter.size();

        HuffmanEncodingTable encodingTable = calcEncodingTable(symbolsCounter);

        StringBuilder encodedMessageBuilder = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            encodedMessageBuilder.append(encodingTable.get(sourceString.charAt(i)));
        }
        System.out.println(String.format("%d %d", symbolsNumber, encodedMessageBuilder.length()));
        for (char symbol : encodingTable.keySet()) {
            System.out.println(String.format("%c: %s", symbol, encodingTable.get(symbol)));
        }
        System.out.println(encodedMessageBuilder.toString());
    }

    private HuffmanEncodingTable calcEncodingTable(Map<Character, Integer> symbolsCounter) {
        PriorityQueue<HuffmanTreeNode> frequencyQueue = new PriorityQueue<>();
        for (char key : symbolsCounter.keySet()) {
            HuffmanTreeNode item = new HuffmanTreeNode(key, symbolsCounter.get(key));
            frequencyQueue.add(item);
        }
        HuffmanTreeNode firstHuffmanTreeNode = frequencyQueue.remove();
        HuffmanTreeNode secondHuffmanTreeNode = null;
        if (!frequencyQueue.isEmpty()) {
            secondHuffmanTreeNode = frequencyQueue.remove();
        }
        frequencyQueue.add(new HuffmanTreeNode(firstHuffmanTreeNode, secondHuffmanTreeNode));
        while (frequencyQueue.size() > 1) {
            HuffmanTreeNode leftChild = frequencyQueue.remove();
            HuffmanTreeNode rightChild = frequencyQueue.remove();
            frequencyQueue.add(new HuffmanTreeNode(leftChild, rightChild));
        }

        HuffmanTreeNode currentHuffmanTreeNode = frequencyQueue.remove();
        HuffmanEncodingTable encodingTable = new HuffmanEncodingTable();
        encodingTable.calculateEncodingTable(currentHuffmanTreeNode, new StringBuilder());
        return encodingTable;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
