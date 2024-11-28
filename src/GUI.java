import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuView;
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
    JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemFind, itemSelectAll;
    JMenuItem itemWordWrap;
    JMenuItem itemTimesNewRoman, itemArial, itemComicSans;
    JMenuItem itemRegular, itemItalic, itemBold, itemBoldItalic;
    JMenuItem item8, item9, item10, item11, item12, item14, item16, item18, item20,
            item22, item24, item26, item28, item36, item48, item72;
    JMenu menuFont;
    JMenu menuFontFamily, menuFontStyle, menuFontSize;
    FunctionFile file = new FunctionFile(this);
    FunctionEdit edit = new FunctionEdit(this);
    FunctionView view = new FunctionView(this);

    public static void main(String[] args){
        new GUI();
    }

    public GUI(){

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createViewMenu();

        edit.selectedFont = "arial";
        edit.selectedStyle = Font.PLAIN;
        edit.createFontsize(14);
        view.wordWrap();
        window.setVisible(true);
        window.setLocation(300, 150);
    }

    public void createWindow(){

        window = new JFrame("Notepad");
        window.setSize(900, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createTextArea(){

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuView = new JMenu("View");
        menuBar.add(menuView);
    }

    public void createFileMenu(){

        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save as");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("save as");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("exit");
        menuFile.add(itemExit);
    }

    public void createEditMenu(){

        itemUndo = new JMenuItem("Undo");
        itemUndo.addActionListener(this);
        itemUndo.setActionCommand("undo");
        menuEdit.add(itemUndo);

        itemCut = new JMenuItem("Cut");
        itemCut.addActionListener(this);
        itemCut.setActionCommand("cut");
        menuEdit.add(itemCut);

        itemCopy = new JMenuItem("Copy");
        itemCopy.addActionListener(this);
        itemCopy.setActionCommand("copy");
        menuEdit.add(itemCopy);

        itemPaste = new JMenuItem("Paste");
        itemPaste.addActionListener(this);
        itemPaste.setActionCommand("paste");
        menuEdit.add(itemPaste);

        itemDelete = new JMenuItem("Delete");
        itemDelete.addActionListener(this);
        itemDelete.setActionCommand("delete");
        menuEdit.add(itemDelete);

        itemFind = new JMenuItem("Find");
        itemFind.addActionListener(this);
        itemFind.setActionCommand("find");
        menuEdit.add(itemFind);

        itemSelectAll = new JMenuItem("Select all");
        itemSelectAll.addActionListener(this);
        itemSelectAll.setActionCommand("select all");
        menuEdit.add(itemSelectAll);

        menuFont = new JMenu("Font");
        menuEdit.add(menuFont);

        menuFontFamily = new JMenu("Font family");
        menuFont.add(menuFontFamily);

        menuFontStyle = new JMenu("Font style");
        menuFont.add(menuFontStyle);

        menuFontSize = new JMenu("Font size");
        menuFont.add(menuFontSize);

        itemTimesNewRoman = new JMenuItem("Times new roman");
        itemTimesNewRoman.addActionListener(this);
        itemTimesNewRoman.setActionCommand("times new roman");
        menuFontFamily.add(itemTimesNewRoman);

        itemArial = new JMenuItem("Arial");
        itemArial.addActionListener(this);
        itemArial.setActionCommand("arial");
        menuFontFamily.add(itemArial);

        itemComicSans = new JMenuItem("Comic sans");
        itemComicSans.addActionListener(this);
        itemComicSans.setActionCommand("comic sans");
        menuFontFamily.add(itemComicSans);

        itemRegular = new JMenuItem("Regular");
        itemRegular.addActionListener(this);
        itemRegular.setActionCommand("regular");
        menuFontStyle.add(itemRegular);

        itemItalic = new JMenuItem("Italic");
        itemItalic.addActionListener(this);
        itemItalic.setActionCommand("italic");
        menuFontStyle.add(itemItalic);

        itemBold = new JMenuItem("Bold");
        itemBold.addActionListener(this);
        itemBold.setActionCommand("bold");
        menuFontStyle.add(itemBold);

        itemBoldItalic = new JMenuItem("Bold-Italic");
        itemBoldItalic.addActionListener(this);
        itemBoldItalic.setActionCommand("bold-italic");
        menuFontStyle.add(itemBoldItalic);

        item8 = new JMenuItem("8px");
        item8.addActionListener(this);
        item8.setActionCommand("8");
        menuFontSize.add(item8);

        item9 = new JMenuItem("9px");
        item9.addActionListener(this);
        item9.setActionCommand("9");
        menuFontSize.add(item9);

        item10 = new JMenuItem("10px");
        item10.addActionListener(this);
        item10.setActionCommand("10");
        menuFontSize.add(item10);

        item11 = new JMenuItem("11px");
        item11.addActionListener(this);
        item11.setActionCommand("11");
        menuFontSize.add(item11);

        item12 = new JMenuItem("12px");
        item12.addActionListener(this);
        item12.setActionCommand("12");
        menuFontSize.add(item12);

        item14 = new JMenuItem("14px");
        item14.addActionListener(this);
        item14.setActionCommand("14");
        menuFontSize.add(item14);

        item16 = new JMenuItem("16px");
        item16.addActionListener(this);
        item16.setActionCommand("16");
        menuFontSize.add(item16);

        item18 = new JMenuItem("18px");
        item18.addActionListener(this);
        item18.setActionCommand("18");
        menuFontSize.add(item18);

        item20 = new JMenuItem("20px");
        item20.addActionListener(this);
        item20.setActionCommand("20");
        menuFontSize.add(item20);

        item22 = new JMenuItem("22px");
        item22.addActionListener(this);
        item22.setActionCommand("22");
        menuFontSize.add(item22);

        item24 = new JMenuItem("24px");
        item24.addActionListener(this);
        item24.setActionCommand("24");
        menuFontSize.add(item24);

        item26 = new JMenuItem("26px");
        item26.addActionListener(this);
        item26.setActionCommand("26");
        menuFontSize.add(item26);

        item28 = new JMenuItem("28px");
        item28.addActionListener(this);
        item28.setActionCommand("28");
        menuFontSize.add(item28);

        item36 = new JMenuItem("36px");
        item36.addActionListener(this);
        item36.setActionCommand("36");
        menuFontSize.add(item36);

        item48 = new JMenuItem("48px");
        item48.addActionListener(this);
        item48.setActionCommand("48");
        menuFontSize.add(item48);

        item72 = new JMenuItem("72px");
        item72.addActionListener(this);
        item72.setActionCommand("72");
        menuFontSize.add(item72);
    }

    public void createViewMenu(){

        itemWordWrap = new JMenuItem("Word wrap: Off");
        itemWordWrap.addActionListener(this);
        itemWordWrap.setActionCommand("word wrap");
        menuView.add(itemWordWrap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.equals("New")) {
            file.newFile();
        }
        if (command.equals("open")){
            file.openFile();
        }
        if (command.equals("save")){
            file.save();
        }
        if (command.equals("save as")){
            file.saveAs();
        }
        if (command.equals("exit")){
            file.exit();
        }

        if (command.equals("arial")){
            edit.createFontFamily(command);
        }
        if (command.equals("times new roman")){
            edit.createFontFamily(command);
        }
        if (command.equals("comic sans")){
            edit.createFontFamily(command);
        }

        if (command.equals("regular")) {
            edit.createFontStyle(Font.PLAIN);
        }
        if (command.equals("bold")) {
            edit.createFontStyle(Font.BOLD);
        }
        if (command.equals("italic")) {
            edit.createFontStyle(Font.ITALIC);
        }
        if (command.equals("bold-italic")) {
            edit.createFontStyle(Font.BOLD | Font.ITALIC);
        }

        if (command.equals("8")){
            edit.createFontsize(8);
        }
        if (command.equals("9")){
            edit.createFontsize(9);
        }
        if (command.equals("10")){
            edit.createFontsize(10);
        }
        if (command.equals("11")){
            edit.createFontsize(11);
        }
        if (command.equals("12")){
            edit.createFontsize(12);
        }
        if (command.equals("14")){
            edit.createFontsize(14);
        }
        if (command.equals("16")){
            edit.createFontsize(16);
        }
        if (command.equals("18")){
            edit.createFontsize(18);
        }
        if (command.equals("20")){
            edit.createFontsize(20);
        }
        if (command.equals("22")){
            edit.createFontsize(22);
        }
        if (command.equals("24")){
            edit.createFontsize(24);
        }
        if (command.equals("26")){
            edit.createFontsize(26);
        }
        if (command.equals("28")){
            edit.createFontsize(28);
        }
        if (command.equals("36")){
            edit.createFontsize(36);
        }
        if (command.equals("48")){
            edit.createFontsize(48);
        }
        if (command.equals("72")){
            edit.createFontsize(72);
        }

        if (command.equals("word wrap")){
            view.wordWrap();
        }
    }
}
