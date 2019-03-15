# FingerTracker
This is a Processing library that does real-time finger-tracking from depth images.
It is based on work done by Murphy Stein at NYU. It uses fast marching squares to find the
contour of the hand and then estimates finger endpoints by looking for inflections in the
curvature of the contour. It can work with depth maps from either OpenNI or libfreenect
(it expects the depth maps to be scaled to the 500-2047 range provided by the Kinect drivers).
