import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.COMInvoker;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;


public class IServiceProvider extends COMInvoker {
    public IServiceProvider() {
    }

    public IServiceProvider(Pointer pvInstance) {
        this.setPointer(pvInstance);
    }

    public WinNT.HRESULT QueryInterface(Guid.REFIID var1, PointerByReference var2) {
        return (WinNT.HRESULT)this._invokeNativeObject(0, new Object[]{this.getPointer(), var1,var2}, WinNT.HRESULT.class);

    }

    public int AddRef() {
        return (int) this._invokeNativeObject(1, new Object[]{this.getPointer()}, WinNT.HRESULT.class);
    }

    public int Release() {
        return (int) this._invokeNativeObject(2, new Object[]{this.getPointer()}, WinNT.HRESULT.class);
    }

    public WinNT.HRESULT QueryService(Pointer var1, Pointer var2, PointerByReference var3) {
        return (WinNT.HRESULT)this._invokeNativeObject(3, new Object[]{this.getPointer(), var1, var2,var3}, WinNT.HRESULT.class);
    }
}
