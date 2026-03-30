class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {

            while (i < j && "aeiouAEIOU".indexOf(chars[i]) == -1) {
                i++;
            }

            while (i < j && "aeiouAEIOU".indexOf(chars[j]) == -1) {
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }
}