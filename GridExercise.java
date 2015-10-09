import java.util.Random;
import java.util.Scanner;

public class GridExercise{

    static Scanner sc = new Scanner(System.in);
    static int row = 0;
    static int cols = 0;
    static String[][] values;
    
    public static void main(String[] args){        
        GridExercise ge = new GridExercise();
        System.out.print("Enter number of rows: ");
        row = sc.nextInt();
        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();
        values = new String[row][cols];
        ge.populateArray();
        ge.initializeGrid();
        ge.showOptions();
    }
    
    void showOptions(){
        System.out.print("\nOPTIONS:\n" + 
                        "[1] Print\n" +
                        "[2] Edit \n" +
                        "[3] Search \n" + 
                        "Choose Your Option: ");
        int option = sc.nextInt();
        
        if(option == 1){
            initializeGrid();
            showOptions();
        }
        else if(option == 2){
            editData();
            showOptions();
        }
        else if(option == 3){
            searchString();
            showOptions();  
        }
        else
            return;
    }
    
    void searchString(){
        System.out.print("\nEnter search parameter: ");
        String searchParam = sc.next();
        String output = "";
        int counter = 0;
        
        if(searchParam.length() <= 3 && searchParam.matches("[a-z]+")){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < cols; j++){
                    if(values[i][j].contains(searchParam)){
                        counter++;
                        output += "[" + (i + 1) + "][" + (j + 1) + "] ";
                    }
                }
            }
            System.out.println("Search parameter \"" + searchParam + 
            "\" occured (" + counter + ") time(s) at \n" + output);
        }
        else
            System.out.println("Search parameter not accepted");
    }
    
    void editData(){
        System.out.print("\nEnter row to edit: ");
        int rowToEdit = sc.nextInt();
        System.out.print("Enter column to edit: ");
        int colToEdit = sc.nextInt();
        if(row < rowToEdit || cols < colToEdit){
            System.out.println("Row/column not found!");
            showOptions();
        }
        else{
            System.out.print("Enter value to replace: ");
            String value = sc.next();
            if(value.length() == 3 && value.matches("[a-z]+"))
                values[rowToEdit - 1][colToEdit - 1] = value.toLowerCase();
            else{
                System.out.println("Only accepts lower case alphabets");
                showOptions();
            }
        }
    }
    
    void populateArray(){
        for(int i = 0; i < row; i++){//rows
            for(int j = 0; j < cols; j++){//columns   
                values[i][j] = generateThreeLetters();
            }
        }
    }
    
    void initializeGrid(){
        System.out.println();
        for(int i = 0; i < row; i++){//rows
            System.out.print("| ");
            for(int j = 0; j < cols; j++){//columns   
                System.out.print(values[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
    
    String generateThreeLetters(){
        Random random = new Random();
        char[] chars = new char[3];
        for(int i = 0; i < 3; i++){
            chars[i] = (char)(random.nextInt(26) + 'a');
        }
        String a = "";
        for(char c : chars){
            a = a + c;
        }
        return a;
    }
}
