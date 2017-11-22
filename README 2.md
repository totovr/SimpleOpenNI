# SimpleOpenni

This is a library was created by Max Rheiner and his Project:

* [SimpleOpenni](https://code.google.com/archive/p/simple-openni/)

I Update the driver to can use this library with Processing 3 and 2

### Change of branch depending of your currently version:

* Programs using Processing V2.2.1:

    https://github.com/totovr/Processing/tree/Processing-2.2.1

* Programs using Processing V3.3.6:

    https://github.com/totovr/Processing/tree/Processing-3.3.6

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

[Kinect V1 Processing 3](https://github.com/totovr/Processing/tree/Processing-3.3.6/Kinect).

* If you want to use the SimpleOpenni library tested for Processing 2.2.1 check this branch:

[Kinect V1 Processing 2](https://github.com/totovr/Processing/tree/Processing-2.2.1/Kinect).

## Test a program sample:

Open Processing IDE and upload the next example:
```
void setup() {
  size(480, 120); //Create a window of 480*120
}

void draw() {
  if (mousePressed) {
    fill(0);
    } else {
      fill(255);
    }
    ellipse(mouseX, mouseY, 80, 80); //If we pressed the mouse a Ellipse will be draw
}
```
This is one simple example draw a Ellipse in the sketch window.

## Also you can use the next IDE to build programs:

* [Processing Online Editor](http://js.do/blog/processing/editor/)
* [Atom](https://atom.io/)

## Contributing

Please read [CONTRIBUTING.md](https://github.com/totovr/Processing/blob/master/CONTRIBUTING.md) for details of the code of conduct, and the process for submitting pull requests to us.

## Versioning

I use [SemVer](http://semver.org/) for versioning.

## Author

Antonio Vega Ramirez:

* [Github](https://github.com/totovr)
* [Twitter](https://twitter.com/SpainDice)

## License

This project is licensed under CC License - see the [LICENSE.md](https://creativecommons.org/licenses/by/4.0/) file for details

### The instructions to Setup the Kinect are written for Mac OS High Sierra users.

![Deep](https://github.com/totovr/Processing/blob/master/Images/deep.png)
