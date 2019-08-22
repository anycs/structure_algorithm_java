package com.space.structure;

/**
 * Created by lucifel on 19-8-22.
 */
public class BinarySearchTree {
    private Node tree = null;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(33);
        binarySearchTree.insert(16);
        binarySearchTree.insert(13);
        binarySearchTree.insert(15);
        binarySearchTree.insert(18);
        binarySearchTree.insert(17);
        binarySearchTree.insert(25);
        binarySearchTree.insert(19);
        binarySearchTree.insert(27);
        binarySearchTree.insert(50);
        binarySearchTree.insert(34);
        binarySearchTree.insert(58);
        binarySearchTree.insert(51);
        binarySearchTree.insert(55);
        binarySearchTree.insert(66);

        binarySearchTree.delete(13);
        binarySearchTree.delete(18);
        binarySearchTree.delete(55);
        System.out.println(binarySearchTree);


    }

    public  Node find(int data){
        Node node = tree;
        while(node != null){
            if(data < node.data ){
                node = node.left;
            }else if(data > node.data){
                node = node.right;
            }else{
                return node;
            }
        }
        return null;
    }

    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node node = tree;
        while(node != null){
            if(data < node.data ){
                if(node.left == null){
                   node.left = new Node(data);
                   return;
                }
                node = node.left;
            }else if(data > node.data){
                if(node.right == null){
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    public void delete(int data){
        Node node = tree;
        Node father = null;
        while (node != null && data != node.data){
            father = node;
            if(data < node.data){
                node = node.left;
            }else if(data > node.data){
                node = node.right;
            }
        }
        if(node == null){
            return;
        }
        //没有子节点或有一个子节点
        if(node.left == null || node.right == null){
            if(father.left == node){
                father.left = (node.left==null?node.right:node.left);
            }
            if(father.right == node){
                father.right = (node.right == null?node.left:node.right);
            }
        }
        //有两个子节点
        if(node.left != null && node.right != null){
            Node temp = node.right;
            Node minFather = node;
            while (temp.left != null){
                minFather = temp;
                temp = temp.left;
            }
            Node minNode = temp;
            node.data = minNode.data;
            minFather.left = minNode.right;

        }

    }




    public class Node {

        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

}
