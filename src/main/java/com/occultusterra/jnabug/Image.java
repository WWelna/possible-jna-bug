package com.occultusterra.jnabug;

import com.sun.jna.Structure;
import com.sun.jna.Pointer;

@Structure.FieldOrder({"data", "width", "height", "mipmaps", "format"})
public class Image extends Structure implements Structure.ByReference, Structure.ByValue {
	
	public Image() { super(); }
	public Image(Pointer peer) { super(peer); }
    
	public Pointer data;
	public int width;
	public int height;
	public int mipmaps;
	public int format;
}
