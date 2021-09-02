import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.platform.win32.Guid.*;

import java.io.IOException;

public class test {
    IID IID_IServiceProvider = new  IID("{6D5140C1-7436-11CE-8034-00AA006009FA}");
    REFIID REFIID_IServiceProvider = new  REFIID(IID_IServiceProvider);


    //    Guid.REFIID REFIID_IAccessibleEx = new Guid.REFIID(GUID_IAccessibleEx);
    GUID IID_IAccessibleEx = new GUID("{F8b80AdA-2C44-48D0-89BE-5FF23C9CD875}");
    REFIID REFIID_IAccessibleEx = new REFIID(IID_IAccessibleEx.getPointer());

    WinNT.HRESULT hr;

    void GetIAccessibleExFromIAccessible(){
        WinDef.HWND app = User32.INSTANCE.FindWindow(null,"Calculator");
        UIElementRef aapp = CallOleacc.getAccessibleObject(app);
        // First, get IServiceProvider from the IAccessible.
        PointerByReference pSp = new PointerByReference();
        hr = aapp.QueryInterface(REFIID_IServiceProvider, pSp);
        if (!COMUtils.FAILED(hr)) {
            System.out.println(hr);
            System.out.println("successful");
        }
        IServiceProvider iServiceProvider = new IServiceProvider(pSp.getValue());
        PointerByReference paex = new PointerByReference();

        GUID GUID_IAccessibleEx = new GUID("f8b80ada-2c44-48d0-89be-5ff23c9cd875");

        hr = iServiceProvider.QueryService(GUID_IAccessibleEx.getPointer(),GUID_IAccessibleEx.getPointer(),paex);
        System.out.println(hr);
        if (!COMUtils.FAILED(hr)) {
            System.out.println("successful");
        }else {
            System.out.println("failed");
        }
    }




    public static void main(String[] args) throws IOException, InterruptedException {
        new test().GetIAccessibleExFromIAccessible();
    }
}
