package validations;

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
	    
	    
	    
	    
	}


