package com.vriz.servlet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserManager {
	
	private Map<String, User> users = new HashMap<>();
	
	 /** Constructeur privé */
    private UserManager()
    {}
 
    /** Instance unique pré-initialisée */
    private static UserManager instance = new UserManager();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static UserManager getInstance()
    {   return instance;
    }
    
    public void ajouterUser(User user) {
    	this.users.put(user.getEmail(), user);
    }
    
    public boolean supprimerUser(String email) {
		Set cles = users.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()){
		   Object cle = it.next();
		   if(email.equals((String) cle)){
			   users.remove((String) cle);
			   return true;
		   }
		}
		return false;
    }

	public Map<String, User> getUsers() {
		return users;
	}
    
    
}