package validations;

import database.UserDatabase;
import models.user.User;

public class UserValidations {


	    // validar letras
	    public static boolean onlyLetters(String text) {

	        return text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
	    }

	    // validar numeros
	    public static boolean onlyNumbers(String text) {

	        return text.matches("[0-9]+");
	    }

	    // validar correo
	    public static boolean validMail(String mail) {

	        return mail.matches(
	                "^[A-Za-z0-9+_.-]+@(.+)$"
	        );
	    }

	    // campos vacios
	    public static boolean emptyField(String text) {

	        return text.trim().isEmpty();
	        
	    }
	    
	    // validar telefono
	    public static boolean validPhone(String phone) {

	        return phone.matches("[0-9]{8}");
	    }
	    
	    // validación para que telefono tenga solo 8 digitos
	    public static boolean phoneLength(String phone) {

	        return phone.length() == 8;
	    }
	    
	     // DETECTA ID REPETIDO
	    public static boolean idExists(String id) {

	        UserDatabase.loadUsers();

	        for (User user : UserDatabase.users) {

	            if (String.valueOf(user.getId()).equals(id)) {

	                return true;
	            }
	        }

	        return false;
	        
	    }
	    
	    // DETECTA CARNET REPETIDOS
	    public static boolean carnetExists(String carnet) {

	        UserDatabase.loadUsers();

	        for (User user : UserDatabase.users) {

	            if (user.getCarnet().equalsIgnoreCase(carnet)) {

	                return true;
	            }
	        }

	        return false;
	    }
	    
	    
	    
	    
	}


