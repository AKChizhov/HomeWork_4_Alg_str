
public class node {
    node left, right;
    int data;

    // красный --> true, черный --> false
    boolean color;

    node(int data)
    {
        this.data = data;
        left = null;
        right = null;

        // новый узел всегда красный
        color = true;
    }
}