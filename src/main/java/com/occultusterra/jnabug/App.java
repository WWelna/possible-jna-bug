package com.occultusterra.jnabug;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {
    public static void main( String[] args ) {
    	// Replace with path to image
    	Image.ByValue i = RayLibNative.INSTANCE.LoadImage("/home/wwelna/test.png");
    	RayLibNative.INSTANCE.ExportImage(i, "/home/wwelna/test_exp.png");
    	RayLibNative.INSTANCE.ExportImageAsCode(i, "/home/wwelna/test_exp.h");
    }
}

interface RayLibNative extends Library {
	// replace with path to raylib binary
	RayLibNative INSTANCE = (RayLibNative)Native.load("/home/wwelna/raylib4/raylib-4.0.0_linux_amd64/lib/libraylib.so.4.0.0", RayLibNative.class);
	Image.ByValue LoadImage(String fileName);
	boolean ExportImage(Image.ByValue image, String fileName);
	boolean ExportImageAsCode(Image.ByValue image, String fileName);
}
