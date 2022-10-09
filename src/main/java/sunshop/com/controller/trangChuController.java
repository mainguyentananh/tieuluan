package sunshop.com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		int start = 1;
		Long total = hhs.getCountHh();
		Long sum = hhs.getCountHh();
		int temp = 100;
		if(total%temp!=0) {
			total = total/temp + 1;
		}else {
			total = total/temp;
		}
		Long end = total;
		if(total > 10) {
			end = 10L;
		}
		if(Integer.valueOf(page) < 1) {
			page = "1";
		}
		if(Integer.valueOf(page) > total) {
			page = String.valueOf(total);
		}
		
		if(Integer.valueOf(page) >= 10 ) {
			start = Integer.valueOf(page);
			if(total/10 == start/10) {
				end = total;
			}else {
				end = start/10 * 10L + 10;
			}
			
		}
		List<sach> list_product = hhs.getAllHangHoa(page);
		md.addAttribute("start", start);
		md.addAttribute("end", end);
		md.addAttribute("total", total);
		md.addAttribute("sum", sum);
		md.addAttribute("list_product", list_product);
		return "trangchu";
	}


	@RequestMapping(value = "/chitietsach/{mshh}", method = RequestMethod.GET)
	public String chiTietSach(@PathVariable(value = "mshh") int id, Model md) {
		sach chiTietSach = hhs.getHangHoaByMshh(id);
		md.addAttribute("chiTietSach", chiTietSach);
		return "chitietsach";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model md, @RequestParam("sach") String sach) {
		List<sach> list_product = hhs.search(sach);
		md.addAttribute("list_product", list_product);
		return "trangchu";
	}

	@RequestMapping(value = "/giohang", method = RequestMethod.GET)
	public String gioHang() {
		return "giohang";
	}

}
