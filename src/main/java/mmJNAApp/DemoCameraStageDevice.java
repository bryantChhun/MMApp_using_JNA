package mmJNAApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import javax.swing.JTextArea;

/**
 *
 * @author bchhun
 */
public class DemoCameraStageDevice {
    private static DemoCameraDLL_h INSTANCE;
    
    public DemoCameraStageDevice() {
        String rootPath = System.getProperty("user.dir");
        String DLLPath = rootPath + "\\mmgr_dal_DemoCamera.dll";
        System.out.print("DLLPath = "+DLLPath);
        INSTANCE = (DemoCameraDLL_h) Native.loadLibrary(DLLPath, DemoCameraDLL_h.class);
    }
    
    public void InitializeModuleData() {
        INSTANCE.InitializeModuleData();
    }
    
    // MM::Device* CreateDevice(const char* name);
    public PointerByReference CreateDevice(String name, JTextArea box) {
        box.append("\n calling Create Device");
        PointerByReference ptrref = INSTANCE.CreateDevice(name);
        box.append("\n called pointer hashcode = "+ptrref.hashCode());
        box.append("\n ptrref.value.class = "+ptrref.getValue().getClass().getName());
        box.append("\n ptrref.pointer.class = "+ptrref.getPointer().getClass().getName());
        box.append("\n ptrref.value.string = "+ptrref.getValue().getString(1));
        return ptrref;
    }
    //void DeleteDevice(MM::Device* pDevice);
    public NativeLong GetModuleVersion() {
        return INSTANCE.GetModuleVersion();
    }
    
    public NativeLong GetDeviceInterfaceVersion() {
        return INSTANCE.GetDeviceInterfaceVersion();
    }
    
    public int GetNumberOfDevices() {
        return INSTANCE.GetNumberOfDevices();
    }
    
    public boolean GetDeviceName(int deviceIndex, String name, int bufferLength) {
        return INSTANCE.GetDeviceName(deviceIndex, name, bufferLength);
    }
    
    public boolean GetDeviceType(String deviceName, IntByReference type) {
        return INSTANCE.GetDeviceType(deviceName, type);
    }
    
    public boolean GetDeviceDescription(String deviceName, String name, int bufferLength) {
        return INSTANCE.GetDeviceDescription(deviceName, name, bufferLength);
    }
    
}
