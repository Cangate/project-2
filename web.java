package project;

import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class web {

    static boolean c = true;

    public static void main(final String[] args) {
        
        
        
        final File file = new File("Pic");
        
        final MyFile mf = new MyFile(file);
        final TreeModel model = new Tree(mf);
        final JTree tree = new JTree(model);
        final JFrame f = new JFrame("web Browser");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.PINK);
        f.setSize(1500, 1000);
        
        
       
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                
                TreePath treePath = e.getPath(); // หารูป
                String print = treePath.toString().replace("[", "").replace("]", "").replace(" ", "");
                String[] j = print.split(",");
                String path = "";
                
                for (int i = 0; i < j.length; i++) {
                    path += j[i];
                    if (i != j.length - 1) {
                        path += "/";
                    }
                }
                                String k = j[j.length - 1]; // เช็ครูป
                if (k.charAt(k.length() - 1) == 'g' && k.charAt(k.length() - 2) == 'p' && k.charAt(k.length() - 3) == 'j') {
                    Showpic.pic = path;
                    if (c) {
                        Showpic.draw.start();
                        c = false;
                    }
                }
                
            }
        });
        
        //ส่วนของแทปด้านขวา
       
        tree.setShowsRootHandles(true);
        tree.setEditable(false);
        final Showpic pi = new Showpic(); //panel  
        JScrollPane sc = new JScrollPane(tree); //จอเลื่อน
        
        sc.setBounds(0, 0, 200, 1000);
        f.add(sc);
        f.add(pi);
        f.setVisible(true);
    }
}
