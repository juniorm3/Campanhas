package campanha.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MarioJr
 *
 */
public class Erro implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private final List<String> erros;
	   
      public Erro() {
          erros = new ArrayList<String>();
      }
   
      public Erro(String mensagem) {
          erros = new ArrayList<String>();
          erros.add(mensagem);
      }
   
      public void add(String mensagem) {
          erros.add(mensagem);
      }
      
      public boolean isExisteErros() {
          return !erros.isEmpty();
      }
      
      public List<String> getErros() {
          return erros;
      }
      
      public void removeMensagem(){
    	  erros.clear();
      }

}
