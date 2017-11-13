# Processing_Kinect

Steps to setup Kinect V1 in Mac

1.- Install Processing v3.3.6.

It can be found under the heading "Stable Releases" on the page at http://processing.org/download/

If you did not find the version it will be included in the next Download Link too

2.- Setup Openni

Download this version of Simple Openni from the next link:

      https://mega.nz/#F!ORxG3RYJ!p-gfkggjMWzlbT__Dwm_0g


3.- Locate Openni

Unzipped the file "SimpleOpenNI.zip" and a
folder called SimpleOpenNI will be created.
Select the folder SimpleOpenNI and choose Edit > Copy
Go to the Finder
Choose Go > Go to Folder... and enter “~/Documents/Processing/libraries/" without
the quotation marks. Click OK..
Press Cmd-V or choose Edit > Paste menu to put "SimpleOpenNI" in this location.

4.- Set up the libraries

Launch the Processing application. An empty sketch opens by default.
From the menu bar, selectSketch > Import Library > Add Library… The “Library Manager” dialog appears.
In the search field, enter “oscP5”. Select and install oscP5 by Andreas Schlegel. This library provides support for
Open Sound Control (OSC) input and output.
MacOS Only: In the search field, enter Syphon. Select and install Syphon by Andres Colubri. Syphon is a free Mac OS
tool that allows different programs to share video.
Close the “Library Manager” dialog and quit Processing.

5.- Check the libraries

Navigate to:

    /Users/USERNAME/Documents/Processing/libraries

# This path could change depending where did Processing is installed    

You should see the next folders:

oscP5
SimpleOpenNI
Syphon (Mac OS Only)

6.- Test the Kinect Setup

Connect your Xbox Kinect motion sensor to your computer in an available USB port. Ensure the sensor is connected
to a power source.

Open the Processing application again.

Open:

    https://github.com/totovr/Processing/tree/master/Kinect/Angle_Tracking_KV1_ProssingV2.2.1_Arduino_Demo

  ![alt text](https://github.com/totovr/Processing/blob/master/Kinect/Images/Check.png)
