import java.text.SimpleDateFormat;
import java.util.Date;

public class AfficheDate extends  AfficheMulti{
	
	public void outPut_Msg (String message) {
		SimpleDateFormat f =new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		System.out.println(message + f.format(date));}
}

