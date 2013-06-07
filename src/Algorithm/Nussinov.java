package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Nussinov {

	private String sequence;
	private int seqLength;
	private int[][] nussinovMatrix;
	Map<Integer, Integer> pary;
	public int AA, AC, AG, AU, CC, CG, GG, CU, GU, UU;

	public Nussinov(String sequence, int[] eParams) {
		this.AA = eParams[0];
		this.AC = eParams[1];
		this.AG = eParams[2];
		this.AU = eParams[3];
		this.CC = eParams[4];
		this.CG = eParams[5];
		this.CU = eParams[6];
		this.GG = eParams[7];
		this.GU = eParams[8];
		this.UU = eParams[9];

		this.sequence = sequence;
		seqLength = this.sequence.length();
		nussinovMatrix = new int[seqLength][seqLength];
		pary = new HashMap<Integer, Integer>();
		zeroMatrix();
		makeMatrix();
		checkPair(0, seqLength - 1);
	}

	public int getSeqLength() {
		return seqLength;
	}

	private int pairs(char a, char b) {
		switch (a) {
		case ('A'):
			return checkA(b);
		case ('C'):
			return checkC(b);
		case ('G'):
			return checkG(b);
		case ('U'):
			return checkU(b);
		}
		return 0;
	}

	private int checkA(char b) {
		switch (b) {
		case ('A'):
			return AA;
		case ('C'):
			return AC;
		case ('G'):
			return AG;
		case ('U'):
			return AU;
		}
		return 0;
	}

	private int checkC(char b) {
		switch (b) {
		case ('A'):
			return AC;
		case ('C'):
			return CC;
		case ('G'):
			return CG;
		case ('U'):
			return CU;
		}
		return 0;
	}

	private int checkG(char b) {
		switch (b) {
		case ('A'):
			return AG;
		case ('C'):
			return CG;
		case ('G'):
			return GG;
		case ('U'):
			return GU;
		}
		return 0;
	}

	private int checkU(char b) {
		switch (b) {
		case ('A'):
			return AU;
		case ('C'):
			return CU;
		case ('G'):
			return GU;
		case ('U'):
			return UU;
		}
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

		if (i < j) {
			if (nussinovMatrix[i][j] == nussinovMatrix[i + 1][j])
				checkPair(i + 1, j);
			else if (nussinovMatrix[i][j] == nussinovMatrix[i][j - 1])
				checkPair(i, j - 1);
			else if (nussinovMatrix[i][j] == nussinovMatrix[i + 1][j - 1]
					+ pairs(sequence.charAt(i), sequence.charAt(j))) {
				pary.put(i, j);
				checkPair(i + 1, j - 1);
			}
		} else {
			for (int k = i + 1; k < j; k++) {
				if (nussinovMatrix[i][j] == nussinovMatrix[i][k]
						+ nussinovMatrix[k + 1][j]) {
					checkPair(i, k);
					checkPair(k + 1, j);
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

	public void printMatrix(int[][] m) {
		try {
			int rows = m.length;
			int columns = m[0].length;
			String str = "|\t";

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					str += m[i][j] + "\t";
				}

				System.out.println(str + "|");
				str = "|\t";
			}

		} catch (Exception e) {
			System.out.println("Matrix is empty!!");
		}
	}

	public String getMatrixAsText(int[][] m) {
		String matrixString = "";
		try {
			int rows = m.length;
			int columns = m[0].length;
			String str = "\t|";

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					int entryLength = String.valueOf(m[i][j]).trim().length();
					if (entryLength == 1)
						str += m[i][j] + "    ";
					else {
						str += m[i][j] + "  ";
					}
				}
				matrixString += str + "|" + "\n";
				str = "\t|";
			}

		} catch (Exception e) {
			return "Matrix is empty!!";
		}
		return matrixString;
	}

}
