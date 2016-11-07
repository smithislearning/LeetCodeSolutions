public class RandomizedSet {

    private HashMap<Integer, Integer> store;

    private HashMap<Integer, Integer> idx;



    /** Initialize your data structure here. */

    public RandomizedSet() {

        store = new HashMap<Integer, Integer>();

        idx = new HashMap<Integer, Integer>();

    }

    

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */

    public boolean insert(int val) {

        if(store.containsKey(val)) {

            return false;

        }

        store.put(val, store.size());

        idx.put(idx.size(), val);

        return true;

    }

    

    /** Removes a value from the set. Returns true if the set contained the specified element. */

    public boolean remove(int val) {

        if(!store.containsKey(val)) {

            return false;

        }

        int tmp = store.get(val);

        store.remove(val);

        idx.remove(tmp);

        if(store.isEmpty() || tmp == store.size()) {

            return true;

        }

        int tmp1 = idx.get(idx.size());

        store.replace(tmp1, store.get(tmp1), tmp);

        idx.remove(idx.size());

        idx.put(store.get(tmp1), tmp1);

        return true;

    }

    

    /** Get a random element from the set. */

    public int getRandom() {

        if(store.isEmpty()) {

            return 0;

        }

        if(store.size() == 1) {

            return idx.get(0);

        }

        return idx.get(new Random().nextInt(store.size()));

    }

}



/**

 * Your RandomizedSet object will be instantiated and called as such:

 * RandomizedSet obj = new RandomizedSet();

 * boolean param_1 = obj.insert(val);

 * boolean param_2 = obj.remove(val);

 * int param_3 = obj.getRandom();

 */
