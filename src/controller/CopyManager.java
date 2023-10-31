
package controller;

import Repository.ICopyRepository;
import Repository.CopyRepository;
import view.Menu;


public class CopyManager extends Menu<String>{
    static String[] mc ={"Copy file program.","Exit."};
    ICopyRepository copy;
    public CopyManager(){
        super("===== COPY PROGRAM =====",mc);
        copy = new CopyRepository();
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                copy.readFileConfig();
                break;
            case 2:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }
}
