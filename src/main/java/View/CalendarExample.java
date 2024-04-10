package View;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarExample extends JFrame {
    private JTextField textField;
    private JButton calendarButton;

    public CalendarExample() {
        setTitle("Calendar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        calendarButton = new JButton("Show Calendar");
        calendarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCalendar();
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(calendarButton);

        add(panel);
    }

    private void showCalendar() {
        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calendarFrame.setSize(300, 300);
        calendarFrame.setLocationRelativeTo(null);

        JCalendar calendar = new JCalendar();
        calendarFrame.add(calendar);

        calendarFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarExample().setVisible(true);
            }
        });
    }
}