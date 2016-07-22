package exception;

public class ProfileFormException extends Exception {
	private static final long serialVersionUID = 1L;
    String message;
	
	public ProfileFormException(String message)
	{
		this.message=message;
	}
	
	
	public String getMessage()
	{
		return message;
	}



}
