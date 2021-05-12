package parte1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Empleado {

	private List<Capacitacion> capacitaciones;
	
	public Integer obtenerCreditos() {
		
		
		return capacitaciones.stream()
				.map(c->c.calcularCreditos())
				.collect(Collectors.summingInt(Integer::intValue));
		
		
	}
	
	public Double calcularCostoCapacitaciones() {
		return capacitaciones.stream()
				.map(c->c.calcularCosto())
				.collect(Collectors.summingDouble(Double::doubleValue));
	}
	
	
	public List<Capacitacion>getCapacitacionesPorCriterio(Comparator<Capacitacion> comp){
		return this.capacitaciones.stream().sorted(comp).collect(Collectors.toList());
	}
	
	public Double costoPromedioCapacitaciones() {
		return this.calcularCostoCapacitaciones()/this.capacitaciones.size();
	}
	
	public List<Capacitacion> getCapacitacionesPorTema(Tema tema){
		Comparator<Capacitacion> comp = (a,b)->(-1*a.calcularCosto().compareTo(b.calcularCosto()));
		return this.getCapacitacionesPorCriterio(comp).stream()
				.filter(c -> c.getTema().equals(tema))
				.collect(Collectors.toList());
	}
	
	public Docente getDocenteDelCursoConMasCreditos() throws NoExistenCursosRegistradosException {
		Comparator<Capacitacion> comp = (a,b) -> (a.getCreditosMinimos().compareTo(b.getCreditosMinimos()));
		Curso aux = (Curso) this.capacitaciones.stream().max(comp).orElse(new Curso());
		if(aux.getDocente()==null) throw new NoExistenCursosRegistradosException();
		else return aux.getDocente();
	}
	
	public List<Capacitacion> getCapacitacionesPrioritarias(){
		return this.capacitaciones.stream().filter(t-> t.prioritaria).collect(Collectors.toList());
	}
	public List<Capacitacion> getCapacitacionesPorCreditos(){
		Comparator<Capacitacion> comp = (a,b)->(-1*a.calcularCreditos().compareTo(b.calcularCreditos()));
		return this.getCapacitacionesPorCriterio(comp);
	}
}
