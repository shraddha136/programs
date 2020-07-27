public class ExcelSheet {
    public String convertToTitle(int n){
        StringBuilder sb = new StringBuilder();
        while(n!= 0){
            char c = (char)((n-1)%26 + 65);
            n = (n-1)/26;
            sb.insert(0,c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheet().convertToTitle(1000));
    }
}
