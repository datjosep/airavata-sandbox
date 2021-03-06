/*
*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*
*/
package org.apache.airavata.datacat.parsers.gridchem.mfinalcoord;


import java_cup.runtime.lr_parser;
import org.apache.airavata.datacat.parsers.gridchem.GridChemQueueParser;

import javax.swing.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MFinalCoordParser extends java_cup.runtime.lr_parser implements GridChemQueueParser {

  /** Default constructor. */
  public MFinalCoordParser() {super();}

  /** Constructor which sets the default scanner. */
  public MFinalCoordParser(java_cup.runtime.Scanner s) {super(s);}

    /**
     * Constructor which uses a file reader.
     */
    public MFinalCoordParser(final FileReader fileReader) {
        super(new MFinalCoordLexer(fileReader));
    }


    /** Production table. */
  protected static final short _production_table[][] = 
    lr_parser.unpackFromStrings(new String[]{
            "\000\016\000\002\003\005\000\002\002\004\000\002\004" +
                    "\003\000\002\005\004\000\002\005\003\000\002\006\006" +
                    "\000\002\017\004\000\002\017\003\000\002\020\010\000" +
                    "\002\012\003\000\002\013\003\000\002\014\003\000\002" +
                    "\015\003\000\002\016\003"});

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    lr_parser.unpackFromStrings(new String[]{
            "\000\032\000\004\005\005\001\002\000\004\004\010\001" +
                    "\002\000\004\004\uffff\001\002\000\004\002\007\001\002" +
                    "\000\004\002\000\001\002\000\004\007\015\001\002\000" +
                    "\006\004\010\006\013\001\002\000\006\004\ufffd\006\ufffd" +
                    "\001\002\000\004\002\001\001\002\000\006\004\ufffe\006" +
                    "\ufffe\001\002\000\004\011\016\001\002\000\004\012\ufff8" +
                    "\001\002\000\004\012\025\001\002\000\006\010\ufffa\011" +
                    "\ufffa\001\002\000\006\010\022\011\016\001\002\000\006" +
                    "\004\ufffc\006\ufffc\001\002\000\006\010\ufffb\011\ufffb\001" +
                    "\002\000\004\013\026\001\002\000\004\013\ufff7\001\002" +
                    "\000\004\016\027\001\002\000\004\017\ufff6\001\002\000" +
                    "\004\017\031\001\002\000\004\020\ufff5\001\002\000\004" +
                    "\020\033\001\002\000\006\010\ufff4\011\ufff4\001\002\000" +
                    "\006\010\ufff9\011\ufff9\001\002"});

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    lr_parser.unpackFromStrings(new String[]{
            "\000\032\000\006\003\005\004\003\001\001\000\006\005" +
                    "\010\006\011\001\001\000\002\001\001\000\002\001\001" +
                    "\000\002\001\001\000\002\001\001\000\004\006\013\001" +
                    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
                    "\000\010\012\016\017\020\020\017\001\001\000\002\001" +
                    "\001\000\004\013\023\001\001\000\002\001\001\000\006" +
                    "\012\016\020\022\001\001\000\002\001\001\000\002\001" +
                    "\001\000\002\001\001\000\002\001\001\000\004\014\027" +
                    "\001\001\000\002\001\001\000\004\015\031\001\001\000" +
                    "\002\001\001\000\004\016\033\001\001\000\002\001\001" +
                    "\000\002\001\001"});

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

    //Each string is of the format
    //center# atomic# x_coord y_coord z_coord
    private ArrayList<String> result = new ArrayList<String>();
    private String tempStr = "";



    public ArrayList<String> getResult() {
        return result;
    }

    public void addToResult(String value) {
        result.add(value);
    }

    public String getTempStr() {
        return tempStr;
    }

    public void setTempStr(String s) {
        this.tempStr = s;
    }

    /*Adding the parsed data to the hash map */
    @Override
    public HashMap<String, String> getParsedData() throws Exception {
        parse();
        HashMap<String,String> results= new HashMap<String,String>();
        int zCount=0;
        int xCount=0;
        int yCount=0;
        int center=0;
        int atom=0;
        for(int i=0;i<result.size();i++) {
            String singleString = result.get(i);
            String[] temp = singleString.split(" ");
            if (temp.length > 1) {
                String keyElement = temp[0];
                String dataElement = temp[1];
                if (keyElement.equals("Z")) {
                    results.put("FinalCoordParser_Z_coord_" + zCount, dataElement);
                    zCount++;
                } else if (keyElement.equals("Y")) {
                    results.put("FinalCoordParser_Y_coord_" + yCount, dataElement);
                    yCount++;
                } else if (keyElement.equals("X")) {
                    results.put("FinalCoordParser_X_coord_" + xCount, dataElement);
                    xCount++;
                } else if (keyElement.equals("Atom")) {
                    results.put("FinalCoordParser_AtomicNumber_" + atom, dataElement);
                    atom++;
                } else if (keyElement.equals("center")) {
                    results.put("FinalCoordParser_CenterNumber_" + center, dataElement);
                    center++;
                }
            }
        }
return results;


        }

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {

 
  //__________________________________
  public static boolean DEBUG = true;
  private static JTable table;               
  private static final String tableLabel = "SCF Intermediate Results:";
// private static String cycle = "0";
 
  
  public static JTable getTable() {
    return table;
  }

  public static String getTableLabel() {
    return tableLabel;
  }

//   }

  private final MFinalCoordParser MFinalCoordParser;

  /** Constructor */
  CUP$parser$actions(MFinalCoordParser MFinalCoordParser) {
    this.MFinalCoordParser = MFinalCoordParser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // inp7 ::= INPUT7 
            {
              Object RESULT = null;
		int in7left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int in7right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Float in7 = (Float)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //___________________________________________________________________
   if (DEBUG) System.out.println("CUP:Input:  z coordinate "+in7);
                MFinalCoordParser.addToResult("Z "+in7);
 
              CUP$parser$result = new java_cup.runtime.Symbol(12/*inp7*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // inp6 ::= INPUT6 
            {
              Object RESULT = null;
		int in6left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int in6right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Float in6 = (Float)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //___________________________________________________________________
   if (DEBUG) System.out.println("CUP:Input:  y coordinate "+in6);
                MFinalCoordParser.addToResult("Y "+in6);
 
              CUP$parser$result = new java_cup.runtime.Symbol(11/*inp6*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // inp5 ::= INPUT5 
            {
              Object RESULT = null;
		int in5left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int in5right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Float in5 = (Float)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //___________________________________________________________________
   if (DEBUG) System.out.println("CUP:Input:  x coordinate "+in5);
                MFinalCoordParser.addToResult("X "+in5);
 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*inp5*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // inp3 ::= INPUT3 
            {
              Object RESULT = null;
		int in3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int in3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Integer in3 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //___________________________________________________________________
   if (DEBUG) System.out.println("CUP:Input:  atomic number "+in3);
                MFinalCoordParser.addToResult("Atom "+in3);
 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*inp3*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // inp2 ::= INPUT2 
            {
              Object RESULT = null;
		int in2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int in2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Integer in2 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //___________________________________________________________________
   if (DEBUG) System.out.println("CUP:Input:  center number "+in2);
                MFinalCoordParser.addToResult("center "+in2);
 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*inp2*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // cycle2 ::= inp2 inp3 INPUT4 inp5 inp6 inp7 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(14/*cycle2*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // cycle1 ::= cycle2 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*cycle1*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // cycle1 ::= cycle1 cycle2 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*cycle1*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // scfcycle ::= INPUT1 DASH1 cycle1 DASH2 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(4/*scfcycle*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // scfpat ::= scfcycle 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(3/*scfpat*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // scfpat ::= scfpat scfcycle 
            {
              Object RESULT = null;
		 if (DEBUG) System.out.println("CUP:Input: in scfpat"); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*scfpat*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // scfintro ::= FOUNDITER 
            {
              Object RESULT = null;
		 if (DEBUG) System.out.println("CUP:Input:  found the start of Iteration"); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*scfintro*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= startpt EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // startpt ::= scfintro scfpat SCFDONE 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(1/*startpt*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

