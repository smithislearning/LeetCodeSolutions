public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for(int x : nums) {
            inputList.add(x);
        }
        return listPermute(inputList);
    }
    private List<List<Integer>> listPermute(ArrayList<Integer> input) {
        HashSet<Integer> inputHsh = new HashSet<Integer>(input);
        ArrayList<Integer> inputNoDup = new ArrayList<Integer>(inputHsh);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(inputNoDup.size() == 1) {
            rst.add(input);
            return rst;
        }
        for(int i = 0; i < inputNoDup.size(); i++) {
            ArrayList<Integer> wrk = new ArrayList<Integer>(input);
            wrk.remove(inputNoDup.get(i));
            List<List<Integer>> tmp = listPermute(wrk);
            for(int j = 0; j < tmp.size(); j++) {
                tmp.get(j).add(0, inputNoDup.get(i));
            }
            rst.addAll(tmp);
        }
        return rst;
    }
}