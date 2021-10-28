package br.dev.renanbecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import br.dev.renanbecker.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class StopCovid {
	private static long startTime = System.currentTimeMillis(); // pode ignorar pois é apenas para calcular o tempo de execução

	public static void main(String[] args) throws IOException { // metodo main
		
		
		String enderecoArquivo = "src/Input/25102021.csv"; // fileName recebe o endereço do arquivo CSV que será analisado
		leArquivoCsv(enderecoArquivo);
	}
	
	

	public static void leArquivoCsv (String enderecoArquivo) throws IOException{ // função para leitura do arquivo CSV
		
		int branca = 0, preta = 0, parda = 0, amarela = 0, seminfo = 0, masculino = 0, feminino = 0;

		File arquivo = new File(enderecoArquivo);
		FileReader leitor = new FileReader(arquivo); // inicializa o leitor de arquivo
		
		BufferedReader br = new BufferedReader(leitor); // faz o leitor ler um pedaço de cada vez com buffer
		String line;
		while((line = br.readLine()) != null) { // faz leitura de uma linha por vez até o final do arquivo  // a String Line recebe os dados do br readline
			String linha[] = new String[32]; // cria uma string com 32 posições
			linha = line.split(";"); // divide a linha em conjuntos de informações separados por ;
			
			// é nesse ponto da função que será implementado as verificações de todos os dados que vamos tirar do arquivo
			// então falta adequar essa parte conforme a tela 3 do nosso programa
			// as linhas abaixo são apenas para exemplo e para verificar se funciona
			
				
			if(linha[4].contains("M")) { // verifica o dado 5 conforme o "dicionario de dados" e checa o valor se é M ou F
				masculino++;
			}
			else if(linha[4].contains("F")) {
				feminino++;
			}
			
			
			if(linha[6].contains("BRANCA")) { // verifica no espaço 7 a raça/cor
				branca++;
			}
			else if(linha[6].contains("PRETA")) {
				preta++;
			}
			else if(linha[6].contains("AMARELA")) {
				amarela++;
			}
			else if(linha[6].contains("PARDA")) {
				parda++;
			}
			if(linha[6].contains("SEM INFORMACAO")) {
				seminfo++;
			}
			
		}
		br.close(); // fecha o leitor bufferedreader
		System.out.println("Vacinados brancos: " + branca); // imprime os dados coletas
		System.out.println("Vacinados pretos: " + preta);
		System.out.println("Vacinados pardos: " + parda);
		System.out.println("Vacinados amarelos: " + amarela);
		System.out.println("Vacinados Sem Informação: " + seminfo);
		int total = branca + preta + parda + amarela + seminfo; // importante que a soma do total seja após a leitura do arquivo, por isso essa variavel está aqui no final
		System.out.println("Total de vacinas aplicadas: " + total);
		System.out.println("Total de masculinos: " + masculino + " total de femininas: " + feminino);

		
		// apenas para calcular o tempo de execução
		long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}
	
}
