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

class ReaderInformationDialog extends JDialog {

  private static final long serialVersionUID = 9092551044456132039L;
	private Biblioteka bib;
  
  public ReaderInformationDialog(Biblioteka bib) {
  this.bib = bib;	
    initUI();
  }
 
  public final void initUI() {
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    setModalityType(ModalityType.APPLICATION_MODAL);  
    setTitle("Wybierz czytelnika");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(500, 350);
    
    final JTextArea textArea = new JTextArea("");
      textArea.setMaximumSize(new Dimension(400, 200));
      textArea.setEditable(false);

    add(Box.createRigidArea(new Dimension(0, 6)));// 6 pixeli w pionie

    JLabel fname = new JLabel("Wybierz czytelnika:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
    add(fname);

    add(Box.createRigidArea(new Dimension(0, 6)));

    final JComboBox readerToShowComboBox = new JComboBox(bib.getCzytelnicy().toArray());
      readerToShowComboBox.setSelectedIndex(-1);
      readerToShowComboBox.setPreferredSize(new Dimension(450, 22));
      readerToShowComboBox.setMaximumSize(new Dimension(450, 22));
    
      readerToShowComboBox.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
          Czytelnik selectedReader = bib.getCzytelnicy().get(readerToShowComboBox.getSelectedIndex());
          textArea.setText("");
          ArrayList<Ksiazka> books = bib.znajdzKsiazkiCzytelnika(selectedReader);
          for (Ksiazka book: books) {  
            textArea.append(book +"\n");
          }	
        }
      });
    add(readerToShowComboBox);

    add(Box.createRigidArea(new Dimension(0, 10)));
        
  
    JLabel bname = new JLabel("Lista wypożyczonych książek:");
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

