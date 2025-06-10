//Shared May 15th, 2025//Skeleton Code for Quiz Program
// //This imports the required library of commands to access the common
// //utilities and the input and output commands.
// 

import java.util.*;

/**  * This skeleton must be used for your Final Computer Quiz Program  */
public class Main{

   
    /**
     *  * This is the main routine where you will put your code for this
     * assignment. 
     */
    public static void main(String[] args) {

        // These next two lines will clear the terminal window in BlueJ and will
        //also clear the execution area on GDB online.
        System.out.print("\033[H\033[2J\f");
        System.out.flush();

        // Title for the main program.
        System.out.println("ICS 3U1 Computer Quiz Program.");

        // Declaring the 2D array that will hold the set of questions to use.
        // This needs to be setup for each game
        String[][] strQuestions = new String[20][5];

        // SB: Declare the 1D array that will hold the answers for each of the 20 questions
        // This needs to be setup for each game
        String[] strAnswers = new String[20];

        // SB: Declare the 1D array that will hold the 3 prizes for each game - for > 30%, 60% and 90% scores
        // This needs to be setup for each game
        String[] strPrizes = new String[3];

        // SB: Declare the 1D array that will hold the incorrect questions
        // This needs to be reset for each game
        String[] incorrectQs = new String[20];

        // SB: This stores the number of Questions Attempted and number of correct answers to calculate % accuracy
        // This needs to be reset for each game
        int numQsAttempted, numAnsCorrect;

        // SB: This variable stores the users game score
        // This needs to be reset for each game        
        double score;

        // SB: Declare the 2D array that will hold the prizes won
        // There will be no duplicate prizes. A user can only win a prize once
        // This will need to be stored until the game is exited
        String[] prizesWon = new String[9];

        // SB: This variable stores their total cumulative score across all games
        // This will need to be stored until the game is exited
        double scoreTotal = 0.0;

        printAsciiTitle();
        
        //SB: Get the users name using the getString function and greet the user with their name
        String uName = pauseAndContinue("\n\nWhat is your name? " , true, 3);

        // Loop for the current topic.
        do {

            // Initial setup calls "initialize" to ensure the string array is empty.
            // Stores nothing ("") in all spots in the 2D array.
            initialize(strQuestions, "");

            // SB: Initialize all the 1D arrays with nothing ("")
            initialize(strAnswers, "");
            initialize(strPrizes, "");
            initialize(incorrectQs, "");

            // SB: Initiatize all the game stats to 0
            numQsAttempted = 0;
            numAnsCorrect = 0;
            score = 0;

            // Used in the random number generation and loop end detection.
            int iNumQs = strQuestions.length;

            // Get the user input for which game to select.
            int iSection = getInt(
                    "\nHello " + uName  + ". Select your game here: \n" + 
                    "> " + "1 - The Claw Machine\n"  +
                    "> " + "2 - Apple Bobbing\n"  +
                    "> " + "3 - The Sack Race\n"  +
                    "Which number would you like to play? " +
                    "Please enter " + "1, " + "2"  + " or " + "3"  + ": ",
                    1, 3);
            
            // SB: Store the game name to be used for display
            String gameName = "";
            
            // Based on the topic number, call the method and load the correct set of
            // questions.
            switch (iSection) {
                case 1:

                    // Call method for section/topic 1
                    // SB: Pass both question and answer arrays
                    // SB: strQuestions will store 20 questions and 4 answer options for each
                    // SB: strAnswers will store only the correct answer numbers for 20 questions
                    fillArrayTopic1(strQuestions, strAnswers, strPrizes);
                    gameName = "The Claw Machine";
                    break;

                case 2:
                    // Call method for section/topic 2
                    fillArrayTopic2(strQuestions, strAnswers, strPrizes);
                    gameName = "Apple Bobbing";
                    break;

                case 3:
                    // Call method for section/topic 3
                    fillArrayTopic3(strQuestions, strAnswers, strPrizes);
                    gameName = "The Sack Race";
                    break;

                default:
                    // Should not happen -- but you can add any code for this situation.
            }

            // SB: Instruct the user to enter the game before clearing the screen
            pauseToContinue("\nHit 'Enter' to play '" + gameName +"'", true);
            
            // This variable keeps track of what the current questions number we are at.
            int iQCount = 0;

            // Loop to do the random questions.
            do {
                printGameHeader(gameName, uName, numQsAttempted, numAnsCorrect, score, scoreTotal);
                
                // Add one to the question count.
                iQCount++;

                // Select a random question.
                int iRandQ = (int) (Math.random() * iNumQs);

                // If the random question chosen above has already been used (the question
                // portion is empty)
                // then grab the next question in line (wraps around after it gets to the last
                // question).
                while (iQCount <= iNumQs && strQuestions[iRandQ][0] == "") {
                    iRandQ = (iRandQ + 1) % iNumQs;
                }

                // Show the randomly selected question:
                System.out.println("\nQuestion #" + iQCount + " -- " + strQuestions[iRandQ][0] );

                // This shows the four options -- if you want letters for options instead of
                // numbers it can be done as well, ask and I can show it.
                for (int i = 1; i < strQuestions[0].length; i++) {

                    // Displays the options as numbers -- you can add a "\n" for extra spacing.
                    // SB: Since the array containing correct answers will hold the option numbers 
                    // we will prefix possible answer options with numbers. 
                    System.out.println("Option #" + i + ": " + strQuestions[iRandQ][i]);

                    // Displays the options – this line will show lowercase “a”, “b”, “c” and “d”.
                    // SB: We will NOT use alphabets to prefix options, since the array strAnswers 
                    // for correct answers will be storing the correct option number
                    // System.out.println("Option #" + (char) (i + 'a' - 1) + ": " + strQuestions[iRandQ][i]);

                    // Displays the options – this line will show uppercase “A”, “B”, “C” and “D”.
                    // SB: We will NOT use alphabets to prefix options, since the array strAnswers 
                    // for correct answers will be storing the correct option number                    
                    // System.out.println("Option #" + (char) (i + 'A' - 1) + ": " + strQuestions[iRandQ][i]);

                }

                // SB: Users get 2 attempts at the answer for each question. If they don't get in 2 tries, the odds reduce to 50:50. Sweet!
                int uAttempt = 0;
                boolean correctAns = false;

                // SB: Increment number of questions attempted (irrespective of whether the answer is correct)
                numQsAttempted += 1;                                

                // SB: This do while loop will allow for up to 2 attempts 
                // Exit condition - User has a correct answer or User has attempted twice
                do {
                  
                    // SB: Increment user's attempt    
                    uAttempt += 1;

                    // SB: Get the user's answer
                    int uAns = getInt("\nEnter your answer (1, 2, 3 or 4): ", 1, 4);

                    // SB: If the user's answer matches the correct answer for the question
                    if (uAns == Integer.valueOf(strAnswers[iRandQ])) {
                        
                        // SB: Update this boolean variable so user does not get another attempt
                        correctAns = true;

                        // SB: if this was the first attempt
                        if (uAttempt == 1) {
                            // SB: Update score by 1 for the first attempt
                            score += 1;

                            // SB: also update total score
                            // This is the cumulative score across all games
                            scoreTotal += 1;

                            System.out.println("Bingo! You've scored "  + "1 " + "point" );
                        }
                        // SB: if this was the second attempt
                        else {
                            // SB: Update score by 0.5 for the second attempt
                            score += 0.5;

                            // SB: also update total score
                            // This is the cumulative score across all games
                            scoreTotal += 0.5;
                            
                            System.out.println("You got that right! You've scored "  + "0.5");
                        }

                        if (correctAns) {

                            // SB: This needs to be updated only once for a question, if the answer is right
                            numAnsCorrect+=1;
                        }

                    }
                    // SB: This else condition means the user didn't answer correctly
                    else {

                        // SB: if this was the first attempt
                        if (uAttempt == 1) {
                            // SB: Inform the user about getting another chance to try
                            System.out.println("That was not the right answer. You get one more chance." );
                        }
                        // SB: if this was the second and final attempt
                        else {
                            // SB: Inform the user about not scoring                            
                            System.out.println("You missed scoring that one :(" );                                                        
                        }
                    }

                } while (correctAns == false && uAttempt != 2);

                // SB: if correctAns is still false (even after 2 attempts), that means the user failed the question. So sad!
                if (correctAns == false) {

                    // SB: Store the incorrectly answered question in a separate array
                    incorrectQs[iRandQ] = strQuestions[iRandQ][0];

                }

                // Clear that question so it is not selected again
                strQuestions[iRandQ][0] = "";                

                // SB: Give the user feedback about that round
                //System.out.printlPern("\nYou've attempted " + numQsAttempted + " questions in this game and answered " + numAnsCorrect + " correctly.");
                //System.out.println("Your current score is " + score);

                // Keep looping while we have not used all the questions or the user explicitly asks to quit by entering 'no'
            } while (iQCount != iNumQs && !pauseAndContinue(
                    "\nWould you like to see another question?" + 
                    "\n- Hit 'Enter' to continue the game" + 
                    "\n- Type 'no' to go to Game Selection menu \n" ,
                    true, -1).equalsIgnoreCase("no"));

            // This is just here to tell the user that all of the questions have been used
            // -- it should not be needed in your program (unless you wish to allow up to the total number of
            // questions).

            if (iQCount == iNumQs) {
                System.out.println("\nAll questions in this topic have been used. Please try a new topic.");
            }

            // SB: Let the user get an idea of how they did in the game, and what prizes await them.
            // In this block, we just waste some time as if the program is doing some busy work
            printGameHeader(gameName, uName, numQsAttempted, numAnsCorrect, score, scoreTotal);
            System.out.print("\nPlease wait " + uName + "! We are fetching your reward");
            for (int i=0;i<20;i++) {
                System.out.print(". ");
                wait(75);
            }


            // SB: Calculate passRate based on questions answered correctly vs questions attempted
            double passRate = numAnsCorrect*100/numQsAttempted;

            // SB: Now declare the prize. We use the prizes array. Depending on the % scores, we pick the prize. 
            System.out.print("\n\nFor scoring " + passRate + "%"  + ", you win ");
            if (passRate > 90) {
                
                // SB: Print the prize and some shout out
                System.out.print(strPrizes[2]  + ". Woohoo!\n\n");
                
                switch (strPrizes[2]) {
                    case "Teddy Bear":
                        // SB: Print the teddy bear
                        printTeddyBear();
                        // SB: Add it to the list of prizes the user won. 
                        prizesWon[2] = strPrizes[2];     
                        break;
                    case "Basket of caramel apples":
                        printBasketOfApples();
                        prizesWon[5] = strPrizes[2];                             
                        break;
                    case "Decorated sack full of candy":
                        printDecoratedCandySack();
                        prizesWon[8] = strPrizes[2];                             
                        break;
                    default:
                        System.out.println("Unknown prize!");
                }
            }
            else if (passRate > 60) {
                System.out.print(strPrizes[1]  + ". Super cool!\n\n");

                switch (strPrizes[1]) {
                    case "Lollipop":
                        // SB: Print the lollipop
                        printLollipop();
                        // SB: Add it to the list of prizes the user won. 
                        prizesWon[1] = strPrizes[1];     
                        break;
                    case "Caramel apple with sprinkles":
                        printCaramelApple();
                        prizesWon[4] = strPrizes[1];                             
                        break;
                    case "Decorated sack":
                        printDecoratedSack();
                        prizesWon[7] = strPrizes[1];                             
                        break;
                    default:
                        System.out.println("Unknown prize!");
                }

            }
            else if (passRate > 30) {
                System.out.print(strPrizes[0]  + ". Nicely Done!\n\n");
                
                switch (strPrizes[0]) {
                    case "High Five":
                        // SB: Print a high five hand
                        printHighFiveHand();
                        // SB: Add it to the list of prizes the user won. 
                        prizesWon[0] = strPrizes[0];     
                        break;
                    case "Delicious apple":
                        printRedApple();
                        prizesWon[3] = strPrizes[0];                             
                        break;
                    case "Keep your sack":
                        printSack();
                        prizesWon[6] = strPrizes[0];
                        break;
                    default:
                        System.out.println("Unknown prize!");
                }

            }
            else {
                System.out.print("nothing! "  + "Better luck next time.");
            }
            
            // SB: If the passRate is not a perfect 100, they missed some question. Print a list of questions they missed
            if (passRate < 100) {
                System.out.println("\n" + uName + " - These are the questions you had missed: " );
                printArrayContents(incorrectQs);
            }

            // SB: Loop the whole thing if they wish to try another EXCITING game. This is very addictive.
            // In this case, the game will quit if the user enters "no" at the prompt. Otherwise the game will continue
        } while (!pauseAndContinue(
                    "\nWould you like to try a different game?" + 
                    "\n- Hit 'Enter' to continue playing" + 
                    "\n- Type 'no' to quit. WARNING: You will exit the game and all progress will be lost\n" ,
                    true,-1).equalsIgnoreCase("no"));

            // SB: Print the game title in the final screen
            printAsciiTitle();

            System.out.println("\n- - - - - - - - THANK YOU for playing! - - - - - - - -" );

            // SB: Since the user is quitting the game, it is time to declare the total score and the prizes they won
            System.out.println("\n" + uName + " - Your total score is "  + scoreTotal);
            System.out.println("\nHere's are the prizes you won today: " );
            printArrayContents(prizesWon);

            System.out.println("\n- - - - - - Come back to play another time!- - - - - -" );
            System.out.println("======================================================" );

    }

