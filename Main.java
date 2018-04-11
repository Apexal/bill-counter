import java.util.Scanner;

class Main {
  MoneyCounter counter = new MoneyCounter();
  
  Scanner input = new Scanner(System.in);

  public void loop() {
    while (true) {
      System.out.println("Current total:\t$" + counter.getTotal());
      System.out.print("> ");
      String line = input.nextLine();

      String[] parts = line.split(" ");
      if (validate(parts)) {
        process(parts);
      }
    }
  }
  
  public boolean validate(String[] parts) {
    if (parts.length != 3) return false;
    return true;
  }
  
  public void process(String[] parts) {
    Boolean adding = null;
    switch (parts[0]) {
      case "+":
      case "a":
      case "add":
        adding = true;
        break;
      case "-":
      case "s":
      case "sub":
      case "subtract":
        adding = false;
        break;
    }
    
    if (adding == null) return;
    
    Bill bill = null;
    switch (parts[2]) {
      case "1":
      case "one":
      case "ones":
        bill = Bill.ONE;
        break;
      case "2":
      case "two":
      case "twos":
        bill = Bill.TWO;
        break;
      case "5":
      case "five":
      case "fives":
        bill = Bill.FIVE;
        break;
      case "10":
      case "ten":
      case "tens":
        bill = Bill.TEN;
        break;
    }
    
    if (bill == null) return;
    
    int count = Integer.parseInt(parts[1]);
    
    if (adding) {
      counter.add(bill, count);
    } else {
      counter.subtract(bill, count);
    }
  }
  
  public static void main(String[] args) {
    Main app = new Main();
    app.loop();
  }
}