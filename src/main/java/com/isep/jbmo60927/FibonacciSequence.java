package com.isep.jbmo60927;
import java.util.Scanner;


public class FibonacciSequence {

  //we don't use the constructor
  public FibonacciSequence() {
    throw new IllegalAccessError("Utility class");
  }

  //two differnet methods to resolve this problem
  public enum Methods {
    RECURSIVE,
    ITERATIVE
  }

  
  /** 
   * call the 2 differents methods
   * @param recursive the method used to find the result
   * @param n the max number of the Fibonacci Sequence
   * @return int the value return by this sequence
   */
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

  
  /** 
   * recursive methode to resolve this problem
   * @param n the max number of the Fibonacci Sequence
   * @return int the value return by this sequence
   */
  private static int recursiveFib(int n){
    if(n==0|| n==1)
      return n;
    else 
      return recursiveFib(n-1)+recursiveFib(n-2);
  }

  
  /** 
   * iterative methode to resolve this problem
   * @param n the max number of the Fibonacci Sequence
   * @return int the value return by this sequence
   */
  private static int iterativeFib(int n){
    if(n==0)
      return n;
    else {
      int first = 0;
      int second = 1;
      int temp = 0;
      for (int i = 1; i < n; i++) {
        temp = first + second;
        first = second;
        second = temp;
      }
      return second;
    }
  }


  
  /** 
   * main function to start the algorithm
   * @param args[]
   */
  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter a number: ");
    int n=sc.nextInt();
    sc.close();
    System.out.println(String.format("Recursive: %d", FibonacciSequence.fib(Methods.RECURSIVE, n)));
    System.out.println(String.format("Iterative: %d", FibonacciSequence.fib(Methods.ITERATIVE, n)));
  }
}