    // SB: This method will print the header for the game which will be presented at the top
    // when questions are displayed. It will contain the game name and game stats. 
    private static void printGameHeader(String gameName, String userName, int numQsAttempted, int numAnsCorrect, double score, double scoreTotal) {

        // SB: Print the game name
        System.out.println("===================================================================================" );
        System.out.println("                                " + gameName + "                                " );
        System.out.println("===================================================================================" );

        // SB: Print the game stats
        System.out.println("User Name: "  + userName + 
                            "              Current score: "  + score + 
                            "         Total Score: "  + scoreTotal);
        System.out.print("Questions attempted: "  + numQsAttempted + 
        "      Answered correctly: "  + numAnsCorrect);

        // If any questions were attempted, calculate and print the pass rate
        if (numQsAttempted > 0) {
            System.out.println("      Pass Rate: "  + Math.round(numAnsCorrect * 100.0 / numQsAttempted) + "%");
        }
        else {
            System.out.println("      Pass Rate: "  + "0%");
        }
        
        System.out.println("===================================================================================" );        
    }    

    // This routine is here to initialize the 2 dimensional array to contain
    // whatever initial starting string is sent as the second parameter.
    private static void initialize(String grid[][], String strStart) {

        // Loop through the number of arrays (rows) there are.
        for (int i = 0; i < grid.length; i++) {

            // Loop through the number of elements there are in each array (columns).
            for (int j = 0; j < grid[0].length; j++) {

                // Put the start character in the current spot in the 2D array.
                grid[i][j] = strStart;
            }
        }
    }

