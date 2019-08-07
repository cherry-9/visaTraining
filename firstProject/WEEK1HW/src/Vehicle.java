import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Vehicle implements Comparable<Vehicle>{
	String regNumber;
	String area;
	static HashMap<String,String> map;
	static {
		map.put("KA-01","Kormangla");
		map.put("KA-02","Rajajinagar");
		map.put("KA-03", "Indiranagar");
		map.put("KA-04", "Yashwanthpuram");
		map.put("KA-05", "Abcd");
		map.put("KA-50", "Jayanagar");
		map.put("KA-51", "Yelahanka");
		map.put("KA-52", "Electronics City");
		map.put("KA-53", "Nelamangala");
		map.put("KA-54", "Mysore easy");
		map.put("KA-55", "Basawa Kalyan");
		map.put("KA-56", "ShantiNagar");
		map.put("KA-57", "Marathalli");
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Vehicle(String regNumber, String area) {
		super();
		this.regNumber = regNumber;
		this.area = calcArea(regNumber);
	}
	private String calcArea(String reg) {
		return map.get(reg.subSequence(0,5));
		//return null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (regNumber == null) {
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		return true;
	}
	@Override
	public int compareTo(Vehicle o) {
		String a=this.area;
		String b=o.getArea();
		if(b.compareTo(a)==0)return this.regNumber.compareTo(o.getRegNumber());
		return b.compareTo(a);
	}
	
	public List<Vehicle> sort(List<Vehicle> ls){
		Collections.sort(ls);;
		return ls;
		
	}
	
	
	
	
	
	
}
