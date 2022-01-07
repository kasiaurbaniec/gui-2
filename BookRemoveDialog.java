import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

class BookRemoveDialog extends JDialog {

  private static final long serialVersionUID = 9092551044456132037L;
	private Biblioteka bib;
  
  public BookRemoveDialog(Biblioteka bib) {
  this.bib = bib;	
    initUI();
  }

  public final void initUI() {
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    setModalityType(ModalityType.APPLICATION_MODAL);  
    setTitle("Usuń książkę");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(500, 150);
    
    add(Box.createRigidArea(new Dimension(0, 6)));// 6 pixeli w pionie

    JLabel fname = new JLabel("Wybierz książkę do usunięcia:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
    add(fname);

    add(Box.createRigidArea(new Dimension(0, 6)));

    final JComboBox booksToRemoveComboBox = new JComboBox(bib.getKsiazki().toArray());
        booksToRemoveComboBox.setSelectedIndex(-1);
        booksToRemoveComboBox.setPreferredSize(new Dimension(450, 22));
        booksToRemoveComboBox.setMaximumSize(new Dimension(450, 22));
    add(booksToRemoveComboBox);
    
    add(Box.createRigidArea(new Dimension(0, 10)));

    JButton removeBookButton = new JButton("Usun ksiażkę");
      removeBookButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          bib.usunKsiazke(bib.getKsiazki().get(booksToRemoveComboBox.getSelectedIndex()));
          dispose();
        }
      });
      removeBookButton.setAlignmentX(0.5f);
    add(removeBookButton);
        
    add(Box.createRigidArea(new Dimension(0, 10)));
        
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