    // SB: This routine is here to initialize the 1 dimensional array to contain
    // whatever initial starting string is sent as the second parameter.
    private static void initialize(String grid[], String strStart) {

        // Loop through the number of arrays (rows) there are.
        for (int i = 0; i < grid.length; i++) {

            // Put the start character in the current spot in the 2D array.
            grid[i] = strStart;
        }
    }

    // SB: A little subroutine to nap... err, sleep for a bit when needed. Let the program relax a bit
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    // SB: Prints the contents of the 1D array
    public static void printArrayContents(String items[]) {

        int count = 0;
        // Loop through the number of arrays (rows) there are.
        for (int i = 0; i < items.length; i++) {

            // Print them in separate lines if they aren't empty
            if (items[i] != null && items[i] != "") {
                count ++;
                System.out.println(count + ". " + items[i]);
            }
        }
    }

    public static void printAsciiTitle() {
        System.out.println("==============================================================" );
        System.out.println("\n" + 
            "           _____                  _               _ \n" +
            "          /  __ \\                (_)             | |\n" +
            "         /  /  \\/ __ _ _ __ _ __  _ __    __ __ _| |\n" +
            "        (  (     / _` | '_,| '_ `| |\\ \\  / // _` | | \n" +
            "         \\  \\__/\\ (_| | |  | | | | | \\ \\/ /| (_| | |\n" +
            "          \\_____/\\__,_|_|  |_| |_|_|  \\__/  \\__,_|_|\n" +
            "\n" +
            "    _____        _         _____                        \n" + 
            "   /  _  \\      (_)       /  _  \\     \n" +
            "  |  | |  |_   _ _ ____  /  / |__| __ _ _ __  __   ___  ___ \n" +
            "  |  | |  | | | | |_  / (  (  ___ / _` | '_ `'_ \\ / _ \\/ __|\n" +
            "  |  |_|\\ \\ |_| | |/ /_  \\  \\|_  | (_| | | | | | |  __/\\__ \\\n" +
            "   \\____,\\_\\__,_|_|____|  \\_____/ \\__,_|_| |_| |_|\\___||___/\n\n" );
        System.out.println("==============================================================" );
    }    

    // Loads the array sent in with the first topic content.
    // SB: strAs 1D array will store the correct answers for all 20 questions
    private static void fillArrayTopic1(String strQs[][], String strAs[], String prizes[]) {
                strQs[0][0] = "Which of the following would correctly declare two integer variables and set them both to an initial value of 3?";
        strQs[0][1] = "int a = 3, b = 3;";
        strQs[0][2] = "int a = 3; int b == 3;";
        strQs[0][3] = "int a == 3, b == 3;";
        strQs[0][4] = "int a = b = 3;";
        strAs[0] = "2"; // SB: In this case 3rd option is the correct answer

        strQs[1][0] = "Which would be the correct datatype to use to store the following type of information:\r\n" + //
                        "- text information/words like: \"Hello\", \"John Smith\", \"Java\", or \"123 Some Street\"";
        strQs[1][1] = "use int, byte or short";
        strQs[1][2] = "use boolean";
        strQs[1][3] = "use char";
        strQs[1][4] = "use String.";
        strAs[1] = "4"; // SB: 

        strQs[2][0] = "AWhich would be the correct datatype to use to store the following type of information:\r\n" + //
                        "- values for calculations like: 12.23, -32.345, 12.12 or 199.87";
        strQs[2][1] = "use int, byte or short";
        strQs[2][2] = "use String";
        strQs[2][3] = "use float, or double.";
        strQs[2][4] = "use char";
        strAs[2] = "3"; // SB: 

        strQs[3][0] = "Which would be the correct datatype to use to store the following type of information:\r\n" + //
                        "- values resulting from conditions or comparisons like: true, or false";
        strQs[3][1] = "use boolean.";
        strQs[3][2] = "use char";
        strQs[3][3] = "use String";
        strQs[3][4] = "use int, byte or short";
        strAs[3] = "1"; // SB: 

        strQs[4][0] = "Which would be the correct datatype to use to store the following type of information:\r\n" + //
                        "- whole number values like: 123, 12, or  -27";
        strQs[4][1] = "use String";
        strQs[4][2] = "use float, or double";
        strQs[4][3] = "use char";
        strQs[4][4] = "use int, byte or short.";
        strAs[4] = "4"; // SB: 

        strQs[5][0] = "Which would be the correct datatype to use to store the following type of information:\r\n" + //
                        "- a single character like:  'a', '4', '#' or '+'";
        strQs[5][1] = "use boolean";
        strQs[5][2] = "use char.";
        strQs[5][3] = "use int, byte or short";
        strQs[5][4] = "use String";
        strAs[5] = "2"; // SB: 

        strQs[6][0] = "Which of the following printf statements would correctly output the following:\r\n" + //
                        "Hi John, you got 73 out of 80 on a quiz that is 91.3%";
        strQs[6][1] = "System.out.printf(\"Hi %s, you got %d out of 80 on a quiz that is %.1f%%\", \"John\", 73, 91.25);";
        strQs[6][2] = "System.out.printf(\"Hi %s, you got %.0f out of 80 on a quiz that is %.1f%%\", \"John\", 73, 91.25);";
        strQs[6][3] = "System.out.printf(\"Hi %s, you got %d out of 80 on a quiz that is %.2f%%\", \"John\", 73, 91.25);";
        strQs[6][4] = "System.out.printf(\"Hi %s, you got %.0f out of 80 on a quiz that is %.2f%%\", \"John\", 73, 91.25);";
        strAs[6] = "1"; // SB: 

        strQs[7][0] = "What is the default value of an int variable in Java?";
        strQs[7][1] = "0.";
        strQs[7][2] = "null";
        strQs[7][3] = "0.0";
        strQs[7][4] = "undefined";
        strAs[7] = "1"; // SB: 

        strQs[8][0] = "Which data type is used to store a single 16-bit Unicode character?";
        strQs[8][1] = "char.";
        strQs[8][2] = "byte";
        strQs[8][3] = "short";
        strQs[8][4] = "String";
        strAs[8] = "1"; // SB: 

        strQs[9][0] = "What is the result of the expression 5 + 2 * 3 in Java?";
        strQs[9][1] = "21";
        strQs[9][2] = "11.";
        strQs[9][3] = "15";
        strQs[9][4] = "13";
        strAs[9] = "2"; // SB: 

        strQs[10][0] = "Which of the following is a valid declaration of a float variable?";
        strQs[10][1] = "float f = 3.14;";
        strQs[10][2] = "float f = \"3.14\";";
        strQs[10][3] = "float f = 3.14f;";
        strQs[10][4] = "float f = 3,14;";
        strAs[10] = "3"; // SB: 

        strQs[11][0] = "Which operator is used for modulus (remainder) in Java?";
        strQs[11][1] = "/";
        strQs[11][2] = "*";
        strQs[11][3] = "%";
        strQs[11][4] = "^";
        strAs[11] = "3"; // SB: 

        strQs[12][0] = "What will System.out.println(10 / 4); output?";
        strQs[12][1] = "2.5";
        strQs[12][2] = "2";
        strQs[12][3] = "2.0";
        strQs[12][4] = "3";
        strAs[12] = "2"; // SB: 

        strQs[13][0] = "Which of these data types has the largest range?";
        strQs[13][1] = "int";
        strQs[13][2] = "long";
        strQs[13][3] = "float";
        strQs[13][4] = "double.";
        strAs[13] = "4"; // SB: 

        strQs[14][0] = "Which of these values can a boolean type have?";
        strQs[14][1] = "0 or 1";
        strQs[14][2] = "\"true\" or \"false\"";
        strQs[14][3] = "true or false.";
        strQs[14][4] = "'T' or 'F'";
        strAs[14] = "3"; // SB: 

        strQs[15][0] = "What is the size of a byte in Java?";
        strQs[15][1] = "4 bits";
        strQs[15][2] = "8 bits.";
        strQs[15][3] = "16 bits";
        strQs[15][4] = "32 bits";
        strAs[15] = "2"; // SB: 
        
        strQs[16][0] = "What will be the output of: System.out.println(3 + 4 + \"Hi\");?";
        strQs[16][1] = "Hi34";
        strQs[16][2] = "34Hi";
        strQs[16][3] = "Error";
        strQs[16][4] = "7Hi.";
        strAs[16] = "4"; // SB: 

        strQs[17][0] = "What will System.out.println(10 % 3); print?";
        strQs[17][1] = "3";
        strQs[17][2] = "0";
        strQs[17][3] = "10";
        strQs[17][4] = "1.";
        strAs[17] = "4"; // SB: 

        strQs[18][0] = "What happens if you try to assign a double value to an int variable directly?";
        strQs[18][1] = "It will round the value";
        strQs[18][2] = "It will truncate the value";
        strQs[18][3] = "It will cause a compile-time error.";
        strQs[18][4] = "It will throw an exception";
        strAs[18] = "3"; // SB: 

        strQs[19][0] = "Which type should you use to store a number like 3.14159?";
        strQs[19][1] = "int";
        strQs[19][2] = "double.";
        strQs[19][3] = "long";
        strQs[19][4] = "char";
        strAs[19] = "2"; // SB: 

        // SB: Fill the prizes array with the prizes for this game
        prizes[0] = "High Five";
        prizes[1] = "Lollipop";
        prizes[2] = "Teddy Bear";
    }

