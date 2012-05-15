IT Fornebu lunch app for Android
=================================
by Marius Haugli Kristensen

Description
---------------------------------
Just an app for displayin the lunch menu at IT Fornebu. It's based on screenscraping the [IT Fornebu homepage](http://leietaker.itfornebu.no/itfornebu/kantinemeny) which unfortunately don't update at a regular interval (if updated at all). But this is as close I could get. 

As of May 14th 2012 this is available on Google Play, but only for norwegians. [Check it out!](https://play.google.com/store/apps/details?id=com.kwc.itfornebulunchapp)


Implementation
---------------------------------
I've tried to implement this app using WebView. I find it easier to style and make a HTML page compatible with different sizes easier than using ContentView. But the cost may be a bit slower application.

To do
---------------------------------
- Add a about screen + button.
- Replace spinner with something more fun.
- Possibly a check to find what day it is and highlight that day in some way.
- When in mainscreen, the back button should exit the application. But not in about screen.
