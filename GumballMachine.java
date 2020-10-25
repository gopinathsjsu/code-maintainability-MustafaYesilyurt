public class GumballMachine {

    private final int N_VALUE = 5;
    private final int D_VALUE = 10;
    private final int Q_VALUE = 25;
    private final int DEF_GUMBALLS = 3;

    private int num_gumballs;
    private int model;
    private boolean has_coin;
    private int requirement;
    private int total;
    private int coin;

    public GumballMachine() { // default constructor
        this.num_gumballs = DEF_GUMBALLS;
        this.model = 1;
        this.requirement = Q_VALUE;
        this.has_coin = false;
        this.total = 0;
        this.coin = 0;
        System.out.println("\n\nNow testing (default) GumballMachine(size = " + this.num_gumballs + ", model = " + this.model + ")\n");
    }

    public GumballMachine(int size, int model) {
        // initialise instance variables
        this.num_gumballs = size;
        if (this.num_gumballs <= 0) 
            this.num_gumballs = DEF_GUMBALLS;  // default size
        this.model = model;
        if (this.model < 1 || this.model > 3) 
            this.model = 1;         // default model
        switch (model) {
            case 2:
                this.requirement = 2*Q_VALUE;
                break;
            case 3:
                this.requirement = 2*Q_VALUE;
                break;
            default:
                this.requirement = Q_VALUE;
        }
        this.has_coin = false;
        this.total = 0;
        this.coin = 0;
        System.out.println("\n\nNow testing GumballMachine(size = " + this.num_gumballs + ", model = " + this.model + ")\n");
    }

    public boolean hasBalls() {return this.num_gumballs > 0 ? true : false;}

    public void insertCoin(int coin) {
        if (((model == 1 || model == 2) && coin == Q_VALUE) || (model == 3 && (coin == N_VALUE || coin == D_VALUE || coin == Q_VALUE))) {
            this.has_coin = true;
            this.coin = coin;
            System.out.println("Valid coin inserted. Please turn the crank to retrieve gumball or insert next coin.");
        }
        else if (model == 1) {
            System.out.println("Invalid coin! Please insert a quarter (1 required).");
        }
        else if (model == 2) {
            System.out.println("Invalid coin! Please insert a quarter (" + ((this.requirement - this.total)/Q_VALUE) + "  quarters remaining).");
        }
        else {
            // if (coin != N_VALUE && coin != D_VALUE && coin != Q_VALUE)
            System.out.println("Invalid coin! Please insert a nickel, dime, or quarter (" + (this.requirement - this.total) + " cents remaining).");
        }
    }
    
    public boolean turnCrank() {
    	if (this.has_coin) {
    		if (this.num_gumballs > 0) {
                this.total += this.coin;
                this.coin = 0;
    			this.has_coin = false;
                if (this.total >= this.requirement) {
                    this.num_gumballs--;
                    
        			System.out.println("Thank you for your patronage.  Here is your gumball!");
                    if (this.total > this.requirement)
                        System.out.println("\t" + (this.total-this.requirement) + " cents is your change.");
                    total = 0;
                }
                else {
                    System.out.println("Coin accepted. " + (this.requirement - this.total) + " cents remaining.");
                }
    		}
    		else {
    			System.out.println("Sorry, there are no more gumballs!  Returning your coin.");
                return false;
    		}
    	}
    	else {
            switch (model) {
                case 2:
                    System.out.println("Please insert a quarter (2 required).");
                    break;
                case 3:
                    System.out.println("Please insert a nickel, dime, or quarter (50 cents required).");
                    break;
                default:
                    System.out.println("Please insert a quarter (1 required).");
            }
    	}
        return true;
    }

    public static void main(String[] args) {
        int size = 3;
        int model = 1;
        GumballMachine gm1 = new GumballMachine(size, model);
        // while (gm1.hasBalls()) {
        for (int i = 0; i < 4; i++) {
            gm1.insertCoin(20);
            gm1.insertCoin(10);
            gm1.insertCoin(5);
            gm1.insertCoin(25);
            if (!gm1.turnCrank())
                break;
        }
        gm1.turnCrank();
        gm1.insertCoin(25);
        gm1.turnCrank();


        model = 2;
        GumballMachine gm2 = new GumballMachine(size, model);
        // while (gm2.hasBalls()) {
        for (int i = 0; i < 7; i++) {
            gm2.insertCoin(20);
            gm2.insertCoin(10);
            gm2.insertCoin(5);
            gm2.insertCoin(25);
            if (!gm2.turnCrank())
                break;
        }
        gm2.turnCrank();
        gm2.insertCoin(25);
        gm2.turnCrank();


        model = 3;
        GumballMachine gm3 = new GumballMachine(size-1, model);
        gm3.insertCoin(20);
        gm3.turnCrank();
        gm3.insertCoin(25);
        gm3.turnCrank();
        gm3.insertCoin(5);
        gm3.turnCrank();
        gm3.insertCoin(25);
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();
        gm3.insertCoin(5);
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();
        gm3.turnCrank();
        gm3.insertCoin(10);
        gm3.turnCrank();


        GumballMachine gmd = new GumballMachine();
        // while (gmd.hasBalls()) {
        for (int i = 0; i < 7; i++) {
            gmd.insertCoin(20);
            gmd.insertCoin(25);
            if (!gmd.turnCrank())
                break;
        }
        gmd.turnCrank();
        gmd.insertCoin(25);
        gmd.turnCrank();
    }
}

