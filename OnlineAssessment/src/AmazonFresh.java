public class AmazonFresh {
    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "banana", "orange","apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println(isWinner(codeList1, shoppingCart1));
        System.out.println(isWinner(codeList2, shoppingCart2));
        System.out.println(isWinner(codeList3, shoppingCart3));
        System.out.println(isWinner(codeList4, shoppingCart4));
        System.out.println(isWinner(codeList5, shoppingCart5));
        System.out.println(isWinner(codeList6, shoppingCart6));
        System.out.println(isWinner(codeList, shoppingCart));

    }

    private static int isWinner(String[][] codeList, String[] shoppingCart) {
        if(codeList == null || codeList.length == 0){
            return 1;
        }
        int codeIndex = 0;
        int codeItemIndex = 0;
        int codeLen = codeList.length;

//        for(int cartIndex = 0; cartIndex < shoppingCart.length;cartIndex++){
//            if(shoppingCart[cartIndex].equals(codeList[codeIndex][codeItemIndex]) || codeList[codeIndex][codeItemIndex].equals("anything")){
//                codeItemIndex++;
//                if(codeItemIndex == codeList[codeIndex].length){
//                    codeIndex++;
//                    codeItemIndex = 0;
//                }
//                if(codeIndex == codeLen){
//                    return 1;
//                }
//            }else{
//                codeItemIndex = 0;
//            }
//        }
        int cartIndex = 0;
        while(cartIndex < shoppingCart.length){
            if(codeList[codeIndex][codeItemIndex].equals("anything")){
                cartIndex++;
            }else if(shoppingCart[cartIndex].equals(codeList[codeIndex][codeItemIndex]) ){
                cartIndex++;
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
