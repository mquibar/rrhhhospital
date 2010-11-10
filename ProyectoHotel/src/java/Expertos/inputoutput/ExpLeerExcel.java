/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.inputoutput;

import java.io.File;
import jxl.*;

/**
 *
 * @author Leo
 */
public class ExpLeerExcel {

    Workbook _workbook;
    Sheet _sheet;

    public boolean  openSource(String path, int shetIndex) {
        boolean res = true;

        try {
            _workbook = Workbook.getWorkbook(new File(path));
            _sheet = _workbook.getSheet(shetIndex);
        } catch (Exception ex) {
            res = false;
        }

        return res;
    }

    public Object[] getRows() {
        return getRows(0);
    }

    public Object[] getRows(int beginIndex) {
        return getRows(beginIndex, _sheet.getColumns()-1);
    }
    
    public Object[] getRows(int beginIndex, int endIndex) {

        Object[] rows = new Object[endIndex - beginIndex + 1];

        int i = 0;
        for (i = beginIndex; i <= endIndex; i++) {
            rows[i] = getRow(i);
        }

        return rows;
    }

    public Object[] getRow(int rowIndex) {
        int colCount = _sheet.getColumns();

        Object[] row = new Object[colCount];

        int i = 0;
        for (i = 0; i < colCount; i++) {
            row[i] = getCellData(_sheet.getCell(rowIndex, i));
        }

        return row;
    }

    Object getCellData(Cell cell) {

        Object cellData = cell.getContents();

        if (cell.getType() == CellType.LABEL) {
            LabelCell lc = (LabelCell) cell;
            cellData = lc.getString();
        } else if (cell.getType() == CellType.NUMBER) {
            NumberCell nc = (NumberCell) cell;
            cellData = nc.getValue();
        } else if (cell.getType() == CellType.DATE) {
            DateCell dc = (DateCell) cell;
            cellData = dc.getDate();
        }

        return cellData;
    }

    public void quit() {
// Finalmente cerramos el workbook y liberamos la memoria
        _workbook.close();
    }
}
