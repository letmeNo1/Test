import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.PointerByReference;

public class CallOleacc {

    public static UIElementRef getAccessibleObject(WinDef.HWND winHWND){
        Guid.IID IID_IAccessible = new Guid.IID("{618736E0-3C3D-11CF-810C-00AA00389B71}");
        Guid.REFIID REFIID_IAccessible = new Guid.REFIID(IID_IAccessible);
        PointerByReference ptr = new PointerByReference();
        Oleacc.INSTANCE.AccessibleObjectFromWindow(winHWND,0,REFIID_IAccessible,ptr);
        return new UIElementRef(ptr.getValue());
    }
}
