package ma.ac.esi.referentielCompetences.controller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.ConnectBd;
import ma.ac.esi.referentielCompetences.model.NoSuchUserException;
import jakarta.servlet.annotation.*;
import java.io.PrintWriter;

@WebServlet("/controller")
public class ServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2140799689820285369L;
	
	public void WriteResponse(HttpServletResponse resp,String msg) {
		try {
			PrintWriter p = resp.getWriter();
			p.append(msg);			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String login= req.getParameter("login");
		String password  = req.getParameter("password");
		System.out.println(req.getHeader("Content-type")+" "+login+"  " + password);
		resp.setContentType("text/html");
		
		ConnectBd cb = new ConnectBd();
		try {
			cb.FindUser(login, password);
			this.WriteResponse(resp, "<h1>Bienvenue Mr/Mme "+ login+"</h1>");
		}catch(NoSuchUserException e) {
			this.WriteResponse(resp, "Login ou mot de passe érroné");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
