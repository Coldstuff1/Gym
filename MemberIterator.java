import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class MemberIterator<Member> implements Iterator<Member> {

  MemberTree cur;
  List<Member> list = new ArrayList<Member>();
  int pos = 0; //

  @SuppressWarnings("unchecked")
  MemberIterator(MemberTree cur) {
    this.cur = cur;
    inOrder((MemberNode<Member>) this.cur.root);
    pos = 0;

  }

  void inOrder(MemberNode<Member> root) {
      if(root.left != null)inOrder(root.left);
      list.add(pos++, root.element);
      if(root.right !=null)inOrder(root.right);
    }


    @Override
    public boolean hasNext() {
        if(list.size()>= pos + 1) {
          return true;
        }
      return false;
    }

    @Override
    public Member next() {
      Member element = list.get(pos);
      pos++;
        return element;
    }



}
