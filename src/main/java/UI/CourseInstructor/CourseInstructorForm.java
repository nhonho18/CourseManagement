/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.CourseInstructor;

import DAL.CourseInstructor.CourseInstructor;
import BLL.CourseIntructorBLL;
import UI.MenuForm;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CourseInstructorForm extends javax.swing.JFrame {

    CourseIntructorBLL c = new CourseIntructorBLL();
    static String IDS = "";
    MenuForm home;

    public CourseInstructorForm(MenuForm parent, boolean modal) {
        initComponents();
        initTable();
        init();
        closeChidrentForm(parent, modal);
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

    public CourseInstructorForm() {
        initComponents();
        initTable();
        init();
        this.setLocationRelativeTo(null);
        this.home = new MenuForm();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(home.DISPOSE_ON_CLOSE);
                home.setVisible(true);
            }
        });

    }

    public void init() {
        tableDark1.fixTable(jScrollPane1);
        getContentPane().setBackground(Color.white);
    }

    public void initTable() {
        try {
            listCourseInstructorForm();
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void listCourseInstructorForm() throws SQLException {
        List list = c.loadCourseInstructor();
        DefaultTableModel model = convertCourseInstructor(list);
        tableDark1.setModel(model);
    }

    private DefaultTableModel convertCourseInstructor(List list) throws SQLException {
        String[] columnNames = {"TT", "PERSONID", "NAME TEACHER", "COURSEID", "TITLE COURSE"};
        String[] teacherNames = c.loadTeacheName(list);
        String[] titles = c.loadTitle(list);
        Object[][] data;
        data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            CourseInstructor c = (CourseInstructor) list.get(i);
            data[i][0] = i + 1;
            data[i][1] = c.getPersonID();
            //courseBLL
            data[i][4] = titles[i];
            // personBLL
            data[i][2] = teacherNames[i];
            //nameteacher
            data[i][3] = c.getCourseID();

        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new UI.UI_Item.table.TableDark();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnAdd = new UI.UI_Item.button.MyButton();
        btnEdit = new UI.UI_Item.button.MyButton();
        btnDelete = new UI.UI_Item.button.MyButton();
        jPanel9 = new javax.swing.JPanel();
        btnBack = new UI.UI_Item.button.MyButton();
        jPanel6 = new javax.swing.JPanel();
        searchField1 = new UI.UI_Item.textfield.SearchField();
        btnSearch = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("David", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 161, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COURSE INSTRUCTOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableDark1.setForeground(new java.awt.Color(102, 102, 102));
        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"001", "Yến Nhi", "abc", "abc"},
                {"002", "Yến Nhi", "abc", "abc"},
                {"003", "Yến Nhi", "abc", "abc"},
                {"004", "Yến Nhi", "abc", null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDark1.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tableDark1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        btnAdd.setBackground(new java.awt.Color(93, 212, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/round-add-button (2).png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(btnAdd, gridBagConstraints);

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/pencil.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(btnEdit, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(12, 105, 172));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (2).png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(btnDelete, gridBagConstraints);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setForeground(new java.awt.Color(12, 105, 172));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/previous.png"))); // NOI18N
        btnBack.setText("BACK");
        btnBack.setBorderColor(new java.awt.Color(12, 105, 172));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setMaximumSize(new java.awt.Dimension(91, 25));
        btnBack.setMinimumSize(new java.awt.Dimension(91, 25));
        btnBack.setOver(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        searchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField1.setText("Enter CourseID or TeacherID ...");
        searchField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchField1.setName(""); // NOI18N
        searchField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchField1MouseClicked(evt);
            }
        });
        searchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 199;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 141, 0, 0);
        jPanel6.add(searchField1, gridBagConstraints);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search (1).png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 152, 7, 53);
        jPanel6.add(btnSearch, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // load laji truoc khi search
        try {
            listCourseInstructorForm();
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        String stringToSearchs = searchField1.getText();
        try {

            List list = c.findCourseInstructor(stringToSearchs);
//            tableDark1.setBackGroundIsEmty(list.size());
            DefaultTableModel model = convertCourseInstructor(list);
            tableDark1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        CourseInstructorAddForm C_ADD_FORM = new CourseInstructorAddForm(this, false);
        C_ADD_FORM.setVisible(true);
        C_ADD_FORM.setLocationRelativeTo(null);
//        this.setVisible(false);
//        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        if (tableDark1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pleases choose row!", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                List<CourseInstructor> list = c.loadCourseInstructor();
                IDS = list.get(tableDark1.getSelectedRow()).getCourseID() + "|"
                        + list.get(tableDark1.getSelectedRow()).getPersonID() + "";
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            CourseInstructorEditForm C_EDIT_FORM = new CourseInstructorEditForm(this, false);
            C_EDIT_FORM.setVisible(true);
            C_EDIT_FORM.setLocationRelativeTo(null);
//      this.setVisible(false);
//            this.dispose();
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tableDark1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "chose row!", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "You want delete this row",
                    "Yes",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    List<CourseInstructor> list = c.loadCourseInstructor();
                    int result = c.deleteCourseInstructor(new CourseInstructor(list.get(tableDark1.getSelectedRow()).getCourseID(),
                            list.get(tableDark1.getSelectedRow()).getPersonID()));
                    if (result == -1) {
                        JOptionPane.showMessageDialog(this,
                                "Deleted fail!", "Message", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Deleted success!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        initTable();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void searchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchField1MouseClicked
        searchField1.setText("");
    }//GEN-LAST:event_searchField1MouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

//    public static void main(String args[]) {
//       
//        java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new CourseInstructorForm().setVisible(true);
    }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnAdd;
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnDelete;
    private UI.UI_Item.button.MyButton btnEdit;
    private UI.UI_Item.button.MyButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.UI_Item.textfield.SearchField searchField1;
    private UI.UI_Item.table.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables

}
