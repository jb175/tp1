package com.isep.jbmo60927;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringPermute {
  public StringPermute() {
    throw new IllegalAccessError("Utility class");
  }

  /**
   * permute a string in all possibilities
   * @param stringToPermute the string to permute
   * @return an array of ervery string permuted
   */
  public static String[] permutations(String stringToPermute) {
    ArrayList<String> allPermutations = new ArrayList<>();
    
    //for every char in the string
    if (stringToPermute.length() > 2) {
      for (int i = 0; i < stringToPermute.length(); i++) {
  
        //we keep a char
        String firstChar = Character.toString(stringToPermute.charAt(i));

        //we get the reminder characters
        String toPermute = charExtraction(stringToPermute, i);

        //we permute the reminder characters
        String[] list = permutations(toPermute);

        //we add the char to every permutation returned
        for (int j = 0; j < list.length; j++) {
          list[j] = firstChar+list[j];
        }

        //we add these permutations to the list
        Collections.addAll(allPermutations, list);
      }
    } else {

      //if we have only 2 characters we may return the list directly
      Collections.addAll(allPermutations, permutationsFor2(stringToPermute));
    }

    //we return the permutations for the string we get in input as an array
    return allPermutations.toArray(new String[allPermutations.size()]);
  }

  /**
   * Method to extract a character from a string and get the reminder characters
   * @param stringToExtractFrom the string to exctract a char from
   * @param positionOfTheCharToExtract the position in the string to extract the char
   * @return String without one char
   */
  public static String charExtraction(String stringToExtractFrom, int positionOfTheCharToExtract) {
    if (stringToExtractFrom.length() >= positionOfTheCharToExtract)
      return stringToExtractFrom.substring(0, positionOfTheCharToExtract)+stringToExtractFrom.substring(positionOfTheCharToExtract+1);
    else
      return "";
  }

  /**
   * Permute a string of 2 char
   * @param stringToPermute
   * @return
   */
  public static String[] permutationsFor2(String stringToPermute) {

    // if the string length is different from 2
    if (stringToPermute.length() != 2)
      return new String[0];

    //otherwise we create the array
    String[] permutations = new String[2];

    //and we add the string normally
    permutations[0] = stringToPermute;
    //and inverted
    permutations[1] = Character.toString(stringToPermute.charAt(1))+Character.toString(stringToPermute.charAt(0));

    //we return the array
    return permutations;
  }


  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter a string:");
    String s=sc.nextLine();
    sc.close();

    String[] stringList = permutations(s);
    for (int index = 0; index < stringList.length; index++) {
      System.out.println(String.format("#%2d: %s", index, stringList[index]));
    }
  }
}