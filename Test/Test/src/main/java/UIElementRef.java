import com.sun.jna.Pointer;

import com.sun.jna.platform.win32.*;


public class UIElementRef extends IAccessible{
    public UIElementRef(Pointer p) {
        super(p);
    }

    private final Guid.IID IID_IAccessible = new Guid.IID("{618736E0-3C3D-11CF-810C-00AA00389B71}");
    private final int DEFAULT_TIMEOUT = 20000;

}
