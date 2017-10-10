import javax.swing.*;
import java.io.File;
import java.util.Map;
import java.util.Scanner;


/**
 * The ReadProtein class processes the input proteins that will be returned with their original data set.
 * @author Daniel Machlab
 */
public class ReadProtein {

    /**
     * Scanner object reader iterates through the input protein list text file.
     */
    private Scanner reader;


    /**
     * Method openFile prepares text file GetOriginalData.txt to be scanned for proteins. File GetOriginalData.txt
     * must be located in the src folder under project ProSave.
     */
    public void openFile() {
        try {
            reader = new Scanner(new File("src\\GetOriginalData.txt"));

        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    /**
     * Method readFile reads GetOriginalData.txt for subset of proteins and prints out subset of proteins with original data.
     * @param keyMap Map generated by ReadProteinData class containing all proteins mapped to their original data.
     */
    public void readFile(Map<String, Double> keyMap, JTextArea outputField) {
        while (reader.hasNext()) {
            String proteinName = reader.next();
            double spectralCount = 0;
            if (keyMap.containsKey(proteinName))
                spectralCount = keyMap.get(proteinName);
            else
                outputField.append("ERROR" + proteinName + "\n");
            outputField.append(spectralCount + "\n");
        }

    }

    /**
     * Method close file closes the file GetOriginalData.txt.
     */
    public void closeFile() {
        reader.close();
    }

}
