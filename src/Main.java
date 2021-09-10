import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ForwardInferenceEngine fie = new ForwardInferenceEngine();
		
		Litteral l1 = new Litteral("sacs");
		Litteral l2 = new Litteral("container");
		Litteral l3 = new Litteral("grosse-quantite");
		Litteral l4 = new Litteral("asperges");
		Litteral l5 = new Litteral("moyenne-quantite");
		Litteral l6 = new Litteral("cageots");
		Litteral l7 = new Litteral("choux-fleurs");
		Litteral l8 = new Litteral("petite-quantite");
		Litteral l9 = new Litteral("delai-tres-court");
		Litteral l10 = new Litteral("presse");
		Litteral l11 = new Litteral("delai-court");
		Litteral l12 = new Litteral("fragile");
		Litteral l13 = new Litteral("hors-france");
		Litteral l14 = new Litteral("camion");
		Litteral l15 = new Litteral("france");
		Litteral l16 = new Litteral("pas-presse");
		Litteral l17 = new Litteral("train");
		
		
		Rule r1 = new Rule();
		r1.addPremise(l1);
		r1.addConclusion(l2);
		fie.addRule(r1);
		
		Rule r2 = new Rule();
		r2.addPremise(l3);
		r2.addConclusion(l2);
		fie.addRule(r2);
		
		Rule r3 = new Rule();
		r3.addPremise(l4);
		r3.addPremise(l5);
		r3.addConclusion(l6);
		fie.addRule(r3);
		
		Rule r4 = new Rule();
		r4.addPremise(l7);
		r4.addPremise(l8);
		r4.addConclusion(l6);
		fie.addRule(r4);
		
		Rule r5 = new Rule();
		r5.addPremise(l9);
		r5.addConclusion(l10);
		fie.addRule(r5);
		
		Rule r6 = new Rule();
		r6.addPremise(l11);
		r6.addPremise(l12);
		r6.addConclusion(l10);
		fie.addRule(r6);
		
		Rule r7 = new Rule();
		r7.addPremise(l2);
		r7.addPremise(l13);
		r7.addConclusion(l14);
		fie.addRule(r7);
		
		Rule r8 = new Rule();
		r8.addPremise(l2);
		r8.addPremise(l15);
		r8.addPremise(l16);
		r8.addConclusion(l17);
		fie.addRule(r8);
		
		Rule r9 = new Rule();
		r8.addPremise(l2);
		r8.addPremise(l15);
		r8.addPremise(l10);
		r8.addConclusion(l14);
		fie.addRule(r9);
		
		Rule r10 = new Rule();
		r10.addPremise(l13);
		r10.addPremise(l12);
		r10.addConclusion(l14);
		fie.addRule(r10);
		
		Rule r11 = new Rule();
		r11.addPremise(l4);
		r11.addConclusion(l12);
		fie.addRule(r11);
		
		
		/* Creation de la BF initiale */
		fie.addLitteral(l3); // grosse quantite
		fie.addLitteral(l4); // asperges
		fie.addLitteral(l11); // delai-court
		fie.addLitteral(l13); // hors-france
		
		System.out.println("Base de connaissance initiale : ");
		System.out.println("--------------------------------");
		
		for(Litteral l : fie.getBF()) {
			System.out.println(l.getName());
		}
		System.out.println();
		
		fie.forwardChain();
		
		
		
		System.out.println("Base de connaissance apres deduction en chainage avant : ");
		System.out.println("--------------------------------");
		for(Litteral l : fie.getBF()) {
			System.out.println(l.getName());
		}
		
	}
}
