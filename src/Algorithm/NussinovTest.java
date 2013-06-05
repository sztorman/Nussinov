package Algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class NussinovTest {

	@Test
	public void test1() {
		Nussinov nussinov = new Nussinov("GCCGCGGGCCGAAAAAACCCCCGGCCCGCGGC");

		// sprawdzenie czy dlugosc inputa jest poprawna
		assertEquals(32, nussinov.getSeqLength());

		// sprawdzenie czy macierz nie jest nullem
		assertNotNull(nussinov.getMatrix());
	}
	@Test
	public void test2() {
		Nussinov nussinov = new Nussinov("GCACGACG");

		// sprawdzenie czy dlugosc inputa jest poprawna
		assertEquals(8, nussinov.getSeqLength());

		// sprawdzenie czy macierz nie jest nullem
		assertNotNull(nussinov.getMatrix());

		int[][] referenceMatrix = new int[][] { { 0, 1, 1, 1, 2, 2, 2, 3 },
				{ 0, 0, 0, 0, 1, 1, 1, 2 }, { 0, 0, 0, 0, 1, 1, 1, 2 },
				{ 0, 0, 0, 0, 1, 1, 1, 2 }, { 0, 0, 0, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		assertArrayEquals(nussinov.getMatrix(), referenceMatrix);
	}

}
