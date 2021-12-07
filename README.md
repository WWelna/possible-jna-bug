# Possible JNA Bug
That's about it...

## Solved

I submitted a message to the JNA User's Group [Here](https://groups.google.com/g/jna-users/c/uRkxF-svyoE) in hopes of resolving this. So. this is what I did wrong.

This was not the proper way to implement support for ByValue and a C Pointer. The _implements Structure.ByValue, Structure.ByReference_ needed to be removed.
```Java
public class Image extends Structure implements Structure.ByValue, Structure.ByReference {
```

Instead, it needed to be implimented by these two inner Classes.
```Java
	public static class ByReference extends Image implements Structure.ByReference {
		public ByReference() { super(); }
		public ByReference(Pointer memory) { super(memory); read(); }
	}

	public static class ByValue extends Image implements Structure.ByValue {
		public ByValue() { super(); }
		public ByValue(Pointer memory) { super(memory); read(); }
	}
```

The Wrapper needed to be changed from this
```Java
	Image LoadImage(String fileName);
	boolean ExportImage(Image image, String fileName);
```

To This, to support the passing and return ByValue
```Java
	Image.ByValue LoadImage(String fileName);
	boolean ExportImage(Image.ByValue image, String fileName);
```

### Updated Notes
* _read()_ in the constructor is critical, as it instructs the Structure class to read the data pointed to by _Pointer memory_. Without this, calls such as _RayLibNative.INSTANCE.ImageDrawText(new Image.ByReference(i.getPointer()), "Hello World", 0, 0, 20, RayLibNative.Colors.GREEN);_ will not work, as it is not updated nor passed properly as a pointer.
