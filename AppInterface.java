/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import adts.GenericResizeStack;
import java.util.Scanner;

/**
 *
 * @author diego.gutierrezf
 */
public class AppInterface {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericResizeStack<String> stack;

        String text, inverted = "";

        System.out.println("Insert a word");
        text = sc.nextLine();

        stack = new GenericResizeStack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(String.valueOf(text.charAt(i)));
        }

        while (!stack.isEmpty()) {
            inverted += stack.pop();
        }
        System.out.println(inverted.equals(text) ? text+" is palindrome" : text+" is not a palindrome");

    }

}
