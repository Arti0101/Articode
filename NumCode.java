package NumberCode;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Random;
	  
	public class NumCode {
	  
	    private Random generator;
	    private int generatedNumber;
	    private int numberOfAttempts;
	    BufferedReader reader = null;
	  
	    public NumCode() {
	        generator = new Random();
	        reader = new BufferedReader(new InputStreamReader(System.in));
	    }
	  
	    public void start() throws IOException {
	  
	        boolean wantToPlay = false;
	        boolean firstTime = true;
	  
	        do {
	            System.out.println();
	            System.out.println();
	            System.out.println("Gussing number it should be Higher and Lower??");
	            if (wantToPlay = prompt()) {
	                generatedNumber = generateSecretNumber();
	                numberOfAttempts = 0;
	                if (firstTime) {
	                    describeRules();
	                    firstTime = false;
	                }
	                playGame();
	            }
	  
	        } while (wantToPlay);
	  
	        System.out.println();
	        System.out.println("Thanks for gussing number!!");
	        reader.close();
	    }
	  
	    private void describeRules() {
	        System.out.println();
	        System.out.println("Only 2 Rules:");
	        System.out.println("1) Guess the any  number between 1 to 100 in maximum 8 attemps.");
	        System.out.println("2) select number is an integer between 1 to 100)");
	        System.out.println();
	        System.out.println();
	    }
	  
	    private int generateSecretNumber() {
	        return (generator.nextInt(100) + 1);
	    }
	  
	    private void playGame() throws IOException {
	  
	        while (numberOfAttempts < 8) {
	  
	            int guess = getNextGuess();
	  
	            if (guess > generatedNumber) {
	                System.out.println("HIGHER");
	            } else if (guess < generatedNumber) {
	                System.out.println("LOWER");
	            } else {
	                System.out.println("You guessed the right number!!");
	                return;
	            }
	            numberOfAttempts++;
	        }
	  
	        System.out.println("Sorry, you didn't guess the right number in eight attempts. In other two words, YOU LOST !!!!");
	        System.out.println("The secret number was " + generatedNumber);
	  
	    }
	  
	    private boolean prompt() {
	  
	        boolean answer = false;
	  
	        try {
	  
	            boolean inputOk = false;
	            while (!inputOk) {
	                System.out.print("Y / N : ");
	                String input = reader.readLine();
	                if (input.equalsIgnoreCase("y")) {
	                    inputOk = true;
	                    answer = true;
	                } else if (input.equalsIgnoreCase("n")) {
	                    inputOk = true;
	                    answer = false;
	                } else {
	                    System.out.println(" please type 'y' and 'n' ?? Please try again:");
	                }
	            }
	  
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
	  
	        return answer;
	    }
	  
	    private int getNextGuess() throws IOException {
	  
	        boolean inputOk = false;
	        int number = 0;
	        String input = null;
	        while (!inputOk) {
	            try {
	  
	                System.out.print("Please guess the any number between 1 to 100: ");
	                input = reader.readLine();
	                number = Integer.parseInt(input);
	                if (number >= 1 && number <= 100) {
	                    inputOk = true;
	                } else {
	                    System.out.println("Your number is not between 1 and 100 (" + number + ").");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input (" + input + ")");
	            }
	        }
	  
	        return number;
	    }
	}
}
