import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Okno dodawania nowego czytelnika
class ReaderDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
    public ReaderDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Imie:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField fnameTextField = new JTextField(20);
        add(fnameTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Nazwisko:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField lnameTextField = new JTextField(20);
        add(lnameTextField);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Dodaj");
        
        // Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajCzytelnika(new Czytelnik(fnameTextField.getText(), lnameTextField.getText(), bib.kolejny_numer_czytelnika()));
              bib.saveObjectToFile("czytelnicyFile.ser", bib.getCzytelnicy());
              dispose();
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dodaj czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 220);
    }
}
