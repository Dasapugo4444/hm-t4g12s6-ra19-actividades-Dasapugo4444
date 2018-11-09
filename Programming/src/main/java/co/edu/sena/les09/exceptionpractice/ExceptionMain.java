package co.edu.sena.les09.exceptionpractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {

    public static void main(String[] args) {
        try {
            System.out.println("Leyendo del archivo: "+args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No hay archivo seleccionado we");
            System.exit(1);
        }

        try (BufferedReader b= new BufferedReader(new FileReader(args[0]));)
        {
            String s=null;
            while ((s=b.readLine())!=null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+args[0]);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error leyendo el archivito: "+e.getMessage());
            System.exit(1);
        }
    }

}
