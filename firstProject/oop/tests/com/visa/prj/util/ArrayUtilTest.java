package com.visa.prj.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data= {5,6,4};
		assertEquals(15,ArrayUtil.getSum(data));
		
		int[] elems= {-1,0,1};
		assertEquals(0,ArrayUtil.getSum(elems));
	}

	@Test
	public void testGetCount() {
		int[] elems= {1,1,2,3,4,1,2};
		assertEquals(3,ArrayUtil.getCount(elems, 1));
}

	@Test
	public void testSort() {
		int[] elems= {3,5,6,7,1,2,3,4};
		int[] exp= {1,2,3,3,4,5,6,7};
		ArrayUtil.sort(elems);
		assertArrayEquals(exp,elems);
	}

}
