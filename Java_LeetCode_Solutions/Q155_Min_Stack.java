public class MinStack {

    private ArrayList<Integer> store;

    private int min;



    /** initialize your data structure here. */

    public MinStack() {

        store = new ArrayList<Integer>();

        min = Integer.MAX_VALUE;

    }

    

    public void push(int x) {

        store.add(x);

        min = Math.min(min, x);

    }

    

    public void pop() {

        if(store.get(store.size() - 1) == min) {

            min = Integer.MAX_VALUE;

            for(int i = 0; i < store.size() - 1; i ++) {

                min = Math.min(store.get(i), min);

            }

        }

        store.remove(store.size() - 1);

    }

    

    public int top() {

        return store.get(store.size() - 1);

    }

    

    public int getMin() {

        return min;

    }

}



/**

 * Your MinStack object will be instantiated and called as such:

 * MinStack obj = new MinStack();

 * obj.push(x);

 * obj.pop();

 * int param_3 = obj.top();

 * int param_4 = obj.getMin();

 */
