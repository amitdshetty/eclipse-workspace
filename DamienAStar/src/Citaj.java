// Citaj.java - Citanje podataka standardnih tipova iz datoteke.

import  java.io.*;

public class Citaj {

  private InputStream ul;    // Datoteka iz koje se cita.
  private char c;            // Poslednji procitani znak.
  private boolean eof;       // Indikator kraja datoteke?

  public Citaj (String ime) throws FileNotFoundException  // Otvaranje
    { ul = new FileInputStream (ime); }                   //   datoteke.

  public boolean eofF () { return eof; }      // Da li je kraj datoteke?

  public char getChF () {    // Dohvatanje sledeceg znaka.
    try { int i = ul.read (); return c = (eof = i == -1) ? ' ' : (char)i; }
      catch (Exception g) { eof = true; return c = ' '; }
  }

  public char CharF () {     // Citanje jednog (ne belog) znaka.
    while (Character.isWhitespace (c = getChF ()));
    return !eof ? c : ' ';
  }

  public String StringF () { // Citanje jedne reci.
    String s = "";
    while ( Character.isWhitespace (c = getChF ()) && !eof);
    if (eof) return "";
    s += c;
    while (!Character.isWhitespace (c = getChF ()) && !eof) s += c;
    eof = false;
    return s;
  }

  public String LineF () {    // Citanje jednog reda teksta.
    String s="";
    while ((c = getChF ()) != '\n' && !eof) if (c != '\r') s += c;
    if (s.length () != 0) eof = false;
    return s;
  }

  public void getNLF ()      // Preskakanje znakova do kraja reda.
    { while (c!='\n' && !eof) c = getChF (); c = '\0'; }

  public byte   ByteF    ()  // Citanje jednog podatka tipa byte.
    { String s = StringF (); return !eof ? Byte.parseByte (s) : 0; }

  public short  ShortF   ()  // Citanje jednog podatka tipa short.
    { String s = StringF (); return !eof ? Short.parseShort (s) : 0; }

  public int    IntF     ()  // Citanje jednog podatka tipa int.
    { String s = StringF (); return !eof ? Integer.parseInt (s) : 0; }

  public long   LongF    ()  // Citanje jednog podatka tipa long.
    { String s = StringF (); return !eof ? Long.parseLong (s) : 0; }

  public float  FloatF   ()  // Citanje jednog podatka tipa float.
    { String s = StringF (); return !eof ? Float.parseFloat (s) : 0; }

  public double DoubleF  ()  // Citanje jednog podatka tipa double.
    { String s = StringF (); return !eof ? Double.parseDouble (s) : 0; }

//  public boolean BooleanF()  // Citanje jednog podatka tipa boolean.
//    { String s = StringF (); return !eof ? Boolean.parseBoolean (s) : false; }

  // PODRSKA ZA CITANJE SA GLAVNOG ULAZA.

  private Citaj () { ul = System.in; }      // Privatni konstruktor.

  private static Citaj gl = new Citaj ();   // Predstavnik glavnog ulaza.

  public static boolean eof    () { return gl.eofF    (); } // Varijante
  public static char    getCh  () { return gl.getChF  (); } //   metoda
  public static char    Char   () { return gl.CharF   (); } //   koje
  public static String  String () { return gl.StringF (); } //   citaju sa
  public static String  Line   () { return gl.LineF   (); } //   glavnog
  public static void    getNL  () {        gl.getNLF  (); } //   ulaza.
  public static byte    Byte   () { return gl.ByteF   (); }
  public static short   Short  () { return gl.ShortF  (); }
  public static int     Int    () { return gl.IntF    (); }
  public static long    Long   () { return gl.LongF   (); }
  public static float   Float  () { return gl.FloatF  (); }
  public static double  Double () { return gl.DoubleF (); }
//  public static boolean Boolean() { return gl.BooleanF(); }
}