package nat.impl;

import nat.Nat;

public class ZeroImpl implements Nat {
	private NatFactoryImpl factory;
	
	public ZeroImpl(NatFactoryImpl factory) {
		this.factory = factory;
	}
	
	@Override
	public Nat successor() {
		return factory.getOne();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ZeroImpl) && ((ZeroImpl)obj).factory == factory;
	}
	
	@Override
	public int hashCode() {
		return 43;
	}
	
	@Override
	public String toString() {
		return "0";
	}
}