    // SB: This method will print a high five hand    
    public static void printHighFiveHand() {

        System.out.println("       _.-._");
        System.out.println("     /| | | |_");
        System.out.println("     || | | | |");
        System.out.println("     || | | | |");
        System.out.println("    _||     ` |");
        System.out.println("   \\\\`\\\\       ;");
        System.out.println("    \\\\        |");;
        System.out.println("     \\\\      /");;
        System.out.println("     | |    |");
        System.out.println("     | |    |" );
        System.out.println("    HIGH FIVE!");
    }    

    // SB: This method will print a lollipop
    public static void printLollipop() {

        System.out.println("   .-." );
        System.out.println("  ( @ )" );
        System.out.println("   `-'" );
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");        
        System.out.println("LOLLIPOP!");
    }

    // SB: This method will print a teddy bear
    public static void printTeddyBear() {

        System.out.println("/  \\.-\"\"\"-./  \\");
        System.out.println("\\    -   -    /");
        System.out.println(" |   o   o   |");
        System.out.println(" \\  .-'''-.  /");
        System.out.println("  '-\\__Y__/-'");
        System.out.println("     `---`" );
        System.out.println("  TEDDY BEAR!");
    }

    // Loads the array sent in with the second topic content.
    // SB: strAs 1D array will store the correct answers for all 20 questions
    private static void fillArrayTopic2(String strQs[][], String strAs[], String prizes[]) {
        strQs[0][0] = "Which of the following is not a Java primitive type?";
        strQs[0][1] = "int";
        strQs[0][2] = "boolean";
        strQs[0][3] = "String.";
        strQs[0][4] = "char";
        strAs[0] = "3"; // SB: In this case 3rd option is the correct answer

        strQs[1][0] = "What is the purpose of the \"final\" keyword when applied to a variable?";
        strQs[1][1] = "It can only be used once";
        strQs[1][2] = "It cannot be reassigned after initialization.";
        strQs[1][3] = "It creates a global variable";
        strQs[1][4] = "It can only be accessed inside a loop";
        strAs[1] = "2"; // SB:
        
        strQs[2][0] = "What is the default value of a boolean instance variable in Java?";
        strQs[2][1] = "true";
        strQs[2][2] = "false.";
        strQs[2][3] = "0";
        strQs[2][4] = "null";
        strAs[2] = "2"; // SB:

        strQs[3][0] = "Which of the following statements about Java interfaces is correct?";
        strQs[3][1] = "Interfaces cannot have any methods";
        strQs[3][2] = "All methods in interfaces must be static";
        strQs[3][3] = "Interfaces cannot be implemented by abstract classes";
        strQs[3][4] = "Interfaces can contain default and static methods.";
        strAs[3] = "4"; // SB:

        strQs[4][0] = "What is the main reason Java uses garbage collection?";
        strQs[4][1] = "To manage file system access";
        strQs[4][2] = "To automatically free memory used by unreachable objects.";
        strQs[4][3] = "To make code compile faster";
        strQs[4][4] = "To detect syntax errors";
        strAs[4] = "2"; // SB:

        strQs[5][0] = "Which Java keyword is used to inherit a class?";
        strQs[5][1] = "implements";
        strQs[5][2] = "extends.";
        strQs[5][3] = "inherits";
        strQs[5][4] = "override";
        strAs[5] = "2"; // SB:

        strQs[6][0] = "What does the \"this\" keyword refer to in Java?";
        strQs[6][1] = "The parent class";
        strQs[6][2] = "The current object instance.";
        strQs[6][3] = "A static variable";
        strQs[6][4] = "A global variable";
        strAs[6] = "2"; // SB:

        strQs[7][0] = "What will happen if a Java program tries to access an array index that is out of bounds?";
        strQs[7][1] = "It wraps around";
        strQs[7][2] = "It returns null";
        strQs[7][3] = "It throws an ArrayIndexOutOfBoundsException.";
        strQs[7][4] = "It compiles with a warning";
        strAs[7] = "3"; // SB:

        strQs[8][0] = "What is method overloading in Java?";
        strQs[8][1] = "Changing the return type of a method";
        strQs[8][2] = "Defining a method in a subclass";
        strQs[8][3] = "Calling a method from multiple threads";
        strQs[8][4] = "Creating multiple methods with the same name but different parameters.";
        strAs[8] = "4"; // SB:

        strQs[9][0] = "Which of the following best describes Java’s exception hierarchy?";
        strQs[9][1] = "All exceptions inherit from RuntimeError";
        strQs[9][2] = "Only checked exceptions can be thrown";
        strQs[9][3] = "All exceptions inherit from Throwable.";
        strQs[9][4] = "Exceptions must be caught using try-finally";
        strAs[9] = "3"; // SB:

        strQs[10][0] = "Which keyword is used to prevent method overriding?";
        strQs[10][1] = "static";
        strQs[10][2] = "final.";
        strQs[10][3] = "protected";
        strQs[10][4] = "sealed";
        strAs[10] = "2"; // SB:

        strQs[11][0] = "What does the \"super\" keyword do?";
        strQs[11][1] = "Access a static variable";
        strQs[11][2] = "Refer to the current class";
        strQs[11][3] = "Refer to the parent class.";
        strQs[11][4] = "Create a subclass";
        strAs[11] = "3"; // SB:

        strQs[12][0] = "What does the JVM (Java Virtual Machine) do?";
        strQs[12][1] = "Compiles Java source code into .java files";
        strQs[12][2] = "Executes compiled Java bytecode.";
        strQs[12][3] = "Converts HTML to Java";
        strQs[12][4] = "Parses XML files";
        strAs[12] = "2"; // SB:

        strQs[13][0] = "Which of the following is NOT true about Java’s String class?";
        strQs[13][1] = "It is immutable";
        strQs[13][2] = "It is a primitive type.";
        strQs[13][3] = "It supports the + operator for concatenation";
        strQs[13][4] = "It overrides the equals() method";
        strAs[13] = "2"; // SB:

        strQs[14][0] = "Which collection type maintains the insertion order?";
        strQs[14][1] = "HashMap";
        strQs[14][2] = "TreeMap";
        strQs[14][3] = "LinkedHashMap.";
        strQs[14][4] = "Hashtable";
        strAs[14] = "3"; // SB:

        strQs[15][0] = "What is the time complexity of ArrayList.add() in the average case?";
        strQs[15][1] = "O(n)";
        strQs[15][2] = "O(1).";
        strQs[15][3] = "O(log n)";
        strQs[15][4] = "O(n log n)";
        strAs[15] = "2"; // SB:

        strQs[16][0] = "Which access modifier allows a member to be accessed only within its own package?";
        strQs[16][1] = "private";
        strQs[16][2] = "protected";
        strQs[16][3] = "(default, no modifier).";
        strQs[16][4] = "public";
        strAs[16] = "3"; // SB:

        strQs[17][0] = "Which interface must be implemented to create a thread by inheritance?";
        strQs[17][1] = "ExecutorService";
        strQs[17][2] = "Callable";
        strQs[17][3] = "Runnable.";
        strQs[17][4] = "Comparable";
        strAs[17] = "3"; // SB:
        
        strQs[18][0] = "Which Java feature supports dynamic method dispatch?";
        strQs[18][1] = "Method overloading";
        strQs[18][2] = "Static binding";
        strQs[18][3] = "Polymorphism.";
        strQs[18][4] = "Encapsulation";
        strAs[18] = "3"; // SB:

        strQs[19][0] = "What will System.out.println(0.0/0) output?";
        strQs[19][1] = "0";
        strQs[19][2] = "Infinity";
        strQs[19][3] = "NaN.";
        strQs[19][4] = "Error";
        strAs[19] = "3"; // SB:

        prizes[0] = "Delicious apple";
        prizes[1] = "Caramel apple with sprinkles";
        prizes[2] = "Basket of caramel apples";

    }

