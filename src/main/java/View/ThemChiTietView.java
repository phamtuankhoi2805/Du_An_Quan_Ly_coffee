package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import Controller.ThemNguyenLieuController;

import javax.swing.JList;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class ThemChiTietView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_idNguyenLieu;
    private JTextField txt_tenNL;
    private JTextField txt_tenNCC;
    private JButton btn_themNguyenLieuXong;
    private JTextField txt_sdtNCC;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThemChiTietView frame = new ThemChiTietView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ThemChiTietView() {
        ThemNguyenLieuController tnlc = new ThemNguyenLieuController(this, null, null);
        setTitle("Nguyên Liệu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 464, 450);
        setLocationRelativeTo(null);

        contentPane = new JPanel();


        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Thêm Nguyên Liệu");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 345, 27);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID Nguyên Liệu:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(21, 93, 174, 27);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Tên Nguyên Liệu:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(21, 131, 174, 27);
        contentPane.add(lblNewLabel_1_1);

        txt_idNguyenLieu = new JTextField();
        txt_idNguyenLieu.setBounds(175, 98, 191, 20);
        contentPane.add(txt_idNguyenLieu);
        txt_idNguyenLieu.setColumns(10);

        txt_tenNL = new JTextField();
        txt_tenNL.setColumns(10);
        txt_tenNL.setBounds(175, 131, 191, 20);
        contentPane.add(txt_tenNL);

        btn_themNguyenLieuXong = new JButton("Xong");
        btn_themNguyenLieuXong.setBackground(new Color(0, 0, 160));
        btn_themNguyenLieuXong.setForeground(new Color(255, 255, 255));
        btn_themNguyenLieuXong.setBounds(175, 253, 89, 23);
        contentPane.add(btn_themNguyenLieuXong);

        JLabel lblNewLabel_1_1_1 = new JLabel("SDT:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1.setBounds(21, 215, 174, 27);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Tên NCC:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1.setBounds(21, 168, 174, 27);
        contentPane.add(lblNewLabel_1_1_1_1);

        txt_tenNCC = new JTextField();
        txt_tenNCC.setColumns(10);
        txt_tenNCC.setBounds(175, 169, 191, 20);
        contentPane.add(txt_tenNCC);

        txt_sdtNCC = new JTextField();
        txt_sdtNCC.setColumns(10);
        txt_sdtNCC.setBounds(175,220, 191, 20);
        contentPane.add(txt_sdtNCC);
    }
    
    public JTextField txt_idSanPham1() {
        return txt_idNguyenLieu;
    }
    
    public JTextField txt_tenSP1() {
        return txt_tenNL;
    }
    
    public JTextField txt_soLuongSP() {
        return txt_tenNCC;
    }

    public JButton btn_themNguyenLieuXong() {
        return btn_themNguyenLieuXong;
    }
}