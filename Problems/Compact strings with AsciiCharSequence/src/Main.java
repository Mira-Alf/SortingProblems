import java.util.Arrays;

class AsciiCharSequence implements CharSequence {

    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes == null ? 0 : bytes.length;
    }

    @Override
    public char charAt(int index) {
        if( index >= 0 && index < bytes.length )
            return (char)bytes[index];
        return '\u0000';
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] newBytes = Arrays.copyOfRange(bytes, start, end);
        return new AsciiCharSequence(newBytes);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if( bytes != null ) {
            for (int i = 0; i < bytes.length; i++) {
                builder.append((char) bytes[i]);
            }
        }
        return new String(builder);
    }
}