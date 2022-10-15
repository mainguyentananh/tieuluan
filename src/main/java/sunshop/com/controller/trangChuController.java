package sunshop.com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.sach;
import sunshop.com.service.gioHangSession;
import sunshop.com.service.sachService;

@Controller
public class trangChuController {

	@Autowired
	private sachService hhs;

	@Autowired
	private gioHangSession session;

	@RequestMapping(value = "/trangchu", method = RequestMethod.GET)
	public String trangChu(Model md, @RequestParam(value = "page", defaultValue = "1") String page){
		session.getCount();
		Long start = 1L;
		Long end = 10L;
		Long total = hhs.getCountHh();
		Long sum = hhs.getCountHh();
		Long temp = 100L;
		Long disabled = 1L;
		if(total%temp!=0) {
			total = total/temp + 1;
		}else {
			total = total/temp;
		}
		if(total < 10) {
			end = total;
		}
		if(Long.valueOf(page) >= 10) {
			start = Long.valueOf(page)/10 * 10;
			end = Long.valueOf(page)/10 * 10 + 10;
		}
		if(Long.valueOf(page) < 1) {
			page = "1";
		}
		if(Long.valueOf(page) > total) {
			page = String.valueOf(total);
		}
		if(Long.valueOf(page) > 1) {
			disabled = Long.valueOf(page);
		}
		if(Long.valueOf(page) >= total) {
			start = Long.valueOf(page)/10 * 10;
			 end = total;
		}
		List<sach> list_product = hhs.getAllHangHoa(page);
		md.addAttribute("start", start);
		md.addAttribute("end", end);
		md.addAttribute("total", total);
		md.addAttribute("sum", sum);
		md.addAttribute("disabled", disabled);
		md.addAttribute("list_product", list_product);
		return "trangchu";
	}


	@RequestMapping(value = "/chitietsach/{mshh}", method = RequestMethod.GET)
	public String chiTietSach(@PathVariable(value = "mshh") int id, Model md) {
		sach chiTietSach = hhs.getHangHoaByMshh(id);
		md.addAttribute("chiTietSach", chiTietSach);
		return "chitietsach";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model md, @RequestParam("sach") String sach, @RequestParam(value = "page", defaultValue = "1") String page) {
		try {
			if(ObjectUtils.isEmpty(sach.trim())) {
				return "redirect:/trangchu";
			}
			session.getCount();
			Long start = 1L;
			Long end = 10L;
			Long total = hhs.getCountSearch(sach);
			Long sum = hhs.getCountSearch(sach);
			Long temp = 100L;
			Long disabled = 1L;
			if(total%temp!=0) {
				total = total/temp + 1;
			}else {
				total = total/temp;
			}
			if(total < 10) {
				end = total;
			}
			if(Long.valueOf(page) >= 10) {
				start = Long.valueOf(page)/10 * 10;
				end = Long.valueOf(page)/10 * 10 + 10;
			}
			if(Long.valueOf(page) < 1) {
				page = "1";
			}
			if(Long.valueOf(page) > total) {
				page = String.valueOf(total);
			}
			if(Long.valueOf(page) > 1) {
				disabled = Long.valueOf(page);
			}
			if(Long.valueOf(page) >= total) {
				start = Long.valueOf(page)/10 * 10;
				 end = total;
			}
			List<sach> list_product = hhs.search(sach,page);
			md.addAttribute("sach", sach.trim());
			md.addAttribute("start", start);
			md.addAttribute("end", end);
			md.addAttribute("total", total);
			md.addAttribute("sum", sum);
			md.addAttribute("disabled", disabled);
			md.addAttribute("list_product", list_product);
		}catch (Exception e) {
			return "redirect:/trangchu";
		}
		return "timkiem";
	}

	@RequestMapping(value = "/giohang", method = RequestMethod.GET)
	public String gioHang() {
		return "giohang";
	}

}
