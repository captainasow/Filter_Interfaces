import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {



        JFileChooser chooser = new JFileChooser();
        Scanner inFile;

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);
                ArrayList<String> filteredWords = collectAll(inFile);

                System.out.println("Here are your short words:");

                for (String word: filteredWords)
                {
                    System.out.println(word);
                }




            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> collectAll(Scanner sc) {

        ArrayList<String> shortWords = new ArrayList<>();

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            ShortWordFilter wordFilter = new ShortWordFilter();
            boolean filtered = wordFilter.accept(line);

            if (filtered)
            {
                shortWords.add(line);

            }

        }


        sc.close();

        return shortWords;
    }
}
