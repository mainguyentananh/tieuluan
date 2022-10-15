package sunshop.com.controllerNoiBo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.sach;
import sunshop.com.service.sachService;

@Controller
@RequestMapping(value = "/noibo")
public class quanLySachController {

	@Autowired
	private sachService hhs;

	@GetMapping(value = "/quanlysach")
	public String quanLySach(Model md, @RequestParam(value = "page", defaultValue = "1") String page) {
		Long start = 1L;
		Long end = 10L;
		Long total = hhs.getCountHh();
		Long sum = hhs.getCountHh();
		Long temp = 100L;
		Long disabled = 1L;
		if (total % temp != 0) {
			total = total / temp + 1;
		} else {
			total = total / temp;
		}
		if (Long.valueOf(page) >= 10) {
			start = Long.valueOf(page) / 10 * 10;
			end = Long.valueOf(page) / 10 * 10 + 10;
		}
		if (Long.valueOf(page) < 1) {
			page = "1";
		}
		if (Long.valueOf(page) > total) {
			page = String.valueOf(total);
		}
		if (Long.valueOf(page) > 1) {
			disabled = Long.valueOf(page);
		}
		if (Long.valueOf(page) >= total) {
			start = Long.valueOf(page) / 10 * 10;
			end = total;
		}
		List<sach> list_product = hhs.getAllHangHoa(page);
		md.addAttribute("start", start);
		md.addAttribute("end", end);
		md.addAttribute("total", total);
		md.addAttribute("sum", sum);
		md.addAttribute("disabled", disabled);
		md.addAttribute("list_product", list_product);
		return "quanlysach";
	}

	@GetMapping(value = "/themsach")
	public String themSach(Model md) {
		md.addAttribute("n_sach", new sach());
		return "themsach";
	}

	@PostMapping(value = "/luusach")
	public String luuSach(@ModelAttribute(value = "n_sach") sach n_sach, @RequestParam(value = "url") String url) {
		n_sach.setHinh(url);
		hhs.saveHangHoa(n_sach);
		return "redirect:/noibo/quanlysach";
	}

	@GetMapping(value = "/quanlysach/xoa/{id}")
	public String xoaSach(@PathVariable(value = "id") Integer id) {
		hhs.deleteHangHoa(id);
		return "redirect:/noibo/quanlysach";
	}

	@GetMapping(value = "/quanlysach/sua/{id}")
	public String suaSach(@PathVariable(value = "id") Integer id, Model md) {
		md.addAttribute("s_sach", hhs.getHangHoaByMshh(id));
		return "suasach";
	}

	@PostMapping(value = "/suasach")
	public String luuSuaSach(@ModelAttribute(value = "s_sach") sach s_sach, @RequestParam(value = "url") String url) {
		if (!ObjectUtils.isEmpty(url)) {
			s_sach.setHinh(url);
		}
		hhs.updateHangHoa(s_sach);
		return "redirect:/noibo/quanlysach";
	}

}
