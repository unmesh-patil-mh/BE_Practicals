
import java.util.*;

class Huffman {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    // Greedy method to build Huffman Tree
    static Node buildTree(char[] ch, int[] freq) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        for (int i = 0; i < ch.length; i++) {
            pq.add(new Node(ch[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        return pq.poll();
    }

    // Print Huffman Codes
    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] ch = new char[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character and frequency: ");
            ch[i] = sc.next().charAt(0);
            freq[i] = sc.nextInt();
        }

        Node root = buildTree(ch, freq);

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");

        sc.close();
    }
}
