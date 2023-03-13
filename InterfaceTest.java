/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adts;
import adts.GenericResizingQueue;
/**
 *
 * @author diego.gutierrezf
 */
public class InterfaceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test ="Hello world";
        GenericResizingQueue<String> queue;
        queue= new GenericResizingQueue<>();
        
        for (int i = 0;i<test.length();i++){
            char chr = test.charAt(i);
            queue.enqueue(String.valueOf(chr));
        }
        
        while (!queue.quueIsEmpty()){
            System.out.println(queue.dequeue());
        }
        test ="ThisIsATest";
        for (int i = 0;i<test.length();i++){
            char chr = test.charAt(i);
            queue.enqueue(String.valueOf(chr));
        }
        
        
    }
    
}
