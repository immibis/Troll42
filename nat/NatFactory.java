package nat;


public interface NatFactory {
	Nat getZero();
	Nat getOne();
	Nat getSix();
	
	Operation getOperation(String name) throws OperationNotFoundException;
}
