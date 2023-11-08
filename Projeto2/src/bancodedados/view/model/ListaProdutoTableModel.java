ppackage bancodedados.view.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import control.ProdutoController;

public class ListaProdutoTableModel extends AbstractTableModel {

    private List<String[]> dadosProdutos;
    private String[] titulos;

    public ListaProdutoTableModel() {
        titulos = new String[]{"Nome Produto", "Quantidade Produto", "Data de Entrada", "Valor do produto"};
        dadosProdutos = new ProdutoController().listarProdutos();
    }

    public ListaProdutoTableModel(List<String[]> dadosProdutos) {
        titulos = new String[]{"Nome Produto", "Quantidade Produto", "Data de Entrada", "Valor do produto"};
        this.dadosProdutos = dadosProdutos;
    }

    @Override
    public int getRowCount() {
        return dadosProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] dadosProduto = dadosProdutos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dadosProduto[0]; // nomeProduto
            case 1:
                return dadosProduto[1]; // qtddProduto
            case 2:
                return dadosProduto[2]; // dataEntrada
            case 3:
                return dadosProduto[3]; // valor
            default:
                System.out.println("Erro ao apresentar os dados");
                return "";
        }
    }
}
