class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int total = 1 << n;
        for(int i = 0; i < total; i++){
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}