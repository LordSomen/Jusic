package com.Jusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Jusic extends JPanel implements ActionListener {

  private JButton playButton;
  private JButton pauseButton;
  private JButton chooseButton;
  private JFileChooser fileChooser;
  private JTextArea textArea;

  public Jusic() {
    super(new BorderLayout());

    textArea = new JTextArea(5, 20);
    textArea.setMargin(new Insets(5, 5, 5, 5));
    textArea.setEditable(false);
    playButton = new JButton("Play");
    pauseButton = new JButton("Pause");
    chooseButton = new JButton("Choose");

    playButton.addActionListener(this);
    pauseButton.addActionListener(this);
    chooseButton.addActionListener(this);

    add(textArea, BorderLayout.NORTH);
    add(playButton, BorderLayout.EAST);
    add(pauseButton, BorderLayout.WEST);
    add(chooseButton, BorderLayout.CENTER);
  }

  private static void createAndShowGui() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);

    JFrame frame = new JFrame("Jusic");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JComponent playerContentPane = new Jusic();
    playerContentPane.setOpaque(true);
    frame.setContentPane(playerContentPane);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    EventQueue.invokeAndWait(new Runnable() {
      @Override
      public void run() {
        createAndShowGui();
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == chooseButton) {
      fileChooser = new JFileChooser();
      int returnVal = fileChooser.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
      }
    }
  }
}
