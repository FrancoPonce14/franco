package modelo;

public class num {
	private double intervaloX;
	private double intervaloY;
	private int frecuenciaSimple;
	
	public num(double intervaloX, double intervaloY, int frecuenciaSimple) {
		super();
		this.intervaloX = intervaloX;
		this.intervaloY = intervaloY;
		this.frecuenciaSimple = frecuenciaSimple;
	}


	@Override
	public String toString() {
		return "num [intervaloX=" + intervaloX + ", intervaloY=" + intervaloY + ", frecuenciaSimple=" + frecuenciaSimple
				+ "]";
	}


	public double getIntervaloX() {
		return intervaloX;
	}

	public void setIntervaloX(double intervaloX) {
		this.intervaloX = intervaloX;
	}

	public double getIntervaloY() {
		return intervaloY;
	}

	public void setIntervaloY(double intervaloY) {
		this.intervaloY = intervaloY;
	}

	public int getFrecuenciaSimple() {
		return frecuenciaSimple;
	}

	public void setFrecuenciaSimple(int frecuenciaSimple) {
		this.frecuenciaSimple = frecuenciaSimple;
	}
	
	

}
