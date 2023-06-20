public class tree {

    // вспомогательный метод поворота против часовой стрелки.
    node rotateLeft(node myNode) {
        System.out.printf("left rotation\n");
        node child = myNode.right;
        node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    // вспомогательный метод поворота по часовой стрелке.
    node rotateRight(node myNode) {
        System.out.printf("right rotation\n");
        node child = myNode.left;
        node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    // проверка красный узел или нет
    boolean isRed(node myNode) {
        if (myNode == null)
            return false;
        return (myNode.color == true);
    }

    // метеод обмена цветами между узлами

    void swapColors(node node1, node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    node simpleInsert(node myNode, int data) {
        if (myNode == null)
            return new node(data);

        if (data < myNode.data)
            myNode.left = simpleInsert(myNode.left, data);

        else if (data > myNode.data)
            myNode.right = simpleInsert(myNode.right, data);

        else
            return myNode;
        return myNode;
    }

    // вставка в левостороннее красно-черное дерево.
    node insert(node myNode, int data) {
        // обычная вставка в бинарное дерево

        if (myNode == null)
            return new node(data);

        if (data < myNode.data)
            myNode.left = insert(myNode.left, data);

        else if (data > myNode.data)
            myNode.right = insert(myNode.right, data);

        else
            return myNode;

        // вариант 1.
        // правый сын красный, а левый черный или не существует
        if (isRed(myNode.right) && !isRed(myNode.left)) {
            // левый разворот узла

            myNode = rotateLeft(myNode);

            // обмен цветами
            // потомок должен быть красным
            swapColors(myNode, myNode.left);

        }

        // вариант 2
        // левый сын и его сын красные
        if (isRed(myNode.left) && isRed(myNode.left.left)) {
            // правый разворот текущего узла
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

        // вариант 3
        // и левый и правый сыны красные
        if (isRed(myNode.left) && isRed(myNode.right)) {
            // изменить цвет узла
            // и его правого и левого детей
            myNode.color = !myNode.color;

            // меняем цвета детей на черный
            myNode.left.color = false;
            myNode.right.color = false;
        }

        return myNode;
    }

    // центрированный обход
    void inorder(node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // распечатка дерева (вершина слева, движимся вправо, как будто вниз)
    int COUNT = 5;

    void PrintTree(node root, int space) {
        if (root == null)
            return;

        // Увеличить расстояние между уровнями
        space += COUNT;

        // Правый сын сверху
        PrintTree(root.right, space);

        // Текущий узел
        //

        System.out.println();
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Левый сын снизу
        PrintTree(root.left, space);
    }

    void DispTree(node root) {
        // Изначальный промежуток 0
        PrintTree(root, 0);
    }
}
