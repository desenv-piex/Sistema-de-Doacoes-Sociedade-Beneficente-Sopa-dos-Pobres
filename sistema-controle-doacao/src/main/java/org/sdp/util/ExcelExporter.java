package org.sdp.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sdp.model.Doacao;
import org.sdp.model.DoacaoProduto;
import org.sdp.model.Produto;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExcelExporter {
    public static void exportToExcel(List<Doacao> doacoes) {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Relatorio de doacoes");

        // Cabeçalho da planilha
        String[] colunas = {"ID", "Tipo de Doacao", "Data da Doacao", "Produtos", "Valor Total"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(colunas[i]);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int rowIdx = 1;
        for (Doacao doacao : doacoes) {
            Row row = sheet.createRow(rowIdx++);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(doacao.getId());
            Cell tipoDoacaoCell = row.createCell(1);
            tipoDoacaoCell.setCellValue(doacao.getTipoDoacao().name());
            Cell dataDoacaoCell = row.createCell(2);
            dataDoacaoCell.setCellValue(dateFormat.format(doacao.getDataDoacao()));

            // Concatena os nomes dos produtos
            StringBuilder produtosStr = new StringBuilder();
            for (DoacaoProduto produto : doacao.getProdutos()) {
                produtosStr.append(produto.getProduto().getNomeProduto()).append(", ");
            }
            if (produtosStr.length() > 2) {
                produtosStr.setLength(produtosStr.length() - 2); // Remove a última vírgula e espaço
            }
            Cell produtosCell = row.createCell(3);
            produtosCell.setCellValue(produtosStr.toString());

            Cell valorTotalCell = row.createCell(4);
            valorTotalCell.setCellValue(doacao.valorTotalDoado());
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