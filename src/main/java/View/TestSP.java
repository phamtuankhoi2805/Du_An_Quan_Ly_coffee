package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.SanPhamDAO;
import Model.SanPhamModel;

public class TestSP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ArrayList<SanPhamModel> listSP;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestSP frame = new TestSP();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TestSP() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1117, 581);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        JPanel panel_DSSP = new JPanel();
        panel_DSSP.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        listSP = SanPhamDAO.getInstance().selectAll();

        // Duyệt qua danh sách sản phẩm và tạo JPanel cho mỗi sản phẩm
        for (SanPhamModel sp : listSP) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(320, 136));
            panel.setLayout(null);

            JLabel lbl__hinhAnh = new JLabel("");
            lbl__hinhAnh.setBounds(10, 10, 88, 116);
            panel.add(lbl__hinhAnh);
            // Đặt ảnh
            setScaledImage(lbl__hinhAnh, sp.getHinh());

            JLabel lbl_tenSP = new JLabel(sp.getTenSP());
            lbl_tenSP.setBounds(126, 10, 168, 22);
            panel.add(lbl_tenSP);

            JLabel lbl_gia = new JLabel("Giá: " + sp.getGiaBan());
            lbl_gia.setBounds(126, 79, 168, 22);
            panel.add(lbl_gia);

            JButton btn_xoa = new JButton("Xóa");
            btn_xoa.setBounds(240, 80, 54, 46);
            panel.add(btn_xoa);
            
            // Gắn MouseListener vào panel để xử lý sự kiện khi nhấn vào panel
            panel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Lấy tên sản phẩm và giá và in ra màn hình
                    System.out.println("Tên sản phẩm: " + sp.getTenSP());
                    System.out.println("Giá: " + sp.getGiaBan());
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            
            panel_DSSP.add(panel);
        }
        
        contentPane.add(panel_DSSP, BorderLayout.CENTER);
    }

    private void setScaledImage(JLabel label, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
}