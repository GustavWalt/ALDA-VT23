// Gustav Walter guwa7932
// Samarbetat med Bill Rosander bijo4628

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoder {

	// Encode metod, som tar en sträng och returnerar en EncodedMessage
	public EncodedMessage<?, ?> encode(String input) {
		HashMap<Character, Integer> charFrequencies = getStringFrequencies(input);

		Node treeRoot = buildTree(charFrequencies);

		HashMap<Character, String> characterEncodings = generateEncodingMap(treeRoot, new StringBuilder());

		StringBuilder encodedMessage = new StringBuilder();
		for (char c : input.toCharArray()) {
			encodedMessage.append(characterEncodings.get(c));
		}

		return new EncodedMessage<>(generateHeader(characterEncodings, charFrequencies), encodedMessage);
	}

	// Decode metod, som tar en EncodedMessage och returnerar en sträng
	public String decode(EncodedMessage<?, ?> input) {
		String encodedMessage = input.message.toString();

		HashMap<Character, Integer> frequencies = getEncodedMsgFrequencies(input);

		Node treeRoot = buildTree(frequencies);
		HashMap<Character, String> encodingMap = generateEncodingMap(treeRoot, new StringBuilder());

		return traverseDecode(encodingMap, encodedMessage);
	}

	// Metod för att traversera trädet och dekodera meddelandet, returnerar en sträng
	private String traverseDecode(HashMap<Character, String> encodingMap, String encodedMessage) {
		StringBuilder decodedMessage = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (char c : encodedMessage.toCharArray()) {
			sb.append(c);

			if (encodingMap.containsValue(sb.toString())) {
				for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
					if (entry.getValue().equals(sb.toString())) {
						decodedMessage.append(entry.getKey());
						sb = new StringBuilder();
					}
				}
			}
		}
		return decodedMessage.toString();
	}

	// Metod för att hämta frekvenserna från en EncodedMessage
	private HashMap<Character, Integer> getEncodedMsgFrequencies(EncodedMessage input) {
		HashMap<Character, Integer> frequencies = new HashMap<>();
		String msgHeader = input.header.toString();
		for (String s : msgHeader.split("¤")) {
			char c = s.split("£")[0].toCharArray()[0];
			int i = Integer.parseInt(s.split("£")[1]);
			frequencies.put(c, i);
		}
		return frequencies;
	}

	// Metod för att hämta frekvenserna från en sträng
	private HashMap<Character, Integer> getStringFrequencies(String input) {
		HashMap<Character, Integer> frequencies = new HashMap<>();
		for (char c : input.toCharArray()) {
			frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
		}
		return frequencies;
	}

	// Metod för att bygga trädet
	private Node buildTree(HashMap<Character, Integer> frequencies) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
			pq.offer(new Node(entry.getKey(), entry.getValue()));
		}

		while (pq.size() > 1) {
			Node firstNode = pq.poll();
			Node secondNode = pq.poll();

			pq.offer(new Node('\0', firstNode.freq + secondNode.freq, firstNode, secondNode));
		}

		return pq.poll();
	}

	// Metod för att generera header
	private String generateHeader(HashMap<Character, String> encodingMap, HashMap<Character, Integer> frequencies) {
		StringBuilder header = new StringBuilder();
		for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
			header.append(entry.getKey()).append('£').append(frequencies.get(entry.getKey())).append('¤');
		}
		return header.toString();
	}

	// Metod för att generera encodingMap
	private HashMap<Character, String> generateEncodingMap(Node node, StringBuilder sb) {
		HashMap<Character, String> encodingMap = new HashMap<>();
		if (node.left == null && node.right == null) {
			encodingMap.put(node.character, sb.toString());

		} else {
			encodingMap.putAll(generateEncodingMap(node.left, sb.append('0')));
			sb.deleteCharAt(sb.length() - 1);
			encodingMap.putAll(generateEncodingMap(node.right, sb.append('1')));
			sb.deleteCharAt(sb.length() - 1);
		}

		return encodingMap;
	}

	// Innerklass för Node som används för att bygga trädet
	private class Node implements Comparable<Node> {
		private char character;
		private int freq;
		private Node left;
		private Node right;

		Node(char c, int freq) {
			this.character = c;
			this.freq = freq;
		}

		Node(char c, int freq, Node left, Node right) {
			this.character = c;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}

		@Override
		public String toString() {
			return "Node [c=" + character + ", freq=" + freq + "]";
		}
	}
}