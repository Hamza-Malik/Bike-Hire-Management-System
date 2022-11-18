package application;

public class Email {

	
	public void senddata(String[] recepients,String subject,String filename){
	//	String[] recepients = {"malikhamza1525@gmail.com"};
		String[] bccRecepients = {"malikhamza1525@gmail.com"};
		//String subject = "Invoice from Northampton Hire!";
		String message = "How are you?";
		
		new MailUtil().sendMail(recepients, bccRecepients, subject, message,filename);
		
	}
}
