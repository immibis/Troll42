package nat.impl;

import nat.Nat;

public class SixImpl implements Nat {
	private NatFactoryImpl factory;
	
	public SixImpl(NatFactoryImpl factory) {
		this.factory = factory;
	}
	
	@Override
	public Nat successor() {
		return new OtherNatImpl(factory, this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof SixImpl) && ((SixImpl)obj).factory == factory;
	}
	
	@Override
	public int hashCode() {
		return 43;
	}
	
	@Override
	public String toString() {
		return "6";
	}
}
