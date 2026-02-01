class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int merged = 0;
        int end = 0;

        if(intervals.length ==0)
        list.add(newInterval);

        for(int i = 0; i < intervals.length ; i++){
        if(merged == 0){
            if(newInterval[1] < intervals[i][0]){
                list.add(newInterval) ;
                merged = 2;
            }

            if(intervals[i][1] >= newInterval[0] && merged != 2){
                list.add(new int[]{Math.min(intervals[i][0],newInterval[0]), Math.max(intervals[i][1],newInterval[1])});
                merged = 1;
                end = Math.max(intervals[i][1],newInterval[1]);
            }
            else{
                list.add(intervals[i]);
            }
        }
        else{
            if(end >= intervals[i][0]) {
             int last[] =  list.remove(list.size() -1);
              if(end < intervals[i][1])
                  end = intervals[i][1] ;
              list.add(new int[]{last[0],end}) ;
          }
         else{
             list.add(intervals[i]);
             end = intervals[i][1];
         }
        }
        }

        if(merged == 0 && intervals.length > 0 && newInterval[0] > intervals[intervals.length -1][1]){
            list.add(newInterval);
        }

        int arr[][] = list.toArray(new int[list.size()][]) ;
        return arr;
    }
}