public class LRUCache {

    

    class Node {

        private int key;

        private int value;

        private Node pre;

        private Node next;

        public Node(int key, int val) {

            this.key = key;

            this.value = val;

            this.pre = null;

            this.next = null;

        }

    }

    

    private HashMap<Integer, Node> store;

    private int capacity;

    private Node head;

    private Node end;

    

    public LRUCache(int capacity) {

        this.store = new HashMap<Integer, Node>();

        this.capacity = capacity;

        this.head = null;

        this.end = null;

    }

    

    public int get(int key) {

        if(!this.store.containsKey(key)) {

            return -1;

        }

        Node n = this.store.get(key);

        remove(n);

        setHead(n);

        return n.value;

    }

    

    private void remove(Node n) {

        if(n.pre != null) {

            n.pre.next = n.next;

        } else {

            head = n.next;

        }

        if(n.next != null) {

            n.next.pre = n.pre;

        } else {

            end = n.pre;

        }

    }

    

    private void setHead(Node n) {

        n.next = head;

        n.pre = null;

        if(head != null) {

            head.pre = n;

        }

        head = n;

        if(end == null) {

            end = head;

        }

    }

    

    public void set(int key, int value) {

        if(!this.store.containsKey(key)) {

            Node tmp = new Node(key, value);

            this.store.put(key, tmp);

            setHead(tmp);

            if(this.store.size() > this.capacity) {

                this.store.remove(this.end.key);

                remove(end);

            }

        } else {

            Node old = this.store.get(key);

            old.value = value;

            remove(old);

            setHead(old);

        }

    }

}
