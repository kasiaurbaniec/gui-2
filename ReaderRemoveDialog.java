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

class ReaderRemoveDialog extends JDialog {

  private static final long serialVersionUID = 9092551044456132038L;
	private Biblioteka bib;
  
  public ReaderRemoveDialog(Biblioteka bib) {
  this.bib = bib;	
    initUI();
  }

  public final void initUI() {
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    setModalityType(ModalityType.APPLICATION_MODAL);  
    setTitle("Usuń czytelnika");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(500, 150);
    
    add(Box.createRigidArea(new Dimension(0, 6)));// 6 pixeli w pionie

    JLabel fname = new JLabel("Wybierz czytelnika do usunięcia:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
    add(fname);

    add(Box.createRigidArea(new Dimension(0, 6)));

    final JComboBox readerToRemoveComboBox = new JComboBox(bib.getCzytelnicy().toArray());
      readerToRemoveComboBox.setSelectedIndex(-1);
      readerToRemoveComboBox.setPreferredSize(new Dimension(450, 22));
      readerToRemoveComboBox.setMaximumSize(new Dimension(450, 22));
    add(readerToRemoveComboBox);
    
    add(Box.createRigidArea(new Dimension(0, 10)));

    JButton removeReaderButton = new JButton("Usun czytelnika");
      removeReaderButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          bib.usunCzytelnika(bib.getCzytelnicy().get(readerToRemoveComboBox.getSelectedIndex()));
          dispose();
        }
      });
      removeReaderButton.setAlignmentX(0.5f);
    add(removeReaderButton);
        
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

