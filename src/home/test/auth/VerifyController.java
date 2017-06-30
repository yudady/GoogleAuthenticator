package home.test.auth;

import home.test.googauth.GoogleAuthenticator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyController
 */
@WebServlet("/VerifyController")
public class VerifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codestr = request.getParameter("code");

		long code =	Long.parseLong(codestr);

		long t = System.currentTimeMillis();

		GoogleAuthenticator ga = new GoogleAuthenticator();

		ga.setWindowSize(1);  //should give 5 * 30 seconds of grace

		//Get the secret key from the session , you will get it from the db.
		String savedSecret = (String)request.getSession().getAttribute("secretKey");

		//TOOD
		savedSecret = "VW7IS2HMF37M2LTH";
		boolean result = ga.check_code(savedSecret, code, t);

		PrintWriter pw = response.getWriter();

		if (result) {
			pw.write("<html><body><h1>Code Verification Successful</h1></body></html>");
		} else {
			pw.write("<html><body><h1>Code Verification Unsuccessful</h1></body></html>");
		}
	}

}
