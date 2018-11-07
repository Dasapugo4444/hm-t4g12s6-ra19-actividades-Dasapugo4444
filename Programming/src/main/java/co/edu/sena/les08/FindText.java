package co.edu.sena.les08;

import sun.security.krb5.internal.PAData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    private String fileName = "gettys.html";
    private Pattern pattern;
    private Matcher ma;

    public static void main(String[] args) {
        FindText find = new FindText();
        find.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int c = 1;
            while ((line = reader.readLine()) != null) {
                pattern=Pattern.compile("<h4>");
                pattern=Pattern.compile("\\bto\\b");
                pattern=Pattern.compile("^\\s{4}");
                pattern=Pattern.compile("^<[p|d]");
                pattern=Pattern.compile("</div>");
                ma=pattern.matcher(line);
                if (ma.find()){
                    System.out.println(" " + c + " "+ line);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
