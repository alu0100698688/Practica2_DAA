package practica2_DiseñoyAnalisisAlgoritmos.algoritmos;

import java.util.ArrayList;

public class MergeSort {
	
	private int size;
	private ArrayList<Integer>vector;
	
	public MergeSort(int s, ArrayList<Integer> v){
		size = s;
		setVector(v);
	}
	
	public void ordenar(){
		ordenar(0,getSize()-1);
	}
	
	private void ordenar(int ini, int fin){
		
		int centro = 0;
		if(ini < fin){
			centro = (ini + fin) / 2;
			ordenar(ini, centro);
			ordenar(centro+1, fin);
			mezcla(ini,centro,fin);
		}
	}
	
	private void mezcla (int ini, int centro, int fin){
		
		int i, j, k;
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();
		//Como se usa ArrayList no es necesario redimensionar
		i = ini;
		j = centro + 1;
		k = ini;
		
		while((i <= centro) && (j <= fin)){
			if(getVector().get(i) < getVector().get(j)){
				auxiliar.set(k, getVector().get(i));
				i++;
			}else{
				auxiliar.set(k, getVector().get(j));
				j++;
			}
			k++;
		}
		
		if (i > centro){
			while (j <= fin){
				auxiliar.set(k, getVector().get(j));
				j++;
				k++;
			}
		}else{
			while (i <= centro){
				auxiliar.set(k, getVector().get(i));
				i++;
				k++;
			} 
		}
		
		for (k = ini; k <= fin; k++){
			getVector().set(k, auxiliar.get(k));
		}
		
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Integer> getVector() {
		return vector;
	}

	public void setVector(ArrayList<Integer> vector) {
		this.vector = new ArrayList<Integer>(); 
		for(int i=0;i<vector.size()-1;i++){
			this.vector.add(vector.get(i));
		}
	}
	
	

}
