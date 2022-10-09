package sunshop.com.controllerNoiBo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.chiTietDatHang;
import sunshop.com.model.datHang;
import sunshop.com.model.khachHang;
import sunshop.com.model.nhanVien;
import sunshop.com.service.chiTietDatHangService;
import sunshop.com.service.datHangService;
import sunshop.com.service.khachHangService;
import sunshop.com.service.mailService;
import sunshop.com.service.nhanVienService;

@Controller
@RequestMapping(value = "/noibo")
public class donHangController {

	@Autowired
	private datHangService dhs;
	
	@Autowired
	private khachHangService khs;
	
	@Autowired
	private nhanVienService nvs;
	
	@Autowired
	private chiTietDatHangService ctdhs;
	
	@Autowired
	private mailService mail;
	
	@GetMapping(value = "/donhang")
	public String donHang(Model md) {
		md.addAttribute("l_donhang", dhs.getAllDatHang());
		return "donhang";
	}
	
	@GetMapping(value = "/donhang/sua/{id}")
	public String suaDonHang(Model md,@PathVariable(value = "id") Integer id,@RequestParam(name ="notify",defaultValue = "") String notify) {
		
		//Get Email Nhân Viên Trong Spring Security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		//Get Nhan Vien
		nhanVien nv = nvs.loadNhanVienByEmail(name);
		
		md.addAttribute("nv", nv);
		md.addAttribute("donhang",dhs.getDatHangByMsdh(id));
		return "xuly";
	}
	
	@PostMapping(value = "/xulydonhang",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String xuLyDonHang(@ModelAttribute(value = "donhang") datHang dh,@RequestParam(value = "ngh") String ngh) throws ParseException, MessagingException {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayGH = smf.parse(ngh);
		
		if(dh.getNgayDatHang().after(ngayGH)) {
			String notify = "fail";
			return "redirect:/noibo/donhang/sua/"+dh.getId()+"?notify="+notify;
		}
		
		
		dh.setNgayGiaoHang(ngayGH);
		dhs.updateDatHang(dh);
		
	
		
		//Lấy KH - Lấy Mail
		khachHang mailKH = khs.getKhachHangByMskh(dh.getMaSoKhachHang().getId());
		
		
		String content ="�?ơn Hàng Của Khách Hàng �?ã �?ược Xử Lý. Dự Kiến Giao Hàng Ngày: "+ngh;
		//mail.sendEmail("sinotsistore@gmail.com",mailKH.getEmail(), "SunShop Thông Báo Giao Hàng",content);
		return "redirect:/noibo/donhang";
	}
	
	@GetMapping(value = "/chitietdonhang/{iddonhang}")
	public String chiTietDonHang(Model md,@PathVariable(value = "iddonhang") Integer id) {
		List<chiTietDatHang> ctdt = ctdhs.getAllChiTietDatHang(id);
		md.addAttribute("chitietdonhang", ctdt);
		md.addAttribute("thongtin",dhs.getDatHangByMsdh(id));
		return "chitietdonhang";
	}
	
	
	
	
}
