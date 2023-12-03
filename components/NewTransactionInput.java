
package components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTransactionInput extends JPanel implements ActionListener {
  private double value = 0.00d;
  GridLayout amountLayout = new GridLayout(2, 1);
  JTextField amountField = new JTextField(10);
  JButton submitButton = new JButton("Submit");
  ButtonListener listener;

  public NewTransactionInput(ButtonListener listener) {
    this.listener = listener;
    this.submitButton.addActionListener(this);

    this.amountField.setText(String.format("%.2f", this.value));
    this.amountField.setMaximumSize(new Dimension(143, 30));
    this.amountField.setHorizontalAlignment(JTextField.RIGHT);
    this.amountLayout.setVgap(4);

    this.setLayout(this.amountLayout);
    this.add(this.amountField);
    this.add(this.submitButton);
  }

  public void actionPerformed(ActionEvent event) {
    try {
      this.value = Double.valueOf(this.amountField.getText());
    } catch (Exception e) {
      System.out.print(e);
      this.value = 0.00d;
    } finally {
      this.value = Math.round(this.value * 100.0) / 100.0;
      this.amountField.setText(String.format("%.2f", this.value));
      this.listener.onSubmit(this.value);
    }
  }
}