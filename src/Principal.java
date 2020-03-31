
public class Principal {
	
	static Exception e = new Exception();

	static int[][] matrizSolucao;
	static int[] possiveisX = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] possiveisY = {1, 2, -2 ,-1, 1, 2, -2, -1};
	final static int tamanhoTabuleiro = 8;
	
	public Principal() {
		matrizSolucao = new int [tamanhoTabuleiro][tamanhoTabuleiro];
		IniciarTabuleiro(matrizSolucao);
		matrizSolucao[0][0] = 1;
	}
	
	private static void IniciarTabuleiro(int[][] matrizSolucao2) {
		for(int i = 0; i < possiveisX.length; i++) {
			for(int j = 0; j < possiveisY.length; j++) {
				matrizSolucao[i][j] = 0;
			}
		}		
	}
	
	public void Passeio() {
		if(Solucao(2,0,0)) {
			PrintSolucao();
		}else {
			System.out.println("Solucao nao encontrada");
		}
	}

	private static boolean Solucao(int movimento, int x, int y) {
		
		if(movimento == Math.pow(tamanhoTabuleiro, 2) + 1) {
			return true;
		}
		
		int proximoX = x;
		int proximoY = y;
				
		for(int i = 0; i < possiveisX.length; i++) {
			proximoX += possiveisX[i];
			proximoY += possiveisY[i];
			
			//System.out.println("Fora x = " + proximoX + "; y = " + proximoY);
			//e = new Exception();
			//e.printStackTrace();
			
			if(Validade(proximoX, proximoY)) {
				
				//System.out.println("Dentro x = " + proximoX + "; y = " + proximoY);
				
				matrizSolucao[proximoX][proximoY] = movimento;
				
				if(Solucao(movimento+1, proximoX, proximoY)) {
					return true;	
				}	
			}
			
			//e = new Exception();
			//e.printStackTrace();
			
			proximoX = x;
			proximoY = y;
			
		}
		
		matrizSolucao[proximoX][proximoY] = 0;
		
		//PrintSolucao();
		return false;
	}

	private static boolean Validade(int proximoX, int proximoY) {
		
		if(proximoX >= possiveisX.length || proximoX < 0) {
			return false;
		}else if(proximoY >= possiveisY.length || proximoY < 0) {
			return false;
		}else if(matrizSolucao[proximoX][proximoY] != 0) {
			return false;
		}else {		
			return true;
		}
	}

	private static void PrintSolucao() {
		for(int i = 0; i < tamanhoTabuleiro; i++) {
			for(int j = 0; j < tamanhoTabuleiro; j++) {
				if(matrizSolucao[i][j] < 10){
					System.out.print(matrizSolucao[i][j] + "  | ");
				}else {
					System.out.print(matrizSolucao[i][j] + " | ");
				}
			}
			System.out.println("");
			System.out.println("---------------------------------------");
		}
		
	}
}
