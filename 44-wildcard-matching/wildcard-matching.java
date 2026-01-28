class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][]arr=new Boolean[s.length()][p.length()];
        return helper(s,p,arr,s.length()-1,p.length()-1);
    }
    public static boolean helper(String text1,String text2, Boolean[][]dp,int index1,int index2){
        if(index1<0&&index2<0)return true;
        if(index1>=0&&index2<0)return false;
        if(index1<0&&index2>=0){
            for(int i=index2;i>=0;i--){
                if(text2.charAt(i)!='*')return false;
            }
            return true;
        }
        if(dp[index1][index2]!=null)return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2)||text2.charAt(index2)=='?')return dp[index1][index2]=helper(text1,text2,dp,index1-1,index2-1);
        if(text2.charAt(index2)=='*')return dp[index1][index2]=helper(text1,text2,dp,index1-1,index2)||helper(text1,text2,dp,index1,index2-1);
        return false;
    }
}