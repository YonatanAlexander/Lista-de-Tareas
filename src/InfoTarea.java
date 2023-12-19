import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Dec 17 22:01:08 CLST 2023
 */



/**
 * @author yonatan
 */
public class InfoTarea extends JDialog {
    private InfoTarea(String nombreTarea) {
        super();
        initComponents();
        recoveryInfo(nombreTarea);
    }

    private void recoveryInfo(String nombreTarea) {
        Tarea tarea = ControlTareas.getInstance().getTarea(nombreTarea).get(); // en este punto la tarea existe siempre
        this.nombreTarea.setText(tarea.getTitulo());
        this.descripcion.setText(tarea.getDescripcion());
        this.tipo.setText(tarea.getTipo().toString());
        this.fecha.setText(tarea.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.notificacion.setText(
                (tarea.getNotificar()) ? "Activada" : "Desactivada"
        );
        this.terminada.setText(
                (tarea.getTerminada()) ? "Sí" : "No"
        );
    }

    public static void display(String nombreTarea){
        InfoTarea infoTarea = new InfoTarea(nombreTarea);
        infoTarea.setMinimumSize(new Dimension());
        infoTarea.setVisible(true);
    }

    public static void main(String[] args) {
        InfoTarea.display("Tender la cama");
    }

    private void aceptar() {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Yonatan Chiuca (yonatan.chiuca2301)
        button1 = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        descripcion = new JLabel();
        label2 = new JLabel();
        tipo = new JLabel();
        label3 = new JLabel();
        fecha = new JLabel();
        label4 = new JLabel();
        notificacion = new JLabel();
        label5 = new JLabel();
        terminada = new JLabel();
        nombreTarea = new JLabel();
        editarButton = new JButton();

        //======== this ========
        setTitle("Datos de Tarea");
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Aceptar");
        button1.addActionListener(e -> aceptar());

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("Descripci\u00f3n:");

            //======== scrollPane1 ========
            {

                //---- descripcion ----
                descripcion.setVerticalAlignment(SwingConstants.TOP);
                descripcion.setForeground(new Color(0x999999));
                scrollPane1.setViewportView(descripcion);
            }

            //---- label2 ----
            label2.setText("Tipo:");

            //---- label3 ----
            label3.setText("Fecha:");

            //---- label4 ----
            label4.setText("Notificaci\u00f3n:");

            //---- label5 ----
            label5.setText("Terminada:");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(12, 12, 12)
                                .addComponent(terminada, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1, GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(notificacion, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label3, GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label4, GroupLayout.Alignment.TRAILING)
                            .addComponent(notificacion, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label5, GroupLayout.Alignment.TRAILING)
                            .addComponent(terminada, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
            );
        }

        //---- nombreTarea ----
        nombreTarea.setFont(new Font("Inter", Font.PLAIN, 20));

        //---- editarButton ----
        editarButton.setText("Editar");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(editarButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(15, 15, 15))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(nombreTarea, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 1, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(nombreTarea, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(editarButton))
                    .addGap(18, 18, 18))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Yonatan Chiuca (yonatan.chiuca2301)
    private JButton button1;
    private JPanel panel1;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JLabel descripcion;
    private JLabel label2;
    private JLabel tipo;
    private JLabel label3;
    private JLabel fecha;
    private JLabel label4;
    private JLabel notificacion;
    private JLabel label5;
    private JLabel terminada;
    private JLabel nombreTarea;
    private JButton editarButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
