public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for(int x : nums) {
            inputList.add(x);
        }
        return listPermute(inputList);
    }
    private List<List<Integer>> listPermute(ArrayList<Integer> input) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(input.size() == 1) {
            rst.add(input);
            return rst;
        }
        for(int i = 0; i < input.size(); i++) {
            ArrayList<Integer> wrk = new ArrayList<Integer>(input);
            wrk.remove(i);
            List<List<Integer>> tmp = listPermute(wrk);
            for(int j = 0; j < tmp.size(); j++) {
                tmp.get(j).add(0, input.get(i));
            }
            rst.addAll(tmp);
        }
        return rst;
    }
}