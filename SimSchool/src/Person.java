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

  // constructor
  public Person(String name, int age, String gender)
  {
    myName = name;
    myAge = age;
    myGender = gender;
  }
  
  public void draw(PApplet drawer, PImage img, double x, double y, double width, double height) 
  {
	  drawer.image(img, (float) x, (float) y, (float) width, (float) height);
  }
  
  public void draw(PApplet drawer, double x, double y, double width, double height) {
	  PImage img = drawer.loadImage("Person.png");
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