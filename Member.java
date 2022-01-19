/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 34 "model.ump"
public class Member
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Member Attributes
  private String name;
  private String gender;
  private static int currentMaxId;
  private int id;
  private int age;
  private double rate = 15;
  private boolean supermem;

  //Member Associations
  private List<PaymentMethod> paymentMethods;
  private List<Address> addresses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Member(String aName, int aAge, String aGender, boolean aSupermem)
  {
    name = aName;
    age = aAge;
    gender = aGender;
    supermem = aSupermem;
    paymentMethods = new ArrayList<PaymentMethod>();
    addresses = new ArrayList<Address>();
    currentMaxId++;
    id = currentMaxId-1;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setRate(double aRate)
  {
    boolean wasSet = false;
    rate = aRate;
    wasSet = true;
    return wasSet;
  }

  public boolean setSupermem(boolean aSupermem)
  {
    boolean wasSet = false;
    supermem = aSupermem;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public int getAge()
  {
    return age;
  }

  public double getRate()
  {
    return rate;
  }

  public boolean getSupermem()
  {
    return supermem;
  }
  /* Code from template association_GetMany */
  public PaymentMethod getPaymentMethod(int index)
  {
    PaymentMethod aPaymentMethod = paymentMethods.get(index);
    return aPaymentMethod;
  }

  public List<PaymentMethod> getPaymentMethods()
  {
    List<PaymentMethod> newPaymentMethods = Collections.unmodifiableList(paymentMethods);
    return newPaymentMethods;
  }

  public int numberOfPaymentMethods()
  {
    int number = paymentMethods.size();
    return number;
  }

  public boolean hasPaymentMethods()
  {
    boolean has = paymentMethods.size() > 0;
    return has;
  }

  public int indexOfPaymentMethod(PaymentMethod aPaymentMethod)
  {
    int index = paymentMethods.indexOf(aPaymentMethod);
    return index;
  }
  /* Code from template association_GetMany */
  public Address getAddress(int index)
  {
    Address aAddress = addresses.get(index);
    return aAddress;
  }

  public List<Address> getAddresses()
  {
    List<Address> newAddresses = Collections.unmodifiableList(addresses);
    return newAddresses;
  }

  public int numberOfAddresses()
  {
    int number = addresses.size();
    return number;
  }

  public boolean hasAddresses()
  {
    boolean has = addresses.size() > 0;
    return has;
  }

  public int indexOfAddress(Address aAddress)
  {
    int index = addresses.indexOf(aAddress);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPaymentMethods()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPaymentMethod(PaymentMethod aPaymentMethod)
  {
    boolean wasAdded = false;
    if (paymentMethods.contains(aPaymentMethod)) { return false; }
    paymentMethods.add(aPaymentMethod);
    if (aPaymentMethod.indexOfMember(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPaymentMethod.addMember(this);
      if (!wasAdded)
      {
        paymentMethods.remove(aPaymentMethod);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePaymentMethod(PaymentMethod aPaymentMethod)
  {
    boolean wasRemoved = false;
    if (!paymentMethods.contains(aPaymentMethod))
    {
      return wasRemoved;
    }

    int oldIndex = paymentMethods.indexOf(aPaymentMethod);
    paymentMethods.remove(oldIndex);
    if (aPaymentMethod.indexOfMember(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPaymentMethod.removeMember(this);
      if (!wasRemoved)
      {
        paymentMethods.add(oldIndex,aPaymentMethod);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaymentMethodAt(PaymentMethod aPaymentMethod, int index)
  {
    boolean wasAdded = false;
    if(addPaymentMethod(aPaymentMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaymentMethods()) { index = numberOfPaymentMethods() - 1; }
      paymentMethods.remove(aPaymentMethod);
      paymentMethods.add(index, aPaymentMethod);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaymentMethodAt(PaymentMethod aPaymentMethod, int index)
  {
    boolean wasAdded = false;
    if(paymentMethods.contains(aPaymentMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaymentMethods()) { index = numberOfPaymentMethods() - 1; }
      paymentMethods.remove(aPaymentMethod);
      paymentMethods.add(index, aPaymentMethod);
      wasAdded = true;
    }
    else
    {
      wasAdded = addPaymentMethodAt(aPaymentMethod, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAddresses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAddress(Address aAddress)
  {
    boolean wasAdded = false;
    if (addresses.contains(aAddress)) { return false; }
    addresses.add(aAddress);
    if (aAddress.indexOfMember(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAddress.addMember(this);
      if (!wasAdded)
      {
        addresses.remove(aAddress);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeAddress(Address aAddress)
  {
    boolean wasRemoved = false;
    if (!addresses.contains(aAddress))
    {
      return wasRemoved;
    }

    int oldIndex = addresses.indexOf(aAddress);
    addresses.remove(oldIndex);
    if (aAddress.indexOfMember(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAddress.removeMember(this);
      if (!wasRemoved)
      {
        addresses.add(oldIndex,aAddress);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAddressAt(Address aAddress, int index)
  {
    boolean wasAdded = false;
    if(addAddress(aAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAddresses()) { index = numberOfAddresses() - 1; }
      addresses.remove(aAddress);
      addresses.add(index, aAddress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAddressAt(Address aAddress, int index)
  {
    boolean wasAdded = false;
    if(addresses.contains(aAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAddresses()) { index = numberOfAddresses() - 1; }
      addresses.remove(aAddress);
      addresses.add(index, aAddress);
      wasAdded = true;
    }
    else
    {
      wasAdded = addAddressAt(aAddress, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<PaymentMethod> copyOfPaymentMethods = new ArrayList<PaymentMethod>(paymentMethods);
    paymentMethods.clear();
    for(PaymentMethod aPaymentMethod : copyOfPaymentMethods)
    {
      aPaymentMethod.removeMember(this);
    }
    ArrayList<Address> copyOfAddresses = new ArrayList<Address>(addresses);
    addresses.clear();
    for(Address aAddress : copyOfAddresses)
    {
      aAddress.removeMember(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ": " + getName()+ "," +
            "id" + ": " + getId()+ "," +
            "age" + ": " + getAge()+ "," +
            "rate" + ": " + getRate()+ "," +
            "supermem" + ": " + getSupermem()+ "]";
  }

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}
}
