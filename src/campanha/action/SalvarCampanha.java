package campanha.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campanha.model.dao.CampanhaDAO;
import campanha.model.dto.CampanhaDTO;
import campanha.util.Erro;
import campanha.util.Util;

/**
 * Servlet implementation class SalvarCampanha
 */
@WebServlet("/SalvarCampanha")
public class SalvarCampanha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : null;
		
		String nome = request.getParameter("nome");
		if (nome == null || nome.isEmpty()) {
		    erros.add("Nome da campanha não informado!");
		}
		
		String inicio = request.getParameter("inicio");
		if (inicio == null || inicio.isEmpty()) {
		    erros.add("Data de inicio não informada!");
		}
		
		String fim = request.getParameter("fim");
		if (fim == null || fim.isEmpty()) {
		    erros.add("Data de fim não informada!");
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
			CampanhaDTO campanhaDTO = new CampanhaDTO(id, nome, time, inicio, fim);
			
			CampanhaDAO campanhaDAO = CampanhaDAO.getInstance();
			campanhaDAO.salvar(campanhaDTO);
		}
		
		String retorno = "/ServicosCampanha/ListarCampanha";
		if(erros.isExisteErros()) {
			retorno = "/ServicosCampanha/EditarCampanha";
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
