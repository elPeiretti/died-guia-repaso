package parte1;

import java.util.List;
import parte2.*;
public abstract class Capacitacion {
	
	protected boolean prioritaria;
	protected Tema tema;
	protected Integer creditosMinimos;
	
	public abstract Integer calcularCreditos();
	public abstract Double calcularCosto();
	public Tema getTema() {
		return this.tema;
	}
	public Integer getCreditosMinimos() {
		return this.creditosMinimos;
	}
	
	public abstract void inscribir(Alumno a) throws CreditosInsuficientesException,TallerCompletoException;
	public abstract void aprobar(Alumno a);
}