    // SB: This method prints a red apple using ANSI escape codes for colors 
    public static void printRedApple() {
        System.out.println("        ,----./,---." );
        System.out.println("       / #          \\" );
        System.out.println("      /              \\");
        System.out.println("     |                |");
        System.out.println("     |                |");
        System.out.println("      \\              /");
        System.out.println("       `.          .'");
        System.out.println("         `--.,..--'" );
    }    

    // SB: This method prints a caramel apple with sprinkles using ANSI escape codes for colors
    public static void printCaramelApple() {
        System.out.println("        ,----./,---." );
        System.out.println("       /  #         \\" );
        System.out.println("      /" + " . * " + "|" +  " * " + "|" + " .* " + "\\");
        System.out.println("     |" +  " * " + "|" + " . * . " + "|" + " * " + "|");
        System.out.println("     |" + " . * " + "|" +  " * " + "|" + " . * " + "|");
        System.out.println("      \\ . * . . * . /" );
        System.out.println("       `.         .'" );
        System.out.println("         `--.,.--'" );
    }

    // SB: This method prints a basket of caramel apples using ANSI escape codes for colors
    public static void printBasketOfApples() {
        // Apples in basket
        System.out.println("      ._./\\._." + "  ._./\\,_." );
        System.out.println("     (  " + "*.*" + "  )(  " + "*.*" + "  )" );
        System.out.println("    (  " + ".*.*" + "  )(  " + ".*.*" + "  )" );
        System.out.println("     (  " + "*.*" + "  )(  " + "*.*" + "  )" );
        
        // Basket
        System.out.println("    ╭─────────────────╮");
        System.out.println("    │ ╭─────────────╮ │");
        System.out.println("    │ │   Basket    │ │");
        System.out.println("    │ │     of      │ │");
        System.out.println("    │ │   Caramel   │ │");
        System.out.println("    │ │   Apples    │ │");
        System.out.println("    │ ╰─────────────╯ │");
        System.out.println("    ╰─────────────────╯" );
    } 

