
package components;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionHistorySection extends JTabbedPane {
  TransactionHistoryTable depositsTable = new TransactionHistoryTable();
  TransactionHistoryTable withdrawalsTable = new TransactionHistoryTable();
  JScrollPane depositsPane = null; 
  JScrollPane withdrawalsPane = null;

  public TransactionHistorySection() {
    this.depositsPane = new JScrollPane(depositsTable);
    this.withdrawalsPane = new JScrollPane(withdrawalsTable);

    this.setMinimumSize(new Dimension(0, 198));
    this.addTab("Deposits", this.depositsPane);
    this.addTab("Withdrawals", this.withdrawalsPane);
  }

  public void addTransaction(Transaction type, double amount, double balance) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String dateText = dateFormat.format(new Date());
    String amountText = String.format("$%,.2f", amount);
    String balanceText = String.format("$%,.2f", balance);

    if (type == Transaction.DEPOSIT) {
      this.depositsTable.addRow(new TransactionRow(
        String.format("%17s", dateText), 
        String.format("%17s", amountText), 
        String.format("%17s", balanceText)));
    }

    if (type == Transaction.WITHDRAW) {
      this.withdrawalsTable.addRow(new TransactionRow(
        String.format("%17s", dateText), 
        String.format("%10s%s", "-", amountText), 
        String.format("%17s", balanceText)));
    }
  }
}


