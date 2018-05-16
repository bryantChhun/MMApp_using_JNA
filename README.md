# MMApp_using_JNA
This repo is similar to the other MMPlugin_using_JNA, but is a standalone application (does not require Micromanager)
  - It seems we can call the dll fine, but the central problem of not having access to a class's submethods remains.
  - Thus, the purpose of this repo is mostly as a JNA example without needing to install micromanager.

# Dependencies
  jna-4.5.1 (https://github.com/java-native-access/jna)

# Setup/Installation

The "mmgr_dal_DemoCamera.dll" is in the project root directory.

Simply build the gradle project and then run it.

# The central problem
- because all mm device adaptors need to implement "ModuleInterface", the exposed methods are all the same for all adaptors.
- I can directly call "CreateDevice(const char* name)" via JNA (which is one of the ModuleInterface methods), but that returns a pointer to the device.  It's not obvious to me how one can use this pointer to call it's submethods.  This might be impossible.
- If we can call methods via this pointer, problem solved!  But it's more likely that the methods get jumbled in memory and are not accessible.

# Other ideas:
While the goal is not to use mmcore, is there a way to use it minimally?

JNAerator isn't able to generate c++ wrappers for mm device adaptor code.  I've tried this.

Possibly the simplest scenario:  use the device adaptor headers to build the direct JNA interface (without using mm's mmgr_dal_<device>.dll).  This is useful especially if the manufacturer does not supply an SDK.
