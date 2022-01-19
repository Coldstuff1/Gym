
public class MemberGate {
	
	private boolean locked = true;
	public MemberGate(boolean locked) {
		this.setLocked(locked);
	}
	

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}
