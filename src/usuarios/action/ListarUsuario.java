package usuarios.action;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.UsuarioDAO;
import campanha.model.dto.UsuarioDTO;

/**
 * Servlet implementation class ListarUsuario
 */
@WebServlet("/ListarUsuario")
public class ListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usuario = UsuarioDAO.getInstance();
		
		Set<UsuarioDTO> usuarios = usuario.getUsuarios();
		request.setAttribute("usuarios", usuarios);

		request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
	}

}
