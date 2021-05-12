package parte1;

import parte2.*;

public class Taller extends Capacitacion{
	
	private Integer cupoMaximo;
	private Integer duracion;
	private Double costoPorHora;
	private Integer cantInscriptos;
	
	
	public Taller() {
		this.creditosMinimos=0;
	}
	@Override
	public Integer calcularCreditos() {
		if(this.prioritaria) return Math.min(duracion/6,12)+1;
		return Math.min(duracion/6,12);
	}

	@Override
	public Double calcularCosto() {
		Double costo = this.costoPorHora*this.duracion;
		if(this.prioritaria) return costo*0.2+costo;
		return costo;
	}
	
	@Override
	public void inscribir(Alumno a) throws TallerCompletoException{
		
		if(cupoMaximo.equals(cantInscriptos)) throw new TallerCompletoException();
		
		cantInscriptos++;
		
	}
	
	@Override
	public void aprobar(Alumno a) {
		cantInscriptos--;
	}
	
}
