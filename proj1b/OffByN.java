public class OffByN implements CharacterComparator {
    int need = 0;
    public OffByN(int N){
       need = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == need||diff== -need) {
            return true;
        } else {
            return false;
        }

    }

}
