package level;

import pieces.*;
import engine.*;
import level.*;
import engine.*;
import userInterfaceController.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Level
{
   //Attributes
   private String levelName;
   int boardType;
   PolyminoList list;
   
   //Constructors
   
   public Level(String name, int boardType, File level) throws FileNotFoundException
   {
      levelName = name;
      this.boardType = boardType;
      Scanner sc = new Scanner (level);
      list = new PolyminoList(7);
      
      //iterate whole file until you find the part corresponds to levelName
      while (sc.hasNextLine())
      {
         String line = sc.nextLine();
         
         //pass empty lines
         while(line.equals(""))
            line = sc.nextLine();
         
         if(line.charAt(0) == '$')//$ indicates a new level in file
         {
            String nameOfCurrentLevel = line.substring(2); // take the part after "$ "
            
            if(nameOfCurrentLevel.equals(levelName))
            {
               while(sc.hasNextLine()) // we found level, now iterate
               {
                  boolean isMainNode = true;
                  String polyminoSpecs = sc.nextLine();
                  
                  while(polyminoSpecs.equals("")) //pass empty line
                     polyminoSpecs = sc.nextLine();
                  
                  if (polyminoSpecs.charAt(0) == '$')
                     break; // finished traversing level, now break
                  
                  String[] words = polyminoSpecs.split(" "); // split method splits a string into parts seperated by " ".
                  MyNode[] nodes = new MyNode[55]; // an array to keep nodes of that polymino, each line in file corresponds to a single polymino
                  int count = 1;// will be used to differentiate main node from relatives.
                  boolean isFixed = false;
                  
                  for( String word: words) // traverse words in polymino one by one
                  {
                     int color = 9999; // placeholder for color
                     
                     if(word.charAt(0) == '#') // if first char is #, then this word keeps color.
                     {
                        color = Integer.parseInt(word.substring(1,word.length()-1));
                     }
                     else // else, the word is a node for polymino
                     {
                        String[] elements = word.split(","); // split the word by comma, which gives positions of nodes.
                        int x = Integer.parseInt(elements[0]);
                        int y = Integer.parseInt(elements[1]);
                        int z = Integer.parseInt(elements[2]);
                        
                        if (isMainNode)
                        {
                           nodes[0] = new MyNode (x,y,z,color); // nodes[0] will represent main node
                           isMainNode = false;
                        }
                        else //else, this is a relative node.
                        {
                           nodes[count] = new MyNode (x,y,z,color);
                           count++;
                        }
                        
                     }
                  }
                  
                  // if x y and z is 0, then polymino is not fixed.
                  //if(nodes[0].getX() == -1 && nodes[0].getY() == -1 && nodes[0].getZ() == -1 )
                  //   isFixed = false;
                  //else 
                  //   isFixed = true;
                  // We add new polymino to list
                  list.addPolymino( new Polymino( count, nodes[0], Arrays.copyOfRange(nodes, 1, count), nodes[0].getColor() ));
                  
                  
               }
            }
         }
      }
   }
   
   public Level (PolyminoList list, String name, int boardType)
   {
      this.list = list;
      this.levelName = name;
      this.boardType = boardType;
   }
   
   // Methods
   
   int getSolution (int level)
   {
      //to do...
      return 0;
   }
   
   Level getSolution(Level level)
   {
      //to do...
      return null;
   }
   
   boolean setBoard(MyNode origin)
   {
      //to do...
      return true;
   }
}   
