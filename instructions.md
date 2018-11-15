# Manual installation to use Kinect V2 with SimpleOpenni

> If you are using Kinect V1 avoid this steps and just download and paste the library in the the Processing folder

<img src="Assets/threshold.gif" width="900">

<img src="Assets/Kinect_V2_Tracking.gif" width="900">

   > Example of skeleton tracking using KinectV2

### Mac OS

* Install [Homebrew](https://brew.sh/index_es) opening a terminal and pasting the next code

``` terminal
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
> The site that is provided in the link is in Spanish

- Make sure these build tools are available:
  - wget
  - git
  - cmake
  - pkg-config

> If you don't have the tools use Homebrew to install them

- Open a terminal and download libfreenect2 source
  ```
  git clone https://github.com/OpenKinect/libfreenect2.git
  cd libfreenect2
  ```

- Open an other terminal and install dependencies:
  ```
  brew update
  brew install libusb
  brew tap homebrew/versions
  brew install glfw3
  ```

- Install TurboJPEG (optional)
  ```
  brew install jpeg-turbo
  ```

- Install CUDA (optional): TODO

- Return to the first terminal, or in the libfreenect2 folder, and build:
  ```
  mkdir build && cd build
  cmake ..
  make
  make install
  ```

- Install OpenNI2 (optional)
  ```
  brew tap brewsci/science
  brew install openni2
  export OPENNI2_REDIST=/usr/local/lib/ni2
  export OPENNI2_INCLUDE=/usr/local/include/ni2
  ```
