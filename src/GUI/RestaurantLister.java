package GUI;

import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RestaurantLister extends AbstractTableModel {

    private List<Restaurant>  restaurants = new ArrayList<>();
    private String[] columnNames = {"Name", "Address", "Category", "Website"};

    public RestaurantLister(List<Restaurant> restaurants){
        this.restaurants = restaurants;
    }

    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return restaurants.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Restaurant r = restaurants.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getName();
            case 1:
                return r.getAddress();
            case 2:
                return r.getCategory();
            case 3:
                return r.getWebsite();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
        }
        return null;
    }
}