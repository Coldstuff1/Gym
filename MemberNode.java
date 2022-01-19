class MemberNode<Member>{

  Member element; //
  MemberNode<Member> left; //
  MemberNode<Member> right; //

  MemberNode(Member element) {
    this.element = element;
  }


  MemberNode<Member> findMax(){
    if(right == null)return this;
    else {
      return right.findMax();
    }
  }

  MemberNode<Member> findMin(){
    if (this.left == null) return this;
    else {
      return left.findMin();
    }
  }

  int height(){
    if(this.equals(null))return 0;

    else return height(this) - 1;
  }

 private int height(MemberNode<Member> v) {
   int h = 0;
   int hL = 0;
   int hR = 0;
   if(v.left != null) hL = height(v.left);
   if(v.right != null)hR = height(v.right);
   h = max(h, hL, hR);
    return 1 + h;

  }

 private int max(int a, int b, int c) {
   int max = a;
   if(b > max) max = b;
   if(c > max)max = c;
   return max;

 }

  int balance() {
    int subTreeR = 0;
    int subTreeL = 0;
    if(this.right == null)subTreeR = -1;
    else subTreeR = this.right.height();
    if(this.left == null)subTreeL = -1;
    else subTreeL = this.left.height();
    return subTreeL - subTreeR;
  }

}
