import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	
	public static void main(String []args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("minhthu"));
//		String t = "444";
//		if(!t.equalsIgnoreCase("444"))
//		{
//			System.out.println("dung");
//		}
//		System.out.println("sai");
//		Random rand = new Random();
//		  for (int i=0; i<5; i++) {
//	            
//	            int ranNum = rand.nextInt(100)+1;
//	            System.out.println("Random number is " + ranNum);
//	        }
//		  
//		  int page =(int)Math.ceil(9/4)+1; 
//		  
//		  System.out.println(page);
		List<Integer> a =new ArrayList<>();
		
		for (int i = 1; i <= 3; i++) {
			a.add(i);
		}
		
//		for (Integer integer : a) {
//			System.out.println(integer);
//		}
		
		System.out.println(a.size());
		
//			while (i < sachTuongTu.size()) {
//			if(chiTietSach.getId() == sachTuongTu.get(i).getId())
//			{
//				sachTuongTu.remove(i);
//				break;
//			}
//			i++;
//		}
		
		

//		String path = app.getRealPath("/resources");
//		File f = new File(path,file.getOriginalFilename()); 
//		file.transferTo(f);
		
//		Workbook workbook = new XSSFWorkbook(new File("C:\\Users\\DELL\\Downloads\\t.xlsx"));
//		 Sheet datatypeSheet = workbook.getSheetAt(0);
//	
//		 Iterator<Row> iterator = datatypeSheet.iterator();
//		  while (iterator.hasNext()) {	  
//			  Row row = iterator.next();
//			  if(row.getRowNum() == 0) {
//				  continue;
//			  }
//			  
//		    // Now let's iterate over the columns of the current row
//		    Iterator<Cell> cellIterator = row.cellIterator();
//
//		    while (cellIterator.hasNext()) {
//		      Cell cell = cellIterator.next();
//		      
//		      cell.getRow();
//		      System.out.print(cell + "\t");
//		    }
//		    System.out.println();
//		  }
//		
//		
		
		

	}
}
