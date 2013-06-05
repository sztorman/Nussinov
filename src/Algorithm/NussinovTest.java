package Algorithm;
import static org.junit.Assert.*;

import org.junit.Test;


public class NussinovTest {

	@Test
	public void test() {
		Nussinov nussinov = new Nussinov("GCCGCGGGCCGAAAAAACCCCCGGCCCGCGGC");
		assertEquals(34, nussinov.getSeqLength());
		System.out.println(nussinov.getMap());
		@SuppressWarnings("unused")
		int[][] matrix = nussinov.getMatrix();
//		nussinov.printMatrix(matrix);
		System.out.println(nussinov.getMatrixAsText(matrix));
	}

}
