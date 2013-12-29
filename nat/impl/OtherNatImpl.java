package nat.impl;

import nat.Nat;

public class OtherNatImpl implements Nat {

	private NatFactoryImpl factory;
	private Nat predecessor;
	
	/**
	 * Precondition: 'factory' produced 'predecessor'
	 */
	public OtherNatImpl(NatFactoryImpl factory, Nat predecessor) {
		this.factory = factory;
		this.predecessor = predecessor;
		
		assert !(predecessor instanceof ZeroImpl);
		assert !isFive(predecessor);
	}
	
	private static boolean isFive(Nat n) {
		return n instanceof OtherNatImpl
			&& ((OtherNatImpl)n).predecessor instanceof OtherNatImpl
			&& ((OtherNatImpl)((OtherNatImpl)n).predecessor).predecessor instanceof OtherNatImpl
			&& ((OtherNatImpl)((OtherNatImpl)((OtherNatImpl)n).predecessor).predecessor).predecessor instanceof OtherNatImpl
			&& ((OtherNatImpl)((OtherNatImpl)((OtherNatImpl)((OtherNatImpl)n).predecessor).predecessor).predecessor).predecessor instanceof OneImpl;
	}

	@Override
	public Nat successor() {
		if(isFive(this))
			return factory.getSix();
		else
			return new OtherNatImpl(factory, this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof OtherNatImpl) && ((OtherNatImpl)obj).factory == factory && ((OtherNatImpl)obj).predecessor.equals(predecessor);
	}
	
	@Override
	public int hashCode() {
		return 43;
	}
	
	@Override
	public String toString() {
		return predecessor+"+1";
	}

}
