# UCD Final Project - SAVICK
Stock Market Simulation Game 

Stock Market simulation Game v1.4
This project was developed by group of students at UCD for the final year project. This project implements a Stock Market simulator. A player has to sign up beforehand or login using the credentials to play the game. Minimum of 3 players (Deployed version, minimum players are 2 - (Human Player and AI Player) for testing purpose) including AI player (which is basically a computer player), required to start a game. The game has 10 rounds and each round lasts 30 seconds. Game provide 60 seconds of time as Ready Period to allow other players to join the game. At the start of each round the stock values gets changed according to the trends and events occurred. Each player in a game gets an opening balance of 1000 and connected players can buy and sell stocks in each round. At the end of the final round which is round 10 to be precise the player who has invested by far the best in stocks and gains the most profits will win the game.

## Running the Project
This project is created using Intellij IDEA
For contributers
In Intellij
Goto File > New > Project From Version Contron > Github and choose this project
To run the project goto "src" folder and right click on Main which is located in "smsimulator.server.root" and click on "Run 'Main'"

## What if doesn't run 
  ### For Intellij IDEA

```
    1. Showing code in red
        Probably because libs are not detected by the Intellij
        Goto com.smsimulator.libs and right click each and every library and click "Add as Library"
      
    2. Error: Could not find or load main class com.smsimulator.server.root.Main
        Goto File>Project Structure and select Project from Project Settings which is on left pane and set a path for Project  
        compiler output. This path usually is "<yourproject location>/out"
        Then goto Build>Build Module 'UCD_FinalProject_SAVICK' and try again running the Application
```

## Database SQL file
  https://drive.google.com/open?id=1pbgwv9gy01SA7tNLxQ3hHvAnUbVrPDFj
  
  ### Used Function and Procedures
  https://drive.google.com/file/d/1ir3eP-8q-WAl1U8ofr48VXjObsVRCE3W/view?usp=sharing
  
## Deployed Version Links
  ### Front-end link : http://simulator-frontend.s3-website-us-east-1.amazonaws.com/
  ### Back-end link  : http://stockmarketsimulator-env.3ipy32ivep.us-east-1.elasticbeanstalk.com/
