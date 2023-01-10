interface TV { // 이미 작성된 클래스명과 겹치면 안됨!
	void viewTv();
}
interface Camera {
	public abstract void takePhoto();
}
interface Music {
	void playMusic();
}


class Shape2 {
	private int size;
	private String color;
	
	public Shape2(int size, String color) {
		this.size = size;
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	public String getColor() {
		return color;
	}
	
	
} // Shape2

class Phone extends Shape2 implements TV, Camera, Music {
	
	public Phone(int size, String color) {
		super(size, color);
	}
	
	@Override // 어노테이션
	public void viewTv() {
		System.out.println("TV를 본다.");
	}
	public void takePhoto() {
		System.out.println("사진을 찍는다.");
	}
	public void playMusic() {
		System.out.println("음악을 듣는다.");
	}
	
} // Phone


public class Ex06_15_interface {

	public static void main(String[] args) {
		
		Phone p = new Phone(7, "blue");
		
		System.out.println("size:" + p.getSize());
		System.out.println("color:" + p.getColor());
		p.viewTv(); // TV를 본다.
		p.takePhoto(); // 사진을 찍는다.
		p.playMusic(); // 음악을 듣는다.
		
	}

}

