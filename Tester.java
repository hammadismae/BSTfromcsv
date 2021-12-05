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

public class Tester {
    public static void main(String[] args) throws IOException, ParseException {

        System.out.println("Reading file...\n");
        File inputfile = new File("insert file path of the input file");

        //int temp = Integer.parseInt(args[1].trim());//query integer
        int temp = Integer.parseInt("1");

        Scanner inscan = new Scanner(inputfile);
        Binarytree mytree = new Binarytree();

        BigDecimal starttime = new BigDecimal(System.nanoTime());

        boolean dummy = true;

        int count = 0;
        while(inscan.hasNextLine()){

            //skips first interation
            if(dummy == true){
                String[] result = new String[15];
                result = inscan.nextLine().split(",");
                dummy = false;
                continue;
            }

            //this is the csv part we're concerned with
            if(dummy == false){

                String[] result = new String[15];
                result = inscan.nextLine().split(",");

                //No need for comparator
                //imagine the node iso and date are joint to form
                //the unique code and manually compare nodes in bstree

                try {

                    Node echo = new Node(

                            result[0].trim(), result[1].trim(), result[2].trim(),
                            Integer.parseInt(result[3].concat("0").trim()),
                            Integer.parseInt(result[4].concat("0").trim()),
                            Integer.parseInt(result[5].concat("0").trim()),
                            Integer.parseInt(result[6].concat("0").trim()),
                            Integer.parseInt(result[7].trim()),
                            Double.parseDouble(result[8].concat("0").trim()),
                            Double.parseDouble(result[9].concat("0").trim()));

                    count = count + 1;
                    //System.out.println(count);

                    mytree.insert(echo);

                }catch (ArrayIndexOutOfBoundsException e){}
            }
            //str.compareTo(str2) will compare the isocode
        }

        BigDecimal endtime = new BigDecimal(System.nanoTime());
        BigDecimal divi = new BigDecimal("1000000000");
        BigDecimal substr;
        substr = endtime.subtract(starttime);

        System.out.println("Total time to read data to BST: " +
                substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");

        //query 1 searches for the node that contains
        if(temp == 1){

            BigDecimal startt = new BigDecimal(System.nanoTime());
            System.out.println("Starting Search at time: " + startt);

            Node alpha = new Node("SAU", "03/03/2020");
            Node tempor = mytree.search2(mytree.root, alpha);

            String[] result = tempor.nodestring();

            for (String beta : result){
                System.out.println(beta);
            }

            BigDecimal endd = new BigDecimal(System.nanoTime());
            System.out.println("\nEnding search at time: " + endd);
            substr = endd.subtract(startt);
            System.out.println("Time for search: " +
                    substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");
        }

        //searches again for a different node
        if(temp == 2){

            BigDecimal startt = new BigDecimal(System.nanoTime());
            System.out.println("Starting Search at time: " + startt);

            Node theta = new Node("SAU", "01/11/2020");

            Node tempor;
            tempor = mytree.search2(mytree.root, theta);

            String[] result = tempor.nodestring();

            for (String beta : result){
                System.out.println(beta);
            }

            BigDecimal endd = new BigDecimal(System.nanoTime());
            System.out.println("\nEnding search at time: " + endd);

            substr = endd.subtract(startt);
            System.out.println("Time for search: " +
                    substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");

        }

        //searches again for a different node
        if(temp == 3){

            BigDecimal startt = new BigDecimal(System.nanoTime());
            System.out.println("Starting Search at time: " + startt);

            Node alpha = new Node("SAU", "18/06/2020");

            Node temporr = mytree.search2(mytree.root, alpha);

            String[] result = temporr.nodestring();

            for (String beta : result){
                System.out.println(beta);
            }

            BigDecimal endd = new BigDecimal(System.nanoTime());
            substr = endd.subtract(startt);
            System.out.println("\nEnding search at time: " + endd);

            System.out.println("Time for search: " +
                    substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");
        }

        //inset the node the has the information information taken as an array string
        if(temp == 4){

            BigDecimal startt = new BigDecimal(System.nanoTime());
            System.out.println("Starting Search at time: " + startt);

            Node alpha = new Node("SAU","Saudi Arabia", "31/06/2020",
                    -1, 0, 0, 0, 0, 0.0 ,0.0 );

            mytree.insert(alpha);

            BigDecimal endd = new BigDecimal(System.nanoTime());
            System.out.println("\nEnding search at time: " + endd);

            substr = endd.subtract(startt);
            System.out.println("Time for search: " +
                    substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");

        }

        //removes the node that contains
        if(temp == 5){

            BigDecimal startt = new BigDecimal(System.nanoTime());
            System.out.println("Starting Search at time: " + startt);

            //send the placer node here to be remooved
            Node alpha = new Node("SAU","03/03/2020");
            mytree.deleteKey(alpha);

            BigDecimal endd = new BigDecimal(System.nanoTime());
            System.out.println("\nEnding search at time: " + endd);

            substr = endd.subtract(startt);
            System.out.println("Time for search: " +
                    substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");

        }

        BigDecimal abc = new BigDecimal(System.nanoTime());

        System.out.println("\nWriting to file");
        mytree.traverseforcsv(mytree.root);

        BigDecimal xyz = new BigDecimal(System.nanoTime());

        substr = xyz.subtract(abc);
        System.out.println("Total time to write data to file: " +
                substr.divide(divi, 5, RoundingMode.CEILING) + " Seconds");
    }
}
