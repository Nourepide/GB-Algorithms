package Lesson_6;

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
    }


    void display() {
        System.out.println(value);
    }

}


//        if (parent != null) {
//            parent.display(parent.leftChild, level + 1);
//            for (int i = 0; i < level; i++) System.out.print("   ");
//            System.out.println(parent.value + "<");
//            parent.display(parent.rightChild, level + 1);
//        }