import java.util.HashMap;
import java.util.Map;

public class nussinov {

	private String sequence;
	private int seqLength;
	private int[][] nussinovMatrix;
	Map<Integer, Integer> pary;

	public nussinov(String sequence) {
		this.sequence = sequence;
		seqLength = this.sequence.length();
		nussinovMatrix = new int[seqLength][seqLength];
		pary = new HashMap<Integer, Integer>();
		zeroMatrix();
		makeMatrix();
		checkPair(0, seqLength-1);
	}

	private int pairs(char a, char b) {

		if (a == 'A' && b == 'U')
			return 1;

		if (b == 'A' && a == 'U')
			return 1;

		if (a == 'G' && b == 'C')
			return 1;

		if (a == 'C' && b == 'G')
			return 1;

		return 0;

	}

	private void makeMatrix() {

		for (int i = 1; i < seqLength; i++) {

			for (int j = i; j < seqLength; j++) {

				int n = j - i;

				int case1 = nussinovMatrix[n + 1][j - 1]
						+ pairs(sequence.charAt(n), sequence.charAt(j));
				int case2 = nussinovMatrix[n + 1][j];
				int case3 = nussinovMatrix[n][j - 1];
				if (n + 3 <= j) {

					int tmp = 0;

					for (int k = n + 1; k < j; k++) {
						if ((nussinovMatrix[n][k] + nussinovMatrix[k + 1][j]) > tmp)
							tmp = nussinovMatrix[n][k]
									+ nussinovMatrix[k + 1][j];

						int first = Math.max(case1, case2);
						int second = Math.max(case3, tmp);
						nussinovMatrix[n][j] = Math.max(first, second);
					}
				} else {

					int third = Math.max(case1, case2);
					nussinovMatrix[n][j] = Math.max(third, case3);
				}

			}

		}

	}

	private void checkPair(int i, int j) {
		
		if (i<j){
			if (nussinovMatrix[i][j]==nussinovMatrix[i+1][j]) checkPair(i+1,j);
			else if (nussinovMatrix[i][j]==nussinovMatrix[i][j-1])	checkPair(i,j-1);
			else if (nussinovMatrix[i][j]==nussinovMatrix[i+1][j-1]+pairs(sequence.charAt(i),sequence.charAt(j))){
				pary.put(i,j);
				checkPair(i+1,j-1);
			}
		}
		else {
				for (int k=i+1;k<j;k++){
					if (nussinovMatrix[i][j]==nussinovMatrix[i][k]+nussinovMatrix[k+1][j]){
						checkPair(i,k);
						checkPair(k+1,j);
						break;
					}
				}
		}
		
	}

	private void zeroMatrix() {

		for (int i = 0; i < seqLength; i++) {
			for (int j = 0; j < seqLength; j++) {

				nussinovMatrix[i][j] = 0;
			}

		}

	}

	public int[][] getMatrix() {
		return nussinovMatrix;
	}

	public Map<Integer, Integer> getMap() {
		return pary;
	}

}
