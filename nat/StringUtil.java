package nat;

public class StringUtil {

    public static char charAt(NatFactory factory, String str, Nat index) throws IndexOutOfBoundsException {
        char[] chars = str.toCharArray();
        Nat k = factory.getZero();
        for (char c : chars) {
            if (index.equals(k))
                return c;
            k = k.successor();
        }
        throw new IndexOutOfBoundsException();
    }
    
    public static Nat strLength(NatFactory factory, String str) {
        char[] chars = str.toCharArray();
        Nat k = factory.getZero();
        for (char c : chars)
            k = k.successor();
        return k;
    }
    
}
