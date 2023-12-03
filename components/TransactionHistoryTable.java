
package components;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransactionHistoryTable extends JTable {
  String[] columns = { "Date", "Amount", "Balance" };
  DefaultTableModel tableModel = null;

  public TransactionHistoryTable() {
    this.setFillsViewportHeight(true);
  }

  public void addRow(TransactionRow transactionRow) {
    Object[] row = {
      transactionRow.date,
      transactionRow.amount,
      transactionRow.balance
    };

    if (this.tableModel == null) {
      Object[][] rows = { row };
      this.tableModel = new DefaultTableModel(rows, this.columns);
      this.setModel(this.tableModel);
    } else {
      this.tableModel.insertRow(0, row);
    }
  }
}