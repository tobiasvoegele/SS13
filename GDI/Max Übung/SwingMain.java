import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMain extends JFrame {
    private static final long serialVersionUID = -2479348283207711881L;

    private JMenuBar menubar1;

    private JMenu menubar1Menu1;
    private JMenu menubar1Menu2;
    private JMenu menubar1Menu3;

    private JMenuItem menubar1Menu1Menuitem1;
    private JMenuItem menubar1Menu1Menuitem2;
    private JMenuItem menubar1Menu1Menuitem3;

    private JMenuItem menubar1Menu2Menuitem1;
    private JMenuItem menubar1Menu2Menuitem2;
    private JMenuItem menubar1Menu2Menuitem3;

    private JMenuItem menubar1Menu3Menuitem1;
    private JMenuItem menubar1Menu3Menuitem2;
    private JMenuItem menubar1Menu3Menuitem3;

    public SwingMain() {
        setTitle("Swing Tutorial");
        setBounds(0, 0, 800, 600);

        // Anwendung schließt wenn Eigenschaft gesetzt ist
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Zentriert das Fenster

        initComponents();
        initListeners();
        setVisible(true);
    }

    private void initComponents() {

        menubar1 = new JMenuBar();

        menubar1Menu1 = new JMenu("Menu 1");
        menubar1Menu2 = new JMenu("Menu 2");
        menubar1Menu3 = new JMenu("Menu 3");

        menubar1Menu1Menuitem1 = new JMenuItem("MenuItem 1/1");
        menubar1Menu1Menuitem2 = new JMenuItem("MenuItem 1/2");
        menubar1Menu1Menuitem3 = new JMenuItem("MenuItem 1/3");

        menubar1Menu2Menuitem1 = new JMenuItem("MenuItem 2/1");
        menubar1Menu2Menuitem2 = new JMenuItem("MenuItem 2/2");
        menubar1Menu2Menuitem3 = new JMenuItem("MenuItem 2/3");

        menubar1Menu3Menuitem1 = new JMenuItem("MenuItem 3/1");
        menubar1Menu3Menuitem2 = new JMenuItem("MenuItem 3/2");
        menubar1Menu3Menuitem3 = new JMenuItem("MenuItem 3/3");

        menubar1.add(menubar1Menu1);
        menubar1.add(menubar1Menu2);
        menubar1.add(menubar1Menu3);

        menubar1Menu1.add(menubar1Menu1Menuitem1);
        menubar1Menu1.add(menubar1Menu1Menuitem2);
        menubar1Menu1.add(menubar1Menu1Menuitem3);

        menubar1Menu2.add(menubar1Menu2Menuitem1);
        menubar1Menu2.add(menubar1Menu2Menuitem2);
        menubar1Menu2.add(menubar1Menu2Menuitem3);

        menubar1Menu3.add(menubar1Menu3Menuitem1);
        menubar1Menu3.add(menubar1Menu3Menuitem2);
        menubar1Menu3.add(menubar1Menu3Menuitem3);

        setJMenuBar(menubar1);
    }

    private void initListeners(){
        menubar1Menu1Menuitem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hallo Welt! :-)");
            }
        });
    }

    public static void main(String[] args) {
        new SwingMain();
    }
}
