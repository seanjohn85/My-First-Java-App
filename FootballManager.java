/* Ca2
 *
 Manager Game

 ********MIN WINDOW SIZE 100 width **************
 *
 John Kenny 04.12.14*/

//imports error handler to handle incompatable user input. *****see method playerSelect****
import java.util.InputMismatchException;

//imports keyboard input
import java.util.Scanner;

//imports Random feature
import java.util.Random;

public class FootballManager
{
    public static void main(String args[])
    {
        /*---------------Welcome Screen---------------*/

        //Adds keyboard input to our file.
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter Your Name: ");
        //Sets string name to what the user inputs
        String name= in.nextLine();
        //Prints the bolow information line by line
        System.out.println("Congratulations " + name + " you are now the new manager of \n");

        //Prints the below text art screen must be min 100 width!!

        System.out.println("  AN UT       DMAN        UTD       MAN U   AN UTD       MAN UT  AN UTDMAN UTDMAN U  MAN UTD");
        System.out.println("   UTDM       AN UT      TDMAN      N UTD    UTDMA       N UTDM   UTDM N UTDMAN UTD  N UTDMAN");
        System.out.println("    MAN        UT        MAN U       TDMAN   DMAN         TDM     DMA  UTD  N U  MA  UTDMAN UTD");
        System.out.println("    N UTD    UTDM       AN UTD       MAN UT  AN            AN     AN        UTD      DMAN   DMAN");
        System.out.println("    UTDMA    D AN        UT MAN      N UTDMA  UT            U      UT       DMA       N U   AN U");
        System.out.println("    DMAN U  MA  U      UTDMAN UT     UTDMAN  TDM           TD     TDM       AN        UTD    UTD");
        System.out.println("    AN UTDM N  TD      DMAN UTDM     DMA  UTDMAN           MAN    MAN        UT       DMA   TDMA");
        System.out.println("     U DMAN U  MAN    MAN    MAN     AN  TDMAN U           N U    N U       TDM      MAN   DMAN");
        System.out.println("    TDM N UTD AN U    N U      UT     UT  AN UTD           UTDMAN UT        MAN     AN UTDMAN UT");
        System.out.println("   DMAN  TDM N UTDM N UTDM   UTDMAN UTDMA  UTDMA            MAN UTD       MAN UTD    UTDMAN UTD");
        System.out.println("  MAN UT MA  UTDMAN UTDMAN   DMAN U DMAN    MAN               UTDM        N UTDMA   TDMAN UTD \n");

        System.out.println("After last years disappointment your minimum target is top four.");
        System.out.println("Anything less is unacceptable\nGood Luck " + name +"\n \n");



        /*------------------------------Information arrays----------------------------------*/

        /*The Below arrays contain the information for all the teams. This is the information the game reads.
         The index for the team matches the index for their team name, their staidum, their attack and defence, there goals and their points.
         The teams and stadium arrays do not change. With the exception of the user team (index 10) the attack and defence and change either.
         After each game the goal diffece and the points tab will change for each team, again this is matched to the index value ie. Arsenal are all things in the position 0*/

        //Array teams = index  0,           1,           2,         3,             4,            5,          6,             7,
        String teams [] = {"Arsenal\t\t", "Aston Villa\t", "Burnley\t\t", "Chelsea\t\t", "Crystal Palace\t", "Everton\t\t", "Hull City\t","Leicester City\t",
            //    8,             9,                  10,                  11,                 12,                13,          14,
            "Liverpool\t", "Manchester City\t", "Manchester United", "Newcastle United", "Queens Park Rangers", "Southampton\t", "Stoke City\t",
            //  15,           16,                 17,                  18,                   19,
            "Sunderland\t", "Swansea City\t", "Tottenham Hotspur", "West Bromwich Albion", "West Ham United\t"};

        //Array stadium = index         0,                1,            2,               3,                4,              5,               6,                   7,
        String stadium [] = {"The Emirates Stadium", "Villa Park", "Turf Moor", "Stamford Bridge", "Selhurst Park", "Goodison Park", "The KC Stadium","The King Power Stadium",
            //   8,              9,                 10",           11,              12,               13,                   14,
            "Anfield", "The Etihad Stadium", "Old Trafford", "St James' Park", "Loftus Road", "St Mary's Stadium", "The Britannia Stadium",
            //       15,                    16,                   17,                18,                    19,
            "The Stadium of Light", "The Liberty Stadium", "White Hart Lane", "The Hawthorns", "The Boleyn Ground (Upton Park)"};

        //Array defence = index  0,   1,   2,    3,  4,   5,    6,   7,   8,   9,  10,  11,  12,  13,  14,  15,  16,  17,  18,  19
        double defence[] =      {7.4, 5.9, 6.2, 8.7, 6.1, 7.3, 5.4, 4.9, 5.6, 8.3, 1.0, 6.4, 4.4, 7.7, 7.5, 5.9, 6.7, 6.7, 6.2, 6.9};

        //Array attack =index  0,   1,   2,    3,  4,   5,    6,   7,   8,   9,  10,  11,  12,  13,  14,  15,  16,  17,  18,  19
        double attack [] =   {8.4, 6.5, 6.2, 8.7, 7.2, 6.7, 6.7, 5.2, 6.1, 8.7, 1.0, 6.9, 5.8, 7.7, 6.4, 6.3, 7.2, 7.5, 6.1, 6.9};

        /* creates a goals array each teams goals are added to this array after each match.
         0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19*/
        int goals [] ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        /* creates a  points array each teams goals are added to this array after each match.
         0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19*/
        int points [] ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        /*This array is named date. This array matches up with the week count so the date changes each week. Index 0 is blank as there is no week 0
         see the for loop in game play to see how this is implemented*/
        String date [] ={"blank", "Sat 16th August", "Sun 24th August", "Sat 30th August", "Sun 14th September", "Sun 21st September", "Sat 27th September",
            "Sun 5th October", "Mon 20th October", "Sun 26th October", "Sun 2nd November", "Sat 8th November", "Sat 22nd November", "Sat 29th November",
            "Tue 2nd December", "Mon 8th December", "Sun 14th December", "Sat 20th December", "Fri 26th December", "Sun 28th December", "Thu 1st January",
            "Sun 11th January", "Sat 17th January", "Sat 31st January", "Sun 8th February", "Wed 11th February", "Sat 21st February", "Sat 28th February",
            "Wed 4th March", "Sat 14th March", "Sat 21st March", "Sat 4th April", "Sat 11th April", "Sat 18th April", "Sat 25th April", "Sat 2nd May",
            "Sat 9th May", "Sat 16th May", "Sun 24th May"};
        //Creates a boolean to indicate if a team is home or away in the score method
        boolean home = true;

        /*---------------------Arrays applied to the user's team (Manchester United)--------------------------*/

        /*The below two arrays hold the player the user can select and their ratings. These arrays are used by both the TeamSelector method and
         the teamName method. When the user selects the players the rating of the players are added up and adveraged in the Teamselector method,
         The defence and attack of the user team is then changed to match the average ratings of the user team.*/
        String manUPlayers [] = {"invalid", "1. David De Gea", "2. Rafael", "3. Luke Shaw", "4. Phil Jones", "5. Marcos Rojo", "6. Jonny Evans",
            "7. Angel Di Maria", "8. Juan Mata", "9. Radamel Falcao", "10. Wayne Rooney", "11. Adnan Januzaj", "12. Chris Smalling", "13. Anders Lindegaard",
            "14. Javier Hernandez", "15. James Wilson", "16. Michael Carrick", "17. Daley Blind", "18. Ashley Young", "19. Marouane Fellaini", "20. Robin van Persie", "21. Ander Herrera",
            "22. Nick Powell", "23. Tom Cleverley", "24. Darren Fletcher", "25. Antonio Valencia", "26. Paddy McNair", "27. Jesse Lingard", "28. Tyler Blackett",};

        double ratings [] = {0, 9.5, 7.4, 7.7, 7.4, 7.5, 7.2, 9.3, 8.5, 9.1, 9.1, 7.8, 7.2, 7.2, 7.8, 6.9, 8.1, 7.8, 7.3, 7.1, 9.1, 8.1, 6.9, 6.9, 5.9, 7.1, 7.2, 7.1, 7.0,};

        /*When the user selects a team in the teamSelector method the player is stored here as a number.
         The numbers stored here matches the player and index in the manUPlayers array above.
         The reason this array is necessary is when the user opts to name an unchanged team.
         This array is also used by the teamName method to print the starting 11 each week*/
        int starting11 [] = new int [11];
        // This is my the teamName method to print the position beside the player.
        String positions [] = {"Goalkeeper", "Leftback", "Rightback", "Centerback", "Centerback", "Left Wing", "Right Wing", "Defensive Center Midfielder", "Attacking Center Midfielder", "Striker", "Striker"};

        /*----------------------------Game Play------------------------------------*/

        //fixtures array the numbers 0 - 19 are used to match the index values of the teams arrays
        int fixture[] ={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        //This outer for loop it runs for 38 weeks enabling the game to run for 38 weeks.
        for(int week=1; week<=38; week++)
        {
   //impliments the stop method with time = 5000 (ie:5 seconds)
            stop(5000);
            //The week number is printed. The int week it is also used as an index point in the date array to get a date each week
            System.out.println("Week:\t" + week + "\nDate:\t" + date[week] + "\n");

            //Pick one week's fixtures
            /* for the first game the away team will be the last team.
             19 is in the index of the last team in the teams array.*/
            int teamB = 19;

            /* The below loop runs 10 times to give us 10 games a week.
             It is ran in a round robin format Please see:  http://en.wikipedia.org/wiki/Round-robin_tournament
             To simply put it it runs by setting team 0 to play 19, 1 to play 18 ect.
             In the loop team a couts up and team b counts back to achieve the above*/
            for(int teamA=0; teamA<=9; teamA++)
            {
                /*This fuction means that the same team will not play at home every week,
                 without this index 0 would always be home. */
                if(week%2==0)
                {
                    //Prints from the stadium array the stadium of the home team
                    System.out.println("Tonight's game takes place @ " +stadium[fixture[teamA]]);
                    //Uses the index values in the fixtures array to print the team names from the teams array
                    System.out.println(teams[fixture[teamA]] + " V " + teams[fixture[teamB]]);
                    //checks for the user team
                    if(fixture[teamA] ==10|| fixture[teamB]==10)
                    {
                        /*Runs the Method that allows the users to pick the team
                         matches our main arrays with the ones in the method this allows the Teamselector to
                         write the team to selected and change the user teams defence and attack*/
                        teamSelector(manUPlayers, ratings, starting11, week, attack, defence);
                        //This runs the teamName Method which prints the team based on the changes in the previous method*/
                        teamName (manUPlayers, starting11, positions);
                        /*Code used for testing only
                        System.out.println(defence[10] + " defence");
                        System.out.println(attack[10] + " attack");*/
                        System.out.println("\n"+teams[fixture[teamA]] + " V " + teams[fixture[teamB]]);
                    }
                    /*Uses the score method to create a match set the goalsH and goalsA
                     these values are then used for the score. this command also provides the score method with
                     the information of the attack and the defence of the the team playing using the attack and defence array, the fixture teamA and teamB
                    is used to indicate the index of the playing teams in these arrays. the home boolean then this the score array if the team is the hame team.*/
                    int goalsH = score(attack [fixture[teamA]], defence[fixture[teamB]], home = true);
                    int goalsA = score(attack [fixture[teamB]], defence[fixture[teamA]], home = false);

                    //prints the score
                    System.out.println(goalsH + " - " + goalsA + "\n");

                    //checks if the home team scored more than the away team
                    if(goalsH > goalsA)
                    {
                        //if ture adds 3 points to index of the home team in the points array.
                        points[fixture[teamA]] = points[fixture[teamA]] + 3;
                    }
                    //checks if the home team scored less than the away team
                    else if(goalsH < goalsA)
                    {
                        //if ture adds 3 points to index of the away team in the points array.
                        points[fixture[teamB]] = points[fixture[teamB]] + 3;
                    }
                    //If no team scored more goals than the other team then its a draw the only other match outcome.
                    else
                    {
                        //if none of the 2 previous ifs are true. 1 is added to the points array in the index value of both teams
                        points[fixture[teamB]] = points[fixture[teamB]] + 1;
                        points[fixture[teamA]] = points[fixture[teamA]] + 1;
                    }
                    //adds the goals conseeded by a team and the goals scored and stores this figure in the same index point as the team in the goals array
                    goals[fixture[teamA]] = goals[fixture[teamA]] + (goalsH - goalsA);
                    goals[fixture[teamB]] = goals[fixture[teamB]] + (goalsA - goalsH);
                }
                else
                {
                    //Prints from the stadium array the stadium of the home team
                    System.out.println("Tonight's game takes place @ " +stadium[fixture[teamB]]);
                    System.out.println(teams[fixture[teamB]] + " V " + teams[fixture[teamA]] );
                    //checks for the user team
                    if(fixture[teamA] ==10|| fixture[teamB]==10)
                    {
                        /*Runs the Method that allows the users to pick the team
                         matches our main arrays with the ones in the method this allows the Teamselector to
                         write the team to selected and change the user teams defence and attack*/
                        teamSelector(manUPlayers, ratings, starting11, week, attack, defence);
                        //This runs the teamName Method which prints the team based on the changes in the previous method*/
                        teamName (manUPlayers, starting11, positions);
                        /*Code used for testing only
                        System.out.println(defence[10] + " defence");
                        System.out.println(attack[10] + " attack");*/
                        System.out.println(teams[fixture[teamB]] + " V " + teams[fixture[teamA]] );
                    }
                    /*Uses the score method to create a match set the goalsH and goalsA
                     these values are then used for the score. this command also provides the score method with
                     the information of the attack and the defence of the the team playing using the attack and defence array, the fixture teamA and teamB
                    is used to indicate the index of the playing teams in these arrays. the home boolean then this the score array if the team is the hame team.*/
                    int goalsH = score(attack [fixture[teamB]], defence[fixture[teamA]], home = true);
                    int goalsA = score(attack [fixture[teamA]], defence[fixture[teamB]], home = false);
                    //prints the score
                    System.out.println(goalsH + " - " + goalsA+ "\n");

                    //checks if the home team scored more than the away team
                    if(goalsH > goalsA)
                    {
                        //if ture adds 3 points to index of the home team in the points array.
                        points[fixture[teamB]] = points[fixture[teamB]] + 3;
                    }
                    else if(goalsH < goalsA)
                    {
                        //if ture adds 3 points to index of the away team in the points array.
                        points[fixture[teamA]] = points[fixture[teamA]] + 3;
                    }
                    else
                    {
                        //if none of the 2 previous ifs are true. 1 is added to the points array in the index value of both teams
                        points[fixture[teamB]] = points[fixture[teamB]] + 1;
                        points[fixture[teamA]] = points[fixture[teamA]] + 1;
                    }
                    //adds the goals conseeded by a team and the goals scored and stores this figure in the same index point as the team in the goals array
                    goals[fixture[teamB]] = goals[fixture[teamB]] + (goalsH - goalsA);
                    goals[fixture[teamA]] = goals[fixture[teamA]] + (goalsA - goalsH);
                }
                /*Used for testing only
                Prints the team name goal difference and points of the team after theyve played using the fixture value as an index in the teams, goals and points arrays.
                System.out.println("Team:\t" + teams[fixture[teamB]] + "\t\tGoal difference:\t" + goals[fixture[teamB]]+ "\tPoints:\t" +points[fixture[teamB]] + "\n");
                System.out.println("Team:\t" + teams[fixture[teamA]] + "\t\tGoal difference:\t" + goals[fixture[teamA]]+ "\tPoints:\t" +points[fixture[teamA]] + "\n");*/

                teamB --;

                stop(3000);

            }
            //Rotate the teams

            /*safes the number in the array fixture in the index 19.
             This needs to be before the below for loop as the loop changes the index and */
            int lastTeamIndex = fixture[19];

            // This loop counts from 19 - 2 running 18 times.
            for (int move = 19;  move>=2; move --)
            {
                /* place the value in the index value move with the value in the previous index
                 * ie fixture[] ={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}
                 * will become fixture[] ={0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}
                 * */
                fixture[move]= fixture[move-1];
            }
            /*as index 1 is saved as lastTeamIndex indexbefore the loop is ran in is the index 1 od the fixtures array.
             * ie will finish as fixture[] ={0, 19, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}
             * the first time the loop is ran*/
            fixture[1]= lastTeamIndex;
            // Runs the leagueTable method feeding in the information from the teams, points, goals and week arrays
            leagueTable (teams, points, goals, week);

        } // Close week couter for loop
    }//Close main


    /*----------------------------Methods outside of main------------------------------------*/

    /*---------------------------- Stop Method ------------------------------------*/

//http://stackoverflow.com/questions/3342651/how-can-i-delay-a-java-program-for-a-few-seconds

//This method makes the program pause. The time is set in the main method.   1000 milliseconds is one second.

    public static void stop(int time)
    {
        try
        {
            //reads the time set in the main method when this method is actioned. the reson for this is the pauses can be altered at different points in the game
            Thread.sleep(time);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }//Closes stop Method

    /*----------------------------Score Gen Method------------------------------------*/

    //http://www.javamex.com/tutorials/random_numbers/gaussian_distribution_2.shtml

    //This method uses the information from the attack and defence method and the boolean home
    public static int score(double att, double def, boolean homeTeam)
    {
        //New random generater is set
        Random sigma = new Random();
        //teamScore is declared. This will be later returned in the main method and used are the the amount of goals a team has scored
        int teamScore = 0;
        //Checks if hometeam is true. This is set in the main method
        if(homeTeam)
        {
            /*This makes goals equal to a random number based on the gaussian of the attack minus defence of the teams playing. This is used for the
             * the home team and a slight home feild advantage is applied*/
            double goals = sigma.nextGaussian() * 1.8 + ((att-def)*.70)+.5;
            //converts goals from a double to an int
            teamScore = (int)(goals + 0.5);
        }
        //used for the away team
        else
        {
            /*This makes goals equal to a random number based on the gaussian of the attack minus defence of the teams playing. This is used for the
             * the away team and is made slightly harder to score.*/
            double goals = sigma.nextGaussian() * 1.6 + ((att-def)*.69)-.5;
            //converts goals from a double to an int
            teamScore = (int)(goals + 0.5);
        }
        //Sets min and max values for teamscore
        teamScore = Math.max(Math.min(8, teamScore),0);
        //Returns an int value to repersent goals this team has scored in this match
        return teamScore;
    }

    /*----------------------------User input player select Method------------------------------------*/

    /*http://chortle.ccsu.edu/java5/Notes/chap80/ch80_8.html
     *
     This method is used in the team selector method to selct the team. The team is selected by the user inputing a number. The below method
     is used to ensure that if the user doesnt enter a number that we dont get an error terminating the program.*/

    public static int playerSelect()
    {
        Scanner in = new Scanner(System.in);
        int playerSelected = 0 ;
        boolean userInput = false;
        //loop will run until the user enters a whole number.
        while ( !userInput )
        {
            System.out.print("\n");

            try
            {
                //sets playerSelected to the value to the user input
                playerSelected  = in.nextInt();
                // once a number is entered the boolean value is set to true ending the loop.
                userInput = true;
            }
            //This only comes into effect when the user enters data other than a number.
            catch (InputMismatchException  ex )
            {
                System.out.println("You entered bad data. The player must be one of the numbers listed above.\nPlease try again.\n" );
                //Clears the userinput and the loop runs again
                String flush = in.next();
            }
        }
        // returns the value input by the user provided its a whole number
        return playerSelected;
    }//closes playerSelect

    /*---------------------When the user team is selected --------------------------*/

    /*The following allows the user to select their players by inserting the players number..
     the players selected rating is used to impact the values in index 10 of the arrays defence and attack are*/
    public static void teamSelector (String [] players, double [] selected, int [] prev, int period, double[] teamsatt, double[] teamsdef)
    {
        //Adds keyboard input to our file.
        Scanner in = new Scanner(System.in);
        int counter = 0; //sets counter to 0
        int answer = 0; //sets answer to 0

        /*In the main method we have set period equal to week.
         The reason the below if checks if period is greater than 1 is we need to pick a team the first week.
         After the first week the user is then given the option to use an unchanged team.*/
        if(period >1)
        {

            System.out.println("\nWould you like to keep an unchanged team \ny or yes to remain unchanged n or no to change team.\n");
            //This loop will run until a valid anser is given
            while(answer<1)
            {
                // sets user input
                String changeTeam = in.next();
                //checks the user input. If the user opts not to change the team this statement is actioned
                if(changeTeam.equalsIgnoreCase("y") ||changeTeam.equalsIgnoreCase("yes"))
                {
                    //Removes us from the current loop
                    answer ++;
                    /*As the user does not wish to change the team the counter is set to 11 meaning the below 11 while loops below
                     used to select the team wont be actioned*/
                    counter = 11;
                }
                //This is if the user opts to change the team
                else if (changeTeam.equalsIgnoreCase("n") || changeTeam.equalsIgnoreCase("no"))
                {
                    //removes from current loop, inturn will start the next 11 while loops to pick the team
                    answer++;
                }
                //If the user answer is invalid.. This advises the user the answer is invalid and restarts this loop
                else
                {
                    System.out.println("Please select a valid option! \ny or yes to remain unchanged n or no to change team.\n");
                }
            }
        }
        /*The next 11 while loops are used to selct the team The reason I chose to use so many loops are due to the limitions I wanted
         to set for each position. each time a valid player is selected 1 will add to the counter ending the loop
         Each player is delared with a varible outside of the while loop. This varibles are then used for the index of the players and ratings.
         They are also returned to the starting 11 array in the main method so we can save the previous team and print the team in the
         teamName method*/
        int goalKeeper = 0;
        while(counter<=0)
        {
            System.out.println("\nPlease pick your team");
            System.out.println("To select a player just enter the number of the player and he will be added to your team \n");
            System.out.println("Please pick a Goalkeeper.");
            System.out.println("1. David De Gea or 13. Anders Lindegaard");
            //Sets Goalkeeper to the value returned from the method Playerselect.
            goalKeeper = playerSelect();
            //
            if(goalKeeper ==1 || goalKeeper== 13)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid goalkeeper between " + players[1] + " or " + players[13]);
                System.out.println("Please select a valid goalkeeper between 1. David De Gea or 13. Anders Lindegaard");
            }
            //Stores the goalkeeper index in the prev array which is also changing the starting11 array in the main method
            prev [0] = (goalKeeper);
        }

        int leftBack = 0;
        while(counter<=1)
        {
            System.out.println("Please pick a Left back.");
            System.out.println("3. Luke Shaw or 18. Ashley Young or 5. Marcos Rojo or 28. Tyler Blackett or 17. Daley Blind");
            //Sets leftBack to the value returned from the method Playerselect.
            leftBack = playerSelect();

            if(leftBack ==3 || leftBack== 18 || leftBack== 5 || leftBack== 28 || leftBack== 17)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid leftBack between 3. Luke Shaw or 18. Ashley Young or 5. Marcos Rojo or 28. Tyler Blackett or 17. Daley Blind");
            }
            //Stores the leftback index in the prev array which is also changing the starting11 array in the main method
            prev [1] = (leftBack);
        }

        int rightBack = 0;
        while(counter<=2)
        {
            System.out.println("Please pick a Right back.");
            System.out.println("2. Rafael or 25. Antonio Valencia or 12. Chris Smalling or 4. Phil Jones");
            //Sets rightBack to the value returned from the method Playerselect.
            rightBack = playerSelect();

            if(rightBack ==2 || rightBack== 25 || rightBack== 12 || rightBack== 4)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid rightBack between 2. Rafael or 25. Antonio Valencia or 12. Chris Smalling or 4. Phil Jones");
            }
            //Stores the rightBack index in the prev array which is also changing the starting11 array in the main method
            prev [2] = (rightBack);
        }

