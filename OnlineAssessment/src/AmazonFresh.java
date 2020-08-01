public class AmazonFresh {
    public static void main(String[] args) {
        String[][] codeList = {{"apple"}, {"banana"}};
        String[] shoppingCart = {"apple","apple","banana" };

//        String[][] codeList = {{"apple", "apple"}, {"apple", "apple", "banana"}};
//        String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
//        String[] shoppingCart = {"apple", "apple","apple","banana" };
//        String[] shoppingCart = {"apple", "banana","apple","banana","orange","banana" };
//        String[] shoppingCart = {"banana", "orange", "banana", "apple", "apple"};
//        String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};

        System.out.println(isWinner(codeList,shoppingCart));
    }

    private static int isWinner(String[][] codeList, String[] shoppingCart) {
        if(codeList == null || codeList.length == 0){
            return 1;
        }

        int codeIndex = 0;
        int codeItemIndex = 0;
        int codeLen = codeList.length;

        for(int cartIndex = 0; cartIndex < shoppingCart.length;cartIndex++){
            if(shoppingCart[cartIndex].equals(codeList[codeIndex][codeItemIndex]) || codeList[codeIndex][codeItemIndex].equals("anything")){
                codeItemIndex++;
                if(codeItemIndex == codeList[codeIndex].length){
                    codeIndex++;
                    codeItemIndex = 0;
                }
                if(codeIndex == codeLen){
                    return 1;
                }
            }else{
                codeItemIndex = 0;
            }
        }
        return 0;
    }
}
