package algorithms.huffman_coding.decoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int differentSymbolsNumber = scanner.nextInt();
        int encodedMessageLength = scanner.nextInt();
        Map<String, Character> decodingTable = new HashMap<>();
        for (int i = 0; i < differentSymbolsNumber; i++) {
            char symbol = scanner.next().charAt(0);
            String code = scanner.next();
            decodingTable.put(code, symbol);
        }
        String encodedMessage = scanner.next();
        if (encodedMessage.length() > encodedMessageLength) {
            encodedMessage = encodedMessage.substring(0, encodedMessageLength - 1);
        }

        String decodedMessage = decodeMessage(encodedMessage, decodingTable);
        System.out.println(decodedMessage);
    }

    private String decodeMessage(String encodedMessage, Map<String, Character> decodingTable) {
        StringBuilder decodedMessageBuilder = new StringBuilder();
        StringBuilder currentCodeBuilder = new StringBuilder();
        for (int i = 0; i < encodedMessage.length(); i++) {
            currentCodeBuilder.append(encodedMessage.charAt(i));
            Character symbol = decodingTable.get(currentCodeBuilder.toString());
            if (symbol != null) {
                decodedMessageBuilder.append(symbol);
                currentCodeBuilder.setLength(0);
            }
        }
        return decodedMessageBuilder.toString();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
