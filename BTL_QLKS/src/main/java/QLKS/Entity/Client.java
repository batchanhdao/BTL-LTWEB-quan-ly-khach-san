package QLKS.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data//tự động tạo các phương thức getter, setter, equals, hashCode và toString cho các thuộc tính của một lớp thông quan thư viện lombok
@Entity// đánh dấu lớp Client là một thực thể
@Table(name = "Client")//Client là tên của bảng trong cơ sở dữ liệu mà lớp client ánh xạ đến
public class Client {
	//thuộc tính id là khóa chính và được tự động sinh ra và tự động tăng bởi hqtcsdl
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private String fullname;
//	private String idCard;
//	private String phoneNumber;
//	private String email;
//	private String address;
	
	@NotBlank(message = "Tài khoản ngân hàng không được bỏ trống")
	private String bankAccount;
	private String note;// ghi chú khác về khách hàng
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	private User user;// thuộc tính User là khóa ngoại của Client 1 user chỉ có 1 client
}

//Client để lưu thông tin khách hàng gồm 9 thuộc tính
