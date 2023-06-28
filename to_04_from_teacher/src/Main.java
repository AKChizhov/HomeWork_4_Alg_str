public class Main {
    public static void main(String[] args) {


        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(6);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(5);

        tree.remove(6);
        tree.remove(5);

        tree.print();

        if (tree.remove(3))
            System.out.println("  Deleted");

        for (int i =0;i <11; i++){
            System.out.println(i + " " + tree.contain(i));

        }
    }
}