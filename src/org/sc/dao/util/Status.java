package org.sc.dao.util;

public enum Status {
	
	DESATIVADO(0), ATIVADO(1), AFASTADO(2);

	private int status;
	
	private Status(int status) {
		this.status = status;
	}
}
