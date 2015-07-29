package org.git.permuter.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.git.permuter.artifacts.Permutable;

public class PermuteEngine<T> implements IPermuteEngine<T>{

	private List<Permutable<T>> orignalDeck;
	private Stack<Permutable<T>> processingStack;
	private Stack<Permutable<T>> tempHolderStack;
	private Permutable<T> currentElement;
	private boolean isNextAvailable=true;
	PermuteEngine(List<Permutable<T>> deck)
	{
		processingStack=new Stack<>();
		tempHolderStack=new Stack<>();
		orignalDeck=new LinkedList<Permutable<T>>();
		init(deck);
	}

	private void init(List<Permutable<T>> deck) {
		for(Permutable<T> permutable:deck)
		{
			Permutable<T> permutableCopy=permutable;//permutable.clone();
			orignalDeck.add(permutableCopy);
			processingStack.push(permutableCopy);
		}
		currentElement=processingStack.pop();
		tempHolderStack.push(currentElement);
	}

	@Override
	public List<Permutable<T>> nextPermute() {
		isNextAvailable=false;
		permuteNext();
		List<Permutable<T>> deckCopy=orignalDeck;//orignalDeck.clone();
		return deckCopy;
	}

	@Override
	public boolean isNextPermute() {
		return isNextAvailable;
	}
	
	private void permuteNext()
	{
		if(currentElement.isNext())
		{
			currentElement.next();
			isNextAvailable=true;
			return;
		}
		
		Permutable<T> nextElement=currentElement;
		while(!nextElement.isNext()&&!processingStack.isEmpty())
		{
			nextElement=processingStack.pop();
			tempHolderStack.push(nextElement);
		}
		
		if(nextElement.isNext())
		{
			nextElement.next();
			isNextAvailable=true;
			tempHolderStack.pop();
			resetDeck();
		}
	}

	private void resetDeck() {
		Permutable<T> element=null;
		while(!tempHolderStack.isEmpty())
		{
			element=tempHolderStack.pop();
			element.reset();
		}
		currentElement=element;
		tempHolderStack.push(element);
	}
}
