package Biblioteca.Model;

import Biblioteca.Entities.Usuarios;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class modelUsuarios extends AbstractTableModel {
    public ArrayList<Usuarios> linhas = new ArrayList();
    String[] colunas = {"Nome", "Email", "Senha", "Idade", "Curso"};
    
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
        switch(coluna){
            case 0:
                return linhas.get(linha).getNome();
            case 1:
                return linhas.get(linha).getEmail();
            case 2:
                return linhas.get(linha).getSenha();
            case 3:
                return linhas.get(linha).getIdade();
            case 4:
                return linhas.get(linha).getCurso();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                linhas.get(linha).setNome((String) valor);
                break;
            case 1:
                linhas.get(linha).setEmail((String) valor);
                break;
            case 2:
                linhas.get(linha).setSenha((String) valor);
                break;
            case 3:
                linhas.get(linha).setIdade(Integer.parseInt((String) valor));
                break;
            case 4:
                linhas.get(linha).setCurso((String) valor);
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void Adicionar(Usuarios u){
        linhas.add(u);
        this.fireTableDataChanged();
    }
    
    public void Remover(int linha){
        linhas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
