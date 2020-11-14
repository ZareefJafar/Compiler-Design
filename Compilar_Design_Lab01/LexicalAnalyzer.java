/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg420_l01;

import java.io.*;
import java.util.*;

/**
 *
 * @author Zareef
 */
class LexicalAnalyzer {

    String[] K = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
        "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return",
        "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};
    String[] I = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] M = {"+", "-", "=", "/", "%", "*", "++", "--"};
    String[] L = {">", "<", ">=", "<=", "||", "&&", "^", "|", "&", "!"};
    String N = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
    String[] O = {",", ";", "(", ")", "{", "}", "[", "]"};
    String Keywords = "";
    String Identifiers = "";
    String MathOperators = "";
    String LogOperators = "";
    String NumValues = "";
    String Others = "";

    String[] splitA = {};
    String[] splitB = {};
    Set<String> a = new HashSet<String>();
    Set<String> b = new HashSet<String>();

    public void analyze() {
        try {
            File inputFile = new File("input.txt");
            try (Scanner sc = new Scanner(inputFile)) {
                while (sc.hasNextLine()) {

                    String line = sc.nextLine();
                    splitA = line.split("\\s+"); //splitting spaces
                    splitB = line.split("\\w+"); //splitting others except words
                    for (int index = 0; index < splitA.length; index++) {
                        String[] tempSplit = splitA[index].split(";");  //splitting ; at end of words
                        String[] temp2 = tempSplit[0].split(",");       //splitting , at end of words
                        String[] temp3 = temp2[0].split("\\)");         //splitting ) at end of words
                        if (!temp3[0].isEmpty()) {
                            a.add(temp3[0]);
                        }
                    }
                    for (int index = 0; index < splitB.length; index++) {
                        String temp = splitB[index].trim();
                        if (!(temp.isEmpty() || temp.equals("."))) {
                            b.add(temp);
                        }
                    }

                    String[] curretnLineArray = a.toArray(new String[a.size()]);
                    String[] curretnLineArray2 = b.toArray(new String[b.size()]);

                    for (int i = 0; i < curretnLineArray.length; i++) {

                        if (Arrays.asList(K).contains(curretnLineArray[i])) {
                            addkeyWordK(curretnLineArray[i]);
                        } else if (Arrays.asList(I).contains(curretnLineArray[i])) {
                            addkeyWordI(curretnLineArray[i]);
                        } else if (Arrays.asList(M).contains(curretnLineArray[i])) {
                            addkeyWordM(curretnLineArray[i]);
                        } else if (Arrays.asList(L).contains(curretnLineArray[i])) {
                            addkeyWordL(curretnLineArray[i]);
                        } else if (Arrays.asList(O).contains(curretnLineArray[i])) {
                            addkeyWordO(curretnLineArray[i]);
                        } else if (curretnLineArray[i].matches(N)) {
                            addkeyWordN(curretnLineArray[i]);
                        }
                    }

                    for (int i = 0; i < curretnLineArray2.length; i++) {

                        if (Arrays.asList(K).contains(curretnLineArray2[i])) {
                            addkeyWordK(curretnLineArray2[i]);
                        } else if (Arrays.asList(I).contains(curretnLineArray2[i])) {
                            addkeyWordI(curretnLineArray2[i]);
                        } else if (Arrays.asList(M).contains(curretnLineArray2[i])) {
                            addkeyWordM(curretnLineArray2[i]);
                        } else if (Arrays.asList(L).contains(curretnLineArray2[i])) {
                            addkeyWordL(curretnLineArray2[i]);
                        } else if (Arrays.asList(O).contains(curretnLineArray2[i])) {
                            addkeyWordO(curretnLineArray2[i]);
                        } else if (curretnLineArray2[i].matches(N)) {
                            addkeyWordN(curretnLineArray2[i]);
                        }
                    }

                }
            }
            System.out.println("Keywords: " + Keywords);
            System.out.println("Identifiers: " + Identifiers);
            System.out.println("MathOperators: " + MathOperators);
            System.out.println("LogOperators: " + LogOperators);
            System.out.println("NumValues: " + NumValues);
            System.out.println("Others: " + Others);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addkeyWordK(String ele) {
        if (!Keywords.contains(ele)) {
            if (Keywords.equals("")) {
                Keywords = ele;
            } else {
                Keywords = Keywords + ", " + ele;
            }
        }
    }

    public void addkeyWordI(String ele) {
        if (!Identifiers.contains(ele)) {
            if (Identifiers.equals("")) {
                Identifiers = ele;
            } else {
                Identifiers = Identifiers + ", " + ele;
            }
        }
    }

    public void addkeyWordM(String ele) {
        if (!MathOperators.contains(ele)) {
            if (MathOperators.equals("")) {
                MathOperators = ele;
            } else {
                MathOperators = MathOperators + "," + ele;
            }
        }
    }

    public void addkeyWordL(String ele) {
        if (!LogOperators.contains(ele)) {
            if (LogOperators.equals("")) {
                LogOperators = ele;
            } else {
                LogOperators = LogOperators + ", " + ele;
            }
        }
    }

    public void addkeyWordN(String ele) {
        if (!NumValues.contains(ele)) {
            if (NumValues.equals("")) {
                NumValues = ele;
            } else {
                NumValues = NumValues + ", " + ele;
            }
        }
    }

    public void addkeyWordO(String ele) {
        if (!Others.contains(ele)) {
            if (Others.equals("")) {
                Others = ele;
            } else {
                Others = Others + "" + ele;
            }
        }
    }
}
