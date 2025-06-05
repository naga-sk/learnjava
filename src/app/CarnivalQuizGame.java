package app;

//Shared May 15th, 2025//Skeleton Code for Quiz Program
// //This imports the required library of commands to access the common
// //utilities and the input and output commands.
// 

import java.util.*;

/**  * This skeleton must be used for your Final Computer Quiz Program  */
public class CarnivalQuizGame {
    
    /** * This is the main routine where you will put your code for this  assignment. */
    public static void main(String[] args) {

        // These next two lines will clear the terminal window in BlueJ and will
        // //also clear the execution area on GDB online.
        System.out.print("\033[H\033[2J\f");
        System.out.flush();

        // Title for the main program.
        System.out.println("ICS 3U1 Computer Quiz Program.");

        // Declaring the 2D array that will hold the set of questions to use.
        String[][] strQuestions = new String[20][5];

        // Loop for the current topic.
        do {

            // Initial setup calls "initialize" to ensure the string array is empty.
            //   Stores nothing ("") in all spots in the 2D array.
            initialize(strQuestions, "");

            // Used in the random number generation and loop end detection.
            int iNumQs = strQuestions.length;

            // Get the user input for which topic to select.
            int iSection = getInt(
                    "Please select the 'Section' (or 'Topic') you want the questions to be based on:\n(1 - Section 1, 2 - Section 2, and 3 - Section 3)",
                    1, 3);

            // Based on the topic number, call the method and load the correct set of
            // questions.
            switch (iSection) {
                case 1:

                    // Call method for section/topic 1
                    fillArrayTopic1(strQuestions);
                    break;

                case 2:
                    // Call method for section/topic 2
                    fillArrayTopic2(strQuestions);
                    break;

                case 3:
                    // Call method for section/topic 3
                    fillArrayTopic3(strQuestions);
                    break;

                default:
                    // Should not happen -- but you can add any code for this situation.
            }

            // This variable keeps track of what the current questions number we are at.
            int iQCount = 0;

            // Loop to do the random questions.
            do {
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
                System.out.println("Question #" + iQCount + " -- " + strQuestions[iRandQ][0]);

                // Clear that question so it is not selected again.
                strQuestions[iRandQ][0] = "";

                // This shows the four options -- if you want letters for options instead of
                // numbers
                // it can be done as well, ask and I can show it.
                for (int i = 1; i < strQuestions[0].length; i++) {

                    // Displays the options as numbers -- you can add a "\n" for extra spacing.
                    System.out.println("Option #" + i + ": " + strQuestions[iRandQ][i]);

                    // Displays the options – this line will show lowercase “a”, “b”, “c” and “d”.
                    System.out.println("Option #" + (char) (i + 'a' - 1) + ": " + strQuestions[iRandQ][i]);

                    // Displays the options – this line will show uppercase “A”, “B”, “C” and “D”.
                    System.out.println("Option #" + (char) (i + 'A' - 1) + ": " + strQuestions[iRandQ][i]);
                }

                // Keep looping while we have not used all the questions or while the user wants
                // to see more questions.
            } while (iQCount != iNumQs && getString(
                    "Would you like to see a different random question? (Enter y for 'yes' to see another question -- anything else exits.)",
                    true, -1, -1).equalsIgnoreCase("y"));

            // This is just here to tell the user that all of the questions have been used
            // -- it should not be
            // needed in your program (unless you wish to allow up to the total number of
            // questions).

            if (iQCount == iNumQs) {
                System.out.println("All questions in this topic have been used. Please try a new topic.");
            }

            // Loop the whole thing if they wish to try another topic.
        } while (getString(
                "Would you like to select a different 'Section' or 'Topic'? (Enter y for 'yes' to play again -- anything else exits.)",
                true, -1, -1).equalsIgnoreCase("y"));
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

    // Loads the array sent in with the first topic content.
    private static void fillArrayTopic1(String strQs[][]) {
        strQs[0][0] = "What programming language did we use most during this course?";
        strQs[0][1] = "Java";
        strQs[0][2] = "Python";
        strQs[0][3] = "C#";
        strQs[0][4] = "Visual Basic";
        strQs[1][0] = "Section 1-Question 02";
        strQs[1][1] = "Section 1-Q02 - Option 01";
        strQs[1][2] = "Section 1-Q02 - Option 02";
        strQs[1][3] = "Section 1-Q02 - Option 03";
        strQs[1][4] = "Section 1-Q02 - Option 04";
        strQs[2][0] = "Section 1-Question 03";
        strQs[2][1] = "Section 1-Q03 - Option 01";
        strQs[2][2] = "Section 1-Q03 - Option 02";
        strQs[2][3] = "Section 1-Q03 - Option 03";
        strQs[2][4] = "Section 1-Q03 - Option 04";
        strQs[3][0] = "Section 1-Question 04";
        strQs[3][1] = "Section 1-Q04 - Option 01";
        strQs[3][2] = "Section 1-Q04 - Option 02";
        strQs[3][3] = "Section 1-Q04 - Option 03";
        strQs[3][4] = "Section 1-Q04 - Option 04";
        strQs[4][0] = "Section 1-Question 05";
        strQs[4][1] = "Section 1-Q05 - Option 01";
        strQs[4][2] = "Section 1-Q05 - Option 02";
        strQs[4][3] = "Section 1-Q05 - Option 03";
        strQs[4][4] = "Section 1-Q05 - Option 04";
        strQs[5][0] = "Section 1-Question 06";
        strQs[5][1] = "Section 1-Q06 - Option 01";
        strQs[5][2] = "Section 1-Q06 - Option 02";
        strQs[5][3] = "Section 1-Q06 - Option 03";
        strQs[5][4] = "Section 1-Q06 - Option 04";
        strQs[6][0] = "Section 1-Question 07";
        strQs[6][1] = "Section 1-Q07 - Option 01";
        strQs[6][2] = "Section 1-Q07 - Option 02";
        strQs[6][3] = "Section 1-Q07 - Option 03";
        strQs[6][4] = "Section 1-Q07 - Option 04";
        strQs[7][0] = "Section 1-Question 08";
        strQs[7][1] = "Section 1-Q08 - Option 01";
        strQs[7][2] = "Section 1-Q08 - Option 02";
        strQs[7][3] = "Section 1-Q08 - Option 03";
        strQs[7][4] = "Section 1-Q08 - Option 04";
        strQs[8][0] = "Section 1-Question 09";
        strQs[8][1] = "Section 1-Q09 - Option 01";
        strQs[8][2] = "Section 1-Q09 - Option 02";
        strQs[8][3] = "Section 1-Q09 - Option 03";
        strQs[8][4] = "Section 1-Q09 - Option 04";
        strQs[9][0] = "Section 1-Question 10";
        strQs[9][1] = "Section 1-Q10 - Option 01";
        strQs[9][2] = "Section 1-Q10 - Option 02";
        strQs[9][3] = "Section 1-Q10 - Option 03";
        strQs[9][4] = "Section 1-Q10 - Option 04";
        strQs[10][0] = "Section 1-Question 11";
        strQs[10][1] = "Section 1-Q11 - Option 01";
        strQs[10][2] = "Section 1-Q11 - Option 02";
        strQs[10][3] = "Section 1-Q11 - Option 03";
        strQs[10][4] = "Section 1-Q11 - Option 04";
        strQs[11][0] = "Section 1-Question 12";
        strQs[11][1] = "Section 1-Q12 - Option 01";
        strQs[11][2] = "Section 1-Q12 - Option 02";
        strQs[11][3] = "Section 1-Q12 - Option 03";
        strQs[11][4] = "Section 1-Q12 - Option 04";
        strQs[12][0] = "Section 1-Question 13";
        strQs[12][1] = "Section 1-Q13 - Option 01";
        strQs[12][2] = "Section 1-Q13 - Option 02";
        strQs[12][3] = "Section 1-Q13 - Option 03";
        strQs[12][4] = "Section 1-Q13 - Option 04";
        strQs[13][0] = "Section 1-Question 14";
        strQs[13][1] = "Section 1-Q14 - Option 01";
        strQs[13][2] = "Section 1-Q14 - Option 02";
        strQs[13][3] = "Section 1-Q14 - Option 03";
        strQs[13][4] = "Section 1-Q14 - Option 04";
        strQs[14][0] = "Section 1-Question 15";
        strQs[14][1] = "Section 1-Q15 - Option 01";
        strQs[14][2] = "Section 1-Q15 - Option 02";
        strQs[14][3] = "Section 1-Q15 - Option 03";
        strQs[14][4] = "Section 1-Q15 - Option 04";
        strQs[15][0] = "Section 1-Question 16";
        strQs[15][1] = "Section 1-Q16 - Option 01";
        strQs[15][2] = "Section 1-Q16 - Option 02";
        strQs[15][3] = "Section 1-Q16 - Option 03";
        strQs[15][4] = "Section 1-Q16 - Option 04";
        strQs[16][0] = "Section 1-Question 17";
        strQs[16][1] = "Section 1-Q17 - Option 01";
        strQs[16][2] = "Section 1-Q17 - Option 02";
        strQs[16][3] = "Section 1-Q17 - Option 03";
        strQs[16][4] = "Section 1-Q17 - Option 04";
        strQs[17][0] = "Section 1-Question 18";
        strQs[17][1] = "Section 1-Q18 - Option 01";
        strQs[17][2] = "Section 1-Q18 - Option 02";
        strQs[17][3] = "Section 1-Q18 - Option 03";
        strQs[17][4] = "Section 1-Q18 - Option 04";
        strQs[18][0] = "Section 1-Question 19";
        strQs[18][1] = "Section 1-Q19 - Option 01";
        strQs[18][2] = "Section 1-Q19 - Option 02";
        strQs[18][3] = "Section 1-Q19 - Option 03";
        strQs[18][4] = "Section 1-Q19 - Option 04";
        strQs[19][0] = "Section 1-Question 20";
        strQs[19][1] = "Section 1-Q20 - Option 01";
        strQs[19][2] = "Section 1-Q20 - Option 02";
        strQs[19][3] = "Section 1-Q20 - Option 03";
        strQs[19][4] = "Section 1-Q20 - Option 04";
    }

    // Loads the array sent in with the second topic content.
    private static void fillArrayTopic2(String strQs[][]) {
        strQs[0][0] = "Section 2-Question 01";
        strQs[0][1] = "Section 2-Q01 - Option 01";
        strQs[0][2] = "Section 2-Q01 - Option 02";
        strQs[0][3] = "Section 2-Q01 - Option 03";
        strQs[0][4] = "Section 2-Q01 - Option 04";
        strQs[1][0] = "Section 2-Question 02";
        strQs[1][1] = "Section 2-Q02 - Option 01";
        strQs[1][2] = "Section 2-Q02 - Option 02";
        strQs[1][3] = "Section 2-Q02 - Option 03";
        strQs[1][4] = "Section 2-Q02 - Option 04";
        strQs[2][0] = "Section 2-Question 03";
        strQs[2][1] = "Section 2-Q03 - Option 01";
        strQs[2][2] = "Section 2-Q03 - Option 02";
        strQs[2][3] = "Section 2-Q03 - Option 03";
        strQs[2][4] = "Section 2-Q03 - Option 04";
        strQs[3][0] = "Section 2-Question 04";
        strQs[3][1] = "Section 2-Q04 - Option 01";
        strQs[3][2] = "Section 2-Q04 - Option 02";
        strQs[3][3] = "Section 2-Q04 - Option 03";
        strQs[3][4] = "Section 2-Q04 - Option 04";
        strQs[4][0] = "Section 2-Question 05";
        strQs[4][1] = "Section 2-Q05 - Option 01";
        strQs[4][2] = "Section 2-Q05 - Option 02";
        strQs[4][3] = "Section 2-Q05 - Option 03";
        strQs[4][4] = "Section 2-Q05 - Option 04";
        strQs[5][0] = "Section 2-Question 06";
        strQs[5][1] = "Section 2-Q06 - Option 01";
        strQs[5][2] = "Section 2-Q06 - Option 02";
        strQs[5][3] = "Section 2-Q06 - Option 03";
        strQs[5][4] = "Section 2-Q06 - Option 04";
        strQs[6][0] = "Section 2-Question 07";
        strQs[6][1] = "Section 2-Q07 - Option 01";
        strQs[6][2] = "Section 2-Q07 - Option 02";
        strQs[6][3] = "Section 2-Q07 - Option 03";
        strQs[6][4] = "Section 2-Q07 - Option 04";
        strQs[7][0] = "Section 2-Question 08";
        strQs[7][1] = "Section 2-Q08 - Option 01";
        strQs[7][2] = "Section 2-Q08 - Option 02";
        strQs[7][3] = "Section 2-Q08 - Option 03";
        strQs[7][4] = "Section 2-Q08 - Option 04";
        strQs[8][0] = "Section 2-Question 09";
        strQs[8][1] = "Section 2-Q09 - Option 01";
        strQs[8][2] = "Section 2-Q09 - Option 02";
        strQs[8][3] = "Section 2-Q09 - Option 03";
        strQs[8][4] = "Section 2-Q09 - Option 04";
        strQs[9][0] = "Section 2-Question 10";
        strQs[9][1] = "Section 2-Q10 - Option 01";
        strQs[9][2] = "Section 2-Q10 - Option 02";
        strQs[9][3] = "Section 2-Q10 - Option 03";
        strQs[9][4] = "Section 2-Q10 - Option 04";
        strQs[10][0] = "Section 2-Question 11";
        strQs[10][1] = "Section 2-Q11 - Option 01";
        strQs[10][2] = "Section 2-Q11 - Option 02";
        strQs[10][3] = "Section 2-Q11 - Option 03";
        strQs[10][4] = "Section 2-Q11 - Option 04";
        strQs[11][0] = "Section 2-Question 12";
        strQs[11][1] = "Section 2-Q12 - Option 01";
        strQs[11][2] = "Section 2-Q12 - Option 02";
        strQs[11][3] = "Section 2-Q12 - Option 03";
        strQs[11][4] = "Section 2-Q12 - Option 04";
        strQs[12][0] = "Section 2-Question 13";
        strQs[12][1] = "Section 2-Q13 - Option 01";
        strQs[12][2] = "Section 2-Q13 - Option 02";
        strQs[12][3] = "Section 2-Q13 - Option 03";
        strQs[12][4] = "Section 2-Q13 - Option 04";
        strQs[13][0] = "Section 2-Question 14";
        strQs[13][1] = "Section 2-Q14 - Option 01";
        strQs[13][2] = "Section 2-Q14 - Option 02";
        strQs[13][3] = "Section 2-Q14 - Option 03";
        strQs[13][4] = "Section 2-Q14 - Option 04";
        strQs[14][0] = "Section 2-Question 15";
        strQs[14][1] = "Section 2-Q15 - Option 01";
        strQs[14][2] = "Section 2-Q15 - Option 02";
        strQs[14][3] = "Section 2-Q15 - Option 03";
        strQs[14][4] = "Section 2-Q15 - Option 04";
        strQs[15][0] = "Section 2-Question 16";
        strQs[15][1] = "Section 2-Q16 - Option 01";
        strQs[15][2] = "Section 2-Q16 - Option 02";
        strQs[15][3] = "Section 2-Q16 - Option 03";
        strQs[15][4] = "Section 2-Q16 - Option 04";
        strQs[16][0] = "Section 2-Question 17";
        strQs[16][1] = "Section 2-Q17 - Option 01";
        strQs[16][2] = "Section 2-Q17 - Option 02";
        strQs[16][3] = "Section 2-Q17 - Option 03";
        strQs[16][4] = "Section 2-Q17 - Option 04";
        strQs[17][0] = "Section 2-Question 18";
        strQs[17][1] = "Section 2-Q18 - Option 01";
        strQs[17][2] = "Section 2-Q18 - Option 02";
        strQs[17][3] = "Section 2-Q18 - Option 03";
        strQs[17][4] = "Section 2-Q18 - Option 04";
        strQs[18][0] = "Section 2-Question 19";
        strQs[18][1] = "Section 2-Q19 - Option 01";
        strQs[18][2] = "Section 2-Q19 - Option 02";
        strQs[18][3] = "Section 2-Q19 - Option 03";
        strQs[18][4] = "Section 2-Q19 - Option 04";
        strQs[19][0] = "Section 2-Question 20";
        strQs[19][1] = "Section 2-Q20 - Option 01";
        strQs[19][2] = "Section 2-Q20 - Option 02";
        strQs[19][3] = "Section 2-Q20 - Option 03";
        strQs[19][4] = "Section 2-Q20 - Option 04";
    }

    // Loads the array sent in with the third topic content.
    private static void fillArrayTopic3(String strQs[][]) {
        strQs[0][0] = "Section 3-Question 01";
        strQs[0][1] = "Section 3-Q01 - Option 01";
        strQs[0][2] = "Section 3-Q01 - Option 02";
        strQs[0][3] = "Section 3-Q01 - Option 03";
        strQs[0][4] = "Section 3-Q01 - Option 04";
        strQs[1][0] = "Section 3-Question 02";
        strQs[1][1] = "Section 3-Q02 - Option 01";
        strQs[1][2] = "Section 3-Q02 - Option 02";
        strQs[1][3] = "Section 3-Q02 - Option 03";
        strQs[1][4] = "Section 3-Q02 - Option 04";
        strQs[2][0] = "Section 3-Question 03";
        strQs[2][1] = "Section 3-Q03 - Option 01";
        strQs[2][2] = "Section 3-Q03 - Option 02";
        strQs[2][3] = "Section 3-Q03 - Option 03";
        strQs[2][4] = "Section 3-Q03 - Option 04";
        strQs[3][0] = "Section 3-Question 04";
        strQs[3][1] = "Section 3-Q04 - Option 01";
        strQs[3][2] = "Section 3-Q04 - Option 02";
        strQs[3][3] = "Section 3-Q04 - Option 03";
        strQs[3][4] = "Section 3-Q04 - Option 04";
        strQs[4][0] = "Section 3-Question 05";
        strQs[4][1] = "Section 3-Q05 - Option 01";
        strQs[4][2] = "Section 3-Q05 - Option 02";
        strQs[4][3] = "Section 3-Q05 - Option 03";
        strQs[4][4] = "Section 3-Q05 - Option 04";
        strQs[5][0] = "Section 3-Question 06";
        strQs[5][1] = "Section 3-Q06 - Option 01";
        strQs[5][2] = "Section 3-Q06 - Option 02";
        strQs[5][3] = "Section 3-Q06 - Option 03";
        strQs[5][4] = "Section 3-Q06 - Option 04";
        strQs[6][0] = "Section 3-Question 07";
        strQs[6][1] = "Section 3-Q07 - Option 01";
        strQs[6][2] = "Section 3-Q07 - Option 02";
        strQs[6][3] = "Section 3-Q07 - Option 03";
        strQs[6][4] = "Section 3-Q07 - Option 04";
        strQs[7][0] = "Section 3-Question 08";
        strQs[7][1] = "Section 3-Q08 - Option 01";
        strQs[7][2] = "Section 3-Q08 - Option 02";
        strQs[7][3] = "Section 3-Q08 - Option 03";
        strQs[7][4] = "Section 3-Q08 - Option 04";
        strQs[8][0] = "Section 3-Question 09";
        strQs[8][1] = "Section 3-Q09 - Option 01";
        strQs[8][2] = "Section 3-Q09 - Option 02";
        strQs[8][3] = "Section 3-Q09 - Option 03";
        strQs[8][4] = "Section 3-Q09 - Option 04";
        strQs[9][0] = "Section 3-Question 10";
        strQs[9][1] = "Section 3-Q10 - Option 01";
        strQs[9][2] = "Section 3-Q10 - Option 02";
        strQs[9][3] = "Section 3-Q10 - Option 03";
        strQs[9][4] = "Section 3-Q10 - Option 04";
        strQs[10][0] = "Section 3-Question 11";
        strQs[10][1] = "Section 3-Q11 - Option 01";
        strQs[10][2] = "Section 3-Q11 - Option 02";
        strQs[10][3] = "Section 3-Q11 - Option 03";
        strQs[10][4] = "Section 3-Q11 - Option 04";
        strQs[11][0] = "Section 3-Question 12";
        strQs[11][1] = "Section 3-Q12 - Option 01";
        strQs[11][2] = "Section 3-Q12 - Option 02";
        strQs[11][3] = "Section 3-Q12 - Option 03";
        strQs[11][4] = "Section 3-Q12 - Option 04";
        strQs[12][0] = "Section 3-Question 13";
        strQs[12][1] = "Section 3-Q13 - Option 01";
        strQs[12][2] = "Section 3-Q13 - Option 02";
        strQs[12][3] = "Section 3-Q13 - Option 03";
        strQs[12][4] = "Section 3-Q13 - Option 04";
        strQs[13][0] = "Section 3-Question 14";
        strQs[13][1] = "Section 3-Q14 - Option 01";
        strQs[13][2] = "Section 3-Q14 - Option 02";
        strQs[13][3] = "Section 3-Q14 - Option 03";
        strQs[13][4] = "Section 3-Q14 - Option 04";
        strQs[14][0] = "Section 3-Question 15";
        strQs[14][1] = "Section 3-Q15 - Option 01";
        strQs[14][2] = "Section 3-Q15 - Option 02";
        strQs[14][3] = "Section 3-Q15 - Option 03";
        strQs[14][4] = "Section 3-Q15 - Option 04";
        strQs[15][0] = "Section 3-Question 16";
        strQs[15][1] = "Section 3-Q16 - Option 01";
        strQs[15][2] = "Section 3-Q16 - Option 02";
        strQs[15][3] = "Section 3-Q16 - Option 03";
        strQs[15][4] = "Section 3-Q16 - Option 04";
        strQs[16][0] = "Section 3-Question 17";
        strQs[16][1] = "Section 3-Q17 - Option 01";
        strQs[16][2] = "Section 3-Q17 - Option 02";
        strQs[16][3] = "Section 3-Q17 - Option 03";
        strQs[16][4] = "Section 3-Q17 - Option 04";
        strQs[17][0] = "Section 3-Question 18";
        strQs[17][1] = "Section 3-Q18 - Option 01";
        strQs[17][2] = "Section 3-Q18 - Option 02";
        strQs[17][3] = "Section 3-Q18 - Option 03";
        strQs[17][4] = "Section 3-Q18 - Option 04";
        strQs[18][0] = "Section 3-Question 19";
        strQs[18][1] = "Section 3-Q19 - Option 01";
        strQs[18][2] = "Section 3-Q19 - Option 02";
        strQs[18][3] = "Section 3-Q19 - Option 03";
        strQs[18][4] = "Section 3-Q19 - Option 04";
        strQs[19][0] = "Section 3-Question 20";
        strQs[19][1] = "Section 3-Q20 - Option 01";
        strQs[19][2] = "Section 3-Q20 - Option 02";
        strQs[19][3] = "Section 3-Q20 - Option 03";
        strQs[19][4] = "Section 3-Q20 - Option 04";
    }

    /****************************************************************************************************************
     *  
     * * BELOW THIS LINE IS MR. HUDSON'S 'HELPING' CODE 
     * * Each routine below is commented -- so read for full understanding, here is
     * a short description of each 
     * * routine included below: 
     * * pauseToContinue - used to pause the program and then the user presses enter
     * to continue. 
     * * getString - used to get String input from the user. 
     * * getInt - used to get a valid integer input from the user. 
     * * getDbl - used to get a valid double (decimal values) input from the user. 
     * * checkNum - used to verify a string only has numeric values in it. 
     * * checkIntNum - used to check if a string value is a valid number within an
     * integer range. 
     * * checkDblNum - used to check if a string value is a valid number within a
     * double range. 
     ****************************************************************************************************************/

    /***
     * This is a 'pause' routine to allow the user to just hit "enter" to continue
     * with your 
     * * programs can be used in multiple ways/locations. You can send in a message
     * to the user 
     * and whether you want to clear the screen 'flush' before continuing. 
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
     * This is used to get a valid string input from the user, used whenever I need
     * user input.
     * * You send in the sMessage containing what you are asking the user for, next
     * is a boolean value as to whether 
     * * an empty string is okay input or not (emptyOK -- true means an empty string
     * is fine, false means need something). 
     * * You can also send in a minimum or maximum length needed for the string --
     * if -1 is sent for either then
     * * the length of the string is not checked. In the end the return value is a
     * string based on the criteria sent. 
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
            System.out.println(sMessage);
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
        keyInput.close();
        // Out of the input loop now -- so return the input -- it meets the
        // requirements.
        return strTemp;
    }

    /**
     *  * This is used to get input from the user in the form of an integer. A
     * message is sent to this routine 
     * * asking the user for integer input. A lowNum value should be sent as the
     * lowest number allowed as well as 
     * * a highNum value is sent to represent the largest value allowed as input. In
     * the end a valid integer is 
     * * returned based on the parameters sent in and outlined. 
     */
    public static int getInt(String sMessage, int lowNum, int highNum) {
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