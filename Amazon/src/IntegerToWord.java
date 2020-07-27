public class IntegerToWord {

        private String[] thousands = {"", "Thousand", "Million", "Billion"};
        private String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder();
                toWord(temp, num % 1000);
                sb.insert(0, temp.append(thousands[index]).append(" "));
            }
            index++;
            num = num / 1000;
        }
        return sb.toString().trim();
    }

    private void toWord(StringBuilder sb, int num) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            sb.append(lessThanTwenty[num]).append(" ");
            return;
        } else if (num < 100) {
            sb.append(tens[num / 10]).append(" ");
            toWord(sb, num % 10);
        } else {
            sb.append(lessThanTwenty[num / 100]).append(" Hundred ");
            toWord(sb, num % 100);
        }

    }

    public static void main(String[] args) {
        System.out.println(new IntegerToWord().numberToWords(123));
        System.out.println(new IntegerToWord().numberToWords(12345));
    }
}
