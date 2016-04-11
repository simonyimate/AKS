package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AksMainLocal;
import model.Akskorisnik;
import model.Akspredmet;
import model.Aksaukcija;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "shoppingCart";
	Akskorisnik result=null;
	List<Aksaukcija> aukcije=new ArrayList<Aksaukcija>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type= request.getParameter("type");
		AksMainLocal cartBean = (AksMainLocal)  request.getSession().getAttribute(CART_SESSION_KEY);
		 if(cartBean == null){
			 try{
				 InitialContext ic = new InitialContext();
				 cartBean = (AksMainLocal)
						 ic.lookup("java:global/ASKEAR/AKSEJB/AksMain!bean.AksMainLocal");
				 //
				 request.getSession().setAttribute(CART_SESSION_KEY, cartBean);
				 
			
			 }catch (NamingException e) {
				 throw new ServletException(e);

			 }
		}
		 
		 	if(type.equals("login")){
				String username= request.getParameter("userName");
				String password= request.getParameter("password");
				boolean rezultat=false;
			if (!username.equals("") &&username !=null && password!=null && !password.equals("")) {
					result = cartBean.login(username, password);
					if(result!=null){
						rezultat=true;
					}
		       	
		    	}
				request.setAttribute("result", rezultat);
				if(!rezultat){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/logovaniUser.jsp");
					rd.forward(request, response);
				}
			}else if(type.equals("registracija")){
				// boolean result=false;
				// searchResult=cartBean.izlistajBlogove();
				 /*for(Oglas o:searchResult){
					 Systeelse if(type.equals("registracija")){
				// boolean result=false;
				// searchResult=cartBean.izlistajBlogove();
				 /*for(Oglas m.out.println("Servlet ispis:  "+o.getText());
				 }*/
			System.out.println("POZVANO!");
				String username= request.getParameter("userName");
				String password= request.getParameter("password");
				String ime= request.getParameter("ime");
				String prezime= request.getParameter("prezime");
				String email= request.getParameter("email");
				Akskorisnik result2=cartBean.registracija(ime, prezime, username, password, email);
				boolean rezultat2=false;
				if(result2!=null){
					rezultat2=true;
				}
				request.setAttribute("result", rezultat2);
				//request.setAttribute("searchResult", searchResult);
				RequestDispatcher rd =  getServletContext().getRequestDispatcher("/registracija.jsp");
				rd.forward(request, response);
			 }else if(type.equals("izlistaj")){
				 String tip1= request.getParameter("tip1");
				 String tip2= request.getParameter("tip2");
				 if(tip1.equals("sve")&&tip2.equals("naziv")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivSve(naziv);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("sve")&&tip2.equals("nazivVlasnik")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivVlasnikSve(naziv, result.toString());
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("sve")&&tip2.equals("nazivStanje")){
					 String naziv=request.getParameter("naziv");
					 String stanje=request.getParameter("stanje");
					 aukcije=cartBean.aukcijeNazivStanjeSve(naziv, stanje);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("sve")&&tip2.equals("nazivCena")){
					 String naziv=request.getParameter("naziv");
					 String dolnjaC=request.getParameter("dolnjaCena");
					 String gornjaC=request.getParameter("gornjaCena");
					 float c1 = Float.parseFloat(dolnjaC);
					 float c2 = Float.parseFloat(gornjaC);
					 aukcije=cartBean.aukcijeNazivCenaSve(naziv, c1, c2);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("aktivna")&&tip2.equals("naziv")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivAktivne(naziv);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("aktivna")&&tip2.equals("nazivVlasnik")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivVlasnikAktivne(naziv, result.toString());
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("aktivna")&&tip2.equals("nazivStanje")){
					 String naziv=request.getParameter("naziv");
					 String stanje=request.getParameter("stanje");
					 aukcije=cartBean.aukcijeNazivStanjeAktivne(naziv, stanje);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("aktivna")&&tip2.equals("nazivCena")){
					 String naziv=request.getParameter("naziv");
					 String dolnjaC=request.getParameter("dolnjaCena");
					 String gornjaC=request.getParameter("gornjaCena");
					 float c1 = Float.parseFloat(dolnjaC);
					 float c2 = Float.parseFloat(gornjaC);
					 aukcije=cartBean.aukcijeNazivCenaAktivne(naziv, c1, c2);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("zavrsena")&&tip2.equals("naziv")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivZavrsene(naziv);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("zavrsena")&&tip2.equals("nazivVlasnik")){
					 String naziv=request.getParameter("naziv");
					 aukcije=cartBean.aukcijeNazivVlasnikZavrsene(naziv,result.toString());
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("zavrsena")&&tip2.equals("nazivStanje")){
					 String naziv=request.getParameter("naziv");
					 String stanje=request.getParameter("stanje");
					 aukcije=cartBean.aukcijeNazivStanjeZavrsene(naziv, stanje);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("zavrsena")&&tip2.equals("nazivCena")){
					 String naziv=request.getParameter("naziv");
					 String dolnjaC=request.getParameter("dolnjaCena");
					 String gornjaC=request.getParameter("gornjaCena");
					 float c1 = Float.parseFloat(dolnjaC);
					 float c2 = Float.parseFloat(gornjaC);
					 aukcije=cartBean.aukcijeNazivCenaZavrsene(naziv, c1, c2);
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }
			 }else if(type.equals("aukcija")){
				 String naziv=request.getParameter("naziv");
				 String opis=request.getParameter("opis");
				 String stanje=request.getParameter("stanje");
				 String pCena=request.getParameter("pocetnaCena");
				 float pocetnaCena=Float.parseFloat(pCena);
				 String pathSlika=request.getParameter("slika");
					Akspredmet predmet= cartBean.novPredmet(naziv, opis, stanje, pocetnaCena, pathSlika);
					String danS=request.getParameter("dan");
					String satS=request.getParameter("sat");
					int dan=Integer.parseInt(danS);
					int sat=Integer.parseInt(satS);
					Aksaukcija aukc=cartBean.novaAukcija(result, predmet, dan, sat);
					if(aukc==null){
						request.setAttribute("kreiranje", "Kreiranje nije uspesno");
					}else{
						request.setAttribute("kreiranje", "Kreiranje je uspesno");
					}
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/unosAukcije.jsp");
				 rd.forward(request, response);
			 }
	}

}
