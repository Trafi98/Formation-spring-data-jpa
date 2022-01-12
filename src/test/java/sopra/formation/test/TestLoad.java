package sopra.formation.test;

import java.time.LocalDate;
import java.time.Month;

import sopra.formation.Application;
import sopra.formation.dao.IAbsenceDao;
import sopra.formation.dao.ICompetenceDao;
import sopra.formation.dao.ICoursDao;
import sopra.formation.dao.ICursusDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.model.Absence;
import sopra.formation.model.Competence;
import sopra.formation.model.Cours;
import sopra.formation.model.Cursus;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Droit;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.Niveau;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.Utilisateur;

public class TestLoad {

	public static void main(String[] args) {
		IAbsenceDao abscenceDao = Application.getInstance().getAbscenceDao();
		ICompetenceDao competenceDao = Application.getInstance().getCompetenceDao();
		ICoursDao coursDao = Application.getInstance().getCoursDao();
		ICursusDao cursusDao = Application.getInstance().getCursusDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		ISalleDao salleDao = Application.getInstance().getSalleDao();
		IUtilisateurDao utilisateurDao = Application.getInstance().getUtilisateurDao();

		Utilisateur admin = new Utilisateur();
		admin.setIdentifiant("admin");
		admin.setMotDePasse("admin12345");
		admin.setDroit(Droit.ADMIN);
		admin.setEmail("admin@ajc-ingenierie.fr");

		admin = utilisateurDao.save(admin);

		Utilisateur manu = new Utilisateur();
		manu.setNom("JANVIER");
		manu.setPrenom("Manuela");
		manu.setIdentifiant("manu");
		manu.setMotDePasse("manu");
		manu.setDroit(Droit.GESTIONNAIRE);
		manu.setEmail("manuela@ajc-ingenierie.fr");

		manu = utilisateurDao.save(manu);

		Formateur jeremy = new Formateur();
		jeremy.setNom("PERROUAULT");
		jeremy.setPrenom("Jérémy");
		jeremy.setIdentifiant("jerem");
		jeremy.setMotDePasse("jerem");
		jeremy.setDroit(Droit.FORMATEUR);
		jeremy.setEmail("jerem@ascadis.fr");

		jeremy = (Formateur) utilisateurDao.save(jeremy);

		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 27), jeremy));
		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 28), jeremy));

		Formateur eric = new Formateur();
		eric.setNom("SULTAN");
		eric.setPrenom("Eric");
		eric.setIdentifiant("eric");
		eric.setMotDePasse("eric");
		eric.setDroit(Droit.FORMATEUR);
		eric.setEmail("e.sultan@ajc-ingenierie.fr");

		eric = (Formateur) utilisateurDao.save(eric);

		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 24), eric));
		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 25), eric));
		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 26), eric));
		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 27), eric));
		abscenceDao.save(new Absence(LocalDate.of(2022, Month.JANUARY, 28), eric));

		Stagiaire marine = new Stagiaire();
		marine.setNom("GUEDON");
		marine.setPrenom("Marine");
		marine.setIdentifiant("marine");
		marine.setMotDePasse("marine");
		marine.setDroit(Droit.STAGIAIRE);
		marine.setEmail("marine@gmail.com");
		marine.setDateNaissance(LocalDate.of(1994, Month.FEBRUARY, 3));

		marine = (Stagiaire) utilisateurDao.save(marine);

		Stagiaire louis = new Stagiaire();
		louis.setNom("DABOT");
		louis.setPrenom("Louis");
		louis.setIdentifiant("louis");
		louis.setMotDePasse("louis");
		louis.setDroit(Droit.STAGIAIRE);
		louis.setEmail("louis@gmail.com");
		louis.setDateNaissance(LocalDate.of(1994, Month.OCTOBER, 24));

		louis = (Stagiaire) utilisateurDao.save(louis);

		Salle zoomSopraJavaNantes20211129 = new Salle("Zoom Sopra Java Nantes 29/11/2021");
		zoomSopraJavaNantes20211129
				.setUrl("https://ajc-ingenierie-fr.zoom.us/j/89940652253?pwd=a3ppbE5mbzdUWDdyOGFTbkVrTGxsUT09");

		zoomSopraJavaNantes20211129 = salleDao.save(zoomSopraJavaNantes20211129);

		Filiere sopraJavaNantes20211129 = new Filiere();
		sopraJavaNantes20211129.setDateDebut(LocalDate.of(2021, Month.NOVEMBER, 29));
		sopraJavaNantes20211129.setDuree(45);
		sopraJavaNantes20211129.setDispositif(Dispositif.CPRO);
		sopraJavaNantes20211129.setGestionnaire(manu);
		sopraJavaNantes20211129.setReferent(jeremy);
		sopraJavaNantes20211129.setSalle(zoomSopraJavaNantes20211129);

		sopraJavaNantes20211129 = filiereDao.save(sopraJavaNantes20211129);

		Cursus marineSopraJavaNantes20211129 = new Cursus(marine, sopraJavaNantes20211129);

		marineSopraJavaNantes20211129 = cursusDao.save(marineSopraJavaNantes20211129);

		Cursus louisSopraJavaNantes20211129 = new Cursus(louis, sopraJavaNantes20211129);

		louisSopraJavaNantes20211129 = cursusDao.save(louisSopraJavaNantes20211129);

		Matiere algo = new Matiere("ALGO", 3);

		algo = matiereDao.save(algo);

		Matiere javaObjet = new Matiere("Java Objet", 3);

		javaObjet = matiereDao.save(javaObjet);

		Matiere javaAvance = new Matiere("Java Avancee", 5);

		javaAvance = matiereDao.save(javaAvance);

		Matiere maven = new Matiere("Maven", 2);

		maven = matiereDao.save(maven);

		Matiere JPA = new Matiere("JPA", 5);

		JPA = matiereDao.save(JPA);

		Cours coursAlgo = new Cours();
		coursAlgo.setFiliere(sopraJavaNantes20211129);
		coursAlgo.setFormateur(jeremy);
		coursAlgo.setMatiere(algo);
		coursAlgo.setDuree(3);
		coursAlgo.setOrdre(1);

		coursAlgo = coursDao.save(coursAlgo);

		Cours coursJavaObjet = new Cours();
		coursJavaObjet.setFiliere(sopraJavaNantes20211129);
		coursJavaObjet.setFormateur(jeremy);
		coursJavaObjet.setMatiere(javaObjet);
		coursJavaObjet.setDuree(2);
		coursJavaObjet.setOrdre(2);

		coursJavaObjet = coursDao.save(coursJavaObjet);

		Cours coursJavaAvance = new Cours();
		coursJavaAvance.setFiliere(sopraJavaNantes20211129);
		coursJavaAvance.setFormateur(jeremy);
		coursJavaAvance.setMatiere(javaAvance);
		coursJavaAvance.setDuree(4);
		coursJavaAvance.setOrdre(3);

		coursJavaAvance = coursDao.save(coursJavaAvance);

		Cours coursJPA = new Cours();
		coursJPA.setFiliere(sopraJavaNantes20211129);
		coursJPA.setFormateur(eric);
		coursJPA.setMatiere(JPA);
		coursJPA.setDuree(4);
		coursJPA.setOrdre(5);

		coursJPA = coursDao.save(coursJPA);

		Cours coursMaven = new Cours();
		coursMaven.setFiliere(sopraJavaNantes20211129);
		coursMaven.setFormateur(eric);
		coursMaven.setMatiere(maven);
		coursMaven.setDuree(1);
		coursMaven.setOrdre(4);

		coursMaven = coursDao.save(coursMaven);

		competenceDao.save(new Competence(Niveau.EXPERT, jeremy, algo));
		competenceDao.save(new Competence(Niveau.EXPERT, jeremy, javaObjet));
		competenceDao.save(new Competence(Niveau.EXPERT, jeremy, javaAvance));
		competenceDao.save(new Competence(Niveau.CONFIRME, jeremy, maven));
		competenceDao.save(new Competence(Niveau.CONFIRME, jeremy, JPA));

		competenceDao.save(new Competence(Niveau.CONFIRME, eric, algo));
		competenceDao.save(new Competence(Niveau.CONFIRME, eric, javaObjet));
		competenceDao.save(new Competence(Niveau.CONFIRME, eric, javaAvance));
		competenceDao.save(new Competence(Niveau.EXPERT, eric, maven));
		competenceDao.save(new Competence(Niveau.CONFIRME, eric, JPA));
	}

}
