package bancodedados.view.model;

import control.ClienteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaClienteTableModel extends AbstractTableModel {

    private List<String[]> dadosClientes;
    private String[] titulos;

    public ListaClienteTableModel() {
        titulos = new String[]{"Nome Cliente", "Nome Produto", "Data", "Valor"};
        dadosClientes = new ClienteController().listarClientes();
    }

    public ListaClienteTableModel(List<String[]> dadosClientes) {
        titulos = new String[]{"Nome Cliente", "Nome Produto", "Data", "Valor"};
        this.dadosClientes = dadosClientes;
    }

    @Override
    public int getRowCount() {
        return dadosClientes.size();
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
        String[] dadosCliente = dadosClientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dadosCliente[0]; // nomeCliente
            case 1:
                return dadosCliente[1]; // nomeProduto
            case 2:
                return dadosCliente[2]; // data
            case 3:
                return dadosCliente[3]; // valor
            default:
                System.out.println("Erro ao apresentar os dados");
                return "";
        }
    }
}