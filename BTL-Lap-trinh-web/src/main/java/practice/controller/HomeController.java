package practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import practice.model.Account;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/") // tiếp nhận yêu cầu từ trang / 
	public String home(Model model, HttpSession session) {
		// dùng model để lưu data từ session 
		if (session.getAttribute("currentAccount") != null) {
			model.addAttribute("account", session.getAttribute("currentAccount"));
		}
		// tìm đến trang giao diện homepage.html
		return "homepage";
	}

	// đăng nhập hoặc đăng xuất 
	@GetMapping("/login")// tiếp nhận yêu cầu từ trang /login
	public String login(HttpSession session) {
		// nếu có tài khoản thì chuyển đến trang đăng xuất
		if (session.getAttribute("currentAccount") != null) {
			return "logout";
		}
		return "login";
	}

	@GetMapping("/logout") // tiếp nhận yêu cầu từ trang /logout
	public String logout(HttpSession session) {
//		lấy data trong session với name là currentAccount
//		kiểu dữ liệu là Account 
		Account account = (Account) session.getAttribute("currentAccount");
		if (account != null) { // nếu tồn tại thì ghi lại vào log
			log.info("Log out: " + account);
		}
//		nếu không thì chạy đến trang logout
		return "logout";
	}

}