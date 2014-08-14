package java.br.udesc.gdc.dao;

import java.util.List;

public interface DefaultDAO<T extends Object> {
    
    public boolean inserir(T t);
    public boolean alterar(T t);
    public boolean excluir(long id);
    public T ler(long id);
    public List<T> listarTodos();
    public void atualizar(T t);
}
