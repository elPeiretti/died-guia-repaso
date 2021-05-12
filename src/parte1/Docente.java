package parte1;

public class Docente {

	private String nombre;
	private Integer antiguedad;
	
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	private Double costoPorHora;
}
