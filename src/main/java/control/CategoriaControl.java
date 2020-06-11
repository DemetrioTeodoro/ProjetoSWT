package control;

import java.util.ArrayList;

import model.BO.CategoriaBO;
import model.entity.Categoria;

public class CategoriaControl {
	
	private CategoriaBO catBO =  new CategoriaBO();
	
	public ArrayList<Categoria> listarCategorias() {
			
		return catBO.listarCategorias();
	}

}
