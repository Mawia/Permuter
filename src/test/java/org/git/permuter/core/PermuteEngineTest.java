package org.git.permuter.core;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.git.permuter.artifacts.Permutable;
import org.git.permuter.artifacts.TestPermutable;
import org.junit.Test;

public class PermuteEngineTest {

	@Test
	public void testBasicCase()
	{
		List<Permutable<Integer>> deck=new LinkedList<>();
		Permutable<Integer> permutable=new TestPermutable(1,2);
		deck.add(permutable);
		IPermuteEngine<Integer> permuteEngine=new PermuteEngine<>(deck);
		
		assertTrue(permutable.getCurrentValue()==1);
		
		assertTrue(permuteEngine.isNextPermute());
		permuteEngine.nextPermute();
		assertTrue(permutable.getCurrentValue()==2);
		
		assertTrue(permuteEngine.isNextPermute());
		permuteEngine.nextPermute();
		assertFalse(permuteEngine.isNextPermute());
	}
	
	@Test
	public void testPermute1()
	{
		List<Permutable<Integer>> deck=new LinkedList<>();
		Permutable<Integer> permutable=new TestPermutable(1,2);
		deck.add(permutable);
		IPermuteEngine<Integer> permuteEngine=new PermuteEngine<>(deck);
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable.getCurrentValue()==1);
		permuteEngine.nextPermute();
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable.getCurrentValue()==2);
		permuteEngine.nextPermute();
		assertFalse(permuteEngine.isNextPermute());
	}
	
	@Test
	public void testPermute2()
	{
		List<Permutable<Integer>> deck=new LinkedList<>();
		Permutable<Integer> permutable1=new TestPermutable(1,2);
		Permutable<Integer> permutable2=new TestPermutable(1,2);
		deck.add(permutable1);
		deck.add(permutable2);
		IPermuteEngine<Integer> permuteEngine=new PermuteEngine<>(deck);
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==1);
		assertTrue(permutable2.getCurrentValue()==1);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==1);
		assertTrue(permutable2.getCurrentValue()==2);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==2);
		assertTrue(permutable2.getCurrentValue()==1);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==2);
		assertTrue(permutable2.getCurrentValue()==2);
		permuteEngine.nextPermute();
	
		assertFalse(permuteEngine.isNextPermute());
	
	}
	
	@Test
	public void testPermute3()
	{
		List<Permutable<Integer>> deck=new LinkedList<>();
		Permutable<Integer> permutable1=new TestPermutable(1,2);
		Permutable<Integer> permutable2=new TestPermutable(1,2);
		deck.add(permutable1);
		deck.add(permutable2);
		IPermuteEngine<Integer> permuteEngine=new PermuteEngine<>(deck);
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==1);
		assertTrue(permutable2.getCurrentValue()==1);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==1);
		assertTrue(permutable2.getCurrentValue()==2);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==2);
		assertTrue(permutable2.getCurrentValue()==1);
		permuteEngine.nextPermute();
		
		assertTrue(permuteEngine.isNextPermute());
		assertTrue(permutable1.getCurrentValue()==2);
		assertTrue(permutable2.getCurrentValue()==2);
		permuteEngine.nextPermute();
	
		assertFalse(permuteEngine.isNextPermute());
	
		assertTrue(permutable1.getCurrentValue()==2);
		assertTrue(permutable2.getCurrentValue()==2);
	
	}
}
