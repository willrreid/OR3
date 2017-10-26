package GUI;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;

import javax.swing.*;

/**
 * Created by will on 10/25/17.
 */
public class SearchResultView extends JPanel {

    SearchResultView() {
        add(resultPanel());
    }

    JPanel resultPanel() {
        JPanel tablePanel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        JTable rTable = new JTable();
        //rTable.setModel(new RestaurantLister(new ArrayList<>(new SqliteRestaurantDAO().getAll())));
        jScrollPane.setViewportView(rTable);
        tablePanel.add(jScrollPane);
        return tablePanel;
    }

}