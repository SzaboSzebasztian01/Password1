import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NewPass {
    Scanner scanner;

    public NewPass() {
        scanner = new Scanner(System.in);
    }


    public void addNewPass(){
        System.out.print("\n-----Új jelszó-----\n");
        System.out.print("\nHasználat: ");
        String use = this.scanner.nextLine();

        System.out.print("Jelszó: ");
        String pass = this.scanner.nextLine();
        System.out.println("Folytatáshoz nyomjon egy Entert...");
        appendToFile(use, pass);

    }


    private void appendToFile(String using, String pass){

        try {
            tryAppendToFile(using, pass);

        } catch (IOException e) {

            System.err.println("A fájlba írás sikertelen");

        }

    }


    private void tryAppendToFile(String using, String pass) throws IOException{
        FileWriter fileWriter = new FileWriter("data.txt", Charset.forName("utf-8"), true);

        PrintWriter printWriter = new PrintWriter(fileWriter);
        String line = using + ":" + pass;
        printWriter.println(line);
        printWriter.close(); 

    }

}
