package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import Controller.DangNhapController;

import javax.swing.JButton;
import java.awt.Font;

public class viewQR extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Webcam webcam;
    private DangNhapView dnv = new DangNhapView();
	 String taiKhoang = "";
	 String matKhau = "";
	private DangNhapController dnc;
	private JButton btn_Ql;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    viewQR frame = new viewQR();
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
    public viewQR() {
    	 dnc = new DangNhapController(dnv, null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 572, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 536, 450);
        contentPane.add(panel);
        panel.setLayout(null);

        // Create the webcam panel
        WebcamPanel webcamPanel = createWebcamPanel();
        panel.add(webcamPanel);
        
        btn_Ql = new JButton("Quay Lại");
        btn_Ql.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DangNhapView dnv = new DangNhapView();
        		dnv.setVisible(true);
        		setVisible(false);
        	}
        });
        btn_Ql.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btn_Ql.setBounds(353, 11, 173, 23);
        panel.add(btn_Ql);

        // Start capturing from the webcam
        webcamPanel.start();

        // Create a separate thread for QR code scanning
        Thread scanThread = new Thread(new Runnable() {
            

			@Override
            public void run() {
                while (true) {
                    try {
                        // Capture the current frame from the webcam
                        BufferedImage image = webcam.getImage();

                        // Create a BinaryBitmap from the captured image
                        BinaryBitmap bitmap = new BinaryBitmap(
                                new HybridBinarizer(new BufferedImageLuminanceSource(image)));

                        // Set up hints for QR code decoding
                        DecodeHintType hintType = DecodeHintType.TRY_HARDER;
                        MultiFormatReader reader = new MultiFormatReader();
                        reader.setHints(java.util.Collections.singletonMap(hintType, Boolean.TRUE));

                        // Decode the QR code from the image
                        Result result = reader.decode(bitmap);

                        // Get the text result from the decoded QR code
                        String qrText = result.getText();
                            System.out.println(qrText);
                        String[] parts = qrText.split(" ");

                        if (parts.length > 1) {
                            taiKhoang = parts[0];
                            matKhau = parts[1];

                            boolean loggedIn = dnc.DangNhapQR(taiKhoang, matKhau);
                            if (loggedIn) {
                                closeWebcam(); // Close the webcam if loggedIn is true
                                closeApplication();
                            }
                        }

                    } catch (Exception e) {
                        // Ignore any exceptions during QR code scanning
                    }
                }
            }
        });

        scanThread.setDaemon(true);
        scanThread.start();
    }

    /**
     * Create the webcam panel.
     */
    private WebcamPanel createWebcamPanel() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setBounds(10, 73, 516, 337);
        return webcamPanel;
    }

    public void closeApplication() {
 
        webcam.close();
        dispose();
    }
    public void closeWebcam() {
        if (webcam.isOpen()) {
            webcam.close();
        }
    }
    
    
}