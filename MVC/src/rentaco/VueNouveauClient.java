package rentaco;

import java.awt.* ;
import java.awt.event.* ;

import javax.swing.* ;

/** Vue dédiée à la saisie des informations d'un nouveau client
 * 
 * @author xilim
 *
 */
public class VueNouveauClient extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleLocations modele ;
	
	private JTextField tfNom = new JTextField() ;
	private JTextField tfPrenom = new JTextField() ;
	private JTextField tfMobile = new JTextField() ;
	
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Créer la vue de saisie d'un nouveau client
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueNouveauClient(ModeleLocations modele, Controleur controleur) {
		super();
		System.out.println("VueNouveauClient::VueNouveauClient()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		
		this.bEnregistrer.addActionListener(this) ;
		this.bAnnuler.addActionListener(this);
		
		Box boxPrincipal = Box.createVerticalBox();	
		Box boxNom = Box.createHorizontalBox();
		Box boxPrenom = Box.createHorizontalBox();
		Box boxNumero = Box.createHorizontalBox();
		Box boxBouton = Box.createHorizontalBox();
		
		
	boxNom.add(new JLabel("Nom : "));
	boxNom.add(tfNom);
	boxPrenom.add(new JLabel("Prénom : "));
	boxPrenom.add(tfPrenom);
	boxNumero.add(new JLabel("Numéro : "));
	boxNumero.add(tfMobile);
	boxBouton.add(bEnregistrer);
	boxBouton.add(bAnnuler);
	boxPrincipal.add(boxNom);
	boxPrincipal.add(boxPrenom);
	boxPrincipal.add(boxNumero);
	boxPrincipal.add(boxBouton);
	this.add(boxPrincipal);
	
	}
	
	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'action de l'utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		System.out.println("VueNouveauClient::actionPerformed()") ;
		Object sourceEvt = evenement.getSource() ;
		if(sourceEvt == this.bEnregistrer){
			this.controleur.enregistrerClient(tfNom.getText(),tfPrenom.getText(),tfMobile.getText());
			tfNom.setText("");
			tfPrenom.setText("");
			tfMobile.setText("");
		}
		else if(sourceEvt == this.bAnnuler){
			this.controleur.annulerEnregistrerClient();
			
		}
	}
	
}
