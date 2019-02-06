import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHomepage extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

            request.getServletContext().getRequestDispatcher("/WEB-INF/views/homepage.jsp").forward(request, response);
            }
        //request.getRequestDispatcher("/WEB-INF/views/homepage.jsp").forward(request, response);
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
    response.getWriter().println("<h1>success</h1>  ");
    request.getServletContext().getRequestDispatcher("/WEB-INF/views/homepage.jsp").include(request, response);
}
    
}