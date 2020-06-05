package model.DAO;

import java.util.ArrayList;

public interface BaseDAO<T> {

	public T salvar(T entity);

	public T atualizar(T entity);

	public boolean deletar(T entity);

	public T listarPorId(T entity);

	public ArrayList<T> listarTodos(T entity);

}
