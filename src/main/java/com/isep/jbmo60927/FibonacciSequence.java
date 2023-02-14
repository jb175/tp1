package com.isep.jbmo60927;
import java.util.Scanner;

public class FibonacciSequence {
  public FibonacciSequence() {
    throw new IllegalAccessError("Utility class");
  }

  public enum Methods {
    RECURSIVE,
    ITERATIVE
  }

  public static int fib(Methods recursive, int n) {
    if (n==0 || n==1)
      return n;
    else
      switch(recursive) {
        case RECURSIVE:
          return recursiveFib(n);
        case ITERATIVE:
          return iterativeFib(n);
        default:
          return 0;
      }
  }

  private static int recursiveFib(int n){
    if(n==0|| n==1)
      return n;
    else 
      return recursiveFib(n-1)+recursiveFib(n-2);
  }

  private static int iterativeFib(int n){
    if(n==0||n==1)
      return n;
    else {
      int counter = 0;
      for(int i=1; i< (n-2); i++) {
        if (i == 0 || i == (n-1))
          counter += i; //we add the first and the second to last element because each of them are added only one time
        else
          counter += (2*i); //and 2 times for evry other element
      }
      return counter;
    }
  }


  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter a number:");
    int n=sc.nextInt();
    sc.close();
    System.out.println(String.format("Recursive: %d", FibonacciSequence.fib(Methods.RECURSIVE, n)));
    System.out.println(String.format("Iterative: %d", FibonacciSequence.fib(Methods.ITERATIVE, n)));
  }
}