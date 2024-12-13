/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5bai1.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class Lab5Bai12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Kết nối đến cơ sở dữ liệu MySQL
            String url = "jdbc:mysql://localhost:3306/QLSINHVIEN?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "18102007";

            // Nạp driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối với cơ sở dữ liệu
            Connection con = DriverManager.getConnection(url, user, password);

            // Câu lệnh SQL để truy vấn dữ liệu từ bảng STUDENTS
            String sql = "SELECT MaSV, HoTen, Email, SDT, Gioitinh FROM STUDENTS";

            // Tạo Statement để thực thi câu lệnh SQL
            Statement st = con.createStatement();

            // Thực thi truy vấn và lấy kết quả vào ResultSet
            ResultSet rs = st.executeQuery(sql);

            // Duyệt qua các kết quả trả về và in ra màn hình
            while (rs.next()) {
                System.out.print(rs.getString("MaSV") + ", ");  // In mã sinh viên
                System.out.print(rs.getString("HoTen") + ", "); // In họ tên
                System.out.print(rs.getString("Email") + ", "); // In email
                System.out.print(rs.getString("SDT") + ", ");   // In số điện thoại

                // Kiểm tra giới tính và in "Nam" hoặc "Nữ"
                System.out.println(rs.getBoolean("Gioitinh") ? "Nam" : "Nữ");
            }

            // Đóng kết nối sau khi hoàn thành
            con.close();
        } catch (Exception e) {
            // Bắt lỗi và in thông báo lỗi nếu có
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
