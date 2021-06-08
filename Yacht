import java.util.Arrays;
class Yacht {
    private int[] yachtDice;
    private int score;
    private YachtCategory category;
    private int[] multis = {0, 0, 0, 0, 0, 0, 0};

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.category = yachtCategory;
        this.yachtDice = new int[5];
        for (int i = 0; i < dice.length; i++){
            yachtDice[i] = dice[i];
        }
        for(int x: yachtDice){
            multis[x]++;
        }
        Arrays.sort(yachtDice);
        calcScore();
    }

    int score() {
        return score;
    }

    private void calcScore(){
        int sum = 0;
        switch(category){
            case ONES:
                for (int x: yachtDice){
                    if (x == 1) sum += 1;
                }
                break;
            case TWOS:
                for (int x: yachtDice){
                    if (x == 2) sum += 2;
                }
                break;
            case THREES:
                for (int x: yachtDice){
                    if (x == 3) sum += 3;
                }
                break;
            case FOURS:
                for (int x: yachtDice){
                    if (x == 4) sum += 4;
                }
                break;
            case FIVES:
                for (int x: yachtDice){
                    if (x == 5) sum += 5;
                }
                break;
            case SIXES:
                for (int x: yachtDice){
                    if (x == 6) sum += 6;
                }
                break;
            case YACHT:
                if(multisContains(5)) sum = 50;
                break;
            case FULL_HOUSE:
                if(multisContains(3) && multisContains(2)) {
                    for(int x:yachtDice) sum+=x;
                }
                break;
            case LITTLE_STRAIGHT:
                int tempsum = 0;
                for(int i = 0; i < 4; i++){
                    if (yachtDice[i + 1] - yachtDice[i] ==  1) tempsum++;
                }
                if (tempsum == 4 && yachtDice[0] == 1) sum = 30;
                break;
            case BIG_STRAIGHT:
                int tempsum2 = 0;
                for(int i = 0; i < 4; i++){
                    if (yachtDice[i+1] - yachtDice[i] ==  1) tempsum2++;
                }
                if (tempsum2 == 4 && yachtDice[0] == 2) sum = 30;
                break;
            case CHOICE:
                for(int x: yachtDice){
                    sum += x;
                }
                break;
            case FOUR_OF_A_KIND:
                if(multisContains(4) || multisContains(5)) {
                    for(int p=0; p < 7; p++) if (multis[p] > 3)
                    sum += 4 * p;
                }
                break;

        }
        score = sum;
    }

    private boolean multisContains(int x){
        for(int s:this.multis) if (s==x) return true;
        return false;
    }
}
