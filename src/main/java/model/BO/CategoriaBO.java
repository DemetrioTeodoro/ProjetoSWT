package model.BO;

import java.util.ArrayList;

import model.DAO.CategoriaDAO;
import model.entity.Categoria;

public class CategoriaBO {
	 
	private CategoriaDAO catDAO = new CategoriaDAO();
	
	public ArrayList<Categoria>listarCategorias(){
		
		return catDAO.listarTodos();
		
	}
	
}
