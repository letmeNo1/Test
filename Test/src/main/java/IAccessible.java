import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IUnknown;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;

public class IAccessible extends Dispatch implements IUnknown {
    public IAccessible(Pointer p){
        super(p);
    }

    public WinNT.HRESULT get_AccChildCountHRESULT(NativeLongByReference pcountChildren) {
        return (WinNT.HRESULT) this._invokeNativeObject(IAccessibleVtbMapped.getAccChildCount,
                new Object[]{
                        this.getPointer(),
                        pcountChildren
                }, WinNT.HRESULT.class);

    }

    public WinNT.HRESULT get_AccNameHRESULT(Variant.VARIANT varID, WTypes.BSTRByReference pszName) {
        return (WinNT.HRESULT)this._invokeNativeObject(IAccessibleVtbMapped.getAccName ,
                new Object[]{
                        this.getPointer(),
                        varID,
                        pszName
                },
                WinNT.HRESULT.class);
    }

    public WinNT.HRESULT get_accRoleHRESULT(Variant.VARIANT varID, Variant.VARIANT pvarRole) {
        return (WinNT.HRESULT)this._invokeNativeObject(IAccessibleVtbMapped.getAccRole ,
                new Object[]{
                        this.getPointer(),
                        varID,
                        pvarRole
                },
                WinNT.HRESULT.class);
    }

    public WinNT.HRESULT get_accLocationHRESULT(NativeLongByReference pxLeft,
                                            NativeLongByReference pyTop,
                                            NativeLongByReference pcxWidth,
                                            NativeLongByReference pcyHeight,
                                            Variant.VARIANT varID) {
        return (WinNT.HRESULT)this._invokeNativeObject(IAccessibleVtbMapped.getAccLocation ,
                new Object[]{
                        this.getPointer(),
                        pxLeft,
                        pyTop,
                        pcxWidth,
                        pcyHeight,
                        varID
                },
                WinNT.HRESULT.class);
    }

    private WinDef.HWND getHWNDFromIAccessible(IAccessible pAcc){
        PointerByReference ptr = new PointerByReference();
        WinNT.HRESULT res = Oleacc.INSTANCE.WindowFromAccessibleObject(pAcc.getPointer(), ptr);

        COMUtils.checkRC(res);

        return new WinDef.HWND(ptr.getValue());
    }
}

