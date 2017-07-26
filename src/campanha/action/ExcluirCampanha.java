package campanha.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.CampanhaDAO;

/**
 * Servlet implementation class ExcluirCampanha
 */
@WebServlet("/ExcluirCampanha")
public class ExcluirCampanha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		CampanhaDAO campanha = CampanhaDAO.getInstance();
		campanha.excluir(id);
		
		response.sendRedirect("/ServicosCampanha/ListarCampanha");
	}

}
