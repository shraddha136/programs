//import com.sun.tools.javac.util.Pair;
//import sun.management.Agent;
//
//import java.util.*;
//
//public class EntityRelationship {
//    static class Node{
//        double percent;
//        String name;
//        Node left;
//        Node right;
//
//        public Node(double percent, String name){
//            this.percent = percent;
//            this.name = name;
//        }
//    }
//    private int count = 0;
//    public void generateTable(Node root){
//        Queue<Node> queue = new LinkedList<>();
//        List<Node> list = new ArrayList<>();
//        queue.offer(root);
//        list.add(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0;i<size;i++){
//                count++;
//                Node node = queue.poll();
//                if(node.left != null){
//                    queue.offer(node.left);
//                    list.add(node.left);
//                }
//                if(node.right != null){
//                    queue.offer(node.right);
//                    list.add(node.right);
//                }
//            }
//        }
//
//        for(Node node:list){
//            String letter = node.name;
//
//            dfs(letter, node.left,100);
//            dfs(letter, node.right,100);
//        }
//
//        printTable();
//
//    }
//
//    private void printTable() {
//        System.out.println("Here:");
//        System.out.println("Parent\t"+"Child\t"+"OwnerShip%");
//        System.out.println("------\t"+"------\t"+"----------%");
//        for(String letter: map.keySet()){
//            List<Pair<String,Double>> list = map.get(letter);
//            for(Pair<String,Double> pair:list){
//                System.out.println(letter+"\t"+pair.fst+"\t"+pair.snd+"%");
//            }
//        }
//
//        System.out.println(count);
//    }
//
//    Map<String, List<Pair<String,Double>>> map = new HashMap<>();
//    private void dfs(String letter, Node root, double percent) {
//        count++;
//        if(root == null){
//            return;
//        }
//        double currPercent = root.percent * percent * 0.01;
//        List<Pair<String,Double>> list = new ArrayList<>();
//        if(map.containsKey(letter)){
//            list = map.get(letter);
//        }
//        list.add(new Pair<>(root.name,currPercent));
//        map.put(letter,list);
//        dfs(letter,root.left,currPercent);
//        dfs(letter,root.right,currPercent);
//    }
//
//    public static void main(String[] args) {
//        Node root = new Node(100,"A");
//        root.left = new Node(50,"B");
//        root.right = new Node(33,"C");
//        root.left.left = new Node(50,"D");
//        root.right.left = new Node(10,"G");
//        root.left.right = new Node(30,"F");
//        root.right.right = new Node(10,"E");
//        new EntityRelationship().generateTable(root);
//    }
//}