    // Loads the array sent in with the third topic content.
    // SB: strAs 1D array will store the correct answers for all 20 questions
    private static void fillArrayTopic3(String strQs[][], String strAs[], String prizes[]) {
        strQs[0][0] = "What is the primary purpose of encapsulation in Java?";
        strQs[0][1] = "To reduce code execution time";
        strQs[0][2] = "To improve syntax readability";
        strQs[0][3] = "To bundle data and restrict access.";
        strQs[0][4] = "To inherit methods from another class";
        strAs[0] = "3"; // SB: In this case 3rd option is the correct answer

        strQs[1][0] = "Which keyword is used to create a subclass in Java?";
        strQs[1][1] = "this";
        strQs[1][2] = "instanceof";
        strQs[1][3] = "extends.";
        strQs[1][4] = "super";
        strAs[1] = "3"; // SB: 

        strQs[2][0] = "What is method overloading?";
        strQs[2][1] = "Changing the return type of a method";
        strQs[2][2] = "Defining methods with the same name but different parameters.";
        strQs[2][3] = "Replacing a method in the child class";
        strQs[2][4] = "Creating a method with the same name and parameters in a different class";
        strAs[2] = "2"; // SB: 

        strQs[3][0] = "Which keyword is used to refer to the immediate parent class object?";
        strQs[3][1] = "parent";
        strQs[3][2] = "super.";
        strQs[3][3] = "base";
        strQs[3][4] = "this";
        strAs[3] = "2"; // SB: 

        strQs[4][0] = "What does the abstract keyword signify in a class declaration?";
        strQs[4][1] = "The class can’t have constructors";
        strQs[4][2] = "The class cannot contain methods";
        strQs[4][3] = "The class can’t be instantiated.";
        strQs[4][4] = "The class is private";
        strAs[4] = "3"; // SB: 

        strQs[5][0] = "Which of the following supports runtime polymorphism in Java?";
        strQs[5][1] = "Method overloading";
        strQs[5][2] = "Final methods";
        strQs[5][3] = "Static methods";
        strQs[5][4] = "Method overriding.";
        strAs[5] = "4"; // SB: 

        strQs[6][0] = "Which access modifier makes a member accessible only within its own class?";
        strQs[6][1] = "protected";
        strQs[6][2] = "private.";
        strQs[6][3] = "public";
        strQs[6][4] = "default";
        strAs[6] = "2"; // SB: 

        strQs[7][0] = "Which concept allows multiple forms of a method to exist in a program?";
        strQs[7][1] = "Abstraction";
        strQs[7][2] = "Polymorphism.";
        strQs[7][3] = "Encapsulation";
        strQs[7][4] = "Inheritance";
        strAs[7] = "2"; // SB: 

        strQs[8][0] = "Interfaces in Java can contain:";
        strQs[8][1] = "Only private methods";
        strQs[8][2] = "Abstract methods and final variables";
        strQs[8][3] = "Constructors";
        strQs[8][4] = "Static variables and static methods.";
        strAs[8] = "4"; // SB: 

        strQs[9][0] = "What is the main use of the instanceof operator in Java?";
        strQs[9][1] = "To convert types at runtime";
        strQs[9][2] = "To compare two objects";
        strQs[9][3] = "To check if an object is an instance of a particular class or subclass.";
        strQs[9][4] = "To create new objects";
        strAs[9] = "3"; // SB: 

        strQs[10][0] = "What happens if a subclass does not implement all abstract methods from an abstract class?";
        strQs[10][1] = "It is automatically compiled";
        strQs[10][2] = "It must be declared abstract.";
        strQs[10][3] = "It throws a runtime exception";
        strQs[10][4] = "It will inherit default implementations";
        strAs[10] = "2"; // SB: 

        strQs[11][0] = "Which of the following correctly defines a class implementing multiple interfaces?";
        strQs[11][1] = "class A implements B, C {}.";
        strQs[11][2] = "class A implements B + C {}";
        strQs[11][3] = "class A extends B, C {}";
        strQs[11][4] = "class A imports B, C {}";
        strAs[11] = "1"; // SB: 

        strQs[12][0] = "What is true about final classes in Java?";
        strQs[12][1] = "They cannot contain methods";
        strQs[12][2] = "They can only be extended, not instantiated";
        strQs[12][3] = "They cannot be subclassed.";
        strQs[12][4] = "They must be abstract";
        strAs[12] = "3"; // SB: 

        strQs[13][0] = "Which design principle does inheritance violate if used excessively?";
        strQs[13][1] = "Single Responsibility Principle.";
        strQs[13][2] = "Liskov Substitution Principle";
        strQs[13][3] = "DRY (Don’t Repeat Yourself)";
        strQs[13][4] = "Law of Demeter";
        strAs[13] = "1"; // SB: 

        strQs[14][0] = "What is dynamic method dispatch?";
        strQs[14][1] = "Calling a method defined in an interface";
        strQs[14][2] = "Deciding which method to call at compile-time";
        strQs[14][3] = "Runtime decision of which overridden method to call.";
        strQs[14][4] = "Static binding of method names";
        strAs[14] = "3"; // SB: 

        strQs[15][0] = "Which of the following is not a valid reason to use an interface?";
        strQs[15][1] = "To achieve multiple inheritance";
        strQs[15][2] = "To allow unrelated classes to implement the same behavior";
        strQs[15][3] = "To reduce object size.";
        strQs[15][4] = "To define behavior contracts";
        strAs[15] = "3"; // SB: 

        strQs[16][0] = "What is the main purpose of the this keyword?";
        strQs[16][1] = "Refers to the superclass";
        strQs[16][2] = "Refers to the current class";
        strQs[16][3] = "Refers to the current object.";
        strQs[16][4] = "Refers to the static context";
        strAs[16] = "3"; // SB: 

        strQs[17][0] = "If a class inherits a method from a superclass, but also defines its own method with the same signature, what is happening?";
        strQs[17][1] = "Overriding.";
        strQs[17][2] = "Overloading";
        strQs[17][3] = "Inheriting";
        strQs[17][4] = "Shadowing";
        strAs[17] = "1"; // SB: 
        
        strQs[18][0] = "What will happen if you try to override a method declared as final in the superclass?";
        strQs[18][1] = "It will compile and run successfully";
        strQs[18][2] = "The method will be hidden, not overridden";
        strQs[18][3] = "The final method will be replaced at runtime";
        strQs[18][4] = "It will result in a compile-time error.";
        strAs[18] = "4"; // SB: 

        strQs[19][0] = "What happens if a subclass does not implement all abstract methods from an abstract class?";
        strQs[19][1] = "It must be declared abstract. ";
        strQs[19][2] = "It is automatically compiled  ";
        strQs[19][3] = "It throws a runtime exception ";
        strQs[19][4] = "It will inherit default implementation";
        strAs[19] = "1"; // SB: 

        prizes[0] = "Keep your sack";
        prizes[1] = "Decorated sack";
        prizes[2] = "Decorated sack full of candy";        
    }

    // SB: This method prints a simple sack
    public static void printSack() {

        System.out.println("    __________");
        System.out.println("   /          \\");
        System.out.println("  /            \\");
        System.out.println(" /              \\");
        System.out.println("|                |");
        System.out.println("|                |");
        System.out.println("|      SACK      |");
        System.out.println("|                |");
        System.out.println("|                |");
        System.out.println("\\________________/");
        System.out.println(" \\______________/" );
    }

