package org.git.permuter.artifacts;

public class TestPermutable implements Permutable<Integer>{

	private int currentValue;
	private int startValue;;
	private int maxValue;
	
	public TestPermutable(int startValue, int maxValue)
	{
		this.startValue=this.currentValue=startValue;
		this.maxValue=maxValue;
	}
	
	@Override
	public boolean isNext() {
		if(currentValue<maxValue)
			return true;
		return false;
	}

	@Override
	public Integer next() {
		return currentValue++;
	}

	@Override
	public void reset() {
		currentValue=startValue;
	}

	@Override
	public Integer getCurrentValue() {
		return currentValue;
	}

}
