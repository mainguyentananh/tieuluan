package sunshop.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dangNhapController {

	
	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		if (error != null) {
			model.addAttribute("message",
					"<div class=\"btn btn-danger btn-sm rounded-pill\">Nhập Sai Vui Lòng Nhập Lại!</div>");
		}
		return "dangnhap";
	}

	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String dangXuat() {
		return "dangnhap";
	}
	
	@GetMapping(value = "/noibo/trangchu")
	public String trangChu() {
		return "trangchu-ad";
	}
	
	@GetMapping(value = "/403")
	public String accessDenied() {
	    return "403";
	  }
	
}
