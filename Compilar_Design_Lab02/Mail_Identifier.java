/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg420_l02;

/**
 *
 * @author Zareef
 */
public class Mail_Identifier {
    
    
    
//Regular expression for EMAILS = "^[a-z]+[0-9\a-z\.\-]*@[a-z\.\-]*[.][a-z]+";
//Following code will iterate over each character of the string using DFA following the Regular expression of emails
    
    
    public int emailCheck(String WM) {
        int state = 0;
        int lexeM = 0;
        int validMail = 0;             
        while (lexeM < WM.length()) {
            switch (state) {
                case 0:
                    if (((int) WM.charAt(lexeM) > 96 && (int) WM.charAt(lexeM) < 123)) {
                        state = 1;
                    } else {
                        state = 4;
                    }
                    lexeM++;
                    break;
                case 1:
                    if (((int) WM.charAt(lexeM) == 0) ||((int) WM.charAt(lexeM) > 44 && (int) WM.charAt(lexeM) < 58)  || ((int) WM.charAt(lexeM) > 96 && (int) WM.charAt(lexeM) < 123)) {
                        state = 1;
                    } else if (WM.charAt(lexeM) == '@') {
                        state = 2;
                    } else {
                        state = 4;
                    }
                    lexeM++;
                    break;
                case 2:
                    if (((int) WM.charAt(lexeM) == 0)||((int) WM.charAt(lexeM) == 45) || ((int) WM.charAt(lexeM) > 96 && (int) WM.charAt(lexeM) < 123)) {
                        state = 2;

                    } else if (WM.charAt(lexeM) == '.') {
                        state = 3;
                    } else {

                        state = 4;
                    }
                    lexeM++;
                    break;
                case 3:
                    if (((int) WM.charAt(lexeM) > 96 && (int) WM.charAt(lexeM) < 123)) {
                        state = 3;
                        validMail = 1;

                    } else {
                        state = 4;

                    }
                    lexeM++;
                    break;
                case 4:
                    state =4;
                    lexeM++;
                    break;
            }
        }

        return validMail;
    }

}
