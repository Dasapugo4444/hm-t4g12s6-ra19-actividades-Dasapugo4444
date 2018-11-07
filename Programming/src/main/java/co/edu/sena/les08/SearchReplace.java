package co.edu.sena.les08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {

    private String fileName = "gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";
            String replaceTag = "span";
            String attribute = "class";
            String value = "sentence";
            String line = "";
            int c = 1;
            Pattern pattern1=Pattern.compile("(<"+targetTag+".*?>)(.*?)(</"+targetTag+".*?>)");

            while ((line = reader.readLine()) != null) {
                Matcher m1=pattern1.matcher(line);
                if (m1.find()){
                    String newStart =replaceTag(m1.group(1), targetTag, replaceTag);
                    newStart=replaceAttribute(newStart, attribute, value);
                    String newEnd=replaceTag(m1.group(3), targetTag, replaceTag);
                    String newLine=newStart+m1.group(2)+newEnd;
                    System.out.println("%3d %s\n"+c+newLine);
                }
                String newLine = "The newly created line goes here";
                System.out.printf("%3d %s\n", c, newLine);
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String replaceTag(String tag, String targetTag, String replaceTag){
        Pattern p=Pattern.compile(targetTag);
        Matcher m=p.matcher(tag);
        if (m.find()){
            return m.replaceFirst(replaceTag);
        }
        return targetTag;
    }

    public String replaceAttribute(String tag, String attribute, String value){
        Pattern p=Pattern.compile(attribute+"="+"\".*?\"");
        Matcher m=p.matcher(tag);
        if (m.find()){
            return m.replaceFirst(attribute+"="+"\""+value+"\"");
        }
        return tag;
    }
}
