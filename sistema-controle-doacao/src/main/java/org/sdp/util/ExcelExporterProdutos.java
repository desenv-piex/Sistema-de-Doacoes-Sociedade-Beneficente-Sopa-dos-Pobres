package org.sdp.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

public class ExcelExporterProdutos {
    public static void exportToExcel(List<Produto> produtos) {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Relatorio de doacoes");

        // Cabeçalho da planilha
        String[] colunas = {"ID", "Nome", "Valor Unitario", "Quantidade Doada", "Valor Total"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(colunas[i]);
        }

        int rowIdx = 1;
        for (Produto produto : produtos) {
            int qtdDoada = 0;
            double valorTotal = 0;
            for (DoacaoProduto dp : produto.getDoacoes()){
                qtdDoada += dp.getQuantidade();
                valorTotal += dp.getQuantidade() * produto.getValorProduto();
            }

            //{"ID", "Nome", "Valor Unitario", "Quantidade Doada", "Valor Total"}
            Row row = sheet.createRow(rowIdx++);

            Cell idCell = row.createCell(0);
            idCell.setCellValue(produto.getId());

            Cell nomeProdutoCell = row.createCell(1);
            nomeProdutoCell.setCellValue(produto.getNomeProduto());

            Cell valorProdutoCell = row.createCell(2);
            valorProdutoCell.setCellValue(produto.getValorProduto());

            Cell quantidadeDoadaCell = row.createCell(3);
            quantidadeDoadaCell.setCellValue(qtdDoada);

            Cell valorTotalCell = row.createCell(4);
            valorTotalCell.setCellValue(valorTotal);

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