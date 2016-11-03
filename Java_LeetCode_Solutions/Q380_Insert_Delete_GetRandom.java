public class RandomizedSet {
    private HashMap<Integer, Integer> store;
    private HashMap<Integer, Integer> idxSt;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        store = new HashMap<Integer, Integer>();
        idxSt = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(store.containsKey(val)) {
            return false;
        }
        store.put(val, store.size());
        idxSt.put(idxSt.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!store.containsKey(val)) {
            return false;
        }
        int tmp = store.get(val);
        store.remove(val);
        idxSt.remove(tmp);
        if(tmp == store.size() || store.size() == 0) {
            return true;
        }
        int tmpKey = idxSt.get(idxSt.size());
        store.replace(tmpKey, store.get(tmpKey), tmp);
        idxSt.remove(idxSt.size());
        idxSt.put(store.get(tmpKey), tmpKey);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(store.size() == 0) {
            return 0;
        }
        if(store.size() == 1) {
            return idxSt.get(0);
        }
        return idxSt.get(new Random().nextInt(store.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
