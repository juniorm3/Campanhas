package campanha.model.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import campanha.model.dto.UsuarioDTO;


public class UsuarioDAO {

	private class NomeComparator implements Comparator<UsuarioDTO>{
		@Override
		public int compare(UsuarioDTO u1, UsuarioDTO u2) {
			return u1.getId().compareTo(u2.getId());
		}		
	}
	
	private static UsuarioDAO instance;
	private Map<Integer, UsuarioDTO> usuarios = new HashMap<Integer, UsuarioDTO>();
	private NomeComparator nomeComparator = new NomeComparator();
	private int proximoId = 1;
	
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public Set<UsuarioDTO> getUsuarios(){
		Set<UsuarioDTO> set = new TreeSet<UsuarioDTO>(nomeComparator);
		set.addAll(usuarios.values());
		return set;
	}
	
	public void salvar(UsuarioDTO u){
		if(u.getId() == null){
			u.setId(gerarId());
		}
		
		usuarios.put(u.getId(), u);
	}
	
	public UsuarioDTO carregar(int id){
		return usuarios.get(id);
	}
	
	public void excluir(int id){
		usuarios.remove(id);
	}
	
	private int gerarId(){
		return proximoId++;
	}
}
