package com.company;

public class Node {

    String isocode;
    String location;
    String date;
    int totalcases;
    int newcases;
    int totaldeaths;
    int newdeath;
    int populat;
    double populatdensity;
    double gdpperppp;

    Node left;
    Node right;
    Node parent;

    public Node()
    {

        this.isocode = "";
        this.date = "";
        left=right=parent=null;
    }

    public Node(String isocode, String date){

        this.isocode = isocode;
        this.date = date;
        this.left = null;
        this.right = null;
        this.parent = null;

    }

    public Node(String isocode, String location,
            String date , int totalcases, int newcases, int totaldeaths,
            int newdeath, int populat, double populatdensity,
            double gdpperppp)
    {
        //overloaded constructor that initiates the node
        this.isocode = isocode;
        this.location = location;
        this.date = date;
        this.totalcases = totalcases;
        this.newcases = newcases;
        this.totaldeaths = totaldeaths;
        this.newdeath = newdeath;
        this.populat = populat;
        this.populatdensity = populatdensity;
        this.gdpperppp = gdpperppp;

        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public String[] nodestring(){

        String[] answ = new String[10];

        answ[0] = this.isocode;
        answ[1] = this.location;
        answ[2] = this.date;
        answ[3] = String.valueOf(this.totalcases);
        answ[4] = String.valueOf(this.newcases);
        answ[5] = String.valueOf(this.totaldeaths);
        answ[6] = String.valueOf(this.newdeath);
        answ[7] = String.valueOf(this.populat);
        answ[8] = String.valueOf(this.populatdensity);
        answ[9] = String.valueOf(this.gdpperppp);
        return answ;
    }
}
