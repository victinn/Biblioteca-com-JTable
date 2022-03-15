package Biblioteca.Model;

import Biblioteca.Entities.Livros;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class modelLivros extends AbstractTableModel{
    public final ArrayList<Livros> linhas = new ArrayList();
    String[] colunas = {"Título", "Páginas", "Nome do Autor", "Gênero", "Editora", "Ano de Publicação"};
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
        
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0:
                return linhas.get(linha).getTitulo();
            case 1:
                return linhas.get(linha).getPaginas();
            case 2:
                return linhas.get(linha).getNomeAutor();
            case 3:
                return linhas.get(linha).getGenero();
            case 4:
                return linhas.get(linha).getEditora();
            case 5:
                return linhas.get(linha).getAnoPublicacao();
            
        }
                
        return null;    
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna){
            case 0:
                linhas.get(linha).setTitulo((String) valor);
                break;
            case 1:
                linhas.get(linha).setPaginas(Integer.parseInt((String) valor));
                break;
            case 2:
                linhas.get(linha).setNomeAutor((String) valor);
                break;
            case 3:
                linhas.get(linha).setGenero((String) valor);
                break;
            case 4:
                linhas.get(linha).setEditora((String) valor);
                break;
            case 5:
                linhas.get(linha).setAnoPublicacao(Integer.parseInt((String) valor));
                break;
            
        }
        this.fireTableRowsUpdated(linha, linha);
    }
   
    
    public void Adicionar(Livros l){
        linhas.add(l);
        this.fireTableDataChanged();
    }
    
    public void Remover(int index){
        linhas.remove(index);
        this.fireTableRowsDeleted(index, index);
    }
    
}
