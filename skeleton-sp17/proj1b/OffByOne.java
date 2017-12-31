public class OffByOne implements CharacterComparator {


    @Override
    public boolean equalChars(char x, char y) {
        if ((x-y)*(x-y)==1){
            return true;
        }
        else{
            return false;
        }
    }

//    public static void main(String[] args) {
//        OffByOne obo = new OffByOne();
//        System.out.println(obo.equalChars('a', 'b'));
//    }
}
