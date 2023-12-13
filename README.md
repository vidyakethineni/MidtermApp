# Midterm App

Midterm App includes an app that consists of three screens: Main Fragment, Game Fragment, and HighScore Fragment, each with specific functionalities.

## Functionality 

The following **required** functionality is completed:

Main Screen:

Adaptable layout for both portrait and landscape modes.
Interactive buttons ("Play Game" and "View HighScores") for navigation to other screens.
Proper padding for components.

Game Screen:
Random number generation between 1-100 for the user to guess.
Horizontal row with a TextView and an EditText for player name entry.
Image buttons (source: ic_minus.png) to decrement and increment the guess value.
Toast notification for showing if the guess was higher or lower than the original.
Sound feedback (buzz.mp3) on incorrect guesses.
Display of the number of attempts.
Communication with Fragment 1 using a View Model.
Storage of correct guesses in a local Room database.

HighScore Screen:
Display of scores from the Room database, sorted by the top score.
Use of RecyclerView for efficient data display.
Deletion functionality for each high score item, using a dialog fragment for confirmation.
Handling of cases where no high scores exist.

## Extensions

Potential extensions include:
  - Implementation of additional features, such as hints or difficulty levels.
  - Integration of cloud storage for scores to enable cross-device synchronization.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='MidtermApp Video Walkthrough.gif' title='MidtermApp Video Walkthrough' width='50%' alt='MidtermApp Video Walkthrough' />

GIF created with [EzGif](https://ezgif.com/) 

## Notes

Challenges encountered during the coding process included:
  - Utilizing View Models
  - Integrating the Room database.



## License

    Copyright [2023] [Vidya Kethineni]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
