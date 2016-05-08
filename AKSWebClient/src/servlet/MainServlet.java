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
import model.Aksponuda;
import model.Aksporuka;
import model.Akspredmet;
import model.Aksaukcija;
import model.Akskomentar;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "shoppingCart";
	Akskorisnik result=null;
	List<Aksaukcija> aukcije=new ArrayList<Aksaukcija>();
	List<Aksaukcija> aukcijeMoje=new ArrayList<Aksaukcija>();
	List<Aksaukcija> aukcijeGdeLicitiram=new ArrayList<Aksaukcija>();
	List<Aksaukcija> aukcijeUspesneVlasnik=new ArrayList<Aksaukcija>();
	List<Aksaukcija> aukcijeUspesneKupac=new ArrayList<Aksaukcija>();
       
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
						 ic.lookup("java:global/AKSEAR/AKSEJB/AksMain!bean.AksMainLocal");
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
					aukcijeMoje=cartBean.aukcijeReportP(result.getIme());
					aukcijeGdeLicitiram=cartBean.aukcijeReportK(result.getIme());
					aukcijeUspesneVlasnik=cartBean.aukcijeListP(result.getIme());
					aukcijeUspesneKupac=cartBean.aukcijeListK(result.getIme());
					request.getSession().setAttribute("aukcijeMoje", aukcijeMoje);
					request.getSession().setAttribute("aukcijeGdeLicitiram", aukcijeGdeLicitiram);
					request.getSession().setAttribute("aukcijeUspesneVlasnik", aukcijeUspesneVlasnik);
					request.getSession().setAttribute("aukcijeUspesneKupac", aukcijeUspesneKupac);
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
					 System.out.println("Bean NAZIV+SVE FIRST");
					 String naziv=request.getParameter("naziv");
					 System.out.println("Bean NAZIV+SVE PARAMETER");
					 aukcije=cartBean.aukcijeNazivSve(naziv);
					 System.out.println("Bean NAZIV+SVE LIST");
					 request.setAttribute("aukcije", aukcije);
					 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
						rd.forward(request, response);
				 }else if(tip1.equals("sve")&&tip2.equals("nazivVlasnik")){
					 String naziv=request.getParameter("naziv");
					 String vlasnik=request.getParameter("vlasnik");
					 aukcije=cartBean.aukcijeNazivVlasnikSve(naziv, vlasnik);
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
					 String vlasnik=request.getParameter("vlasnik");
					 aukcije=cartBean.aukcijeNazivVlasnikAktivne(naziv, vlasnik);
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
					 String vlasnik=request.getParameter("vlasnik");
					 aukcije=cartBean.aukcijeNazivVlasnikZavrsene(naziv,vlasnik);
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
						request.setAttribute("kreiranje", "Aukcija nije uspesno unesena");
					}else{
						request.setAttribute("kreiranje", "Aukcija je uspesno uneta");
					}
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/unosAukcije.jsp");
				 rd.forward(request, response);
				 //!!!!!!!!
				 //Poruku saljemo kupcu!
			 }else if(type.equals("porukaKupac")){
				 String auk= request.getParameter("auk");
				 String text=request.getParameter("text");
				 int aukcijaId=Integer.parseInt(auk);
				 Aksporuka por=cartBean.novaPorukaP(aukcijaId, text);
				 if(por==null){
					 request.setAttribute("por", "Poruka nije poslata");
				 }else{
					 request.setAttribute("por", "Poruka je poslata");
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/poruka.jsp");
				 rd.forward(request, response); 
				 //!!!!!!!!!!!
				 //Poruku saljemo prodavcu
			 }else if(type.equals("porukaProdavac")){
				 String auk= request.getParameter("auk");
				 String text=request.getParameter("text");
				 int aukcijaId=Integer.parseInt(auk);
				 Aksporuka por=cartBean.novaPorukaK(aukcijaId, text);
				 if(por==null){
					 request.setAttribute("por", "Poruka nije poslata");
				 }else{
					 request.setAttribute("por", "Poruka je poslata");
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/prodavacPoruka.jsp");
				 rd.forward(request, response); 
			 }
		 	
			 else if(type.equals("pogledajPorukuKupac")){
				 String auk= request.getParameter("auk");
				 int aukcijaId=Integer.parseInt(auk);
				 List<Aksporuka> poruke=cartBean.porukaList(aukcijaId);
				 request.setAttribute("poruke", poruke);
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/pogledajPorukuKupac.jsp");
				 rd.forward(request, response); 
			 }else if(type.equals("pogledajPorukuProdavac")){
				 String auk= request.getParameter("auk");
				 int aukcijaId=Integer.parseInt(auk);
				 List<Aksporuka> poruke=cartBean.porukaList(aukcijaId);
				 request.setAttribute("poruke", poruke);
				
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/pogledajPorukuProdavac.jsp");
				 rd.forward(request, response); 
				 
				 
				 //!!!!!!!!!!!!!
				 //ISHOD LICITACIJE!!!
			 }else if(type.equals("ishodLicitacije")){
				 List<Aksaukcija> aukcijeSveVlasnik=cartBean.aukcijeReportP(result.getIme());
				 List<Aksaukcija> aukcijeSveLicit=cartBean.aukcijeReportK(result.getIme());
				 List<Aksaukcija> aukcijeUspesneVlasnik=cartBean.aukcijeListP(result.getIme());
				 List<Aksaukcija> aukcijeUspesneKupac=cartBean.aukcijeListK(result.getIme());
				 
				 request.setAttribute("aukcijeSveVlasnik",aukcijeSveVlasnik);
				 request.setAttribute("aukcijeSveLicit",aukcijeSveLicit);
				 request.setAttribute("aukcijeUspesneVlasnik",aukcijeUspesneVlasnik);
				 request.setAttribute("aukcijeUspesneKupac",aukcijeUspesneKupac);
				
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/rezultatiLicitacija.jsp");
				 rd.forward(request, response);
				 
				 
				 //!!!!!!!!!
				 //SAMA LICITACIJA!!! 
			 }else if(type.equals("licitiraj")){
				 String auk= request.getParameter("auk");
				 String iznos= request.getParameter("iznos");
				 int aukcijaId=Integer.parseInt(auk);
				 float vrednost=Float.parseFloat(iznos);
				 Aksponuda pon=cartBean.novaPonuda(null, aukcijaId,vrednost);
				 if(pon==null){  
					 request.setAttribute("lic", "licitacija je neuspesna,molimo vas registrujte se na nas sistem");
				 }else if(pon.getVrednost()<-0.5f && pon.getVrednost()>-1.5f){
					 request.setAttribute("lic", "Pravise mali iznost ste dali tokom licitacije");
				 }else if(pon.getVrednost()<-1.5f && pon.getVrednost()>-2.5f){
					 request.setAttribute("lic", "Aukcija je vec zavrsena");
				 }else{
					 request.setAttribute("lic", "Licitacija je uspesna");
				 }
				
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Izlistaj.jsp");
				 rd.forward(request, response); 
				 
				 
				 //KOMENTAR I OCENJIVANJE!!!
			 }else if(type.equals("comment")){
				 String auk= request.getParameter("auk");
				 int aukcijaId=Integer.parseInt(auk);
				 String oc= request.getParameter("oc");
				 String text=request.getParameter("text");
				 int ocena=Integer.parseInt(oc);
				 Akskomentar kom=cartBean.novKommentarP(aukcijaId, text, ocena);
				 if (kom!=null){
					 request.setAttribute("por", "komentar i ocena su poslati");
				 }else{
					 request.setAttribute("por", "komentar i ocena nisu poslati");
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/ocenaAndcomentars.jsp");
				 rd.forward(request, response); 
				 
				 //Ishod licitacija na kojima sam ucestvovao!!!!
			 }
			 else if(type.equals("commentKupac")){
				 String auk= request.getParameter("auk");
				 int aukcijaId=Integer.parseInt(auk);
				 String oc= request.getParameter("oc");
				 String text=request.getParameter("text");
				 int ocena=Integer.parseInt(oc);
				 Akskomentar kom=cartBean.novKommentarK(aukcijaId, text, ocena);
				 if (kom!=null){
					 request.setAttribute("por", "komentar i ocena su poslati");
				 }else{
					 request.setAttribute("por", "komentar i ocena nisu poslati");
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/ocenaAndcomentarsKupac.jsp");
				 rd.forward(request, response); 
			 }else if(type.equals("ishodLicitacijeUcestvovao")){
				 List<Aksaukcija> aukcijeSveVlasnik=cartBean.aukcijeReportP(result.getIme());
				 List<Aksaukcija> aukcijeSveLicit=cartBean.aukcijeReportK(result.getIme());
				 List<Aksaukcija> aukcijeUspesneVlasnik=cartBean.aukcijeListP(result.getIme());
				 List<Aksaukcija> aukcijeUspesneKupac=cartBean.aukcijeListK(result.getIme());
				 
				 request.setAttribute("aukcijeSveVlasnik",aukcijeSveVlasnik);
				 request.setAttribute("aukcijeSveLicit",aukcijeSveLicit);
				 request.setAttribute("aukcijeUspesneVlasnik",aukcijeUspesneVlasnik);
				 request.setAttribute("aukcijeUspesneKupac",aukcijeUspesneKupac);
				
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/listaGdeSamUcestvovao.jsp.jsp");
				 rd.forward(request, response);
			 }else if(type.equals("commKup")){
				 String kupac= request.getParameter("kupac");
				 List<Akskomentar> kom=cartBean.kommentarP(kupac);
				 if (kom!=null){
					 request.setAttribute("KomentariKup", kom);
				 }else{
					 request.setAttribute("KomentariKup", null);
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/ocenaKupac.jsp");
				 rd.forward(request, response); 
			 }
			 else if(type.equals("commProd")){
				 String prodavac= request.getParameter("prodavac");
				 List<Akskomentar> kom=cartBean.kommentarK(prodavac);
				 if (kom!=null){
					 request.setAttribute("KomentariProd", kom);
				 }else{
					 request.setAttribute("KomentariProd", null);
				 }
				 RequestDispatcher rd =  getServletContext().getRequestDispatcher("/ocenaProdavac.jsp");
				 rd.forward(request, response); 
			 }
		 	}

}
