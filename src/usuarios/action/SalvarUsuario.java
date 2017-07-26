package usuarios.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.UsuarioDAO;
import campanha.model.dto.UsuarioDTO;
import campanha.util.Erro;
import campanha.util.Util;

/**
 * Servlet implementation class SalvarUsuario
 */
@WebServlet("/SalvarUsuario")
public class SalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : null;
		
		String nome = request.getParameter("nome");
		if (nome == null || nome.isEmpty()) {
		    erros.add("Nome do usuário não informado!");
		}
		
		String email = request.getParameter("email");
		if (nome == null || nome.isEmpty()) {
		    erros.add("E-Mail não informado!");
		}
		
		String nascimento = request.getParameter("dtNascimento");
		if (nascimento == null || nascimento.isEmpty()) {
		    erros.add("Data de Nascimento não informada!");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dtNascimento = null;
		try {
			dtNascimento = sdf.parse(nascimento);
		} catch (ParseException e) {
			erros.add("Falha ao converter data nascimento. " + e.getMessage());
			e.printStackTrace();			
		}
		
		Integer time = null;
		String valor = request.getParameter("time");
		if (!Util.isNumber(valor)) {
			erros.add("Campo Time informado precisa ser um numero!");
		} else if(valor == null || Integer.valueOf(valor) <= 0) {
		    erros.add("Campo Time informada não é valido!");
		} else {
			time = Integer.valueOf(valor);	
		}
				
		
		
		if(!erros.isExisteErros()) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(id, nome, email, dtNascimento, time);
			
			UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
			usuarioDAO.salvar(usuarioDTO);
		}
		
		String retorno = "/ServicosCampanha/ListarUsuario";
		if(erros.isExisteErros()) {
			retorno = "/ServicosCampanha/EditarUsuario";
		}
		
		// Envia mensagem de erro para sessão e resultados de apontamento e requsições para sessão
		enviarMenssagens(request, erros);
		
		response.sendRedirect(retorno);
	}
	
	private void enviarMenssagens(HttpServletRequest request, Erro erros) {
		if(erros.isExisteErros()){
			request.getSession().setAttribute("mensagens", erros);
		}else{
			request.getSession().setAttribute("mensagens", null);
		}
	}
}
