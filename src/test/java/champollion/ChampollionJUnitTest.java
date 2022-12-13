package champollion;

import org.junit.jupiter.api.*;

import java.util.Date;

import static champollion.TypeIntervention.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testSousService(){
		untel.ajouteEnseignement(uml, 100,0,0);
		assertEquals(true, untel.enSousService(), "L'enseignant doit fait au moins 192 heures équivalent TD pour ne pas être en sous service");
	}

	@Test
	public void testAjoutEnseignement(){
		untel.ajouteEnseignement(uml, 10,50,20);
		untel.ajouteEnseignement(java, 10, 5, 20);
		assertTrue(untel.myServicesPrevus.size() == 2, "L'enseignement n'a pas été ajouté aux services prévu de untel");
	}

	@Test
	public void testAjoutIntervention(){
		Intervention inter = new Intervention(new Date(), 2, false, 14, CM, uml, untel);
		untel.ajouterIntervention(inter);
		assertTrue(untel.myInterventions.size() == 1, "L'intervention n'a pas été ajouté aux interventions de untel");
	}

	@Test
	public void testPlanning(){
		untel.ajouteEnseignement(uml, 10,50,20);
		Intervention inter = new Intervention(new Date(), 10, false, 15, CM, uml, untel);
		untel.ajouterIntervention(inter);
		assertEquals(0, untel.resteAPlanifier(uml, CM), "Il n'y a plus de CM a programmer normalement");

	}


}
