package campanha.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.CampanhaDAO;
import campanha.model.dto.CampanhaDTO;

/**
 * Servlet implementation class EditarCampanha
 */
@WebServlet("/EditarCampanha")
public class EditarCampanha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : null;
		
		CampanhaDAO campanhaDAO = CampanhaDAO.getInstance();
		
		if(id != null) {
			CampanhaDTO campanhaDTO = campanhaDAO.carregar(id);
			request.setAttribute("campanha", campanhaDTO);
		}
		
		request.getRequestDispatcher("/EditarCampanha.jsp").forward(request, response);
	}

}
