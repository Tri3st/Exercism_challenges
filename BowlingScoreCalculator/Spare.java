public class Spare extends Frame {
  private int extra1;
  
  public Spare(int first, int second){
    super(first, second);
  }
  
  public void setExtra1(int extra1){
    this.extra1 = extra1;
  }
  
  public int getScore(){
    return super.getScore() + this.extra1;
  }
  
  @Override
  public String toString(){
    String t="";
    t += "+---+---+\n";
    t += String.format("| %d | %s |%d %n",super.first, "/", this.getScore());
    t+= "+---+---+\n";
    return t;
  }
}
