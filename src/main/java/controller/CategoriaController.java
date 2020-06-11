package controller;

import java.util.ArrayList;

import model.BO.CategoriaBO;
import model.entity.Categoria;

public class CategoriaController {
	
	private CategoriaBO catBO =  new CategoriaBO();
	
	public ArrayList<Categoria> listarCategorias() {
			
		return catBO.listarCategorias();
	}

}
