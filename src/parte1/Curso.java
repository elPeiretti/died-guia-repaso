package parte1;

import parte2.*;

public class Curso extends Capacitacion {
	
	private Integer cantClases;
	private Integer duracionClases;
	private Docente profe;
	
	@Override
	public Integer calcularCreditos() {
		Integer credPorClases = Math.min(cantClases/2,10);
		Integer antiguedadProfe = this.profe.getAntiguedad();
		
		if(antiguedadProfe<6) {
			credPorClases++;
		}
		else if(antiguedadProfe<16) {
			credPorClases+=3;
		}
		else {
			credPorClases+=5;
		}
		
		return credPorClases;
		
	}

	@Override
	public Double calcularCosto() {
		Double costo = this.profe.getCostoPorHora()*cantClases*duracionClases;
		
		if(this.prioritaria) {
			return costo*1.1;
		}
		return costo;
	}
	public Docente getDocente() {
		return profe;
	}

	@Override
	public void inscribir(Alumno a) throws CreditosInsuficientesException{
		
		if(a.creditosObtenidos()<this.creditosMinimos) throw new CreditosInsuficientesException();
		
	}
	
	@Override
	public void aprobar(Alumno a) {
		
	}
}
