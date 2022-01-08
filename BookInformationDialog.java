import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

class BookInformationDialog extends JDialog {

  private static final long serialVersionUID = 9092551044456132039L;
	private Biblioteka bib;
  
  public BookInformationDialog(Biblioteka bib) {
  this.bib = bib;	
    initUI();
  }
 
  public final void initUI() {
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    setModalityType(ModalityType.APPLICATION_MODAL);  
    setTitle("Informacje o książkach");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(500, 350);
    
    final JTextArea textArea = new JTextArea("");
      textArea.setMaximumSize(new Dimension(400, 200));
      textArea.setEditable(false);

    add(Box.createRigidArea(new Dimension(0, 6)));

    JLabel fname = new JLabel("Wybierz książkę:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
    add(fname);

    add(Box.createRigidArea(new Dimension(0, 6)));

    final JComboBox bookToShowComboBox = new JComboBox(bib.getKsiazki().toArray());
      bookToShowComboBox.setSelectedIndex(-1);
      bookToShowComboBox.setPreferredSize(new Dimension(450, 22));
      bookToShowComboBox.setMaximumSize(new Dimension(450, 22));
    
      bookToShowComboBox.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
          Ksiazka selectedBook = bib.getKsiazki().get(bookToShowComboBox.getSelectedIndex());
          ArrayList<Czytelnik> readers = bib.znajdzWypozyczajacychKsiazke(selectedBook);
          textArea.setText("");
          for (Czytelnik reader : readers) {  
            textArea.append(reader +"\n");
          }	
        }
      });
    add(bookToShowComboBox);

    add(Box.createRigidArea(new Dimension(0, 10)));
        
  
    JLabel bname = new JLabel("Wypożyczone przez:");
        bname.setFont(new Font("Serif", Font.BOLD, 12));
        bname.setAlignmentX(0.5f);
    add(bname);

    add(Box.createRigidArea(new Dimension(0, 10)));
    add(textArea);
    add(Box.createRigidArea(new Dimension(0, 10)));
    
    JButton cancelButton = new JButton("Zamknij");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          dispose();
        }
      });

      cancelButton.setAlignmentX(0.5f);
    add(cancelButton);

    add(Box.createRigidArea(new Dimension(0, 10)));
  }
}

