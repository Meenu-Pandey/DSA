class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDif = Integer.MAX_VALUE;

        for(int i=0; i < arr.length - 1; i++){
            int curDif = arr[i+1] - arr[i];
            if(curDif < minDif){
                minDif = curDif;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            } else if (curDif == minDif){
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }

        return res;
    }
}