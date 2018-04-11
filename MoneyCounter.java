public class MoneyCounter {
  private int total = 0;
  
  public MoneyCounter(int initital) {
    total = initital;
  }
  
  public MoneyCounter() { this(0); }
  
  public int getTotal() {
    return total;
  }

  public void add(Bill bill, int count) {
    int billValue = bill.getValue();
    int valueToAdd = billValue * count;
    
    total += valueToAdd;
    System.out.println("Adding " + count + " of $" + bill.getValue() + " bills ($" + valueToAdd + " total)");
  }
  
  public void subtract(Bill bill, int count) {
    int billValue = bill.getValue();
    int valueToAdd = billValue * count;
    
    total -= valueToAdd;
    System.out.println("Subtracting " + count + " of $" + bill.getValue() + " bills ($" + valueToAdd + " total)");
  }
}