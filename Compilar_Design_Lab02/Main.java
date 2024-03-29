/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg420_l02;

import java.io.*;
import java.util.*;

/**
 *
 * @author Zareef
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
//        String mail = "^[a-zA-Z]+[0-9\a-z\.\-]*@[a-z]+[a-z\.\-]*[.][a-z]+";
//        String web = "[w]{3,3}[.][a-zA-Z0-9@:%_\\+~]+[.][com]{3,3}";
//        int mailCount = 0;
//        int webCount = 0;
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        String info[] = new String[size+1];
//        for (int i = 0; i < info.length; i++) {
//            info[i] = sc.nextLine();
//        }
//        for (int i = 0; i < info.length; i++) {
//            if (info[i].matches(mail)) {
//                mailCount++;
//            } else if (info[i].matches(web)) {
//                webCount++;
//            }
//        }
//        System.out.println("Email, " + mailCount);
//        System.out.println("Web, " + webCount);


        Mail_Identifier m = new Mail_Identifier(); //m is a Object of Mail_Identifier class
        Web_Identifier w = new Web_Identifier();   //w is a Object of Web_Identifier class

        
        //Input from user
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String info[] = new String[size + 1];
        for (int i = 0; i < info.length; i++) {
            info[i] = sc.nextLine();
        }
        
        //Checking validity of each string 
        for (int i = 0; i < info.length; i++) {
            if (m.emailCheck(info[i]) == 1) {         //if it is valid email ID it will return 1/true
                System.out.println("Email, " + i); 
                
            } else if (w.webCheck(info[i]) == 1) {    //if it is valid web ID it will return 1/true
                System.out.println("Web, " + i);
                
            }
        }
        
       //System.out.println("Email, " + mailCount);
       // System.out.println("Web, " + webCount);
    }

}
