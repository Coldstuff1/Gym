/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 12 "model.ump"
// line 40 "model.ump"
public class Address
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Address Attributes
  private String street;
  private String city;
  private String province;
  private String country;
  private String postalcode;

  //Address Associations
  private List<Member> members;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Address(String aStreet, String aCity, String aProvince, String aCountry, String aPostalcode)
  {
    street = aStreet;
    city = aCity;
    province = aProvince;
    country = aCountry;
    postalcode = aPostalcode;
    members = new ArrayList<Member>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setProvince(String aProvince)
  {
    boolean wasSet = false;
    province = aProvince;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalcode(String aPostalcode)
  {
    boolean wasSet = false;
    postalcode = aPostalcode;
    wasSet = true;
    return wasSet;
  }

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getProvince()
  {
    return province;
  }

  public String getCountry()
  {
    return country;
  }

  public String getPostalcode()
  {
    return postalcode;
  }
  /* Code from template association_GetMany */
  public Member getMember(int index)
  {
    Member aMember = members.get(index);
    return aMember;
  }

  public List<Member> getMembers()
  {
    List<Member> newMembers = Collections.unmodifiableList(members);
    return newMembers;
  }

  public int numberOfMembers()
  {
    int number = members.size();
    return number;
  }

  public boolean hasMembers()
  {
    boolean has = members.size() > 0;
    return has;
  }

  public int indexOfMember(Member aMember)
  {
    int index = members.indexOf(aMember);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMembers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addMember(Member aMember)
  {
    boolean wasAdded = false;
    if (members.contains(aMember)) { return false; }
    members.add(aMember);
    if (aMember.indexOfAddress(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMember.addAddress(this);
      if (!wasAdded)
      {
        members.remove(aMember);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeMember(Member aMember)
  {
    boolean wasRemoved = false;
    if (!members.contains(aMember))
    {
      return wasRemoved;
    }

    int oldIndex = members.indexOf(aMember);
    members.remove(oldIndex);
    if (aMember.indexOfAddress(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMember.removeAddress(this);
      if (!wasRemoved)
      {
        members.add(oldIndex,aMember);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMemberAt(Member aMember, int index)
  {  
    boolean wasAdded = false;
    if(addMember(aMember))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMembers()) { index = numberOfMembers() - 1; }
      members.remove(aMember);
      members.add(index, aMember);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMemberAt(Member aMember, int index)
  {
    boolean wasAdded = false;
    if(members.contains(aMember))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMembers()) { index = numberOfMembers() - 1; }
      members.remove(aMember);
      members.add(index, aMember);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMemberAt(aMember, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Member> copyOfMembers = new ArrayList<Member>(members);
    members.clear();
    for(Member aMember : copyOfMembers)
    {
      aMember.removeAddress(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "street" + ":" + getStreet()+ "," +
            "city" + ":" + getCity()+ "," +
            "province" + ":" + getProvince()+ "," +
            "country" + ":" + getCountry()+ "," +
            "postalcode" + ":" + getPostalcode()+ "]";
  }
}