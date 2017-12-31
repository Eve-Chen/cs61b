public class OffByN implements CharacterComparator {
    public int difference;

    public OffByN(int N) {
        difference= N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if ((x-y)*(x-y)==difference*difference){
            return true;
        }
        else{
            return false;
        }
    }

//    public static void main(String[] args) {
//    OffByN obo = new OffByN(5);
//    System.out.println(obo.equalChars('f', 'a'));
//    }

}
