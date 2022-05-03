package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;	
import java.util.List;

public class abmNum {
	List<num> lstNum = new ArrayList<num>();

	public List<num> getLstNum() {
		return lstNum;
	}

	public void setLstNum(List<num> lstNum) {
		this.lstNum = lstNum;
	}
	
	public boolean agregarIntervalo(double intervaloX, double intervaloY, int frecuenciaSimple) {
		num agregar = new num(intervaloX, intervaloY, frecuenciaSimple);
		return lstNum.add(agregar);
	}

	public void mostrarTabla() {
		 //ESTE CODIGO SE HIZO RAPIDO POR ENDE SE IGNORO TODO TIPI DE PATRON O MEJORA DE CODIGO, ESTA HECHO PARA USO RAPIDO
		 //SE RECOMIENDA DISCRECION AL MIRAR EL CODIG Y LOS RESULTADOS ARROJAN "RESULTADOS" APROXIMADOS
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		double xi[] = {0,0,0,0,0,0,0,0,0,0}; 
		double xfi[] = {0,0,0,0,0,0,0,0,0,0}; 
		double xMenosxCuadrado[] = {0,0,0,0,0,0,0,0,0,0};
		double fri[] = {0,0,0,0,0,0,0,0,0,0}; 
		double Fri[] = {0,0,0,0,0,0,0,0,0,0}; 
		int Fi[] = {0,0,0,0,0,0,0,0,0,0};
		int FiAux = 0;
		double TotalCasos=0,sumaXfi=0;
		num aux = null;
		System.out.println(" Intervalo --------- xi --------- fi --------- fri ---------  Fi --------- Fri --------- xfi ");
		for(int i=0;i<lstNum.size();i++) {
			aux = lstNum.get(i);
			xi[i] = (aux.getIntervaloX()+aux.getIntervaloY())/2;
			FiAux = FiAux + aux.getFrecuenciaSimple();
			Fi[i] = FiAux;
			xfi[i] = xi[i] * aux.getFrecuenciaSimple();
			TotalCasos = Fi[lstNum.size()-1];
			sumaXfi += xfi[i];
			
		}
		for(int i=0;i<lstNum.size();i++) {
			aux = lstNum.get(i);
			fri[i] = aux.getFrecuenciaSimple() / TotalCasos; //TOTAL DE CASOS
			Fri[i] = Fi[i] / TotalCasos; //TOTAL DE CASOS
			System.out.println(" "+aux.getIntervaloX()+" - "+aux.getIntervaloY()+"|        "+df.format(xi[i])+"|          "+aux.getFrecuenciaSimple()+"|           "+df.format(fri[i])+"|           "+Fi[i]+"|           "+df.format(Fri[i])+"|           "+df.format(xfi[i]));
		}
		
		
		//Media = SUMATORIA XFI / TOTAL DE CASOS -------------------------------------------------------------------------------------------
		double mediaAritmetica = sumaXfi / TotalCasos;;
		System.out.println("\nMEDIA ARITMETICA: "+mediaAritmetica);
		//MEDIANA  = LIMITE INFERIOR + AMPLITUD ( POSICION - fi-1 / fi) -----------------------------------------------------------------------
		double posicion = TotalCasos/2; //EL TOTAL DE CASOS ENTRE 2 
		double aBuscar = 0;
		int FrecuenciaAnterior = 0;
		for(int i=0;i<lstNum.size();i++) {
			if(Fi[i] == posicion) {
				aBuscar = posicion;
			}else if(Fi[i] > posicion){
				aBuscar = Fi[i];
				FrecuenciaAnterior = Fi[i-1];
				break;
			}
		}
		double mediana = 0;
		for(int i=0;i<lstNum.size();i++) {
			aux = lstNum.get(i);
			if (Fi[i] == aBuscar) {
				mediana = aux.getIntervaloX() + ((aux.getIntervaloY() - aux.getIntervaloX())*(posicion-FrecuenciaAnterior)/aux.getFrecuenciaSimple());
				System.out.println("Mediana: "+mediana);
				System.out.println("Mediana = "+aux.getIntervaloX()+" + "+(aux.getIntervaloY() - aux.getIntervaloX())+" * ( ("+posicion+"-"+FrecuenciaAnterior+") / "+aux.getFrecuenciaSimple()+" )" );
			}
		}
		System.out.println("\n");
		//MODA = --------------------------------------------------------------------------------------------------------------------------------------------
		int numModa = 0;
		for(int i=0;i<lstNum.size();i++) { // BUSCAMOS EL INTERVALO DE LA MODA 
			aux = lstNum.get(i);
			if(aux.getFrecuenciaSimple() > numModa) {
				numModa = aux.getFrecuenciaSimple();
			}
		}
		num auxModa = null;
		double moda =0;
		int auxModaAnt=0;
		int auxModaPos=0;
		num modaAnterior = null; 
		num modaPosterior = null; 
		double amplitud = 0;
		for(int i=0;i<lstNum.size();i++) {
			auxModa = lstNum.get(i);
			if(auxModa.getFrecuenciaSimple() == numModa) {
				if(i == 0 ) {
					auxModaAnt=0; //ESTO LO HAGO PARA QUE NO SE ROMPA AL NO ENCONTRAR LA POSICION -1 QUE NO EXISTE 
				}else {
					modaAnterior = lstNum.get(i-1);	//ASI ME ASEGURO QUE NUNCA SE VA A ROMPER 
					auxModaAnt = modaAnterior.getFrecuenciaSimple();
				}
					if(i == lstNum.size()) {
						auxModaPos = 0;//LO MISMO QUE ARRIBA POR SI LLEGA A ENCONTRAR LA MODA EN LA ULTIMA POSICION SE VA A ROMPER PORQUE NO EXISTE ULTIMA +1
					}else {            //POR ESO LE ASIGNO 0 PARA QUE NO SE ROMPA
						modaPosterior = lstNum.get(i+1);
						auxModaPos = modaPosterior.getFrecuenciaSimple();
					}
	
				 amplitud = (auxModa.getIntervaloY() - auxModa.getIntervaloX());
				 moda = auxModa.getIntervaloX() + (amplitud*(auxModa.getFrecuenciaSimple() - auxModaAnt)/((auxModa.getFrecuenciaSimple()-auxModaAnt)+auxModa.getFrecuenciaSimple()-auxModaPos));
				 System.out.println("Moda: "+moda);
				 System.out.println("Moda = "+auxModa.getIntervaloX()+" + "+amplitud+" * ( ("+auxModa.getFrecuenciaSimple()+" - "+auxModaAnt+") / ("+auxModa.getFrecuenciaSimple()+" - "+auxModaAnt+") + ("+auxModa.getFrecuenciaSimple()+" - "+modaPosterior.getFrecuenciaSimple()+") )");
				 
			}
		}
		System.out.println("\n");
		double totalVarianza = 0;
		//VARIANZA = -------------------------------------------------------------------------------------------------------------------------------------------------------
		for(int i=0;i<lstNum.size();i++) {
			aux = lstNum.get(i);
			xMenosxCuadrado[i] = (Math.pow(xi[i]-mediaAritmetica, 2))*aux.getFrecuenciaSimple();
			totalVarianza = totalVarianza + xMenosxCuadrado[i];
		}
		double sCuadrado = (totalVarianza / (TotalCasos-1));
		System.out.println("Varianza: "+sCuadrado);
		System.out.println("Variana = s^2 = "+totalVarianza+" / "+TotalCasos);
		//DESVIACION ESTANDAR----------------------------------------------------------------------------------------------------------------------------------------------
		double desviacionEstandar = Math.sqrt(sCuadrado);
		System.out.println("\nDesvio estandar: "+desviacionEstandar);
		System.out.println("Desvio estandar = Raiz( "+sCuadrado+" )");
		//COEFICIENTE DE VARIACION------------------------------------------------------------------------------------------------------------------------------------------
		double coefVariacion = ((desviacionEstandar / mediaAritmetica)*100); //AGREGAR EL *100 O SACAR 
		System.out.println("\nCoeficiente de variacion: "+coefVariacion);
		System.out.println("Coef Variacion = "+desviacionEstandar+" / "+mediaAritmetica+" * 100");
		
	}
}
