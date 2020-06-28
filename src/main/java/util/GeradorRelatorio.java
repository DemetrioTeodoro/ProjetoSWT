package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.details.Agenda;


public class GeradorRelatorio {
	
	String msg = "";

	public String gerarPlanilhaAgenda(List<Agenda> agendas, String caminhoEscolhido) {
		String[] colunasTabelaAgenda = { "Número Ordem de Serviço"," Cliente", "Contato do Cliente", "Bairro", "Cidade", "Estado", "Data Início", "Data Final" };
		
		HSSFWorkbook planilha = new HSSFWorkbook();
		
		HSSFSheet abaPlanilha = planilha.createSheet("Agenda");
		
		Row headerRow = abaPlanilha.createRow(0);
		
		for (int i = 0; i < colunasTabelaAgenda.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasTabelaAgenda[i]);
		}
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
		int rowNum = 1;
		for (Agenda agenda : agendas) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);
			
			novaLinha.createCell(0).setCellValue(agenda.getNumOS());
			novaLinha.createCell(1).setCellValue(agenda.getCliente());
			novaLinha.createCell(2).setCellValue(agenda.getTelCliente());
			novaLinha.createCell(3).setCellValue(agenda.getBairro());
			novaLinha.createCell(4).setCellValue(agenda.getCidade());
			novaLinha.createCell(5).setCellValue(agenda.getEstado());
			novaLinha.createCell(6).setCellValue(agenda.getInicio().format(formatador));
			novaLinha.createCell(7).setCellValue(agenda.getFim().format(formatador));
		}
		
		for (int i = 0; i < colunasTabelaAgenda.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}
		
		FileOutputStream fileOut = null;
		
		try {
			fileOut = new FileOutputStream(caminhoEscolhido + ".xls");
			planilha.write(fileOut);
			msg = " Relatório criado com sucesso! ";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			msg = " Ocorreu um erro ao criar Relatório! ";
		} catch (IOException e) {
			e.printStackTrace();
			msg = " Ocorreu um erro ao criar Relatório verifique as permissões de escrita. ";
		}finally {
			try {
				fileOut.close();
				planilha.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}

}
