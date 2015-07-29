package org.git.permuter.artifacts;

public interface Permutable<T> {
	public boolean isNext();
	public T next();
	public void reset();
	public T getCurrentValue();
}
