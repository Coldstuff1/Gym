import java.util.Iterator;
import java.util.HashMap;
public class MemberTree implements Iterable<Member> {


  MemberNode<Member> root;

  private static int pos = 0;

  HashMap<String, Integer> nameSearch = new HashMap<String, Integer>();


  public void insert(Member member){
	  root = insert(root, member);
	  nameSearch.put(member.getName(), member.getId());
  }

  private MemberNode<Member> insert(MemberNode<Member> root, Member member) {
    if(member == null)return null;
    if(root == null) {
      root = new MemberNode<Member>(member);
      }
      if(root.element.getId() > member.getId())root.left = insert(root.left, member);
      else if(root.element.getId() < member.getId())root.right = insert(root.right, member);
      else return root;
      return applyRotation(root);

    }

  private MemberNode<Member> rotateLeft(MemberNode<Member> root) {
    MemberNode<Member> rightNode = root.right;
    MemberNode<Member> centerNode = rightNode.left;
    rightNode.left = root;
    root.right = centerNode;
    return rightNode;
  }

  private MemberNode<Member> rotateRight(MemberNode<Member> root) {
	  MemberNode<Member> leftNode = root.left;
	  MemberNode<Member> centerNode = leftNode.right;
	  leftNode.right = root;
	  root.left = centerNode;
	  return leftNode;
  }

  private MemberNode<Member> applyRotation(MemberNode<Member> root) {
    if(root.balance() > 1) {
      if(root.left.balance() < 0) {
        root.left = rotateLeft(root.left);
      }
      return rotateRight(root);
    }
    if(root.balance() < -1) {
      if(root.right.balance() > 0) {
        root.right = rotateRight(root.right);

      }
      return rotateLeft(root);
    }
    return root;
    }


  public void remove(Member member){
	 root = remove(root, member);
  }

  public Member findName(String name) {
	  MemberNode<Member> root = find(this.root, nameSearch.get(name));
	  if(root == null)return null;
	  return root.element;

  }

  public Member findId(int id){
	  MemberNode<Member> root = find(this.root, id);
	  if(root == null)return null;
	  return root.element;

  }


  private MemberNode<Member> find(MemberNode<Member> root, int id) {
  	if(root == null)return null;
  	else if(id == root.element.getId())return root;
  	else if(root.element.getId() > id)return find(root.left, id);
  	else return find(root.right, id);
  }





  private MemberNode<Member> remove(MemberNode<Member> root, Member member) {
    if(root == null || member == null) return null;
    else if(root.element.getId() > member.getId())root.left = remove(root.left, member);
    else if(root.element.getId() < member.getId())root.right = remove(root.right, member);
    else {
      if(root.left == null)root = root.right;
      else if(root.right == null)root = root.left;
      else root.element = root.right.findMax().element;
      return root;
    }
    return applyRotation(root);

  }

  @Override
  public Iterator<Member> iterator() {
    return new MemberIterator<Member>(this);


  }

}
