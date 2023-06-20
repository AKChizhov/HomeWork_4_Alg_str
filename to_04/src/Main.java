public class Main {
    private static node root = null;

    public static void main(String[] args) throws Exception {
        int [] data = {20, 10, 40, 30, 25, 50};
        System.out.println("Без балансировки:");
        tree simpleTree = new tree();
        root = simpleTree.simpleInsert(root, data[0]);
        root = simpleTree.simpleInsert(root, data[1]);
        root = simpleTree.simpleInsert(root, data[2]);
        root = simpleTree.simpleInsert(root, data[3]);
        root = simpleTree.simpleInsert(root, data[4]);
        root = simpleTree.simpleInsert(root, data[5]);
        // центрированный обход и распечатка
        simpleTree.inorder(root);
        simpleTree.DispTree(root);

        System.out.println("То же самое с балансировкой:");
        root = null;
        tree balancedTree = new tree();
        root = balancedTree.insert(root, data[0]);
        // корневой элемент черный
        root.color = false;
        root = balancedTree.insert(root, data[1]);
        root.color = false;
        root = balancedTree.insert(root, data[2]);
        root.color = false;
        root = balancedTree.insert(root, data[3]);
        root.color = false;
        root = balancedTree.insert(root, data[4]);
        root.color = false;
        root = balancedTree.insert(root, data[5]);
        root.color = false;
        // центрированный обход и распечатка
        balancedTree.inorder(root);
        balancedTree.DispTree(root);
    }
}