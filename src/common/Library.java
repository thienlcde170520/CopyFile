
package common;

import DataAccess.CopyDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;


public class Library {
    static Scanner sc = new Scanner(System.in);
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                
            }
        }
    }
    
    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }
    
    public boolean checkFileConfig(File propertiesFile) {
        Properties prop = new Properties();
        InputStream input = null;
        boolean exist = false;
        try {
            input = new FileInputStream(propertiesFile);
            prop.load(input);
            if (prop.getProperty("COPY_FOLDER").length() == 0) {
                System.err.println("Folder Sourse is not input");
            }
            if (prop.getProperty("DATA_TYPE").length() == 0) {
                System.err.println("Data type is not input");
            }
            if (prop.getProperty("PATH").length() == 0) {
                System.err.println("Folder Destination is not input");
            }
            exist = prop.getProperty("COPY_FOLDER") != null
                    && prop.getProperty("DATA_TYPE") != null
                    && prop.getProperty("PATH") != null;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Can read file configure!");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("File configure is not found!");
                }
            }
        }
        return exist;
    }
    
    public boolean checkInformationConfig(File f1, File f2) {
        boolean checkInformationConfig = f1.exists() && f1.isDirectory()
                && f2.exists() && f2.isDirectory();
        if (f1.exists() == false || f1.isDirectory() == false) {
            System.err.println("Can't find folder Sourse");
        }
        if (f2.exists() == false || f2.isDirectory() == false) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }
    
    
}
