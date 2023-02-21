package com.isep.jbmo60927;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GreedyProblems {

    private int numberOfElement;
    private int[] payements;
    private int[] clics;
    
    public GreedyProblems(int numberOfElement, int[] payements, int[] clics) {
        this.numberOfElement = numberOfElement;
        this.payements = payements;
        this.clics = clics;
    }

    public int maxSeqProduct() {
        //we ordered the payements
        ArrayList<Integer> payementList = new ArrayList<>();
        for (int payement : payements) {
            payementList.add(payement);
        }
        Collections.sort(payementList);

        //and the clics
        ArrayList<Integer> clicsList = new ArrayList<>();
        for (int clic : clics) {
            clicsList.add(clic);
        }
        Collections.sort(clicsList);

        //the highest paement go with the most clicked to maximize revenues
        int maxCoounter = 0;
        for (int i = 0; i < numberOfElement; i++) {
            maxCoounter += payementList.get(i) * clicsList.get(i);
        }

        //we return the value found
        return maxCoounter;
    }

    /**
     * Main function
     * @param args
     */
    public static void main(String[] args) {

        //scanner
        Scanner sc = new Scanner(System.in);

        //size of inputs
        System.out.print("enter the number of spaces: ");
        int value = sc.nextInt();

        //create arrays
        int[] payement = new int[value];
        int[] clics = new int[value];

        //enter payeemnts
        for (int i = 0; i < value; i++) {
            System.out.print(String.format("enter pay%d: ", i));
            payement[i] = sc.nextInt();
        }

        //enter clics
        for (int i = 0; i < value; i++) {
            System.out.print(String.format("enter clic%d: ", i));
            clics[i] = sc.nextInt();
        }

        sc.close();

        //create object
        GreedyProblems ga = new GreedyProblems(value, payement, clics);

        //resolve it and display the result
        System.out.println(String.format("max revenues: %d", ga.maxSeqProduct()));
    }
}
