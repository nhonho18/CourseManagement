package UI.Student;

import BLL.StudentBLL;
import DAL.Student.Student;
import UI.MenuForm;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentForm extends javax.swing.JFrame {

    StudentBLL stb = new StudentBLL();
    MenuForm home;

    public StudentForm() {
        this.setTitle("Student");
        initComponents();
        tbDS.fixTable(jScrollPane1);
        getContentPane().setBackground(Color.WHITE);
        try {
            listStudent();
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StudentForm(MenuForm parent, boolean modal) {
        this.setTitle("Student");
        initComponents();
        tbDS.fixTable(jScrollPane1);
        closeChidrentForm(parent, modal);
        getContentPane().setBackground(Color.WHITE);
        try {
            listStudent();
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeChidrentForm(MenuForm parent, boolean modal) {
        this.setLocationRelativeTo(null);
        this.home = parent;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(parent.DISPOSE_ON_CLOSE);
                parent.setVisible(true);
            }
        });
    }

    public void initTable() {
        try {
            listStudent();
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //for 3layer`
    private void listStudent() throws SQLException {
        List list = stb.LoadStudents();
        DefaultTableModel model = convertStudent(list);
        tbDS.setModel(model);
    }

    private DefaultTableModel convertStudent(List list) {
        String[] columnNames = {"Person ID", "First Name", "Last Name", "Enrollment Date"};
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            Student s = (Student) list.get(i);
            data[i][0] = s.getPersonId();
            data[i][1] = s.getFirstName();
            data[i][2] = s.getLastName();
            data[i][3] = s.getEnrollmentDate();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new UI.UI_Item.textfield.SearchField();
        btnSearch = new UI.UI_Item.button.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDS = new UI.UI_Item.table.TableDark();
        btnAdd = new UI.UI_Item.button.MyButton();
        btnEdit = new UI.UI_Item.button.MyButton();
        btnDelete = new UI.UI_Item.button.MyButton();
        btnBack = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setText("STUDENT");

        txtSearch.setText("Enter Name");
        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search (1).png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setMaximumSize(new java.awt.Dimension(91, 32));
        btnSearch.setMinimumSize(new java.awt.Dimension(91, 32));
        btnSearch.setPreferredSize(new java.awt.Dimension(91, 32));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        tbDS.setForeground(new java.awt.Color(102, 102, 102));
        tbDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PersonID", "FirstName", "LastName", "EnrollmentDate"
            }
        ));
        tbDS.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(tbDS);

        btnAdd.setBackground(new java.awt.Color(93, 212, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/round-add-button (2).png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setColor(new java.awt.Color(93, 212, 253));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setMaximumSize(new java.awt.Dimension(91, 32));
        btnAdd.setMinimumSize(new java.awt.Dimension(91, 32));
        btnAdd.setPreferredSize(new java.awt.Dimension(91, 32));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/diskette.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setColor(new java.awt.Color(0, 161, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setMaximumSize(new java.awt.Dimension(91, 32));
        btnEdit.setMinimumSize(new java.awt.Dimension(91, 32));
        btnEdit.setPreferredSize(new java.awt.Dimension(91, 32));
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(12, 105, 172));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (2).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setColor(new java.awt.Color(12, 105, 172));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setMaximumSize(new java.awt.Dimension(91, 32));
        btnDelete.setMinimumSize(new java.awt.Dimension(91, 32));
        btnDelete.setPreferredSize(new java.awt.Dimension(91, 32));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setForeground(new java.awt.Color(12, 105, 172));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/previous.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorderColor(new java.awt.Color(12, 105, 172));
        btnBack.setColor(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setMaximumSize(new java.awt.Dimension(91, 32));
        btnBack.setMinimumSize(new java.awt.Dimension(91, 32));
        btnBack.setPreferredSize(new java.awt.Dimension(91, 32));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        StudentAddForm addform = new StudentAddForm(this, rootPaneCheckingEnabled);
        addform.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        try {
            int row = tbDS.getSelectedRow();
            TableModel model = tbDS.getModel();

            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table !", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                int personID = Integer.parseInt(model.getValueAt(row, 0).toString());
                StudentEditForm f = new StudentEditForm(personID, this, rootPaneCheckingEnabled);
                f.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        try {
            int row = tbDS.getSelectedRow();
            TableModel model = tbDS.getModel();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                int personID = Integer.parseInt(model.getValueAt(row, 0).toString());

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this Student?", "WARNING!", JOptionPane.YES_NO_OPTION);
                if (input == JOptionPane.YES_OPTION) {

                    if (stb.deleteStudent(personID) > 0) {
                        JOptionPane.showMessageDialog(this, "You have completed to delete student successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                        List list = stb.LoadStudents();
                        model = convertStudent(list);
                        tbDS.setModel(model);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error because the information is binding!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        try {
            String fullname = txtSearch.getText();
            if (fullname.isBlank() == false) {
                List list = stb.findStudent(fullname);
                DefaultTableModel model = convertStudent(list);
                tbDS.setModel(model);
            } else {
                List list = stb.LoadStudents();
                DefaultTableModel model = convertStudent(list);
                tbDS.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnAdd;
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnDelete;
    private UI.UI_Item.button.MyButton btnEdit;
    private UI.UI_Item.button.MyButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.UI_Item.table.TableDark tbDS;
    private UI.UI_Item.textfield.SearchField txtSearch;
    // End of variables declaration//GEN-END:variables
}
