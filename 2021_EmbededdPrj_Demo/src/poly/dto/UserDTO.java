package poly.dto;

/**
 * @author  최별규
 * @version 1.1 유저로그인 DTO 업데이트 할 때마다 0.1씩 증가 
 */
public class UserDTO { //  클래스 이름이 mapper.xml의 resulttype 임
	
	// private Logger log = Logger.getLogger(this.getClass()); // DTO에 에러 있나 확인용
	
	private String id; // 아이디
	private String pwd; // 비번
	private String name; // 이름
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
