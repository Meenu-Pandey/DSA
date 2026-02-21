class Solution {
    public String makeLargestSpecial(String s) {
        return solve(s.toCharArray(), 0, s.length() - 1);
    }

    private String solve(char[] str, int start, int end) {
        int sum = 0;
        int mark = start;
        List<String> components = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            sum += (str[i] == '1') ? 1 : -1;
            if (sum == 0) {
                // Recursively sort the inside of this special string
                // Wrap it back in '1' and '0'
                components.add("1" + solve(str, mark + 1, i - 1) + "0");
                mark = i + 1;
            }
        }

        // Sort components in descending order to maximize lexicographical value
        Collections.sort(components, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String comp : components) {
            sb.append(comp);
        }
        return sb.toString();
    }
}