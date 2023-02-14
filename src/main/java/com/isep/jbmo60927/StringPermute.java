package com.isep.jbmo60927;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringPermute {
  public StringPermute() {
    throw new IllegalAccessError("Utility class");
  }

  public static String[] permutations(String stringToPermute) {
    ArrayList<String> allPermutations = new ArrayList<>();
    
    //for every char in the string
    if (stringToPermute.length() > 2) {
      for (int i = 0; i < stringToPermute.length(); i++) {
  
        //we keep a char
        String firstChar = Character.toString(stringToPermute.charAt(i));
        
        String[] strbuild = stringToPermute.split(firstChar);
        StringBuilder toPermute = new StringBuilder();
        for (String str : strbuild) {
          toPermute.append(str);
        }
        String[] list = permutations(toPermute.toString());
        for (int j = 0; j < list.length; j++) {
          list[j] = firstChar+list[j];
        }
        Collections.addAll(allPermutations, list);
      }
    } else {
      Collections.addAll(allPermutations, permutationsFor2(stringToPermute));
    }
    return allPermutations.toArray(new String[allPermutations.size()]);
  }

  private static String[] permutationsFor2(String stringToPermute) {
    String[] permutations = new String[2];
    permutations[0] = stringToPermute;
    permutations[1] = Character.toString(stringToPermute.charAt(1))+Character.toString(stringToPermute.charAt(0));
    return permutations;
  }


  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter a string:");
    String s=sc.nextLine();
    sc.close();

    String[] stringList = permutations(s);
    for (int index = 0; index < stringList.length; index++) {
      System.out.println(String.format("%d\t%s", index, stringList[index]));
    }
  }
}