    // SB: This method prints a decorated sack
    public static void printDecoratedSack() {

        System.out.println("    __________");
        System.out.println("   /  *..*..  \\");
        System.out.println("  /  .*..*..*  \\");
        System.out.println(" /  *..*..*..*  \\");
        System.out.println("|   ..*..*..*.   |");
        System.out.println("|    *..*..*.    |");
        System.out.println("|      SACK      |");
        System.out.println("|    *..*..*.    |");
        System.out.println("|   ..*..*..*.   |");
        System.out.println("\\________________/");
        System.out.println(" \\**************/" );
    }

    // SB: This method prints a decorated sack full of candy
    public static void printDecoratedCandySack() {

        System.out.println("    __________");
        System.out.println("   /  *..*..  \\");
        System.out.println("  /  .*..*..*  \\");
        System.out.println(" /  *..*..*..*  \\");
        System.out.println("|   *..*..*..    |");
        System.out.println("|    *..*..*     |");
        System.out.println("|   CANDY SACK   |");
        System.out.println("|    *..*..*     |");
        System.out.println("|   *..*..*..    |");
        System.out.println("\\~~~~~~~~~~~~~~~~/");
        System.out.println(" \\**************/");
        System.out.println("  \\____________/" );
    }


    /****************************************************************************************************************
     *  
     * BELOW THIS LINE IS MR. HUDSON'S 'HELPING' CODE 
     * Each routine below is commented -- so read for full understanding, here is
     * a short description of each routine included below: 
     * 
     * pauseToContinue - used to pause the program and then the user presses enter
     * to continue. 
     * getString - used to get String input from the user. 
     * getInt - used to get a valid integer input from the user. 
     * getDbl - used to get a valid double (decimal values) input from the user. 
     * checkNum - used to verify a string only has numeric values in it. 
     * checkIntNum - used to check if a string value is a valid number within an
     * integer range. 
     * checkDblNum - used to check if a string value is a valid number within a
     * double range. 
     ****************************************************************************************************************/

    /***
     * This is a 'pause' routine to allow the user to just hit "enter" to 
     * continue with your programs can be used in multiple ways/locations. 
     * You can send in a message to the user and whether you want to clear 
     * the screen 'flush' before continuing. 
     */

    public static void pauseToContinue(String message, boolean clearBeforeContinue) {
        // This is just to allow the user to review anything on screen
        //   before clearing the screen and returning them to the main menu.

        getString(message, true, -1, -1);
        if (clearBeforeContinue) {
            // These next two lines will clear the terminal window in BlueJ and will
            // also clear the execution area on Repl.it or GDB online. (Fully explained
            // above.)
            System.out.print("\033[H\033[2J\f");
            System.out.flush();
        }
    }

    /***
     * SB: This is a 'pause' routine to allow the user to respond with a choice before flushing the screen 
     */
    public static String pauseAndContinue(String message, boolean clearBeforeContinue, int minLength) {

        // SB: Use the "message" to prompt the user, and gather their input back
        String msg = "";
        
        // SB: if the user provided a postive minlenth value, then ensure the minLength is honored
        if (minLength > 0) {
            msg = getString(message, false, minLength, -1);
        }
        else {
            msg = getString(message, true, -1, -1);
        }

        // SB: if the flag to clear is set
        if (clearBeforeContinue) {
            // These next two lines will clear the terminal window in BlueJ and will
            // also clear the execution area on Repl.it or GDB online. (Fully explained
            // above.)
            System.out.print("\033[H\033[2J\f");
            System.out.flush();
        }
        // SB: Return the user response so the appropriate course of action can be determined
        return msg;
    }    

    /***
     * This is used to get a valid string input from the user, used whenever I need user input.
     * You send in the sMessage containing what you are asking the user for, next is a boolean value as to whether 
     * an empty string is okay input or not 
     * (emptyOK -- true means an empty string is fine, false means need something). 
     * You can also send in a minimum or maximum length needed for the string -- 
     * if -1 is sent for either then the length of the string is not checked. 
     * In the end the return value is a string based on the criteria sent. 
     */
    public static String getString(String sMessage, boolean emptyOK, int intMinChar, int intMaxChar) {
        // Setup the scanner for user input via the keyboard.
        Scanner keyInput = new Scanner(System.in);

        // Temp string to hold user's input until it is valid
        String strTemp = "";

        // Boolean variable to know whether we can end the user input loop.
        boolean blnLeaveLoop;
        do {
            // Getting the user's input to be stored in the strTemp variable.
            System.out.print(sMessage);
            strTemp = keyInput.nextLine();

            // Make the assumption that the input is good -- switch to false if there is an
            // issue.
            blnLeaveLoop = true;

            // Checking if empty string (and whether we need to check this).
            if (strTemp.length() == 0 && !emptyOK) {
                System.out.println("You need to enter something!");
                blnLeaveLoop = false;
            }

            // Checking if they care about how short the string is (minimum number of
            // characters).
            if (intMinChar != -1 && strTemp.length() < intMinChar) {
                System.out.println("Your input needs to have at least " + intMinChar + " characters.");
                blnLeaveLoop = false;
            }

            // Checking if they care about how long the string is (maximum number of
            // characters).
            if (intMaxChar != -1 && strTemp.length() > intMaxChar) {
                System.out.println("Your input needs to have less than or equal to " + intMaxChar + " characters.");
                blnLeaveLoop = false;
            }
        } while (!blnLeaveLoop);

        // ************************************************************************************************************
        // NOTE -- if you get an error in an online environment -- comment out the code
        // line below.

        // ************************************************************************************************************
        // keyInput.close();
        // Out of the input loop now -- so return the input -- it meets the
        // requirements.
        return strTemp;
    }

    /**
     * This is used to get input from the user in the form of an integer. 
     * A message is sent to this routine asking the user for integer input. 
     * A lowNum value should be sent as the lowest number allowed as well as 
     * a highNum value is sent to represent the largest value allowed as input. 
     * In the end a valid integer is  returned based on the parameters sent 
     * in and outlined. 
     */
    public static int getInt(String sMessage, int lowNum, int highNum) {
        // Temp string to hold the user's input until it is valid.
        String strTemp = "";
        // Boolean to keep user in loop until input is valid
        boolean blnValidInput = true;
        // Loop to ensure the user enters an integer and in the correct range.
        do {
            // Getting input -- by calling my getString routine, I send in the message to
            // ask the user as well as false for not allowing an empty string. 
            // The next two parameters use the length of the range values sent
            // to determine the length of the string input.
            strTemp = getString(sMessage, false, 1,
                    Math.max(Integer.toString(lowNum).length(), Integer.toString(highNum).length()));
            // Using the checkInt routine to verify a number.

            if (checkNum(strTemp, 0)) {
                // Checking the number is in the right range. 
                if (checkIntNum(strTemp, lowNum, highNum)) {
                    blnValidInput = true;
                } else {

                    // It's not so let the user know.
                    System.out.println("Please enter a value between " + lowNum + " and " + highNum + ".");
                    blnValidInput = false;
                }
            } else {

                // If it got here there's other issues -- like not being a valid integer.
                System.out.println(
                        "Your input: " + strTemp + " is not a valid integer, please read carefully and try again.");
                blnValidInput = false;
            }
        } while (!blnValidInput);

        // Done the input loop -- send back the valid integer input.
        return Integer.parseInt(strTemp);
    }

