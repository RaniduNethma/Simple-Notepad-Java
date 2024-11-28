public class FunctionView {
    GUI guiView;

    public FunctionView(GUI guiView){
        this.guiView = guiView;
    }

    public void wordWrap(){

        if (guiView.wordWrapOn == false){

            guiView.wordWrapOn = true;
            guiView.textArea.setLineWrap(true);
            guiView.textArea.setWrapStyleWord(true);
            guiView.itemWordWrap.setText("Word wrap: On");
        }

        else if (guiView.wordWrapOn == true) {
            guiView.wordWrapOn = false;
            guiView.textArea.setLineWrap(false);
            guiView.textArea.setWrapStyleWord(false);
            guiView.itemWordWrap.setText("Word wrap: Off");
        }
    }
}
