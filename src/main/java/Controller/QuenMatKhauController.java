package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.util.Properties;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import DAO.NhanVienDAO;
import Model.NhanVienModel;
import View.DangNhapView;
import View.QuenMatKhauView;

public class QuenMatKhauController implements ActionListener {
	private QuenMatKhauView qmkv;
	private NhanVienDAO nvd;
int maKhoiPhuc ;
	public QuenMatKhauController(QuenMatKhauView qmkv, NhanVienDAO nvd) {

		this.qmkv = qmkv;
		this.nvd = nvd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút " + src);
		if (src.equals("Hủy")) {
			DangNhapView dnv = new DangNhapView();
			dnv.setVisible(true);
			qmkv.setVisible(false);
		} else if (src.equals("Gửi")) {
		sendEmail();
		}
		else if (src.equals("Đổi Mật Khẩu")) {
		quenMatKhau();
			}
	}

	public void sendEmail() {
        String host = "smtp.gmail.com"; // Địa chỉ SMTP server
        int port = 587; // Cổng SMTP server
        String email = "Email của bạn "; // Tài khoản email nguồn
        String password = "mxje bazn lnvo iiav"; // Mật khẩu email nguồn

        String recipientEmail = qmkv.txt_email().getText(); // Địa chỉ email người nhận
        String subject = "Khôi Phục Mật Khẩu"; // Tiêu đề email
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Số ngẫu nhiên từ 0 đến 999
        String content = "Đây Là Mã Khôi Phục Của Bạn: " + randomNumber;
           maKhoiPhuc =  randomNumber;
        // Cấu hình properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Tạo phiên làm việc (session) với thông tin xác thực
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Thiết lập thông tin email
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
	}

	public void quenMatKhau() {
	    ArrayList<NhanVienModel> nv = NhanVienDAO.getInstance().selectAll();
	    String userName = qmkv.txt_userName().getText();
	    String passNew = qmkv.txt_matKhauMoi().getText();
	    int ma = Integer.parseInt(qmkv.txt_maXacNhan().getText());
	    if (ma != maKhoiPhuc) {
	        JOptionPane.showMessageDialog(qmkv, "Nhập sai mã xác nhận");
	        return;
	    }

	    // Kiểm tra độ mạnh của mật khẩu mới
	    if (!isValidPassword(passNew)) {
	        JOptionPane.showMessageDialog(qmkv, "Mật khẩu mới không hợp lệ ít nhất một chữ cái hoa, một chữ cái thường, một số,");
	        return;
	    }

	    for (NhanVienModel nhanVienModel : nv) {
	        if (nhanVienModel.getIdNhanVien().equals(userName)) {
	            NhanVienDAO.getInstance().updatePass(userName, passNew);
	            JOptionPane.showMessageDialog(qmkv, "Đổi mật khẩu thành công");
	            return;
	        }
	    }
	    
	    JOptionPane.showMessageDialog(qmkv, "Nhập Sai Thông tin tài khoảng");
	}

	// Hàm kiểm tra mật khẩu hợp lệ
	private boolean isValidPassword(String password) {
	    // Kiểm tra độ dài của mật khẩu
	    if (password.length() < 8) {
	        return false;
	    }

	    // Kiểm tra các yêu cầu về mật khẩu (ví dụ: ít nhất một chữ cái hoa, một chữ cái thường, một số, v.v.)
	    // Bạn có thể tùy chỉnh các yêu cầu cho phù hợp với quy định của bạn
	    // Dưới đây chỉ là ví dụ đơn giản
	    String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
	    if (!password.matches(regex)) {
	        return false;
	    }

	    return true;
	}
}
