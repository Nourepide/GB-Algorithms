package Lesson_6;

public class Tree {
    private Node root;

    public Node find(int key) {
        Node current = root;

        while (current.value != key) {
            if (key < current.value) current = current.leftChild;
            else current = current.rightChild;

            if (current == null) break;
        }

        return current;
    }

    Tree insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }

                } else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                }
            }
        }

        return this;
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min() {
        Node current, last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node max() {
        Node current, last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }

        return last;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.value != key) {
            parent = current;
            if (key < current.value) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;

            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;

        }

        return true;
    }

    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    Tree displayTree() {
        if (root == null) {
            System.out.println("The tree wasn't filled");
        } else {
            inOrder(root);
        }

        return this;
    }
}
