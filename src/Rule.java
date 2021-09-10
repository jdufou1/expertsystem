import java.util.ArrayList;

public class Rule {

	ArrayList<Litteral> premises = new ArrayList<>();
	ArrayList<Litteral> conclusions = new ArrayList<>();
	
	boolean activated = false;
	
	public Rule() {
		
	}
	
	public Rule(ArrayList<Litteral> premises,ArrayList<Litteral> conclusions) {
		this.premises = premises;
		this.conclusions = conclusions;
	}
	
	public void setActivated(boolean value) {
		activated = value;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public ArrayList<Litteral> getPremises(){
		return premises;
	}
	
	public ArrayList<Litteral> getConclusions(){
		return conclusions;
	}
	
	public void addPremise(Litteral premise) {
		premises.add(premise);
	}
	
	public void addConclusion(Litteral conclusion) {
		conclusions.add(conclusion);
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("si : ");
		for(Litteral premise : premises) {
			str.append(premise.getName()+" , ");
		}
		str.append("alors : ");
		for(Litteral conclusion : conclusions) {
			str.append(conclusion.getName()+" , ");
		}
		return str.toString();
	}
}
