package campanha.model.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import campanha.model.dto.CampanhaDTO;

public class CampanhaDAO {

	private class NomeComparator implements Comparator<CampanhaDTO>{
		@Override
		public int compare(CampanhaDTO c1, CampanhaDTO c2) {
			return c1.getId().compareTo(c2.getId());
		}		
	}
	
	private static CampanhaDAO instance;
	private Map<Integer, CampanhaDTO> campanhas = new HashMap<Integer, CampanhaDTO>();
	private NomeComparator nomeComparator = new NomeComparator();
	private int proximoId = 1;
	
	public static CampanhaDAO getInstance(){
		if(instance == null){
			instance = new CampanhaDAO();
		}
		return instance;
	}
	
	public Set<CampanhaDTO> getCampanhas(){
		Set<CampanhaDTO> set = new TreeSet<CampanhaDTO>(nomeComparator);
		set.addAll(campanhas.values());
		return set;
	}
	
	public void salvar(CampanhaDTO c){
		if(c.getId() == null){
			c.setId(gerarId());
		}
		
		campanhas.put(c.getId(), c);
	}
	
	public CampanhaDTO carregar(int id){
		return campanhas.get(id);
	}
	
	public void excluir(int id){
		campanhas.remove(id);
	}
	
	private int gerarId(){
		return proximoId++;
	}
	
}