    /**
     *  * This is used to get input from the user in the form of a double. A message
     * is sent to this routine 
     * * asking the user for decimal numeric input. A lowNum value should be sent as
     * the lowest number 
     * * allowed as well as a highNum value is sent to represent the largest value
     * allowed as input. In the 
     * * end a valid double value is returned based on the parameters sent in and
     * outlined. 
     */
    public static double getDbl(String sMessage, double lowNum, double highNum) {
        // Temp string to hold the user's input until it is valid.
        String strTemp = "";
        // Boolean to keep user in loop until input is valid 
        boolean blnValidInput = true;
        // Loop to ensure the user enters an integer and in the correct range.
        do {
            // Getting input -- by calling my getString routine, I send in the message to
            // ask the user as well as false
            //   for not allowing an empty string. The next two parameters use the length of
            // the range values sent
            //   to determine the length of the string input.
            strTemp = getString(sMessage, false, 1,
                    3 * Math.max(Double.toString(lowNum).length(), Double.toString(highNum).length()));
            // Using the checkInt routine to verify a number.
            if (checkNum(strTemp, 1)) {
                // Checking the number is in the right range.
                if (checkDblNum(strTemp, lowNum, highNum)) {
                    blnValidInput = true;
                } else {
                    // It's not so let the user know. 
                    System.out.println("Please enter a value between " + lowNum + " and " + highNum + ".");
                    blnValidInput = false;
                }
            } else {
                // If it got here there's other issues -- like not being a valid integer. 
                System.out.println(
                        "Your input: " + strTemp + " is not a valid integer, please read carefully and try again.");
                blnValidInput = false;
            }
        } while (!blnValidInput);

        // Done the input loop -- send back the valid integer input.
        return Double.parseDouble(strTemp);
    }

    /***
     * This is used to error check a string value (sNum sent to the function) to
     * verify that it is an integer 
     * * style number (no decimals). It will receive a string value to check and
     * will return true or false
     * * based on its validity in terms of being an integer. 
     */
    public static boolean checkNum(String sNum, int numDecimals) {
        // Initialize the valid input to false -- assume bad data first and then change
        // if all is good.
        boolean validInput = false;
        // Counters and variables to check for integer validity.
        //   posNegCount keeps track of how many + or - characters are in the string.
        //   posNegPos keeps track of the last position of a + or - found -- should only
        // be 0.
        //   decimalCount keeps track of the number of '.' entered -- should stay at 0
        // for integers
        //   nonNumCount keeps track of how many non numeric characters there were --
        // should be 0 for numbers.
        int posNegCount = 0, posNegPos = -1, decimalCount = 0, nonNumCount = 0;
        // Loop to look at all the characters in the string input and update the counter
        // variables as appropriate.
        for (int i = 0; i < sNum.length(); i++) {
            // Based on what the current character is do....
            switch (sNum.charAt(i)) {
                // Current character is a decimal -- so add one to that counter.
                case '.':
                    decimalCount++;
                    break;
                // Current character is a + or - sign -- so add one to that counter and update
                // the position
                //   where it was found. 
                case '-':
                case '+':
                    posNegCount++;
                    posNegPos = i;
                    break;

                // Current character is a numeric value so do nothing it's okay nothing to do
                // here. 
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                // Anything else caught here is a non-numeric character (at least for this
                // program's purposes). 
                default:
                    nonNumCount++;

            }
        }

        // Now check the results to see if it was valid -- need 1 or 0 +/- sign
        // characters and they can only
        //   occur in position 0 of the input. 
        if (posNegCount <= 1 && posNegPos <= 0) {
            // We want to ensure there were no non-numeric characters 
            if (nonNumCount <= 0) {
                // We want there to be 0 decimal points for integers, maximum 1 for doubles. 
                if (decimalCount <= numDecimals) {
                    // Can't allow just 1 + (or -) sign or 1 decimal point, causing the program to
                    // crash.
                    if (!(posNegCount == 1 && sNum.length() == 1) && !(decimalCount == 1 && sNum.length() == 1)) {
                        // If we make it here, all is good. It's an integer style number.
                        validInput = true;
                    }
                }
            }
        }

        // Send back the validity of the string in terms of it being an integer or not.
        return validInput;
    }

    /**
     *  * This is used to verify that information sent to this function is a valid
     * integer within a specified
     *  * range.  Sent to this routine are:  the string version of the number to
     * check (sNum), the lowest value 
     * * allowed for the number (lowNum), the high value allowed for the number
     * (highNum). Returns true or false 
     * * as to the validity of the 'sNum' sent to the function. 
     */
    public static boolean checkIntNum(String sNum, int lowNum, int highNum) {
        // Temp long to hold the string's value for size checking.
        long lngTemp = 0;
        // Boolean to hold whether the input is valid.
        boolean blnValidInput = true;

        // Using the checkInt routine to verify a number.
        if (checkNum(sNum, 0)) {
            // Storing the number -- as a long temporarily to allow for overflow on the
            // integer datatype.
            //   Hopefully the programmer using this code set appropriate limit values and
            // by the end
            //   can successfully return an integer value.
            lngTemp = Long.parseLong(sNum);
            // Checking the number is in the right range.
            if (lngTemp < lowNum || lngTemp > highNum) {
                blnValidInput = false;
            }
            // All good -- return true
            else {
                blnValidInput = true;
            }
        }
        // Was not a valid number (integer)
        else {
            blnValidInput = false;
        }
        // return the status of the input.
        return blnValidInput;

    }

    /**
     *  * This is used to verify that information sent to this function is a valid
     * double within a specified
     *  * range.  Sent to this routine are:  the string version of the number to
     * check (sNum), the lowest value
     *  * allowed for the number (lowNum), the high value allowed for the number
     * (highNum). Returns true or false 
     * * as to the validity of the 'sNum' sent to the function. 
     */
    public static boolean checkDblNum(String sNum, double lowNum, double highNum) {
        // Temp long to hold the string's value for size checking.
        double dblTemp = 0;
        // Boolean to hold whether the input is valid.
        boolean blnValidInput = true;
        // Using the checkInt routine to verify a number.
        if (checkNum(sNum, 1)) {
            // Storing the number -- as a long temporarily to allow for overflow on the
            // integer datatype.
            //   Hopefully the programmer using this code set appropriate limit values and
            // by the end
            //   can successfully return an integer value.dblTemp =
            // Double.parseDouble(sNum);
            // Checking the number is in the right range.
            if (dblTemp < lowNum || dblTemp > highNum) {
                blnValidInput = false;
            }
            // All good -- return true
            else {
                blnValidInput = true;
            }
        }
        // Was not a valid number (integer)
        else {
            blnValidInput = false;
        }
        // return the status of the input.
        return blnValidInput;
    }
}