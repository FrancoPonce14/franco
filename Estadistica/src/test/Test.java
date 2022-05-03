package test;

import java.text.DecimalFormat;

import modelo.abmNum;

public class Test {

	public static void main(String[] args) {
		
		abmNum intervalo = new abmNum();
		
		intervalo.agregarIntervalo(12.1, 12.6, 9);
		intervalo.agregarIntervalo(12.6, 13.1, 7);
		intervalo.agregarIntervalo(13.1, 13.6, 6);
		intervalo.agregarIntervalo(13.6, 14.1, 3); 
		
		

		intervalo.mostrarTabla();
		/*int n = 3;
		while (n !=  1) {
			System.out.println(n);
			if(n % 2 == 0) {
				n/=2;
			}else {
				n = (n*3)+1;
			}
			
		}
		System.out.println(n);*/
		
		//calcularIntervalo();
		

	}
	//POR SI DA NUMEROS Y HAY QUE CALCULAR EL INTERVALO 
	public static void calcularIntervalo() {
		//-------------------------------------------------------------------------------------------------------------------------------
		//CALCULAR INTERVALO A PARTIR DE NUMEROS
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		double numero[] = {102,123,115.4,111.3,176.2,116.1,121.2,121,131,121.4,128.4,178,124.1,112.2,107.8,114.8,105.8,113.9,178,109.3,117.2,128.8,119.3,113.3,121.8,177.4,110.2,116,105.1,104.2,99.1};
		double rango = 0, xMax = 0, xMin = 0;
		for (int i = 0; i < numero.length; i++) {
			if (numero[i] > xMax) {
				xMax = numero[i];
			}
		}
		xMin = xMax;
		for(int i = 0; i < numero.length; i++) {
			if (numero[i] < xMin) {
				xMin = numero[i];
			}
		}
		rango = xMax - xMin;
		System.out.println(xMax+"y"+xMin);
		double numIntervalos=1+3.322*Math.log10(numero.length);
		double amplitud = rango / Math.floor(4);
		System.out.println("Amplitud: "+ amplitud);
		System.out.println("rango " +rango);
		System.out.println("NumIntervalos: "+numIntervalos);
		double aux=0;
			for(int i=0;i<Math.floor(4);i++) {
				aux=xMin+amplitud;
				System.out.println(df.format(xMin)+" - "+df.format(aux));
				xMin = xMin + amplitud;
			}
	}
}
