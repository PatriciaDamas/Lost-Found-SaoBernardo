package pt.saobernardo.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import pt.saobernardo.model.Registo;

public class GestorDoacao {

	// Metodo que ir� verificar se o objeto j� foi registado h� mais de 30 dias

	public static boolean verificaData(String data) throws ParseException {
		boolean res = false;// verifica se j� foi h� mais de 30 dias e devolve
							// true caso tenha sido

		SimpleDateFormat DataFormato = new SimpleDateFormat("dd-MM-yyyy");

		// Converter a data que est� em String para Date

		Date dataRegisto = DataFormato.parse(data);
		Date dataDoacao = dataRegisto;// Data que vamos somar 30 dias � data do
										// registo
		Date dataHoje = dataRegisto;

		// Soma 30 dias � data do Registo
		Calendar somaData = Calendar.getInstance();
		somaData.setTime(dataDoacao);
		somaData.add(Calendar.DAY_OF_MONTH, 30);
		dataDoacao = somaData.getTime();

		// Definir a data do momento que queremos comparar � data dos 30 dias
		dataHoje = Calendar.getInstance().getTime();

		if (dataHoje.after(dataDoacao)) {
			res = true;
		}

		return res;
	}

	public static void doarObjeto(int codigo) {

		for (int i = 0; i < SaoBernardo.registos.size(); i++) {
			Registo reg = SaoBernardo.registos.get(i);
			if (reg.getCodigo() == (codigo)) {
				SaoBernardo.registos.remove(reg);
				SaoBernardo.doacoes.add(reg);
			}
		}

	}

}