        int centerBack1 = 0;
        while(counter<=3)
        {
            System.out.println("Please pick a your first center half");
            System.out.println("4. Phil Jones or 5. Marcos Rojo or 6. Jonny Evans or 12. Chris Smalling or 16. Michael Carrick or 17. Daley Blind or 26. Paddy McNair or  28. Tyler Blackett");
            //Sets centerBack1 to the value returned from the method Playerselect.
            centerBack1 =  playerSelect();

            if(centerBack1 ==rightBack || centerBack1==leftBack)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(centerBack1 ==4 || centerBack1 ==5 || centerBack1 ==6 || centerBack1 ==12 || centerBack1 ==16 ||centerBack1 ==17 || centerBack1 ==26 ||centerBack1 ==28)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid Center half between 4. Phil Jones or 5. Marcos Rojo or 6. Jonny Evans or 12. Chris Smalling or 16. Michael Carrick or 17. Daley Blind or 26. Paddy McNair or  28. Tyler Blackett");
            }
            //Stores the centerback1 index in the prev array which is also changing the starting11 array in the main method
            prev [3] = (centerBack1);
        }

        int centerBack2 = 0;
        while(counter<=4)
        {
            System.out.println("Please pick a your second center half");
            System.out.println("4. Phil Jones or 5. Marcos Rojo or 6. Jonny Evans or 12. Chris Smalling or 16. Michael Carrick or 17. Daley Blind or 26. Paddy McNair or  28. Tyler Blackett");
            //Sets centerBack2 to the value returned from the method Playerselect.
            centerBack2 =  playerSelect();

            if(centerBack2 ==rightBack || centerBack2==leftBack || centerBack2==centerBack1)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(centerBack2 ==4 || centerBack2 ==5 || centerBack2 ==6 || centerBack2 ==12 || centerBack2 ==16 ||centerBack2 ==17 || centerBack2 ==26 ||centerBack2 ==28)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid Center half between 4. Phil Jones or 5. Marcos Rojo or 6. Jonny Evans or 12. Chris Smalling or 16. Michael Carrick or 17. Daley Blind or 26. Paddy McNair or  28. Tyler Blackett");
            }
            //Stores the centerback2 index in the prev array which is also changing the starting11 array in the main method
            prev [4] = (centerBack2);
        }

        int leftWing = 0;
        while(counter<=5)
        {

            System.out.println("Please pick a your Left Winger");
            System.out.println("7. Angel Di Maria or 18. Ashley Young or 8. Juan Mata or 11. Adnan Januzaj or 10. Wayne Rooney or 17. Daley Blind or 5. Marcos Rojo");
            //Sets leftWing to the value returned from the method Playerselect.
            leftWing =  playerSelect();

            if(leftWing ==rightBack || leftWing==leftBack || leftWing==centerBack1 || leftWing==centerBack2)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(leftWing ==7 || leftWing ==18 || leftWing ==8 || leftWing ==11 || leftWing ==10 ||leftWing ==17 || leftWing ==5)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid Left Winger between 7. Angel Di Maria or 18. Ashley Young or 8. Juan Mata or 11. Adnan Januzaj or 10. Wayne Rooney or 17. Daley Blind or 5. Marcos Rojo");
            }
            //Stores the leftWing index in the prev array which is also changing the starting11 array in the main method
            prev [5] = (leftWing);
        }

        int rightWing = 0;
        while(counter<=6)
        {
            System.out.println("Please pick a your Right Winger");
            System.out.println("7. Angel Di Maria or 18. Ashley Young or 8. Juan Mata or 11. Adnan Januzaj or 10. Wayne Rooney or 25. Antonio Valencia or 15. James Wilson");
            //Sets rightWing to the value returned from the method Playerselect.
            rightWing =  playerSelect();

            if(rightWing ==rightBack || rightWing==leftBack || rightWing==centerBack1 || rightWing==centerBack2 || rightWing==leftWing)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(rightWing ==7 || rightWing ==18 || rightWing ==8 || rightWing ==11 || rightWing ==10 ||rightWing ==25 ||rightWing ==15)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid Right Winger between 7. Angel Di Maria or 18. Ashley Young or 8. Juan Mata or 11. Adnan Januzaj or 10. Wayne Rooney or 25. Antonio Valencia or 15. James Wilson");
            }
            //Stores the RightWing index in the prev array which is also changing the starting11 array in the main method
            prev [6] = (rightWing);
        }

        int centerMiddm = 0;
        while(counter<=7)
        {
            System.out.println("Please pick a your defensive center midfielder");
            System.out.println("16. Michael Carrick or 17. Daley Blind or 19. Marouane Fellaini or 21. Ander Herrera or 22. Nick Powell or 23. Tom Cleverley or 24. Darren Fletcher or 4. Phil Jones or 5. Marcos Rojo");
            //Sets centerMidDm to the value returned from the method Playerselect.
            centerMiddm =  playerSelect();

            if(centerMiddm ==rightBack || centerMiddm ==leftBack || centerMiddm ==centerBack1 || centerMiddm ==centerBack2 || centerMiddm==leftWing || centerMiddm==rightWing)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(centerMiddm ==16 || centerMiddm ==17 || centerMiddm ==19 || centerMiddm ==21 || centerMiddm ==22 || centerMiddm ==23 || centerMiddm ==24 || centerMiddm ==4 || centerMiddm ==5)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid defensive center midfielder between 16. Michael Carrick or 17. Daley Blind or 19. Marouane Fellaini or 21. Ander Herrera or 22. Nick Powell or 23. Tom Cleverley or 24. Darren Fletcher or 4. Phil Jones or 5. Marcos Rojo");
            }
            //Stores the centerMiddm index in the prev array which is also changing the starting11 array in the main method
            prev [7] = (centerMiddm);
        }

        int centerMidat = 0;
        while(counter<=8)
        {
            System.out.println("Please pick a your attacking center midfielder");
            System.out.println("16. Michael Carrick or 19. Marouane Fellaini or 21. Ander Herrera or 22. Nick Powell or 23. Tom Cleverley or 24. Darren Fletcher or 7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 27. Jesse Lingard");
            //Sets centerMidat to the value returned from the method Playerselect.
            centerMidat =  playerSelect();

            if(centerMidat ==rightBack || centerMidat ==leftBack || centerMidat ==centerBack1 || centerMidat ==centerBack2 || centerMidat==leftWing || centerMidat==rightWing || centerMidat == centerMiddm)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(centerMidat ==16 || centerMidat ==19 || centerMidat ==7 || centerMidat ==21 || centerMidat ==22 || centerMidat ==23 || centerMidat ==24 || centerMidat ==8 || centerMidat ==10 || centerMidat ==11 || centerMidat== 27)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid attacking center midfielder between 16. Michael Carrick or 19. Marouane Fellaini or 21. Ander Herrera or 22. Nick Powell or 23. Tom Cleverley or 24. Darren Fletcher or 7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 27. Jesse Lingard");
            }
            //Stores the centerMidat index in the prev array which is also changing the starting11 array in the main method
            prev [8] = (centerMidat);
        }

        int striker1 = 0;
        while(counter<=9)
        {
            System.out.println("Please pick a your first striker");
            System.out.println("7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 9. Radamel Falcao or 20. Robin van Persie or 15. James Wilson or 27. Jesse Lingard");
            //Sets striker1 to the value returned from the method Playerselect.
            striker1 =  playerSelect();

            if(striker1 ==rightBack || striker1 ==leftBack || striker1 ==centerBack1 || striker1 ==centerBack2 || striker1==leftWing || striker1==rightWing || striker1 == centerMiddm || striker1== centerMidat)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(striker1 ==7 || striker1 ==8 || striker1 ==10 || striker1 ==11 || striker1 ==9 || striker1 ==20 || striker1 ==15 || striker1 ==27)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop to select the next player
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid striker between 7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 9. Radamel Falcao or 20. Robin van Persie or 15. James Wilson or 27. Jesse Lingard");
            }
            //Stores the striker1 index in the prev array which is also changing the starting11 array in the main method
            prev [9] = (striker1);
        }//closes final while loop

        int striker2 = 0;
        while(counter<=10)
        {
            System.out.println("Please pick a your second striker");
            System.out.println("7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 9. Radamel Falcao or 20. Robin van Persie or 15. James Wilson or 27. Jesse Lingard");
            //Sets striker2 to the value returned from the method Playerselect.
            striker2 =  playerSelect();

            if(striker2 ==rightBack || striker2 ==leftBack || striker2 ==centerBack1 || striker2 ==centerBack2 || striker2==leftWing || striker2==rightWing || striker2 == centerMiddm || striker2== centerMidat || striker2==striker1)
            {
                System.out.println("This player has already been selected in another position, Please pick another player");
            }
            else if(striker2 ==7 || striker2 ==8 || striker2 ==10 || striker2 ==11 || striker2 ==9 || striker2 ==20 || striker2 ==15 || striker2 ==27)
            {
                //add one to counter as a valid player is selected. This takes the user out of this while loop and finshes the team selection seris of while loops.
                counter++;
                //System.out.println(counter);  used for testing only
            }
            else
            {
                System.out.println("Please select a valid striker between 7. Angel Di Maria or 8. Juan Mata or 10. Wayne Rooney or 11. Adnan Januzaj or 9. Radamel Falcao or 20. Robin van Persie or 15. James Wilson or 27. Jesse Lingard");

            }
            //Stores the striker2 index in the prev array which is also changing the starting11 array in the main method
            prev [10] = (striker2);
            /*Changes the attack and defence of the user team by getting the adverage of the selected players. This is done by dividing by the amount of playes in each area.
             This needed to be moved to the while loop because if the user chose an unchanged team the values would be altered to 0 for every player if this was left outside the loop*/
            teamsatt[10] = (selected[striker2] + selected[striker1] + selected[centerMidat] + selected[rightWing] + selected[leftWing]) /5;
            teamsdef[10]= (selected[centerMiddm] + selected[rightBack] + selected[leftBack] + selected[centerBack1] + selected[centerBack2] + selected[goalKeeper]) / 6;
            /*This is only for test purposes to ensure the values change to match the user selected players
            System.out.println(teamsdef[10]  + " defence");
            System.out.println(teamsatt[10]  + " attack");

             Used for testing to ensure the playes the user selected are stored print and later
             in the teamName method so that if the user opts not to change the team the previous team is stored so it can be reprinted.
             System.out.println(players[goalKeeper] + " goalkeeper");
             System.out.println(players[rightBack] + " rightBack" + players[centerBack1] + " centerBack1" + players[centerBack2] + " centerBack2" + players[leftBack] + " leftBack ");
             System.out.println(players[rightWing] + " rightWing" + players[centerMiddm] + " DM center mid" + players[centerMidat] + " attacking mid" + players[leftWing] + " leftWing ");
             System.out.println(players[striker1] + " striker" + players[striker2] + " striker" );*/
        }//closes while loop

    }//close TeamSelector

    /*---------------------Print Players names method --------------------------*/

    //This method prints the players' names that the user selected in the team selecter, the arrays are defined in the main method.
    public static void teamName (String [] players, int [] selected, String [] pos)
    {
        System.out.println("Your team to play this week is: \t");

        //This loop runs 11 times in order to print the 11 players the user has selected
        for(int counter=0; counter <=10; counter++)
        {
            //This line uses the couter to go to the next index of the array that stores the index value of the players the user selected.
            int location = selected[counter];
            //Ass the arrays in this method are matched to our arrays in the main method the below code prints postion and player for our 11 players.
            System.out.println("Position\t" + pos[counter] + "\tPlayer\t" + players[location]);
        }//closes for loop
    }//close teamName

        /*---------------------League Table --------------------------*/

    /*This method reads the team names the points the goal difference from the main array to print a league table in preference of
    points, gd and names. finally it reads the so on the last week it can indicate how you have done*/
    public static void leagueTable (String [] names, int [] pts, int[] gd, int wk)
    {
        /*new array is created to at the moment the it is numbered 0 to 19 sorting the teams in alphabetical order. This means when a mean has the same
         * points and gd nothing needs to be done*/
        int placing  [] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        //compare is declared
        int compare = 0;
        //swap is declared
        int swap = 0;
        //the loop is ran 19 times in order to check all teams
        for(int counter=1; counter<=19; counter++)
        {
            //compare is set to the counter value -1 This means the the team can be compared to the previous team
            compare = counter-1;
            /*if compare hits a value below 0 reruns counter for loop, inturn compare will have a value valid for this loop to rerun.
             used counter and compare as index references placing and placing index as reference in the pts array. When the points in the next index in the points
             array are greater this loop will action */
            while(compare>=0 && pts[placing[counter]]>pts[placing[compare]])
            {
                //Sets swap to the value of placing[compare] if this is not done we could lose the value in placing[compare] in the next step.
                swap = placing[compare];
                //changes the value in placing[compare] to placing[counter]
                placing[compare] = placing[counter];
                //changes the value in placing[counter] to swap. In turn what value was in placing[compare] before this loop was ran.
                placing[counter]= swap;
                //changes the value in counter and compare so the next part of the array can be checked
                counter--;
                compare--;
            }//closes while loop
            //This loop does the same as the previous loop except it only sorts by gd when the points are different
            while(compare>=0 && pts[placing[compare]]==pts[placing[counter]])
            {
                /*This will action if 2 teams have equal points. It will then compare the goal differnce. If a team in a lower
                 * index in placing has a greater gd than a team above them these teams wil swap places otherwise nothing will happen*/
                if(gd[placing[counter]]>gd[placing[compare]])
                {
                    swap = placing[compare];
                    placing[compare] = placing[counter];
                    placing[counter]= swap;
                    counter--;
                }
                //System.out.println(compare);
                compare--;
            }//close while loop
        }//close for loop
        System.out.println("Postion\tTeam\t\t\tGd\tPts");
        /* the below loop runs 20 times.
         int i is used as the index location in the placing array it.
         the placing value the is held in index i is then printed from the names gd and pts arrays
         this then prints the league table in order*/
        for (int i = 0; i<20; i++)
        {
            System.out.println(i+1 +"\t" + names[placing[i]]+ "\t" + gd[placing[i]]+ "\t" + pts[placing[i]]);
        }
        System.out.println("\n");
        //This checkes where the user team (index 10) finishes on the last week of the season.
        if(wk == 38)
        {
            int final_Position = 0;
            //This checks if you have won the league
            if(placing[0]== 10)
            {
                final_Position = 1;
                System.out.println("Congratulations! You have restored glory to this great club by delivering the Premiership title, this ensuring we remain firmly on our perch for the time being!");
            }
             //This checked if you have finished in the top 4 which is an objective of the game
             else if (placing[1] == 10 || placing [2] == 10 || placing[3] == 10)
             {
                 System.out.println("Well done! You have returned this club to the elite level of the Champions League. We are satisfied with this result.");
             }
             //This checked if you where relagated, in turn losing the game and getting fired
             else if (placing[17] == 10 || placing [18] == 10 || placing[19] == 10)
             {
                 System.out.println("You are relegated.\nThis is an embarrassment to this great club. \nWe are on the brink of financial disaster.\nThe Busby Babes would be turning in their graves. \nYou are more suited to a lesser club such as Liverpool.\nYour a born Loser.\nOUT, OUT OUT!!!!!!");
             }
             //Checks any other position, also results in losing the game and getting fired.
             else System.out.println("You have failed to achieve your initial goal of Champions League qualification. At this great club we cannot afford any further disasters such as yourself and Moyesy. Therefore, YOU'RE FIRED!!!!!");
        }
    }//Close leagueTable method
}//close class