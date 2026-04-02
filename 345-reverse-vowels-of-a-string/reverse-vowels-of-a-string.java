class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i=0, j=s.length()-1;

        while(i<j){
            while(i<j && ("aeiouAEIOU".indexOf(arr[i]) == -1 )){
                i++;
            }
            while(i<j && ("aeiouAEIOU".indexOf(arr[j]) == -1 )){
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return new String(arr);
    }
}