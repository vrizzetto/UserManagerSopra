	<form action="Register" method="post" id="form1">
	
		<fieldset>
			<legend>Inscription</legend>
				<div>Formulaire d'inscription, les champs (*) sont obligatoires :</div>
				
				<br/>
				
				<div>
					<label for="adresse">Adresse mail <span>*</span></label>
		        	<input type="text" id="adresse" name="adresse" value="${form['adresse'] }">
		        	<span class="erreur">${erreurs['adresse']}</span>
		        </div>
		        <br/>
		        <div>
		        	<label for="mdp">Mot de passe <span>*</span></label>
		        	<input type="password" id="mdp" name="mdp" value="${form['mdp'] }">
		        	<span class="erreur">${erreurs['mdp']}</span>
		        </div>
		        <br/>
		        <div>	
		        	<label for="mdp2">Confirmation <span>*</span></label>
		        	<input type="password" id="mdp2" name="mdp2" value="${form['mdp2'] }">
		        </div>
		        <br/>
		        <div>	
		        	<label for="id">Nom </label>
		        	<input type="text" id="id" name="id" value="${form['id'] }">
		        	<span class="erreur">${erreurs['id']}</span>
				</div>
				
				<br/>
				
		    	<div>
		    		<button type="submit" form="form1" value="Submit">Enregistrement</button>
		    	</div>
		    	
		    	<div>
		    		 <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
		    	</div>
		</fieldset>
	</form>