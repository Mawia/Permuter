package org.git.permuter.core;

import java.util.List;

import org.git.permuter.artifacts.Permutable;

public interface IPermuteEngine<T> {
	public List<Permutable<T>> nextPermute();
	public boolean isNextPermute();
}
