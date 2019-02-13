package pt.saobernardo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import pt.saobernardo.model.InstituicaoSolidariedade;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Registo;
import pt.saobernardo.model.Sala;
import pt.saobernardo.model.Utilizador;

public class SaoBernardo {

	// variáveis globais
	
	//Data e Hora
	public static SimpleDateFormat dataHora = new SimpleDateFormat("EEE, dd-MM-yyyy  HH:mm");
	public static String dataHoraFormato = dataHora.format(new Date()).toString();
	
	
	//Data
	public static SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy"); 
	public static String dataFormato = data.format(new Date()).toString();
	
	//Hora
	public static SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
	public static String horaFormato = hora.format(new Date()).toString();
	
	// Utilizador
	public static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	static File utilizadoresFile = new File("Utilizador.txt");

	// Sala
	public static ArrayList<Sala> salas = new ArrayList<Sala>();
	static File salaFile = new File("Sala.txt");

	// Instituicoes de Solidariedade
	public static ArrayList<InstituicaoSolidariedade> instituicoes = new ArrayList<InstituicaoSolidariedade>();
	static File instituicaoFile = new File("Instituicao.txt");

	// Objeto
	public static ArrayList<ObjetoPerdido> objetos = new ArrayList<ObjetoPerdido>();
	static File objetosFile = new File("Objetos.txt");

	// Registo
	public static ArrayList<Registo> registos = new ArrayList<Registo>();
	static File registoFile = new File("Registo.txt");
	
	//Doacao - Este array vai guardar os objetos que foram seleccionados nas doacoes para serem doados
	public static ArrayList<Registo> doacoes = new ArrayList<Registo>();
	static File doacoesFile = new File("Doacoes.txt");
	
	// métodos mais importantes (load, save)
	public static void load() throws FileNotFoundException {

		// Carregar Ficheiro de utilizadores
		Scanner inFile = new Scanner(utilizadoresFile);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] fields = line.split("#");
			Utilizador u = new Utilizador(fields[0], fields[1], fields[2]);
			utilizadores.add(u);

		}
		inFile.close();

		// Carregar Ficheiro de Salas
		Scanner File = new Scanner(salaFile);
		while (File.hasNextLine()) {
			String line = File.nextLine();
			Sala s = new Sala(line);
			salas.add(s);
		}
		File.close();

		// Carregar Ficheiro de Instituicoes
		Scanner iFile = new Scanner(instituicaoFile);
		while (iFile.hasNextLine()) {
			String line = iFile.nextLine();
			String[] fields = line.split("#");
			InstituicaoSolidariedade is = new InstituicaoSolidariedade(
					Integer.parseInt(fields[0]), fields[1]);
			instituicoes.add(is);

		}
		iFile.close();
		
		
		// Carregar Ficheiro dos Objetos
				Scanner oFile = new Scanner(objetosFile);
				while (oFile.hasNextLine()) {
					String line = oFile.nextLine();
					String[] fields = line.split("#");

					for (InstituicaoSolidariedade instituicao : instituicoes) {
						if (instituicao.getCodigoIs() == Integer.parseInt(fields[2])) {
							ObjetoPerdido op = new ObjetoPerdido(
									Integer.parseInt(fields[0]), fields[1], instituicao);
							objetos.add(op);
						}
					}

				}
				oFile.close();

		// Carregar Ficheiro de Registos
		Scanner rFile = new Scanner(registoFile);
		
		 while(rFile.hasNextLine()){ 
			 String line = rFile.nextLine(); 
			String[] fields = line.split("#");
			
			//Salas
			Sala s = null;
			for (Sala sala : salas) {
				if (sala.getSala().equals(fields[3])) {
					s = sala;
				}
			}
			
			//Objeto Perdido
			for (ObjetoPerdido objetoPerdido : objetos) {
				if (objetoPerdido.getCodigoTipo() == Integer.parseInt(fields[6])) {
					Registo r = new Registo(Integer.parseInt(fields[0]),fields[1],fields[2],s,fields[4],fields[5],fields[7],fields[8],fields[9],objetoPerdido);
					registos.add(r);
				}
				
			}

		
		}
		 rFile.close();

		// Carregar Ficheiro das doacoes
			Scanner dFile = new Scanner(doacoesFile);
			
			 while(dFile.hasNextLine()){ 
				 String line = dFile.nextLine(); 
				String[] fields = line.split("#");
				
				//Salas
				Sala s = null;
				for (Sala sala : salas) {
					if (sala.getSala().equals(fields[3])) {
						s = sala;
					}
				}
				
				//Objeto Perdido
				for (ObjetoPerdido objetoPerdido : objetos) {
					if (objetoPerdido.getCodigoTipo() == Integer.parseInt(fields[6])) {
						Registo d = new Registo(Integer.parseInt(fields[0]),fields[1],fields[2],s,fields[4],fields[5],fields[7],fields[8],fields[9],objetoPerdido);
						doacoes.add(d);
					}
					
				}

			
			}
			 dFile.close();

	}

	public static void saveInstituicoes() throws FileNotFoundException {

		PrintWriter out = new PrintWriter(instituicaoFile);

		for (InstituicaoSolidariedade is : instituicoes) {
			out.println(is.getCodigoIs() + "#" + is.getNomeIs());
		}
		out.close();

	}

	public static void saveSalas() throws FileNotFoundException {

		PrintWriter out = new PrintWriter(salaFile);

		for (Sala sala : salas) {
			out.println(sala.getSala());
		}
		out.close();

	}

	public static void saveUtilizadores() throws FileNotFoundException {

		PrintWriter out = new PrintWriter(utilizadoresFile);

		for (Utilizador utilizadores : utilizadores) {
			out.println(utilizadores.getNomeLogin() + "#"
					+ utilizadores.getPassword() + "#" + utilizadores.getNome());
		}
		out.close();

	}

	public static void saveRegisto() throws FileNotFoundException {

		PrintWriter out = new PrintWriter(registoFile);

		for (Registo registo : registos) {
			out.println(registo.getCodigo() + "#" + registo.getNome() + "#"
					+ registo.getEmail() + "#" + registo.getS().getSala() + "#"
					+ registo.getData() + "#" + registo.getHora() + "#"
					+ registo.getO().getCodigoTipo() + "#" + registo.getCor()
					+ "#" + registo.getEstado() + "#" + registo.getDescricao());
		}
		
		out.close();

	}

	public static void saveObjeto() throws FileNotFoundException {
		PrintWriter out = new PrintWriter(objetosFile);

		for (ObjetoPerdido objeto : objetos) {
			out.println(objeto.getCodigoTipo() + "#" + objeto.getObjetoTipo()
					+ "#" + objeto.getIs().getCodigoIs());
		}
		out.close();

	}
	public static void saveDoacao() throws FileNotFoundException {

		PrintWriter out = new PrintWriter(doacoesFile);

		for (Registo doacao : doacoes) {
			out.println(doacao.getCodigo() + "#" + doacao.getNome() + "#"
					+ doacao.getEmail() + "#" + doacao.getS().getSala() + "#"
					+ doacao.getData() + "#" + doacao.getHora() + "#"
					+ doacao.getO().getCodigoTipo() + "#" + doacao.getCor()
					+ "#" + doacao.getEstado() + "#" + doacao.getDescricao());
		}
		
		out.close();

	}

}
