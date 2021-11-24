package com.occultusterra.jnabug;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class App {
    public static void main( String[] args ) {
    	// Replace with path to image
    	RayLibNative.INSTANCE.LoadImage("/home/wwelna/test.png");
    	
    	/* Pointer alloc test
    	String path = "/home/wwelna/test.png";
    	
    	Pointer t = RayLibNative.INSTANCE.MemAlloc(1024);
    	t.write(0, path.getBytes(), 0, path.length());

    	System.out.println(t.getString(0, "ASCII"));
    	Image ginger = RayLibNative.INSTANCE.LoadImage(t);
    	
    	RayLibNative.INSTANCE.MemFree(t);
    	*/
    }
}

interface RayLibNative extends Library {
	// replace with path to raylib binary
	RayLibNative INSTANCE = (RayLibNative)Native.load("/home/wwelna/raylib4/raylib-4.0.0_linux_amd64/lib/libraylib.so.4.0.0", RayLibNative.class);
	Image LoadImage(String fileName);
	Pointer MemAlloc(int size);
	void MemFree(Pointer ptr);
}
