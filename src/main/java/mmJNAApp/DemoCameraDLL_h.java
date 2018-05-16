package mmJNAApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.jna.Library;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.NativeLong;

/**
 * this JNA interface is based on MMDevice.h
 * MMDevice.h contains multiple abstract interfaces, one for each device type (camera, stage etc..)
 * The DemoCamera.h does not contain MMDevice.h, but we will use methods defined here anyway..?
 * 
 * @author bchhun
 */
public interface DemoCameraDLL_h extends Library {
    
   void InitializeModuleData();
   // MM::Device* CreateDevice(const char* name);
   PointerByReference CreateDevice(String name);
   NativeLong GetModuleVersion();
   NativeLong GetDeviceInterfaceVersion();
   int GetNumberOfDevices();
   boolean GetDeviceName(int deviceIndex, String name, int bufferLength);
   boolean GetDeviceType(String deviceName, IntByReference type);
   boolean GetDeviceDescription(String deviceName, String name, int bufferLength);
   //void DeleteDevice(MM::Device* pDevice);
}
