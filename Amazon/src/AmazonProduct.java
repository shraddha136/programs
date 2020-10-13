import java.util.*;

public class AmazonProduct {
    static class Product {

        Integer productId;
        Integer startTime;
        Integer endTime;
        Integer discount;

        public Product(Integer productId, Integer startTime, Integer endTime, Integer discount) {
            this.productId = productId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.discount = discount;
        }
    }

    public static void main(String[] args) {

        AmazonProduct amazonProduct = new AmazonProduct();
        int start = 9;
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, 12, 13, 90));
        productList.add(new Product(2, 12, 15, 5));
        productList.add(new Product(3, 12, 16, 90));
        productList.add(new Product(4, 4, 7, 65));
        productList.add(new Product(5, 5, 9, 98));
        productList.add(new Product(6, 7, 10, 85));
        List<Integer> output = amazonProduct.getMaxDiscountProducts(start, productList);

        for (Integer out : output) {
            System.out.println(out);
        }

    }

    private List<Integer> getMaxDiscountProducts(int start, List<Product> productList) {
        return new ArrayList<>();
    }
}
