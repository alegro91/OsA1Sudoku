package Group14.SudokuSolver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * A class for reading and interpreting comma-delimited .txt files.
 * Only has one method which creates an ArrayList of String objects
 * and returns them to the controller.
 * Took inspiration from an old csv reader I made
 *
 * @author (Alejandro Grønhaug)
 * @version (v0.1)
 */

public class CSV_Reader
{
    BufferedReader reader;
    ArrayList<String> sudokuValues = new ArrayList();


    public CSV_Reader()
    { }

    /**
     *Reads the comma delimited .txt file fed to it and extracts relevant data.
     * Stores the fields of each line in an array of strings whic are then
     * stored in an ArrayList of Strings.
     * @param filePath The path of the file to be loaded
     * @return sudokuValues An ArrayList of the data in the file to be used in the Controller class
     * @throws IOException
     */
    public ArrayList<String> fileParseToArrayList(File filePath) throws IOException
    {
        String path = filePath.getAbsolutePath();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        //Parses a .txt file through a Scanner class constructor

        String stringToBeSplit= reader.readLine();

        while(stringToBeSplit !=null)
        {
            stringToBeSplit = reader.readLine();
            if(stringToBeSplit !=null) {
                //System.out.println(stringToBeSplit);
                String[] fields = stringToBeSplit.split(",");
                for (int i = 0; i<91;i++)
                {
                    sudokuValues.add(fields[i]);
                }
            }
        }
        return sudokuValues;

    }
}

