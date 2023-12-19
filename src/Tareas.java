import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
 * Created by JFormDesigner on Sat Dec 16 15:55:28 CLST 2023
 */



/**
 * @author yonatan
 */
public class Tareas extends JFrame {
    private static DefaultListModel<String> modeloListaGeneral = new DefaultListModel<>();
    private static DefaultListModel<String> modeloListaTareasDeHoy = new DefaultListModel<>();

    public Tareas() {
        initComponents();
        createUIComponents();
    }
    
    private void createUIComponents() {
        String[][] tareas = ControlTareas.getInstance().getTareas();
        Object[][] data = new Object[tareas.length][2];

        for (int i = 0; i < data.length; i++) {
            modeloListaGeneral.addElement(tareas[i][0]);

            if (tareas[i][3].equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))){
                modeloListaTareasDeHoy.addElement(tareas[i][0]);
            }
        }
        this.list1.setModel(modeloListaGeneral);
        this.list2.setModel(modeloListaTareasDeHoy);
    }


    public static void display() {
        Tareas tareas = new Tareas();
        tareas.setMaximumSize(new Dimension(800, 600));
        tareas.setVisible(true);
    }

    private void mostrarDetallesDeTarea() {
        if (list2.getSelectedValue() != null){
            InfoTarea.display(list2.getSelectedValue());
        }
    }

    private void completarTarea() {
        if (list2.getSelectedValue() != null) {
            ControlTareas.getInstance().completarTarea(list2.getSelectedValue());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Yonatan Chiuca (yonatan.chiuca2301)
        mensajeOpcional = new JLabel();
        button1 = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        list2 = new JList<>();
        detallesButton = new JButton();
        marcarCompletadoButton = new JButton();
        button4 = new JButton();
        detallesButton2 = new JButton();
        marcarCompletadoButton2 = new JButton();

        //======== this ========
        setTitle("Tareas");
        var contentPane = getContentPane();

        //---- mensajeOpcional ----
        mensajeOpcional.setText("Lista total de tareas");

        //---- button1 ----
        button1.setText("+");
        button1.setFont(new Font("Inter", Font.PLAIN, 12));

        //---- label1 ----
        label1.setText("Agregar nueva tarea");
        label1.setEnabled(false);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label2 ----
        label2.setText("Tareas de hoy");
        label2.setEnabled(false);
        label2.setFont(new Font("Inter", Font.PLAIN, 18));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list2);
        }

        //---- detallesButton ----
        detallesButton.setText("Detalles");
        detallesButton.addActionListener(e -> mostrarDetallesDeTarea());

        //---- marcarCompletadoButton ----
        marcarCompletadoButton.setText("Marcar como completada");
        marcarCompletadoButton.addActionListener(e -> completarTarea());

        //---- button4 ----
        button4.setText("?");

        //---- detallesButton2 ----
        detallesButton2.setText("Detalles");
        detallesButton2.addActionListener(e -> mostrarDetallesDeTarea());

        //---- marcarCompletadoButton2 ----
        marcarCompletadoButton2.setText("Marcar como completada");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(detallesButton)
                                    .addGap(50, 50, 50)
                                    .addComponent(marcarCompletadoButton))
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(mensajeOpcional, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 163, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(detallesButton2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(marcarCompletadoButton2))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(689, Short.MAX_VALUE)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label1)
                            .addGap(133, 133, 133)))
                    .addGap(28, 28, 28))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button4)
                    .addGap(1, 1, 1)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(mensajeOpcional, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(detallesButton)
                        .addComponent(marcarCompletadoButton)
                        .addComponent(detallesButton2)
                        .addComponent(marcarCompletadoButton2))
                    .addGap(21, 21, 21))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Yonatan Chiuca (yonatan.chiuca2301)
    private JLabel mensajeOpcional;
    private JButton button1;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList<String> list2;
    private JButton detallesButton;
    private JButton marcarCompletadoButton;
    private JButton button4;
    private JButton detallesButton2;
    private JButton marcarCompletadoButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
