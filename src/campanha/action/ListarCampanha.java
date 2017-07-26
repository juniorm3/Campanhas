package campanha.action;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.CampanhaDAO;
import campanha.model.dto.CampanhaDTO;
/**
 * Servlet implementation class ListarCampanha
 */
@WebServlet("/ListarCampanha")
public class ListarCampanha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CampanhaDAO campanha = CampanhaDAO.getInstance();
		
		Set<CampanhaDTO> campanhas = campanha.getCampanhas();
		request.setAttribute("campanhas", campanhas);

		request.getRequestDispatcher("/listarCampanha.jsp").forward(request, response);
	}

}
