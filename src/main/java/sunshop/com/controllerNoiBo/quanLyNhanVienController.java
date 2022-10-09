package sunshop.com.controllerNoiBo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.nhanVien;
import sunshop.com.service.nhanVienService;

@Controller
@RequestMapping(value="/admin")
public class quanLyNhanVienController {
	
	@Autowired
	private nhanVienService nvs;
	
	@GetMapping(value = "/nhanvien")
	public String getAllNhanVien(Model md) {
		List<nhanVien> l_nhanvien = nvs.getAllNhanVien();
		md.addAttribute("l_nhanvien", l_nhanvien);
		return "nhanvien";
	}
	
	
	@GetMapping(value = "/themnhanvien")
	public String themNhanVien(Model md) {
		md.addAttribute("n_nhanvien", new nhanVien());
		return "themnhanvien";
	}
	
	@PostMapping(value = "/luunhanvien")
	public String luuNhanVien(@ModelAttribute(value = "n_nhanvien") nhanVien nv,
			@RequestParam(value ="ns") String ngSinh,@RequestParam(value ="gioitinh") String gt) throws ParseException {
		
		if(gt.equalsIgnoreCase("Nam")) {
			nv.setGioiTinh(true);
		}
		
		//Date
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaySinh = smf.parse(ngSinh);
		nv.setNgaySinh(ngaySinh);
		
		//Pass
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nv.setMatKhau(encoder.encode(nv.getMatKhau()));
		
		//
		
		nvs.saveNhanVien(nv);
		
		return "redirect:/admin/nhanvien";
	}
	
	
	@GetMapping(value = "/nhanvien/sua/{id}")
	public String suaNV(Model md,@PathVariable(value = "id") Integer id) {
		md.addAttribute("e_nhanvien", nvs.getNhanVienByMsnv(id));
		return "suanhanvien";
	}
	
	@PostMapping(value = "/suanhanvien")
	public String luuChinhSuaNhanVien(@ModelAttribute(value = "e_nhanvien") nhanVien nv) {
		nvs.updateNhanVien(nv);
		return "redirect:/admin/nhanvien";
	}
	
	
	
}
