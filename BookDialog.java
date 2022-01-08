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


public class BookDialog extends JDialog{
  
private static final long serialVersionUID = 9092551044456132036L;
	private Biblioteka bib;
  
  public BookDialog(Biblioteka bib) {
  this.bib = bib;	
    initUI();
  }

  public final void initUI() {

    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    add(Box.createRigidArea(new Dimension(0, 6)));// 6 pixeli w pionie
    setModalityType(ModalityType.APPLICATION_MODAL);  
    setTitle("Dodaj książkę");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(400, 350);

    //Sekcja Tytuł
    add(Box.createRigidArea(new Dimension(0, 6)));
    JLabel ltitle = new JLabel("Tytuł:");
      ltitle.setFont(new Font("Serif", Font.BOLD, 12));
      ltitle.setAlignmentX(0.5f);
    add(ltitle);
    add(Box.createRigidArea(new Dimension(0, 6)));
    final JTextField fTitleTextField = new JTextField(20);
    add(fTitleTextField);

    //Sekcja Autor
    add(Box.createRigidArea(new Dimension(0, 6)));
    JLabel lauthor = new JLabel("Autor:");
      lauthor.setFont(new Font("Serif", Font.BOLD, 12));
      lauthor.setAlignmentX(0.5f);
    add(lauthor);
    add(Box.createRigidArea(new Dimension(0, 6)));
    final JTextField fauthorTextField = new JTextField(20);
    add(fauthorTextField);

    //Sekcja ISBN
    add(Box.createRigidArea(new Dimension(0, 6)));
    JLabel lisbn = new JLabel("ISBN:");
      lisbn.setFont(new Font("Serif", Font.BOLD, 12));
      lisbn.setAlignmentX(0.5f);
    add(lisbn);
    add(Box.createRigidArea(new Dimension(0, 6)));
    final JTextField fisbnTextField = new JTextField(10);
    add(fisbnTextField);

    //Sekcja liczba egzemplarzy
    add(Box.createRigidArea(new Dimension(0, 6)));
    JLabel legz = new JLabel("Liczba egzeplarzy:");
      legz.setFont(new Font("Serif", Font.BOLD, 12));
      legz.setAlignmentX(0.5f);
    add(legz);
    add(Box.createRigidArea(new Dimension(0, 6)));
    final JTextField fegzTextField = new JTextField(10);
    add(fegzTextField);

    add(Box.createRigidArea(new Dimension(0, 10)));

    //Dodanie książki
    JButton addBookButton = new JButton("Dodaj");
    // Akcja podpieta pod przycisk "Dodaj"
    addBookButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        bib.dodajKsiazke(new Ksiazka(fauthorTextField.getText(), fTitleTextField.getText(), fisbnTextField.getText(),Integer.parseInt(fegzTextField.getText())));
        bib.saveObjectToFile("ksiazkiFile.ser",bib.getKsiazki());
        dispose();
      }
    });

    addBookButton.setAlignmentX(0.5f);
    add(addBookButton);

    add(Box.createRigidArea(new Dimension(0, 10)));
    // dodaję cancelButton    
    JButton cancelButton = new JButton("Anuluj");
    cancelButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    });
    cancelButton.setAlignmentX(0.5f);
    add(cancelButton);

    
  }
}