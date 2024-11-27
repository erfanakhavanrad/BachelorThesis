package com.tarazgroup.tws.util.excel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tarazgroup.tws.util.exception.TExcelIOException;
import com.tarazgroup.tws.util.global.responseheader.Col;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class TExcel {
    final List<Col> cols;

    final XSSFWorkbook xssfWorkbook;

    final Sheet sheet;

    final JsonArray records;

    final List<Col> colsVisible;

    public TExcel(JsonArray records, List<Col> cols, String sheetName) {
        this.records = records;
        this.cols = cols;
        xssfWorkbook = new XSSFWorkbook();
        sheet = xssfWorkbook.createSheet(sheetName);
        sheet.setRightToLeft(true);
        sheet.createFreezePane(0, 1);
        colsVisible = cols.stream()
                .filter(col -> col.isVisibility())
                .collect(Collectors.toList());
    }

    private void createHeader() {
        Row rowHeader = sheet.createRow(0);
        rowHeader.setHeight((short) 400);

        for (int i = 0; i < colsVisible.size(); i++) {
            sheet.setColumnWidth(i, 5000);
            Col colVisible = colsVisible.get(i);
            Cell cellHeader = rowHeader.createCell(i);
            cellHeader.setCellValue(colVisible.getTitle());
            cellHeader.setCellStyle(xSSFCellStyleHeader());
        }
    }


    private void createRows() {
        for (int i = 0; i < records.size(); i++) {
            JsonObject record = records.get(i).getAsJsonObject();
            Row rowHeader = sheet.createRow(i + 1);
            for (int j = 0; j < colsVisible.size(); j++) {
                Col colVisible = colsVisible.get(j);
                Cell cellHeader = rowHeader.createCell(j);
                JsonElement jsonElement = record.get(colVisible.getName());
                if (jsonElement != null) {
                    switch (colVisible.getType()) {
                        case BOOLEAN:
                            cellHeader.setCellValue(jsonElement.getAsBoolean());
                            break;
                        case QKEY:
                        case STRING:
                        case DATE:
                        case STRINGLONG:
                            cellHeader.setCellValue(jsonElement.getAsString());
                            break;
                        case DECIMAL:
                            cellHeader.setCellValue(jsonElement.getAsBigDecimal().doubleValue());
                            break;
                        case INTEGER:
                        case TINYINTEGER:
                            cellHeader.setCellValue(jsonElement.getAsInt());
                            break;
                        case CHIP:
                            JsonArray jsonArray = jsonElement.getAsJsonArray();
                            String[] chips = new String[jsonArray.size()];
                            for (int k = 0; k < jsonArray.size(); k++) {
                                JsonObject jsonObject = jsonArray.get(k).getAsJsonObject();
                                chips[k]= jsonObject.get("value").getAsString();
                            }
                            cellHeader.setCellValue(String.join(",", chips));
                            break;
                        default:
                            //COLOR
                            break;

                    }

                }

                if (i % 2 == 0) {
                    cellHeader.setCellStyle(xSSFCellStyleRow("EVEN"));
                } else {
                    cellHeader.setCellStyle(xSSFCellStyleRow("ODD"));
                }
            }
        }
    }

    private XSSFCellStyle xSSFCellStyleRow(String evenOdd) {
        XSSFColor colorBackgroundEven = new XSSFColor(new java.awt.Color(222, 234, 246), null);
        XSSFColor colorBackgroundOdd = new XSSFColor(new java.awt.Color(189, 214, 238), null);
        XSSFColor colorBorder = new XSSFColor(new java.awt.Color(255, 255, 255), null);
        XSSFColor colorFont = new XSSFColor(new java.awt.Color(0, 0, 0), null);
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        xssfCellStyle.setTopBorderColor(colorBorder);
        xssfCellStyle.setRightBorderColor(colorBorder);
        xssfCellStyle.setBottomBorderColor(colorBorder);
        xssfCellStyle.setLeftBorderColor(colorBorder);
        xssfCellStyle.setBorderTop(BorderStyle.THIN);
        xssfCellStyle.setBorderRight(BorderStyle.THIN);
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
        switch (evenOdd) {
            case "EVEN":
                xssfCellStyle.setFillForegroundColor(colorBackgroundEven);
                break;
            default://ODD
                xssfCellStyle.setFillForegroundColor(colorBackgroundOdd);
                break;
        }
        XSSFFont font = xssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Tahoma");
        font.setColor(colorFont);
        xssfCellStyle.setFont(font);
        return xssfCellStyle;
    }

    private XSSFCellStyle xSSFCellStyleHeader() {
        XSSFColor colorBackgroundHeader = new XSSFColor(new java.awt.Color(91, 155, 213), null);
        XSSFColor colorBorder = new XSSFColor(new java.awt.Color(255, 255, 255), null);
        XSSFColor colorFont = new XSSFColor(new java.awt.Color(255, 255, 255), null);
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        xssfCellStyle.setTopBorderColor(colorBorder);
        xssfCellStyle.setRightBorderColor(colorBorder);
        xssfCellStyle.setBottomBorderColor(colorBorder);
        xssfCellStyle.setLeftBorderColor(colorBorder);
        xssfCellStyle.setBorderTop(BorderStyle.THIN);
        xssfCellStyle.setBorderRight(BorderStyle.THIN);
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
        xssfCellStyle.setFillForegroundColor(colorBackgroundHeader);
        XSSFFont font = xssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setFontName("Tahoma");
        font.setColor(colorFont);
        xssfCellStyle.setFont(font);
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return xssfCellStyle;
    }

    public InputStreamResource build() {
        createHeader();
        createRows();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            xssfWorkbook.write(byteArrayOutputStream);
            byteArrayOutputStream.close();
            xssfWorkbook.close();
            return new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new TExcelIOException(e.getMessage());
        }

    }
}
