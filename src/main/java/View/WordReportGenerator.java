package View;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xwpf.usermodel.*;

public class WordReportGenerator {
    public static void main(String[] args) {
        // Kết nối cơ sở dữ liệu và truy vấn dữ liệu
    	  String url = "jdbc:sqlserver://localhost:1433;databaseName=QLCafe;"
  	            + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
  	        String user = "sa"; 
  	        String passWord = "songlong";
        String query = "EXEC ThongKeDoanhThuTheoThang";

        try {
            Connection conn = DriverManager.getConnection(url, user, passWord);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Tạo tài liệu Word mới
            XWPFDocument document = new XWPFDocument();

            // Tạo tiêu đề
            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("Báo cáo doanh thu theo tháng");
            titleRun.setBold(true);
            titleRun.setFontSize(16);
            titleRun.addBreak();

            // Tạo bảng và đầu bảng
            XWPFTable table = document.createTable();
            XWPFTableRow headerRow = table.getRow(0);
            headerRow.getCell(0).setText("Tháng");
            headerRow.addNewTableCell().setText("Năm");
            headerRow.addNewTableCell().setText("Doanh thu");
            headerRow.addNewTableCell().setText("Tổng đơn hàng");

            // Thêm dữ liệu từ ResultSet vào bảng
            while (rs.next()) {
                XWPFTableRow dataRow = table.createRow();
                dataRow.getCell(0).setText(rs.getString("Thang"));
                dataRow.getCell(1).setText(rs.getString("Nam"));
                dataRow.getCell(2).setText(rs.getString("DoanhThu"));
                dataRow.getCell(3).setText(rs.getString("TongDonHang"));
            }

            // Lưu tệp Word
            FileOutputStream out = new FileOutputStream("BaoCaoDoanhThu.docx");
            document.write(out);
            out.close();
            document.close();

            System.out.println("Tạo file báo cáo thành công!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
