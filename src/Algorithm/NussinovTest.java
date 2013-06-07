package Algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NussinovTest {
	int[] eParams1 = new int[10];
	int[] eParams2 = new int[10];

	@Before
	public void setUp() {
		eParams1[0] = 0;
		eParams1[1] = 0;
		eParams1[2] = 0;
		eParams1[3] = 1;
		eParams1[4] = 0;
		eParams1[5] = 1;
		eParams1[6] = 0;
		eParams1[7] = 0;
		eParams1[8] = 0;
		eParams1[9] = 0;

		eParams2[0] = 0;
		eParams2[1] = 0;
		eParams2[2] = 0;
		eParams2[3] = 2;
		eParams2[4] = 0;
		eParams2[5] = 3;
		eParams2[6] = 0;
		eParams2[7] = 0;
		eParams2[8] = 1;
		eParams2[9] = 0;
	}

	@Test
	public void test1() {

		Nussinov nussinov = new Nussinov("GCCGCGGGCCGAAAAAACCCCCGGCCCGCGGC",
				eParams1);

		// sprawdzenie czy dlugosc inputa jest poprawna
		assertEquals(32, nussinov.getSeqLength());

		// sprawdzenie czy macierz nie jest nullem
		assertNotNull(nussinov.getMatrix());
	}

	@Test
	public void test2() {
		Nussinov nussinov = new Nussinov("GCACGACG", eParams1);

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

	@Test
	public void test3() {
		Nussinov nussinov = new Nussinov("GGGAAAUCC", eParams1);

		// sprawdzenie czy dlugosc inputa jest poprawna
		assertEquals(9, nussinov.getSeqLength());

		// sprawdzenie czy macierz nie jest nullem
		assertNotNull(nussinov.getMatrix());

		// sprawdzanie czy mapa nie jest nullem
		assertNotNull(nussinov.getMap());
	}

	@Test
	public void test4() {
		Nussinov nussinov = new Nussinov("CCCAAAAGGG", eParams2);

		// sprawdzenie czy dlugosc inputa jest poprawna
		assertEquals(10, nussinov.getSeqLength());

		// sprawdzenie czy macierz nie jest nullem
		assertNotNull(nussinov.getMatrix());

		// sprawdzanie czy mapa nie jest nullem
		assertNotNull(nussinov.getMap());

		nussinov.printMatrix(nussinov.getMatrix());
		int[][] referenceMatrix = new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0, 3, 6, 9 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 6, 6 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 3, 3 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		assertArrayEquals(nussinov.getMatrix(), referenceMatrix);

	}
}
