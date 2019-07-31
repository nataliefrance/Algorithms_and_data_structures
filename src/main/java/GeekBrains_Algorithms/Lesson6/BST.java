package GeekBrains_Algorithms.Lesson6;

import java.util.NoSuchElementException;

//Бинарное дерево поиска (binary search tree)
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private int depth;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private Node parent;
        private int size;
        private int level;

        Node(Key key, Value value, Node parent, int level) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.parent = parent;
            this.level = level;
        }

        public int level(){
            return level;
        }
    }

//    public BST() {
//        this.root.depth = 1;
//        this.depth = 0;
//    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int depth(){
        return this.depth;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key не должен быть null");
        }
        return true;
    }

    public boolean contains(Key key) {
        isKeyNotNull(key);
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int keyCompare = key.compareTo(node.key);
        if (keyCompare == 0) {
            return node.value;
        } else if (keyCompare < 0) {
            return get(node.left, key);
        } else return get(node.right, key);
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value, null);
    }

    private Node put(Node node, Key key, Value value, Node parent) {
        if (node == null) {
            if (parent == null){
                depth = 1;
                return new Node(key, value, null, 1);
            } else {
                if (depth == parent.level){
                    depth++;
                }
                return new Node(key, value, parent, parent.level + 1);
            }
        }
        int keyCompare = key.compareTo(node.key);
        if (keyCompare == 0) {
            node.value = value;
        } else if (keyCompare < 0) {
            node.left = put(node.left, key, value, node);
        } else node.right = put(node.right, key, value, node);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("дерево пустое");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int keyCompare = key.compareTo(node.key);
        if (keyCompare < 0) {
            node.left = delete(node.left, key);
        } else if (keyCompare > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return "BST {" + toString(root) + "}";
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.value.toString() + " " + toString(node.right);
    }
}
