 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	
	IJournal journal;
	
	boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException	
	{
		EtudiantRepository StudRep= new EtudiantRepository();
	    UniversiteRepository UnivRep= new UniversiteRepository();
	    Etudiant stud = new Etudiant(matricule, nom, prénom, email,pwd,id_universite);
	    Universite univ=UnivRep.GetById(id_universite);
	    
	    journal.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }    
	    
	    if (StudRep.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (StudRep.Exists(email))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud);
		 journal.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	public void AjoutBonus(Etudiant stud,Universite univ  ) {
		if (univ.getPack() == TypePackage.Standard) {
			stud.bonus(5);
		}
		else if (univ.getPack() == TypePackage.Premium)
	     {stud.bonus(10);}
	}
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
