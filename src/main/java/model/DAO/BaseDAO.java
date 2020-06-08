package model.DAO;

import java.util.ArrayList;

public interface BaseDAO<T> {

	public T salvar(T entity);

	public boolean atualizar(T entity);

	public boolean excluir(int id);

	public T consultarPorId(int id);

	public ArrayList<T> listarTodos();

}
