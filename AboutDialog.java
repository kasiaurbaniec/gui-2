import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

// Okno "About"
class AboutDialog extends JDialog {
    
	private static final long serialVersionUID = 8169178928427118906L;

	public AboutDialog() {

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel name = new JLabel("Biblioteka, 1.00");
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setAlignmentX(0.5f);
        add(name);

        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton close = new JButton("Zamknij");

        // Akcja podpieta pod przycisk "Zamknij"
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("O programie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
    }
}
