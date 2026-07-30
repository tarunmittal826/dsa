import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node before the tail (Most Recently Used)
    private void insert(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
