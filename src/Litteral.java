
public class Litteral {

	String name;
	
	public Litteral(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object l) {
		if(l instanceof Litteral) {
			Litteral tmp = (Litteral)l;
			if(tmp.name == this.name)
				return true;
		}
		return false;
	}
}
