import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {
    GUI graphicalUserInterface;
    String fileName;
    String fileAddress;

    public FunctionFile(GUI guiFile){
        this.graphicalUserInterface = guiFile;
    }

    public void newFile(){

        graphicalUserInterface.textArea.setText("");
        graphicalUserInterface.window.setTitle("Untitled");
        fileName = null;
        fileAddress = null;
    }

    public void openFile(){

        FileDialog fileExplorer = new FileDialog(graphicalUserInterface.window, "open", FileDialog.LOAD);
        fileExplorer.setVisible(true);

        if (fileExplorer.getFile() != null){

            fileName = fileExplorer.getFile();
            fileAddress = fileExplorer.getDirectory();
            graphicalUserInterface.window.setTitle(fileName);
        }
        System.out.println("File Address and File Name : " + fileAddress + fileName);

        try {

            BufferedReader readContent = new BufferedReader(new FileReader(fileAddress + fileName));
            graphicalUserInterface.textArea.setText("");

            String line = null;
            while ((line = readContent.readLine()) != null){
                graphicalUserInterface.textArea.append(line + "\n");
            }

            readContent.close();
        }

        catch (Exception e){
            System.out.println("FILE NOT OPEN");
        }
    }

    public void save(){

        if (fileName == null){
            saveAs();
        }

        else {

            try {
                FileWriter writeFile = new FileWriter(fileAddress + fileName);
                writeFile.write(graphicalUserInterface.textArea.getText());
                graphicalUserInterface.window.setTitle(fileName);

                writeFile.close();
            }

            catch(Exception e) {
                System.out.println("SOMETHING WRONG");
            }
        }
    }

    public void saveAs(){

        FileDialog fileExplorer = new FileDialog(graphicalUserInterface.window, "Save as", FileDialog.SAVE);
        fileExplorer.setVisible(true);

        if (fileExplorer.getFile() != null){

            fileName = fileExplorer.getFile();
            fileAddress = fileExplorer.getDirectory();
            graphicalUserInterface.window.setTitle(fileName);
        }

        try {

            FileWriter writeFile = new FileWriter(fileAddress + fileName);
            writeFile.write(graphicalUserInterface.textArea.getText());

            writeFile.close();
        }

        catch (Exception e){
            System.out.println("SOMETHING WRONG");
        }
    }

    public void exit(){

        if (fileName == null){
            save();
            System.exit(0);
        }

        else {
            System.exit(0);
        }
    }
}
