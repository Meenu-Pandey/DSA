class Solution {
    public String addBinary(String a, String b) {
        int i= a.length()-1,j=b.length()-1,carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0 || carry!=0){
            int currsum=carry;
            currsum+= i>=0?a.charAt(i)-'0':0;
            currsum+= j>=0?b.charAt(j)-'0':0;
            sb.append(currsum%2);
            carry=currsum/2;
            i--;
            j--;
        }        
        return sb.reverse().toString();
    }
}