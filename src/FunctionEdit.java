import java.awt.*;

public class FunctionEdit {

    GUI guiEdit;
    String selectedFont;
    int selectedStyle;

    public FunctionEdit(GUI guiEdit){
        this.guiEdit = guiEdit;
    }

    public void undo(){
    }

    public void cut(){
    }

    public void copy(){
    }

    public void paste(){
    }

    public void delete(){
    }

    public void find(){
    }

    public void selectAll(){
    }

    public void createFontFamily(String font){

        selectedFont = font;

        if (selectedFont != null) {
            Font updatedFont = new Font(selectedFont, selectedStyle, guiEdit.textArea.getFont().getSize());
            guiEdit.textArea.setFont(updatedFont);
        }
    }

    public void createFontsize(int fontSize) {
        if (selectedFont != null) {
            Font updatedFont = new Font(selectedFont, selectedStyle, fontSize);
            guiEdit.textArea.setFont(updatedFont);
        }
    }

    public void createFontStyle(int fontStyle) {
        selectedStyle = fontStyle;

        if (selectedFont != null) {
            Font updatedFont = new Font(selectedFont, selectedStyle, guiEdit.textArea.getFont().getSize());
            guiEdit.textArea.setFont(updatedFont);
        }
    }
}
