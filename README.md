# SimpleOpenNI

### Use Kinect 1 or 2 sensors with Processing 3

<img src="Assets/threshold.gif" width="900">

<img src="Assets/Kinect_V2_Tracking.gif" width="900">

   > Example of skeleton tracking using KinectV2

<img src="Assets/200w_d.gif" width="900">

   > Example of skeleton tracking using KinectV1

I update the driver to can use this library with Processing 3 and 2 with Kinect V1 and V2

> Kinect V2 just works with USB 3.0

### The instructions to Setup the Kinect are written for Mac OS High Sierra users.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Processing IDE
* A computer with OSX
* Kinect V1
* Kinect V2

### Alternative:

* [Atom](https://atom.io/)
* Arduino IDE
* Arduino board

### Installing

Install the last stable version of Processing IDE, you can download it from this page:

* [Processing IDE](https://processing.org/download/)

For OSX you just need to unzip the folder and paste the App in the applications folder.

* Repository for Processing V3.5.3:

  [SimpleOpenni for Processing 3.5.3](https://github.com/totovr/SimpleOpenni/tree/Processing_3.5.3).

* Repository for Processing V3.5.2:

  [SimpleOpenni for Processing 3.5.2](https://github.com/totovr/SimpleOpenni/tree/Processing_3.5.2).

* Repository for Processing V3.4:

  [SimpleOpenni for Processing 3.4](https://github.com/totovr/SimpleOpenni/tree/Processing_3.4).

* Repository for Processing V3.3.7:

  [SimpleOpenni for Processing 3.3.7](https://github.com/totovr/SimpleOpenni/tree/Processing_3.3.7).

* Repository for Processing V3.3.6:

  [SimpleOpenni for Processing 3.3.6](https://github.com/totovr/SimpleOpenni/tree/Processing_3.3.6).

* Repository for Processing V2.2.1:

  [SimpleOpenni for Processing 2](https://github.com/totovr/SimpleOpenni/tree/Processing_2.2.1).

> The library has compatibility with Kinect V2 just in Processing V3.5.2, V3.4, V3.3.7 and V3.3.6

Once you have downloaded the library unzip it and follow the next steps:

1. Select the folder SimpleOpenNI and choose:

       Edit > Copy

2. Go to the Finder

       Choose Go > Go to Folder... and enter “~/Documents/Processing/libraries/"

 **Without the quotation marks. Click OK.**

3. Press **Cmd-V** or choose Edit > Paste menu to put "SimpleOpenNI" in this location.


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

* For Processing 3.4 the examples are added directly in the library, the Remove_Background_RGB example just work with Kinect V1

* For Processing 3.3.7 check this branch:

[Kinect V1 and V2 Processing 3](https://github.com/totovr/Processing/tree/Processing-3.3.7).

* For Processing 3.3.6 check this branch:

[Kinect V1 and V2 Processing 3](https://github.com/totovr/Processing/tree/Processing-3.3.6).

* For Processing 2.2.1 check this branch:

[Kinect V1 Processing 2](https://github.com/totovr/Processing/tree/Processing-2.2.1/Kinect).

## Also you can use the next text editor to build programs:

* [Atom](https://atom.io/)
* Open package manager -> Install new Package -> Processing

 ***Use this package to run Processing Sketch inside Atom***

## Contributing

Please read [CONTRIBUTING.md](https://github.com/totovr/SimpleOpenni/blob/master/CONTRIBUTING.md) for details of the code of conduct, and the process for submitting pull requests to us.

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

This project is licensed under The MIT License (MIT) - see the [LICENSE.md](https://github.com/totovr/SimpleOpenni/blob/master/LICENSE.md) file for details

## Images

<img src="Assets/Skeleton_Tracking.png" width="600">
<img src="Assets/deep.png" width="600">

## Video

* [Youtube Video](https://www.youtube.com/watch?v=5n5qqz3RfPM)

## Reference

This library was created by Max Rheiner and his Project:

* [Link](https://code.google.com/archive/p/simple-openni/0)
