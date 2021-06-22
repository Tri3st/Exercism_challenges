import java.util.Arrays;
public class Bowling {
  private Frame[] frames = new Frame[10];
  private Frame extra;
  private Frame extra2;
  private int tScore;
  private int[] frameArr = new int[24];
  private int rollNr;
  
  public Bowling(){
    rollNr = 0;
  }
  
  public Bowling(String str){
    String st2 = str.replace("10", "10 0");
    String[] strArr = st2.split(" ");
    for(int i=0; i<strArr.length; i++){
      frameArr[i] = Integer.parseInt(strArr[i]);
    }
    initGame();
    calcScores();
  }

  public Bowling(int[] str){
    int i = 0;
    int j = 0;
    while (i < str.length){
      if (str[i]==10){
        frameArr[j] = str[i]; 
        j++;
        frameArr[j] = 0;
      } else frameArr[j] = str[i];
      j++;
      i++;
    }
    initGame();
    calcScores();
  }
  
  public void roll(int pins){
    if(pins==10){
      frameArr[rollNr] = pins;
      rollNr++;
      frameArr[rollNr] = 0;
    }else frameArr[rollNr] = pins;
    rollNr++;
  }
  
  public int score(){
    initGame();
    calcScores();
    return tScore;
  }
  
  private void initGame(){
    for(int i=0; i<10; i++){
      int thr1 = frameArr[i*2];
      int thr2 = frameArr[i*2+1];
      //strike
      if(thr1==10){
        if(i==9){
          
        } else 
        frames[i] = new Strike(thr1, 0);
      }
      //spare
      else if(thr1 + thr2 ==10){
        frames[i] = new Spare(thr1, thr2);
      }
      //normal
      else {
        frames[i]= new Frame(thr1, thr2);
      }
    }
  }
  
  private void calcScores(){
    for (int i=0; i<10;i++){
      if (frames[i] instanceof Strike){
        if (frames[i+1] instanceof Strike) {
          frames[i].setExtras(frames[i+1].getFirst(), frames[i+2].getFirst());
        } else 
        frames[i].setExtras(frames[i+1].getFirst(), frames[i+1].getSecond());
      } else if(frames[i] instanceof Spare){
        frames[i].setExtra1(frames[i+1].getFirst());
      } 
      tScore += frames[i].getScore();
    }
  }
  
  public String toString(){
    String t = "";
    for(int i=0; i<10;i++){
      t+= "" + (i+1) + "\n";
      if(frames[i] instanceof Strike)
      t += (Strike)frames[i] + "\n";
      else if(frames[i] instanceof Spare) 
      t+= (Spare)frames[i] + "\n";
      else t+= frames[i] + "\n";
    }
    t += "Total score : " + this.tScore +"\n";
    /*
    if(frame[10] instanceof Spare){
      
    } else if (frame[10] instanceof Strike){
      
    }
    */
    return t;
  }
}
