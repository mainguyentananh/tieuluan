package sunshop.com.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sunshop.com.model.chiTietDatHang;
import sunshop.com.model.chiTietDatHang.Pk;
import sunshop.com.model.datHang;
import sunshop.com.model.sach;
import sunshop.com.model.khachHang;
import sunshop.com.service.chiTietDatHangService;
import sunshop.com.service.datHangService;
import sunshop.com.service.gioHangSession;
import sunshop.com.service.khachHangService;

@Controller
public class gioHangController {

	@Autowired
	private gioHangSession session;
	
	@Autowired
	private khachHangService khs;
	
	@Autowired
	private datHangService dhs;
	
	@Autowired
	private chiTietDatHangService ctdhs;
	
	@RequestMapping(value = "/xoa/{id}",method = RequestMethod.GET)
	public String xoaKhoiGio(@PathVariable(value = "id") Integer id) {
		session.remove(id);
		return "redirect:/giohang";
	}
	
	@ResponseBody
	@RequestMapping(value = "/themvaogio/{id}",method = RequestMethod.GET)
	public int themVaoGio(@PathVariable(value = "id") Integer id) {
		session.add(id);
		return session.getCount();
	}
	
	@RequestMapping(value = "/tang/{id}",method = RequestMethod.GET)
	public String tangSoLuong(@PathVariable(value = "id") Integer id) {
		session.getItem(id).setSoLuong(session.getItem(id).getSoLuong()+1);
		return "redirect:/giohang";
	}
	
	@RequestMapping(value = "/giam/{id}",method = RequestMethod.GET)
	public String truSoLuong(@PathVariable(value = "id") Integer id) {
		
		if(session.getItem(id).getSoLuong() == 1)
		{
			session.remove(id);
			return "redirect:/giohang";
		}
			session.getItem(id).setSoLuong(session.getItem(id).getSoLuong()-1);
		return "redirect:/giohang";
	}


	@RequestMapping(value = "/huygiohang",method = RequestMethod.GET)
	public String huyGioHang() {
		session.clear();
		return "redirect:/giohang";
	}
	
	@RequestMapping(value = "/thanhtoan",method = RequestMethod.GET)
	public String thanhToan(Model md) {
		if(session.getCount() == 0 ) {
			return "giohang";
		}
		khachHang kh = new khachHang();
		md.addAttribute("kh", kh);
		return "thanhtoan";
	}
	
	@RequestMapping(value = "/dathang",method = RequestMethod.POST)
	public String datHang(Model md,@ModelAttribute(value = "kh") khachHang khn) {	
			
		//xử lí bảng KH
		khs.saveKhachHang(khn);

		//Lấy KH theo sdt 
		khachHang kh = khs.getKhachHangByPhone(khn.getSoDienThoai());
		//Lấy Ngày Đặt Hàng
		Date today = new Date();
		
		datHang dh = new datHang();
		dh.setMaSoKhachHang(kh);
		dh.setNgayDatHang(today);
		
		//Xử lí bảng ĐH
		dhs.saveDatHang(dh);
		
		//Lấy datHang theo id khachHang
		datHang msdh = dhs.getDatHangByMskh(kh.getId());
			
		//Giỏ hàng session
		for(sach hh : session.getItems()) {
			//xử lí khóa chính
			Pk pk = new Pk();
			pk.setMaSoDatHang(msdh.getId());
			pk.setMaSoSach(hh.getMaSoSach());		
			chiTietDatHang ctdh = new chiTietDatHang();
			ctdh.setPk(pk);
			ctdh.setSoLuong(hh.getSoLuong());
			ctdh.setGiaDatHang(hh.getSoLuong() * hh.getGia());
			
			//Xử lí bảng ctdh
			ctdhs.saveChiTietDatHang(ctdh);
			
		}
		session.clear();
		
		return "thanhcong"; 
	}
	
}
