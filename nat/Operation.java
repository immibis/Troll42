package nat;

public interface Operation {
	UnaryOperation asUnaryOperation() throws WrongArityException;
	BinaryOperation asBinaryOperation() throws WrongArityException;
	SeptenaryOperation asSeptenaryOperation() throws WrongArityException;
}
