package itca.dao;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class TableModelUtil {

    public static <T> DefaultTableModel createTableModel(List<T> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return new DefaultTableModel();
        }

        Class<?> clazz = dataList.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();

        String[] columnNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try {
            for (T data : dataList) {
                Object[] rowData = new Object[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    rowData[i] = fields[i].get(data);
                }
                tableModel.addRow(rowData);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return tableModel;
    }
}
