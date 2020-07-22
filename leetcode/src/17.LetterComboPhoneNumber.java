import java.util.*;

class  LetterComboPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        String[] input = digits.split("");
        String[] inputMap = new String[input.length];
        int i = 0;
        for(String ip:input)
            inputMap[i++] = map.get(ip);
        if(digits.length() == 1)
            return Arrays.asList(inputMap[0].split(""));
        Queue<String> queue = new LinkedList<>();
        for(char s:inputMap[0].toCharArray())
            queue.offer(""+s);

        return combo(queue,inputMap);
    }

    private List<String> combo(Queue<String> queue, String[] input) {
        List<String> result = new ArrayList<>();
        for(int i = 1;i<input.length;i++){
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0;j<size;j++){
                    String curr = queue.poll();
                    String ip = input[i];
                    for(char c:ip.toCharArray()){
                        StringBuilder sb = new StringBuilder();
                        sb.append(curr).append(c);
                        if(sb.toString().length()==input.length)
                            result.add(sb.toString());
                        else
                            queue.offer(sb.toString());
                    }
                }
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterComboPhoneNumber().letterCombinations("2"));
    }
}
