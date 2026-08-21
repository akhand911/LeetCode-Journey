import java.util.Stack;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int currentNum = 0;
        String currentStr = "";

        for (char ch : s.toCharArray()) {

            // If character is a digit
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }

            // If '[' is encountered
            else if (ch == '[') {
                numStack.push(currentNum);
                strStack.push(currentStr);

                currentNum = 0;
                currentStr = "";
            }

            // If ']' is encountered
            else if (ch == ']') {
                int repeat = numStack.pop();
                String previousStr = strStack.pop();

                StringBuilder temp = new StringBuilder(previousStr);

                for (int i = 0; i < repeat; i++) {
                    temp.append(currentStr);
                }

                currentStr = temp.toString();
            }

            // If it's a normal character
            else {
                currentStr += ch;
            }
        }

        return currentStr;
    }
}