class Design_1166 {
    // Most voted solution: HashMap
    /*
    Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
        map.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        return map.containsKey(parent) && map.putIfAbsent(path, value) == null;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
    */


    
    // My first solution: Trie
    class TrieNode {
        int v;
        Map<String, TrieNode> map;
        TrieNode(int _v) {
            v = _v;
            map = new HashMap<>();
        }
    }
    
    TrieNode root;

    public Design_1166() {
        root = new TrieNode(0);
    }
    
    public boolean createPath(String path, int value) {
        String[] strs = path.split("/");
        int n = strs.length;
        if (n <= 1) return false;
        TrieNode node = root;
        for (int i = 1; i < n; i++) {
            if (i < n - 1) {
                if (!node.map.containsKey(strs[i])) return false;
                else node = node.map.get(strs[i]);
            } else {
                if (node.map.containsKey(strs[i])) return false;
                else node.map.put(strs[i], new TrieNode(value));
            }
        }
        return true;
    }
    
    public int get(String path) {
        String[] strs = path.split("/");
        int n = strs.length;
        if (n <= 1) return -1;
        TrieNode node = root;
        for (int i = 1; i < n; i++) {
            if (!node.map.containsKey(strs[i])) return -1;
            else node = node.map.get(strs[i]);
        }
        return node.v;
    }
}