package com.company;
import java.math.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import jdk.jshell.Snippet;
import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Binarytree {

    BufferedWriter br = new BufferedWriter(new FileWriter("/home/user/Desktop/output.csv"));
    StringBuilder sb = new StringBuilder();
    Node root;

    public void exportcsv(Node export) throws IOException{

        //Append strings from array
        for (String element : export.nodestring()) {
            sb.append(element);
            sb.append(",");
        }
        sb.append("\n");
        br.write(sb.toString());
        br.newLine();
    }

    Binarytree() throws IOException {
        root = null;
    }

    public boolean firstcomeslater(Node charlie, Node delta){

        if (delta == null){
            return false;
        }

        if(charlie.isocode.compareTo(delta.isocode) >= 0) {

            //mm/dd/yyyy
            int aa, bb, cc, aaa, bbb, ccc;
            aa = Integer.parseInt(charlie.date.substring(0, 2).trim());
            bb = Integer.parseInt(charlie.date.substring(3, 5).trim());
            cc = Integer.parseInt(charlie.date.substring(6, 10).trim());
            aaa = Integer.parseInt(delta.date.substring(0, 2).trim());
            bbb = Integer.parseInt(delta.date.substring(3, 5).trim());
            ccc = Integer.parseInt(delta.date.substring(6, 10).trim());

            //determine which year is larger
            if (cc >= ccc) {

                if (bb >= bbb){

                    if (aa >= aaa) {

                        return true;//if the first comes later
                    }
                    return true;
                }
                return true;
            }
            //here we'll check if they are the same but the first doesnt come later
        }
        //if it doesnt come later
        return false;

    }

    // insert a node in BST
    public void insert(Node charlie)  {

        root = insert_Recursive(root, charlie);
    }

    //recursive insert function
    public Node insert_Recursive(Node alpha, Node charlie) {

        //tree is empty
        if (alpha == null) {

            alpha = charlie;
            return alpha;
        }

        //traverse the tree
        //firstcomeslater(charlie, root) == false
        if (firstcomeslater(charlie, alpha) == false)     //insert in the left subtree
            alpha.left = insert_Recursive(alpha.left, charlie);

        //firstcomeslater(charlie, root) == true

        else if (firstcomeslater(charlie, alpha) == true)    //insert in the right subtree
            alpha.right = insert_Recursive(alpha.right, charlie);

        // return pointer
        return alpha;
    }

    //inorder the method used for operations
    public String minValue(Node alpha)  {
        //initially minval = root

        String compprr = "";

        //find minval
        while (alpha.left != null)  {

            compprr = alpha.left.isocode.concat(alpha.left.date);
            alpha = alpha.left;
        }
        return compprr;
    }

    // method for inorder traversal of BST
    public void inorder() {

        inorder_Recursive(root);
    }

    // recursively traverse the BST
    public void inorder_Recursive(Node alpha) {

        if (alpha != null) {

            inorder_Recursive(alpha.left);

            System.out.print(alpha.isocode.concat(alpha.date) + " ");

            inorder_Recursive(alpha.right);
        }
    }

    public boolean search(Node alpha)  {

        this.root = search_Recursive(this.root, alpha);

        if (this.root!= null)

            return true;
        else
            return false;
    }

    //recursive insert function
    //search_recursive(Node root, int key)
    public Node search_Recursive(Node theta, Node alpha)  {

        // Base Cases: root is null or key is present at root
        if (theta == null || firstcomeslater(root, alpha) == true)
            return theta;
        // val is greater than root's key

        if (firstcomeslater(alpha, theta) == false)

            return search_Recursive(theta.left, alpha);

        // val is less than root's key
        return search_Recursive(theta.right, alpha);
    }

    //delete a node from BST
    public void deleteKey(Node alpha) {

        root = delete_Recursive(root, alpha);
    }

    public Node delete_Recursive(Node beta, Node alpha)  {
        //tree is empty
        if (beta == null) {
            return null;
        }

        //traverse the tree
        if (firstcomeslater(alpha, beta) == false) { //traverse left subtree

            beta.left = delete_Recursive(beta.left, alpha);
        }

        else if (firstcomeslater(alpha, beta) == true) {  //traverse right subtree

            beta.right = delete_Recursive(beta.right, alpha);
        }

        else  {

            // node contains only one child
            if (beta.left == null)
                return beta.right;

            else if (beta.right == null)
                return beta.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            String holder = "";
            holder = beta.isocode + beta.date;
            holder = minValue(root.right);

            String holder1 = "";
            String holder2 = "";

            holder1 = holder.substring(0,3);
            holder2 = holder.substring(3,13);

            Node temp;
            temp = new Node(holder1, holder2);

            // Delete the inorder successor
            beta.right = delete_Recursive(beta.right, temp);
        }
        return beta;
    }

    public Node search2(Node delta, Node alpha)
    {
        // Base Cases: root is null or key is present at root
        if (delta == null || (delta.isocode.compareTo(alpha.isocode) == 0 && delta.date.compareTo(alpha.date) == 0))
            return delta;

        // Key is greater than root's key
        if (firstcomeslater(alpha, delta) == true)
            return search2(delta.right, alpha);

        // Key is smaller than root's key
        return search2(delta.left, alpha);
    }

    public void traverseforcsv(Node focusNode) throws IOException {

        if (focusNode != null) {

            // Traverse the left node

            traverseforcsv(focusNode.left);

            // Visit the currently focused on node

            exportcsv(focusNode);

            // Traverse the right node
            traverseforcsv(focusNode.right);

        }
    }
}
