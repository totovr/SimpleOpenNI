# SimpleOpenni

This is a library was created by Max Rheiner and his Project:

* [Link](https://code.google.com/archive/p/simple-openni/)

I Update the driver to can use this library with Processing 3 and 2

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Processing IDE
* A computer with OSX
* Kinect V1

Alternative:

* Arduino IDE
* Arduino board

### Installing

Install the last stable version of Processing IDE, you can download it from this page:

* [Processing IDE](https://processing.org/download/)

For OSX you just need to unzip the folder and paste the App in the applications folder.

* Repository for Processing V2.2.1:

  [SimpleOpenni for Processing 2](https://github.com/totovr/SimpleOpenni/tree/Processing_2.2.1).

* Repository for Processing V3.3.6:

  [SimpleOpenni for Processing 3](https://github.com/totovr/SimpleOpenni/tree/Processing_3.3.6).

Once you have downloaded the library unzip it and follow the next steps:

1. Download SimpleOpenni folder

2. Select the folder SimpleOpenNI and choose Edit > Copy
   Go to the Finder
   Choose Go > Go to Folder... and enter “~/Documents/Processing/libraries/" without
   the quotation marks. Click OK..
   Press Cmd-V or choose Edit > Paste menu to put "SimpleOpenNI" in this location.


## Test a program sample:

1.  Connect your Xbox Kinect motion sensor to your computer in an available USB port. Ensure the sensor is connected to a power    source.

2. Open Processing IDE

3. Copy and paste the next example in the sketch:

```
import SimpleOpenNI.*;


SimpleOpenNI  context;

void setup()
{
  size(640, 480);
  context = new SimpleOpenNI(this);
  if (context.isInit() == false)
  {
    println("Can't init SimpleOpenNI, maybe the camera is not connected!");
    exit();
    return;
  }

  // mirror is by default enabled
  context.setMirror(true);

  // enable depthMap generation
  context.enableDepth();

  // enable ir generation
  context.enableRGB();
}

void draw()
{
  // update the cam
  context.update();

  background(200, 0, 0);

  // draw depthImageMap
  image(context.depthImage(), 0, 0);

  // draw irImageMap
  image(context.rgbImage(), context.depthWidth() + 10, 0);
}

```
This is one example of how to activate the deep camera of the Kinect.

## For more examples check the next links:

*  For Processing 3.3.6 check this branch:

[Kinect V1 Processing 3](https://github.com/totovr/Processing/tree/Processing-3.3.6/Kinect/Kinect_SimpleOpenni).

* For Processing 2.2.1 check this branch:

[Kinect V1 Processing 2](https://github.com/totovr/Processing/tree/Processing-2.2.1/Processing%202.2.1/Kinect).

## Also you can use the next IDE to build programs:

* [Atom](https://atom.io/)

## Contributing

Please read [CONTRIBUTING.md](https://github.com/totovr/Processing/blob/master/CONTRIBUTING.md) for details of the code of conduct, and the process for submitting pull requests to us.

## Versioning

I use [SemVer](http://semver.org/) for versioning.

## Author of SimpleOpenNI library:

Max Rheiner

* [Link](https://code.google.com/archive/p/simple-openni/)

## Supporter

Antonio Vega Ramirez:

* [Github](https://github.com/totovr)
* [Twitter](https://twitter.com/SpainDice)

## License

This project is licensed under CC License - see the [LICENSE.md](https://creativecommons.org/licenses/by/4.0/) file for details

### The instructions to Setup the Kinect are written for Mac OS High Sierra users.

![Deep](https://github.com/totovr/Processing/blob/master/Images/deep.png)
