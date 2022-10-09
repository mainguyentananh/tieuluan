package sunshop.com.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import sunshop.com.model.sach;

//scopedTarget.gioHangSession
@SessionScope
@Service
public class gioHangSession {
	@Autowired
	private sachService hhs;
	
	Map<Integer,sach> map = new HashMap<>();
	
	public void add(Integer id) {
		sach p = map.get(id);
		if(p==null) {
			p = hhs.getHangHoaByMshh(id);
			p.setSoLuong(1);
			map.put(id, p);
		}else {
			p.setSoLuong(p.getSoLuong()+1);
		}
	}
	
	public void remove(Integer id) {
		map.remove(id);
	}
	
	public sach getItem(Integer id) {
		return map.get(id);
	}
	
	
	public void clear() {
		map.clear();
	}
	
	public int getCount() {
		Collection<sach> ps = this.getItems();
		int count = 0;
		for (sach mp : ps) {
			count+=mp.getSoLuong();
		}
		return count;
	}
	
	
	public int getAmount() {
		Collection<sach> ps = this.getItems();
		int thanhTien = 0;
		for (sach mp : ps) {
			thanhTien+= (mp.getSoLuong() * mp.getGia());
		}
		return thanhTien;
	}
	
	public Collection<sach> getItems(){
		 return map.values();
	}
	
	
	
}
