package com.occultusterra.jnabug;

import com.sun.jna.Structure;
import com.sun.jna.Pointer;

@Structure.FieldOrder({"data", "width", "height", "mipmaps", "format"})
public class Image extends Structure {
	
	public static class ByReference extends Image implements Structure.ByReference {
		public ByReference() { super(); }
		public ByReference(Pointer memory) { super(memory); read(); }
	}

	public static class ByValue extends Image implements Structure.ByValue {
		public ByValue() { super(); }
		public ByValue(Pointer memory) { super(memory); read(); }
	}
	
	public Image() { super(); }
	public Image(Pointer peer) { super(peer); read(); }
    
	public Pointer data;
	public int width;
	public int height;
	public int mipmaps;
	public int format;
}
