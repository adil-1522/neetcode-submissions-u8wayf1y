class PrefixTree {

    class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    // 🔹 Insert
    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new Node()); // ✅ FIX
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    // 🔹 Search
    public boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) return false;

            node = node.get(ch);
        }

        return node.isEnd();
    }

    // 🔹 StartsWith
    public boolean startsWith(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch)) return false;

            node = node.get(ch);
        }

        return true;
    }
}
