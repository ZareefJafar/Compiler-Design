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
public class Web_Identifier {
    
    

//Regular expression for WEBSITES = "[w]{3,3}[.][a-zA-Z0-9@:%_\\+~]+[.][com]{3,3}";
//Following code will iterate over each character of the string using DFA following the Regular expression of websites
    
    
    
    public int webCheck(String WM) {
        int state = 0;
        int lexeW = 0;
        int ValidWeb = 0;
        int Wcount = 0;    //count the number of "w" in the beginning . Max/Min 3 "w"'s in a row is allowed
        int COMcount = 1;  // if there is anything after ".com" is seen "ValidWeb" will become false
        while (lexeW < WM.length()) {
            switch (state) {
                case 0:
                    if (WM.charAt(lexeW) == 'w') {
                        Wcount++;
                        if (Wcount < 3) {
                            state = 0;
                        } else if (Wcount == 3) {
                            state = 2;
                        }
                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;

                case 1:  //Once this state is reached there is no going back. The output will remain 0 or false
                    state = 1;
                    lexeW++;
                    break;

                case 2:
                    if (WM.charAt(lexeW) == '.') {
                        state = 3;

                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;
                case 3:
                    if (((int) WM.charAt(lexeW) > 47 && (int) WM.charAt(lexeW) < 58) || ((int) WM.charAt(lexeW) > 64 && (int) WM.charAt(lexeW) < 91) || ((int) WM.charAt(lexeW) > 96 && (int) WM.charAt(lexeW) < 123)) {
                        state = 4;

                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;

                case 4:
                    if (((int) WM.charAt(lexeW) > 47 && (int) WM.charAt(lexeW) < 58) || ((int) WM.charAt(lexeW) > 64 && (int) WM.charAt(lexeW) < 91) || ((int) WM.charAt(lexeW) > 96 && (int) WM.charAt(lexeW) < 123)) {
                        state = 4;

                    } else if (WM.charAt(lexeW) == '.') {
                        state = 5;
                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;

                case 5:
                    if (WM.charAt(lexeW) == 'c') {
                        state = 6;

                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;
                case 6:
                    if (WM.charAt(lexeW) == 'o') {
                        state = 7;

                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;
                case 7:
                    if (WM.charAt(lexeW) == 'm') {
                        if (COMcount == 1) {
                            COMcount++;
                            ValidWeb = 1;
                        }
                        
                    } else {
                        state = 1;
                    }
                    lexeW++;
                    break;
            }
        }

        return ValidWeb;
    }

}
