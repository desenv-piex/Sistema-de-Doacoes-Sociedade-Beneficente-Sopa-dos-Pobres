package org.sdp.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sdp.model.Produto;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public static void exportToExcel(List<Produto> produtos) {
        // Cria um novo arquivo XLSX (Excel)
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Data");
        String[] colunas = {"ID", "Nome do Produto", "Quantidade", "Valor"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(colunas[i]);
        }

        int rowIdx = 1;
        for (Produto produto : produtos) {
            Row row = sheet.createRow(rowIdx++);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(produto.getId());
            Cell nomeProdutoCell = row.createCell(1);
            nomeProdutoCell.setCellValue(produto.getNomeProduto());
            Cell qntProdutoCell = row.createCell(2);
            qntProdutoCell.setCellValue(produto.getQntProduto());
            Cell valorProdutoCell = row.createCell(3);
            valorProdutoCell.setCellValue(produto.getValorProduto());
        }


        // Cria o seletor de arquivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Arquivo Excel");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos Excel (*.xlsx)", "xlsx"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (!selectedFile.getName().toLowerCase().endsWith(".xlsx")) {
                selectedFile = new File(selectedFile.getParentFile(), selectedFile.getName() + ".xlsx");
            }

            try (FileOutputStream fileOut = new FileOutputStream(selectedFile)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Arquivo Excel salvo com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo Excel: " + e.getMessage());
            }
        }
    }

}