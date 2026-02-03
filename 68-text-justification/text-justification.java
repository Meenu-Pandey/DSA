class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i, len = 0;
            // Find how many words fit in this line
            while (j < words.length && len + words[j].length() + (j - i) <= maxWidth) {
                len += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - len;
            StringBuilder line = new StringBuilder();

            // Case 1: Last line or single word line → left-justified
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } 
            // Case 2: Fully justified line
            else {
                int spaceEach = spaces / gaps, extra = spaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) {
                        int toAdd = spaceEach + (extra-- > 0 ? 1 : 0);
                        line.append(" ".repeat(toAdd));
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}