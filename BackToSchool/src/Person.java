import processing.core.PApplet;
import processing.core.PImage;

/**
 * L.A.11.1
 *
 * The root of the Person hierarchy.  All persons have
 * a name and an age and a gender
 */

class Person
{
  private String myName ;   // name of the person
  private int myAge;        // person's age
  private String myGender;    // 'M' for male, 'F' for female
  private double x, y, width, height;

  // constructor
  public Person(String name, int age, String gender, double x, double y, double width, double height)
  {
    myName = name;
    myAge = age;
    myGender = gender;
    this.x = x;
    this.y = y;
    this.width = width; 
    this.height = height;
  }
  
  public void draw(PApplet drawer, PImage img) 
  {
	  drawer.image(img, (float) x, (float) y, (float) width, (float) height);
  }

  public String getName()
  {
    return myName;
  }

  public int getAge()
  {
    return myAge;
  }

  public String getGender()
  {
    return myGender;
  }

  public void setName(String name)
  {
    myName = name;
  }

  public void setAge(int age)
  {
    myAge = age;
  }

  public void setGender(String gender)
  {
    myGender = gender;
  }

  public String toString()
  {
    return myName + ", age: " + myAge + ", gender: " + myGender;
  }
}