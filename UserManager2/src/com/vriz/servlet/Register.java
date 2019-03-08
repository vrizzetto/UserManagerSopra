package com.vriz.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public static String VIEW_PAGES_URL="/WEB-INF/register.jsp";
	public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ATT_FORM = "form";
    
    /* Constantes des paramètres */
    public static String PARAM_MAIL = "adresse";
    public static String PARAM_MDP = "mdp";
    public static String PARAM_MDP2 = "mdp2";
    public static String PARAM_ID = "id";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreurs = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users" );
				 if(users==null){
			     users = new HashMap<String, User>();
				 }
		
		String resultat;
		String adresse = request.getParameter(PARAM_MAIL);
		String pwd1 = request.getParameter(PARAM_MDP);
		String pwd2 = request.getParameter(PARAM_MDP2);
		String id = request.getParameter(PARAM_ID);
		
		User user = null;
        /*LesUsers users = new LesUsers();*/
		
        String validateEmail = validateEmail(adresse);
        if(validateEmail != null) {
        	erreurs.put(PARAM_MAIL, validateEmail);
        }else {
        	form.put(PARAM_MAIL, adresse);
        }
        
        String validatePwd = validatePwd(pwd1, pwd2);
        if(validatePwd != null) {
        	erreurs.put(PARAM_MDP, validatePwd);
        }else {
        	form.put(PARAM_MDP, pwd1);
        	form.put(PARAM_MDP2, pwd2);
        }
        
        String validateName = validateName(id);
        if(validateName != null) {
        	erreurs.put(PARAM_ID, validateName);
        }else {
        	form.put(PARAM_ID, id);
        }
        
        boolean errorStatus;
        
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
            user = new User(adresse, pwd1, id);
            UserManager.getInstance().ajouterUser(user);
            /*users.getUsers().add(user);*/
            errorStatus = false;
            request.setAttribute("email", user.getEmail());
            request.setAttribute("id", user.getId());
        } else {
            resultat = "Échec de l'inscription.";
            errorStatus = true;
        }
        
        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute("errorStatus", errorStatus);
        
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}
	
	private String validateEmail(String email){
		String message = null;
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				message = "Veuillez saisir une adresse valide";
			}
		} else {
			message = "L'adresse mail est obligatoire";
		}
		return message;
	}
	
	private String validatePwd(String pwd1, String pwd2){
		String message = null;
		if (pwd1 != null && pwd1.trim().length() != 0 && pwd2 != null && pwd2.trim().length() != 0) {
	        if (!pwd1.equals(pwd2)) {
	            message = "Mots de passe différents, merci de les re-saisir.";
	        } else if (pwd1.trim().length() < 3) {
	            message = "Les mots de passe doivent contenir au moins 3 caractères.";
	        }
	    } else {
	        message = "Merci de saisir et confirmer votre mot de passe.";
	    }
		return message;
	}
	
	private String validateName(String name){
		String message = null;
		if ( name != null && name.trim().length() < 3 ) {
	        message = "Le nom d'utilisateur doit contenir au moins 3 caractères.";
	    }
		return message;
	}

}
