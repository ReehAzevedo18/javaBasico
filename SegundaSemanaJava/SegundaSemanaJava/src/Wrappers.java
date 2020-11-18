public class Wrappers {
    public static void main(String[] args) throws Exception {
        
        int i = 1;
        Integer wrapperInt = new Integer(2);
        float f = 3.4f;
        Float wrapperFloat = Float.valueOf(3);
        char c = 'c';
        Character wrapperChar = Character.valueOf(c);
        byte b = 32;
        Byte wrapperByte = Byte.valueOf(b);
        long l = 34433L;
        Long wrapperLong = Long.valueOf(l);
        short s = 12;
        Short wrappeShort = Short.valueOf(s);
        double d = 12.3;
        Double wrapperDouble = Double.valueOf(d);
        boolean bol = false;
        Boolean wrapperBoolean = Boolean.valueOf(bol);
        
    }
}
