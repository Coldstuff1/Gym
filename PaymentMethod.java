/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 22 "model.ump"
// line 46 "model.ump"
public class PaymentMethod
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PaymentMethod Attributes
  private String cardtype;
  private String cardnum;
  private String seccode;
  private String expdate;

  //PaymentMethod Associations
  private List<Member> members;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PaymentMethod(String aCardtype, String aCardnum, String aExpdate, String aSeccode)
  {
    cardtype = aCardtype;
    cardnum = aCardnum;
    expdate = aExpdate;
    seccode = aSeccode;
    members = new ArrayList<Member>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCardtype(String aCardtype)
  {
    boolean wasSet = false;
    cardtype = aCardtype;
    wasSet = true;
    return wasSet;
  }

  public boolean setCardnum(String aCardnum)
  {
    boolean wasSet = false;
    cardnum = aCardnum;
    wasSet = true;
    return wasSet;
  }

  public boolean setSeccode(String aSeccode)
  {
    boolean wasSet = false;
    seccode = aSeccode;
    wasSet = true;
    return wasSet;
  }

  public String getCardtype()
  {
    return cardtype;
  }

  public String getCardnum()
  {
    return cardnum;
  }

  public String getSeccode()
  {
    return seccode;
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
    if (aMember.indexOfPaymentMethod(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMember.addPaymentMethod(this);
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
    if (aMember.indexOfPaymentMethod(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMember.removePaymentMethod(this);
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
      aMember.removePaymentMethod(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "cardtype" + ":" + getCardtype()+ "," +
            "cardnum" + ":" + getCardnum()+ "," +
            "seccode" + ":" + getSeccode()+ "]";
  }

public String getExpdate() {
	return expdate;
}

public void setExpdate(String expdate) {
	this.expdate = expdate;
}
}