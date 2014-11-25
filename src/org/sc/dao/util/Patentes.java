package org.sc.dao.util;

public enum Patentes {
	
	RECRUTA(0), SOLDADO(1), SOLDADO1CLASSE(2), CABO(3), SARGENTO3(4), SARGENTO2(5), SARGENTO1(6), SUBTENENTE(7), ASPIRANTE(8), TENENTE2(9),
	TENENTE1(10), CAPITAO(11), MAJOR(12), TENCORONEL(13), CORONEL(14), CAPELAO(15); 
	

	private int value;
	
	private Patentes(int value) {
		this.value = value;
	}
}
