package sunshop.com.controllerNoiBo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.nhanVien;
import sunshop.com.service.nhanVienService;

@Controller
@RequestMapping(value = "/noibo")
public class noiBoController {

	@Autowired
	private nhanVienService nvs;
	
	@GetMapping("/thongtincanhan")
	public String thongTinNhanVien(Model md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		nhanVien nv = nvs.loadNhanVienByEmail(name);	
		md.addAttribute("e_canhan", nv);
		return "thongtincanhan";
	}

	@PostMapping("/suathongtincanhan")
	public String suaThongTinNhanVien(@ModelAttribute(value = "e_canhan") nhanVien nv,
			@RequestParam(value = "npassword") String npass,
			@RequestParam(value = "rpassword") String rpass) {
		if(!npass.isEmpty() && !rpass.isEmpty()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if(npass.equals(rpass)) {
				nv.setMatKhau(encoder.encode(npass));
			}
		}
		nvs.updateNhanVien(nv);
		return "redirect:/noibo/trangchu";
	}
	
}
