/*
 * Write a program to generate the following result.
 * 1
 * 12
 * 124
 * 1247
 * 124713
 * 12471324
 * 1247132444
 * 124713244481
 * 124713244481149
 * …........................(and so on)
 * Directly print out the result is not acceptable
 * (Bonus: If you do not need to use If-Case to handle first few lines)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("input number here : ");
    int number = input.nextInt();
    System.out.println();
    
    List<Integer> ans1 = new ArrayList<>();
    ans1.add(1);
    ans1.add(2);
    ans1.add(4);
    // int[] answer = new int[number];
    for (int i = 0; i < number; i++) {
      ans1.add(ans1.get(i) + ans1.get(i + 1) + ans1.get(i + 2));
    }
    String answer = "";
    for (int i = 0; i < ans1.size(); i++) {
      answer += (ans1.get(i).toString());
      System.out.println(answer);
    }
  }
}