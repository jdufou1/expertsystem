import java.util.ArrayList;

public class ForwardInferenceEngine {

	ArrayList<Litteral> BFinit = new ArrayList<>();
	ArrayList<Rule> BR = new ArrayList<>();
	
	public ArrayList<Litteral> getBF(){
		return BFinit;
	}
	
	public ArrayList<Rule> getBR(){
		return BR;
	}
	
	public void addRule(Rule rule) {
		BR.add(rule);
	}
	
	public void addLitteral(Litteral l) {
		BFinit.add(l);
	}
	
	public void forwardChain() {
		double start = System.currentTimeMillis();
		ArrayList<Litteral> sBF = new ArrayList<>();
		sBF.addAll(BFinit);
		ArrayList<Litteral> BF = new ArrayList<>();
		do {
			BF = new ArrayList<>();
			BF.addAll(sBF);
			for(Rule rule : BR) {
				if(!rule.isActivated()) {
					if(eval(rule,BF)) {
						for(Litteral conclusion : rule.getConclusions()) {
							if(!sBF.contains(conclusion))
								sBF.add(conclusion);
						}
						rule.setActivated(true);
					}
				}
			}
		}while(!(sBF.containsAll(BF) && BF.containsAll(sBF)));
		BFinit = sBF;
		double end = System.currentTimeMillis();
		System.out.println("Temps d'execution de l'algorithme de chainage avant : "+(end-start)+" ms");
	}
	
	private boolean eval(Rule rule,ArrayList<Litteral> BF) {
		for(Litteral premise : rule.getPremises()) {
			boolean ok = false;
			for(Litteral fact : BF) {
				if(fact.equals(premise)) {
					ok = true;
				}
			}
			if(!ok)
				return false;
		}
		return true;
	}
}
