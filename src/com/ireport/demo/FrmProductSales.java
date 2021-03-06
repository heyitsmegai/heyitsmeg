/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ireport.demo;

/**
 *
 * @author Admin01
 */
public class FrmProductSales extends javax.swing.JFrame {

    /**
     * Creates new form FrmProductSales
     */
    public FrmProductSales() {
        initComponents();
        
        //Database Connection Setup
        SQLite.url = "jdbc:sqlite:D:\\java-sqlite-ireport-master\\src\\com\\ireport\\demo\\db.sqlite";
        SQLite.username = "";
        SQLite.password = "";
        SQLite.className = "org.sqlite.JDBC";
        
        //Basic Setup
        UIC.Frame.setDefault(this);
        
        //Load data to JTables
        if(SQLite.openDB()){
            String[] columnsProducts = {"ID", "PNAME", "QTY", "DESC", "PRICE"};
            String[][] recordsProducts = SQLite.executeDQL("product", columnsProducts, "1=1");
            UIC.Table.setModel(tblProducts, recordsProducts, columnsProducts);
            
            //Refresh the JTable Sales
            String[] columnsSales = {"ID", "TID", "PNAME", "DOP", "PRICE"};
            String[][] recordsSales = SQLite.executeDQL("sales", columnsSales, " TID='"+lblTID.getText()+"'");
            UIC.Table.setModel(tblSales, recordsSales, columnsSales);         
            SQLite.closeDB();
        }
        
        //Add EventListener to JTable Product
        javax.swing.JTable table = tblProducts;
        table.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                if (table.getSelectedRow() > -1) {
                    // print first column value from selected row
                    String selectedID = table.getValueAt(table.getSelectedRow(), 0).toString();
                    String selectedPNAME = table.getValueAt(table.getSelectedRow(), 1).toString();
                    String selectedPRICE = table.getValueAt(table.getSelectedRow(), 4).toString();
                    
                    txtOrderPname.setText(selectedPNAME);
                    txtOrderPID.setText(selectedID);
                    txtOrderPrice.setText(selectedPRICE);
                }
            }
        });        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPrintProducts = new javax.swing.JButton();
        btnPrintSales = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTID = new javax.swing.JLabel();
        btnGenerateNewTransID = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtOrderPname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOrderPID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtOrderQty = new javax.swing.JTextField();
        btnOrder = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtOrderPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("clydeatuic Demo (Swing + JDBC + SQLite + iReport)");

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSales);

        jLabel1.setText("Products");

        jLabel2.setText("Sales");

        btnPrintProducts.setText("Print All Products");
        btnPrintProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintProductsActionPerformed(evt);
            }
        });

        btnPrintSales.setText("Print All Sales");
        btnPrintSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSalesActionPerformed(evt);
            }
        });

        jLabel3.setText("Transaction ID");

        lblTID.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lblTID.setText("000000-000000");

        btnGenerateNewTransID.setText("Generate New Transaction ID");
        btnGenerateNewTransID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateNewTransIDActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Order Details");

        txtOrderPname.setEditable(false);
        txtOrderPname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("Product Name");

        jLabel7.setText("Product ID");

        txtOrderPID.setEditable(false);
        txtOrderPID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Qty");

        txtOrderQty.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        txtOrderQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrderQty.setText("1");

        btnOrder.setBackground(new java.awt.Color(255, 51, 102));
        btnOrder.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnOrder.setText("ORDER");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtOrderQty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrderQty, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel9.setText("Price");

        txtOrderPrice.setEditable(false);
        txtOrderPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtOrderPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOrderPrice.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txtOrderPname, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtOrderPID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtOrderPrice)))))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintSales, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnGenerateNewTransID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTID)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerateNewTransID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrintProducts)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrintSales)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintProductsActionPerformed
        try{
            if(SQLite.openDB()){
                String reportName = "src\\com\\ireport\\demo\\reportProd.jrxml";
                UIC.Report.viewReport(reportName);
                //UIC.Report.viewReport(jspReport, reportName);
                SQLite.closeDB();
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }        
    }//GEN-LAST:event_btnPrintProductsActionPerformed

    private void btnPrintSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSalesActionPerformed
        try{
            if(SQLite.openDB()){
                String reportName = "src\\com\\ireport\\demo\\reportSales.jrxml";
                UIC.Report.viewReport(reportName);
                //UIC.Report.viewReport(jspReport, reportName);
                SQLite.closeDB();
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }         
    }//GEN-LAST:event_btnPrintSalesActionPerformed

    private void btnGenerateNewTransIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateNewTransIDActionPerformed
        String newTransactionID = UIC.Date.getAutoGeneratedID("MMddYY-HHmmss");
        lblTID.setText(newTransactionID);        
        lblTotal.setText("0");
        //Refresh the JTable Sales
        String[] columnsSales = {"ID", "TID", "PNAME", "DOP", "PRICE"};
        String[][] recordsSales = SQLite.executeDQL("sales", columnsSales, " TID='"+lblTID.getText()+"'");
        UIC.Table.setModel(tblSales, recordsSales, columnsSales);           
    }//GEN-LAST:event_btnGenerateNewTransIDActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        String transID = lblTID.getText();
        
        String orderPname = txtOrderPname.getText();
        
        String orderPriceStringFormat = txtOrderPrice.getText();        
        double orderPriceDoubleFormat = Double.parseDouble(orderPriceStringFormat);

        String orderQtyStringFormat = txtOrderQty.getText();
        double orderQtyDoubleFormat = Double.parseDouble(orderQtyStringFormat);
        
        double orderTotalDoubleFormat = orderPriceDoubleFormat * orderQtyDoubleFormat;
        String orderTotal = orderTotalDoubleFormat + "";
        
        if(SQLite.openDB()){
            if(!transID.equals("000000-000000")){
                boolean result = SQLite.executeDML("insert into sales (tid, pname, price) values('"+transID+"', '"+orderPname+"', "+orderTotal+")");
                if(result){
                    //Refresh the JTable Sales
                    String[] columnsSales = {"ID", "TID", "PNAME", "DOP", "PRICE"};
                    String[][] recordsSales = SQLite.executeDQL("sales", columnsSales, " TID='"+lblTID.getText()+"'");
                    UIC.Table.setModel(tblSales, recordsSales, columnsSales);
                    
                    //Compute the total sales inside the table, since PRICE is in the 5th column then we set our array index to 4.
                    int index = 4;
                    double total = 0.0;
                    for(int i=0;i<recordsSales.length;i++){
                        String priceStringFormat = recordsSales[i][index];
                        double priceDoubleFormat = Double.parseDouble(priceStringFormat);                        
                        total+=priceDoubleFormat;
                    }
                    lblTotal.setText(total+"");
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(null, "Unable to process order!\n\nSomething went wrong during the process.");
                }
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(null, "Unable to process order!\n\nDon't forget to generate new transaction ID\nto start new orders.");
            }
            SQLite.closeDB();
        }
    }//GEN-LAST:event_btnOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProductSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateNewTransID;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPrintProducts;
    private javax.swing.JButton btnPrintSales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTID;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtOrderPID;
    private javax.swing.JTextField txtOrderPname;
    private javax.swing.JTextField txtOrderPrice;
    private javax.swing.JTextField txtOrderQty;
    // End of variables declaration//GEN-END:variables
}
