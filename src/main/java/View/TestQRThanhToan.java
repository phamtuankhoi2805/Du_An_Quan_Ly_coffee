package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class TestQRThanhToan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPaymentAmount;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestQRThanhToan frame = new TestQRThanhToan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TestQRThanhToan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 728, 412);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        JLabel lbl_hienQR = new JLabel("");
        lbl_hienQR.setBounds(157, 32, 452, 287);
        contentPane.add(lbl_hienQR);

        JLabel lblPaymentAmount = new JLabel("Số tiền:");
        lblPaymentAmount.setBounds(10, 357, 91, 14);
        contentPane.add(lblPaymentAmount);

        txtPaymentAmount = new JTextField();
        txtPaymentAmount.setBounds(111, 354, 86, 20);
        contentPane.add(txtPaymentAmount);
        txtPaymentAmount.setColumns(10);

        JButton btnGenerateQR = new JButton("Tạo mã QR");
        btnGenerateQR.setBounds(207, 353, 89, 23);
        contentPane.add(btnGenerateQR);
        btnGenerateQR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(txtPaymentAmount.getText());
                    String qrData = "momo://pay?amount=" + amount + "&phone=0866786774";

                    // Tạo mã QR
                    int qrSize = 300;
                    Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
                    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                    BitMatrix bitMatrix = new QRCodeWriter().encode(qrData, BarcodeFormat.QR_CODE, qrSize, qrSize, hints);
                    BufferedImage qrImage = new BufferedImage(qrSize, qrSize, BufferedImage.TYPE_INT_RGB);
                    for (int x = 0; x < qrSize; x++) {
                        for (int y = 0; y < qrSize; y++) {
                            qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                        }
                    }

                    // Lưu mã QR vào tệp momo_qr.png
                    File qrFile = new File("momo_qr.png");
                    ImageIO.write(qrImage, "png", qrFile);

                    // Hiển thị hình ảnh mã QR
                    lbl_hienQR.setIcon(new ImageIcon(qrFile.getAbsolutePath()));
                } catch (NumberFormatException | WriterException | IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Nhập không hợp lệ. Vui lòng nhập số tiền hợp lệ.");
                }
            }
        });

        setContentPane(contentPane);
    }
}
