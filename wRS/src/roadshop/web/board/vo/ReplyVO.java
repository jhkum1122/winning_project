package roadshop.web.board.vo;
//응답에 관계된 데이터들을 담을 클래스
public class ReplyVO {
	
	private int b_num;		//글의 고유번호임!!
	private int ref;		
	private int re_step;
	private int re_level;
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}